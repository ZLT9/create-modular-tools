package net.zlt.create_modular_tools.client.renderer.blockentity.yellow_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.yellow_concrete_powder.PickaxeYellowConcretePowderDarkOakMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PickaxeYellowConcretePowderDarkOakMoldRenderer extends ToolYellowConcretePowderMoldRenderer<PickaxeYellowConcretePowderDarkOakMoldBlockEntity> {
    public PickaxeYellowConcretePowderDarkOakMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.PICKAXE_YELLOW_CONCRETE_POWDER_DARK_OAK_MOLD;
    }
}
