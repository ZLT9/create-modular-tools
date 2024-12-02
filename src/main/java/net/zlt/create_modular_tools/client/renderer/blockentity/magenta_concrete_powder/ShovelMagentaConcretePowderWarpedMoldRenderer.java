package net.zlt.create_modular_tools.client.renderer.blockentity.magenta_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.magenta_concrete_powder.ShovelMagentaConcretePowderWarpedMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ShovelMagentaConcretePowderWarpedMoldRenderer extends ToolMagentaConcretePowderMoldRenderer<ShovelMagentaConcretePowderWarpedMoldBlockEntity> {
    public ShovelMagentaConcretePowderWarpedMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.SHOVEL_MAGENTA_CONCRETE_POWDER_WARPED_MOLD;
    }
}
