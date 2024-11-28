package net.zlt.create_modular_tools.block.entity.mold;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ShovelSandMoldBlockEntity extends ShovelMoldBlockEntity {
    public ShovelSandMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.SHOVEL_SAND_MOLD, pos, blockState);
    }
}
