package net.zlt.create_modular_tools.tool.module.sword_guard;

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
public class GoldenSwordGuardToolModule extends ToolModule {
    @Override
    public int getTierLevel() {
        return ToolModuleConstants.GOLD_TIER_LEVEL;
    }

    @Override
    public float getAttackSpeed() {
        return 0.2f;
    }

    @Override
    public int getDurability() {
        return ToolModuleConstants.GOLD_DURABILITY;
    }

    @Override
    public int getEnchantmentValue() {
        return 7;
    }

    @Override
    public ToolModuleType getType() {
        return AllToolModuleTypes.SWORD_GUARD;
    }

    @Override
    public Item getItem() {
        return AllItems.GOLDEN_SWORD_GUARD;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.GOLD_SOUND;
    }
}
