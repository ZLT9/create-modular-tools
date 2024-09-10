package net.zlt.create_modular_tools.tool.module.tool_grip;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.zlt.create_modular_tools.item.AllItems;
import net.zlt.create_modular_tools.tool.module.AllToolModuleTypes;
import net.zlt.create_modular_tools.tool.module.ToolModule;
import net.zlt.create_modular_tools.tool.module.ToolModuleConstants;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class IronToolGripToolModule extends ToolModule {
    @Override
    public int getTierLevel() {
        return ToolModuleConstants.IRON_TIER_LEVEL;
    }

    @Override
    public float getBaseDestroySpeedBonus() {
        return 0.3f;
    }

    @Override
    public float getAttackSpeed() {
        return 0.3f;
    }

    @Override
    public int getDurability() {
        return ToolModuleConstants.IRON_DURABILITY;
    }

    @Override
    public int getEnchantmentValue() {
        return 3;
    }

    @Override
    public ToolModuleType getType() {
        return AllToolModuleTypes.TOOL_GRIP;
    }

    @Override
    public Item getItem() {
        return AllItems.IRON_TOOL_GRIP;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.IRON_SOUND;
    }
}
