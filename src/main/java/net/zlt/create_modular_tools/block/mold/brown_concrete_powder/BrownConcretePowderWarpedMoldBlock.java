package net.zlt.create_modular_tools.block.mold.brown_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.zlt.create_modular_tools.block.AllBlocks;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class BrownConcretePowderWarpedMoldBlock extends BrownConcretePowderMoldBlock {
    public BrownConcretePowderWarpedMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected Block getMoldBlock() {
        return AllBlocks.WARPED_MOLD;
    }

    @Override
    protected ToolMaterialMoldBlock getSwordMoldBlock() {
        return AllMoldBlocks.SWORD_BROWN_CONCRETE_POWDER_WARPED_MOLD;
    }

    @Override
    protected ToolMaterialMoldBlock getShovelMoldBlock() {
        return AllMoldBlocks.SHOVEL_BROWN_CONCRETE_POWDER_WARPED_MOLD;
    }

    @Override
    protected ToolMaterialMoldBlock getPickaxeMoldBlock() {
        return AllMoldBlocks.PICKAXE_BROWN_CONCRETE_POWDER_WARPED_MOLD;
    }

    @Override
    protected ToolMaterialMoldBlock getAxeMoldBlock() {
        return AllMoldBlocks.AXE_BROWN_CONCRETE_POWDER_WARPED_MOLD;
    }

    @Override
    protected ToolMaterialMoldBlock getHoeMoldBlock() {
        return AllMoldBlocks.HOE_BROWN_CONCRETE_POWDER_WARPED_MOLD;
    }
}
