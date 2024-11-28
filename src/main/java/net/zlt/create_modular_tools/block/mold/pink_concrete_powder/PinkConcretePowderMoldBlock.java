package net.zlt.create_modular_tools.block.mold.pink_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.MoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PinkConcretePowderMoldBlock extends MoldBlock {
    public PinkConcretePowderMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MoldBlock getSwordMoldBlock() {
        return AllMoldBlocks.SWORD_PINK_CONCRETE_POWDER_MOLD;
    }

    @Override
    protected MoldBlock getShovelMoldBlock() {
        return AllMoldBlocks.SHOVEL_PINK_CONCRETE_POWDER_MOLD;
    }

    @Override
    protected MoldBlock getPickaxeMoldBlock() {
        return AllMoldBlocks.PICKAXE_PINK_CONCRETE_POWDER_MOLD;
    }

    @Override
    protected MoldBlock getAxeMoldBlock() {
        return AllMoldBlocks.AXE_PINK_CONCRETE_POWDER_MOLD;
    }

    @Override
    protected MoldBlock getHoeMoldBlock() {
        return AllMoldBlocks.HOE_PINK_CONCRETE_POWDER_MOLD;
    }
}
