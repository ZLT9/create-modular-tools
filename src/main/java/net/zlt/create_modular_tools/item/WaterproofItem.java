package net.zlt.create_modular_tools.item;

import net.minecraft.world.item.ItemStack;

public interface WaterproofItem {
    default boolean isWaterproof(ItemStack stack) {
        return true;
    }
}
