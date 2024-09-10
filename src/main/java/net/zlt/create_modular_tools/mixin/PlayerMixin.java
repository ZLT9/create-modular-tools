package net.zlt.create_modular_tools.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.zlt.create_modular_tools.item.WaterproofItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity {
    private PlayerMixin(EntityType<? extends LivingEntity> entityType, Level level) {
        super(entityType, level);
    }

    @ModifyExpressionValue(method = "getDestroySpeed", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/enchantment/EnchantmentHelper;hasAquaAffinity(Lnet/minecraft/world/entity/LivingEntity;)Z"))
    private boolean createModularTools$getDestroySpeed(boolean original) {
        return original || getMainHandItem().getItem() instanceof WaterproofItem waterproofItem && waterproofItem.isWaterproof(getMainHandItem());
    }
}
