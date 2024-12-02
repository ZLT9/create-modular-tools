package net.zlt.create_modular_tools.client.model.item.mold.light_blue_concrete_powder;

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
public class HoeLightBlueConcretePowderBambooMoldItemModelResolver extends SingleModelResolver {
    public static final ResourceLocation HOE_LIGHT_BLUE_CONCRETE_POWDER_BAMBOO_MOLD_MODEL_ID = CreateModularTools.asResource("item/hoe_light_blue_concrete_powder_bamboo_mold");

    @Override
    public ResourceLocation getModelId() {
        return HOE_LIGHT_BLUE_CONCRETE_POWDER_BAMBOO_MOLD_MODEL_ID;
    }

    @Override
    public UnbakedModel createUnbaked() {
        return new HoeLightBlueConcretePowderBambooMoldItemUnbakedModel();
    }
}
