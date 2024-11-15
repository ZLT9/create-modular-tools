package net.zlt.create_modular_tools.mixin;

import com.google.common.collect.Maps;
import com.simibubi.create.content.kinetics.base.BlockBreakingKineticBlockEntity;
import com.simibubi.create.content.kinetics.saw.CuttingRecipe;
import com.simibubi.create.content.kinetics.saw.SawBlockEntity;
import com.simibubi.create.content.processing.recipe.ProcessingInventory;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SidedStorageBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.item.tool.module.ToolModuleItem;
import net.zlt.create_modular_tools.recipe.AllRecipeTypes;
import net.zlt.create_modular_tools.recipe.ModularToolCuttingRecipe;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.ToolModuleRegistry;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;
import net.zlt.create_modular_tools.tool.module.ToolModuleUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Mixin(SawBlockEntity.class)
public abstract class SawBlockEntityMixin extends BlockBreakingKineticBlockEntity implements SidedStorageBlockEntity {
    @Shadow
    public ProcessingInventory inventory;

    private SawBlockEntityMixin(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Inject(method = "getRecipes", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/foundation/recipe/RecipeConditions;isOfType([Lnet/minecraft/world/item/crafting/RecipeType;)Ljava/util/function/Predicate;"), cancellable = true)
    private void createModularTools$getRecipes(CallbackInfoReturnable<List<? extends Recipe<?>>> cir) {
        ItemStack inputStack = inventory.getStackInSlot(0);
        if (!(inputStack.getItem() instanceof ModularToolItem modularToolItem) || AllRecipeTypes.MODULAR_TOOL_CUTTING.find(inventory, level).isEmpty()) {
            return;
        }

        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(inputStack);
        if (toolModulesNbt.isEmpty()) {
            cir.setReturnValue(List.of());
            return;
        }

        NonNullList<Ingredient> ingredients = NonNullList.of(new Ingredient(Stream.of(new Ingredient.ItemValue(inputStack))));

        List<ItemStack> results = new ArrayList<>();
        Map<Enchantment, List<Integer>> enchantmentMap = Maps.newHashMap();
        for (ToolModuleType toolModuleType : modularToolItem.getCompatible()) {
            CompoundTag toolModuleNbt = toolModulesNbt.getCompound(toolModuleType.getTag());
            ToolModuleItem toolModule = ToolModuleRegistry.get(toolModuleNbt.getString("id"));
            if (toolModule != null) {
                ItemStack toolModuleStack = toolModule.getDefaultInstance();
                if (toolModuleNbt.contains("tag", Tag.TAG_COMPOUND)) {
                    CompoundTag toolModuleTag = toolModuleNbt.getCompound("tag");
                    toolModuleStack.setTag(toolModuleTag);
                    if (enchantmentMap != null) {
                        enchantmentMap = ToolModuleUtils.mergeEnchantments(enchantmentMap, EnchantmentHelper.deserializeEnchantments(toolModuleTag.getList(ItemStack.TAG_ENCH, Tag.TAG_COMPOUND)));
                    }
                }
                results.add(toolModuleStack);
            }
        }

        if (enchantmentMap != null) {
            ItemStack enchantedBook = new ItemStack(Items.ENCHANTED_BOOK);
            boolean dropEnchantedBook = false;
            for (Map.Entry<Enchantment, Integer> enchantmentEntry : EnchantmentHelper.deserializeEnchantments(inputStack.getEnchantmentTags()).entrySet()) {
                Enchantment enchantment = enchantmentEntry.getKey();
                Integer enchantmentLevel = enchantmentEntry.getValue();
                List<Integer> enchantmentLevels = enchantmentMap.get(enchantment);
                if (enchantmentLevels == null) {
                    dropEnchantedBook = true;
                    EnchantedBookItem.addEnchantment(enchantedBook, new EnchantmentInstance(enchantment, enchantmentLevel));
                } else if (enchantmentLevel > enchantmentLevels.get(0)) {
                    dropEnchantedBook = true;
                    EnchantedBookItem.addEnchantment(enchantedBook, new EnchantmentInstance(enchantment, enchantmentLevel - enchantmentLevels.get(0)));
                }
            }
            if (dropEnchantedBook) {
                results.add(enchantedBook);
            }
        }

        cir.setReturnValue(List.<CuttingRecipe>of(new ModularToolCuttingRecipe.SubRecipe(ingredients, results, 15)));
    }
}
