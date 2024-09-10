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
public class ZincSwordBladeToolModule extends SwordBladeToolModule {
    @Override
    public int getTierLevel() {
        return ToolModuleConstants.ZINC_TIER_LEVEL;
    }

    @Override
    public float getAttackDamage() {
        return 4.5f;
    }

    @Override
    public float getAttackSpeed() {
        return -2.3f;
    }

    @Override
    public int getDurability() {
        return ToolModuleConstants.ZINC_DURABILITY;
    }

    @Override
    public int getEnchantmentValue() {
        return 2;
    }

    @Override
    public Item getItem() {
        return AllItems.ZINC_SWORD_BLADE;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.ZINC_SOUND;
    }
}
