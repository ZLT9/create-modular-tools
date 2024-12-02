package net.zlt.create_modular_tools.block.entity.mold.purple_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.entity.mold.PickaxeMaterialMoldBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PickaxePurpleConcretePowderJungleMoldBlockEntity extends PickaxeMaterialMoldBlockEntity {
    public PickaxePurpleConcretePowderJungleMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.PICKAXE_PURPLE_CONCRETE_POWDER_JUNGLE_MOLD, pos, blockState);
    }
}
