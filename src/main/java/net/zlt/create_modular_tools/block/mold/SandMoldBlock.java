package net.zlt.create_modular_tools.block.mold;

import net.minecraft.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SandMoldBlock extends MoldBlock {
    public SandMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MoldBlock getSwordMoldBlock() {
        return AllMoldBlocks.SWORD_SAND_MOLD;
    }

    @Override
    protected MoldBlock getShovelMoldBlock() {
        return AllMoldBlocks.SHOVEL_SAND_MOLD;
    }

    @Override
    protected MoldBlock getPickaxeMoldBlock() {
        return AllMoldBlocks.PICKAXE_SAND_MOLD;
    }

    @Override
    protected MoldBlock getAxeMoldBlock() {
        return AllMoldBlocks.AXE_SAND_MOLD;
    }

    @Override
    protected MoldBlock getHoeMoldBlock() {
        return AllMoldBlocks.HOE_SAND_MOLD;
    }
}
