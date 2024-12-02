package net.zlt.create_modular_tools.block.mold.white_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;
import net.zlt.create_modular_tools.block.mold.MaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class ToolWhiteConcretePowderCherryMoldBlock extends ToolMaterialMoldBlock {
    public ToolWhiteConcretePowderCherryMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.WHITE_CONCRETE_POWDER_CHERRY_MOLD;
    }
}
