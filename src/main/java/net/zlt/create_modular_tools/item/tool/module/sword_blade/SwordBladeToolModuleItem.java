package net.zlt.create_modular_tools.item.tool.module.sword_blade;

import io.github.fabricators_of_create.porting_lib.tool.ToolAction;
import io.github.fabricators_of_create.porting_lib.tool.ToolActions;
import net.fabricmc.fabric.api.mininglevel.v1.FabricMineableTags;
import net.fabricmc.fabric.api.mininglevel.v1.MiningLevelManager;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.item.tool.module.ToolModuleItem;
import net.zlt.create_modular_tools.tool.module.AllToolModuleTypes;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class SwordBladeToolModuleItem extends ToolModuleItem {
    public SwordBladeToolModuleItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isSuitableForWhenAttached(BlockState blockState) {
        return blockState.is(Blocks.COBWEB) || blockState.is(FabricMineableTags.SWORD_MINEABLE) && getTierLevel() >= MiningLevelManager.getRequiredMiningLevel(blockState);
    }

    @Override
    public int getMiningDurabilityDamageWhenAttached() {
        return 2;
    }

    @Override
    public int getAttackDurabilityDamageWhenAttached() {
        return 1;
    }

    @Override
    public float getDestroySpeedBonusWhenAttached(BlockState blockState) {
        return blockState.is(Blocks.COBWEB) ? Math.max(15.0f, getBaseDestroySpeedBonusWhenAttached()) : blockState.is(BlockTags.SWORD_EFFICIENT) || blockState.is(FabricMineableTags.SWORD_MINEABLE) ? getBaseDestroySpeedBonusWhenAttached() : 0.0f;
    }

    @Override
    public float getBaseDestroySpeedBonusWhenAttached() {
        return 1.5f;
    }

    @Override
    public ToolModuleType getType() {
        return AllToolModuleTypes.SWORD_BLADE;
    }

    @Override
    public boolean canAttackBlockWhenAttached(BlockState state, Level level, BlockPos pos, Player player) {
        return !player.isCreative();
    }

    @Override
    public boolean canPerformActionWhenAttached(ToolAction toolAction) {
        return ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return super.canApplyAtEnchantingTable(stack, enchantment) ||
            enchantment == Enchantments.SHARPNESS ||
            enchantment == Enchantments.SMITE ||
            enchantment == Enchantments.BANE_OF_ARTHROPODS ||
            enchantment == Enchantments.KNOCKBACK ||
            enchantment == Enchantments.FIRE_ASPECT ||
            enchantment == Enchantments.MOB_LOOTING ||
            enchantment == Enchantments.SWEEPING_EDGE ||
            enchantment == Enchantments.UNBREAKING ||
            enchantment == Enchantments.MENDING ||
            enchantment == Enchantments.VANISHING_CURSE;
    }
}
