package net.zlt.create_modular_tools.client.model.item.mold.black_concrete_powder;

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
public class AxeBlackConcretePowderSpruceMoldItemModelResolver extends SingleModelResolver {
    public static final ResourceLocation AXE_BLACK_CONCRETE_POWDER_SPRUCE_MOLD_MODEL_ID = CreateModularTools.asResource("item/axe_black_concrete_powder_spruce_mold");

    @Override
    public ResourceLocation getModelId() {
        return AXE_BLACK_CONCRETE_POWDER_SPRUCE_MOLD_MODEL_ID;
    }

    @Override
    public UnbakedModel createUnbaked() {
        return new AxeBlackConcretePowderSpruceMoldItemUnbakedModel();
    }
}