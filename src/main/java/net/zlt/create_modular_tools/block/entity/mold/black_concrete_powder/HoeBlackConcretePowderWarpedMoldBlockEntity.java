package net.zlt.create_modular_tools.block.entity.mold.black_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.entity.mold.HoeMaterialMoldBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class HoeBlackConcretePowderWarpedMoldBlockEntity extends HoeMaterialMoldBlockEntity {
    public HoeBlackConcretePowderWarpedMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.HOE_BLACK_CONCRETE_POWDER_WARPED_MOLD, pos, blockState);
    }
}