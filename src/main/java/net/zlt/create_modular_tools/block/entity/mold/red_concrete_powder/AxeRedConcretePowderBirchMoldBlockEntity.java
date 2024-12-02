package net.zlt.create_modular_tools.block.entity.mold.red_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.entity.mold.AxeMaterialMoldBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AxeRedConcretePowderBirchMoldBlockEntity extends AxeMaterialMoldBlockEntity {
    public AxeRedConcretePowderBirchMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.AXE_RED_CONCRETE_POWDER_BIRCH_MOLD, pos, blockState);
    }
}
