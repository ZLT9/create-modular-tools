package net.zlt.create_modular_tools.block.mold.red_sand;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.MoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class RedSandMoldBlock extends MoldBlock {
    public RedSandMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MoldBlock getSwordMoldBlock() {
        return AllMoldBlocks.SWORD_RED_SAND_MOLD;
    }

    @Override
    protected MoldBlock getShovelMoldBlock() {
        return AllMoldBlocks.SHOVEL_RED_SAND_MOLD;
    }

    @Override
    protected MoldBlock getPickaxeMoldBlock() {
        return AllMoldBlocks.PICKAXE_RED_SAND_MOLD;
    }

    @Override
    protected MoldBlock getAxeMoldBlock() {
        return AllMoldBlocks.AXE_RED_SAND_MOLD;
    }

    @Override
    protected MoldBlock getHoeMoldBlock() {
        return AllMoldBlocks.HOE_RED_SAND_MOLD;
    }
}
