package net.zlt.create_modular_tools.block.entity.mold.green_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.entity.mold.AxeMaterialMoldBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AxeGreenConcretePowderAcaciaMoldBlockEntity extends AxeMaterialMoldBlockEntity {
    public AxeGreenConcretePowderAcaciaMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.AXE_GREEN_CONCRETE_POWDER_ACACIA_MOLD, pos, blockState);
    }
}
