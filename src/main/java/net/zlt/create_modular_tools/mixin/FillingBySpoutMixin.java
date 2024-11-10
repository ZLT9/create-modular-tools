package net.zlt.create_modular_tools.mixin;

import com.simibubi.create.content.fluids.spout.FillingBySpout;
import io.github.fabricators_of_create.porting_lib.fluids.FluidStack;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Container;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.zlt.create_modular_tools.block.mold.BaseSandMoldBlock;
import net.zlt.create_modular_tools.item.mold.BaseSandMoldItem;
import net.zlt.create_modular_tools.recipe.AllRecipeTypes;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;
import net.zlt.create_modular_tools.tool.module.ToolModuleTypeRegistry;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.UUID;

@Mixin(FillingBySpout.class)
public abstract class FillingBySpoutMixin {
    @Shadow
    @Final
    private static Container WRAPPER;

    @Inject(method = "canItemBeFilled", at = @At(value = "RETURN", ordinal = 2), cancellable = true)
    private static void createModularTools$canItemBeFilled(Level world, ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (!(stack.getItem() instanceof BaseSandMoldItem) || AllRecipeTypes.MOLD_FILLING.find(WRAPPER, world).isEmpty()) {
            return;
        }

        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(stack.getTag());
        if (toolModulesNbt.isEmpty()) {
            cir.setReturnValue(false);
            return;
        }

        boolean hasEmptySlots = false;
        for (String toolModuleTypeTag : toolModulesNbt.getAllKeys()) {
            ToolUtils.MoldSlot moldSlot = ToolUtils.getMoldSlot(toolModulesNbt, toolModuleTypeTag);
            if (moldSlot.state() == ToolUtils.MoldSlotState.EMPTY) {
                hasEmptySlots = true;
            } else if (moldSlot.state() == ToolUtils.MoldSlotState.FLUID) {
                cir.setReturnValue(false);
                return;
            }
        }
        cir.setReturnValue(hasEmptySlots);
    }

    @Inject(method = "getRequiredAmountForItem", at = @At(value = "RETURN", ordinal = 2), cancellable = true)
    private static void createModularTools$getRequiredAmountForItem(Level world, ItemStack stack, FluidStack availableFluid, CallbackInfoReturnable<Long> cir) {
        Item item = stack.getItem();
        if (!(item instanceof BaseSandMoldItem moldItem)) {
            return;
        }

        Block block = moldItem.getBlock();
        if (!(block instanceof BaseSandMoldBlock moldBlock)) {
            return;
        }

        if (!BaseSandMoldItem.canBeFilledWith(availableFluid.getFluid())) {
            cir.setReturnValue(-1L);
            return;
        }

        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(stack.getTag());
        if (toolModulesNbt.isEmpty()) {
            cir.setReturnValue(-1L);
            return;
        }

        long requiredMoltenMetalAmount = 0L;
        for (String key : toolModulesNbt.getAllKeys()) {
            ToolModuleType toolModuleType = ToolModuleTypeRegistry.get(key);
            if (toolModuleType == null || !moldBlock.isCompatible(toolModuleType)) {
                continue;
            }

            CompoundTag slotNbt = toolModulesNbt.getCompound(key);
            ToolUtils.MoldSlotState slotState = ToolUtils.MoldSlotState.fromName(slotNbt.getString("state"));

            if (slotState == ToolUtils.MoldSlotState.EMPTY) {
                requiredMoltenMetalAmount += toolModuleType.getRequiredMoltenMetalAmount();
            }
        }
        cir.setReturnValue(requiredMoltenMetalAmount);
    }

    @Inject(method = "fillItem", at = @At(value = "RETURN", ordinal = 1), cancellable = true)
    private static void createModularTools$fillItem(Level world, long requiredAmount, ItemStack stack, FluidStack availableFluid, CallbackInfoReturnable<ItemStack> cir) {
        Item item = stack.getItem();
        if (!(item instanceof BaseSandMoldItem moldItem)) {
            return;
        }

        Block block = moldItem.getBlock();
        if (!(block instanceof BaseSandMoldBlock moldBlock)) {
            return;
        }

        Fluid fluid = availableFluid.getFluid();
        if (!BaseSandMoldItem.canBeFilledWith(fluid)) {
            cir.setReturnValue(ItemStack.EMPTY);
            return;
        }

        ItemStack result = stack.copy();

        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(result.getTag());
        if (toolModulesNbt.isEmpty()) {
            cir.setReturnValue(ItemStack.EMPTY);
            return;
        }

        String fluidId = BuiltInRegistries.FLUID.getKey(fluid).toString();
        for (String key : toolModulesNbt.getAllKeys()) {
            ToolModuleType toolModuleType = ToolModuleTypeRegistry.get(key);
            if (toolModuleType == null || !moldBlock.isCompatible(toolModuleType)) {
                continue;
            }

            CompoundTag slotNbt = toolModulesNbt.getCompound(key);
            ToolUtils.MoldSlotState slotState = ToolUtils.MoldSlotState.fromName(slotNbt.getString("state"));

            if (slotState == ToolUtils.MoldSlotState.EMPTY) {
                slotNbt.putString("state", ToolUtils.MoldSlotState.FLUID.toString());
                slotNbt.putString("id", fluidId);
            }
        }

        result.getTag().putUUID("UUID", UUID.randomUUID());

        stack.shrink(1);
        cir.setReturnValue(result);
    }
}
