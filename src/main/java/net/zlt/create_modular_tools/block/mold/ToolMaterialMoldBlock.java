package net.zlt.create_modular_tools.block.mold;

import com.simibubi.create.content.fluids.tank.FluidTankBlock;
import com.simibubi.create.content.kinetics.deployer.DeployerFakePlayer;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.zlt.create_modular_tools.AllTagNames;
import net.zlt.create_modular_tools.block.entity.mold.ToolMaterialMoldBlockEntity;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.item.tool.module.ToolModuleItem;
import net.zlt.create_modular_tools.mold.MoldRegistry;
import net.zlt.create_modular_tools.sound.AllSoundEvents;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class ToolMaterialMoldBlock extends MaterialMoldBlock implements EntityBlock {
    public static final IntegerProperty LIGHT_LEVEL = FluidTankBlock.LIGHT_LEVEL;

    public ToolMaterialMoldBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(LIGHT_LEVEL, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(LIGHT_LEVEL);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!(level.getBlockEntity(pos) instanceof ToolMaterialMoldBlockEntity toolMaterialMoldBlockEntity)) {
            return InteractionResult.PASS;
        }

        ItemStack stack = player.getItemInHand(hand);
        if (!stack.isEmpty()) {
            CompoundTag toolModulesNbt = toolMaterialMoldBlockEntity.getToolModulesNbt();

            if (stack.getItem() instanceof ToolModuleItem toolModule) {
                if (!MoldRegistry.isCompatible(getModularTool(), toolModule.getType())) {
                    return InteractionResult.PASS;
                }

                if (!toolModulesNbt.contains(toolModule.getType().getTag(), Tag.TAG_COMPOUND)) {
                    for (String toolModuleTypeTag : toolModulesNbt.getAllKeys()) {
                        if (ToolUtils.MoldSlotState.fromName(toolModulesNbt.getCompound(toolModuleTypeTag).getString(AllTagNames.MOLD_SLOT_STATE)) == ToolUtils.MoldSlotState.FLUID) {
                            return InteractionResult.PASS;
                        }
                    }
                }

                ToolUtils.MoldSlot moldSlot = ToolUtils.getMoldSlot(toolModulesNbt, toolModule.getType());
                if (moldSlot.state() == ToolUtils.MoldSlotState.FLUID) {
                    return InteractionResult.PASS;
                }

                if (!level.isClientSide) {
                    if (!player.isCreative()) {
                        stack.shrink(1);
                        if (moldSlot.state() == ToolUtils.MoldSlotState.SOLID && moldSlot.contents() != null) {
                            ItemStack returnedToolModuleStack = ((ToolModuleItem) moldSlot.contents()).getDefaultInstance();
                            returnedToolModuleStack.setTag(moldSlot.tag());
                            player.getInventory().placeItemBackInInventory(returnedToolModuleStack);
                        }
                    }
                    toolMaterialMoldBlockEntity.putToolModule(toolModule.getType(), toolModule, stack.getTag());
                }

                SoundEvent toolModuleSound = toolModule.getSound();
                if (toolModuleSound != null) {
                    level.playSound(player, pos, toolModuleSound, SoundSource.BLOCKS, 0.5f, 0.8f);
                }

                boolean isNewToolModuleEnchanted = stack.isEnchanted();
                if (isNewToolModuleEnchanted) {
                    level.playSound(player, pos, AllSoundEvents.ENCHANTED_TOOL_MODULE, SoundSource.BLOCKS, 0.5f, 0.8f);
                }

                playMoldSlotSound(level, pos, player, moldSlot.state() == ToolUtils.MoldSlotState.SOLID, isNewToolModuleEnchanted ? null : moldSlot.tag());

                return InteractionResult.sidedSuccess(level.isClientSide);
            }

            for (String toolModuleTypeTag : toolModulesNbt.getAllKeys()) {
                if (ToolUtils.MoldSlotState.fromName(toolModulesNbt.getCompound(toolModuleTypeTag).getString(AllTagNames.MOLD_SLOT_STATE)) != ToolUtils.MoldSlotState.EMPTY) {
                    return InteractionResult.PASS;
                }
            }

            return super.use(state, level, pos, player, hand, hit);
        }

        HitCoords hitCoords = getHitCoords(pos, state.getValue(FACING), hit);
        if (hitCoords == null) {
            return InteractionResult.PASS;
        }

        CompoundTag toolModulesNbt = toolMaterialMoldBlockEntity.getToolModulesNbt();

        List<ToolModuleType> existingToolModuleTypes = new ArrayList<>();
        Iterator<ToolModuleType> it = MoldRegistry.getCompatible(getModularTool()).descendingIterator();
        while (it.hasNext()) {
            ToolModuleType toolModuleType = it.next();

            ToolUtils.MoldSlot moldSlot = ToolUtils.getMoldSlot(toolModulesNbt, toolModuleType);
            if (moldSlot.state() == ToolUtils.MoldSlotState.ABSENT) {
                continue;
            }

            if (moldSlot.state() == ToolUtils.MoldSlotState.FLUID) {
                return InteractionResult.PASS;
            }

            existingToolModuleTypes.add(toolModuleType);
        }

        boolean isDeployer = player instanceof DeployerFakePlayer;
        for (ToolModuleType toolModuleType : existingToolModuleTypes) {
            ToolModuleType.MoldTopTexture moldTopTexture = toolModuleType.getMoldTopTexture(this, toolModulesNbt);
            if (moldTopTexture == null) {
                continue;
            }

            ToolUtils.MoldSlot moldSlot = ToolUtils.getMoldSlot(toolModulesNbt, toolModuleType);

            if (moldSlot.state() == ToolUtils.MoldSlotState.EMPTY && (isDeployer || MoldRegistry.isRequired(getModularTool(), toolModuleType))) {
                continue;
            }

            if (!isDeployer && !moldTopTexture.clicked(hitCoords.X, hitCoords.Y)) {
                continue;
            }

            if (!level.isClientSide) {
                if (moldSlot.state() == ToolUtils.MoldSlotState.EMPTY) {
                    toolMaterialMoldBlockEntity.removeToolModule(toolModuleType);
                } else if (moldSlot.state() == ToolUtils.MoldSlotState.SOLID) {
                    toolMaterialMoldBlockEntity.putToolModule(toolModuleType, null, null);

                    if (!player.isCreative() && moldSlot.contents() != null) {
                        ItemStack returnedToolModuleStack = ((ToolModuleItem) moldSlot.contents()).getDefaultInstance();
                        returnedToolModuleStack.setTag(moldSlot.tag());
                        player.getInventory().placeItemBackInInventory(returnedToolModuleStack);
                    }
                }
            }

            playMoldSlotSound(level, pos, player, moldSlot.state() == ToolUtils.MoldSlotState.SOLID, moldSlot.tag());

            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        for (ToolModuleType toolModuleType : existingToolModuleTypes) {
            ToolUtils.MoldSlot moldSlot = ToolUtils.getMoldSlot(toolModulesNbt, toolModuleType);
            if (moldSlot.state() != ToolUtils.MoldSlotState.EMPTY) {
                return InteractionResult.PASS;
            }
        }

        if (!level.isClientSide) {
            Block result = getMaterialMoldBlock();
            if (result != this) {
                level.destroyBlock(pos, false);
            }
            level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
            level.setBlock(pos, result.defaultBlockState().setValue(FACING, player.getDirection().getOpposite()), 3);
        }

        level.playSound(player, pos, SoundEvents.SAND_PLACE, SoundSource.BLOCKS, 0.25f, 0.8f);

        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState state) {
        return level.getBlockEntity(pos) instanceof ToolMaterialMoldBlockEntity toolMaterialMoldBlockEntity ? getStack(toolMaterialMoldBlockEntity) : new ItemStack(this);
    }

    @Override
    public void attack(BlockState state, Level level, BlockPos pos, Player player) {
        if (!(level.getBlockEntity(pos) instanceof ToolMaterialMoldBlockEntity toolMaterialMoldBlockEntity)) {
            super.attack(state, level, pos, player);
            return;
        }

        if (level.isClientSide) {
            return;
        }

        level.destroyBlock(pos, false);
        if (level.getBlockState(pos) == state || player.isCreative()) {
            return;
        }

        player.getInventory().placeItemBackInInventory(getStack(toolMaterialMoldBlockEntity));
    }

    @Override
    protected ToolMaterialMoldBlock getSwordMoldBlock() {
        return getMaterialMoldBlock().getSwordMoldBlock();
    }

    @Override
    protected ToolMaterialMoldBlock getShovelMoldBlock() {
        return getMaterialMoldBlock().getShovelMoldBlock();
    }

    @Override
    protected ToolMaterialMoldBlock getPickaxeMoldBlock() {
        return getMaterialMoldBlock().getPickaxeMoldBlock();
    }

    @Override
    protected ToolMaterialMoldBlock getAxeMoldBlock() {
        return getMaterialMoldBlock().getAxeMoldBlock();
    }

    @Override
    protected ToolMaterialMoldBlock getHoeMoldBlock() {
        return getMaterialMoldBlock().getHoeMoldBlock();
    }

    public static void playMoldSlotSound(Level level, BlockPos pos, @Nullable Player player, boolean isReplacing, @Nullable CompoundTag previousContentsNbt) {
        level.playSound(player, pos, SoundEvents.SAND_PLACE, SoundSource.BLOCKS, 0.25f, 0.8f);

        if (isReplacing) {
            level.playSound(player, pos, SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 0.2f, 1.0f + level.random.nextFloat());

            if (previousContentsNbt != null && !previousContentsNbt.getList(ItemStack.TAG_ENCH, CompoundTag.TAG_COMPOUND).isEmpty()) {
                level.playSound(player, pos, AllSoundEvents.ENCHANTED_TOOL_MODULE, SoundSource.BLOCKS, 0.5f, 0.8f);
            }
        }
    }

    public abstract ModularToolItem getModularTool();

    protected abstract MaterialMoldBlock getMaterialMoldBlock();

    protected ItemStack getStack(ToolMaterialMoldBlockEntity toolMaterialMoldBlockEntity) {
        ItemStack stack = new ItemStack(this);
        CompoundTag nbt = stack.getOrCreateTag();
        nbt.putUUID(AllTagNames.ITEM_STACK_UNIQUE_ID, UUID.randomUUID());
        CompoundTag blockEntityNbt = new CompoundTag();
        nbt.put(BlockItem.BLOCK_ENTITY_TAG, blockEntityNbt);
        blockEntityNbt.put(ToolMaterialMoldBlockEntity.TOOL_MODULES_TAG, toolMaterialMoldBlockEntity.getToolModulesNbt().copy());
        return stack;
    }

    @Nullable
    protected static HitCoords getHitCoords(BlockPos pos, Direction facing, BlockHitResult hitResult) {
        if (hitResult.getDirection() != Direction.UP || !Direction.Plane.HORIZONTAL.test(facing)) {
            return null;
        }
        Vec3 hitLocation = hitResult.getLocation();
        double hitX = hitLocation.x - pos.getX();
        double hitY = hitLocation.z - pos.getZ();
        if (facing == Direction.WEST) {
            double oldHitX = hitX;
            hitX = hitY;
            hitY = 1.0 - oldHitX;
        } else if (facing == Direction.NORTH) {
            hitX = 1.0 - hitX;
            hitY = 1.0 - hitY;
        } else if (facing == Direction.EAST) {
            double oldHitZ = hitY;
            hitY = hitX;
            hitX = 1.0 - oldHitZ;
        }
        return new HitCoords((int) (hitX * 16.0), (int) (hitY * 16.0));
    }

    public static class HitCoords {
        public final int X;
        public final int Y;

        public HitCoords(int x, int y) {
            X = x;
            Y = y;
        }
    }
}
