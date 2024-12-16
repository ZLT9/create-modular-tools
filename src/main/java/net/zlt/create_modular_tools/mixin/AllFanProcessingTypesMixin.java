package net.zlt.create_modular_tools.mixin;

import com.google.common.collect.Lists;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.kinetics.fan.processing.AllFanProcessingTypes;
import com.simibubi.create.content.kinetics.fan.processing.SplashingRecipe;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.zlt.create_modular_tools.AllTagNames;
import net.zlt.create_modular_tools.item.mold.ToolMaterialMoldItem;
import net.zlt.create_modular_tools.item.tool.module.ToolModuleItem;
import net.zlt.create_modular_tools.recipe.AllRecipeTypes;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.ToolModuleRecipeRegistry;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;
import net.zlt.create_modular_tools.tool.module.ToolModuleTypeRegistry;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.UUID;

@Mixin(AllFanProcessingTypes.SplashingType.class)
public abstract class AllFanProcessingTypesMixin {
    @Shadow
    @Final
    private static SplashingRecipe.SplashingWrapper SPLASHING_WRAPPER;

    @ModifyReturnValue(method = "canProcess", at = @At("RETURN"))
    private boolean createModularTools$canSolidifyMold(boolean original, @Local(argsOnly = true) ItemStack stack, @Local(argsOnly = true) Level level) {
        if (original) {
            return true;
        }

        if (!(stack.getItem() instanceof ToolMaterialMoldItem) || AllRecipeTypes.MOLD_SPLASHING.find(SPLASHING_WRAPPER, level).isEmpty()) {
            return false;
        }

        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(stack.getTag());
        if (toolModulesNbt.isEmpty()) {
            return false;
        }

        Fluid fluidIngredient = null;
        for (String toolModuleTypeTag : toolModulesNbt.getAllKeys()) {
            ToolUtils.MoldSlot moldSlot = ToolUtils.getMoldSlot(toolModulesNbt, toolModuleTypeTag);
            if (moldSlot.state() == ToolUtils.MoldSlotState.EMPTY) {
                return false;
            }

            if (moldSlot.state() == ToolUtils.MoldSlotState.FLUID) {
                Fluid fluid = (Fluid) moldSlot.contents();

                if (fluidIngredient == null) {
                    if (ToolMaterialMoldItem.canBeFilledWith(fluid)) {
                        fluidIngredient = fluid;
                    } else {
                        return false;
                    }
                } else if (fluid != fluidIngredient) {
                    return false;
                }
            }
        }

        return true;
    }

    @Inject(method = "process", at = @At(value = "RETURN", ordinal = 1), cancellable = true)
    private void createModularTools$solidifyMold(ItemStack stack, Level level, CallbackInfoReturnable<List<ItemStack>> cir) {
        if (!(stack.getItem() instanceof ToolMaterialMoldItem)) {
            return;
        }

        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(stack.getTag());
        if (toolModulesNbt.isEmpty()) {
            cir.setReturnValue(null);
            return;
        }

        ItemStack result = stack.copy();
        CompoundTag resultNbt = result.getTag();
        resultNbt.putUUID(AllTagNames.ITEM_STACK_UNIQUE_ID, UUID.randomUUID());
        CompoundTag resultToolModulesNbt = ToolUtils.getToolModulesNbt(resultNbt);

        for (String toolModuleTypeTag : toolModulesNbt.getAllKeys()) {
            ToolModuleType toolModuleType = ToolModuleTypeRegistry.get(toolModuleTypeTag);
            if (toolModuleType == null) {
                continue;
            }

            ToolUtils.MoldSlot moldSlot = ToolUtils.getMoldSlot(toolModulesNbt, toolModuleTypeTag);

            if (moldSlot.state() == ToolUtils.MoldSlotState.EMPTY) {
                cir.setReturnValue(null);
                return;
            }

            if (moldSlot.state() == ToolUtils.MoldSlotState.FLUID) {
                ToolModuleItem toolModule = ToolModuleRecipeRegistry.get(toolModuleType, (Fluid) moldSlot.contents());
                if (toolModule == null) {
                    cir.setReturnValue(null);
                    return;
                }

                CompoundTag resultToolModuleNbt = new CompoundTag();
                resultToolModuleNbt.putString(AllTagNames.MOLD_SLOT_STATE, ToolUtils.MoldSlotState.SOLID.toString());
                resultToolModuleNbt.putString(AllTagNames.TOOL_MODULE_ID, toolModule.getId());
                resultToolModulesNbt.put(toolModuleTypeTag, resultToolModuleNbt);
            }
        }

        cir.setReturnValue(Lists.newArrayList(result));
    }
}
