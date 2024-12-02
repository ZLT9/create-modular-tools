package net.zlt.create_modular_tools.block.mold.green_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;
import net.zlt.create_modular_tools.block.mold.MaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class ToolGreenConcretePowderBirchMoldBlock extends ToolMaterialMoldBlock {
    public ToolGreenConcretePowderBirchMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.GREEN_CONCRETE_POWDER_BIRCH_MOLD;
    }
}
