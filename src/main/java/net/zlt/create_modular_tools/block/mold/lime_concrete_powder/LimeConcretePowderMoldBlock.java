package net.zlt.create_modular_tools.block.mold.lime_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.MoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class LimeConcretePowderMoldBlock extends MoldBlock {
    public LimeConcretePowderMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MoldBlock getSwordMoldBlock() {
        return AllMoldBlocks.SWORD_LIME_CONCRETE_POWDER_MOLD;
    }

    @Override
    protected MoldBlock getShovelMoldBlock() {
        return AllMoldBlocks.SHOVEL_LIME_CONCRETE_POWDER_MOLD;
    }

    @Override
    protected MoldBlock getPickaxeMoldBlock() {
        return AllMoldBlocks.PICKAXE_LIME_CONCRETE_POWDER_MOLD;
    }

    @Override
    protected MoldBlock getAxeMoldBlock() {
        return AllMoldBlocks.AXE_LIME_CONCRETE_POWDER_MOLD;
    }

    @Override
    protected MoldBlock getHoeMoldBlock() {
        return AllMoldBlocks.HOE_LIME_CONCRETE_POWDER_MOLD;
    }
}
