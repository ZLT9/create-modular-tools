package net.zlt.create_modular_tools.recipe;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.compat.recipeViewerCommon.SequencedAssemblySubCategoryType;
import com.simibubi.create.content.processing.recipe.ProcessingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import com.simibubi.create.content.processing.sequenced.IAssemblyRecipe;
import com.simibubi.create.foundation.utility.Components;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.zlt.create_modular_tools.block.entity.mold.SandMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.MoldUtils;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.ToolModuleRegistry;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Set;
import java.util.UUID;

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

        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(input.getTag());
        if (toolModulesNbt.isEmpty()) {
            return result;
        }

        CompoundTag resultToolModulesNbt = new CompoundTag();
        for (String key : toolModulesNbt.getAllKeys()) {
            String toolModuleId = toolModulesNbt.getString(key);
            if (ToolModuleRegistry.containsId(toolModuleId)) {
                resultToolModulesNbt.putString(key, toolModuleId);
            }
        }

        CompoundTag nbt = result.getOrCreateTag();
        nbt.putUUID("UUID", UUID.randomUUID());
        nbt.put(SandMoldBlockEntity.TOOL_MODULES_TAG, resultToolModulesNbt);

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
        return ingredients.get(0).test(input) && MoldUtils.isMoldSolid(input);
    }
}
