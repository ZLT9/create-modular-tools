package net.zlt.create_modular_tools.block.mold.light_gray_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.MoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class LightGrayConcretePowderMoldBlock extends MoldBlock {
    public LightGrayConcretePowderMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MoldBlock getSwordMoldBlock() {
        return AllMoldBlocks.SWORD_LIGHT_GRAY_CONCRETE_POWDER_MOLD;
    }

    @Override
    protected MoldBlock getShovelMoldBlock() {
        return AllMoldBlocks.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_MOLD;
    }

    @Override
    protected MoldBlock getPickaxeMoldBlock() {
        return AllMoldBlocks.PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_MOLD;
    }

    @Override
    protected MoldBlock getAxeMoldBlock() {
        return AllMoldBlocks.AXE_LIGHT_GRAY_CONCRETE_POWDER_MOLD;
    }

    @Override
    protected MoldBlock getHoeMoldBlock() {
        return AllMoldBlocks.HOE_LIGHT_GRAY_CONCRETE_POWDER_MOLD;
    }
}
