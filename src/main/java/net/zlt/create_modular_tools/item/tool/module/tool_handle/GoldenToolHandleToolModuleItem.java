package net.zlt.create_modular_tools.item.tool.module.tool_handle;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvent;
import net.zlt.create_modular_tools.tool.module.ToolModuleConstants;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class GoldenToolHandleToolModuleItem extends ToolHandleToolModuleItem {
    public GoldenToolHandleToolModuleItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getTierLevel() {
        return ToolModuleConstants.GOLD_TIER_LEVEL;
    }

    @Override
    public float getBaseDestroySpeedBonusWhenAttached() {
        return -0.1f;
    }

    @Override
    public float getAttackSpeedWhenAttached() {
        return -0.1f;
    }

    @Override
    public int getDurabilityWhenAttached() {
        return ToolModuleConstants.GOLD_DURABILITY;
    }

    @Override
    public int getEnchantmentValue() {
        return 7;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.GOLD_SOUND;
    }
}
