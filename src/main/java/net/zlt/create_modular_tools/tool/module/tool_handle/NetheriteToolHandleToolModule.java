package net.zlt.create_modular_tools.tool.module.tool_handle;

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
public class NetheriteToolHandleToolModule extends ToolModule {
    @Override
    public int getTierLevel() {
        return ToolModuleConstants.NETHERITE_TIER_LEVEL;
    }

    @Override
    public float getBaseDestroySpeedBonus() {
        return -0.4f;
    }

    @Override
    public float getAttackSpeed() {
        return -0.4f;
    }

    @Override
    public int getDurability() {
        return ToolModuleConstants.NETHERITE_DURABILITY;
    }

    @Override
    public boolean isFireproof() {
        return true;
    }

    @Override
    public int getEnchantmentValue() {
        return 4;
    }

    @Override
    public ToolModuleType getType() {
        return AllToolModuleTypes.TOOL_HANDLE;
    }

    @Override
    public Item getItem() {
        return AllItems.NETHERITE_TOOL_HANDLE;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.NETHERITE_SOUND;
    }
}
