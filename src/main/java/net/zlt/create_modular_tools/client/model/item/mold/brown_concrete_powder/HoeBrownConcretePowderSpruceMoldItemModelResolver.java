package net.zlt.create_modular_tools.client.model.item.mold.brown_concrete_powder;

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
public class HoeBrownConcretePowderSpruceMoldItemModelResolver extends SingleModelResolver {
    public static final ResourceLocation HOE_BROWN_CONCRETE_POWDER_SPRUCE_MOLD_MODEL_ID = CreateModularTools.asResource("item/hoe_brown_concrete_powder_spruce_mold");

    @Override
    public ResourceLocation getModelId() {
        return HOE_BROWN_CONCRETE_POWDER_SPRUCE_MOLD_MODEL_ID;
    }

    @Override
    public UnbakedModel createUnbaked() {
        return new HoeBrownConcretePowderSpruceMoldItemUnbakedModel();
    }
}