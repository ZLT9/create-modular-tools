package net.zlt.create_modular_tools.block.mold.gray_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;
import net.zlt.create_modular_tools.block.mold.MaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class ToolGrayConcretePowderDarkOakMoldBlock extends ToolMaterialMoldBlock {
    public ToolGrayConcretePowderDarkOakMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.GRAY_CONCRETE_POWDER_DARK_OAK_MOLD;
    }
}