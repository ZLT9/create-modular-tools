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
public class IronSwordBladeToolModule extends SwordBladeToolModule {
    @Override
    public int getTierLevel() {
        return ToolModuleConstants.IRON_TIER_LEVEL;
    }

    @Override
    public float getAttackDamage() {
        return 5.5f;
    }

    @Override
    public float getAttackSpeed() {
        return -2.7f;
    }

    @Override
    public int getDurability() {
        return ToolModuleConstants.IRON_DURABILITY;
    }

    @Override
    public int getEnchantmentValue() {
        return 5;
    }

    @Override
    public Item getItem() {
        return AllItems.IRON_SWORD_BLADE;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.IRON_SOUND;
    }
}
