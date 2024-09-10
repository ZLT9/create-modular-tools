package net.zlt.create_modular_tools.item.tool.module;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.zlt.create_modular_tools.advancement.AllCriterionTriggers;
import net.zlt.create_modular_tools.entity.ThrownBoomerang;
import net.zlt.create_modular_tools.tool.module.ToolModule;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class BoomerangItem extends ToolModuleItem {
    public BoomerangItem(ToolModule toolModule, Properties properties) {
        super(toolModule, properties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.SPEAR;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        player.startUsingItem(usedHand);
        return InteractionResultHolder.consume(player.getItemInHand(usedHand));
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity livingEntity, int timeCharged) {
        if (!(livingEntity instanceof Player player) || getUseDuration(stack) - timeCharged < 10) {
            return;
        }

        if (!level.isClientSide) {
            ThrownBoomerang thrownBoomerang = createThrownBoomerang(level, player, stack.copyWithCount(1));
            thrownBoomerang.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0f, 1.0f, 0.0f);
            if (player.getAbilities().instabuild) {
                thrownBoomerang.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
            }

            level.addFreshEntity(thrownBoomerang);
            level.playSound(null, thrownBoomerang, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0f, 1.0f);
            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
            }

            if (livingEntity instanceof ServerPlayer serverPlayer) {
                AllCriterionTriggers.BOOMERANG_THROWN.trigger(serverPlayer);
            }
        }

        player.awardStat(Stats.ITEM_USED.get(this));
    }

    protected abstract ThrownBoomerang createThrownBoomerang(Level level, LivingEntity shooter, ItemStack stack);
}
