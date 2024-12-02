package net.zlt.create_modular_tools.block.entity.mold.gray_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.entity.mold.ShovelMaterialMoldBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ShovelGrayConcretePowderBambooMoldBlockEntity extends ShovelMaterialMoldBlockEntity {
    public ShovelGrayConcretePowderBambooMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.SHOVEL_GRAY_CONCRETE_POWDER_BAMBOO_MOLD, pos, blockState);
    }
}
