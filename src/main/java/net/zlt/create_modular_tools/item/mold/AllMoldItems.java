package net.zlt.create_modular_tools.item.mold;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;

public final class AllMoldItems {
    private AllMoldItems() {
    }

    public static final Item SAND_MOLD = register("sand_mold", new BlockItem(AllMoldBlocks.SAND_MOLD, new Item.Properties()));
    public static final Item RED_SAND_MOLD = register("red_sand_mold", new BlockItem(AllMoldBlocks.RED_SAND_MOLD, new Item.Properties()));

    public static final Item SWORD_SAND_MOLD = register("sword_sand_mold", new BaseSandMoldItem(AllMoldBlocks.SWORD_SAND_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item SHOVEL_SAND_MOLD = register("shovel_sand_mold", new BaseSandMoldItem(AllMoldBlocks.SHOVEL_SAND_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item PICKAXE_SAND_MOLD = register("pickaxe_sand_mold", new BaseSandMoldItem(AllMoldBlocks.PICKAXE_SAND_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item AXE_SAND_MOLD = register("axe_sand_mold", new BaseSandMoldItem(AllMoldBlocks.AXE_SAND_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item HOE_SAND_MOLD = register("hoe_sand_mold", new BaseSandMoldItem(AllMoldBlocks.HOE_SAND_MOLD, new Item.Properties().stacksTo(1)));

    public static final Item SWORD_RED_SAND_MOLD = register("sword_red_sand_mold", new BaseSandMoldItem(AllMoldBlocks.SWORD_RED_SAND_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item SHOVEL_RED_SAND_MOLD = register("shovel_red_sand_mold", new BaseSandMoldItem(AllMoldBlocks.SHOVEL_RED_SAND_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item PICKAXE_RED_SAND_MOLD = register("pickaxe_red_sand_mold", new BaseSandMoldItem(AllMoldBlocks.PICKAXE_RED_SAND_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item AXE_RED_SAND_MOLD = register("axe_red_sand_mold", new BaseSandMoldItem(AllMoldBlocks.AXE_RED_SAND_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item HOE_RED_SAND_MOLD = register("hoe_red_sand_mold", new BaseSandMoldItem(AllMoldBlocks.HOE_RED_SAND_MOLD, new Item.Properties().stacksTo(1)));

    private static Item register(String path, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, CreateModularTools.asResource(path), item);
    }

    public static void init() {
    }
}
