package net.zlt.create_modular_tools.client.renderer.blockentity.light_blue_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.light_blue_concrete_powder.ShovelLightBlueConcretePowderMangroveMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ShovelLightBlueConcretePowderMangroveMoldRenderer extends ToolLightBlueConcretePowderMoldRenderer<ShovelLightBlueConcretePowderMangroveMoldBlockEntity> {
    public ShovelLightBlueConcretePowderMangroveMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_MANGROVE_MOLD;
    }
}
