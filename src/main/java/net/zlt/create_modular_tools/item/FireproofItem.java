package net.zlt.create_modular_tools.item;

import net.minecraft.world.item.ItemStack;

public interface FireproofItem {
    default boolean isFireproof(ItemStack stack) {
        return true;
    }
}
