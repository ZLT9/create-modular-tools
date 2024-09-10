package net.zlt.create_modular_tools.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(targets = "net.minecraft.world.item.enchantment.EnchantmentCategory$6")
public abstract class WeaponEnchantmentCategoryMixin {
    @ModifyReturnValue(method = "canEnchant", at = @At("RETURN"))
    private boolean createModularTools$canEnchant(boolean original, @Local(argsOnly = true) Item item) {
        return original || item instanceof ModularToolItem modularTool && modularTool.canApplyEnchantmentOf(EnchantmentCategory.WEAPON);
    }
}
