package net.zlt.create_modular_tools.client.renderer.blockentity.yellow_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.yellow_concrete_powder.ShovelYellowConcretePowderMangroveMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ShovelYellowConcretePowderMangroveMoldRenderer extends ToolYellowConcretePowderMoldRenderer<ShovelYellowConcretePowderMangroveMoldBlockEntity> {
    public ShovelYellowConcretePowderMangroveMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.SHOVEL_YELLOW_CONCRETE_POWDER_MANGROVE_MOLD;
    }
}
