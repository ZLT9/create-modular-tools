package net.zlt.create_modular_tools.fluid;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.zlt.create_modular_tools.block.AllBlocks;
import net.zlt.create_modular_tools.item.AllItems;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class MoltenGoldFluid extends MoltenMetalFluid {
    @Override
    protected Block getBlock() {
        return AllBlocks.MOLTEN_GOLD;
    }

    @Override
    public Fluid getSource() {
        return AllFluids.MOLTEN_GOLD;
    }

    @Override
    public Fluid getFlowing() {
        return AllFluids.FLOWING_MOLTEN_GOLD;
    }

    @Override
    public Item getBucket() {
        return AllItems.MOLTEN_GOLD_BUCKET;
    }

    @Override
    public int getTickDelay(LevelReader level) {
        return level.dimensionType().ultraWarm() ? 5 : 15;
    }

    @Override
    @Nullable
    public Block solidify(Level level, BlockPos pos, BlockState state) {
        if (level.getFluidState(pos).isSource() && level.getBlockState(pos.below()).is(Blocks.HAY_BLOCK)) {
            for (Direction direction : LiquidBlock.POSSIBLE_FLOW_DIRECTIONS) {
                BlockPos blockPos = pos.relative(direction);
                if (level.getFluidState(blockPos).is(Fluids.LAVA)) {
                    return Blocks.DIAMOND_BLOCK;
                }
            }
        }
        return null;
    }

    @Override
    public Block solidifySourceByWater() {
        return Blocks.GOLD_BLOCK;
    }

    public static class Flowing extends MoltenGoldFluid {
        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }

        @Override
        public boolean isSource(FluidState state) {
            return false;
        }
    }

    public static class Source extends MoltenGoldFluid {
        @Override
        public int getAmount(FluidState state) {
            return 8;
        }

        @Override
        public boolean isSource(FluidState state) {
            return true;
        }
    }
}
