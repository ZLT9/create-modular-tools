package net.zlt.create_modular_tools.item.tool.module.sword_guard;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvent;
import net.zlt.create_modular_tools.item.tool.module.ToolModuleItem;
import net.zlt.create_modular_tools.tool.module.AllToolModuleTypes;
import net.zlt.create_modular_tools.tool.module.ToolModuleConstants;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class StoneSwordGuardToolModuleItem extends ToolModuleItem {
    public StoneSwordGuardToolModuleItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getTierLevel() {
        return ToolModuleConstants.STONE_TIER_LEVEL;
    }

    @Override
    public float getAttackSpeedWhenAttached() {
        return 0.2f;
    }

    @Override
    public int getDurabilityWhenAttached() {
        return ToolModuleConstants.STONE_DURABILITY;
    }

    @Override
    public int getEnchantmentValue() {
        return 1;
    }

    @Override
    public ToolModuleType getType() {
        return AllToolModuleTypes.SWORD_GUARD;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.STONE_SOUND;
    }
}