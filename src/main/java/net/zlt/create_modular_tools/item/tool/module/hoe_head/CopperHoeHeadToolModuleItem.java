package net.zlt.create_modular_tools.item.tool.module.hoe_head;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvent;
import net.zlt.create_modular_tools.tool.module.ToolModuleConstants;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CopperHoeHeadToolModuleItem extends HoeHeadToolModuleItem {
    public CopperHoeHeadToolModuleItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getTierLevel() {
        return ToolModuleConstants.COPPER_TIER_LEVEL;
    }

    @Override
    public float getAttackDamageWhenAttached() {
        return 0.5f;
    }

    @Override
    public float getAttackSpeedWhenAttached() {
        return -1.2f;
    }

    @Override
    public int getDurabilityWhenAttached() {
        return ToolModuleConstants.COPPER_DURABILITY;
    }

    @Override
    public boolean isWaterproofWhenAttached() {
        return true;
    }

    @Override
    public int getEnchantmentValue() {
        return 6;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.COPPER_SOUND;
    }

    @Override
    public float getBaseDestroySpeedBonusWhenAttached() {
        return 5.0f;
    }
}
