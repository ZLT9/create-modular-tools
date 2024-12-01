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
public class SwordRedSandSpruceMoldItemModelResolver extends SingleModelResolver {
    public static final ResourceLocation SWORD_RED_SAND_SPRUCE_MOLD_MODEL_ID = CreateModularTools.asResource("item/sword_red_sand_spruce_mold");

    @Override
    public ResourceLocation getModelId() {
        return SWORD_RED_SAND_SPRUCE_MOLD_MODEL_ID;
    }

    @Override
    public UnbakedModel createUnbaked() {
        return new SwordRedSandSpruceMoldItemUnbakedModel();
    }
}
