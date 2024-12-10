package net.zlt.create_modular_tools.client.model;

import net.fabricmc.fabric.api.client.model.loading.v1.ModelResolver;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.client.model.item.mold.black_concrete_powder.*;
import net.zlt.create_modular_tools.client.model.item.mold.blue_concrete_powder.*;
import net.zlt.create_modular_tools.client.model.item.mold.brown_concrete_powder.*;
import net.zlt.create_modular_tools.client.model.item.mold.cyan_concrete_powder.*;
import net.zlt.create_modular_tools.client.model.item.mold.gray_concrete_powder.*;
import net.zlt.create_modular_tools.client.model.item.mold.green_concrete_powder.*;
import net.zlt.create_modular_tools.client.model.item.mold.light_blue_concrete_powder.*;
import net.zlt.create_modular_tools.client.model.item.mold.light_gray_concrete_powder.*;
import net.zlt.create_modular_tools.client.model.item.mold.lime_concrete_powder.*;
import net.zlt.create_modular_tools.client.model.item.mold.magenta_concrete_powder.*;
import net.zlt.create_modular_tools.client.model.item.mold.orange_concrete_powder.*;
import net.zlt.create_modular_tools.client.model.item.mold.pink_concrete_powder.*;
import net.zlt.create_modular_tools.client.model.item.mold.purple_concrete_powder.*;
import net.zlt.create_modular_tools.client.model.item.mold.red_concrete_powder.*;
import net.zlt.create_modular_tools.client.model.item.mold.red_sand.*;
import net.zlt.create_modular_tools.client.model.item.mold.sand.*;
import net.zlt.create_modular_tools.client.model.item.mold.white_concrete_powder.*;
import net.zlt.create_modular_tools.client.model.item.mold.yellow_concrete_powder.*;
import net.zlt.create_modular_tools.client.model.item.tool.ModularToolUnbakedModel;
import net.zlt.create_modular_tools.tool.AllModularTools;
import org.jetbrains.annotations.Nullable;

