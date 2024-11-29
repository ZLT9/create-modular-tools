package net.zlt.create_modular_tools.block.entity.mold;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.block.entity.mold.black_concrete_powder.*;
import net.zlt.create_modular_tools.block.entity.mold.blue_concrete_powder.*;
import net.zlt.create_modular_tools.block.entity.mold.brown_concrete_powder.*;
import net.zlt.create_modular_tools.block.entity.mold.cyan_concrete_powder.*;
import net.zlt.create_modular_tools.block.entity.mold.gray_concrete_powder.*;
import net.zlt.create_modular_tools.block.entity.mold.green_concrete_powder.*;
import net.zlt.create_modular_tools.block.entity.mold.light_blue_concrete_powder.*;
import net.zlt.create_modular_tools.block.entity.mold.light_gray_concrete_powder.*;
import net.zlt.create_modular_tools.block.entity.mold.lime_concrete_powder.*;
import net.zlt.create_modular_tools.block.entity.mold.magenta_concrete_powder.*;
import net.zlt.create_modular_tools.block.entity.mold.orange_concrete_powder.*;
import net.zlt.create_modular_tools.block.entity.mold.pink_concrete_powder.*;
import net.zlt.create_modular_tools.block.entity.mold.purple_concrete_powder.*;
import net.zlt.create_modular_tools.block.entity.mold.red_concrete_powder.*;
import net.zlt.create_modular_tools.block.entity.mold.red_sand.*;
import net.zlt.create_modular_tools.block.entity.mold.sand.*;
import net.zlt.create_modular_tools.block.entity.mold.white_concrete_powder.*;
import net.zlt.create_modular_tools.block.entity.mold.yellow_concrete_powder.*;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;

public final class AllMoldBlockEntityTypes {
    private AllMoldBlockEntityTypes() {
    }

    public static final BlockEntityType<SwordSandMoldBlockEntity> SWORD_SAND_MOLD = register("sword_sand_mold", FabricBlockEntityTypeBuilder.create(SwordSandMoldBlockEntity::new, AllMoldBlocks.SWORD_SAND_MOLD).build());
    public static final BlockEntityType<ShovelSandMoldBlockEntity> SHOVEL_SAND_MOLD = register("shovel_sand_mold", FabricBlockEntityTypeBuilder.create(ShovelSandMoldBlockEntity::new, AllMoldBlocks.SHOVEL_SAND_MOLD).build());
    public static final BlockEntityType<PickaxeSandMoldBlockEntity> PICKAXE_SAND_MOLD = register("pickaxe_sand_mold", FabricBlockEntityTypeBuilder.create(PickaxeSandMoldBlockEntity::new, AllMoldBlocks.PICKAXE_SAND_MOLD).build());
    public static final BlockEntityType<AxeSandMoldBlockEntity> AXE_SAND_MOLD = register("axe_sand_mold", FabricBlockEntityTypeBuilder.create(AxeSandMoldBlockEntity::new, AllMoldBlocks.AXE_SAND_MOLD).build());
    public static final BlockEntityType<HoeSandMoldBlockEntity> HOE_SAND_MOLD = register("hoe_sand_mold", FabricBlockEntityTypeBuilder.create(HoeSandMoldBlockEntity::new, AllMoldBlocks.HOE_SAND_MOLD).build());

