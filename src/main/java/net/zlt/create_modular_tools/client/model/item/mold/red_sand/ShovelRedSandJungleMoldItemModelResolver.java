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
public class ShovelRedSandJungleMoldItemModelResolver extends SingleModelResolver {
    public static final ResourceLocation SHOVEL_RED_SAND_JUNGLE_MOLD_MODEL_ID = CreateModularTools.asResource("item/shovel_red_sand_jungle_mold");

    @Override
    public ResourceLocation getModelId() {
        return SHOVEL_RED_SAND_JUNGLE_MOLD_MODEL_ID;
    }

    @Override
    public UnbakedModel createUnbaked() {
        return new ShovelRedSandJungleMoldItemUnbakedModel();
    }
}
