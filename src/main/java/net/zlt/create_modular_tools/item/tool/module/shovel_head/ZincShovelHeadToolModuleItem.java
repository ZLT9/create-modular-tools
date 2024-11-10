package net.zlt.create_modular_tools.item.tool.module.shovel_head;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvent;
import net.zlt.create_modular_tools.tool.module.ToolModuleConstants;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ZincShovelHeadToolModuleItem extends ShovelHeadToolModuleItem {
    public ZincShovelHeadToolModuleItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getTierLevel() {
        return ToolModuleConstants.ZINC_TIER_LEVEL;
    }

    @Override
    public float getAttackDamageWhenAttached() {
        return 3.0f;
    }

    @Override
    public float getAttackSpeedWhenAttached() {
        return -2.8f;
    }

    @Override
    public int getDurabilityWhenAttached() {
        return ToolModuleConstants.ZINC_DURABILITY;
    }

    @Override
    public int getEnchantmentValue() {
        return 1;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.ZINC_SOUND;
    }

    @Override
    public float getBaseDestroySpeedBonusWhenAttached() {
        return 1.9f;
    }
}
