package net.zlt.create_modular_tools.client.renderer.blockentity.blue_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.blue_concrete_powder.HoeBlueConcretePowderCherryMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class HoeBlueConcretePowderCherryMoldRenderer extends ToolBlueConcretePowderMoldRenderer<HoeBlueConcretePowderCherryMoldBlockEntity> {
    public HoeBlueConcretePowderCherryMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.HOE_BLUE_CONCRETE_POWDER_CHERRY_MOLD;
    }
}
