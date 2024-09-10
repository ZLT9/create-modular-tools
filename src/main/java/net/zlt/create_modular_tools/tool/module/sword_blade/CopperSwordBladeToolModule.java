package net.zlt.create_modular_tools.tool.module.sword_blade;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.zlt.create_modular_tools.item.AllItems;
import net.zlt.create_modular_tools.tool.module.ToolModuleConstants;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CopperSwordBladeToolModule extends SwordBladeToolModule {
    @Override
    public int getTierLevel() {
        return ToolModuleConstants.COPPER_TIER_LEVEL;
    }

    @Override
    public float getAttackDamage() {
        return 5.0f;
    }

    @Override
    public float getAttackSpeed() {
        return -2.6f;
    }

    @Override
    public int getDurability() {
        return ToolModuleConstants.COPPER_DURABILITY;
    }

    @Override
    public boolean isWaterproof() {
        return true;
    }

    @Override
    public int getEnchantmentValue() {
        return 3;
    }

    @Override
    public Item getItem() {
        return AllItems.COPPER_SWORD_BLADE;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.COPPER_SOUND;
    }
}
