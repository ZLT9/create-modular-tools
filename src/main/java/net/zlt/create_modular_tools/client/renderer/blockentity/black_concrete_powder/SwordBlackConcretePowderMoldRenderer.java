package net.zlt.create_modular_tools.client.renderer.blockentity.black_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.black_concrete_powder.SwordBlackConcretePowderMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.BaseMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SwordBlackConcretePowderMoldRenderer extends BaseBlackConcretePowderMoldRenderer<SwordBlackConcretePowderMoldBlockEntity> {
    public SwordBlackConcretePowderMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected BaseMoldBlock getMoldBlock() {
        return AllMoldBlocks.SWORD_BLACK_CONCRETE_POWDER_MOLD;
    }
}