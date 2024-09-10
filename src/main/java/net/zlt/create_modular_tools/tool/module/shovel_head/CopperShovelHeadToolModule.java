package net.zlt.create_modular_tools.tool.module.shovel_head;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.zlt.create_modular_tools.item.AllItems;
import net.zlt.create_modular_tools.tool.module.ToolModuleConstants;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CopperShovelHeadToolModule extends ShovelHeadToolModule {
    @Override
    public int getTierLevel() {
        return ToolModuleConstants.COPPER_TIER_LEVEL;
    }

    @Override
    public float getAttackDamage() {
        return 3.5f;
    }

    @Override
    public float getAttackSpeed() {
        return -2.8f;
    }

    @Override
    public int getDurability() {
        return ToolModuleConstants.COPPER_DURABILITY;
    }

    @Override
    public boolean isWaterproof() {
        return true;
    }

    @Override
    public int getEnchantmentValue() {
        return 3;
    }

    @Override
    public Item getItem() {
        return AllItems.COPPER_SHOVEL_HEAD;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.COPPER_SOUND;
    }

    @Override
    public float getBaseDestroySpeedBonus() {
        return 4.9f;
    }
}
