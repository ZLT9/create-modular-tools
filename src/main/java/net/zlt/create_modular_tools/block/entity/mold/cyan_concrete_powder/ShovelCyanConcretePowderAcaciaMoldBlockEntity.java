package net.zlt.create_modular_tools.block.entity.mold.cyan_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.entity.mold.ShovelMaterialMoldBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ShovelCyanConcretePowderAcaciaMoldBlockEntity extends ShovelMaterialMoldBlockEntity {
    public ShovelCyanConcretePowderAcaciaMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.SHOVEL_CYAN_CONCRETE_POWDER_ACACIA_MOLD, pos, blockState);
    }
}
