package net.zlt.create_modular_tools.client.model.item.mold.orange_concrete_powder;

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
public abstract class ToolOrangeConcretePowderMoldItemUnbakedModel extends ToolMaterialMoldItemUnbakedModel {
    @Override
    protected ResourceLocation getTopTextureId() {
        return new ResourceLocation("minecraft", "block/orange_concrete_powder");
    }
}
