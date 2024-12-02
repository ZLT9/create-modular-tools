package net.zlt.create_modular_tools.client.model.item.mold.light_gray_concrete_powder;

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
public class HoeLightGrayConcretePowderMangroveMoldItemModelResolver extends SingleModelResolver {
    public static final ResourceLocation HOE_LIGHT_GRAY_CONCRETE_POWDER_MANGROVE_MOLD_MODEL_ID = CreateModularTools.asResource("item/hoe_light_gray_concrete_powder_mangrove_mold");

    @Override
    public ResourceLocation getModelId() {
        return HOE_LIGHT_GRAY_CONCRETE_POWDER_MANGROVE_MOLD_MODEL_ID;
    }

    @Override
    public UnbakedModel createUnbaked() {
        return new HoeLightGrayConcretePowderMangroveMoldItemUnbakedModel();
    }
}
