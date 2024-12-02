package net.zlt.create_modular_tools.client.renderer.blockentity.black_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.black_concrete_powder.ShovelBlackConcretePowderJungleMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ShovelBlackConcretePowderJungleMoldRenderer extends ToolBlackConcretePowderMoldRenderer<ShovelBlackConcretePowderJungleMoldBlockEntity> {
    public ShovelBlackConcretePowderJungleMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.SHOVEL_BLACK_CONCRETE_POWDER_JUNGLE_MOLD;
    }
}
