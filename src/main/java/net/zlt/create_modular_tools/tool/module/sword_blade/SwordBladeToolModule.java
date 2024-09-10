package net.zlt.create_modular_tools.tool.module.sword_blade;

import io.github.fabricators_of_create.porting_lib.tool.ToolAction;
import io.github.fabricators_of_create.porting_lib.tool.ToolActions;
import net.fabricmc.fabric.api.mininglevel.v1.FabricMineableTags;
import net.fabricmc.fabric.api.mininglevel.v1.MiningLevelManager;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.tool.module.AllToolModuleTypes;
import net.zlt.create_modular_tools.tool.module.ToolModule;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class SwordBladeToolModule extends ToolModule {
    @Override
    public boolean isSuitableFor(BlockState blockState) {
        return blockState.is(Blocks.COBWEB) || blockState.is(FabricMineableTags.SWORD_MINEABLE) && getTierLevel() >= MiningLevelManager.getRequiredMiningLevel(blockState);
    }

    @Override
    public int getMiningDurabilityDamage() {
        return 2;
    }

    @Override
    public int getAttackDurabilityDamage() {
        return 1;
    }

    @Override
    public float getDestroySpeedBonus(BlockState blockState) {
        return blockState.is(Blocks.COBWEB) ? Math.max(15.0f, getBaseDestroySpeedBonus()) : blockState.is(BlockTags.SWORD_EFFICIENT) || blockState.is(FabricMineableTags.SWORD_MINEABLE) ? getBaseDestroySpeedBonus() : 0.0f;
    }

    @Override
    public float getBaseDestroySpeedBonus() {
        return 1.5f;
    }

    @Override
    public ToolModuleType getType() {
        return AllToolModuleTypes.SWORD_BLADE;
    }

    @Override
    public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
        return !player.isCreative();
    }

    @Override
    public boolean canPerformAction(ToolAction toolAction) {
        return ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction);
    }
}
