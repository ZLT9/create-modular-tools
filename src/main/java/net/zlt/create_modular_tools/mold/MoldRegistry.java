package net.zlt.create_modular_tools.mold;

import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;
import org.jetbrains.annotations.Unmodifiable;

import java.util.*;

public final class MoldRegistry {
    private MoldRegistry() {
    }

    private static final Map<ModularToolItem, Set<ToolModuleType>> REQUIRED_TOOL_MODULE_TYPES = new HashMap<>();
    private static final Map<ModularToolItem, TreeSet<ToolModuleType>> COMPATIBLE_TOOL_MODULE_TYPES = new HashMap<>();

    public static void addRequired(ModularToolItem modularTool, ToolModuleType... toolModuleTypes) {
        Collections.addAll(REQUIRED_TOOL_MODULE_TYPES.computeIfAbsent(modularTool, modularToolItem -> new HashSet<>()), toolModuleTypes);
        addCompatible(modularTool, toolModuleTypes);
    }

    public static void addCompatible(ModularToolItem modularTool, ToolModuleType... toolModuleTypes) {
        Collections.addAll(COMPATIBLE_TOOL_MODULE_TYPES.computeIfAbsent(modularTool, modularToolItem -> new TreeSet<>(Comparator.comparingInt(ToolModuleType::getLayer).thenComparing(ToolModuleType::getTag))), toolModuleTypes);
    }

    public static boolean isRequired(ModularToolItem modularTool, ToolModuleType toolModuleType) {
        return REQUIRED_TOOL_MODULE_TYPES.containsKey(modularTool) && REQUIRED_TOOL_MODULE_TYPES.get(modularTool).contains(toolModuleType);
    }

    public static boolean isCompatible(ModularToolItem modularTool, ToolModuleType toolModuleType) {
        return COMPATIBLE_TOOL_MODULE_TYPES.containsKey(modularTool) && COMPATIBLE_TOOL_MODULE_TYPES.get(modularTool).contains(toolModuleType);
    }

    @Unmodifiable
    public static Set<ToolModuleType> getRequired(ModularToolItem modularTool) {
        return REQUIRED_TOOL_MODULE_TYPES.get(modularTool);
    }

    @Unmodifiable
    public static TreeSet<ToolModuleType> getCompatible(ModularToolItem modularTool) {
        return COMPATIBLE_TOOL_MODULE_TYPES.get(modularTool);
    }
}
