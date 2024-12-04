package net.zlt.create_modular_tools.block.mold.red_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.zlt.create_modular_tools.block.AllBlocks;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.MaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class ToolRedConcretePowderCherryMoldBlock extends ToolRedConcretePowderMoldBlock {
    public ToolRedConcretePowderCherryMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected Block getMoldBlock() {
        return AllBlocks.CHERRY_MOLD;
    }

    @Override
    protected MaterialMoldBlock getMaterialMoldBlock() {
        return AllMoldBlocks.RED_CONCRETE_POWDER_CHERRY_MOLD;
    }
}