    public static final BlockEntityType<SwordRedSandMoldBlockEntity> SWORD_RED_SAND_MOLD = register("sword_red_sand_mold", FabricBlockEntityTypeBuilder.create(SwordRedSandMoldBlockEntity::new, AllMoldBlocks.SWORD_RED_SAND_MOLD).build());
    public static final BlockEntityType<ShovelRedSandMoldBlockEntity> SHOVEL_RED_SAND_MOLD = register("shovel_red_sand_mold", FabricBlockEntityTypeBuilder.create(ShovelRedSandMoldBlockEntity::new, AllMoldBlocks.SHOVEL_RED_SAND_MOLD).build());
    public static final BlockEntityType<PickaxeRedSandMoldBlockEntity> PICKAXE_RED_SAND_MOLD = register("pickaxe_red_sand_mold", FabricBlockEntityTypeBuilder.create(PickaxeRedSandMoldBlockEntity::new, AllMoldBlocks.PICKAXE_RED_SAND_MOLD).build());
    public static final BlockEntityType<AxeRedSandMoldBlockEntity> AXE_RED_SAND_MOLD = register("axe_red_sand_mold", FabricBlockEntityTypeBuilder.create(AxeRedSandMoldBlockEntity::new, AllMoldBlocks.AXE_RED_SAND_MOLD).build());
    public static final BlockEntityType<HoeRedSandMoldBlockEntity> HOE_RED_SAND_MOLD = register("hoe_red_sand_mold", FabricBlockEntityTypeBuilder.create(HoeRedSandMoldBlockEntity::new, AllMoldBlocks.HOE_RED_SAND_MOLD).build());

