package net.zlt.create_modular_tools.recipe;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.compat.recipeViewerCommon.SequencedAssemblySubCategoryType;
import com.simibubi.create.content.processing.recipe.ProcessingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import com.simibubi.create.content.processing.sequenced.IAssemblyRecipe;
import com.simibubi.create.foundation.utility.Components;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Set;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class MoldFillingRecipe extends ProcessingRecipe<Container> implements IAssemblyRecipe {
    public MoldFillingRecipe(ProcessingRecipeBuilder.ProcessingRecipeParams params) {
        super(AllRecipeTypes.MOLD_FILLING, params);
    }

    @Override
    public ItemStack assemble(Container container, RegistryAccess registryAccess) {
        return super.assemble(container, registryAccess);
    }

    @Override
    protected int getMaxInputCount() {
        return 1;
    }

    @Override
    protected int getMaxOutputCount() {
        return 1;
    }

    @Override
    protected int getMaxFluidInputCount() {
        return 1;
    }

    @Override
    public Component getDescriptionForAssembly() {
        return Components.translatable("create_modular_tools.recipe.assembly.mold_filling");
    }

    @Override
    public void addRequiredMachines(Set<ItemLike> list) {
        list.add(AllBlocks.SPOUT.get());
    }

    @Override
    public void addAssemblyIngredients(List<Ingredient> list) {
    }

    @Override
    public SequencedAssemblySubCategoryType getJEISubCategory() {
        return SequencedAssemblySubCategoryType.SPOUTING;
    }

    @Override
    public boolean matches(Container container, Level level) {
        return !container.isEmpty() && ingredients.get(0).test(container.getItem(0));
    }
}
