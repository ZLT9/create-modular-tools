package net.zlt.create_modular_tools.block.mold.magenta_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.MaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class MagentaConcretePowderMangroveMoldBlock extends MaterialMoldBlock {
    public MagentaConcretePowderMangroveMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MaterialMoldBlock getSwordMoldBlock() {
        return AllMoldBlocks.SWORD_MAGENTA_CONCRETE_POWDER_MANGROVE_MOLD;
    }

    @Override
    protected MaterialMoldBlock getShovelMoldBlock() {
        return AllMoldBlocks.SHOVEL_MAGENTA_CONCRETE_POWDER_MANGROVE_MOLD;
    }

    @Override
    protected MaterialMoldBlock getPickaxeMoldBlock() {
        return AllMoldBlocks.PICKAXE_MAGENTA_CONCRETE_POWDER_MANGROVE_MOLD;
    }

    @Override
    protected MaterialMoldBlock getAxeMoldBlock() {
        return AllMoldBlocks.AXE_MAGENTA_CONCRETE_POWDER_MANGROVE_MOLD;
    }

    @Override
    protected MaterialMoldBlock getHoeMoldBlock() {
        return AllMoldBlocks.HOE_MAGENTA_CONCRETE_POWDER_MANGROVE_MOLD;
    }
}
