package net.zlt.create_modular_tools.block.mold.light_blue_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.MaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class LightBlueConcretePowderDarkOakMoldBlock extends MaterialMoldBlock {
    public LightBlueConcretePowderDarkOakMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MaterialMoldBlock getSwordMoldBlock() {
        return AllMoldBlocks.SWORD_LIGHT_BLUE_CONCRETE_POWDER_DARK_OAK_MOLD;
    }

    @Override
    protected MaterialMoldBlock getShovelMoldBlock() {
        return AllMoldBlocks.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_DARK_OAK_MOLD;
    }

    @Override
    protected MaterialMoldBlock getPickaxeMoldBlock() {
        return AllMoldBlocks.PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_DARK_OAK_MOLD;
    }

    @Override
    protected MaterialMoldBlock getAxeMoldBlock() {
        return AllMoldBlocks.AXE_LIGHT_BLUE_CONCRETE_POWDER_DARK_OAK_MOLD;
    }

    @Override
    protected MaterialMoldBlock getHoeMoldBlock() {
        return AllMoldBlocks.HOE_LIGHT_BLUE_CONCRETE_POWDER_DARK_OAK_MOLD;
    }
}
