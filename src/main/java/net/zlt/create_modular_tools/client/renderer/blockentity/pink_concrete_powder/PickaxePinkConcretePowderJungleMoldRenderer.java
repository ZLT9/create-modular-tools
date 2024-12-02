package net.zlt.create_modular_tools.client.renderer.blockentity.pink_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.pink_concrete_powder.PickaxePinkConcretePowderJungleMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PickaxePinkConcretePowderJungleMoldRenderer extends ToolPinkConcretePowderMoldRenderer<PickaxePinkConcretePowderJungleMoldBlockEntity> {
    public PickaxePinkConcretePowderJungleMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.PICKAXE_PINK_CONCRETE_POWDER_JUNGLE_MOLD;
    }
}
