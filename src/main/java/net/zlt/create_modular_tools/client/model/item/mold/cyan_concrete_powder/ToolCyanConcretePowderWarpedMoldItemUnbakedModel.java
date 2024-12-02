package net.zlt.create_modular_tools.client.model.item.mold.cyan_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;
import net.zlt.create_modular_tools.CreateModularTools;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class ToolCyanConcretePowderWarpedMoldItemUnbakedModel extends ToolCyanConcretePowderMoldItemUnbakedModel {
    @Override
    protected ResourceLocation getMoldModelId() {
        return CreateModularTools.asResource("block/cyan_concrete_powder_warped_mold");
    }
}
