package net.zlt.create_modular_tools.client.renderer.blockentity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.SwordSandMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.BaseMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SwordRedSandMoldRenderer extends BaseRedSandMoldRenderer<SwordSandMoldBlockEntity> {
    public SwordRedSandMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected BaseMoldBlock getMoldBlock() {
        return AllMoldBlocks.SWORD_RED_SAND_MOLD;
    }
}