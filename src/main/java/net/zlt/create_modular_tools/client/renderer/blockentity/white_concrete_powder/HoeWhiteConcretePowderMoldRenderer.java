package net.zlt.create_modular_tools.client.renderer.blockentity.white_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.white_concrete_powder.HoeWhiteConcretePowderMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class HoeWhiteConcretePowderMoldRenderer extends ToolWhiteConcretePowderMoldRenderer<HoeWhiteConcretePowderMoldBlockEntity> {
    public HoeWhiteConcretePowderMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.HOE_WHITE_CONCRETE_POWDER_MOLD;
    }
}
