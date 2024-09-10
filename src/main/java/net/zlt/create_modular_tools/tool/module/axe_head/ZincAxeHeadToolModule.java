package net.zlt.create_modular_tools.tool.module.axe_head;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.zlt.create_modular_tools.item.AllItems;
import net.zlt.create_modular_tools.tool.module.ToolModuleConstants;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ZincAxeHeadToolModule extends AxeHeadToolModule {
    @Override
    public int getTierLevel() {
        return ToolModuleConstants.ZINC_TIER_LEVEL;
    }

    @Override
    public float getAttackDamage() {
        return 8.5f;
    }

    @Override
    public float getAttackSpeed() {
        return -2.9f;
    }

    @Override
    public int getDurability() {
        return ToolModuleConstants.ZINC_DURABILITY;
    }

    @Override
    public int getEnchantmentValue() {
        return 4;
    }

    @Override
    public Item getItem() {
        return AllItems.ZINC_AXE_HEAD;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.ZINC_SOUND;
    }

    @Override
    public float getBaseDestroySpeedBonus() {
        return 2.0f;
    }
}
