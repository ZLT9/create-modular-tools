package net.zlt.create_modular_tools.block.mold;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.block.entity.mold.PickaxeSandMoldBlockEntity;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PickaxeSandMoldBlock extends BaseSandMoldBlock {
    private static final List<ToolModuleType> REQUIRED = new ArrayList<>();
    private static final TreeSet<ToolModuleType> COMPATIBLE = new TreeSet<>(Comparator.comparingInt(ToolModuleType::getLayer).thenComparing(ToolModuleType::getTag));

    public PickaxeSandMoldBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(LIGHT_LEVEL, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(LIGHT_LEVEL);
    }

    @Override
    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PickaxeSandMoldBlockEntity(pos, state);
    }

    public static void addCompatible(ToolModuleType toolModuleType) {
        if (COMPATIBLE.contains(toolModuleType)) {
            CreateModularTools.LOGGER.error("The given tool module type is already compatible with this mold: {}", toolModuleType);
            throw new IllegalArgumentException();
        }

        COMPATIBLE.add(toolModuleType);
    }

    public static void addCompatible(ToolModuleType... toolModuleTypes) {
        for (ToolModuleType toolModuleType : toolModuleTypes) {
            addCompatible(toolModuleType);
        }
    }

    public static void addRequired(ToolModuleType toolModuleType) {
        if (REQUIRED.contains(toolModuleType)) {
            CreateModularTools.LOGGER.error("The given tool module type is already required by this mold: {}", toolModuleType);
            throw new IllegalArgumentException();
        }

        REQUIRED.add(toolModuleType);
        addCompatible(toolModuleType);
    }

    public static void addRequired(ToolModuleType... toolModuleTypes) {
        for (ToolModuleType toolModuleType : toolModuleTypes) {
            addRequired(toolModuleType);
        }
    }

    public static boolean s_isCompatible(ToolModuleType toolModuleType) {
        return COMPATIBLE.contains(toolModuleType);
    }

    public static boolean s_isRequired(ToolModuleType toolModuleType) {
        return REQUIRED.contains(toolModuleType);
    }

    @Unmodifiable
    public static TreeSet<ToolModuleType> s_getCompatible() {
        return COMPATIBLE;
    }

    @Unmodifiable
    public static List<ToolModuleType> s_getRequired() {
        return REQUIRED;
    }

    @Override
    @Unmodifiable
    public TreeSet<ToolModuleType> getCompatible() {
        return COMPATIBLE;
    }

    @Override
    @Unmodifiable
    public List<ToolModuleType> getRequired() {
        return REQUIRED;
    }
}
