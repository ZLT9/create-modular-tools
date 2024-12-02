package net.zlt.create_modular_tools.block.mold.purple_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;
import net.zlt.create_modular_tools.block.mold.MaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class ToolPurpleConcretePowderMangroveMoldBlock extends ToolMaterialMoldBlock {
    public ToolPurpleConcretePowderMangroveMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.PURPLE_CONCRETE_POWDER_MANGROVE_MOLD;
    }
}
