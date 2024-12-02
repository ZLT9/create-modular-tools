package net.zlt.create_modular_tools.block.entity.mold.pink_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.entity.mold.PickaxeMaterialMoldBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PickaxePinkConcretePowderSpruceMoldBlockEntity extends PickaxeMaterialMoldBlockEntity {
    public PickaxePinkConcretePowderSpruceMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.PICKAXE_PINK_CONCRETE_POWDER_SPRUCE_MOLD, pos, blockState);
    }
}
