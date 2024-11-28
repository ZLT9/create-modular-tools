package net.zlt.create_modular_tools.client.model.item.mold;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;
import net.zlt.create_modular_tools.CreateModularTools;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class BaseRedSandMoldItemUnbakedModel extends BaseMoldItemUnbakedModel {
    @Override
    protected ResourceLocation getMoldModelId() {
        return CreateModularTools.asResource("block/red_sand_mold");
    }

    @Override
    protected ResourceLocation getTopTextureId() {
        return new ResourceLocation("minecraft", "block/red_sand");
    }
}
