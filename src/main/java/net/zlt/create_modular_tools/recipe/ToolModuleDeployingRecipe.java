package net.zlt.create_modular_tools.recipe;

import com.google.gson.JsonObject;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.compat.recipeViewerCommon.SequencedAssemblySubCategoryType;
import com.simibubi.create.content.processing.recipe.ProcessingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import com.simibubi.create.content.processing.sequenced.IAssemblyRecipe;
import com.simibubi.create.foundation.utility.Components;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Set;

public class ToolModuleDeployingRecipe extends ProcessingRecipe<Container> implements IAssemblyRecipe {
    private boolean keepHeldItem;

    public ToolModuleDeployingRecipe(ProcessingRecipeBuilder.ProcessingRecipeParams params) {
        super(AllRecipeTypes.TOOL_MODULE_DEPLOYING, params);
        keepHeldItem = params.keepHeldItem;
    }

    @Override
    public boolean matches(Container inv, Level worldIn) {
        return ingredients.get(0).test(inv.getItem(0)) && ingredients.get(1).test(inv.getItem(1));
    }

    @Override
    protected int getMaxInputCount() {
        return 2;
    }

    @Override
    protected int getMaxOutputCount() {
        return 4;
    }

    public boolean shouldKeepHeldItem() {
        return keepHeldItem;
    }

    public Ingredient getRequiredHeldItem() {
        if (ingredients.isEmpty()) {
            throw new IllegalStateException("Tool Module Deploying Recipe: " + id.toString() + " has no tool!");
        }
        return ingredients.get(1);
    }

    public Ingredient getProcessedItem() {
        if (ingredients.size() < 2) {
            throw new IllegalStateException("Tool Module Deploying Recipe: " + id.toString() + " has no ingredient!");
        }
        return ingredients.get(0);
    }

    @Override
    public void readAdditional(JsonObject json) {
        super.readAdditional(json);
        keepHeldItem = GsonHelper.getAsBoolean(json, "keepHeldItem", false);
    }

    @Override
    public void writeAdditional(JsonObject json) {
        super.writeAdditional(json);
        if (keepHeldItem) {
            json.addProperty("keepHeldItem", keepHeldItem);
        }
    }

    @Override
    public void readAdditional(FriendlyByteBuf buffer) {
        super.readAdditional(buffer);
        keepHeldItem = buffer.readBoolean();
    }

    @Override
    public void writeAdditional(FriendlyByteBuf buffer) {
        super.writeAdditional(buffer);
        buffer.writeBoolean(keepHeldItem);
    }

    @Override
    public void addAssemblyIngredients(List<Ingredient> list) {
        list.add(ingredients.get(1));
    }

    @Override
    public Component getDescriptionForAssembly() {
        return Components.translatable("create_modular_tools.recipe.assembly.tool_module_deploying");
    }

    @Override
    public void addRequiredMachines(Set<ItemLike> list) {
        list.add(AllBlocks.DEPLOYER.get());
    }

    @Override
    public SequencedAssemblySubCategoryType getJEISubCategory() {
        return SequencedAssemblySubCategoryType.DEPLOYING;
    }
}
