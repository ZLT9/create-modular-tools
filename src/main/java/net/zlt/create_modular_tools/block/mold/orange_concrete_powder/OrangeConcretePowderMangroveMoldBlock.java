package net.zlt.create_modular_tools.block.mold.orange_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.zlt.create_modular_tools.block.AllBlocks;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class OrangeConcretePowderMangroveMoldBlock extends OrangeConcretePowderMoldBlock {
    public OrangeConcretePowderMangroveMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected Block getMoldBlock() {
        return AllBlocks.MANGROVE_MOLD;
    }

    @Override
    protected ToolMaterialMoldBlock getSwordMoldBlock() {
        return AllMoldBlocks.SWORD_ORANGE_CONCRETE_POWDER_MANGROVE_MOLD;
    }

    @Override
    protected ToolMaterialMoldBlock getShovelMoldBlock() {
        return AllMoldBlocks.SHOVEL_ORANGE_CONCRETE_POWDER_MANGROVE_MOLD;
    }

    @Override
    protected ToolMaterialMoldBlock getPickaxeMoldBlock() {
        return AllMoldBlocks.PICKAXE_ORANGE_CONCRETE_POWDER_MANGROVE_MOLD;
    }

    @Override
    protected ToolMaterialMoldBlock getAxeMoldBlock() {
        return AllMoldBlocks.AXE_ORANGE_CONCRETE_POWDER_MANGROVE_MOLD;
    }

    @Override
    protected ToolMaterialMoldBlock getHoeMoldBlock() {
        return AllMoldBlocks.HOE_ORANGE_CONCRETE_POWDER_MANGROVE_MOLD;
    }
}
