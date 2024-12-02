package net.zlt.create_modular_tools.client.renderer.blockentity.gray_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.gray_concrete_powder.ShovelGrayConcretePowderOakMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ShovelGrayConcretePowderOakMoldRenderer extends ToolGrayConcretePowderMoldRenderer<ShovelGrayConcretePowderOakMoldBlockEntity> {
    public ShovelGrayConcretePowderOakMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.SHOVEL_GRAY_CONCRETE_POWDER_OAK_MOLD;
    }
}
