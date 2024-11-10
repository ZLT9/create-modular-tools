package net.zlt.create_modular_tools.tool.module;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.item.tool.module.ToolModuleItem;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class ToolModuleRegistry {
    private ToolModuleRegistry() {
    }

    private static final Map<String, ToolModuleItem> BY_ID = new HashMap<>();
    private static final Map<ToolModuleItem, String> BY_TOOL_MODULE = new HashMap<>();
    private static final List<ToolModuleItem> TOOL_MODULES = new ArrayList<>();
    private static final Map<ToolModuleType, List<ToolModuleItem>> BY_TOOL_MODULE_TYPE = new HashMap<>();

    public static ToolModuleItem register(ResourceLocation id, ToolModuleItem toolModule) {
        String toolModuleId = id.toString();
        if (BY_ID.containsKey(toolModuleId)) {
            CreateModularTools.LOGGER.error("A tool module with the same id is already registered: {}, {}", id, toolModule);
            throw new IllegalArgumentException();
        }

        BY_ID.put(toolModuleId, toolModule);
        BY_TOOL_MODULE.put(toolModule, toolModuleId);
        TOOL_MODULES.add(toolModule);
        BY_TOOL_MODULE_TYPE.computeIfAbsent(toolModule.getType(), k -> new ArrayList<>()).add(toolModule);

        return toolModule;
    }

    public static ToolModuleItem register(ResourceLocation id, Item item) {
        if (item instanceof ToolModuleItem toolModuleItem) {
            return register(id, toolModuleItem);
        }

        CreateModularTools.LOGGER.error("The given item is not a tool module item: {}, {}", id, item);
        throw new IllegalArgumentException();
    }

    @Nullable
    public static ToolModuleItem get(String id) {
        return BY_ID.get(id);
    }

    public static String getId(ToolModuleItem toolModule) {
        return BY_TOOL_MODULE.get(toolModule);
    }

    @Unmodifiable
    public static List<ToolModuleItem> getAll() {
        return TOOL_MODULES;
    }

    @Unmodifiable
    public static List<ToolModuleItem> getAllOfType(ToolModuleType type) {
        return BY_TOOL_MODULE_TYPE.get(type);
    }

    public static boolean containsId(String id) {
        return BY_ID.containsKey(id);
    }

    public static boolean containsToolModule(ToolModuleItem toolModule) {
        return BY_TOOL_MODULE.containsKey(toolModule);
    }

    public static boolean containsType(ToolModuleType type) {
        return BY_TOOL_MODULE_TYPE.containsKey(type);
    }
}
