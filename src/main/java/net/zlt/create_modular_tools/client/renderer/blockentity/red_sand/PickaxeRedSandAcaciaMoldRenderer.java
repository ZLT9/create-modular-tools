package net.zlt.create_modular_tools.client.renderer.blockentity.red_sand;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.red_sand.PickaxeRedSandAcaciaMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PickaxeRedSandAcaciaMoldRenderer extends ToolRedSandMoldRenderer<PickaxeRedSandAcaciaMoldBlockEntity> {
    public PickaxeRedSandAcaciaMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.PICKAXE_RED_SAND_ACACIA_MOLD;
    }
}
