package net.zlt.create_modular_tools.tool.module;

import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public final class ToolModuleRecipeRegistry {
    private ToolModuleRecipeRegistry() {
    }

    private static final Map<ToolModuleType, Map<Fluid, ToolModule>> RECIPES = new HashMap<>();

    public static void register(ToolModuleType toolModuleType, Fluid fluid, ToolModule toolModule) {
        RECIPES.computeIfAbsent(toolModuleType, t -> new HashMap<>()).put(fluid, toolModule);
    }

    @Nullable
    public static ToolModule get(ToolModuleType toolModuleType, Fluid fluid) {
        Map<Fluid, ToolModule> map = RECIPES.get(toolModuleType);
        return map == null ? null : map.get(fluid);
    }
}
