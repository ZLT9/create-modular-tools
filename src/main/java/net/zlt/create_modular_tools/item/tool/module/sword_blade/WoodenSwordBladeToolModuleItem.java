package net.zlt.create_modular_tools.item.tool.module.sword_blade;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvent;
import net.zlt.create_modular_tools.tool.module.ToolModuleConstants;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class WoodenSwordBladeToolModuleItem extends SwordBladeToolModuleItem {
    public WoodenSwordBladeToolModuleItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getTierLevel() {
        return ToolModuleConstants.WOOD_TIER_LEVEL;
    }

    @Override
    public float getAttackDamageWhenAttached() {
        return 3.5f;
    }

    @Override
    public float getAttackSpeedWhenAttached() {
        return -2.3f;
    }

    @Override
    public int getDurabilityWhenAttached() {
        return ToolModuleConstants.WOOD_DURABILITY;
    }

    @Override
    public int getEnchantmentValue() {
        return 6;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.WOOD_SOUND;
    }
}
