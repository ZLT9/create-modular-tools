package net.zlt.create_modular_tools.item.tool.module.sword_blade;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvent;
import net.zlt.create_modular_tools.tool.module.ToolModuleConstants;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class NetheriteSwordBladeToolModuleItem extends SwordBladeToolModuleItem {
    public NetheriteSwordBladeToolModuleItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getTierLevel() {
        return ToolModuleConstants.NETHERITE_TIER_LEVEL;
    }

    @Override
    public float getAttackDamageWhenAttached() {
        return 7.5f;
    }

    @Override
    public float getAttackSpeedWhenAttached() {
        return -3.1f;
    }

    @Override
    public int getDurabilityWhenAttached() {
        return ToolModuleConstants.NETHERITE_DURABILITY;
    }

    @Override
    public boolean isFireproofWhenAttached() {
        return true;
    }

    @Override
    public int getEnchantmentValue() {
        return 6;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.NETHERITE_SOUND;
    }
}
