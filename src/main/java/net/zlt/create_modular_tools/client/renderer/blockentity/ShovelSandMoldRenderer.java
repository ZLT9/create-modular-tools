package net.zlt.create_modular_tools.client.renderer.blockentity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.ShovelSandMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.BaseMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ShovelSandMoldRenderer extends BaseMoldRenderer<ShovelSandMoldBlockEntity> {
    public ShovelSandMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected BaseMoldBlock getMoldBlock() {
        return AllMoldBlocks.SHOVEL_SAND_MOLD;
    }
}
