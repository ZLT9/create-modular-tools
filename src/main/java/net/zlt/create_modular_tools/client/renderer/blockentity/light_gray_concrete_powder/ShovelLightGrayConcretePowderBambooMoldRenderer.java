package net.zlt.create_modular_tools.client.renderer.blockentity.light_gray_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.light_gray_concrete_powder.ShovelLightGrayConcretePowderBambooMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ShovelLightGrayConcretePowderBambooMoldRenderer extends ToolLightGrayConcretePowderMoldRenderer<ShovelLightGrayConcretePowderBambooMoldBlockEntity> {
    public ShovelLightGrayConcretePowderBambooMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_BAMBOO_MOLD;
    }
}