package net.zlt.create_modular_tools.client.model.item.mold.red_sand;

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
public class HoeRedSandSpruceMoldItemModelResolver extends SingleModelResolver {
    public static final ResourceLocation HOE_RED_SAND_SPRUCE_MOLD_MODEL_ID = CreateModularTools.asResource("item/hoe_red_sand_spruce_mold");

    @Override
    public ResourceLocation getModelId() {
        return HOE_RED_SAND_SPRUCE_MOLD_MODEL_ID;
    }

    @Override
    public UnbakedModel createUnbaked() {
        return new HoeRedSandSpruceMoldItemUnbakedModel();
    }
}
