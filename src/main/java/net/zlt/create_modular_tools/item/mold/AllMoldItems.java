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
    public static final Item WHITE_CONCRETE_POWDER_MOLD = register("white_concrete_powder_mold", new BlockItem(AllMoldBlocks.WHITE_CONCRETE_POWDER_MOLD, new Item.Properties()));
    public static final Item LIGHT_GRAY_CONCRETE_POWDER_MOLD = register("light_gray_concrete_powder_mold", new BlockItem(AllMoldBlocks.LIGHT_GRAY_CONCRETE_POWDER_MOLD, new Item.Properties()));
    public static final Item GRAY_CONCRETE_POWDER_MOLD = register("gray_concrete_powder_mold", new BlockItem(AllMoldBlocks.GRAY_CONCRETE_POWDER_MOLD, new Item.Properties()));
    public static final Item BLACK_CONCRETE_POWDER_MOLD = register("black_concrete_powder_mold", new BlockItem(AllMoldBlocks.BLACK_CONCRETE_POWDER_MOLD, new Item.Properties()));
    public static final Item BROWN_CONCRETE_POWDER_MOLD = register("brown_concrete_powder_mold", new BlockItem(AllMoldBlocks.BROWN_CONCRETE_POWDER_MOLD, new Item.Properties()));
    public static final Item RED_CONCRETE_POWDER_MOLD = register("red_concrete_powder_mold", new BlockItem(AllMoldBlocks.RED_CONCRETE_POWDER_MOLD, new Item.Properties()));
    public static final Item ORANGE_CONCRETE_POWDER_MOLD = register("orange_concrete_powder_mold", new BlockItem(AllMoldBlocks.ORANGE_CONCRETE_POWDER_MOLD, new Item.Properties()));
    public static final Item YELLOW_CONCRETE_POWDER_MOLD = register("yellow_concrete_powder_mold", new BlockItem(AllMoldBlocks.YELLOW_CONCRETE_POWDER_MOLD, new Item.Properties()));
    public static final Item LIME_CONCRETE_POWDER_MOLD = register("lime_concrete_powder_mold", new BlockItem(AllMoldBlocks.LIME_CONCRETE_POWDER_MOLD, new Item.Properties()));
    public static final Item GREEN_CONCRETE_POWDER_MOLD = register("green_concrete_powder_mold", new BlockItem(AllMoldBlocks.GREEN_CONCRETE_POWDER_MOLD, new Item.Properties()));
    public static final Item CYAN_CONCRETE_POWDER_MOLD = register("cyan_concrete_powder_mold", new BlockItem(AllMoldBlocks.CYAN_CONCRETE_POWDER_MOLD, new Item.Properties()));
    public static final Item LIGHT_BLUE_CONCRETE_POWDER_MOLD = register("light_blue_concrete_powder_mold", new BlockItem(AllMoldBlocks.LIGHT_BLUE_CONCRETE_POWDER_MOLD, new Item.Properties()));
    public static final Item BLUE_CONCRETE_POWDER_MOLD = register("blue_concrete_powder_mold", new BlockItem(AllMoldBlocks.BLUE_CONCRETE_POWDER_MOLD, new Item.Properties()));
    public static final Item PURPLE_CONCRETE_POWDER_MOLD = register("purple_concrete_powder_mold", new BlockItem(AllMoldBlocks.PURPLE_CONCRETE_POWDER_MOLD, new Item.Properties()));
    public static final Item MAGENTA_CONCRETE_POWDER_MOLD = register("magenta_concrete_powder_mold", new BlockItem(AllMoldBlocks.MAGENTA_CONCRETE_POWDER_MOLD, new Item.Properties()));
    public static final Item PINK_CONCRETE_POWDER_MOLD = register("pink_concrete_powder_mold", new BlockItem(AllMoldBlocks.PINK_CONCRETE_POWDER_MOLD, new Item.Properties()));

    public static final Item SWORD_SAND_MOLD = register("sword_sand_mold", new BaseMoldItem(AllMoldBlocks.SWORD_SAND_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item SHOVEL_SAND_MOLD = register("shovel_sand_mold", new BaseMoldItem(AllMoldBlocks.SHOVEL_SAND_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item PICKAXE_SAND_MOLD = register("pickaxe_sand_mold", new BaseMoldItem(AllMoldBlocks.PICKAXE_SAND_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item AXE_SAND_MOLD = register("axe_sand_mold", new BaseMoldItem(AllMoldBlocks.AXE_SAND_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item HOE_SAND_MOLD = register("hoe_sand_mold", new BaseMoldItem(AllMoldBlocks.HOE_SAND_MOLD, new Item.Properties().stacksTo(1)));

    public static final Item SWORD_RED_SAND_MOLD = register("sword_red_sand_mold", new BaseMoldItem(AllMoldBlocks.SWORD_RED_SAND_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item SHOVEL_RED_SAND_MOLD = register("shovel_red_sand_mold", new BaseMoldItem(AllMoldBlocks.SHOVEL_RED_SAND_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item PICKAXE_RED_SAND_MOLD = register("pickaxe_red_sand_mold", new BaseMoldItem(AllMoldBlocks.PICKAXE_RED_SAND_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item AXE_RED_SAND_MOLD = register("axe_red_sand_mold", new BaseMoldItem(AllMoldBlocks.AXE_RED_SAND_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item HOE_RED_SAND_MOLD = register("hoe_red_sand_mold", new BaseMoldItem(AllMoldBlocks.HOE_RED_SAND_MOLD, new Item.Properties().stacksTo(1)));

    public static final Item SWORD_WHITE_CONCRETE_POWDER_MOLD = register("sword_white_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SWORD_WHITE_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item SHOVEL_WHITE_CONCRETE_POWDER_MOLD = register("shovel_white_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SHOVEL_WHITE_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item PICKAXE_WHITE_CONCRETE_POWDER_MOLD = register("pickaxe_white_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.PICKAXE_WHITE_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item AXE_WHITE_CONCRETE_POWDER_MOLD = register("axe_white_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.AXE_WHITE_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item HOE_WHITE_CONCRETE_POWDER_MOLD = register("hoe_white_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.HOE_WHITE_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));

    public static final Item SWORD_LIGHT_GRAY_CONCRETE_POWDER_MOLD = register("sword_light_gray_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SWORD_LIGHT_GRAY_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_MOLD = register("shovel_light_gray_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_MOLD = register("pickaxe_light_gray_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item AXE_LIGHT_GRAY_CONCRETE_POWDER_MOLD = register("axe_light_gray_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.AXE_LIGHT_GRAY_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item HOE_LIGHT_GRAY_CONCRETE_POWDER_MOLD = register("hoe_light_gray_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.HOE_LIGHT_GRAY_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));

    public static final Item SWORD_GRAY_CONCRETE_POWDER_MOLD = register("sword_gray_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SWORD_GRAY_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item SHOVEL_GRAY_CONCRETE_POWDER_MOLD = register("shovel_gray_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SHOVEL_GRAY_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item PICKAXE_GRAY_CONCRETE_POWDER_MOLD = register("pickaxe_gray_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.PICKAXE_GRAY_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item AXE_GRAY_CONCRETE_POWDER_MOLD = register("axe_gray_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.AXE_GRAY_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item HOE_GRAY_CONCRETE_POWDER_MOLD = register("hoe_gray_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.HOE_GRAY_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));

    public static final Item SWORD_BLACK_CONCRETE_POWDER_MOLD = register("sword_black_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SWORD_BLACK_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item SHOVEL_BLACK_CONCRETE_POWDER_MOLD = register("shovel_black_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SHOVEL_BLACK_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item PICKAXE_BLACK_CONCRETE_POWDER_MOLD = register("pickaxe_black_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.PICKAXE_BLACK_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item AXE_BLACK_CONCRETE_POWDER_MOLD = register("axe_black_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.AXE_BLACK_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item HOE_BLACK_CONCRETE_POWDER_MOLD = register("hoe_black_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.HOE_BLACK_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));

    public static final Item SWORD_BROWN_CONCRETE_POWDER_MOLD = register("sword_brown_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SWORD_BROWN_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item SHOVEL_BROWN_CONCRETE_POWDER_MOLD = register("shovel_brown_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SHOVEL_BROWN_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item PICKAXE_BROWN_CONCRETE_POWDER_MOLD = register("pickaxe_brown_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.PICKAXE_BROWN_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item AXE_BROWN_CONCRETE_POWDER_MOLD = register("axe_brown_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.AXE_BROWN_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item HOE_BROWN_CONCRETE_POWDER_MOLD = register("hoe_brown_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.HOE_BROWN_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));

    public static final Item SWORD_RED_CONCRETE_POWDER_MOLD = register("sword_red_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SWORD_RED_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item SHOVEL_RED_CONCRETE_POWDER_MOLD = register("shovel_red_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SHOVEL_RED_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item PICKAXE_RED_CONCRETE_POWDER_MOLD = register("pickaxe_red_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.PICKAXE_RED_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item AXE_RED_CONCRETE_POWDER_MOLD = register("axe_red_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.AXE_RED_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item HOE_RED_CONCRETE_POWDER_MOLD = register("hoe_red_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.HOE_RED_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));

    public static final Item SWORD_ORANGE_CONCRETE_POWDER_MOLD = register("sword_orange_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SWORD_ORANGE_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item SHOVEL_ORANGE_CONCRETE_POWDER_MOLD = register("shovel_orange_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SHOVEL_ORANGE_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item PICKAXE_ORANGE_CONCRETE_POWDER_MOLD = register("pickaxe_orange_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.PICKAXE_ORANGE_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item AXE_ORANGE_CONCRETE_POWDER_MOLD = register("axe_orange_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.AXE_ORANGE_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item HOE_ORANGE_CONCRETE_POWDER_MOLD = register("hoe_orange_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.HOE_ORANGE_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));

    public static final Item SWORD_YELLOW_CONCRETE_POWDER_MOLD = register("sword_yellow_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SWORD_YELLOW_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item SHOVEL_YELLOW_CONCRETE_POWDER_MOLD = register("shovel_yellow_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SHOVEL_YELLOW_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item PICKAXE_YELLOW_CONCRETE_POWDER_MOLD = register("pickaxe_yellow_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.PICKAXE_YELLOW_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item AXE_YELLOW_CONCRETE_POWDER_MOLD = register("axe_yellow_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.AXE_YELLOW_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item HOE_YELLOW_CONCRETE_POWDER_MOLD = register("hoe_yellow_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.HOE_YELLOW_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));

    public static final Item SWORD_LIME_CONCRETE_POWDER_MOLD = register("sword_lime_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SWORD_LIME_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item SHOVEL_LIME_CONCRETE_POWDER_MOLD = register("shovel_lime_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SHOVEL_LIME_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item PICKAXE_LIME_CONCRETE_POWDER_MOLD = register("pickaxe_lime_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.PICKAXE_LIME_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item AXE_LIME_CONCRETE_POWDER_MOLD = register("axe_lime_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.AXE_LIME_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item HOE_LIME_CONCRETE_POWDER_MOLD = register("hoe_lime_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.HOE_LIME_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));

    public static final Item SWORD_GREEN_CONCRETE_POWDER_MOLD = register("sword_green_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SWORD_GREEN_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item SHOVEL_GREEN_CONCRETE_POWDER_MOLD = register("shovel_green_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SHOVEL_GREEN_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item PICKAXE_GREEN_CONCRETE_POWDER_MOLD = register("pickaxe_green_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.PICKAXE_GREEN_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item AXE_GREEN_CONCRETE_POWDER_MOLD = register("axe_green_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.AXE_GREEN_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item HOE_GREEN_CONCRETE_POWDER_MOLD = register("hoe_green_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.HOE_GREEN_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));

    public static final Item SWORD_CYAN_CONCRETE_POWDER_MOLD = register("sword_cyan_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SWORD_CYAN_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item SHOVEL_CYAN_CONCRETE_POWDER_MOLD = register("shovel_cyan_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SHOVEL_CYAN_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item PICKAXE_CYAN_CONCRETE_POWDER_MOLD = register("pickaxe_cyan_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.PICKAXE_CYAN_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item AXE_CYAN_CONCRETE_POWDER_MOLD = register("axe_cyan_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.AXE_CYAN_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item HOE_CYAN_CONCRETE_POWDER_MOLD = register("hoe_cyan_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.HOE_CYAN_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));

    public static final Item SWORD_LIGHT_BLUE_CONCRETE_POWDER_MOLD = register("sword_light_blue_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SWORD_LIGHT_BLUE_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_MOLD = register("shovel_light_blue_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_MOLD = register("pickaxe_light_blue_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item AXE_LIGHT_BLUE_CONCRETE_POWDER_MOLD = register("axe_light_blue_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.AXE_LIGHT_BLUE_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item HOE_LIGHT_BLUE_CONCRETE_POWDER_MOLD = register("hoe_light_blue_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.HOE_LIGHT_BLUE_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));

    public static final Item SWORD_BLUE_CONCRETE_POWDER_MOLD = register("sword_blue_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SWORD_BLUE_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item SHOVEL_BLUE_CONCRETE_POWDER_MOLD = register("shovel_blue_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SHOVEL_BLUE_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item PICKAXE_BLUE_CONCRETE_POWDER_MOLD = register("pickaxe_blue_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.PICKAXE_BLUE_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item AXE_BLUE_CONCRETE_POWDER_MOLD = register("axe_blue_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.AXE_BLUE_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item HOE_BLUE_CONCRETE_POWDER_MOLD = register("hoe_blue_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.HOE_BLUE_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));

    public static final Item SWORD_PURPLE_CONCRETE_POWDER_MOLD = register("sword_purple_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SWORD_PURPLE_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item SHOVEL_PURPLE_CONCRETE_POWDER_MOLD = register("shovel_purple_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SHOVEL_PURPLE_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item PICKAXE_PURPLE_CONCRETE_POWDER_MOLD = register("pickaxe_purple_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.PICKAXE_PURPLE_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item AXE_PURPLE_CONCRETE_POWDER_MOLD = register("axe_purple_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.AXE_PURPLE_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item HOE_PURPLE_CONCRETE_POWDER_MOLD = register("hoe_purple_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.HOE_PURPLE_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));

    public static final Item SWORD_MAGENTA_CONCRETE_POWDER_MOLD = register("sword_magenta_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SWORD_MAGENTA_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item SHOVEL_MAGENTA_CONCRETE_POWDER_MOLD = register("shovel_magenta_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SHOVEL_MAGENTA_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item PICKAXE_MAGENTA_CONCRETE_POWDER_MOLD = register("pickaxe_magenta_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.PICKAXE_MAGENTA_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item AXE_MAGENTA_CONCRETE_POWDER_MOLD = register("axe_magenta_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.AXE_MAGENTA_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item HOE_MAGENTA_CONCRETE_POWDER_MOLD = register("hoe_magenta_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.HOE_MAGENTA_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));

    public static final Item SWORD_PINK_CONCRETE_POWDER_MOLD = register("sword_pink_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SWORD_PINK_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item SHOVEL_PINK_CONCRETE_POWDER_MOLD = register("shovel_pink_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.SHOVEL_PINK_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item PICKAXE_PINK_CONCRETE_POWDER_MOLD = register("pickaxe_pink_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.PICKAXE_PINK_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item AXE_PINK_CONCRETE_POWDER_MOLD = register("axe_pink_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.AXE_PINK_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item HOE_PINK_CONCRETE_POWDER_MOLD = register("hoe_pink_concrete_powder_mold", new BaseMoldItem(AllMoldBlocks.HOE_PINK_CONCRETE_POWDER_MOLD, new Item.Properties().stacksTo(1)));

    private static Item register(String path, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, CreateModularTools.asResource(path), item);
    }

    public static void init() {
    }
}
