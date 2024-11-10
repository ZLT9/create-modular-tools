package net.zlt.create_modular_tools.item.tool.module.axe_head;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvent;
import net.zlt.create_modular_tools.tool.module.ToolModuleConstants;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ZincAxeHeadToolModuleItem extends AxeHeadToolModuleItem {
    public ZincAxeHeadToolModuleItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getTierLevel() {
        return ToolModuleConstants.ZINC_TIER_LEVEL;
    }

    @Override
    public float getAttackDamageWhenAttached() {
        return 8.5f;
    }

    @Override
    public float getAttackSpeedWhenAttached() {
        return -2.9f;
    }

    @Override
    public int getDurabilityWhenAttached() {
        return ToolModuleConstants.ZINC_DURABILITY;
    }

    @Override
    public int getEnchantmentValue() {
        return 4;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.ZINC_SOUND;
    }

    @Override
    public float getBaseDestroySpeedBonusWhenAttached() {
        return 2.0f;
    }
}
