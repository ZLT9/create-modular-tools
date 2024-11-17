package net.zlt.create_modular_tools.item;

import net.minecraft.world.item.ItemStack;

/**
 * Implemented by items whose enchantment value depends on the specific item stack. Useful for determining enchantability based on NBT data.
 */
public interface CustomEnchantabilityItem {
    int getEnchantmentValue(ItemStack stack);
}
