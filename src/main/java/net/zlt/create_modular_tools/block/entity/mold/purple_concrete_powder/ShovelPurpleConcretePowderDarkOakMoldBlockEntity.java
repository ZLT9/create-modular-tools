package net.zlt.create_modular_tools.block.entity.mold.purple_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.entity.mold.ShovelMaterialMoldBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ShovelPurpleConcretePowderDarkOakMoldBlockEntity extends ShovelMaterialMoldBlockEntity {
    public ShovelPurpleConcretePowderDarkOakMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.SHOVEL_PURPLE_CONCRETE_POWDER_DARK_OAK_MOLD, pos, blockState);
    }
}
