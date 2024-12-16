package net.zlt.create_modular_tools.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.inventory.GrindstoneMenu;
import net.minecraft.world.item.ItemStack;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(GrindstoneMenu.class)
public abstract class GrindstoneMenuMixin {
    @ModifyExpressionValue(method = "createResult", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;isEmpty()Z", ordinal = 0))
    private boolean createModularTools$ignoreFirstModularToolInGrindstone(boolean original, @Local(ordinal = 0) ItemStack itemStack) {
        return original || itemStack.getItem() instanceof ModularToolItem;
    }

    @ModifyExpressionValue(method = "createResult", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;isEmpty()Z", ordinal = 1))
    private boolean createModularTools$ignoreSecondModularToolInGrindstone(boolean original, @Local(ordinal = 1) ItemStack itemStack2) {
        return original || itemStack2.getItem() instanceof ModularToolItem;
    }
}
