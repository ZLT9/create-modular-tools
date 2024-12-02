package net.zlt.create_modular_tools.block.mold.cyan_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.MaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CyanConcretePowderBambooMoldBlock extends MaterialMoldBlock {
    public CyanConcretePowderBambooMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MaterialMoldBlock getSwordMoldBlock() {
        return AllMoldBlocks.SWORD_CYAN_CONCRETE_POWDER_BAMBOO_MOLD;
    }

    @Override
    protected MaterialMoldBlock getShovelMoldBlock() {
        return AllMoldBlocks.SHOVEL_CYAN_CONCRETE_POWDER_BAMBOO_MOLD;
    }

    @Override
    protected MaterialMoldBlock getPickaxeMoldBlock() {
        return AllMoldBlocks.PICKAXE_CYAN_CONCRETE_POWDER_BAMBOO_MOLD;
    }

    @Override
    protected MaterialMoldBlock getAxeMoldBlock() {
        return AllMoldBlocks.AXE_CYAN_CONCRETE_POWDER_BAMBOO_MOLD;
    }

    @Override
    protected MaterialMoldBlock getHoeMoldBlock() {
        return AllMoldBlocks.HOE_CYAN_CONCRETE_POWDER_BAMBOO_MOLD;
    }
}
