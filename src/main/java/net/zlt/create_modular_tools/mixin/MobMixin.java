package net.zlt.create_modular_tools.mixin;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Mob.class)
public abstract class MobMixin {
    @Inject(method = "canReplaceCurrentItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;getItem()Lnet/minecraft/world/item/Item;", ordinal = 0), cancellable = true)
    private void createModularTools$canReplace(ItemStack candidate, ItemStack existing, CallbackInfoReturnable<Boolean> cir) {
        if (candidate.getItem() instanceof ModularToolItem modularTool) {
            cir.setReturnValue(modularTool.canReplace((Mob) (Object) this, candidate, existing));
        }
    }

    @Inject(method = "canReplaceCurrentItem", at = @At(value = "RETURN", ordinal = 1), cancellable = true)
    private void createModularTools$canBeReplacedBySword(ItemStack candidate, ItemStack existing, CallbackInfoReturnable<Boolean> cir) {
        if (existing.getItem() instanceof ModularToolItem modularTool) {
            cir.setReturnValue(modularTool.canBeReplacedBy((Mob) (Object) this, candidate, existing));
        }
    }

    @Inject(method = "canReplaceCurrentItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;getItem()Lnet/minecraft/world/item/Item;", ordinal = 14), cancellable = true)
    private void createModularTools$canBeReplacedByDigger(ItemStack candidate, ItemStack existing, CallbackInfoReturnable<Boolean> cir) {
        if (existing.getItem() instanceof ModularToolItem modularTool) {
            cir.setReturnValue(modularTool.canBeReplacedBy((Mob) (Object) this, candidate, existing));
        }
    }
}
