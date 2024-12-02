package net.zlt.create_modular_tools.block.entity.mold.green_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.entity.mold.SwordMaterialMoldBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SwordGreenConcretePowderCherryMoldBlockEntity extends SwordMaterialMoldBlockEntity {
    public SwordGreenConcretePowderCherryMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.SWORD_GREEN_CONCRETE_POWDER_CHERRY_MOLD, pos, blockState);
    }
}
