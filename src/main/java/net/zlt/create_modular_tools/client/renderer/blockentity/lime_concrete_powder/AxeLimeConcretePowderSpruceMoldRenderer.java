package net.zlt.create_modular_tools.client.renderer.blockentity.lime_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.lime_concrete_powder.AxeLimeConcretePowderSpruceMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AxeLimeConcretePowderSpruceMoldRenderer extends ToolLimeConcretePowderMoldRenderer<AxeLimeConcretePowderSpruceMoldBlockEntity> {
    public AxeLimeConcretePowderSpruceMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.AXE_LIME_CONCRETE_POWDER_SPRUCE_MOLD;
    }
}
