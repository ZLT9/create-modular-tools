package net.zlt.create_modular_tools.block.mold.brown_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;
import net.zlt.create_modular_tools.block.mold.MaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class ToolBrownConcretePowderAcaciaMoldBlock extends ToolMaterialMoldBlock {
    public ToolBrownConcretePowderAcaciaMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.BROWN_CONCRETE_POWDER_ACACIA_MOLD;
    }
}
