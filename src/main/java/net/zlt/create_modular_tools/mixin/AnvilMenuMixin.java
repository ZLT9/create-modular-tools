package net.zlt.create_modular_tools.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.ItemCombinerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.zlt.create_modular_tools.AllTagNames;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AnvilMenu.class)
public abstract class AnvilMenuMixin extends ItemCombinerMenu {
    private AnvilMenuMixin(@Nullable MenuType<?> type, int containerId, Inventory playerInventory, ContainerLevelAccess access) {
        super(type, containerId, playerInventory, access);
    }

    @ModifyExpressionValue(method = "createResult", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;isEmpty()Z", ordinal = 0))
    private boolean createModularTools$ignoreSecondModularToolInAnvil(boolean original, @Local(ordinal = 0) ItemStack itemStack) {
        return original || inputSlots.getItem(1).getItem() instanceof ModularToolItem;
    }

    @Inject(method = "createResult", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/inventory/ResultContainer;setItem(ILnet/minecraft/world/item/ItemStack;)V", ordinal = 4))
    private void createModularTools$storeAnvilDirectEnchantments(CallbackInfo ci, @Local(ordinal = 1) ItemStack itemStack2) {
        if (!(itemStack2.getItem() instanceof ModularToolItem)) {
            return;
        }

        ItemStack itemStack3 = inputSlots.getItem(1);
        if (!itemStack3.is(Items.ENCHANTED_BOOK)) {
            return;
        }

        CompoundTag modularToolNbt = itemStack2.getTag();
        if (modularToolNbt == null) {
            return;
        }

        CompoundTag enchantedBook = itemStack3.save(new CompoundTag());
        if (modularToolNbt.contains(AllTagNames.MODULAR_TOOL_DIRECT_ENCHANTMENTS, CompoundTag.TAG_LIST)) {
            modularToolNbt.getList(AllTagNames.MODULAR_TOOL_DIRECT_ENCHANTMENTS, CompoundTag.TAG_COMPOUND).add(enchantedBook);
        } else {
            ListTag directEnchantmentsNbt = new ListTag();
            directEnchantmentsNbt.add(enchantedBook);
            modularToolNbt.put(AllTagNames.MODULAR_TOOL_DIRECT_ENCHANTMENTS, directEnchantmentsNbt);
        }
    }
}
