package net.zlt.create_modular_tools.block.entity.mold.green_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.entity.mold.ShovelMaterialMoldBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ShovelGreenConcretePowderAcaciaMoldBlockEntity extends ShovelMaterialMoldBlockEntity {
    public ShovelGreenConcretePowderAcaciaMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.SHOVEL_GREEN_CONCRETE_POWDER_ACACIA_MOLD, pos, blockState);
    }
}