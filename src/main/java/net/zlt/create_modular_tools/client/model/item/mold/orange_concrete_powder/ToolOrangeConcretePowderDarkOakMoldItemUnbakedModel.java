package net.zlt.create_modular_tools.client.model.item.mold.orange_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;
import net.zlt.create_modular_tools.CreateModularTools;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class ToolOrangeConcretePowderDarkOakMoldItemUnbakedModel extends ToolOrangeConcretePowderMoldItemUnbakedModel {
    @Override
    protected ResourceLocation getMoldModelId() {
        return CreateModularTools.asResource("block/orange_concrete_powder_dark_oak_mold");
    }
}
