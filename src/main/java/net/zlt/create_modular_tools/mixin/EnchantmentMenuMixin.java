package net.zlt.create_modular_tools.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.EnchantmentMenu;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EnchantmentMenu.class)
public abstract class EnchantmentMenuMixin {
    @Unique
    private ItemStack result;

    @Inject(method = "method_17410", at = @At(value = "INVOKE", target = "Ljava/util/List;size()I"))
    private void createModularTools$grabEnchantingTableResult(ItemStack itemStack, int i, Player player, int j, ItemStack itemStack2, Level world, BlockPos pos, CallbackInfo ci, @Local(ordinal = 2) ItemStack itemStack3) {
        result = itemStack3.getItem() instanceof ModularToolItem ? itemStack3 : null;
    }

    @Inject(method = "method_17410", at = @At(value = "FIELD", target = "Lnet/minecraft/world/entity/player/Abilities;instabuild:Z"))
    private void createModularTools$storeEnchantingTableDirectEnchantments(ItemStack itemStack, int i, Player player, int j, ItemStack itemStack2, Level world, BlockPos pos, CallbackInfo ci) {
        if (result == null) {
            return;
        }

        CompoundTag resultNbt = result.getTag();
        if (resultNbt == null) {
            return;
        }

        ListTag resultEnchantments = resultNbt.getList(ItemStack.TAG_ENCH, CompoundTag.TAG_COMPOUND);

        CompoundTag enchantedBookNbt = new CompoundTag();
        enchantedBookNbt.putString("id", BuiltInRegistries.ITEM.getKey(Items.ENCHANTED_BOOK).toString());
        enchantedBookNbt.putByte("Count", (byte) 1);
        CompoundTag enchantedBookNbtTag = new CompoundTag();
        enchantedBookNbtTag.put(EnchantedBookItem.TAG_STORED_ENCHANTMENTS, resultEnchantments.copy());
        enchantedBookNbt.put("tag", enchantedBookNbtTag);

        ListTag directEnchantments = new ListTag();
        directEnchantments.add(enchantedBookNbt);

        resultNbt.put("DirectEnchantments", directEnchantments);

        result = null;
    }
}
