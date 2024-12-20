package net.zlt.create_modular_tools.block.entity.mold.orange_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.entity.mold.HoeMaterialMoldBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class HoeOrangeConcretePowderBirchMoldBlockEntity extends HoeMaterialMoldBlockEntity {
    public HoeOrangeConcretePowderBirchMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.HOE_ORANGE_CONCRETE_POWDER_BIRCH_MOLD, pos, blockState);
    }
}
