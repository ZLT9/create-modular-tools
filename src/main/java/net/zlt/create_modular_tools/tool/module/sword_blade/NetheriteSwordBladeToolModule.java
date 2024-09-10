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
public class NetheriteSwordBladeToolModule extends SwordBladeToolModule {
    @Override
    public int getTierLevel() {
        return ToolModuleConstants.NETHERITE_TIER_LEVEL;
    }

    @Override
    public float getAttackDamage() {
        return 7.5f;
    }

    @Override
    public float getAttackSpeed() {
        return -3.1f;
    }

    @Override
    public int getDurability() {
        return ToolModuleConstants.NETHERITE_DURABILITY;
    }

    @Override
    public boolean isFireproof() {
        return true;
    }

    @Override
    public int getEnchantmentValue() {
        return 6;
    }

    @Override
    public Item getItem() {
        return AllItems.NETHERITE_SWORD_BLADE;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.NETHERITE_SOUND;
    }
}
