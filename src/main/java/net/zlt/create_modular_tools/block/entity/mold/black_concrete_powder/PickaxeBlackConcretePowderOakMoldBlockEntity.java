package net.zlt.create_modular_tools.block.entity.mold.black_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.entity.mold.PickaxeMaterialMoldBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PickaxeBlackConcretePowderOakMoldBlockEntity extends PickaxeMaterialMoldBlockEntity {
    public PickaxeBlackConcretePowderOakMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.PICKAXE_BLACK_CONCRETE_POWDER_OAK_MOLD, pos, blockState);
    }
}
