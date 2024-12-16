package net.zlt.create_modular_tools.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.kinetics.belt.transport.TransportedItemStack;
import com.simibubi.create.content.kinetics.press.MechanicalPressBlockEntity;
import com.simibubi.create.content.kinetics.press.PressingBehaviour;
import com.simibubi.create.content.processing.basin.BasinOperatingBlockEntity;
import com.simibubi.create.foundation.utility.VecHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Container;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.zlt.create_modular_tools.AllTagNames;
import net.zlt.create_modular_tools.block.mold.MoldUtils;
import net.zlt.create_modular_tools.recipe.AllRecipeTypes;
import net.zlt.create_modular_tools.recipe.MoldPressingRecipe;
import net.zlt.create_modular_tools.tool.ToolUtils;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mixin(MechanicalPressBlockEntity.class)
public abstract class MechanicalPressBlockEntityMixin extends BasinOperatingBlockEntity implements PressingBehaviour.PressingBehaviourSpecifics {
    @Shadow
    @Final
    private static Container pressingInv;

    @Shadow
    public PressingBehaviour pressingBehaviour;

    @Shadow
    public abstract void onItemPressed(ItemStack result);

    private MechanicalPressBlockEntityMixin(BlockEntityType<?> typeIn, BlockPos pos, BlockState state) {
        super(typeIn, pos, state);
    }

    @Inject(method = "tryProcessInWorld", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/content/kinetics/press/MechanicalPressBlockEntity;getRecipe(Lnet/minecraft/world/item/ItemStack;)Ljava/util/Optional;"), cancellable = true)
    private void createModularTools$tryPressMoldInWorld(ItemEntity itemEntity, boolean simulate, CallbackInfoReturnable<Boolean> cir, @Local ItemStack item) {
        Optional<MoldPressingRecipe> recipe = getMoldPressingRecipe(item);
        if (recipe.isEmpty()) {
            return;
        }
        if (simulate) {
            cir.setReturnValue(true);
            return;
        }

        if (!MoldUtils.isMoldSolid(itemEntity.getItem())) {
            cir.setReturnValue(false);
            return;
        }

        ItemStack remainder = itemEntity.getItem().copy();
        if (remainder.isEmpty()) {
            itemEntity.discard();
        } else {
            CompoundTag remainderNbt = remainder.getTag();
            remainderNbt.putUUID(AllTagNames.ITEM_STACK_UNIQUE_ID, UUID.randomUUID());
            CompoundTag remainderToolModulesNbt = ToolUtils.getToolModulesNbt(remainderNbt);
            for (String toolModuleTypeTag : remainderToolModulesNbt.getAllKeys()) {
                CompoundTag remainderToolModuleNbt = new CompoundTag();
                remainderToolModuleNbt.putString(AllTagNames.MOLD_SLOT_STATE, ToolUtils.MoldSlotState.EMPTY.toString());
                remainderToolModulesNbt.put(toolModuleTypeTag, remainderToolModuleNbt);
            }
            itemEntity.setItem(remainder);
        }

        ItemStack result = recipe.get().assemble(item, level.registryAccess());
        pressingBehaviour.particleItems.add(item);

        ItemEntity created = new ItemEntity(level, itemEntity.getX(), itemEntity.getY(), itemEntity.getZ(), result);
        if (item.getCount() == 1) {
            created.setDeltaMovement(itemEntity.getDeltaMovement());
        } else {
            created.setDefaultPickUpDelay();
            created.setDeltaMovement(VecHelper.offsetRandomly(Vec3.ZERO, level.random, 0.05f));
        }
        level.addFreshEntity(created);

        if (!result.isEmpty()) {
            onItemPressed(result);
        }
        cir.setReturnValue(true);
    }

    @Inject(method = "tryProcessOnBelt", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/content/kinetics/press/MechanicalPressBlockEntity;getRecipe(Lnet/minecraft/world/item/ItemStack;)Ljava/util/Optional;"), cancellable = true)
    private void createModularTools$tryPressMoldOnBelt(TransportedItemStack input, List<ItemStack> outputList, boolean simulate, CallbackInfoReturnable<Boolean> cir) {
        Optional<MoldPressingRecipe> recipe = getMoldPressingRecipe(input.stack);
        if (recipe.isEmpty()) {
            return;
        }
        if (simulate) {
            cir.setReturnValue(true);
            return;
        }

        if (!MoldUtils.isMoldSolid(input.stack)) {
            cir.setReturnValue(false);
            return;
        }

        pressingBehaviour.particleItems.add(input.stack);
        ItemStack created = recipe.get().assemble(pressingInv, level.registryAccess());

        if (!created.isEmpty()) {
            onItemPressed(created);
        }

        ItemStack remainder = input.stack.copy();
        CompoundTag remainderNbt = remainder.getTag();
        remainderNbt.putUUID(AllTagNames.ITEM_STACK_UNIQUE_ID, UUID.randomUUID());
        CompoundTag remainderToolModulesNbt = ToolUtils.getToolModulesNbt(remainderNbt);
        for (String toolModuleTypeTag : remainderToolModulesNbt.getAllKeys()) {
            CompoundTag remainderToolModuleNbt = new CompoundTag();
            remainderToolModuleNbt.putString(AllTagNames.MOLD_SLOT_STATE, ToolUtils.MoldSlotState.EMPTY.toString());
            remainderToolModulesNbt.put(toolModuleTypeTag, remainderToolModuleNbt);
        }

        outputList.add(remainder);
        outputList.add(created);

        cir.setReturnValue(true);
    }

    @Unique
    private Optional<MoldPressingRecipe> getMoldPressingRecipe(ItemStack item) {
        pressingInv.setItem(0, item);
        return AllRecipeTypes.MOLD_PRESSING.find(pressingInv, level);
    }
}
