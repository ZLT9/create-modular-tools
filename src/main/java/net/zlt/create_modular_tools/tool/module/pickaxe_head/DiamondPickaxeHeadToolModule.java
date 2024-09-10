package net.zlt.create_modular_tools.tool.module.pickaxe_head;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.zlt.create_modular_tools.item.AllItems;
import net.zlt.create_modular_tools.tool.module.ToolModuleConstants;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class DiamondPickaxeHeadToolModule extends PickaxeHeadToolModule {
    @Override
    public int getTierLevel() {
        return ToolModuleConstants.DIAMOND_TIER_LEVEL;
    }

    @Override
    public float getAttackDamage() {
        return 4.5f;
    }

    @Override
    public float getAttackSpeed() {
        return -2.5f;
    }

    @Override
    public int getDurability() {
        return ToolModuleConstants.DIAMOND_DURABILITY;
    }

    @Override
    public int getEnchantmentValue() {
        return 9;
    }

    @Override
    public Item getItem() {
        return AllItems.DIAMOND_PICKAXE_HEAD;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.DIAMOND_SOUND;
    }

    @Override
    public float getBaseDestroySpeedBonus() {
        return 8.0f;
    }
}
