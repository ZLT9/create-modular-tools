package net.zlt.create_modular_tools.tool.module.hoe_head;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.zlt.create_modular_tools.item.AllItems;
import net.zlt.create_modular_tools.tool.module.ToolModuleConstants;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class IronHoeHeadToolModule extends HoeHeadToolModule {
    @Override
    public int getTierLevel() {
        return ToolModuleConstants.IRON_TIER_LEVEL;
    }

    @Override
    public float getAttackDamage() {
        return 0.5f;
    }

    @Override
    public float getAttackSpeed() {
        return -0.7f;
    }

    @Override
    public int getDurability() {
        return ToolModuleConstants.IRON_DURABILITY;
    }

    @Override
    public int getEnchantmentValue() {
        return 12;
    }

    @Override
    public Item getItem() {
        return AllItems.IRON_HOE_HEAD;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.IRON_SOUND;
    }

    @Override
    public float getBaseDestroySpeedBonus() {
        return 6.0f;
    }
}
