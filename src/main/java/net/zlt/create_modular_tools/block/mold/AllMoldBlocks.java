package net.zlt.create_modular_tools.block.mold;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.block.mold.black_concrete_powder.*;
import net.zlt.create_modular_tools.block.mold.blue_concrete_powder.*;
import net.zlt.create_modular_tools.block.mold.brown_concrete_powder.*;
import net.zlt.create_modular_tools.block.mold.cyan_concrete_powder.*;
import net.zlt.create_modular_tools.block.mold.gray_concrete_powder.*;
import net.zlt.create_modular_tools.block.mold.green_concrete_powder.*;
import net.zlt.create_modular_tools.block.mold.light_blue_concrete_powder.*;
import net.zlt.create_modular_tools.block.mold.light_gray_concrete_powder.*;
import net.zlt.create_modular_tools.block.mold.lime_concrete_powder.*;
import net.zlt.create_modular_tools.block.mold.magenta_concrete_powder.*;
import net.zlt.create_modular_tools.block.mold.orange_concrete_powder.*;
import net.zlt.create_modular_tools.block.mold.pink_concrete_powder.*;
import net.zlt.create_modular_tools.block.mold.purple_concrete_powder.*;
import net.zlt.create_modular_tools.block.mold.red_concrete_powder.*;
import net.zlt.create_modular_tools.block.mold.red_sand.*;
import net.zlt.create_modular_tools.block.mold.sand.*;
import net.zlt.create_modular_tools.block.mold.white_concrete_powder.*;
import net.zlt.create_modular_tools.block.mold.yellow_concrete_powder.*;

import java.util.Set;

public final class AllMoldBlocks {
    private AllMoldBlocks() {
    }

    public static final MaterialMoldBlock SAND_MOLD = register("sand_mold", new SandMoldBlock(BlockBehaviour.Properties.of()));
    public static final MaterialMoldBlock RED_SAND_MOLD = register("red_sand_mold", new RedSandMoldBlock(BlockBehaviour.Properties.of()));
    public static final MaterialMoldBlock WHITE_CONCRETE_POWDER_MOLD = register("white_concrete_powder_mold", new WhiteConcretePowderMoldBlock(BlockBehaviour.Properties.of()));
    public static final MaterialMoldBlock LIGHT_GRAY_CONCRETE_POWDER_MOLD = register("light_gray_concrete_powder_mold", new LightGrayConcretePowderMoldBlock(BlockBehaviour.Properties.of()));
    public static final MaterialMoldBlock GRAY_CONCRETE_POWDER_MOLD = register("gray_concrete_powder_mold", new GrayConcretePowderMoldBlock(BlockBehaviour.Properties.of()));
    public static final MaterialMoldBlock BLACK_CONCRETE_POWDER_MOLD = register("black_concrete_powder_mold", new BlackConcretePowderMoldBlock(BlockBehaviour.Properties.of()));
    public static final MaterialMoldBlock BROWN_CONCRETE_POWDER_MOLD = register("brown_concrete_powder_mold", new BrownConcretePowderMoldBlock(BlockBehaviour.Properties.of()));
    public static final MaterialMoldBlock RED_CONCRETE_POWDER_MOLD = register("red_concrete_powder_mold", new RedConcretePowderMoldBlock(BlockBehaviour.Properties.of()));
    public static final MaterialMoldBlock ORANGE_CONCRETE_POWDER_MOLD = register("orange_concrete_powder_mold", new OrangeConcretePowderMoldBlock(BlockBehaviour.Properties.of()));
    public static final MaterialMoldBlock YELLOW_CONCRETE_POWDER_MOLD = register("yellow_concrete_powder_mold", new YellowConcretePowderMoldBlock(BlockBehaviour.Properties.of()));
    public static final MaterialMoldBlock LIME_CONCRETE_POWDER_MOLD = register("lime_concrete_powder_mold", new LimeConcretePowderMoldBlock(BlockBehaviour.Properties.of()));
    public static final MaterialMoldBlock GREEN_CONCRETE_POWDER_MOLD = register("green_concrete_powder_mold", new GreenConcretePowderMoldBlock(BlockBehaviour.Properties.of()));
    public static final MaterialMoldBlock CYAN_CONCRETE_POWDER_MOLD = register("cyan_concrete_powder_mold", new CyanConcretePowderMoldBlock(BlockBehaviour.Properties.of()));
    public static final MaterialMoldBlock LIGHT_BLUE_CONCRETE_POWDER_MOLD = register("light_blue_concrete_powder_mold", new LightBlueConcretePowderMoldBlock(BlockBehaviour.Properties.of()));
    public static final MaterialMoldBlock BLUE_CONCRETE_POWDER_MOLD = register("blue_concrete_powder_mold", new BlueConcretePowderMoldBlock(BlockBehaviour.Properties.of()));
    public static final MaterialMoldBlock PURPLE_CONCRETE_POWDER_MOLD = register("purple_concrete_powder_mold", new PurpleConcretePowderMoldBlock(BlockBehaviour.Properties.of()));
    public static final MaterialMoldBlock MAGENTA_CONCRETE_POWDER_MOLD = register("magenta_concrete_powder_mold", new MagentaConcretePowderMoldBlock(BlockBehaviour.Properties.of()));
    public static final MaterialMoldBlock PINK_CONCRETE_POWDER_MOLD = register("pink_concrete_powder_mold", new PinkConcretePowderMoldBlock(BlockBehaviour.Properties.of()));

