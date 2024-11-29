package net.zlt.create_modular_tools.client.renderer.blockentity.green_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.green_concrete_powder.ShovelGreenConcretePowderMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.BaseMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ShovelGreenConcretePowderMoldRenderer extends BaseGreenConcretePowderMoldRenderer<ShovelGreenConcretePowderMoldBlockEntity> {
    public ShovelGreenConcretePowderMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected BaseMoldBlock getMoldBlock() {
        return AllMoldBlocks.SHOVEL_GREEN_CONCRETE_POWDER_MOLD;
    }
}