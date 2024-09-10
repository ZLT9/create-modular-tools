package net.zlt.create_modular_tools.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import io.github.fabricators_of_create.porting_lib.item.DamageableItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Shadow
    public abstract Item getItem();

    @ModifyExpressionValue(method = "isDamageableItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/Item;getMaxDamage()I"))
    private int createModularTools$isDamageableItem(int original) {
        return original <= 0 && getItem() instanceof DamageableItem damageableItem ? damageableItem.getMaxDamage((ItemStack) (Object) this) : original;
    }
}
