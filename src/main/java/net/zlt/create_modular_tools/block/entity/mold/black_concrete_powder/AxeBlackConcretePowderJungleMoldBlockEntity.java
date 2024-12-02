package net.zlt.create_modular_tools.block.entity.mold.black_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.entity.mold.AxeMaterialMoldBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AxeBlackConcretePowderJungleMoldBlockEntity extends AxeMaterialMoldBlockEntity {
    public AxeBlackConcretePowderJungleMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.AXE_BLACK_CONCRETE_POWDER_JUNGLE_MOLD, pos, blockState);
    }
}