    public static final BlockEntityType<SwordWhiteConcretePowderMoldBlockEntity> SWORD_WHITE_CONCRETE_POWDER_MOLD = register("sword_white_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(SwordWhiteConcretePowderMoldBlockEntity::new, AllMoldBlocks.SWORD_WHITE_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<ShovelWhiteConcretePowderMoldBlockEntity> SHOVEL_WHITE_CONCRETE_POWDER_MOLD = register("shovel_white_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(ShovelWhiteConcretePowderMoldBlockEntity::new, AllMoldBlocks.SHOVEL_WHITE_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<PickaxeWhiteConcretePowderMoldBlockEntity> PICKAXE_WHITE_CONCRETE_POWDER_MOLD = register("pickaxe_white_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(PickaxeWhiteConcretePowderMoldBlockEntity::new, AllMoldBlocks.PICKAXE_WHITE_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<AxeWhiteConcretePowderMoldBlockEntity> AXE_WHITE_CONCRETE_POWDER_MOLD = register("axe_white_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(AxeWhiteConcretePowderMoldBlockEntity::new, AllMoldBlocks.AXE_WHITE_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<HoeWhiteConcretePowderMoldBlockEntity> HOE_WHITE_CONCRETE_POWDER_MOLD = register("hoe_white_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(HoeWhiteConcretePowderMoldBlockEntity::new, AllMoldBlocks.HOE_WHITE_CONCRETE_POWDER_MOLD).build());

    public static final BlockEntityType<SwordLightGrayConcretePowderMoldBlockEntity> SWORD_LIGHT_GRAY_CONCRETE_POWDER_MOLD = register("sword_light_gray_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(SwordLightGrayConcretePowderMoldBlockEntity::new, AllMoldBlocks.SWORD_LIGHT_GRAY_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<ShovelLightGrayConcretePowderMoldBlockEntity> SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_MOLD = register("shovel_light_gray_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(ShovelLightGrayConcretePowderMoldBlockEntity::new, AllMoldBlocks.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<PickaxeLightGrayConcretePowderMoldBlockEntity> PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_MOLD = register("pickaxe_light_gray_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(PickaxeLightGrayConcretePowderMoldBlockEntity::new, AllMoldBlocks.PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<AxeLightGrayConcretePowderMoldBlockEntity> AXE_LIGHT_GRAY_CONCRETE_POWDER_MOLD = register("axe_light_gray_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(AxeLightGrayConcretePowderMoldBlockEntity::new, AllMoldBlocks.AXE_LIGHT_GRAY_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<HoeLightGrayConcretePowderMoldBlockEntity> HOE_LIGHT_GRAY_CONCRETE_POWDER_MOLD = register("hoe_light_gray_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(HoeLightGrayConcretePowderMoldBlockEntity::new, AllMoldBlocks.HOE_LIGHT_GRAY_CONCRETE_POWDER_MOLD).build());

    public static final BlockEntityType<SwordGrayConcretePowderMoldBlockEntity> SWORD_GRAY_CONCRETE_POWDER_MOLD = register("sword_gray_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(SwordGrayConcretePowderMoldBlockEntity::new, AllMoldBlocks.SWORD_GRAY_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<ShovelGrayConcretePowderMoldBlockEntity> SHOVEL_GRAY_CONCRETE_POWDER_MOLD = register("shovel_gray_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(ShovelGrayConcretePowderMoldBlockEntity::new, AllMoldBlocks.SHOVEL_GRAY_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<PickaxeGrayConcretePowderMoldBlockEntity> PICKAXE_GRAY_CONCRETE_POWDER_MOLD = register("pickaxe_gray_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(PickaxeGrayConcretePowderMoldBlockEntity::new, AllMoldBlocks.PICKAXE_GRAY_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<AxeGrayConcretePowderMoldBlockEntity> AXE_GRAY_CONCRETE_POWDER_MOLD = register("axe_gray_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(AxeGrayConcretePowderMoldBlockEntity::new, AllMoldBlocks.AXE_GRAY_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<HoeGrayConcretePowderMoldBlockEntity> HOE_GRAY_CONCRETE_POWDER_MOLD = register("hoe_gray_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(HoeGrayConcretePowderMoldBlockEntity::new, AllMoldBlocks.HOE_GRAY_CONCRETE_POWDER_MOLD).build());

    public static final BlockEntityType<SwordBlackConcretePowderMoldBlockEntity> SWORD_BLACK_CONCRETE_POWDER_MOLD = register("sword_black_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(SwordBlackConcretePowderMoldBlockEntity::new, AllMoldBlocks.SWORD_BLACK_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<ShovelBlackConcretePowderMoldBlockEntity> SHOVEL_BLACK_CONCRETE_POWDER_MOLD = register("shovel_black_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(ShovelBlackConcretePowderMoldBlockEntity::new, AllMoldBlocks.SHOVEL_BLACK_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<PickaxeBlackConcretePowderMoldBlockEntity> PICKAXE_BLACK_CONCRETE_POWDER_MOLD = register("pickaxe_black_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(PickaxeBlackConcretePowderMoldBlockEntity::new, AllMoldBlocks.PICKAXE_BLACK_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<AxeBlackConcretePowderMoldBlockEntity> AXE_BLACK_CONCRETE_POWDER_MOLD = register("axe_black_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(AxeBlackConcretePowderMoldBlockEntity::new, AllMoldBlocks.AXE_BLACK_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<HoeBlackConcretePowderMoldBlockEntity> HOE_BLACK_CONCRETE_POWDER_MOLD = register("hoe_black_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(HoeBlackConcretePowderMoldBlockEntity::new, AllMoldBlocks.HOE_BLACK_CONCRETE_POWDER_MOLD).build());

    public static final BlockEntityType<SwordBrownConcretePowderMoldBlockEntity> SWORD_BROWN_CONCRETE_POWDER_MOLD = register("sword_brown_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(SwordBrownConcretePowderMoldBlockEntity::new, AllMoldBlocks.SWORD_BROWN_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<ShovelBrownConcretePowderMoldBlockEntity> SHOVEL_BROWN_CONCRETE_POWDER_MOLD = register("shovel_brown_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(ShovelBrownConcretePowderMoldBlockEntity::new, AllMoldBlocks.SHOVEL_BROWN_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<PickaxeBrownConcretePowderMoldBlockEntity> PICKAXE_BROWN_CONCRETE_POWDER_MOLD = register("pickaxe_brown_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(PickaxeBrownConcretePowderMoldBlockEntity::new, AllMoldBlocks.PICKAXE_BROWN_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<AxeBrownConcretePowderMoldBlockEntity> AXE_BROWN_CONCRETE_POWDER_MOLD = register("axe_brown_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(AxeBrownConcretePowderMoldBlockEntity::new, AllMoldBlocks.AXE_BROWN_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<HoeBrownConcretePowderMoldBlockEntity> HOE_BROWN_CONCRETE_POWDER_MOLD = register("hoe_brown_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(HoeBrownConcretePowderMoldBlockEntity::new, AllMoldBlocks.HOE_BROWN_CONCRETE_POWDER_MOLD).build());

    public static final BlockEntityType<SwordRedConcretePowderMoldBlockEntity> SWORD_RED_CONCRETE_POWDER_MOLD = register("sword_red_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(SwordRedConcretePowderMoldBlockEntity::new, AllMoldBlocks.SWORD_RED_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<ShovelRedConcretePowderMoldBlockEntity> SHOVEL_RED_CONCRETE_POWDER_MOLD = register("shovel_red_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(ShovelRedConcretePowderMoldBlockEntity::new, AllMoldBlocks.SHOVEL_RED_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<PickaxeRedConcretePowderMoldBlockEntity> PICKAXE_RED_CONCRETE_POWDER_MOLD = register("pickaxe_red_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(PickaxeRedConcretePowderMoldBlockEntity::new, AllMoldBlocks.PICKAXE_RED_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<AxeRedConcretePowderMoldBlockEntity> AXE_RED_CONCRETE_POWDER_MOLD = register("axe_red_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(AxeRedConcretePowderMoldBlockEntity::new, AllMoldBlocks.AXE_RED_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<HoeRedConcretePowderMoldBlockEntity> HOE_RED_CONCRETE_POWDER_MOLD = register("hoe_red_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(HoeRedConcretePowderMoldBlockEntity::new, AllMoldBlocks.HOE_RED_CONCRETE_POWDER_MOLD).build());

    public static final BlockEntityType<SwordOrangeConcretePowderMoldBlockEntity> SWORD_ORANGE_CONCRETE_POWDER_MOLD = register("sword_orange_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(SwordOrangeConcretePowderMoldBlockEntity::new, AllMoldBlocks.SWORD_ORANGE_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<ShovelOrangeConcretePowderMoldBlockEntity> SHOVEL_ORANGE_CONCRETE_POWDER_MOLD = register("shovel_orange_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(ShovelOrangeConcretePowderMoldBlockEntity::new, AllMoldBlocks.SHOVEL_ORANGE_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<PickaxeOrangeConcretePowderMoldBlockEntity> PICKAXE_ORANGE_CONCRETE_POWDER_MOLD = register("pickaxe_orange_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(PickaxeOrangeConcretePowderMoldBlockEntity::new, AllMoldBlocks.PICKAXE_ORANGE_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<AxeOrangeConcretePowderMoldBlockEntity> AXE_ORANGE_CONCRETE_POWDER_MOLD = register("axe_orange_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(AxeOrangeConcretePowderMoldBlockEntity::new, AllMoldBlocks.AXE_ORANGE_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<HoeOrangeConcretePowderMoldBlockEntity> HOE_ORANGE_CONCRETE_POWDER_MOLD = register("hoe_orange_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(HoeOrangeConcretePowderMoldBlockEntity::new, AllMoldBlocks.HOE_ORANGE_CONCRETE_POWDER_MOLD).build());

    public static final BlockEntityType<SwordYellowConcretePowderMoldBlockEntity> SWORD_YELLOW_CONCRETE_POWDER_MOLD = register("sword_yellow_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(SwordYellowConcretePowderMoldBlockEntity::new, AllMoldBlocks.SWORD_YELLOW_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<ShovelYellowConcretePowderMoldBlockEntity> SHOVEL_YELLOW_CONCRETE_POWDER_MOLD = register("shovel_yellow_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(ShovelYellowConcretePowderMoldBlockEntity::new, AllMoldBlocks.SHOVEL_YELLOW_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<PickaxeYellowConcretePowderMoldBlockEntity> PICKAXE_YELLOW_CONCRETE_POWDER_MOLD = register("pickaxe_yellow_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(PickaxeYellowConcretePowderMoldBlockEntity::new, AllMoldBlocks.PICKAXE_YELLOW_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<AxeYellowConcretePowderMoldBlockEntity> AXE_YELLOW_CONCRETE_POWDER_MOLD = register("axe_yellow_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(AxeYellowConcretePowderMoldBlockEntity::new, AllMoldBlocks.AXE_YELLOW_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<HoeYellowConcretePowderMoldBlockEntity> HOE_YELLOW_CONCRETE_POWDER_MOLD = register("hoe_yellow_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(HoeYellowConcretePowderMoldBlockEntity::new, AllMoldBlocks.HOE_YELLOW_CONCRETE_POWDER_MOLD).build());

    public static final BlockEntityType<SwordLimeConcretePowderMoldBlockEntity> SWORD_LIME_CONCRETE_POWDER_MOLD = register("sword_lime_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(SwordLimeConcretePowderMoldBlockEntity::new, AllMoldBlocks.SWORD_LIME_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<ShovelLimeConcretePowderMoldBlockEntity> SHOVEL_LIME_CONCRETE_POWDER_MOLD = register("shovel_lime_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(ShovelLimeConcretePowderMoldBlockEntity::new, AllMoldBlocks.SHOVEL_LIME_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<PickaxeLimeConcretePowderMoldBlockEntity> PICKAXE_LIME_CONCRETE_POWDER_MOLD = register("pickaxe_lime_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(PickaxeLimeConcretePowderMoldBlockEntity::new, AllMoldBlocks.PICKAXE_LIME_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<AxeLimeConcretePowderMoldBlockEntity> AXE_LIME_CONCRETE_POWDER_MOLD = register("axe_lime_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(AxeLimeConcretePowderMoldBlockEntity::new, AllMoldBlocks.AXE_LIME_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<HoeLimeConcretePowderMoldBlockEntity> HOE_LIME_CONCRETE_POWDER_MOLD = register("hoe_lime_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(HoeLimeConcretePowderMoldBlockEntity::new, AllMoldBlocks.HOE_LIME_CONCRETE_POWDER_MOLD).build());

    public static final BlockEntityType<SwordGreenConcretePowderMoldBlockEntity> SWORD_GREEN_CONCRETE_POWDER_MOLD = register("sword_green_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(SwordGreenConcretePowderMoldBlockEntity::new, AllMoldBlocks.SWORD_GREEN_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<ShovelGreenConcretePowderMoldBlockEntity> SHOVEL_GREEN_CONCRETE_POWDER_MOLD = register("shovel_green_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(ShovelGreenConcretePowderMoldBlockEntity::new, AllMoldBlocks.SHOVEL_GREEN_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<PickaxeGreenConcretePowderMoldBlockEntity> PICKAXE_GREEN_CONCRETE_POWDER_MOLD = register("pickaxe_green_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(PickaxeGreenConcretePowderMoldBlockEntity::new, AllMoldBlocks.PICKAXE_GREEN_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<AxeGreenConcretePowderMoldBlockEntity> AXE_GREEN_CONCRETE_POWDER_MOLD = register("axe_green_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(AxeGreenConcretePowderMoldBlockEntity::new, AllMoldBlocks.AXE_GREEN_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<HoeGreenConcretePowderMoldBlockEntity> HOE_GREEN_CONCRETE_POWDER_MOLD = register("hoe_green_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(HoeGreenConcretePowderMoldBlockEntity::new, AllMoldBlocks.HOE_GREEN_CONCRETE_POWDER_MOLD).build());

    public static final BlockEntityType<SwordCyanConcretePowderMoldBlockEntity> SWORD_CYAN_CONCRETE_POWDER_MOLD = register("sword_cyan_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(SwordCyanConcretePowderMoldBlockEntity::new, AllMoldBlocks.SWORD_CYAN_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<ShovelCyanConcretePowderMoldBlockEntity> SHOVEL_CYAN_CONCRETE_POWDER_MOLD = register("shovel_cyan_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(ShovelCyanConcretePowderMoldBlockEntity::new, AllMoldBlocks.SHOVEL_CYAN_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<PickaxeCyanConcretePowderMoldBlockEntity> PICKAXE_CYAN_CONCRETE_POWDER_MOLD = register("pickaxe_cyan_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(PickaxeCyanConcretePowderMoldBlockEntity::new, AllMoldBlocks.PICKAXE_CYAN_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<AxeCyanConcretePowderMoldBlockEntity> AXE_CYAN_CONCRETE_POWDER_MOLD = register("axe_cyan_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(AxeCyanConcretePowderMoldBlockEntity::new, AllMoldBlocks.AXE_CYAN_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<HoeCyanConcretePowderMoldBlockEntity> HOE_CYAN_CONCRETE_POWDER_MOLD = register("hoe_cyan_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(HoeCyanConcretePowderMoldBlockEntity::new, AllMoldBlocks.HOE_CYAN_CONCRETE_POWDER_MOLD).build());

    public static final BlockEntityType<SwordLightBlueConcretePowderMoldBlockEntity> SWORD_LIGHT_BLUE_CONCRETE_POWDER_MOLD = register("sword_light_blue_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(SwordLightBlueConcretePowderMoldBlockEntity::new, AllMoldBlocks.SWORD_LIGHT_BLUE_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<ShovelLightBlueConcretePowderMoldBlockEntity> SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_MOLD = register("shovel_light_blue_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(ShovelLightBlueConcretePowderMoldBlockEntity::new, AllMoldBlocks.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<PickaxeLightBlueConcretePowderMoldBlockEntity> PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_MOLD = register("pickaxe_light_blue_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(PickaxeLightBlueConcretePowderMoldBlockEntity::new, AllMoldBlocks.PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<AxeLightBlueConcretePowderMoldBlockEntity> AXE_LIGHT_BLUE_CONCRETE_POWDER_MOLD = register("axe_light_blue_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(AxeLightBlueConcretePowderMoldBlockEntity::new, AllMoldBlocks.AXE_LIGHT_BLUE_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<HoeLightBlueConcretePowderMoldBlockEntity> HOE_LIGHT_BLUE_CONCRETE_POWDER_MOLD = register("hoe_light_blue_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(HoeLightBlueConcretePowderMoldBlockEntity::new, AllMoldBlocks.HOE_LIGHT_BLUE_CONCRETE_POWDER_MOLD).build());

    public static final BlockEntityType<SwordBlueConcretePowderMoldBlockEntity> SWORD_BLUE_CONCRETE_POWDER_MOLD = register("sword_blue_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(SwordBlueConcretePowderMoldBlockEntity::new, AllMoldBlocks.SWORD_BLUE_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<ShovelBlueConcretePowderMoldBlockEntity> SHOVEL_BLUE_CONCRETE_POWDER_MOLD = register("shovel_blue_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(ShovelBlueConcretePowderMoldBlockEntity::new, AllMoldBlocks.SHOVEL_BLUE_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<PickaxeBlueConcretePowderMoldBlockEntity> PICKAXE_BLUE_CONCRETE_POWDER_MOLD = register("pickaxe_blue_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(PickaxeBlueConcretePowderMoldBlockEntity::new, AllMoldBlocks.PICKAXE_BLUE_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<AxeBlueConcretePowderMoldBlockEntity> AXE_BLUE_CONCRETE_POWDER_MOLD = register("axe_blue_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(AxeBlueConcretePowderMoldBlockEntity::new, AllMoldBlocks.AXE_BLUE_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<HoeBlueConcretePowderMoldBlockEntity> HOE_BLUE_CONCRETE_POWDER_MOLD = register("hoe_blue_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(HoeBlueConcretePowderMoldBlockEntity::new, AllMoldBlocks.HOE_BLUE_CONCRETE_POWDER_MOLD).build());

    public static final BlockEntityType<SwordPurpleConcretePowderMoldBlockEntity> SWORD_PURPLE_CONCRETE_POWDER_MOLD = register("sword_purple_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(SwordPurpleConcretePowderMoldBlockEntity::new, AllMoldBlocks.SWORD_PURPLE_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<ShovelPurpleConcretePowderMoldBlockEntity> SHOVEL_PURPLE_CONCRETE_POWDER_MOLD = register("shovel_purple_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(ShovelPurpleConcretePowderMoldBlockEntity::new, AllMoldBlocks.SHOVEL_PURPLE_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<PickaxePurpleConcretePowderMoldBlockEntity> PICKAXE_PURPLE_CONCRETE_POWDER_MOLD = register("pickaxe_purple_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(PickaxePurpleConcretePowderMoldBlockEntity::new, AllMoldBlocks.PICKAXE_PURPLE_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<AxePurpleConcretePowderMoldBlockEntity> AXE_PURPLE_CONCRETE_POWDER_MOLD = register("axe_purple_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(AxePurpleConcretePowderMoldBlockEntity::new, AllMoldBlocks.AXE_PURPLE_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<HoePurpleConcretePowderMoldBlockEntity> HOE_PURPLE_CONCRETE_POWDER_MOLD = register("hoe_purple_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(HoePurpleConcretePowderMoldBlockEntity::new, AllMoldBlocks.HOE_PURPLE_CONCRETE_POWDER_MOLD).build());

    public static final BlockEntityType<SwordMagentaConcretePowderMoldBlockEntity> SWORD_MAGENTA_CONCRETE_POWDER_MOLD = register("sword_magenta_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(SwordMagentaConcretePowderMoldBlockEntity::new, AllMoldBlocks.SWORD_MAGENTA_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<ShovelMagentaConcretePowderMoldBlockEntity> SHOVEL_MAGENTA_CONCRETE_POWDER_MOLD = register("shovel_magenta_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(ShovelMagentaConcretePowderMoldBlockEntity::new, AllMoldBlocks.SHOVEL_MAGENTA_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<PickaxeMagentaConcretePowderMoldBlockEntity> PICKAXE_MAGENTA_CONCRETE_POWDER_MOLD = register("pickaxe_magenta_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(PickaxeMagentaConcretePowderMoldBlockEntity::new, AllMoldBlocks.PICKAXE_MAGENTA_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<AxeMagentaConcretePowderMoldBlockEntity> AXE_MAGENTA_CONCRETE_POWDER_MOLD = register("axe_magenta_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(AxeMagentaConcretePowderMoldBlockEntity::new, AllMoldBlocks.AXE_MAGENTA_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<HoeMagentaConcretePowderMoldBlockEntity> HOE_MAGENTA_CONCRETE_POWDER_MOLD = register("hoe_magenta_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(HoeMagentaConcretePowderMoldBlockEntity::new, AllMoldBlocks.HOE_MAGENTA_CONCRETE_POWDER_MOLD).build());

    public static final BlockEntityType<SwordPinkConcretePowderMoldBlockEntity> SWORD_PINK_CONCRETE_POWDER_MOLD = register("sword_pink_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(SwordPinkConcretePowderMoldBlockEntity::new, AllMoldBlocks.SWORD_PINK_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<ShovelPinkConcretePowderMoldBlockEntity> SHOVEL_PINK_CONCRETE_POWDER_MOLD = register("shovel_pink_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(ShovelPinkConcretePowderMoldBlockEntity::new, AllMoldBlocks.SHOVEL_PINK_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<PickaxePinkConcretePowderMoldBlockEntity> PICKAXE_PINK_CONCRETE_POWDER_MOLD = register("pickaxe_pink_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(PickaxePinkConcretePowderMoldBlockEntity::new, AllMoldBlocks.PICKAXE_PINK_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<AxePinkConcretePowderMoldBlockEntity> AXE_PINK_CONCRETE_POWDER_MOLD = register("axe_pink_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(AxePinkConcretePowderMoldBlockEntity::new, AllMoldBlocks.AXE_PINK_CONCRETE_POWDER_MOLD).build());
    public static final BlockEntityType<HoePinkConcretePowderMoldBlockEntity> HOE_PINK_CONCRETE_POWDER_MOLD = register("hoe_pink_concrete_powder_mold", FabricBlockEntityTypeBuilder.create(HoePinkConcretePowderMoldBlockEntity::new, AllMoldBlocks.HOE_PINK_CONCRETE_POWDER_MOLD).build());

    private static <T extends BlockEntity> BlockEntityType<T> register(String path, BlockEntityType<T> blockEntityType) {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, CreateModularTools.asResource(path), blockEntityType);
    }

    public static void init() {
    }
}
