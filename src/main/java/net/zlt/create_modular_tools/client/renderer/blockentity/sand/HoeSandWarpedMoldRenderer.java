package net.zlt.create_modular_tools.client.renderer.blockentity.sand;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.sand.HoeSandWarpedMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class HoeSandWarpedMoldRenderer extends ToolSandMoldRenderer<HoeSandWarpedMoldBlockEntity> {
    public HoeSandWarpedMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.HOE_SAND_WARPED_MOLD;
    }
}
