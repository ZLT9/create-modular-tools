package net.zlt.create_modular_tools.block.entity.mold.blue_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.entity.mold.ShovelMaterialMoldBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ShovelBlueConcretePowderBirchMoldBlockEntity extends ShovelMaterialMoldBlockEntity {
    public ShovelBlueConcretePowderBirchMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.SHOVEL_BLUE_CONCRETE_POWDER_BIRCH_MOLD, pos, blockState);
    }
}
