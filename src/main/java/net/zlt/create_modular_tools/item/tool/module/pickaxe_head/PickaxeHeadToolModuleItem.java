package net.zlt.create_modular_tools.item.tool.module.pickaxe_head;

import io.github.fabricators_of_create.porting_lib.tool.ToolAction;
import io.github.fabricators_of_create.porting_lib.tool.ToolActions;
import net.fabricmc.fabric.api.mininglevel.v1.MiningLevelManager;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.item.tool.module.BoomerangItem;
import net.zlt.create_modular_tools.tool.module.AllToolModuleTypes;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class PickaxeHeadToolModuleItem extends BoomerangItem {
    public PickaxeHeadToolModuleItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getMiningDurabilityDamageWhenAttached() {
        return 1;
    }

    @Override
    public int getAttackDurabilityDamageWhenAttached() {
        return 2;
    }

    @Override
    public boolean isSuitableForWhenAttached(BlockState blockState) {
        return blockState.is(BlockTags.MINEABLE_WITH_PICKAXE) && getTierLevel() >= MiningLevelManager.getRequiredMiningLevel(blockState);
    }

    @Override
    public float getDestroySpeedBonusWhenAttached(BlockState blockState) {
        return blockState.is(BlockTags.MINEABLE_WITH_PICKAXE) ? getBaseDestroySpeedBonusWhenAttached() : 0.0f;
    }

    @Override
    public ToolModuleType getType() {
        return AllToolModuleTypes.PICKAXE_HEAD;
    }

    @Override
    public boolean canPerformActionWhenAttached(ToolAction toolAction) {
        return ToolActions.DEFAULT_PICKAXE_ACTIONS.contains(toolAction);
    }
}
