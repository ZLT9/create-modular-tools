package net.zlt.create_modular_tools.item;

import net.minecraft.world.item.ItemStack;

public interface CustomEnchantableItem {
    int getEnchantmentValue(ItemStack stack);
}
