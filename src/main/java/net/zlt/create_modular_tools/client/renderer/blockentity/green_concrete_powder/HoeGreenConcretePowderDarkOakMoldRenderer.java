package net.zlt.create_modular_tools.client.renderer.blockentity.green_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.green_concrete_powder.HoeGreenConcretePowderDarkOakMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class HoeGreenConcretePowderDarkOakMoldRenderer extends ToolGreenConcretePowderMoldRenderer<HoeGreenConcretePowderDarkOakMoldBlockEntity> {
    public HoeGreenConcretePowderDarkOakMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.HOE_GREEN_CONCRETE_POWDER_DARK_OAK_MOLD;
    }
}
