package net.zlt.create_modular_tools.item.tool.module.pickaxe_head;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.zlt.create_modular_tools.entity.ThrownBoomerang;
import net.zlt.create_modular_tools.entity.ThrownCopperPickaxeHead;
import net.zlt.create_modular_tools.tool.module.ToolModuleConstants;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CopperPickaxeHeadToolModuleItem extends PickaxeHeadToolModuleItem {
    public CopperPickaxeHeadToolModuleItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getTierLevel() {
        return ToolModuleConstants.COPPER_TIER_LEVEL;
    }

    @Override
    public float getAttackDamageWhenAttached() {
        return 3.0f;
    }

    @Override
    public float getAttackSpeedWhenAttached() {
        return -2.5f;
    }

    @Override
    public int getDurabilityWhenAttached() {
        return ToolModuleConstants.COPPER_DURABILITY;
    }

    @Override
    public boolean isWaterproofWhenAttached() {
        return true;
    }

    @Override
    public int getEnchantmentValue() {
        return 6;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.COPPER_SOUND;
    }

    @Override
    public float getBaseDestroySpeedBonusWhenAttached() {
        return 5.0f;
    }

    @Override
    protected ThrownBoomerang createThrownBoomerang(Level level, LivingEntity shooter, ItemStack stack) {
        return new ThrownCopperPickaxeHead(level, shooter, stack);
    }
}
