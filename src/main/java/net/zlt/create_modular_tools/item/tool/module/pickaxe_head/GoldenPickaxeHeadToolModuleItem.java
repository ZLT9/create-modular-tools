package net.zlt.create_modular_tools.item.tool.module.pickaxe_head;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.zlt.create_modular_tools.entity.ThrownBoomerang;
import net.zlt.create_modular_tools.entity.ThrownGoldenPickaxeHead;
import net.zlt.create_modular_tools.tool.module.ToolModuleConstants;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class GoldenPickaxeHeadToolModuleItem extends PickaxeHeadToolModuleItem {
    public GoldenPickaxeHeadToolModuleItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getTierLevel() {
        return ToolModuleConstants.GOLD_TIER_LEVEL;
    }

    @Override
    public float getAttackDamageWhenAttached() {
        return 1.5f;
    }

    @Override
    public float getAttackSpeedWhenAttached() {
        return -2.5f;
    }

    @Override
    public int getDurabilityWhenAttached() {
        return ToolModuleConstants.GOLD_DURABILITY;
    }

    @Override
    public int getEnchantmentValue() {
        return 21;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.GOLD_SOUND;
    }

    @Override
    public float getBaseDestroySpeedBonusWhenAttached() {
        return 12.0f;
    }

    @Override
    protected ThrownBoomerang createThrownBoomerang(Level level, LivingEntity shooter, ItemStack stack) {
        return new ThrownGoldenPickaxeHead(level, shooter, stack);
    }
}
