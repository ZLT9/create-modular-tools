package net.zlt.create_modular_tools.block.entity.mold.red_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.entity.mold.HoeMaterialMoldBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class HoeRedConcretePowderCrimsonMoldBlockEntity extends HoeMaterialMoldBlockEntity {
    public HoeRedConcretePowderCrimsonMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.HOE_RED_CONCRETE_POWDER_CRIMSON_MOLD, pos, blockState);
    }
}
