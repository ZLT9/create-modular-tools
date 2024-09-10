package net.zlt.create_modular_tools.tool;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ModularToolRegistry {
    private ModularToolRegistry() {
    }

    private static final Map<String, ModularToolItem> BY_ID = new HashMap<>();
    private static final Map<ModularToolItem, String> BY_MODULAR_TOOL = new HashMap<>();
    private static final List<ModularToolItem> MODULAR_TOOLS = new ArrayList<>();

    public static ModularToolItem register(ResourceLocation id, ModularToolItem modularTool) {
        String idAsString = id.toString();
        if (BY_ID.containsKey(idAsString)) {
            CreateModularTools.LOGGER.error("A modular tool with the same id is already registered: {}, {}", id, modularTool);
            throw new IllegalArgumentException();
        }

        BY_ID.put(idAsString, modularTool);
        BY_MODULAR_TOOL.put(modularTool, idAsString);
        MODULAR_TOOLS.add(modularTool);

        return modularTool;
    }

    public static ModularToolItem register(ResourceLocation id, Item item) {
        if (item instanceof ModularToolItem modularToolItem) {
            return register(id, modularToolItem);
        }

        CreateModularTools.LOGGER.error("The given item is not a modular tool item: {}, {}", id, item);
        throw new IllegalArgumentException();
    }

    @Nullable
    public static ModularToolItem get(String id) {
        return BY_ID.get(id);
    }

    @Unmodifiable
    public static List<ModularToolItem> getAll() {
        return MODULAR_TOOLS;
    }

    public static String getId(ModularToolItem modularTool) {
        return BY_MODULAR_TOOL.get(modularTool);
    }
}
