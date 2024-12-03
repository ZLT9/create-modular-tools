package net.zlt.create_modular_tools.tool;

import net.minecraft.world.item.Item;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.item.AllItems;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;

public final class AllModularTools {
    private AllModularTools() {
    }

    public static final ModularToolItem SWORD = register("sword", AllItems.MODULAR_SWORD);
    public static final ModularToolItem SHOVEL = register("shovel", AllItems.MODULAR_SHOVEL);
    public static final ModularToolItem PICKAXE = register("pickaxe", AllItems.MODULAR_PICKAXE);
    public static final ModularToolItem AXE = register("axe", AllItems.MODULAR_AXE);
    public static final ModularToolItem HOE = register("hoe", AllItems.MODULAR_HOE);

    private static ModularToolItem register(String id, Item modularTool) {
        return ModularToolRegistry.register(CreateModularTools.asResource(id), modularTool);
    }

    public static void init() {
    }
}
