package net.zlt.create_modular_tools.block.mold.light_gray_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;
import net.zlt.create_modular_tools.block.mold.MaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class ToolLightGrayConcretePowderWarpedMoldBlock extends ToolMaterialMoldBlock {
    public ToolLightGrayConcretePowderWarpedMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.LIGHT_GRAY_CONCRETE_POWDER_WARPED_MOLD;
    }
}
