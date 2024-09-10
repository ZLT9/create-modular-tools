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
public class GoldenAxeHeadToolModule extends AxeHeadToolModule {
    @Override
    public int getTierLevel() {
        return ToolModuleConstants.GOLD_TIER_LEVEL;
    }

    @Override
    public float getAttackDamage() {
        return 6.5f;
    }

    @Override
    public float getAttackSpeed() {
        return -2.7f;
    }

    @Override
    public int getDurability() {
        return ToolModuleConstants.GOLD_DURABILITY;
    }

    @Override
    public int getEnchantmentValue() {
        return 21;
    }

    @Override
    public Item getItem() {
        return AllItems.GOLDEN_AXE_HEAD;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.GOLD_SOUND;
    }

    @Override
    public float getBaseDestroySpeedBonus() {
        return 12.0f;
    }
}
