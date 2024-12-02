package net.zlt.create_modular_tools.block.mold.purple_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.MaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PurpleConcretePowderBirchMoldBlock extends MaterialMoldBlock {
    public PurpleConcretePowderBirchMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MaterialMoldBlock getSwordMoldBlock() {
        return AllMoldBlocks.SWORD_PURPLE_CONCRETE_POWDER_BIRCH_MOLD;
    }

    @Override
    protected MaterialMoldBlock getShovelMoldBlock() {
        return AllMoldBlocks.SHOVEL_PURPLE_CONCRETE_POWDER_BIRCH_MOLD;
    }

    @Override
    protected MaterialMoldBlock getPickaxeMoldBlock() {
        return AllMoldBlocks.PICKAXE_PURPLE_CONCRETE_POWDER_BIRCH_MOLD;
    }

    @Override
    protected MaterialMoldBlock getAxeMoldBlock() {
        return AllMoldBlocks.AXE_PURPLE_CONCRETE_POWDER_BIRCH_MOLD;
    }

    @Override
    protected MaterialMoldBlock getHoeMoldBlock() {
        return AllMoldBlocks.HOE_PURPLE_CONCRETE_POWDER_BIRCH_MOLD;
    }
}
