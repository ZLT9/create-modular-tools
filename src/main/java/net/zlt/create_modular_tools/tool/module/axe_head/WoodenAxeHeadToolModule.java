package net.zlt.create_modular_tools.tool.module.axe_head;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.zlt.create_modular_tools.item.AllItems;
import net.zlt.create_modular_tools.tool.module.ToolModuleConstants;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class WoodenAxeHeadToolModule extends AxeHeadToolModule {
    @Override
    public int getTierLevel() {
        return ToolModuleConstants.WOOD_TIER_LEVEL;
    }

    @Override
    public float getAttackDamage() {
        return 6.5f;
    }

    @Override
    public float getAttackSpeed() {
        return -2.9f;
    }

    @Override
    public int getDurability() {
        return ToolModuleConstants.WOOD_DURABILITY;
    }

    @Override
    public int getEnchantmentValue() {
        return 14;
    }

    @Override
    public Item getItem() {
        return AllItems.WOODEN_AXE_HEAD;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.WOOD_SOUND;
    }

    @Override
    public float getBaseDestroySpeedBonus() {
        return 2.0f;
    }
}
