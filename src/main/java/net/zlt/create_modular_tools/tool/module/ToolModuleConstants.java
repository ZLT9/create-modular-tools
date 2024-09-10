package net.zlt.create_modular_tools.tool.module;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Tiers;

public final class ToolModuleConstants {
    private ToolModuleConstants() {
    }

    public static final int WOOD_TIER_LEVEL = Tiers.WOOD.getLevel();
    public static final int STONE_TIER_LEVEL = Tiers.STONE.getLevel();
    public static final int IRON_TIER_LEVEL = Tiers.IRON.getLevel();
    public static final int COPPER_TIER_LEVEL = Tiers.IRON.getLevel();
    public static final int GOLD_TIER_LEVEL = Tiers.GOLD.getLevel();
    public static final int NETHERITE_TIER_LEVEL = Tiers.NETHERITE.getLevel();
    public static final int ZINC_TIER_LEVEL = Tiers.STONE.getLevel();
    public static final int BRASS_TIER_LEVEL = Tiers.IRON.getLevel();
    public static final int DIAMOND_TIER_LEVEL = Tiers.DIAMOND.getLevel();

    public static final int WOOD_DURABILITY = 60;
    public static final int STONE_DURABILITY = 140;
    public static final int IRON_DURABILITY = 260;
    public static final int COPPER_DURABILITY = 200;
    public static final int GOLD_DURABILITY = 40;
    public static final int NETHERITE_DURABILITY = 2040;
    public static final int ZINC_DURABILITY = 140;
    public static final int BRASS_DURABILITY = 230;
    public static final int DIAMOND_DURABILITY = 1570;

    public static final SoundEvent WOOD_SOUND = SoundEvents.WOOD_PLACE;
    public static final SoundEvent STONE_SOUND = SoundEvents.STONE_PLACE;
    public static final SoundEvent IRON_SOUND = SoundEvents.METAL_PLACE;
    public static final SoundEvent COPPER_SOUND = SoundEvents.COPPER_PLACE;
    public static final SoundEvent GOLD_SOUND = SoundEvents.METAL_PLACE;
    public static final SoundEvent NETHERITE_SOUND = SoundEvents.NETHERITE_BLOCK_PLACE;
    public static final SoundEvent ZINC_SOUND = SoundEvents.METAL_PLACE;
    public static final SoundEvent BRASS_SOUND = SoundEvents.METAL_PLACE;
    public static final SoundEvent DIAMOND_SOUND = SoundEvents.METAL_PLACE;
}
