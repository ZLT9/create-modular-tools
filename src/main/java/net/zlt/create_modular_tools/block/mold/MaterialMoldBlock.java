package net.zlt.create_modular_tools.block.mold;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.zlt.create_modular_tools.block.MoldBlock;
import net.zlt.create_modular_tools.block.entity.mold.ToolMaterialMoldBlockEntity;
import net.zlt.create_modular_tools.item.AllItemTags;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.AllToolModuleTypes;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;
import net.zlt.create_modular_tools.tool.module.ToolModuleTypeRegistry;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class MaterialMoldBlock extends MoldBlock {
    public MaterialMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);
        if (stack.isEmpty()) {
            return InteractionResult.PASS;
        }

        Block result;
        List<ToolModuleType> additionalSlots = new ArrayList<>();
        boolean isModularTool = stack.getItem() instanceof ModularToolItem;

        if (stack.is(AllItemTags.SWORDS_FOR_MOLDS)) {
            result = getSwordMoldBlock();

            if (!isModularTool) {
                additionalSlots.add(AllToolModuleTypes.SWORD_POMMEL);
                additionalSlots.add(AllToolModuleTypes.SWORD_GUARD);
            }
        } else if (stack.is(AllItemTags.SHOVELS_FOR_MOLDS)) {
            result = getShovelMoldBlock();

            if (!isModularTool) {
                additionalSlots.add(AllToolModuleTypes.TOOL_GRIP);
            }
        } else if (stack.is(AllItemTags.PICKAXES_FOR_MOLDS)) {
            result = getPickaxeMoldBlock();
        } else if (stack.is(AllItemTags.AXES_FOR_MOLDS)) {
            result = getAxeMoldBlock();
        } else if (stack.is(AllItemTags.HOES_FOR_MOLDS)) {
            result = getHoeMoldBlock();
        } else {
            return InteractionResult.PASS;
        }

        if (!level.isClientSide) {
            if (result != this) {
                level.destroyBlock(pos, false);
            }
            level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
            level.setBlock(pos, result.defaultBlockState().setValue(FACING, player.getDirection().getOpposite()), 3);
            if (level.getBlockEntity(pos) instanceof ToolMaterialMoldBlockEntity toolMaterialMoldBlockEntity) {
                toolMaterialMoldBlockEntity.clearToolModules();
                if (isModularTool) {
                    CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(stack);
                    if (!toolModulesNbt.isEmpty()) {
                        for (String toolModuleTypeTag : toolModulesNbt.getAllKeys()) {
                            ToolModuleType toolModuleType = ToolModuleTypeRegistry.get(toolModuleTypeTag);
                            if (toolModuleType != null) {
                                toolMaterialMoldBlockEntity.putToolModule(toolModuleType, null, null);
                            }
                        }
                    }
                }
                for (ToolModuleType toolModuleType : additionalSlots) {
                    toolMaterialMoldBlockEntity.putToolModule(toolModuleType, null, null);
                }
            }
        }

        level.playSound(player, pos, SoundEvents.SAND_PLACE, SoundSource.BLOCKS, 0.25f, 0.8f);

        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    protected abstract MaterialMoldBlock getSwordMoldBlock();

    protected abstract MaterialMoldBlock getShovelMoldBlock();

    protected abstract MaterialMoldBlock getPickaxeMoldBlock();

    protected abstract MaterialMoldBlock getAxeMoldBlock();

    protected abstract MaterialMoldBlock getHoeMoldBlock();
}
