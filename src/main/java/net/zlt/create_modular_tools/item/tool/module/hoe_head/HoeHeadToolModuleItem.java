package net.zlt.create_modular_tools.item.tool.module.hoe_head;

import io.github.fabricators_of_create.porting_lib.tool.ToolAction;
import io.github.fabricators_of_create.porting_lib.tool.ToolActions;
import net.fabricmc.fabric.api.mininglevel.v1.MiningLevelManager;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.item.tool.module.ToolModuleItem;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.AllToolModuleTypes;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class HoeHeadToolModuleItem extends ToolModuleItem {
    public HoeHeadToolModuleItem(Properties properties) {
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
        return blockState.is(BlockTags.MINEABLE_WITH_HOE) && getTierLevel() >= MiningLevelManager.getRequiredMiningLevel(blockState);
    }

    @Override
    public float getDestroySpeedBonusWhenAttached(BlockState blockState) {
        return blockState.is(BlockTags.MINEABLE_WITH_HOE) ? getBaseDestroySpeedBonusWhenAttached() : 0.0f;
    }

    @Override
    public ToolModuleType getType() {
        return AllToolModuleTypes.HOE_HEAD;
    }

    @Override
    public boolean canPerformActionWhenAttached(ToolAction toolAction) {
        return ToolActions.DEFAULT_HOE_ACTIONS.contains(toolAction);
    }

    @Override
    public InteractionResult useOnWhenAttached(BlockState originalBlockState, UseOnContext context, ModularToolItem modularTool) {
        return ToolUtils.hoeOnUse(originalBlockState, context, modularTool);
    }

    @Override
    public boolean canApplyEnchantment(Enchantment enchantment) {
        return enchantment == Enchantments.BLOCK_EFFICIENCY ||
            enchantment == Enchantments.SILK_TOUCH ||
            enchantment == Enchantments.UNBREAKING ||
            enchantment == Enchantments.BLOCK_FORTUNE ||
            enchantment == Enchantments.MENDING ||
            enchantment == Enchantments.VANISHING_CURSE;
    }
}
