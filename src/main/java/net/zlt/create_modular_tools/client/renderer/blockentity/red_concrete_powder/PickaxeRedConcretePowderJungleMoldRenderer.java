package net.zlt.create_modular_tools.client.renderer.blockentity.red_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.red_concrete_powder.PickaxeRedConcretePowderJungleMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PickaxeRedConcretePowderJungleMoldRenderer extends ToolRedConcretePowderMoldRenderer<PickaxeRedConcretePowderJungleMoldBlockEntity> {
    public PickaxeRedConcretePowderJungleMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.PICKAXE_RED_CONCRETE_POWDER_JUNGLE_MOLD;
    }
}
