package net.zlt.create_modular_tools.client.renderer.blockentity.blue_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.blue_concrete_powder.SwordBlueConcretePowderSpruceMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SwordBlueConcretePowderSpruceMoldRenderer extends ToolBlueConcretePowderMoldRenderer<SwordBlueConcretePowderSpruceMoldBlockEntity> {
    public SwordBlueConcretePowderSpruceMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.SWORD_BLUE_CONCRETE_POWDER_SPRUCE_MOLD;
    }
}