    public static final ToolMaterialMoldBlock SWORD_SAND_MOLD = register("sword_sand_mold", new SwordSandMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock SHOVEL_SAND_MOLD = register("shovel_sand_mold", new ShovelSandMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock PICKAXE_SAND_MOLD = register("pickaxe_sand_mold", new PickaxeSandMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock AXE_SAND_MOLD = register("axe_sand_mold", new AxeSandMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock HOE_SAND_MOLD = register("hoe_sand_mold", new HoeSandMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final Set<ToolMaterialMoldBlock> SAND_MOLDS = Set.of(SWORD_SAND_MOLD, SHOVEL_SAND_MOLD, PICKAXE_SAND_MOLD, AXE_SAND_MOLD, HOE_SAND_MOLD);

    public static final ToolMaterialMoldBlock SWORD_RED_SAND_MOLD = register("sword_red_sand_mold", new SwordRedSandMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock SHOVEL_RED_SAND_MOLD = register("shovel_red_sand_mold", new ShovelRedSandMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock PICKAXE_RED_SAND_MOLD = register("pickaxe_red_sand_mold", new PickaxeRedSandMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock AXE_RED_SAND_MOLD = register("axe_red_sand_mold", new AxeRedSandMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock HOE_RED_SAND_MOLD = register("hoe_red_sand_mold", new HoeRedSandMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final Set<ToolMaterialMoldBlock> RED_SAND_MOLDS = Set.of(SWORD_RED_SAND_MOLD, SHOVEL_RED_SAND_MOLD, PICKAXE_RED_SAND_MOLD, AXE_RED_SAND_MOLD, HOE_RED_SAND_MOLD);

    public static final ToolMaterialMoldBlock SWORD_WHITE_CONCRETE_POWDER_MOLD = register("sword_white_concrete_powder_mold", new SwordWhiteConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock SHOVEL_WHITE_CONCRETE_POWDER_MOLD = register("shovel_white_concrete_powder_mold", new ShovelWhiteConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock PICKAXE_WHITE_CONCRETE_POWDER_MOLD = register("pickaxe_white_concrete_powder_mold", new PickaxeWhiteConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock AXE_WHITE_CONCRETE_POWDER_MOLD = register("axe_white_concrete_powder_mold", new AxeWhiteConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock HOE_WHITE_CONCRETE_POWDER_MOLD = register("hoe_white_concrete_powder_mold", new HoeWhiteConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final Set<ToolMaterialMoldBlock> WHITE_CONCRETE_POWDER_MOLDS = Set.of(SWORD_WHITE_CONCRETE_POWDER_MOLD, SHOVEL_WHITE_CONCRETE_POWDER_MOLD, PICKAXE_WHITE_CONCRETE_POWDER_MOLD, AXE_WHITE_CONCRETE_POWDER_MOLD, HOE_WHITE_CONCRETE_POWDER_MOLD);

    public static final ToolMaterialMoldBlock SWORD_LIGHT_GRAY_CONCRETE_POWDER_MOLD = register("sword_light_gray_concrete_powder_mold", new SwordLightGrayConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_MOLD = register("shovel_light_gray_concrete_powder_mold", new ShovelLightGrayConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_MOLD = register("pickaxe_light_gray_concrete_powder_mold", new PickaxeLightGrayConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock AXE_LIGHT_GRAY_CONCRETE_POWDER_MOLD = register("axe_light_gray_concrete_powder_mold", new AxeLightGrayConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock HOE_LIGHT_GRAY_CONCRETE_POWDER_MOLD = register("hoe_light_gray_concrete_powder_mold", new HoeLightGrayConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final Set<ToolMaterialMoldBlock> LIGHT_GRAY_CONCRETE_POWDER_MOLDS = Set.of(SWORD_LIGHT_GRAY_CONCRETE_POWDER_MOLD, SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_MOLD, PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_MOLD, AXE_LIGHT_GRAY_CONCRETE_POWDER_MOLD, HOE_LIGHT_GRAY_CONCRETE_POWDER_MOLD);

    public static final ToolMaterialMoldBlock SWORD_GRAY_CONCRETE_POWDER_MOLD = register("sword_gray_concrete_powder_mold", new SwordGrayConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock SHOVEL_GRAY_CONCRETE_POWDER_MOLD = register("shovel_gray_concrete_powder_mold", new ShovelGrayConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock PICKAXE_GRAY_CONCRETE_POWDER_MOLD = register("pickaxe_gray_concrete_powder_mold", new PickaxeGrayConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock AXE_GRAY_CONCRETE_POWDER_MOLD = register("axe_gray_concrete_powder_mold", new AxeGrayConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock HOE_GRAY_CONCRETE_POWDER_MOLD = register("hoe_gray_concrete_powder_mold", new HoeGrayConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final Set<ToolMaterialMoldBlock> GRAY_CONCRETE_POWDER_MOLDS = Set.of(SWORD_GRAY_CONCRETE_POWDER_MOLD, SHOVEL_GRAY_CONCRETE_POWDER_MOLD, PICKAXE_GRAY_CONCRETE_POWDER_MOLD, AXE_GRAY_CONCRETE_POWDER_MOLD, HOE_GRAY_CONCRETE_POWDER_MOLD);

    public static final ToolMaterialMoldBlock SWORD_BLACK_CONCRETE_POWDER_MOLD = register("sword_black_concrete_powder_mold", new SwordBlackConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock SHOVEL_BLACK_CONCRETE_POWDER_MOLD = register("shovel_black_concrete_powder_mold", new ShovelBlackConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock PICKAXE_BLACK_CONCRETE_POWDER_MOLD = register("pickaxe_black_concrete_powder_mold", new PickaxeBlackConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock AXE_BLACK_CONCRETE_POWDER_MOLD = register("axe_black_concrete_powder_mold", new AxeBlackConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock HOE_BLACK_CONCRETE_POWDER_MOLD = register("hoe_black_concrete_powder_mold", new HoeBlackConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final Set<ToolMaterialMoldBlock> BLACK_CONCRETE_POWDER_MOLDS = Set.of(SWORD_BLACK_CONCRETE_POWDER_MOLD, SHOVEL_BLACK_CONCRETE_POWDER_MOLD, PICKAXE_BLACK_CONCRETE_POWDER_MOLD, AXE_BLACK_CONCRETE_POWDER_MOLD, HOE_BLACK_CONCRETE_POWDER_MOLD);

    public static final ToolMaterialMoldBlock SWORD_BROWN_CONCRETE_POWDER_MOLD = register("sword_brown_concrete_powder_mold", new SwordBrownConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock SHOVEL_BROWN_CONCRETE_POWDER_MOLD = register("shovel_brown_concrete_powder_mold", new ShovelBrownConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock PICKAXE_BROWN_CONCRETE_POWDER_MOLD = register("pickaxe_brown_concrete_powder_mold", new PickaxeBrownConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock AXE_BROWN_CONCRETE_POWDER_MOLD = register("axe_brown_concrete_powder_mold", new AxeBrownConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock HOE_BROWN_CONCRETE_POWDER_MOLD = register("hoe_brown_concrete_powder_mold", new HoeBrownConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final Set<ToolMaterialMoldBlock> BROWN_CONCRETE_POWDER_MOLDS = Set.of(SWORD_BROWN_CONCRETE_POWDER_MOLD, SHOVEL_BROWN_CONCRETE_POWDER_MOLD, PICKAXE_BROWN_CONCRETE_POWDER_MOLD, AXE_BROWN_CONCRETE_POWDER_MOLD, HOE_BROWN_CONCRETE_POWDER_MOLD);

    public static final ToolMaterialMoldBlock SWORD_RED_CONCRETE_POWDER_MOLD = register("sword_red_concrete_powder_mold", new SwordRedConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock SHOVEL_RED_CONCRETE_POWDER_MOLD = register("shovel_red_concrete_powder_mold", new ShovelRedConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock PICKAXE_RED_CONCRETE_POWDER_MOLD = register("pickaxe_red_concrete_powder_mold", new PickaxeRedConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock AXE_RED_CONCRETE_POWDER_MOLD = register("axe_red_concrete_powder_mold", new AxeRedConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock HOE_RED_CONCRETE_POWDER_MOLD = register("hoe_red_concrete_powder_mold", new HoeRedConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final Set<ToolMaterialMoldBlock> RED_CONCRETE_POWDER_MOLDS = Set.of(SWORD_RED_CONCRETE_POWDER_MOLD, SHOVEL_RED_CONCRETE_POWDER_MOLD, PICKAXE_RED_CONCRETE_POWDER_MOLD, AXE_RED_CONCRETE_POWDER_MOLD, HOE_RED_CONCRETE_POWDER_MOLD);

    public static final ToolMaterialMoldBlock SWORD_ORANGE_CONCRETE_POWDER_MOLD = register("sword_orange_concrete_powder_mold", new SwordOrangeConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock SHOVEL_ORANGE_CONCRETE_POWDER_MOLD = register("shovel_orange_concrete_powder_mold", new ShovelOrangeConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock PICKAXE_ORANGE_CONCRETE_POWDER_MOLD = register("pickaxe_orange_concrete_powder_mold", new PickaxeOrangeConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock AXE_ORANGE_CONCRETE_POWDER_MOLD = register("axe_orange_concrete_powder_mold", new AxeOrangeConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock HOE_ORANGE_CONCRETE_POWDER_MOLD = register("hoe_orange_concrete_powder_mold", new HoeOrangeConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final Set<ToolMaterialMoldBlock> ORANGE_CONCRETE_POWDER_MOLDS = Set.of(SWORD_ORANGE_CONCRETE_POWDER_MOLD, SHOVEL_ORANGE_CONCRETE_POWDER_MOLD, PICKAXE_ORANGE_CONCRETE_POWDER_MOLD, AXE_ORANGE_CONCRETE_POWDER_MOLD, HOE_ORANGE_CONCRETE_POWDER_MOLD);

    public static final ToolMaterialMoldBlock SWORD_YELLOW_CONCRETE_POWDER_MOLD = register("sword_yellow_concrete_powder_mold", new SwordYellowConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock SHOVEL_YELLOW_CONCRETE_POWDER_MOLD = register("shovel_yellow_concrete_powder_mold", new ShovelYellowConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock PICKAXE_YELLOW_CONCRETE_POWDER_MOLD = register("pickaxe_yellow_concrete_powder_mold", new PickaxeYellowConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock AXE_YELLOW_CONCRETE_POWDER_MOLD = register("axe_yellow_concrete_powder_mold", new AxeYellowConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock HOE_YELLOW_CONCRETE_POWDER_MOLD = register("hoe_yellow_concrete_powder_mold", new HoeYellowConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final Set<ToolMaterialMoldBlock> YELLOW_CONCRETE_POWDER_MOLDS = Set.of(SWORD_YELLOW_CONCRETE_POWDER_MOLD, SHOVEL_YELLOW_CONCRETE_POWDER_MOLD, PICKAXE_YELLOW_CONCRETE_POWDER_MOLD, AXE_YELLOW_CONCRETE_POWDER_MOLD, HOE_YELLOW_CONCRETE_POWDER_MOLD);

    public static final ToolMaterialMoldBlock SWORD_LIME_CONCRETE_POWDER_MOLD = register("sword_lime_concrete_powder_mold", new SwordLimeConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock SHOVEL_LIME_CONCRETE_POWDER_MOLD = register("shovel_lime_concrete_powder_mold", new ShovelLimeConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock PICKAXE_LIME_CONCRETE_POWDER_MOLD = register("pickaxe_lime_concrete_powder_mold", new PickaxeLimeConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock AXE_LIME_CONCRETE_POWDER_MOLD = register("axe_lime_concrete_powder_mold", new AxeLimeConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock HOE_LIME_CONCRETE_POWDER_MOLD = register("hoe_lime_concrete_powder_mold", new HoeLimeConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final Set<ToolMaterialMoldBlock> LIME_CONCRETE_POWDER_MOLDS = Set.of(SWORD_LIME_CONCRETE_POWDER_MOLD, SHOVEL_LIME_CONCRETE_POWDER_MOLD, PICKAXE_LIME_CONCRETE_POWDER_MOLD, AXE_LIME_CONCRETE_POWDER_MOLD, HOE_LIME_CONCRETE_POWDER_MOLD);

    public static final ToolMaterialMoldBlock SWORD_GREEN_CONCRETE_POWDER_MOLD = register("sword_green_concrete_powder_mold", new SwordGreenConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock SHOVEL_GREEN_CONCRETE_POWDER_MOLD = register("shovel_green_concrete_powder_mold", new ShovelGreenConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock PICKAXE_GREEN_CONCRETE_POWDER_MOLD = register("pickaxe_green_concrete_powder_mold", new PickaxeGreenConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock AXE_GREEN_CONCRETE_POWDER_MOLD = register("axe_green_concrete_powder_mold", new AxeGreenConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock HOE_GREEN_CONCRETE_POWDER_MOLD = register("hoe_green_concrete_powder_mold", new HoeGreenConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final Set<ToolMaterialMoldBlock> GREEN_CONCRETE_POWDER_MOLDS = Set.of(SWORD_GREEN_CONCRETE_POWDER_MOLD, SHOVEL_GREEN_CONCRETE_POWDER_MOLD, PICKAXE_GREEN_CONCRETE_POWDER_MOLD, AXE_GREEN_CONCRETE_POWDER_MOLD, HOE_GREEN_CONCRETE_POWDER_MOLD);

    public static final ToolMaterialMoldBlock SWORD_CYAN_CONCRETE_POWDER_MOLD = register("sword_cyan_concrete_powder_mold", new SwordCyanConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock SHOVEL_CYAN_CONCRETE_POWDER_MOLD = register("shovel_cyan_concrete_powder_mold", new ShovelCyanConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock PICKAXE_CYAN_CONCRETE_POWDER_MOLD = register("pickaxe_cyan_concrete_powder_mold", new PickaxeCyanConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock AXE_CYAN_CONCRETE_POWDER_MOLD = register("axe_cyan_concrete_powder_mold", new AxeCyanConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock HOE_CYAN_CONCRETE_POWDER_MOLD = register("hoe_cyan_concrete_powder_mold", new HoeCyanConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final Set<ToolMaterialMoldBlock> CYAN_CONCRETE_POWDER_MOLDS = Set.of(SWORD_CYAN_CONCRETE_POWDER_MOLD, SHOVEL_CYAN_CONCRETE_POWDER_MOLD, PICKAXE_CYAN_CONCRETE_POWDER_MOLD, AXE_CYAN_CONCRETE_POWDER_MOLD, HOE_CYAN_CONCRETE_POWDER_MOLD);

    public static final ToolMaterialMoldBlock SWORD_LIGHT_BLUE_CONCRETE_POWDER_MOLD = register("sword_light_blue_concrete_powder_mold", new SwordLightBlueConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_MOLD = register("shovel_light_blue_concrete_powder_mold", new ShovelLightBlueConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_MOLD = register("pickaxe_light_blue_concrete_powder_mold", new PickaxeLightBlueConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock AXE_LIGHT_BLUE_CONCRETE_POWDER_MOLD = register("axe_light_blue_concrete_powder_mold", new AxeLightBlueConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock HOE_LIGHT_BLUE_CONCRETE_POWDER_MOLD = register("hoe_light_blue_concrete_powder_mold", new HoeLightBlueConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final Set<ToolMaterialMoldBlock> LIGHT_BLUE_CONCRETE_POWDER_MOLDS = Set.of(SWORD_LIGHT_BLUE_CONCRETE_POWDER_MOLD, SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_MOLD, PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_MOLD, AXE_LIGHT_BLUE_CONCRETE_POWDER_MOLD, HOE_LIGHT_BLUE_CONCRETE_POWDER_MOLD);

    public static final ToolMaterialMoldBlock SWORD_BLUE_CONCRETE_POWDER_MOLD = register("sword_blue_concrete_powder_mold", new SwordBlueConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock SHOVEL_BLUE_CONCRETE_POWDER_MOLD = register("shovel_blue_concrete_powder_mold", new ShovelBlueConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock PICKAXE_BLUE_CONCRETE_POWDER_MOLD = register("pickaxe_blue_concrete_powder_mold", new PickaxeBlueConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock AXE_BLUE_CONCRETE_POWDER_MOLD = register("axe_blue_concrete_powder_mold", new AxeBlueConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock HOE_BLUE_CONCRETE_POWDER_MOLD = register("hoe_blue_concrete_powder_mold", new HoeBlueConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final Set<ToolMaterialMoldBlock> BLUE_CONCRETE_POWDER_MOLDS = Set.of(SWORD_BLUE_CONCRETE_POWDER_MOLD, SHOVEL_BLUE_CONCRETE_POWDER_MOLD, PICKAXE_BLUE_CONCRETE_POWDER_MOLD, AXE_BLUE_CONCRETE_POWDER_MOLD, HOE_BLUE_CONCRETE_POWDER_MOLD);

    public static final ToolMaterialMoldBlock SWORD_PURPLE_CONCRETE_POWDER_MOLD = register("sword_purple_concrete_powder_mold", new SwordPurpleConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock SHOVEL_PURPLE_CONCRETE_POWDER_MOLD = register("shovel_purple_concrete_powder_mold", new ShovelPurpleConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock PICKAXE_PURPLE_CONCRETE_POWDER_MOLD = register("pickaxe_purple_concrete_powder_mold", new PickaxePurpleConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock AXE_PURPLE_CONCRETE_POWDER_MOLD = register("axe_purple_concrete_powder_mold", new AxePurpleConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock HOE_PURPLE_CONCRETE_POWDER_MOLD = register("hoe_purple_concrete_powder_mold", new HoePurpleConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final Set<ToolMaterialMoldBlock> PURPLE_CONCRETE_POWDER_MOLDS = Set.of(SWORD_PURPLE_CONCRETE_POWDER_MOLD, SHOVEL_PURPLE_CONCRETE_POWDER_MOLD, PICKAXE_PURPLE_CONCRETE_POWDER_MOLD, AXE_PURPLE_CONCRETE_POWDER_MOLD, HOE_PURPLE_CONCRETE_POWDER_MOLD);

    public static final ToolMaterialMoldBlock SWORD_MAGENTA_CONCRETE_POWDER_MOLD = register("sword_magenta_concrete_powder_mold", new SwordMagentaConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock SHOVEL_MAGENTA_CONCRETE_POWDER_MOLD = register("shovel_magenta_concrete_powder_mold", new ShovelMagentaConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock PICKAXE_MAGENTA_CONCRETE_POWDER_MOLD = register("pickaxe_magenta_concrete_powder_mold", new PickaxeMagentaConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock AXE_MAGENTA_CONCRETE_POWDER_MOLD = register("axe_magenta_concrete_powder_mold", new AxeMagentaConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock HOE_MAGENTA_CONCRETE_POWDER_MOLD = register("hoe_magenta_concrete_powder_mold", new HoeMagentaConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final Set<ToolMaterialMoldBlock> MAGENTA_CONCRETE_POWDER_MOLDS = Set.of(SWORD_MAGENTA_CONCRETE_POWDER_MOLD, SHOVEL_MAGENTA_CONCRETE_POWDER_MOLD, PICKAXE_MAGENTA_CONCRETE_POWDER_MOLD, AXE_MAGENTA_CONCRETE_POWDER_MOLD, HOE_MAGENTA_CONCRETE_POWDER_MOLD);

    public static final ToolMaterialMoldBlock SWORD_PINK_CONCRETE_POWDER_MOLD = register("sword_pink_concrete_powder_mold", new SwordPinkConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock SHOVEL_PINK_CONCRETE_POWDER_MOLD = register("shovel_pink_concrete_powder_mold", new ShovelPinkConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock PICKAXE_PINK_CONCRETE_POWDER_MOLD = register("pickaxe_pink_concrete_powder_mold", new PickaxePinkConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock AXE_PINK_CONCRETE_POWDER_MOLD = register("axe_pink_concrete_powder_mold", new AxePinkConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final ToolMaterialMoldBlock HOE_PINK_CONCRETE_POWDER_MOLD = register("hoe_pink_concrete_powder_mold", new HoePinkConcretePowderMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MaterialMoldBlock.LIGHT_LEVEL))));
    public static final Set<ToolMaterialMoldBlock> PINK_CONCRETE_POWDER_MOLDS = Set.of(SWORD_PINK_CONCRETE_POWDER_MOLD, SHOVEL_PINK_CONCRETE_POWDER_MOLD, PICKAXE_PINK_CONCRETE_POWDER_MOLD, AXE_PINK_CONCRETE_POWDER_MOLD, HOE_PINK_CONCRETE_POWDER_MOLD);

    private static MaterialMoldBlock register(String path, MaterialMoldBlock block) {
        return Registry.register(BuiltInRegistries.BLOCK, CreateModularTools.asResource(path), block);
    }

    private static ToolMaterialMoldBlock register(String path, ToolMaterialMoldBlock block) {
        return (ToolMaterialMoldBlock) register(path, (MaterialMoldBlock) block);
    }

    public static void init() {
    }
}
