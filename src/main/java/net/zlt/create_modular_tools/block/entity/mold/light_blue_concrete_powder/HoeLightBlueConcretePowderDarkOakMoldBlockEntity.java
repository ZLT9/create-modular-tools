package net.zlt.create_modular_tools.block.entity.mold.light_blue_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.entity.mold.HoeMaterialMoldBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class HoeLightBlueConcretePowderDarkOakMoldBlockEntity extends HoeMaterialMoldBlockEntity {
    public HoeLightBlueConcretePowderDarkOakMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.HOE_LIGHT_BLUE_CONCRETE_POWDER_DARK_OAK_MOLD, pos, blockState);
    }
}
