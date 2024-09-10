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
public class WoodenShovelHeadToolModule extends ShovelHeadToolModule {
    @Override
    public int getTierLevel() {
        return ToolModuleConstants.WOOD_TIER_LEVEL;
    }

    @Override
    public float getAttackDamage() {
        return 2.0f;
    }

    @Override
    public float getAttackSpeed() {
        return -2.8f;
    }

    @Override
    public int getDurability() {
        return ToolModuleConstants.WOOD_DURABILITY;
    }

    @Override
    public int getEnchantmentValue() {
        return 11;
    }

    @Override
    public Item getItem() {
        return AllItems.WOODEN_SHOVEL_HEAD;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.WOOD_SOUND;
    }

    @Override
    public float getBaseDestroySpeedBonus() {
        return 1.9f;
    }
}
