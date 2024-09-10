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
public class StoneShovelHeadToolModule extends ShovelHeadToolModule {
    @Override
    public int getTierLevel() {
        return ToolModuleConstants.STONE_TIER_LEVEL;
    }

    @Override
    public float getAttackDamage() {
        return 3.0f;
    }

    @Override
    public float getAttackSpeed() {
        return -2.8f;
    }

    @Override
    public int getDurability() {
        return ToolModuleConstants.STONE_DURABILITY;
    }

    @Override
    public int getEnchantmentValue() {
        return 0;
    }

    @Override
    public Item getItem() {
        return AllItems.STONE_SHOVEL_HEAD;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.STONE_SOUND;
    }

    @Override
    public float getBaseDestroySpeedBonus() {
        return 3.9f;
    }
}
