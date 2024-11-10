package net.zlt.create_modular_tools.item.tool.module.axe_head;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvent;
import net.zlt.create_modular_tools.tool.module.ToolModuleConstants;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class GoldenAxeHeadToolModuleItem extends AxeHeadToolModuleItem {
    public GoldenAxeHeadToolModuleItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getTierLevel() {
        return ToolModuleConstants.GOLD_TIER_LEVEL;
    }

    @Override
    public float getAttackDamageWhenAttached() {
        return 6.5f;
    }

    @Override
    public float getAttackSpeedWhenAttached() {
        return -2.7f;
    }

    @Override
    public int getDurabilityWhenAttached() {
        return ToolModuleConstants.GOLD_DURABILITY;
    }

    @Override
    public int getEnchantmentValue() {
        return 21;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.GOLD_SOUND;
    }

    @Override
    public float getBaseDestroySpeedBonusWhenAttached() {
        return 12.0f;
    }
}
