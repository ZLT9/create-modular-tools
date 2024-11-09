package net.zlt.create_modular_tools.recipe;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.compat.recipeViewerCommon.SequencedAssemblySubCategoryType;
import com.simibubi.create.content.kinetics.saw.CuttingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingOutput;
import com.simibubi.create.content.processing.recipe.ProcessingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import com.simibubi.create.content.processing.sequenced.IAssemblyRecipe;
import com.simibubi.create.foundation.utility.Components;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.zlt.create_modular_tools.CreateModularTools;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Set;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ModularToolCuttingRecipe extends ProcessingRecipe<Container> implements IAssemblyRecipe {
    public ModularToolCuttingRecipe(ProcessingRecipeBuilder.ProcessingRecipeParams params) {
        super(AllRecipeTypes.MODULAR_TOOL_CUTTING, params);
    }

    @Override
    protected int getMaxInputCount() {
        return 1;
    }

    @Override
    protected int getMaxOutputCount() {
        return 9999;
    }

    @Override
    protected boolean canSpecifyDuration() {
        return true;
    }

    @Override
    public Component getDescriptionForAssembly() {
        return Components.translatable("create_modular_tools.recipe.assembly.modular_tool_cutting");
    }

    @Override
    public void addRequiredMachines(Set<ItemLike> list) {
        list.add(AllBlocks.MECHANICAL_SAW.get());
    }

    @Override
    public void addAssemblyIngredients(List<Ingredient> list) {
    }

    @Override
    public SequencedAssemblySubCategoryType getJEISubCategory() {
        return SequencedAssemblySubCategoryType.CUTTING;
    }

    @Override
    public boolean matches(Container container, Level level) {
        return !container.isEmpty() && ingredients.get(0).test(container.getItem(0));
    }

    public static class SubRecipe extends CuttingRecipe {
        public final List<ItemStack> RESULTS;

        public SubRecipe(NonNullList<Ingredient> ingredients, List<ItemStack> results, int processingDuration) {
            super(new SubRecipeParams(ingredients, NonNullList.create(), processingDuration));
            RESULTS = results;
        }

        @Override
        public List<ItemStack> rollResults() {
            return RESULTS;
        }

        public static class SubRecipeParams extends ProcessingRecipeBuilder.ProcessingRecipeParams {
            public static final ResourceLocation DUMMY_ID = CreateModularTools.asResource("dummy");

            protected SubRecipeParams(NonNullList<Ingredient> ingredients, NonNullList<ProcessingOutput> results, int processingDuration) {
                super(DUMMY_ID);
                this.ingredients = ingredients;
                this.results = results;
                this.processingDuration = processingDuration;
            }
        }
    }
}
