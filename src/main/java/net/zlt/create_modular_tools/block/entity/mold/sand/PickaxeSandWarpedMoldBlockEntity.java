package net.zlt.create_modular_tools.block.entity.mold.sand;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.entity.mold.PickaxeMaterialMoldBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PickaxeSandWarpedMoldBlockEntity extends PickaxeMaterialMoldBlockEntity {
    public PickaxeSandWarpedMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.PICKAXE_SAND_WARPED_MOLD, pos, blockState);
    }
}