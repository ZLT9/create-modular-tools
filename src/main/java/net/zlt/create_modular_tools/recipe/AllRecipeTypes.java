package net.zlt.create_modular_tools.recipe;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeSerializer;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import com.simibubi.create.foundation.utility.Lang;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.zlt.create_modular_tools.CreateModularTools;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Optional;
import java.util.function.Supplier;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public enum AllRecipeTypes implements IRecipeTypeInfo {
    MOLD_PRESSING(MoldPressingRecipe::new),
    MOLD_FILLING(MoldFillingRecipe::new),
    MOLD_EMPTYING(MoldEmptyingRecipe::new),
    MOLD_SPLASHING(MoldSplashingRecipe::new),
    MODULAR_TOOL_CUTTING(ModularToolCuttingRecipe::new);

    private final ResourceLocation ID;
    private final RecipeSerializer<?> SERIALIZER_OBJECT;
    private final RecipeType<?> TYPE_OBJECT;
    private final Supplier<RecipeType<?>> TYPE;

    AllRecipeTypes(ProcessingRecipeBuilder.ProcessingRecipeFactory<?> processingFactory) {
        String path = Lang.asId(name());
        ID = CreateModularTools.asResource(path);
        SERIALIZER_OBJECT = Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, ID, new ProcessingRecipeSerializer<>(processingFactory));
        TYPE_OBJECT = com.simibubi.create.AllRecipeTypes.simpleType(ID);
        Registry.register(BuiltInRegistries.RECIPE_TYPE, ID, TYPE_OBJECT);
        TYPE = () -> TYPE_OBJECT;
    }

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    public <T extends RecipeSerializer<?>> T getSerializer() {
        return (T) SERIALIZER_OBJECT;
    }

    @Override
    public <T extends RecipeType<?>> T getType() {
        return (T) TYPE.get();
    }

    public <C extends Container, T extends Recipe<C>> Optional<T> find(C inv, Level world) {
        return world.getRecipeManager().getRecipeFor(getType(), inv, world);
    }

    public static void init() {
    }
}
