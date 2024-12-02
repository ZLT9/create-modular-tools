package net.zlt.create_modular_tools.block.entity.mold.purple_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.entity.mold.AxeMaterialMoldBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AxePurpleConcretePowderDarkOakMoldBlockEntity extends AxeMaterialMoldBlockEntity {
    public AxePurpleConcretePowderDarkOakMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.AXE_PURPLE_CONCRETE_POWDER_DARK_OAK_MOLD, pos, blockState);
    }
}
