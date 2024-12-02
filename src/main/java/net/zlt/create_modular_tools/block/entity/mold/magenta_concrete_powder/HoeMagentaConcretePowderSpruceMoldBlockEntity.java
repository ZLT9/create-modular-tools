package net.zlt.create_modular_tools.block.entity.mold.magenta_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.entity.mold.HoeMaterialMoldBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class HoeMagentaConcretePowderSpruceMoldBlockEntity extends HoeMaterialMoldBlockEntity {
    public HoeMagentaConcretePowderSpruceMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.HOE_MAGENTA_CONCRETE_POWDER_SPRUCE_MOLD, pos, blockState);
    }
}
