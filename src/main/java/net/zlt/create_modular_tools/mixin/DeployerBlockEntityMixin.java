package net.zlt.create_modular_tools.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.deployer.DeployerBlockEntity;
import com.simibubi.create.content.kinetics.deployer.DeployerRecipeSearchEvent;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.recipe.AllRecipeTypes;
import net.zlt.create_modular_tools.recipe.ToolModuleDeployingRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DeployerBlockEntity.class)
public abstract class DeployerBlockEntityMixin extends KineticBlockEntity {
    private DeployerBlockEntityMixin(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    @Inject(method = "getRecipe", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/content/kinetics/deployer/DeployerRecipeSearchEvent;addRecipe(Ljava/util/function/Supplier;I)V", ordinal = 0))
    private void createModularTools$addToolModuleDeployingRecipes(ItemStack stack, CallbackInfoReturnable<Recipe<? extends Container>> cir, @Local DeployerRecipeSearchEvent event) {
        event.addRecipe(() -> SequencedAssemblyRecipe.getRecipe(level, event.getInventory(), AllRecipeTypes.TOOL_MODULE_DEPLOYING.getType(), ToolModuleDeployingRecipe.class), 100);
        event.addRecipe(() -> AllRecipeTypes.TOOL_MODULE_DEPLOYING.find(event.getInventory(), level), 50);
    }
}
