package net.zlt.create_modular_tools.block.entity.mold;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SwordSandMoldBlockEntity extends SwordMoldBlockEntity {
    public SwordSandMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.SWORD_SAND_MOLD, pos, blockState);
    }
}
