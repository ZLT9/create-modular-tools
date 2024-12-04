package net.zlt.create_modular_tools.block.mold.green_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.zlt.create_modular_tools.block.AllBlocks;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class GreenConcretePowderWarpedMoldBlock extends GreenConcretePowderMoldBlock {
    public GreenConcretePowderWarpedMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected Block getMoldBlock() {
        return AllBlocks.WARPED_MOLD;
    }

    @Override
    protected ToolMaterialMoldBlock getSwordMoldBlock() {
        return AllMoldBlocks.SWORD_GREEN_CONCRETE_POWDER_WARPED_MOLD;
    }

    @Override
    protected ToolMaterialMoldBlock getShovelMoldBlock() {
        return AllMoldBlocks.SHOVEL_GREEN_CONCRETE_POWDER_WARPED_MOLD;
    }

    @Override
    protected ToolMaterialMoldBlock getPickaxeMoldBlock() {
        return AllMoldBlocks.PICKAXE_GREEN_CONCRETE_POWDER_WARPED_MOLD;
    }

    @Override
    protected ToolMaterialMoldBlock getAxeMoldBlock() {
        return AllMoldBlocks.AXE_GREEN_CONCRETE_POWDER_WARPED_MOLD;
    }

    @Override
    protected ToolMaterialMoldBlock getHoeMoldBlock() {
        return AllMoldBlocks.HOE_GREEN_CONCRETE_POWDER_WARPED_MOLD;
    }
}
