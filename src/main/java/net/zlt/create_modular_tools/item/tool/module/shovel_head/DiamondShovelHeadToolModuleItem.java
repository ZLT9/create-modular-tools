package net.zlt.create_modular_tools.item.tool.module.shovel_head;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvent;
import net.zlt.create_modular_tools.tool.module.ToolModuleConstants;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class DiamondShovelHeadToolModuleItem extends ShovelHeadToolModuleItem {
    public DiamondShovelHeadToolModuleItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getTierLevel() {
        return ToolModuleConstants.DIAMOND_TIER_LEVEL;
    }

    @Override
    public float getAttackDamageWhenAttached() {
        return 5.0f;
    }

    @Override
    public float getAttackSpeedWhenAttached() {
        return -2.8f;
    }

    @Override
    public int getDurabilityWhenAttached() {
        return ToolModuleConstants.DIAMOND_DURABILITY;
    }

    @Override
    public int getEnchantmentValue() {
        return 6;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.DIAMOND_SOUND;
    }

    @Override
    public float getBaseDestroySpeedBonusWhenAttached() {
        return 7.9f;
    }
}
