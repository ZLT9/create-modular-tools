package net.zlt.create_modular_tools.tool.module;

import net.zlt.create_modular_tools.CreateModularTools;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public final class ToolModuleTypeRegistry {
    private ToolModuleTypeRegistry() {
    }

    private static final Map<String, ToolModuleType> BY_TAG = new HashMap<>();

    public static ToolModuleType register(ToolModuleType toolModuleType) {
        String toolModuleTypeTag = toolModuleType.getTag();
        if (BY_TAG.containsKey(toolModuleTypeTag)) {
            CreateModularTools.LOGGER.error("A tool module type with the same tag is already registered: {}, {}", toolModuleTypeTag, toolModuleTypeTag);
            throw new IllegalArgumentException();
        }

        BY_TAG.put(toolModuleTypeTag, toolModuleType);

        return toolModuleType;
    }

    @Nullable
    public static ToolModuleType get(String tag) {
        return BY_TAG.get(tag);
    }

    public static boolean containsTag(String tag) {
        return BY_TAG.containsKey(tag);
    }
}
