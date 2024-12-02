package net.zlt.create_modular_tools.block.entity.mold.light_blue_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.entity.mold.SwordMaterialMoldBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SwordLightBlueConcretePowderSpruceMoldBlockEntity extends SwordMaterialMoldBlockEntity {
    public SwordLightBlueConcretePowderSpruceMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.SWORD_LIGHT_BLUE_CONCRETE_POWDER_SPRUCE_MOLD, pos, blockState);
    }
}
