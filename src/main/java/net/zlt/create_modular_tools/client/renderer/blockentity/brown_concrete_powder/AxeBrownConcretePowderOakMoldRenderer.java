package net.zlt.create_modular_tools.client.renderer.blockentity.brown_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.brown_concrete_powder.AxeBrownConcretePowderOakMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AxeBrownConcretePowderOakMoldRenderer extends ToolBrownConcretePowderMoldRenderer<AxeBrownConcretePowderOakMoldBlockEntity> {
    public AxeBrownConcretePowderOakMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.AXE_BROWN_CONCRETE_POWDER_OAK_MOLD;
    }
}
