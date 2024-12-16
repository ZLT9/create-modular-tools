package net.zlt.create_modular_tools.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.zlt.create_modular_tools.item.FireproofItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin {
    @Shadow
    public abstract ItemStack getItem();

    @ModifyExpressionValue(method = "fireImmune", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;fireImmune()Z"))
    private boolean createModularTools$isFireproof(boolean original) {
        return original || getItem().getItem() instanceof FireproofItem fireproofItem && fireproofItem.isFireproof(getItem());
    }
}
