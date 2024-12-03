package net.zlt.create_modular_tools.client.model.item.mold.lime_concrete_powder;

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
public class AxeLimeConcretePowderBirchMoldItemModelResolver extends SingleModelResolver {
    public static final ResourceLocation AXE_LIME_CONCRETE_POWDER_BIRCH_MOLD_MODEL_ID = CreateModularTools.asResource("item/axe_lime_concrete_powder_birch_mold");

    @Override
    public ResourceLocation getModelId() {
        return AXE_LIME_CONCRETE_POWDER_BIRCH_MOLD_MODEL_ID;
    }

    @Override
    public UnbakedModel createUnbaked() {
        return new AxeLimeConcretePowderBirchMoldItemUnbakedModel();
    }
}