public class CreateModularToolsModelResolver implements ModelResolver {
    @Override
    public @Nullable UnbakedModel resolveModel(Context context) {
        ResourceLocation modelId = context.id();

        if (modelId.equals(CreateModularTools.asResource("item/modular_sword"))) {
            return new ModularToolUnbakedModel(AllModularTools.SWORD);
        }
        if (modelId.equals(CreateModularTools.asResource("item/modular_shovel"))) {
            return new ModularToolUnbakedModel(AllModularTools.SHOVEL);
        }
        if (modelId.equals(CreateModularTools.asResource("item/modular_pickaxe"))) {
            return new ModularToolUnbakedModel(AllModularTools.PICKAXE);
        }
        if (modelId.equals(CreateModularTools.asResource("item/modular_axe"))) {
            return new ModularToolUnbakedModel(AllModularTools.AXE);
        }
        if (modelId.equals(CreateModularTools.asResource("item/modular_hoe"))) {
            return new ModularToolUnbakedModel(AllModularTools.HOE);
        }

        if (modelId.equals(CreateModularTools.asResource("item/sword_sand_oak_mold"))) {
            return new SwordSandOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_sand_oak_mold"))) {
            return new ShovelSandOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_sand_oak_mold"))) {
            return new PickaxeSandOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_sand_oak_mold"))) {
            return new AxeSandOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_sand_oak_mold"))) {
            return new HoeSandOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_sand_spruce_mold"))) {
            return new SwordSandSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_sand_spruce_mold"))) {
            return new ShovelSandSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_sand_spruce_mold"))) {
            return new PickaxeSandSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_sand_spruce_mold"))) {
            return new AxeSandSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_sand_spruce_mold"))) {
            return new HoeSandSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_sand_birch_mold"))) {
            return new SwordSandBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_sand_birch_mold"))) {
            return new ShovelSandBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_sand_birch_mold"))) {
            return new PickaxeSandBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_sand_birch_mold"))) {
            return new AxeSandBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_sand_birch_mold"))) {
            return new HoeSandBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_sand_jungle_mold"))) {
            return new SwordSandJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_sand_jungle_mold"))) {
            return new ShovelSandJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_sand_jungle_mold"))) {
            return new PickaxeSandJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_sand_jungle_mold"))) {
            return new AxeSandJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_sand_jungle_mold"))) {
            return new HoeSandJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_sand_acacia_mold"))) {
            return new SwordSandAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_sand_acacia_mold"))) {
            return new ShovelSandAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_sand_acacia_mold"))) {
            return new PickaxeSandAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_sand_acacia_mold"))) {
            return new AxeSandAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_sand_acacia_mold"))) {
            return new HoeSandAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_sand_dark_oak_mold"))) {
            return new SwordSandDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_sand_dark_oak_mold"))) {
            return new ShovelSandDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_sand_dark_oak_mold"))) {
            return new PickaxeSandDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_sand_dark_oak_mold"))) {
            return new AxeSandDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_sand_dark_oak_mold"))) {
            return new HoeSandDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_sand_mangrove_mold"))) {
            return new SwordSandMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_sand_mangrove_mold"))) {
            return new ShovelSandMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_sand_mangrove_mold"))) {
            return new PickaxeSandMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_sand_mangrove_mold"))) {
            return new AxeSandMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_sand_mangrove_mold"))) {
            return new HoeSandMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_sand_cherry_mold"))) {
            return new SwordSandCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_sand_cherry_mold"))) {
            return new ShovelSandCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_sand_cherry_mold"))) {
            return new PickaxeSandCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_sand_cherry_mold"))) {
            return new AxeSandCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_sand_cherry_mold"))) {
            return new HoeSandCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_sand_bamboo_mold"))) {
            return new SwordSandBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_sand_bamboo_mold"))) {
            return new ShovelSandBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_sand_bamboo_mold"))) {
            return new PickaxeSandBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_sand_bamboo_mold"))) {
            return new AxeSandBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_sand_bamboo_mold"))) {
            return new HoeSandBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_sand_crimson_mold"))) {
            return new SwordSandCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_sand_crimson_mold"))) {
            return new ShovelSandCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_sand_crimson_mold"))) {
            return new PickaxeSandCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_sand_crimson_mold"))) {
            return new AxeSandCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_sand_crimson_mold"))) {
            return new HoeSandCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_sand_warped_mold"))) {
            return new SwordSandWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_sand_warped_mold"))) {
            return new ShovelSandWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_sand_warped_mold"))) {
            return new PickaxeSandWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_sand_warped_mold"))) {
            return new AxeSandWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_sand_warped_mold"))) {
            return new HoeSandWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_red_sand_oak_mold"))) {
            return new SwordRedSandOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_red_sand_oak_mold"))) {
            return new ShovelRedSandOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_red_sand_oak_mold"))) {
            return new PickaxeRedSandOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_red_sand_oak_mold"))) {
            return new AxeRedSandOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_red_sand_oak_mold"))) {
            return new HoeRedSandOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_red_sand_spruce_mold"))) {
            return new SwordRedSandSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_red_sand_spruce_mold"))) {
            return new ShovelRedSandSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_red_sand_spruce_mold"))) {
            return new PickaxeRedSandSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_red_sand_spruce_mold"))) {
            return new AxeRedSandSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_red_sand_spruce_mold"))) {
            return new HoeRedSandSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_red_sand_birch_mold"))) {
            return new SwordRedSandBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_red_sand_birch_mold"))) {
            return new ShovelRedSandBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_red_sand_birch_mold"))) {
            return new PickaxeRedSandBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_red_sand_birch_mold"))) {
            return new AxeRedSandBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_red_sand_birch_mold"))) {
            return new HoeRedSandBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_red_sand_jungle_mold"))) {
            return new SwordRedSandJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_red_sand_jungle_mold"))) {
            return new ShovelRedSandJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_red_sand_jungle_mold"))) {
            return new PickaxeRedSandJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_red_sand_jungle_mold"))) {
            return new AxeRedSandJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_red_sand_jungle_mold"))) {
            return new HoeRedSandJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_red_sand_acacia_mold"))) {
            return new SwordRedSandAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_red_sand_acacia_mold"))) {
            return new ShovelRedSandAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_red_sand_acacia_mold"))) {
            return new PickaxeRedSandAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_red_sand_acacia_mold"))) {
            return new AxeRedSandAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_red_sand_acacia_mold"))) {
            return new HoeRedSandAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_red_sand_dark_oak_mold"))) {
            return new SwordRedSandDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_red_sand_dark_oak_mold"))) {
            return new ShovelRedSandDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_red_sand_dark_oak_mold"))) {
            return new PickaxeRedSandDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_red_sand_dark_oak_mold"))) {
            return new AxeRedSandDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_red_sand_dark_oak_mold"))) {
            return new HoeRedSandDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_red_sand_mangrove_mold"))) {
            return new SwordRedSandMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_red_sand_mangrove_mold"))) {
            return new ShovelRedSandMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_red_sand_mangrove_mold"))) {
            return new PickaxeRedSandMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_red_sand_mangrove_mold"))) {
            return new AxeRedSandMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_red_sand_mangrove_mold"))) {
            return new HoeRedSandMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_red_sand_cherry_mold"))) {
            return new SwordRedSandCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_red_sand_cherry_mold"))) {
            return new ShovelRedSandCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_red_sand_cherry_mold"))) {
            return new PickaxeRedSandCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_red_sand_cherry_mold"))) {
            return new AxeRedSandCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_red_sand_cherry_mold"))) {
            return new HoeRedSandCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_red_sand_bamboo_mold"))) {
            return new SwordRedSandBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_red_sand_bamboo_mold"))) {
            return new ShovelRedSandBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_red_sand_bamboo_mold"))) {
            return new PickaxeRedSandBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_red_sand_bamboo_mold"))) {
            return new AxeRedSandBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_red_sand_bamboo_mold"))) {
            return new HoeRedSandBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_red_sand_crimson_mold"))) {
            return new SwordRedSandCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_red_sand_crimson_mold"))) {
            return new ShovelRedSandCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_red_sand_crimson_mold"))) {
            return new PickaxeRedSandCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_red_sand_crimson_mold"))) {
            return new AxeRedSandCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_red_sand_crimson_mold"))) {
            return new HoeRedSandCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_red_sand_warped_mold"))) {
            return new SwordRedSandWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_red_sand_warped_mold"))) {
            return new ShovelRedSandWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_red_sand_warped_mold"))) {
            return new PickaxeRedSandWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_red_sand_warped_mold"))) {
            return new AxeRedSandWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_red_sand_warped_mold"))) {
            return new HoeRedSandWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_white_concrete_powder_oak_mold"))) {
            return new SwordWhiteConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_white_concrete_powder_oak_mold"))) {
            return new ShovelWhiteConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_white_concrete_powder_oak_mold"))) {
            return new PickaxeWhiteConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_white_concrete_powder_oak_mold"))) {
            return new AxeWhiteConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_white_concrete_powder_oak_mold"))) {
            return new HoeWhiteConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_white_concrete_powder_spruce_mold"))) {
            return new SwordWhiteConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_white_concrete_powder_spruce_mold"))) {
            return new ShovelWhiteConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_white_concrete_powder_spruce_mold"))) {
            return new PickaxeWhiteConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_white_concrete_powder_spruce_mold"))) {
            return new AxeWhiteConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_white_concrete_powder_spruce_mold"))) {
            return new HoeWhiteConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_white_concrete_powder_birch_mold"))) {
            return new SwordWhiteConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_white_concrete_powder_birch_mold"))) {
            return new ShovelWhiteConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_white_concrete_powder_birch_mold"))) {
            return new PickaxeWhiteConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_white_concrete_powder_birch_mold"))) {
            return new AxeWhiteConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_white_concrete_powder_birch_mold"))) {
            return new HoeWhiteConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_white_concrete_powder_jungle_mold"))) {
            return new SwordWhiteConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_white_concrete_powder_jungle_mold"))) {
            return new ShovelWhiteConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_white_concrete_powder_jungle_mold"))) {
            return new PickaxeWhiteConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_white_concrete_powder_jungle_mold"))) {
            return new AxeWhiteConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_white_concrete_powder_jungle_mold"))) {
            return new HoeWhiteConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_white_concrete_powder_acacia_mold"))) {
            return new SwordWhiteConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_white_concrete_powder_acacia_mold"))) {
            return new ShovelWhiteConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_white_concrete_powder_acacia_mold"))) {
            return new PickaxeWhiteConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_white_concrete_powder_acacia_mold"))) {
            return new AxeWhiteConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_white_concrete_powder_acacia_mold"))) {
            return new HoeWhiteConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_white_concrete_powder_dark_oak_mold"))) {
            return new SwordWhiteConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_white_concrete_powder_dark_oak_mold"))) {
            return new ShovelWhiteConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_white_concrete_powder_dark_oak_mold"))) {
            return new PickaxeWhiteConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_white_concrete_powder_dark_oak_mold"))) {
            return new AxeWhiteConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_white_concrete_powder_dark_oak_mold"))) {
            return new HoeWhiteConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_white_concrete_powder_mangrove_mold"))) {
            return new SwordWhiteConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_white_concrete_powder_mangrove_mold"))) {
            return new ShovelWhiteConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_white_concrete_powder_mangrove_mold"))) {
            return new PickaxeWhiteConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_white_concrete_powder_mangrove_mold"))) {
            return new AxeWhiteConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_white_concrete_powder_mangrove_mold"))) {
            return new HoeWhiteConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_white_concrete_powder_cherry_mold"))) {
            return new SwordWhiteConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_white_concrete_powder_cherry_mold"))) {
            return new ShovelWhiteConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_white_concrete_powder_cherry_mold"))) {
            return new PickaxeWhiteConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_white_concrete_powder_cherry_mold"))) {
            return new AxeWhiteConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_white_concrete_powder_cherry_mold"))) {
            return new HoeWhiteConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_white_concrete_powder_bamboo_mold"))) {
            return new SwordWhiteConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_white_concrete_powder_bamboo_mold"))) {
            return new ShovelWhiteConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_white_concrete_powder_bamboo_mold"))) {
            return new PickaxeWhiteConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_white_concrete_powder_bamboo_mold"))) {
            return new AxeWhiteConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_white_concrete_powder_bamboo_mold"))) {
            return new HoeWhiteConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_white_concrete_powder_crimson_mold"))) {
            return new SwordWhiteConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_white_concrete_powder_crimson_mold"))) {
            return new ShovelWhiteConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_white_concrete_powder_crimson_mold"))) {
            return new PickaxeWhiteConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_white_concrete_powder_crimson_mold"))) {
            return new AxeWhiteConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_white_concrete_powder_crimson_mold"))) {
            return new HoeWhiteConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_white_concrete_powder_warped_mold"))) {
            return new SwordWhiteConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_white_concrete_powder_warped_mold"))) {
            return new ShovelWhiteConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_white_concrete_powder_warped_mold"))) {
            return new PickaxeWhiteConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_white_concrete_powder_warped_mold"))) {
            return new AxeWhiteConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_white_concrete_powder_warped_mold"))) {
            return new HoeWhiteConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_light_gray_concrete_powder_oak_mold"))) {
            return new SwordLightGrayConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_light_gray_concrete_powder_oak_mold"))) {
            return new ShovelLightGrayConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_light_gray_concrete_powder_oak_mold"))) {
            return new PickaxeLightGrayConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_light_gray_concrete_powder_oak_mold"))) {
            return new AxeLightGrayConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_light_gray_concrete_powder_oak_mold"))) {
            return new HoeLightGrayConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_light_gray_concrete_powder_spruce_mold"))) {
            return new SwordLightGrayConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_light_gray_concrete_powder_spruce_mold"))) {
            return new ShovelLightGrayConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_light_gray_concrete_powder_spruce_mold"))) {
            return new PickaxeLightGrayConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_light_gray_concrete_powder_spruce_mold"))) {
            return new AxeLightGrayConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_light_gray_concrete_powder_spruce_mold"))) {
            return new HoeLightGrayConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_light_gray_concrete_powder_birch_mold"))) {
            return new SwordLightGrayConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_light_gray_concrete_powder_birch_mold"))) {
            return new ShovelLightGrayConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_light_gray_concrete_powder_birch_mold"))) {
            return new PickaxeLightGrayConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_light_gray_concrete_powder_birch_mold"))) {
            return new AxeLightGrayConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_light_gray_concrete_powder_birch_mold"))) {
            return new HoeLightGrayConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_light_gray_concrete_powder_jungle_mold"))) {
            return new SwordLightGrayConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_light_gray_concrete_powder_jungle_mold"))) {
            return new ShovelLightGrayConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_light_gray_concrete_powder_jungle_mold"))) {
            return new PickaxeLightGrayConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_light_gray_concrete_powder_jungle_mold"))) {
            return new AxeLightGrayConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_light_gray_concrete_powder_jungle_mold"))) {
            return new HoeLightGrayConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_light_gray_concrete_powder_acacia_mold"))) {
            return new SwordLightGrayConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_light_gray_concrete_powder_acacia_mold"))) {
            return new ShovelLightGrayConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_light_gray_concrete_powder_acacia_mold"))) {
            return new PickaxeLightGrayConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_light_gray_concrete_powder_acacia_mold"))) {
            return new AxeLightGrayConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_light_gray_concrete_powder_acacia_mold"))) {
            return new HoeLightGrayConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_light_gray_concrete_powder_dark_oak_mold"))) {
            return new SwordLightGrayConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_light_gray_concrete_powder_dark_oak_mold"))) {
            return new ShovelLightGrayConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_light_gray_concrete_powder_dark_oak_mold"))) {
            return new PickaxeLightGrayConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_light_gray_concrete_powder_dark_oak_mold"))) {
            return new AxeLightGrayConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_light_gray_concrete_powder_dark_oak_mold"))) {
            return new HoeLightGrayConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_light_gray_concrete_powder_mangrove_mold"))) {
            return new SwordLightGrayConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_light_gray_concrete_powder_mangrove_mold"))) {
            return new ShovelLightGrayConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_light_gray_concrete_powder_mangrove_mold"))) {
            return new PickaxeLightGrayConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_light_gray_concrete_powder_mangrove_mold"))) {
            return new AxeLightGrayConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_light_gray_concrete_powder_mangrove_mold"))) {
            return new HoeLightGrayConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_light_gray_concrete_powder_cherry_mold"))) {
            return new SwordLightGrayConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_light_gray_concrete_powder_cherry_mold"))) {
            return new ShovelLightGrayConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_light_gray_concrete_powder_cherry_mold"))) {
            return new PickaxeLightGrayConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_light_gray_concrete_powder_cherry_mold"))) {
            return new AxeLightGrayConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_light_gray_concrete_powder_cherry_mold"))) {
            return new HoeLightGrayConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_light_gray_concrete_powder_bamboo_mold"))) {
            return new SwordLightGrayConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_light_gray_concrete_powder_bamboo_mold"))) {
            return new ShovelLightGrayConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_light_gray_concrete_powder_bamboo_mold"))) {
            return new PickaxeLightGrayConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_light_gray_concrete_powder_bamboo_mold"))) {
            return new AxeLightGrayConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_light_gray_concrete_powder_bamboo_mold"))) {
            return new HoeLightGrayConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_light_gray_concrete_powder_crimson_mold"))) {
            return new SwordLightGrayConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_light_gray_concrete_powder_crimson_mold"))) {
            return new ShovelLightGrayConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_light_gray_concrete_powder_crimson_mold"))) {
            return new PickaxeLightGrayConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_light_gray_concrete_powder_crimson_mold"))) {
            return new AxeLightGrayConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_light_gray_concrete_powder_crimson_mold"))) {
            return new HoeLightGrayConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_light_gray_concrete_powder_warped_mold"))) {
            return new SwordLightGrayConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_light_gray_concrete_powder_warped_mold"))) {
            return new ShovelLightGrayConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_light_gray_concrete_powder_warped_mold"))) {
            return new PickaxeLightGrayConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_light_gray_concrete_powder_warped_mold"))) {
            return new AxeLightGrayConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_light_gray_concrete_powder_warped_mold"))) {
            return new HoeLightGrayConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_gray_concrete_powder_oak_mold"))) {
            return new SwordGrayConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_gray_concrete_powder_oak_mold"))) {
            return new ShovelGrayConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_gray_concrete_powder_oak_mold"))) {
            return new PickaxeGrayConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_gray_concrete_powder_oak_mold"))) {
            return new AxeGrayConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_gray_concrete_powder_oak_mold"))) {
            return new HoeGrayConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_gray_concrete_powder_spruce_mold"))) {
            return new SwordGrayConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_gray_concrete_powder_spruce_mold"))) {
            return new ShovelGrayConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_gray_concrete_powder_spruce_mold"))) {
            return new PickaxeGrayConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_gray_concrete_powder_spruce_mold"))) {
            return new AxeGrayConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_gray_concrete_powder_spruce_mold"))) {
            return new HoeGrayConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_gray_concrete_powder_birch_mold"))) {
            return new SwordGrayConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_gray_concrete_powder_birch_mold"))) {
            return new ShovelGrayConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_gray_concrete_powder_birch_mold"))) {
            return new PickaxeGrayConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_gray_concrete_powder_birch_mold"))) {
            return new AxeGrayConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_gray_concrete_powder_birch_mold"))) {
            return new HoeGrayConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_gray_concrete_powder_jungle_mold"))) {
            return new SwordGrayConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_gray_concrete_powder_jungle_mold"))) {
            return new ShovelGrayConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_gray_concrete_powder_jungle_mold"))) {
            return new PickaxeGrayConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_gray_concrete_powder_jungle_mold"))) {
            return new AxeGrayConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_gray_concrete_powder_jungle_mold"))) {
            return new HoeGrayConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_gray_concrete_powder_acacia_mold"))) {
            return new SwordGrayConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_gray_concrete_powder_acacia_mold"))) {
            return new ShovelGrayConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_gray_concrete_powder_acacia_mold"))) {
            return new PickaxeGrayConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_gray_concrete_powder_acacia_mold"))) {
            return new AxeGrayConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_gray_concrete_powder_acacia_mold"))) {
            return new HoeGrayConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_gray_concrete_powder_dark_oak_mold"))) {
            return new SwordGrayConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_gray_concrete_powder_dark_oak_mold"))) {
            return new ShovelGrayConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_gray_concrete_powder_dark_oak_mold"))) {
            return new PickaxeGrayConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_gray_concrete_powder_dark_oak_mold"))) {
            return new AxeGrayConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_gray_concrete_powder_dark_oak_mold"))) {
            return new HoeGrayConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_gray_concrete_powder_mangrove_mold"))) {
            return new SwordGrayConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_gray_concrete_powder_mangrove_mold"))) {
            return new ShovelGrayConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_gray_concrete_powder_mangrove_mold"))) {
            return new PickaxeGrayConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_gray_concrete_powder_mangrove_mold"))) {
            return new AxeGrayConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_gray_concrete_powder_mangrove_mold"))) {
            return new HoeGrayConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_gray_concrete_powder_cherry_mold"))) {
            return new SwordGrayConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_gray_concrete_powder_cherry_mold"))) {
            return new ShovelGrayConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_gray_concrete_powder_cherry_mold"))) {
            return new PickaxeGrayConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_gray_concrete_powder_cherry_mold"))) {
            return new AxeGrayConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_gray_concrete_powder_cherry_mold"))) {
            return new HoeGrayConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_gray_concrete_powder_bamboo_mold"))) {
            return new SwordGrayConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_gray_concrete_powder_bamboo_mold"))) {
            return new ShovelGrayConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_gray_concrete_powder_bamboo_mold"))) {
            return new PickaxeGrayConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_gray_concrete_powder_bamboo_mold"))) {
            return new AxeGrayConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_gray_concrete_powder_bamboo_mold"))) {
            return new HoeGrayConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_gray_concrete_powder_crimson_mold"))) {
            return new SwordGrayConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_gray_concrete_powder_crimson_mold"))) {
            return new ShovelGrayConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_gray_concrete_powder_crimson_mold"))) {
            return new PickaxeGrayConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_gray_concrete_powder_crimson_mold"))) {
            return new AxeGrayConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_gray_concrete_powder_crimson_mold"))) {
            return new HoeGrayConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_gray_concrete_powder_warped_mold"))) {
            return new SwordGrayConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_gray_concrete_powder_warped_mold"))) {
            return new ShovelGrayConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_gray_concrete_powder_warped_mold"))) {
            return new PickaxeGrayConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_gray_concrete_powder_warped_mold"))) {
            return new AxeGrayConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_gray_concrete_powder_warped_mold"))) {
            return new HoeGrayConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_black_concrete_powder_oak_mold"))) {
            return new SwordBlackConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_black_concrete_powder_oak_mold"))) {
            return new ShovelBlackConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_black_concrete_powder_oak_mold"))) {
            return new PickaxeBlackConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_black_concrete_powder_oak_mold"))) {
            return new AxeBlackConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_black_concrete_powder_oak_mold"))) {
            return new HoeBlackConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_black_concrete_powder_spruce_mold"))) {
            return new SwordBlackConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_black_concrete_powder_spruce_mold"))) {
            return new ShovelBlackConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_black_concrete_powder_spruce_mold"))) {
            return new PickaxeBlackConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_black_concrete_powder_spruce_mold"))) {
            return new AxeBlackConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_black_concrete_powder_spruce_mold"))) {
            return new HoeBlackConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_black_concrete_powder_birch_mold"))) {
            return new SwordBlackConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_black_concrete_powder_birch_mold"))) {
            return new ShovelBlackConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_black_concrete_powder_birch_mold"))) {
            return new PickaxeBlackConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_black_concrete_powder_birch_mold"))) {
            return new AxeBlackConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_black_concrete_powder_birch_mold"))) {
            return new HoeBlackConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_black_concrete_powder_jungle_mold"))) {
            return new SwordBlackConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_black_concrete_powder_jungle_mold"))) {
            return new ShovelBlackConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_black_concrete_powder_jungle_mold"))) {
            return new PickaxeBlackConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_black_concrete_powder_jungle_mold"))) {
            return new AxeBlackConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_black_concrete_powder_jungle_mold"))) {
            return new HoeBlackConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_black_concrete_powder_acacia_mold"))) {
            return new SwordBlackConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_black_concrete_powder_acacia_mold"))) {
            return new ShovelBlackConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_black_concrete_powder_acacia_mold"))) {
            return new PickaxeBlackConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_black_concrete_powder_acacia_mold"))) {
            return new AxeBlackConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_black_concrete_powder_acacia_mold"))) {
            return new HoeBlackConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_black_concrete_powder_dark_oak_mold"))) {
            return new SwordBlackConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_black_concrete_powder_dark_oak_mold"))) {
            return new ShovelBlackConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_black_concrete_powder_dark_oak_mold"))) {
            return new PickaxeBlackConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_black_concrete_powder_dark_oak_mold"))) {
            return new AxeBlackConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_black_concrete_powder_dark_oak_mold"))) {
            return new HoeBlackConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_black_concrete_powder_mangrove_mold"))) {
            return new SwordBlackConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_black_concrete_powder_mangrove_mold"))) {
            return new ShovelBlackConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_black_concrete_powder_mangrove_mold"))) {
            return new PickaxeBlackConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_black_concrete_powder_mangrove_mold"))) {
            return new AxeBlackConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_black_concrete_powder_mangrove_mold"))) {
            return new HoeBlackConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_black_concrete_powder_cherry_mold"))) {
            return new SwordBlackConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_black_concrete_powder_cherry_mold"))) {
            return new ShovelBlackConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_black_concrete_powder_cherry_mold"))) {
            return new PickaxeBlackConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_black_concrete_powder_cherry_mold"))) {
            return new AxeBlackConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_black_concrete_powder_cherry_mold"))) {
            return new HoeBlackConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_black_concrete_powder_bamboo_mold"))) {
            return new SwordBlackConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_black_concrete_powder_bamboo_mold"))) {
            return new ShovelBlackConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_black_concrete_powder_bamboo_mold"))) {
            return new PickaxeBlackConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_black_concrete_powder_bamboo_mold"))) {
            return new AxeBlackConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_black_concrete_powder_bamboo_mold"))) {
            return new HoeBlackConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_black_concrete_powder_crimson_mold"))) {
            return new SwordBlackConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_black_concrete_powder_crimson_mold"))) {
            return new ShovelBlackConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_black_concrete_powder_crimson_mold"))) {
            return new PickaxeBlackConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_black_concrete_powder_crimson_mold"))) {
            return new AxeBlackConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_black_concrete_powder_crimson_mold"))) {
            return new HoeBlackConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_black_concrete_powder_warped_mold"))) {
            return new SwordBlackConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_black_concrete_powder_warped_mold"))) {
            return new ShovelBlackConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_black_concrete_powder_warped_mold"))) {
            return new PickaxeBlackConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_black_concrete_powder_warped_mold"))) {
            return new AxeBlackConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_black_concrete_powder_warped_mold"))) {
            return new HoeBlackConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_brown_concrete_powder_oak_mold"))) {
            return new SwordBrownConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_brown_concrete_powder_oak_mold"))) {
            return new ShovelBrownConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_brown_concrete_powder_oak_mold"))) {
            return new PickaxeBrownConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_brown_concrete_powder_oak_mold"))) {
            return new AxeBrownConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_brown_concrete_powder_oak_mold"))) {
            return new HoeBrownConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_brown_concrete_powder_spruce_mold"))) {
            return new SwordBrownConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_brown_concrete_powder_spruce_mold"))) {
            return new ShovelBrownConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_brown_concrete_powder_spruce_mold"))) {
            return new PickaxeBrownConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_brown_concrete_powder_spruce_mold"))) {
            return new AxeBrownConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_brown_concrete_powder_spruce_mold"))) {
            return new HoeBrownConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_brown_concrete_powder_birch_mold"))) {
            return new SwordBrownConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_brown_concrete_powder_birch_mold"))) {
            return new ShovelBrownConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_brown_concrete_powder_birch_mold"))) {
            return new PickaxeBrownConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_brown_concrete_powder_birch_mold"))) {
            return new AxeBrownConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_brown_concrete_powder_birch_mold"))) {
            return new HoeBrownConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_brown_concrete_powder_jungle_mold"))) {
            return new SwordBrownConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_brown_concrete_powder_jungle_mold"))) {
            return new ShovelBrownConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_brown_concrete_powder_jungle_mold"))) {
            return new PickaxeBrownConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_brown_concrete_powder_jungle_mold"))) {
            return new AxeBrownConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_brown_concrete_powder_jungle_mold"))) {
            return new HoeBrownConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_brown_concrete_powder_acacia_mold"))) {
            return new SwordBrownConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_brown_concrete_powder_acacia_mold"))) {
            return new ShovelBrownConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_brown_concrete_powder_acacia_mold"))) {
            return new PickaxeBrownConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_brown_concrete_powder_acacia_mold"))) {
            return new AxeBrownConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_brown_concrete_powder_acacia_mold"))) {
            return new HoeBrownConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_brown_concrete_powder_dark_oak_mold"))) {
            return new SwordBrownConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_brown_concrete_powder_dark_oak_mold"))) {
            return new ShovelBrownConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_brown_concrete_powder_dark_oak_mold"))) {
            return new PickaxeBrownConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_brown_concrete_powder_dark_oak_mold"))) {
            return new AxeBrownConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_brown_concrete_powder_dark_oak_mold"))) {
            return new HoeBrownConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_brown_concrete_powder_mangrove_mold"))) {
            return new SwordBrownConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_brown_concrete_powder_mangrove_mold"))) {
            return new ShovelBrownConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_brown_concrete_powder_mangrove_mold"))) {
            return new PickaxeBrownConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_brown_concrete_powder_mangrove_mold"))) {
            return new AxeBrownConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_brown_concrete_powder_mangrove_mold"))) {
            return new HoeBrownConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_brown_concrete_powder_cherry_mold"))) {
            return new SwordBrownConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_brown_concrete_powder_cherry_mold"))) {
            return new ShovelBrownConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_brown_concrete_powder_cherry_mold"))) {
            return new PickaxeBrownConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_brown_concrete_powder_cherry_mold"))) {
            return new AxeBrownConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_brown_concrete_powder_cherry_mold"))) {
            return new HoeBrownConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_brown_concrete_powder_bamboo_mold"))) {
            return new SwordBrownConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_brown_concrete_powder_bamboo_mold"))) {
            return new ShovelBrownConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_brown_concrete_powder_bamboo_mold"))) {
            return new PickaxeBrownConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_brown_concrete_powder_bamboo_mold"))) {
            return new AxeBrownConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_brown_concrete_powder_bamboo_mold"))) {
            return new HoeBrownConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_brown_concrete_powder_crimson_mold"))) {
            return new SwordBrownConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_brown_concrete_powder_crimson_mold"))) {
            return new ShovelBrownConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_brown_concrete_powder_crimson_mold"))) {
            return new PickaxeBrownConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_brown_concrete_powder_crimson_mold"))) {
            return new AxeBrownConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_brown_concrete_powder_crimson_mold"))) {
            return new HoeBrownConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_brown_concrete_powder_warped_mold"))) {
            return new SwordBrownConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_brown_concrete_powder_warped_mold"))) {
            return new ShovelBrownConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_brown_concrete_powder_warped_mold"))) {
            return new PickaxeBrownConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_brown_concrete_powder_warped_mold"))) {
            return new AxeBrownConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_brown_concrete_powder_warped_mold"))) {
            return new HoeBrownConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_red_concrete_powder_oak_mold"))) {
            return new SwordRedConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_red_concrete_powder_oak_mold"))) {
            return new ShovelRedConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_red_concrete_powder_oak_mold"))) {
            return new PickaxeRedConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_red_concrete_powder_oak_mold"))) {
            return new AxeRedConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_red_concrete_powder_oak_mold"))) {
            return new HoeRedConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_red_concrete_powder_spruce_mold"))) {
            return new SwordRedConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_red_concrete_powder_spruce_mold"))) {
            return new ShovelRedConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_red_concrete_powder_spruce_mold"))) {
            return new PickaxeRedConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_red_concrete_powder_spruce_mold"))) {
            return new AxeRedConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_red_concrete_powder_spruce_mold"))) {
            return new HoeRedConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_red_concrete_powder_birch_mold"))) {
            return new SwordRedConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_red_concrete_powder_birch_mold"))) {
            return new ShovelRedConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_red_concrete_powder_birch_mold"))) {
            return new PickaxeRedConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_red_concrete_powder_birch_mold"))) {
            return new AxeRedConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_red_concrete_powder_birch_mold"))) {
            return new HoeRedConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_red_concrete_powder_jungle_mold"))) {
            return new SwordRedConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_red_concrete_powder_jungle_mold"))) {
            return new ShovelRedConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_red_concrete_powder_jungle_mold"))) {
            return new PickaxeRedConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_red_concrete_powder_jungle_mold"))) {
            return new AxeRedConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_red_concrete_powder_jungle_mold"))) {
            return new HoeRedConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_red_concrete_powder_acacia_mold"))) {
            return new SwordRedConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_red_concrete_powder_acacia_mold"))) {
            return new ShovelRedConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_red_concrete_powder_acacia_mold"))) {
            return new PickaxeRedConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_red_concrete_powder_acacia_mold"))) {
            return new AxeRedConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_red_concrete_powder_acacia_mold"))) {
            return new HoeRedConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_red_concrete_powder_dark_oak_mold"))) {
            return new SwordRedConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_red_concrete_powder_dark_oak_mold"))) {
            return new ShovelRedConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_red_concrete_powder_dark_oak_mold"))) {
            return new PickaxeRedConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_red_concrete_powder_dark_oak_mold"))) {
            return new AxeRedConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_red_concrete_powder_dark_oak_mold"))) {
            return new HoeRedConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_red_concrete_powder_mangrove_mold"))) {
            return new SwordRedConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_red_concrete_powder_mangrove_mold"))) {
            return new ShovelRedConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_red_concrete_powder_mangrove_mold"))) {
            return new PickaxeRedConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_red_concrete_powder_mangrove_mold"))) {
            return new AxeRedConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_red_concrete_powder_mangrove_mold"))) {
            return new HoeRedConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_red_concrete_powder_cherry_mold"))) {
            return new SwordRedConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_red_concrete_powder_cherry_mold"))) {
            return new ShovelRedConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_red_concrete_powder_cherry_mold"))) {
            return new PickaxeRedConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_red_concrete_powder_cherry_mold"))) {
            return new AxeRedConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_red_concrete_powder_cherry_mold"))) {
            return new HoeRedConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_red_concrete_powder_bamboo_mold"))) {
            return new SwordRedConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_red_concrete_powder_bamboo_mold"))) {
            return new ShovelRedConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_red_concrete_powder_bamboo_mold"))) {
            return new PickaxeRedConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_red_concrete_powder_bamboo_mold"))) {
            return new AxeRedConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_red_concrete_powder_bamboo_mold"))) {
            return new HoeRedConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_red_concrete_powder_crimson_mold"))) {
            return new SwordRedConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_red_concrete_powder_crimson_mold"))) {
            return new ShovelRedConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_red_concrete_powder_crimson_mold"))) {
            return new PickaxeRedConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_red_concrete_powder_crimson_mold"))) {
            return new AxeRedConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_red_concrete_powder_crimson_mold"))) {
            return new HoeRedConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_red_concrete_powder_warped_mold"))) {
            return new SwordRedConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_red_concrete_powder_warped_mold"))) {
            return new ShovelRedConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_red_concrete_powder_warped_mold"))) {
            return new PickaxeRedConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_red_concrete_powder_warped_mold"))) {
            return new AxeRedConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_red_concrete_powder_warped_mold"))) {
            return new HoeRedConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_orange_concrete_powder_oak_mold"))) {
            return new SwordOrangeConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_orange_concrete_powder_oak_mold"))) {
            return new ShovelOrangeConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_orange_concrete_powder_oak_mold"))) {
            return new PickaxeOrangeConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_orange_concrete_powder_oak_mold"))) {
            return new AxeOrangeConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_orange_concrete_powder_oak_mold"))) {
            return new HoeOrangeConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_orange_concrete_powder_spruce_mold"))) {
            return new SwordOrangeConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_orange_concrete_powder_spruce_mold"))) {
            return new ShovelOrangeConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_orange_concrete_powder_spruce_mold"))) {
            return new PickaxeOrangeConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_orange_concrete_powder_spruce_mold"))) {
            return new AxeOrangeConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_orange_concrete_powder_spruce_mold"))) {
            return new HoeOrangeConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_orange_concrete_powder_birch_mold"))) {
            return new SwordOrangeConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_orange_concrete_powder_birch_mold"))) {
            return new ShovelOrangeConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_orange_concrete_powder_birch_mold"))) {
            return new PickaxeOrangeConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_orange_concrete_powder_birch_mold"))) {
            return new AxeOrangeConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_orange_concrete_powder_birch_mold"))) {
            return new HoeOrangeConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_orange_concrete_powder_jungle_mold"))) {
            return new SwordOrangeConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_orange_concrete_powder_jungle_mold"))) {
            return new ShovelOrangeConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_orange_concrete_powder_jungle_mold"))) {
            return new PickaxeOrangeConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_orange_concrete_powder_jungle_mold"))) {
            return new AxeOrangeConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_orange_concrete_powder_jungle_mold"))) {
            return new HoeOrangeConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_orange_concrete_powder_acacia_mold"))) {
            return new SwordOrangeConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_orange_concrete_powder_acacia_mold"))) {
            return new ShovelOrangeConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_orange_concrete_powder_acacia_mold"))) {
            return new PickaxeOrangeConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_orange_concrete_powder_acacia_mold"))) {
            return new AxeOrangeConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_orange_concrete_powder_acacia_mold"))) {
            return new HoeOrangeConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_orange_concrete_powder_dark_oak_mold"))) {
            return new SwordOrangeConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_orange_concrete_powder_dark_oak_mold"))) {
            return new ShovelOrangeConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_orange_concrete_powder_dark_oak_mold"))) {
            return new PickaxeOrangeConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_orange_concrete_powder_dark_oak_mold"))) {
            return new AxeOrangeConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_orange_concrete_powder_dark_oak_mold"))) {
            return new HoeOrangeConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_orange_concrete_powder_mangrove_mold"))) {
            return new SwordOrangeConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_orange_concrete_powder_mangrove_mold"))) {
            return new ShovelOrangeConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_orange_concrete_powder_mangrove_mold"))) {
            return new PickaxeOrangeConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_orange_concrete_powder_mangrove_mold"))) {
            return new AxeOrangeConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_orange_concrete_powder_mangrove_mold"))) {
            return new HoeOrangeConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_orange_concrete_powder_cherry_mold"))) {
            return new SwordOrangeConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_orange_concrete_powder_cherry_mold"))) {
            return new ShovelOrangeConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_orange_concrete_powder_cherry_mold"))) {
            return new PickaxeOrangeConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_orange_concrete_powder_cherry_mold"))) {
            return new AxeOrangeConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_orange_concrete_powder_cherry_mold"))) {
            return new HoeOrangeConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_orange_concrete_powder_bamboo_mold"))) {
            return new SwordOrangeConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_orange_concrete_powder_bamboo_mold"))) {
            return new ShovelOrangeConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_orange_concrete_powder_bamboo_mold"))) {
            return new PickaxeOrangeConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_orange_concrete_powder_bamboo_mold"))) {
            return new AxeOrangeConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_orange_concrete_powder_bamboo_mold"))) {
            return new HoeOrangeConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_orange_concrete_powder_crimson_mold"))) {
            return new SwordOrangeConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_orange_concrete_powder_crimson_mold"))) {
            return new ShovelOrangeConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_orange_concrete_powder_crimson_mold"))) {
            return new PickaxeOrangeConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_orange_concrete_powder_crimson_mold"))) {
            return new AxeOrangeConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_orange_concrete_powder_crimson_mold"))) {
            return new HoeOrangeConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_orange_concrete_powder_warped_mold"))) {
            return new SwordOrangeConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_orange_concrete_powder_warped_mold"))) {
            return new ShovelOrangeConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_orange_concrete_powder_warped_mold"))) {
            return new PickaxeOrangeConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_orange_concrete_powder_warped_mold"))) {
            return new AxeOrangeConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_orange_concrete_powder_warped_mold"))) {
            return new HoeOrangeConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_yellow_concrete_powder_oak_mold"))) {
            return new SwordYellowConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_yellow_concrete_powder_oak_mold"))) {
            return new ShovelYellowConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_yellow_concrete_powder_oak_mold"))) {
            return new PickaxeYellowConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_yellow_concrete_powder_oak_mold"))) {
            return new AxeYellowConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_yellow_concrete_powder_oak_mold"))) {
            return new HoeYellowConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_yellow_concrete_powder_spruce_mold"))) {
            return new SwordYellowConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_yellow_concrete_powder_spruce_mold"))) {
            return new ShovelYellowConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_yellow_concrete_powder_spruce_mold"))) {
            return new PickaxeYellowConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_yellow_concrete_powder_spruce_mold"))) {
            return new AxeYellowConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_yellow_concrete_powder_spruce_mold"))) {
            return new HoeYellowConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_yellow_concrete_powder_birch_mold"))) {
            return new SwordYellowConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_yellow_concrete_powder_birch_mold"))) {
            return new ShovelYellowConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_yellow_concrete_powder_birch_mold"))) {
            return new PickaxeYellowConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_yellow_concrete_powder_birch_mold"))) {
            return new AxeYellowConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_yellow_concrete_powder_birch_mold"))) {
            return new HoeYellowConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_yellow_concrete_powder_jungle_mold"))) {
            return new SwordYellowConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_yellow_concrete_powder_jungle_mold"))) {
            return new ShovelYellowConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_yellow_concrete_powder_jungle_mold"))) {
            return new PickaxeYellowConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_yellow_concrete_powder_jungle_mold"))) {
            return new AxeYellowConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_yellow_concrete_powder_jungle_mold"))) {
            return new HoeYellowConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_yellow_concrete_powder_acacia_mold"))) {
            return new SwordYellowConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_yellow_concrete_powder_acacia_mold"))) {
            return new ShovelYellowConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_yellow_concrete_powder_acacia_mold"))) {
            return new PickaxeYellowConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_yellow_concrete_powder_acacia_mold"))) {
            return new AxeYellowConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_yellow_concrete_powder_acacia_mold"))) {
            return new HoeYellowConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_yellow_concrete_powder_dark_oak_mold"))) {
            return new SwordYellowConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_yellow_concrete_powder_dark_oak_mold"))) {
            return new ShovelYellowConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_yellow_concrete_powder_dark_oak_mold"))) {
            return new PickaxeYellowConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_yellow_concrete_powder_dark_oak_mold"))) {
            return new AxeYellowConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_yellow_concrete_powder_dark_oak_mold"))) {
            return new HoeYellowConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_yellow_concrete_powder_mangrove_mold"))) {
            return new SwordYellowConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_yellow_concrete_powder_mangrove_mold"))) {
            return new ShovelYellowConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_yellow_concrete_powder_mangrove_mold"))) {
            return new PickaxeYellowConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_yellow_concrete_powder_mangrove_mold"))) {
            return new AxeYellowConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_yellow_concrete_powder_mangrove_mold"))) {
            return new HoeYellowConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_yellow_concrete_powder_cherry_mold"))) {
            return new SwordYellowConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_yellow_concrete_powder_cherry_mold"))) {
            return new ShovelYellowConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_yellow_concrete_powder_cherry_mold"))) {
            return new PickaxeYellowConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_yellow_concrete_powder_cherry_mold"))) {
            return new AxeYellowConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_yellow_concrete_powder_cherry_mold"))) {
            return new HoeYellowConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_yellow_concrete_powder_bamboo_mold"))) {
            return new SwordYellowConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_yellow_concrete_powder_bamboo_mold"))) {
            return new ShovelYellowConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_yellow_concrete_powder_bamboo_mold"))) {
            return new PickaxeYellowConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_yellow_concrete_powder_bamboo_mold"))) {
            return new AxeYellowConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_yellow_concrete_powder_bamboo_mold"))) {
            return new HoeYellowConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_yellow_concrete_powder_crimson_mold"))) {
            return new SwordYellowConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_yellow_concrete_powder_crimson_mold"))) {
            return new ShovelYellowConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_yellow_concrete_powder_crimson_mold"))) {
            return new PickaxeYellowConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_yellow_concrete_powder_crimson_mold"))) {
            return new AxeYellowConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_yellow_concrete_powder_crimson_mold"))) {
            return new HoeYellowConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_yellow_concrete_powder_warped_mold"))) {
            return new SwordYellowConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_yellow_concrete_powder_warped_mold"))) {
            return new ShovelYellowConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_yellow_concrete_powder_warped_mold"))) {
            return new PickaxeYellowConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_yellow_concrete_powder_warped_mold"))) {
            return new AxeYellowConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_yellow_concrete_powder_warped_mold"))) {
            return new HoeYellowConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_lime_concrete_powder_oak_mold"))) {
            return new SwordLimeConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_lime_concrete_powder_oak_mold"))) {
            return new ShovelLimeConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_lime_concrete_powder_oak_mold"))) {
            return new PickaxeLimeConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_lime_concrete_powder_oak_mold"))) {
            return new AxeLimeConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_lime_concrete_powder_oak_mold"))) {
            return new HoeLimeConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_lime_concrete_powder_spruce_mold"))) {
            return new SwordLimeConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_lime_concrete_powder_spruce_mold"))) {
            return new ShovelLimeConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_lime_concrete_powder_spruce_mold"))) {
            return new PickaxeLimeConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_lime_concrete_powder_spruce_mold"))) {
            return new AxeLimeConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_lime_concrete_powder_spruce_mold"))) {
            return new HoeLimeConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_lime_concrete_powder_birch_mold"))) {
            return new SwordLimeConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_lime_concrete_powder_birch_mold"))) {
            return new ShovelLimeConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_lime_concrete_powder_birch_mold"))) {
            return new PickaxeLimeConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_lime_concrete_powder_birch_mold"))) {
            return new AxeLimeConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_lime_concrete_powder_birch_mold"))) {
            return new HoeLimeConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_lime_concrete_powder_jungle_mold"))) {
            return new SwordLimeConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_lime_concrete_powder_jungle_mold"))) {
            return new ShovelLimeConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_lime_concrete_powder_jungle_mold"))) {
            return new PickaxeLimeConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_lime_concrete_powder_jungle_mold"))) {
            return new AxeLimeConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_lime_concrete_powder_jungle_mold"))) {
            return new HoeLimeConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_lime_concrete_powder_acacia_mold"))) {
            return new SwordLimeConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_lime_concrete_powder_acacia_mold"))) {
            return new ShovelLimeConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_lime_concrete_powder_acacia_mold"))) {
            return new PickaxeLimeConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_lime_concrete_powder_acacia_mold"))) {
            return new AxeLimeConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_lime_concrete_powder_acacia_mold"))) {
            return new HoeLimeConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_lime_concrete_powder_dark_oak_mold"))) {
            return new SwordLimeConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_lime_concrete_powder_dark_oak_mold"))) {
            return new ShovelLimeConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_lime_concrete_powder_dark_oak_mold"))) {
            return new PickaxeLimeConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_lime_concrete_powder_dark_oak_mold"))) {
            return new AxeLimeConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_lime_concrete_powder_dark_oak_mold"))) {
            return new HoeLimeConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_lime_concrete_powder_mangrove_mold"))) {
            return new SwordLimeConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_lime_concrete_powder_mangrove_mold"))) {
            return new ShovelLimeConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_lime_concrete_powder_mangrove_mold"))) {
            return new PickaxeLimeConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_lime_concrete_powder_mangrove_mold"))) {
            return new AxeLimeConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_lime_concrete_powder_mangrove_mold"))) {
            return new HoeLimeConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_lime_concrete_powder_cherry_mold"))) {
            return new SwordLimeConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_lime_concrete_powder_cherry_mold"))) {
            return new ShovelLimeConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_lime_concrete_powder_cherry_mold"))) {
            return new PickaxeLimeConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_lime_concrete_powder_cherry_mold"))) {
            return new AxeLimeConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_lime_concrete_powder_cherry_mold"))) {
            return new HoeLimeConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_lime_concrete_powder_bamboo_mold"))) {
            return new SwordLimeConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_lime_concrete_powder_bamboo_mold"))) {
            return new ShovelLimeConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_lime_concrete_powder_bamboo_mold"))) {
            return new PickaxeLimeConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_lime_concrete_powder_bamboo_mold"))) {
            return new AxeLimeConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_lime_concrete_powder_bamboo_mold"))) {
            return new HoeLimeConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_lime_concrete_powder_crimson_mold"))) {
            return new SwordLimeConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_lime_concrete_powder_crimson_mold"))) {
            return new ShovelLimeConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_lime_concrete_powder_crimson_mold"))) {
            return new PickaxeLimeConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_lime_concrete_powder_crimson_mold"))) {
            return new AxeLimeConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_lime_concrete_powder_crimson_mold"))) {
            return new HoeLimeConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_lime_concrete_powder_warped_mold"))) {
            return new SwordLimeConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_lime_concrete_powder_warped_mold"))) {
            return new ShovelLimeConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_lime_concrete_powder_warped_mold"))) {
            return new PickaxeLimeConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_lime_concrete_powder_warped_mold"))) {
            return new AxeLimeConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_lime_concrete_powder_warped_mold"))) {
            return new HoeLimeConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_green_concrete_powder_oak_mold"))) {
            return new SwordGreenConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_green_concrete_powder_oak_mold"))) {
            return new ShovelGreenConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_green_concrete_powder_oak_mold"))) {
            return new PickaxeGreenConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_green_concrete_powder_oak_mold"))) {
            return new AxeGreenConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_green_concrete_powder_oak_mold"))) {
            return new HoeGreenConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_green_concrete_powder_spruce_mold"))) {
            return new SwordGreenConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_green_concrete_powder_spruce_mold"))) {
            return new ShovelGreenConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_green_concrete_powder_spruce_mold"))) {
            return new PickaxeGreenConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_green_concrete_powder_spruce_mold"))) {
            return new AxeGreenConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_green_concrete_powder_spruce_mold"))) {
            return new HoeGreenConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_green_concrete_powder_birch_mold"))) {
            return new SwordGreenConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_green_concrete_powder_birch_mold"))) {
            return new ShovelGreenConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_green_concrete_powder_birch_mold"))) {
            return new PickaxeGreenConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_green_concrete_powder_birch_mold"))) {
            return new AxeGreenConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_green_concrete_powder_birch_mold"))) {
            return new HoeGreenConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_green_concrete_powder_jungle_mold"))) {
            return new SwordGreenConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_green_concrete_powder_jungle_mold"))) {
            return new ShovelGreenConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_green_concrete_powder_jungle_mold"))) {
            return new PickaxeGreenConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_green_concrete_powder_jungle_mold"))) {
            return new AxeGreenConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_green_concrete_powder_jungle_mold"))) {
            return new HoeGreenConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_green_concrete_powder_acacia_mold"))) {
            return new SwordGreenConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_green_concrete_powder_acacia_mold"))) {
            return new ShovelGreenConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_green_concrete_powder_acacia_mold"))) {
            return new PickaxeGreenConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_green_concrete_powder_acacia_mold"))) {
            return new AxeGreenConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_green_concrete_powder_acacia_mold"))) {
            return new HoeGreenConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_green_concrete_powder_dark_oak_mold"))) {
            return new SwordGreenConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_green_concrete_powder_dark_oak_mold"))) {
            return new ShovelGreenConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_green_concrete_powder_dark_oak_mold"))) {
            return new PickaxeGreenConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_green_concrete_powder_dark_oak_mold"))) {
            return new AxeGreenConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_green_concrete_powder_dark_oak_mold"))) {
            return new HoeGreenConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_green_concrete_powder_mangrove_mold"))) {
            return new SwordGreenConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_green_concrete_powder_mangrove_mold"))) {
            return new ShovelGreenConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_green_concrete_powder_mangrove_mold"))) {
            return new PickaxeGreenConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_green_concrete_powder_mangrove_mold"))) {
            return new AxeGreenConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_green_concrete_powder_mangrove_mold"))) {
            return new HoeGreenConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_green_concrete_powder_cherry_mold"))) {
            return new SwordGreenConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_green_concrete_powder_cherry_mold"))) {
            return new ShovelGreenConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_green_concrete_powder_cherry_mold"))) {
            return new PickaxeGreenConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_green_concrete_powder_cherry_mold"))) {
            return new AxeGreenConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_green_concrete_powder_cherry_mold"))) {
            return new HoeGreenConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_green_concrete_powder_bamboo_mold"))) {
            return new SwordGreenConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_green_concrete_powder_bamboo_mold"))) {
            return new ShovelGreenConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_green_concrete_powder_bamboo_mold"))) {
            return new PickaxeGreenConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_green_concrete_powder_bamboo_mold"))) {
            return new AxeGreenConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_green_concrete_powder_bamboo_mold"))) {
            return new HoeGreenConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_green_concrete_powder_crimson_mold"))) {
            return new SwordGreenConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_green_concrete_powder_crimson_mold"))) {
            return new ShovelGreenConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_green_concrete_powder_crimson_mold"))) {
            return new PickaxeGreenConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_green_concrete_powder_crimson_mold"))) {
            return new AxeGreenConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_green_concrete_powder_crimson_mold"))) {
            return new HoeGreenConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_green_concrete_powder_warped_mold"))) {
            return new SwordGreenConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_green_concrete_powder_warped_mold"))) {
            return new ShovelGreenConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_green_concrete_powder_warped_mold"))) {
            return new PickaxeGreenConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_green_concrete_powder_warped_mold"))) {
            return new AxeGreenConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_green_concrete_powder_warped_mold"))) {
            return new HoeGreenConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_cyan_concrete_powder_oak_mold"))) {
            return new SwordCyanConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_cyan_concrete_powder_oak_mold"))) {
            return new ShovelCyanConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_cyan_concrete_powder_oak_mold"))) {
            return new PickaxeCyanConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_cyan_concrete_powder_oak_mold"))) {
            return new AxeCyanConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_cyan_concrete_powder_oak_mold"))) {
            return new HoeCyanConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_cyan_concrete_powder_spruce_mold"))) {
            return new SwordCyanConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_cyan_concrete_powder_spruce_mold"))) {
            return new ShovelCyanConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_cyan_concrete_powder_spruce_mold"))) {
            return new PickaxeCyanConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_cyan_concrete_powder_spruce_mold"))) {
            return new AxeCyanConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_cyan_concrete_powder_spruce_mold"))) {
            return new HoeCyanConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_cyan_concrete_powder_birch_mold"))) {
            return new SwordCyanConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_cyan_concrete_powder_birch_mold"))) {
            return new ShovelCyanConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_cyan_concrete_powder_birch_mold"))) {
            return new PickaxeCyanConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_cyan_concrete_powder_birch_mold"))) {
            return new AxeCyanConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_cyan_concrete_powder_birch_mold"))) {
            return new HoeCyanConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_cyan_concrete_powder_jungle_mold"))) {
            return new SwordCyanConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_cyan_concrete_powder_jungle_mold"))) {
            return new ShovelCyanConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_cyan_concrete_powder_jungle_mold"))) {
            return new PickaxeCyanConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_cyan_concrete_powder_jungle_mold"))) {
            return new AxeCyanConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_cyan_concrete_powder_jungle_mold"))) {
            return new HoeCyanConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_cyan_concrete_powder_acacia_mold"))) {
            return new SwordCyanConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_cyan_concrete_powder_acacia_mold"))) {
            return new ShovelCyanConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_cyan_concrete_powder_acacia_mold"))) {
            return new PickaxeCyanConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_cyan_concrete_powder_acacia_mold"))) {
            return new AxeCyanConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_cyan_concrete_powder_acacia_mold"))) {
            return new HoeCyanConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_cyan_concrete_powder_dark_oak_mold"))) {
            return new SwordCyanConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_cyan_concrete_powder_dark_oak_mold"))) {
            return new ShovelCyanConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_cyan_concrete_powder_dark_oak_mold"))) {
            return new PickaxeCyanConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_cyan_concrete_powder_dark_oak_mold"))) {
            return new AxeCyanConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_cyan_concrete_powder_dark_oak_mold"))) {
            return new HoeCyanConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_cyan_concrete_powder_mangrove_mold"))) {
            return new SwordCyanConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_cyan_concrete_powder_mangrove_mold"))) {
            return new ShovelCyanConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_cyan_concrete_powder_mangrove_mold"))) {
            return new PickaxeCyanConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_cyan_concrete_powder_mangrove_mold"))) {
            return new AxeCyanConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_cyan_concrete_powder_mangrove_mold"))) {
            return new HoeCyanConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_cyan_concrete_powder_cherry_mold"))) {
            return new SwordCyanConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_cyan_concrete_powder_cherry_mold"))) {
            return new ShovelCyanConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_cyan_concrete_powder_cherry_mold"))) {
            return new PickaxeCyanConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_cyan_concrete_powder_cherry_mold"))) {
            return new AxeCyanConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_cyan_concrete_powder_cherry_mold"))) {
            return new HoeCyanConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_cyan_concrete_powder_bamboo_mold"))) {
            return new SwordCyanConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_cyan_concrete_powder_bamboo_mold"))) {
            return new ShovelCyanConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_cyan_concrete_powder_bamboo_mold"))) {
            return new PickaxeCyanConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_cyan_concrete_powder_bamboo_mold"))) {
            return new AxeCyanConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_cyan_concrete_powder_bamboo_mold"))) {
            return new HoeCyanConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_cyan_concrete_powder_crimson_mold"))) {
            return new SwordCyanConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_cyan_concrete_powder_crimson_mold"))) {
            return new ShovelCyanConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_cyan_concrete_powder_crimson_mold"))) {
            return new PickaxeCyanConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_cyan_concrete_powder_crimson_mold"))) {
            return new AxeCyanConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_cyan_concrete_powder_crimson_mold"))) {
            return new HoeCyanConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_cyan_concrete_powder_warped_mold"))) {
            return new SwordCyanConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_cyan_concrete_powder_warped_mold"))) {
            return new ShovelCyanConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_cyan_concrete_powder_warped_mold"))) {
            return new PickaxeCyanConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_cyan_concrete_powder_warped_mold"))) {
            return new AxeCyanConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_cyan_concrete_powder_warped_mold"))) {
            return new HoeCyanConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_light_blue_concrete_powder_oak_mold"))) {
            return new SwordLightBlueConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_light_blue_concrete_powder_oak_mold"))) {
            return new ShovelLightBlueConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_light_blue_concrete_powder_oak_mold"))) {
            return new PickaxeLightBlueConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_light_blue_concrete_powder_oak_mold"))) {
            return new AxeLightBlueConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_light_blue_concrete_powder_oak_mold"))) {
            return new HoeLightBlueConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_light_blue_concrete_powder_spruce_mold"))) {
            return new SwordLightBlueConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_light_blue_concrete_powder_spruce_mold"))) {
            return new ShovelLightBlueConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_light_blue_concrete_powder_spruce_mold"))) {
            return new PickaxeLightBlueConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_light_blue_concrete_powder_spruce_mold"))) {
            return new AxeLightBlueConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_light_blue_concrete_powder_spruce_mold"))) {
            return new HoeLightBlueConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_light_blue_concrete_powder_birch_mold"))) {
            return new SwordLightBlueConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_light_blue_concrete_powder_birch_mold"))) {
            return new ShovelLightBlueConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_light_blue_concrete_powder_birch_mold"))) {
            return new PickaxeLightBlueConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_light_blue_concrete_powder_birch_mold"))) {
            return new AxeLightBlueConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_light_blue_concrete_powder_birch_mold"))) {
            return new HoeLightBlueConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_light_blue_concrete_powder_jungle_mold"))) {
            return new SwordLightBlueConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_light_blue_concrete_powder_jungle_mold"))) {
            return new ShovelLightBlueConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_light_blue_concrete_powder_jungle_mold"))) {
            return new PickaxeLightBlueConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_light_blue_concrete_powder_jungle_mold"))) {
            return new AxeLightBlueConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_light_blue_concrete_powder_jungle_mold"))) {
            return new HoeLightBlueConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_light_blue_concrete_powder_acacia_mold"))) {
            return new SwordLightBlueConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_light_blue_concrete_powder_acacia_mold"))) {
            return new ShovelLightBlueConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_light_blue_concrete_powder_acacia_mold"))) {
            return new PickaxeLightBlueConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_light_blue_concrete_powder_acacia_mold"))) {
            return new AxeLightBlueConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_light_blue_concrete_powder_acacia_mold"))) {
            return new HoeLightBlueConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_light_blue_concrete_powder_dark_oak_mold"))) {
            return new SwordLightBlueConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_light_blue_concrete_powder_dark_oak_mold"))) {
            return new ShovelLightBlueConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_light_blue_concrete_powder_dark_oak_mold"))) {
            return new PickaxeLightBlueConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_light_blue_concrete_powder_dark_oak_mold"))) {
            return new AxeLightBlueConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_light_blue_concrete_powder_dark_oak_mold"))) {
            return new HoeLightBlueConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_light_blue_concrete_powder_mangrove_mold"))) {
            return new SwordLightBlueConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_light_blue_concrete_powder_mangrove_mold"))) {
            return new ShovelLightBlueConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_light_blue_concrete_powder_mangrove_mold"))) {
            return new PickaxeLightBlueConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_light_blue_concrete_powder_mangrove_mold"))) {
            return new AxeLightBlueConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_light_blue_concrete_powder_mangrove_mold"))) {
            return new HoeLightBlueConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_light_blue_concrete_powder_cherry_mold"))) {
            return new SwordLightBlueConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_light_blue_concrete_powder_cherry_mold"))) {
            return new ShovelLightBlueConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_light_blue_concrete_powder_cherry_mold"))) {
            return new PickaxeLightBlueConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_light_blue_concrete_powder_cherry_mold"))) {
            return new AxeLightBlueConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_light_blue_concrete_powder_cherry_mold"))) {
            return new HoeLightBlueConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_light_blue_concrete_powder_bamboo_mold"))) {
            return new SwordLightBlueConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_light_blue_concrete_powder_bamboo_mold"))) {
            return new ShovelLightBlueConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_light_blue_concrete_powder_bamboo_mold"))) {
            return new PickaxeLightBlueConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_light_blue_concrete_powder_bamboo_mold"))) {
            return new AxeLightBlueConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_light_blue_concrete_powder_bamboo_mold"))) {
            return new HoeLightBlueConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_light_blue_concrete_powder_crimson_mold"))) {
            return new SwordLightBlueConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_light_blue_concrete_powder_crimson_mold"))) {
            return new ShovelLightBlueConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_light_blue_concrete_powder_crimson_mold"))) {
            return new PickaxeLightBlueConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_light_blue_concrete_powder_crimson_mold"))) {
            return new AxeLightBlueConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_light_blue_concrete_powder_crimson_mold"))) {
            return new HoeLightBlueConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_light_blue_concrete_powder_warped_mold"))) {
            return new SwordLightBlueConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_light_blue_concrete_powder_warped_mold"))) {
            return new ShovelLightBlueConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_light_blue_concrete_powder_warped_mold"))) {
            return new PickaxeLightBlueConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_light_blue_concrete_powder_warped_mold"))) {
            return new AxeLightBlueConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_light_blue_concrete_powder_warped_mold"))) {
            return new HoeLightBlueConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_blue_concrete_powder_oak_mold"))) {
            return new SwordBlueConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_blue_concrete_powder_oak_mold"))) {
            return new ShovelBlueConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_blue_concrete_powder_oak_mold"))) {
            return new PickaxeBlueConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_blue_concrete_powder_oak_mold"))) {
            return new AxeBlueConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_blue_concrete_powder_oak_mold"))) {
            return new HoeBlueConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_blue_concrete_powder_spruce_mold"))) {
            return new SwordBlueConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_blue_concrete_powder_spruce_mold"))) {
            return new ShovelBlueConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_blue_concrete_powder_spruce_mold"))) {
            return new PickaxeBlueConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_blue_concrete_powder_spruce_mold"))) {
            return new AxeBlueConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_blue_concrete_powder_spruce_mold"))) {
            return new HoeBlueConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_blue_concrete_powder_birch_mold"))) {
            return new SwordBlueConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_blue_concrete_powder_birch_mold"))) {
            return new ShovelBlueConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_blue_concrete_powder_birch_mold"))) {
            return new PickaxeBlueConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_blue_concrete_powder_birch_mold"))) {
            return new AxeBlueConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_blue_concrete_powder_birch_mold"))) {
            return new HoeBlueConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_blue_concrete_powder_jungle_mold"))) {
            return new SwordBlueConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_blue_concrete_powder_jungle_mold"))) {
            return new ShovelBlueConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_blue_concrete_powder_jungle_mold"))) {
            return new PickaxeBlueConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_blue_concrete_powder_jungle_mold"))) {
            return new AxeBlueConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_blue_concrete_powder_jungle_mold"))) {
            return new HoeBlueConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_blue_concrete_powder_acacia_mold"))) {
            return new SwordBlueConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_blue_concrete_powder_acacia_mold"))) {
            return new ShovelBlueConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_blue_concrete_powder_acacia_mold"))) {
            return new PickaxeBlueConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_blue_concrete_powder_acacia_mold"))) {
            return new AxeBlueConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_blue_concrete_powder_acacia_mold"))) {
            return new HoeBlueConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_blue_concrete_powder_dark_oak_mold"))) {
            return new SwordBlueConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_blue_concrete_powder_dark_oak_mold"))) {
            return new ShovelBlueConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_blue_concrete_powder_dark_oak_mold"))) {
            return new PickaxeBlueConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_blue_concrete_powder_dark_oak_mold"))) {
            return new AxeBlueConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_blue_concrete_powder_dark_oak_mold"))) {
            return new HoeBlueConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_blue_concrete_powder_mangrove_mold"))) {
            return new SwordBlueConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_blue_concrete_powder_mangrove_mold"))) {
            return new ShovelBlueConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_blue_concrete_powder_mangrove_mold"))) {
            return new PickaxeBlueConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_blue_concrete_powder_mangrove_mold"))) {
            return new AxeBlueConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_blue_concrete_powder_mangrove_mold"))) {
            return new HoeBlueConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_blue_concrete_powder_cherry_mold"))) {
            return new SwordBlueConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_blue_concrete_powder_cherry_mold"))) {
            return new ShovelBlueConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_blue_concrete_powder_cherry_mold"))) {
            return new PickaxeBlueConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_blue_concrete_powder_cherry_mold"))) {
            return new AxeBlueConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_blue_concrete_powder_cherry_mold"))) {
            return new HoeBlueConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_blue_concrete_powder_bamboo_mold"))) {
            return new SwordBlueConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_blue_concrete_powder_bamboo_mold"))) {
            return new ShovelBlueConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_blue_concrete_powder_bamboo_mold"))) {
            return new PickaxeBlueConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_blue_concrete_powder_bamboo_mold"))) {
            return new AxeBlueConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_blue_concrete_powder_bamboo_mold"))) {
            return new HoeBlueConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_blue_concrete_powder_crimson_mold"))) {
            return new SwordBlueConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_blue_concrete_powder_crimson_mold"))) {
            return new ShovelBlueConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_blue_concrete_powder_crimson_mold"))) {
            return new PickaxeBlueConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_blue_concrete_powder_crimson_mold"))) {
            return new AxeBlueConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_blue_concrete_powder_crimson_mold"))) {
            return new HoeBlueConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_blue_concrete_powder_warped_mold"))) {
            return new SwordBlueConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_blue_concrete_powder_warped_mold"))) {
            return new ShovelBlueConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_blue_concrete_powder_warped_mold"))) {
            return new PickaxeBlueConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_blue_concrete_powder_warped_mold"))) {
            return new AxeBlueConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_blue_concrete_powder_warped_mold"))) {
            return new HoeBlueConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_purple_concrete_powder_oak_mold"))) {
            return new SwordPurpleConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_purple_concrete_powder_oak_mold"))) {
            return new ShovelPurpleConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_purple_concrete_powder_oak_mold"))) {
            return new PickaxePurpleConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_purple_concrete_powder_oak_mold"))) {
            return new AxePurpleConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_purple_concrete_powder_oak_mold"))) {
            return new HoePurpleConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_purple_concrete_powder_spruce_mold"))) {
            return new SwordPurpleConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_purple_concrete_powder_spruce_mold"))) {
            return new ShovelPurpleConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_purple_concrete_powder_spruce_mold"))) {
            return new PickaxePurpleConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_purple_concrete_powder_spruce_mold"))) {
            return new AxePurpleConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_purple_concrete_powder_spruce_mold"))) {
            return new HoePurpleConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_purple_concrete_powder_birch_mold"))) {
            return new SwordPurpleConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_purple_concrete_powder_birch_mold"))) {
            return new ShovelPurpleConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_purple_concrete_powder_birch_mold"))) {
            return new PickaxePurpleConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_purple_concrete_powder_birch_mold"))) {
            return new AxePurpleConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_purple_concrete_powder_birch_mold"))) {
            return new HoePurpleConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_purple_concrete_powder_jungle_mold"))) {
            return new SwordPurpleConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_purple_concrete_powder_jungle_mold"))) {
            return new ShovelPurpleConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_purple_concrete_powder_jungle_mold"))) {
            return new PickaxePurpleConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_purple_concrete_powder_jungle_mold"))) {
            return new AxePurpleConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_purple_concrete_powder_jungle_mold"))) {
            return new HoePurpleConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_purple_concrete_powder_acacia_mold"))) {
            return new SwordPurpleConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_purple_concrete_powder_acacia_mold"))) {
            return new ShovelPurpleConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_purple_concrete_powder_acacia_mold"))) {
            return new PickaxePurpleConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_purple_concrete_powder_acacia_mold"))) {
            return new AxePurpleConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_purple_concrete_powder_acacia_mold"))) {
            return new HoePurpleConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_purple_concrete_powder_dark_oak_mold"))) {
            return new SwordPurpleConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_purple_concrete_powder_dark_oak_mold"))) {
            return new ShovelPurpleConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_purple_concrete_powder_dark_oak_mold"))) {
            return new PickaxePurpleConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_purple_concrete_powder_dark_oak_mold"))) {
            return new AxePurpleConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_purple_concrete_powder_dark_oak_mold"))) {
            return new HoePurpleConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_purple_concrete_powder_mangrove_mold"))) {
            return new SwordPurpleConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_purple_concrete_powder_mangrove_mold"))) {
            return new ShovelPurpleConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_purple_concrete_powder_mangrove_mold"))) {
            return new PickaxePurpleConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_purple_concrete_powder_mangrove_mold"))) {
            return new AxePurpleConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_purple_concrete_powder_mangrove_mold"))) {
            return new HoePurpleConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_purple_concrete_powder_cherry_mold"))) {
            return new SwordPurpleConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_purple_concrete_powder_cherry_mold"))) {
            return new ShovelPurpleConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_purple_concrete_powder_cherry_mold"))) {
            return new PickaxePurpleConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_purple_concrete_powder_cherry_mold"))) {
            return new AxePurpleConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_purple_concrete_powder_cherry_mold"))) {
            return new HoePurpleConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_purple_concrete_powder_bamboo_mold"))) {
            return new SwordPurpleConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_purple_concrete_powder_bamboo_mold"))) {
            return new ShovelPurpleConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_purple_concrete_powder_bamboo_mold"))) {
            return new PickaxePurpleConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_purple_concrete_powder_bamboo_mold"))) {
            return new AxePurpleConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_purple_concrete_powder_bamboo_mold"))) {
            return new HoePurpleConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_purple_concrete_powder_crimson_mold"))) {
            return new SwordPurpleConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_purple_concrete_powder_crimson_mold"))) {
            return new ShovelPurpleConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_purple_concrete_powder_crimson_mold"))) {
            return new PickaxePurpleConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_purple_concrete_powder_crimson_mold"))) {
            return new AxePurpleConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_purple_concrete_powder_crimson_mold"))) {
            return new HoePurpleConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_purple_concrete_powder_warped_mold"))) {
            return new SwordPurpleConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_purple_concrete_powder_warped_mold"))) {
            return new ShovelPurpleConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_purple_concrete_powder_warped_mold"))) {
            return new PickaxePurpleConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_purple_concrete_powder_warped_mold"))) {
            return new AxePurpleConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_purple_concrete_powder_warped_mold"))) {
            return new HoePurpleConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_magenta_concrete_powder_oak_mold"))) {
            return new SwordMagentaConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_magenta_concrete_powder_oak_mold"))) {
            return new ShovelMagentaConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_magenta_concrete_powder_oak_mold"))) {
            return new PickaxeMagentaConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_magenta_concrete_powder_oak_mold"))) {
            return new AxeMagentaConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_magenta_concrete_powder_oak_mold"))) {
            return new HoeMagentaConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_magenta_concrete_powder_spruce_mold"))) {
            return new SwordMagentaConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_magenta_concrete_powder_spruce_mold"))) {
            return new ShovelMagentaConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_magenta_concrete_powder_spruce_mold"))) {
            return new PickaxeMagentaConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_magenta_concrete_powder_spruce_mold"))) {
            return new AxeMagentaConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_magenta_concrete_powder_spruce_mold"))) {
            return new HoeMagentaConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_magenta_concrete_powder_birch_mold"))) {
            return new SwordMagentaConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_magenta_concrete_powder_birch_mold"))) {
            return new ShovelMagentaConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_magenta_concrete_powder_birch_mold"))) {
            return new PickaxeMagentaConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_magenta_concrete_powder_birch_mold"))) {
            return new AxeMagentaConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_magenta_concrete_powder_birch_mold"))) {
            return new HoeMagentaConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_magenta_concrete_powder_jungle_mold"))) {
            return new SwordMagentaConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_magenta_concrete_powder_jungle_mold"))) {
            return new ShovelMagentaConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_magenta_concrete_powder_jungle_mold"))) {
            return new PickaxeMagentaConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_magenta_concrete_powder_jungle_mold"))) {
            return new AxeMagentaConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_magenta_concrete_powder_jungle_mold"))) {
            return new HoeMagentaConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_magenta_concrete_powder_acacia_mold"))) {
            return new SwordMagentaConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_magenta_concrete_powder_acacia_mold"))) {
            return new ShovelMagentaConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_magenta_concrete_powder_acacia_mold"))) {
            return new PickaxeMagentaConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_magenta_concrete_powder_acacia_mold"))) {
            return new AxeMagentaConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_magenta_concrete_powder_acacia_mold"))) {
            return new HoeMagentaConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_magenta_concrete_powder_dark_oak_mold"))) {
            return new SwordMagentaConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_magenta_concrete_powder_dark_oak_mold"))) {
            return new ShovelMagentaConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_magenta_concrete_powder_dark_oak_mold"))) {
            return new PickaxeMagentaConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_magenta_concrete_powder_dark_oak_mold"))) {
            return new AxeMagentaConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_magenta_concrete_powder_dark_oak_mold"))) {
            return new HoeMagentaConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_magenta_concrete_powder_mangrove_mold"))) {
            return new SwordMagentaConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_magenta_concrete_powder_mangrove_mold"))) {
            return new ShovelMagentaConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_magenta_concrete_powder_mangrove_mold"))) {
            return new PickaxeMagentaConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_magenta_concrete_powder_mangrove_mold"))) {
            return new AxeMagentaConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_magenta_concrete_powder_mangrove_mold"))) {
            return new HoeMagentaConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_magenta_concrete_powder_cherry_mold"))) {
            return new SwordMagentaConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_magenta_concrete_powder_cherry_mold"))) {
            return new ShovelMagentaConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_magenta_concrete_powder_cherry_mold"))) {
            return new PickaxeMagentaConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_magenta_concrete_powder_cherry_mold"))) {
            return new AxeMagentaConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_magenta_concrete_powder_cherry_mold"))) {
            return new HoeMagentaConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_magenta_concrete_powder_bamboo_mold"))) {
            return new SwordMagentaConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_magenta_concrete_powder_bamboo_mold"))) {
            return new ShovelMagentaConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_magenta_concrete_powder_bamboo_mold"))) {
            return new PickaxeMagentaConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_magenta_concrete_powder_bamboo_mold"))) {
            return new AxeMagentaConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_magenta_concrete_powder_bamboo_mold"))) {
            return new HoeMagentaConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_magenta_concrete_powder_crimson_mold"))) {
            return new SwordMagentaConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_magenta_concrete_powder_crimson_mold"))) {
            return new ShovelMagentaConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_magenta_concrete_powder_crimson_mold"))) {
            return new PickaxeMagentaConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_magenta_concrete_powder_crimson_mold"))) {
            return new AxeMagentaConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_magenta_concrete_powder_crimson_mold"))) {
            return new HoeMagentaConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_magenta_concrete_powder_warped_mold"))) {
            return new SwordMagentaConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_magenta_concrete_powder_warped_mold"))) {
            return new ShovelMagentaConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_magenta_concrete_powder_warped_mold"))) {
            return new PickaxeMagentaConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_magenta_concrete_powder_warped_mold"))) {
            return new AxeMagentaConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_magenta_concrete_powder_warped_mold"))) {
            return new HoeMagentaConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_pink_concrete_powder_oak_mold"))) {
            return new SwordPinkConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_pink_concrete_powder_oak_mold"))) {
            return new ShovelPinkConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_pink_concrete_powder_oak_mold"))) {
            return new PickaxePinkConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_pink_concrete_powder_oak_mold"))) {
            return new AxePinkConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_pink_concrete_powder_oak_mold"))) {
            return new HoePinkConcretePowderOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_pink_concrete_powder_spruce_mold"))) {
            return new SwordPinkConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_pink_concrete_powder_spruce_mold"))) {
            return new ShovelPinkConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_pink_concrete_powder_spruce_mold"))) {
            return new PickaxePinkConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_pink_concrete_powder_spruce_mold"))) {
            return new AxePinkConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_pink_concrete_powder_spruce_mold"))) {
            return new HoePinkConcretePowderSpruceMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_pink_concrete_powder_birch_mold"))) {
            return new SwordPinkConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_pink_concrete_powder_birch_mold"))) {
            return new ShovelPinkConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_pink_concrete_powder_birch_mold"))) {
            return new PickaxePinkConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_pink_concrete_powder_birch_mold"))) {
            return new AxePinkConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_pink_concrete_powder_birch_mold"))) {
            return new HoePinkConcretePowderBirchMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_pink_concrete_powder_jungle_mold"))) {
            return new SwordPinkConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_pink_concrete_powder_jungle_mold"))) {
            return new ShovelPinkConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_pink_concrete_powder_jungle_mold"))) {
            return new PickaxePinkConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_pink_concrete_powder_jungle_mold"))) {
            return new AxePinkConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_pink_concrete_powder_jungle_mold"))) {
            return new HoePinkConcretePowderJungleMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_pink_concrete_powder_acacia_mold"))) {
            return new SwordPinkConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_pink_concrete_powder_acacia_mold"))) {
            return new ShovelPinkConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_pink_concrete_powder_acacia_mold"))) {
            return new PickaxePinkConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_pink_concrete_powder_acacia_mold"))) {
            return new AxePinkConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_pink_concrete_powder_acacia_mold"))) {
            return new HoePinkConcretePowderAcaciaMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_pink_concrete_powder_dark_oak_mold"))) {
            return new SwordPinkConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_pink_concrete_powder_dark_oak_mold"))) {
            return new ShovelPinkConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_pink_concrete_powder_dark_oak_mold"))) {
            return new PickaxePinkConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_pink_concrete_powder_dark_oak_mold"))) {
            return new AxePinkConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_pink_concrete_powder_dark_oak_mold"))) {
            return new HoePinkConcretePowderDarkOakMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_pink_concrete_powder_mangrove_mold"))) {
            return new SwordPinkConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_pink_concrete_powder_mangrove_mold"))) {
            return new ShovelPinkConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_pink_concrete_powder_mangrove_mold"))) {
            return new PickaxePinkConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_pink_concrete_powder_mangrove_mold"))) {
            return new AxePinkConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_pink_concrete_powder_mangrove_mold"))) {
            return new HoePinkConcretePowderMangroveMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_pink_concrete_powder_cherry_mold"))) {
            return new SwordPinkConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_pink_concrete_powder_cherry_mold"))) {
            return new ShovelPinkConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_pink_concrete_powder_cherry_mold"))) {
            return new PickaxePinkConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_pink_concrete_powder_cherry_mold"))) {
            return new AxePinkConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_pink_concrete_powder_cherry_mold"))) {
            return new HoePinkConcretePowderCherryMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_pink_concrete_powder_bamboo_mold"))) {
            return new SwordPinkConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_pink_concrete_powder_bamboo_mold"))) {
            return new ShovelPinkConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_pink_concrete_powder_bamboo_mold"))) {
            return new PickaxePinkConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_pink_concrete_powder_bamboo_mold"))) {
            return new AxePinkConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_pink_concrete_powder_bamboo_mold"))) {
            return new HoePinkConcretePowderBambooMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_pink_concrete_powder_crimson_mold"))) {
            return new SwordPinkConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_pink_concrete_powder_crimson_mold"))) {
            return new ShovelPinkConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_pink_concrete_powder_crimson_mold"))) {
            return new PickaxePinkConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_pink_concrete_powder_crimson_mold"))) {
            return new AxePinkConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_pink_concrete_powder_crimson_mold"))) {
            return new HoePinkConcretePowderCrimsonMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/sword_pink_concrete_powder_warped_mold"))) {
            return new SwordPinkConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/shovel_pink_concrete_powder_warped_mold"))) {
            return new ShovelPinkConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/pickaxe_pink_concrete_powder_warped_mold"))) {
            return new PickaxePinkConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/axe_pink_concrete_powder_warped_mold"))) {
            return new AxePinkConcretePowderWarpedMoldItemUnbakedModel();
        }
        if (modelId.equals(CreateModularTools.asResource("item/hoe_pink_concrete_powder_warped_mold"))) {
            return new HoePinkConcretePowderWarpedMoldItemUnbakedModel();
        }

        return null;
    }
}
