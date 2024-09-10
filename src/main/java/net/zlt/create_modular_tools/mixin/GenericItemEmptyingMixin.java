package net.zlt.create_modular_tools.mixin;

import com.simibubi.create.content.fluids.transfer.GenericItemEmptying;
import com.simibubi.create.foundation.utility.Pair;
import io.github.fabricators_of_create.porting_lib.fluids.FluidStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
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

@Mixin(GenericItemEmptying.class)
public abstract class GenericItemEmptyingMixin {
    @Shadow
    @Final
    private static Container WRAPPER;

    @Inject(method = "canItemBeEmptied", at = @At(value = "RETURN", ordinal = 2), cancellable = true)
    private static void createModularTools$canItemBeEmptied(Level world, ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (!(stack.getItem() instanceof BaseSandMoldItem) || AllRecipeTypes.MOLD_EMPTYING.find(WRAPPER, world).isEmpty()) {
            return;
        }

        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(stack.getTag());
        if (toolModulesNbt.isEmpty()) {
            cir.setReturnValue(false);
            return;
        }

        Fluid fluid = null;
        for (String toolModuleTypeTag : toolModulesNbt.getAllKeys()) {
            ToolUtils.MoldSlot moldSlot = ToolUtils.getMoldSlot(toolModulesNbt, toolModuleTypeTag);
            if (moldSlot.state() == ToolUtils.MoldSlotState.EMPTY) {
                cir.setReturnValue(false);
                return;
            }

            if (moldSlot.state() == ToolUtils.MoldSlotState.FLUID) {
                Fluid currentFluid = (Fluid) moldSlot.contents();

                if (fluid == null) {
                    fluid = currentFluid;
                    cir.setReturnValue(true);
                } else if (fluid != currentFluid) {
                    cir.setReturnValue(false);
                    return;
                }
            }
        }
    }

    @Inject(method = "emptyItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;copy()Lnet/minecraft/world/item/ItemStack;"), cancellable = true)
    private static void createModularTools$emptyItem(Level world, ItemStack stack, boolean simulate, CallbackInfoReturnable<Pair<FluidStack, ItemStack>> cir) {
        if (!(stack.getItem() instanceof BaseSandMoldItem)) {
            return;
        }

        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(stack.getTag());
        if (toolModulesNbt.isEmpty()) {
            cir.setReturnValue(Pair.of(FluidStack.EMPTY, ItemStack.EMPTY));
            return;
        }

        ItemStack resultingItem = stack.copy();
        CompoundTag resultingNbt = resultingItem.getTag();
        resultingNbt.putUUID("UUID", UUID.randomUUID());
        CompoundTag resultingToolModulesNbt = ToolUtils.getToolModulesNbt(resultingNbt);

        Fluid resultingFluid = null;
        long resultingFluidAmount = 0L;
        for (String toolModuleTypeTag : toolModulesNbt.getAllKeys()) {
            ToolModuleType toolModuleType = ToolModuleTypeRegistry.get(toolModuleTypeTag);
            if (toolModuleType == null) {
                continue;
            }

            ToolUtils.MoldSlot moldSlot = ToolUtils.getMoldSlot(toolModulesNbt, toolModuleTypeTag);
            if (moldSlot.state() == ToolUtils.MoldSlotState.EMPTY) {
                continue;
            }

            if (moldSlot.state() == ToolUtils.MoldSlotState.FLUID) {
                resultingToolModulesNbt.putString(toolModuleTypeTag, "");
                resultingFluid = (Fluid) moldSlot.contents();
                resultingFluidAmount += toolModuleType.getRequiredMoltenMetalAmount();
            }
        }

        if (!simulate) {
            stack.shrink(1);
        }

        if (resultingFluid == null) {
            cir.setReturnValue(Pair.of(FluidStack.EMPTY, resultingItem));
            return;
        }

        cir.setReturnValue(Pair.of(new FluidStack(resultingFluid, resultingFluidAmount), resultingItem));
    }
}
