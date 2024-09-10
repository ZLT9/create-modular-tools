package net.zlt.create_modular_tools.recipe;

import com.simibubi.create.content.kinetics.fan.processing.SplashingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class MoldSplashingRecipe extends ProcessingRecipe<SplashingRecipe.SplashingWrapper> {
    public MoldSplashingRecipe(ProcessingRecipeBuilder.ProcessingRecipeParams params) {
        super(AllRecipeTypes.MOLD_SPLASHING, params);
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
    public boolean matches(SplashingRecipe.SplashingWrapper container, Level level) {
        return !container.isEmpty() && ingredients.get(0).test(container.getItem(0));
    }
}
