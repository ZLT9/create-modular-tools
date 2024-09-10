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
public class ZincSwordGuardToolModule extends ToolModule {
    @Override
    public int getTierLevel() {
        return ToolModuleConstants.ZINC_TIER_LEVEL;
    }

    @Override
    public float getAttackSpeed() {
        return 0.1f;
    }

    @Override
    public int getDurability() {
        return ToolModuleConstants.ZINC_DURABILITY;
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
    public Item getItem() {
        return AllItems.ZINC_SWORD_GUARD;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.ZINC_SOUND;
    }
}
