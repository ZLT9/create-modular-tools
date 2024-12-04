package net.zlt.create_modular_tools.block.mold.lime_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.zlt.create_modular_tools.block.AllBlocks;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.MaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class ToolLimeConcretePowderMangroveMoldBlock extends ToolLimeConcretePowderMoldBlock {
    public ToolLimeConcretePowderMangroveMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected Block getMoldBlock() {
        return AllBlocks.MANGROVE_MOLD;
    }

    @Override
    protected MaterialMoldBlock getMaterialMoldBlock() {
        return AllMoldBlocks.LIME_CONCRETE_POWDER_MANGROVE_MOLD;
    }
}
