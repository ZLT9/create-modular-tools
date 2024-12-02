package net.zlt.create_modular_tools.block.entity.mold.brown_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.entity.mold.AxeMaterialMoldBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AxeBrownConcretePowderMangroveMoldBlockEntity extends AxeMaterialMoldBlockEntity {
    public AxeBrownConcretePowderMangroveMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.AXE_BROWN_CONCRETE_POWDER_MANGROVE_MOLD, pos, blockState);
    }
}
