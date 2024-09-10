package net.zlt.create_modular_tools.fluid;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

@MethodsReturnNonnullByDefault
public interface SolidifiableFluid {
    @Nullable
    default Block solidify(Level level, BlockPos pos, BlockState state) {
        return null;
    }

    default Block solidifySourceByWater() {
        return Blocks.OBSIDIAN;
    }

    default Block solidifyFlowingByWater() {
        return Blocks.COBBLESTONE;
    }

    default Block solidifyByBlueIceAndSoulSoil() {
        return Blocks.BASALT;
    }
}
