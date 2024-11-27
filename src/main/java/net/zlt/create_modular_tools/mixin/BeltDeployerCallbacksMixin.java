package net.zlt.create_modular_tools.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.kinetics.belt.behaviour.TransportedItemStackHandlerBehaviour;
import com.simibubi.create.content.kinetics.belt.transport.TransportedItemStack;
import com.simibubi.create.content.kinetics.deployer.BeltDeployerCallbacks;
import com.simibubi.create.content.kinetics.deployer.DeployerBlockEntity;
import com.simibubi.create.foundation.utility.VecHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.zlt.create_modular_tools.block.entity.mold.SandMoldBlockEntity;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.item.tool.module.ToolModuleItem;
import net.zlt.create_modular_tools.recipe.ToolModuleDeployingRecipe;
import net.zlt.create_modular_tools.tool.module.ToolModuleRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.UUID;

@Mixin(BeltDeployerCallbacks.class)
public abstract class BeltDeployerCallbacksMixin {
    @Unique
    private static DeployerBlockEntity blockEntity;

    @Inject(method = "activate", at = @At("HEAD"))
    private static void createModularTools$grabBlockEntity(TransportedItemStack transported, TransportedItemStackHandlerBehaviour handler, DeployerBlockEntity blockEntity, Recipe<?> recipe, CallbackInfo ci) {
        BeltDeployerCallbacksMixin.blockEntity = blockEntity;
    }

    @Inject(method = "activate", at = @At("TAIL"))
    private static void createModularTools$clearBlockEntity(TransportedItemStack transported, TransportedItemStackHandlerBehaviour handler, DeployerBlockEntity blockEntity, Recipe<?> recipe, CallbackInfo ci) {
        BeltDeployerCallbacksMixin.blockEntity = null;
    }

    @ModifyVariable(method = "activate", at = @At(value = "STORE", ordinal = 0), name = "keepHeld")
    private static boolean createModularTools$setKeepHeldToolModule(boolean original, @Local(argsOnly = true) Recipe<?> recipe) {
        return original || recipe instanceof ToolModuleDeployingRecipe toolModuleDeployingRecipe && toolModuleDeployingRecipe.shouldKeepHeldItem();
    }

    @Inject(method = "lambda$activate$0", at = @At("RETURN"))
    private static void createModularTools$deployToolModule(TransportedItemStack transported, ItemStack stack, CallbackInfoReturnable<TransportedItemStack> cir, @Local(ordinal = 1) TransportedItemStack copy) {
        if (blockEntity == null || !(transported.stack.getItem() instanceof ModularToolItem)) {
            return;
        }

        ItemStack heldStack = blockEntity.getPlayer().getMainHandItem();
        if (!(heldStack.getItem() instanceof ToolModuleItem toolModule)) {
            return;
        }

        CompoundTag transportedNbt = transported.stack.getTag();
        if (transportedNbt == null) {
            return;
        }

        CompoundTag resultNbt = transportedNbt.copy();
        boolean hasToolModulesNbt = resultNbt.contains(SandMoldBlockEntity.TOOL_MODULES_TAG, Tag.TAG_COMPOUND);
        CompoundTag toolModulesNbt = resultNbt.getCompound(SandMoldBlockEntity.TOOL_MODULES_TAG);
        Level level = blockEntity.getLevel();
        if (level != null) {
            CompoundTag previousToolModuleNbt = toolModulesNbt.getCompound(toolModule.getType().getTag());
            String previousToolModuleId = previousToolModuleNbt.getString("id");
            ToolModuleItem previousToolModule = ToolModuleRegistry.get(previousToolModuleId);
            if (previousToolModule != null) {
                Vec3 pos = blockEntity.getPlayer().position();
                ItemStack previousToolModuleStack = new ItemStack(previousToolModule);
                if (toolModulesNbt.contains("tag", Tag.TAG_COMPOUND)) {
                    previousToolModuleStack.setTag(toolModulesNbt.getCompound("tag").copy());
                }
                ItemEntity previousToolModuleEntity = new ItemEntity(level, pos.x, pos.y, pos.z, previousToolModuleStack);
                previousToolModuleEntity.setDeltaMovement(VecHelper.offsetRandomly(Vec3.ZERO, level.random, 0.05f));
                level.addFreshEntity(previousToolModuleEntity);
            }
        }
        CompoundTag toolModuleNbt = new CompoundTag();
        toolModuleNbt.putString("id", toolModule.getId());
        CompoundTag heldStackNbt = heldStack.getTag();
        if (heldStackNbt != null) {
            toolModuleNbt.put("tag", heldStackNbt.copy());
        }
        toolModulesNbt.put(toolModule.getType().getTag(), toolModuleNbt);
        if (!hasToolModulesNbt) {
            resultNbt.put(SandMoldBlockEntity.TOOL_MODULES_TAG, toolModulesNbt);
        }
        resultNbt.putUUID("UUID", UUID.randomUUID());
        copy.stack.setTag(resultNbt);
    }
}
