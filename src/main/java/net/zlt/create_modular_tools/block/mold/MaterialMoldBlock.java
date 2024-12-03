package net.zlt.create_modular_tools.block.mold;

import com.simibubi.create.content.fluids.tank.FluidTankBlock;
import net.fabricmc.fabric.api.entity.FakePlayer;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.zlt.create_modular_tools.AllTags;
import net.zlt.create_modular_tools.block.AllSoundTypes;
import net.zlt.create_modular_tools.block.entity.mold.ToolMaterialMoldBlockEntity;
import net.zlt.create_modular_tools.item.AllItemTags;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.AllToolModuleTypes;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;
import net.zlt.create_modular_tools.tool.module.ToolModuleTypeRegistry;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class MaterialMoldBlock extends HorizontalDirectionalBlock {
    public static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 4.0, 16.0);
    public static final VoxelShape COLLISION_SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 3.0, 16.0);
    public static final IntegerProperty LIGHT_LEVEL = FluidTankBlock.LIGHT_LEVEL;

    public MaterialMoldBlock(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH));
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

    @Override
    public void attack(BlockState state, Level level, BlockPos pos, Player player) {
        if (level.isClientSide || player instanceof FakePlayer) {
            return;
        }

        BlockEntity blockEntity = level.getBlockEntity(pos);

        level.destroyBlock(pos, false);
        if (level.getBlockState(pos) == state || player.isCreative()) {
            return;
        }

        if (blockEntity instanceof ToolMaterialMoldBlockEntity toolMaterialMoldBlockEntity) {
            player.getInventory().placeItemBackInInventory(getStack(toolMaterialMoldBlockEntity));
        } else {
            player.getInventory().placeItemBackInInventory(getStack());
        }
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState state) {
        return level.getBlockEntity(pos) instanceof ToolMaterialMoldBlockEntity toolMaterialMoldBlockEntity ? getStack(toolMaterialMoldBlockEntity) : new ItemStack(this);
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return COLLISION_SHAPE;
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }

    @Override
    public float getShadeBrightness(BlockState state, BlockGetter level, BlockPos pos) {
        return 1.0f;
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

    protected ItemStack getStack() {
        return new ItemStack(this);
    }

    protected ItemStack getStack(ToolMaterialMoldBlockEntity toolMaterialMoldBlockEntity) {
        ItemStack stack = new ItemStack(this);
        CompoundTag nbt = stack.getOrCreateTag();
        nbt.putUUID(AllTags.ITEM_STACK_UUID, UUID.randomUUID());
        CompoundTag blockEntityNbt = new CompoundTag();
        nbt.put(BlockItem.BLOCK_ENTITY_TAG, blockEntityNbt);
        blockEntityNbt.put(ToolMaterialMoldBlockEntity.TOOL_MODULES_TAG, toolMaterialMoldBlockEntity.getToolModulesNbt().copy());
        return stack;
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
