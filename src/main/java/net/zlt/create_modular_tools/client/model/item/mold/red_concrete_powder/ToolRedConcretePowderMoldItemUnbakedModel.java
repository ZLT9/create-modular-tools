package net.zlt.create_modular_tools.client.model.item.mold.red_concrete_powder;

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
public abstract class ToolRedConcretePowderMoldItemUnbakedModel extends ToolMaterialMoldItemUnbakedModel {
    @Override
    protected ResourceLocation getMoldModelId() {
        return CreateModularTools.asResource("block/red_concrete_powder_mold");
    }

    @Override
    protected ResourceLocation getTopTextureId() {
        return new ResourceLocation("minecraft", "block/red_concrete_powder");
    }
}
