package net.zlt.create_modular_tools.client.renderer.blockentity.brown_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.brown_concrete_powder.AxeBrownConcretePowderJungleMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AxeBrownConcretePowderJungleMoldRenderer extends ToolBrownConcretePowderMoldRenderer<AxeBrownConcretePowderJungleMoldBlockEntity> {
    public AxeBrownConcretePowderJungleMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.AXE_BROWN_CONCRETE_POWDER_JUNGLE_MOLD;
    }
}
