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
public class WoodenPickaxeHeadToolModule extends PickaxeHeadToolModule {
    @Override
    public int getTierLevel() {
        return ToolModuleConstants.WOOD_TIER_LEVEL;
    }

    @Override
    public float getAttackDamage() {
        return 1.5f;
    }

    @Override
    public float getAttackSpeed() {
        return -2.5f;
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
        return AllItems.WOODEN_PICKAXE_HEAD;
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
