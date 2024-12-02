package net.zlt.create_modular_tools.client.model.item.mold.sand;

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
public class SwordSandBambooMoldItemModelResolver extends SingleModelResolver {
    public static final ResourceLocation SWORD_SAND_BAMBOO_MOLD_MODEL_ID = CreateModularTools.asResource("item/sword_sand_bamboo_mold");

    @Override
    public ResourceLocation getModelId() {
        return SWORD_SAND_BAMBOO_MOLD_MODEL_ID;
    }

    @Override
    public UnbakedModel createUnbaked() {
        return new SwordSandBambooMoldItemUnbakedModel();
    }
}
