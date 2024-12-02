package net.zlt.create_modular_tools.block.entity.mold.yellow_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.entity.mold.SwordMaterialMoldBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SwordYellowConcretePowderBambooMoldBlockEntity extends SwordMaterialMoldBlockEntity {
    public SwordYellowConcretePowderBambooMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.SWORD_YELLOW_CONCRETE_POWDER_BAMBOO_MOLD, pos, blockState);
    }
}
