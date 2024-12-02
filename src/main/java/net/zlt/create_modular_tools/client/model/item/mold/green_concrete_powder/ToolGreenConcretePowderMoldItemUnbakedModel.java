package net.zlt.create_modular_tools.client.model.item.mold.green_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.client.model.item.mold.ToolMaterialMoldItemUnbakedModel;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class ToolGreenConcretePowderMoldItemUnbakedModel extends ToolMaterialMoldItemUnbakedModel {
    @Override
    protected ResourceLocation getMoldModelId() {
        return CreateModularTools.asResource("block/green_concrete_powder_mold");
    }

    @Override
    protected ResourceLocation getTopTextureId() {
        return new ResourceLocation("minecraft", "block/green_concrete_powder");
    }
}
