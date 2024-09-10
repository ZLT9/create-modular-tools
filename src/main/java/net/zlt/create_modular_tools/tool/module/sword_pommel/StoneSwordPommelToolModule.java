package net.zlt.create_modular_tools.tool.module.sword_pommel;

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
public class StoneSwordPommelToolModule extends ToolModule {
    @Override
    public int getTierLevel() {
        return ToolModuleConstants.STONE_TIER_LEVEL;
    }

    @Override
    public float getAttackSpeed() {
        return 0.2f;
    }

    @Override
    public int getDurability() {
        return ToolModuleConstants.STONE_DURABILITY;
    }

    @Override
    public int getEnchantmentValue() {
        return 0;
    }

    @Override
    public ToolModuleType getType() {
        return AllToolModuleTypes.SWORD_POMMEL;
    }

    @Override
    public Item getItem() {
        return AllItems.STONE_SWORD_POMMEL;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.STONE_SOUND;
    }
}
