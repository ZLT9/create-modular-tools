package net.zlt.create_modular_tools.block.entity.mold.light_gray_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.entity.mold.ShovelMaterialMoldBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ShovelLightGrayConcretePowderJungleMoldBlockEntity extends ShovelMaterialMoldBlockEntity {
    public ShovelLightGrayConcretePowderJungleMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_JUNGLE_MOLD, pos, blockState);
    }
}
