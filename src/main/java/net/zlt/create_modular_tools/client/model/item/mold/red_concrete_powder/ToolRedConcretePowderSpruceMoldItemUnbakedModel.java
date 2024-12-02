package net.zlt.create_modular_tools.client.model.item.mold.red_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;
import net.zlt.create_modular_tools.CreateModularTools;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class ToolRedConcretePowderSpruceMoldItemUnbakedModel extends ToolRedConcretePowderMoldItemUnbakedModel {
    @Override
    protected ResourceLocation getMoldModelId() {
        return CreateModularTools.asResource("block/red_concrete_powder_spruce_mold");
    }
}
