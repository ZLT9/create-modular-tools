package net.zlt.create_modular_tools.client.renderer.blockentity.green_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.green_concrete_powder.SwordGreenConcretePowderAcaciaMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SwordGreenConcretePowderAcaciaMoldRenderer extends ToolGreenConcretePowderMoldRenderer<SwordGreenConcretePowderAcaciaMoldBlockEntity> {
    public SwordGreenConcretePowderAcaciaMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.SWORD_GREEN_CONCRETE_POWDER_ACACIA_MOLD;
    }
}
