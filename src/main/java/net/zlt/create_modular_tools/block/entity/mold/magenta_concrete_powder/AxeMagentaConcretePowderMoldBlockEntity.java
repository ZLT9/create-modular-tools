package net.zlt.create_modular_tools.block.entity.mold.magenta_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.entity.mold.AxeMaterialMoldBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AxeMagentaConcretePowderMoldBlockEntity extends AxeMaterialMoldBlockEntity {
    public AxeMagentaConcretePowderMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.AXE_MAGENTA_CONCRETE_POWDER_MOLD, pos, blockState);
    }
}
