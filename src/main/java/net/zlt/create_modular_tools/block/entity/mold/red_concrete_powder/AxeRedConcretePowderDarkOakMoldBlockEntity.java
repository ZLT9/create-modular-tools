package net.zlt.create_modular_tools.block.entity.mold.red_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.entity.mold.AxeMaterialMoldBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AxeRedConcretePowderDarkOakMoldBlockEntity extends AxeMaterialMoldBlockEntity {
    public AxeRedConcretePowderDarkOakMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.AXE_RED_CONCRETE_POWDER_DARK_OAK_MOLD, pos, blockState);
    }
}
