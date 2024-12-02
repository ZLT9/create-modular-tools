package net.zlt.create_modular_tools.client.model.item.mold.gray_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.client.model.SingleModelResolver;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PickaxeGrayConcretePowderJungleMoldItemModelResolver extends SingleModelResolver {
    public static final ResourceLocation PICKAXE_GRAY_CONCRETE_POWDER_JUNGLE_MOLD_MODEL_ID = CreateModularTools.asResource("item/pickaxe_gray_concrete_powder_jungle_mold");

    @Override
    public ResourceLocation getModelId() {
        return PICKAXE_GRAY_CONCRETE_POWDER_JUNGLE_MOLD_MODEL_ID;
    }

    @Override
    public UnbakedModel createUnbaked() {
        return new PickaxeGrayConcretePowderJungleMoldItemUnbakedModel();
    }
}
