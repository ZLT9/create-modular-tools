package net.zlt.create_modular_tools.recipe;

import com.google.common.collect.Maps;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.compat.recipeViewerCommon.SequencedAssemblySubCategoryType;
import com.simibubi.create.content.processing.recipe.ProcessingOutput;
import com.simibubi.create.content.processing.recipe.ProcessingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import com.simibubi.create.content.processing.sequenced.IAssemblyRecipe;
import com.simibubi.create.foundation.utility.Components;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.zlt.create_modular_tools.block.entity.mold.MoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.BaseMoldBlock;
import net.zlt.create_modular_tools.item.mold.BaseSandMoldItem;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.mold.MoldRegistry;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.ToolModuleRegistry;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;
import net.zlt.create_modular_tools.tool.module.ToolModuleTypeRegistry;
import net.zlt.create_modular_tools.tool.module.ToolModuleUtils;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.*;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class MoldPressingRecipe extends ProcessingRecipe<Container> implements IAssemblyRecipe {
    public MoldPressingRecipe(ProcessingRecipeBuilder.ProcessingRecipeParams params) {
        super(AllRecipeTypes.MOLD_PRESSING, params);
    }

    @Override
    public ItemStack assemble(Container container, RegistryAccess registryAccess) {
        return assemble(container.getItem(0), registryAccess);
    }

    public ItemStack assemble(ItemStack input, RegistryAccess registryAccess) {
        ItemStack result = getResultItem(registryAccess).copy();

        if (!(result.getItem() instanceof ModularToolItem modularTool) || !(input.getItem() instanceof BaseSandMoldItem moldItem) || !(moldItem.getBlock() instanceof BaseMoldBlock moldBlock)) {
            return result;
        }

        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(input.getTag());
        if (toolModulesNbt.isEmpty()) {
            return result;
        }

        CompoundTag resultToolModulesNbt = new CompoundTag();
        Map<Enchantment, List<Integer>> resultEnchantments = Maps.newHashMap();
        for (String key : toolModulesNbt.getAllKeys()) {
            ToolModuleType toolModuleType = ToolModuleTypeRegistry.get(key);
            if (toolModuleType == null || !MoldRegistry.isCompatible(moldBlock.getModularTool(), toolModuleType) || !modularTool.isCompatible(toolModuleType)) {
                continue;
            }

            CompoundTag slotNbt = toolModulesNbt.getCompound(key);
            if (ToolUtils.MoldSlotState.fromName(slotNbt.getString("state")) != ToolUtils.MoldSlotState.SOLID) {
                continue;
            }

            String toolModuleId = slotNbt.getString("id");
            if (!ToolModuleRegistry.containsId(toolModuleId)) {
                continue;
            }

            CompoundTag resultToolModuleNbt = new CompoundTag();
            resultToolModuleNbt.putString("id", toolModuleId);
            if (slotNbt.contains("tag", Tag.TAG_COMPOUND)) {
                CompoundTag slotContentsNbt = slotNbt.getCompound("tag");
                resultToolModuleNbt.put("tag", slotContentsNbt);
                if (resultEnchantments != null) {
                    resultEnchantments = ToolModuleUtils.mergeEnchantments(resultEnchantments, EnchantmentHelper.deserializeEnchantments(slotContentsNbt.getList(ItemStack.TAG_ENCH, Tag.TAG_COMPOUND)));
                }
            }
            resultToolModulesNbt.put(key, resultToolModuleNbt);
        }

        CompoundTag nbt = result.getOrCreateTag();
        nbt.putUUID("UUID", UUID.randomUUID());
        nbt.put(MoldBlockEntity.TOOL_MODULES_TAG, resultToolModulesNbt);

        Map<Enchantment, Integer> finalResultEnchantments = Maps.newHashMap();
        if (resultEnchantments != null) {
            resultEnchantments.forEach((enchantment, levels) -> finalResultEnchantments.put(enchantment, levels.get(0)));
        }
        EnchantmentHelper.setEnchantments(finalResultEnchantments, result);

        return result;
    }

    @Override
    protected int getMaxInputCount() {
        return 1;
    }

    @Override
    protected int getMaxOutputCount() {
        return 2;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public Component getDescriptionForAssembly() {
        return Components.translatable("create_modular_tools.recipe.assembly.mold_pressing");
    }

    @Override
    public void addRequiredMachines(Set<ItemLike> list) {
        list.add(AllBlocks.MECHANICAL_PRESS.get());
    }

    @Override
    public void addAssemblyIngredients(List<Ingredient> list) {
    }

    @Override
    public SequencedAssemblySubCategoryType getJEISubCategory() {
        return SequencedAssemblySubCategoryType.PRESSING;
    }

    @Override
    public boolean matches(Container container, Level level) {
        if (container.isEmpty()) {
            return false;
        }

        ItemStack input = container.getItem(0);

        if (!(input.getItem() instanceof BaseSandMoldItem moldItem) || !(moldItem.getBlock() instanceof BaseMoldBlock moldBlock) || !ingredients.get(0).test(input)) {
            return false;
        }

        List<ProcessingOutput> rollableResults = getRollableResults();
        ItemStack result = rollableResults.isEmpty() ? ItemStack.EMPTY : rollableResults.get(0).getStack();

        if (!(result.getItem() instanceof ModularToolItem modularTool)) {
            return false;
        }

        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(input.getTag());
        Map<Enchantment, List<Integer>> resultEnchantments = Maps.newHashMap();
        for (String key : toolModulesNbt.getAllKeys()) {
            ToolModuleType toolModuleType = ToolModuleTypeRegistry.get(key);
            if (toolModuleType == null || !MoldRegistry.isCompatible(moldBlock.getModularTool(), toolModuleType) || !modularTool.isCompatible(toolModuleType)) {
                continue;
            }

            CompoundTag slotNbt = toolModulesNbt.getCompound(key);
            if (ToolUtils.MoldSlotState.fromName(slotNbt.getString("state")) != ToolUtils.MoldSlotState.SOLID || !ToolModuleRegistry.containsId(slotNbt.getString("id"))) {
                return false;
            }

            resultEnchantments = ToolModuleUtils.mergeEnchantments(resultEnchantments, EnchantmentHelper.deserializeEnchantments(slotNbt.getCompound("tag").getList(ItemStack.TAG_ENCH, Tag.TAG_COMPOUND)));
            if (resultEnchantments == null) {
                return false;
            }
        }

        return true;
    }
}
