package net.zlt.create_modular_tools.client.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.minecraft.MethodsReturnNonnullByDefault;
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
import net.zlt.create_modular_tools.client.model.item.tool.*;
import net.zlt.create_modular_tools.item.tool.module.ToolModuleItem;
import net.zlt.create_modular_tools.tool.module.ToolModuleRegistry;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class CreateModularToolsModelLoadingPlugin implements ModelLoadingPlugin {
    @Override
    public void onInitializeModelLoader(Context pluginContext) {
        for (ToolModuleItem toolModule : ToolModuleRegistry.getAll()) {
            pluginContext.addModels(toolModule.getModelIds());
        }

        pluginContext.resolveModel().register(new ModularSwordModelResolver());
        pluginContext.resolveModel().register(new ModularShovelModelResolver());
        pluginContext.resolveModel().register(new ModularPickaxeModelResolver());
        pluginContext.resolveModel().register(new ModularAxeModelResolver());
        pluginContext.resolveModel().register(new ModularHoeModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/sand_oak_mold"));
        pluginContext.resolveModel().register(new SwordSandOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelSandOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeSandOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeSandOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeSandOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/sand_spruce_mold"));
        pluginContext.resolveModel().register(new SwordSandSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelSandSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeSandSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeSandSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeSandSpruceMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/sand_birch_mold"));
        pluginContext.resolveModel().register(new SwordSandBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelSandBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeSandBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeSandBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeSandBirchMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/sand_jungle_mold"));
        pluginContext.resolveModel().register(new SwordSandJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelSandJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeSandJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeSandJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeSandJungleMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/sand_acacia_mold"));
        pluginContext.resolveModel().register(new SwordSandAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelSandAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeSandAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeSandAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeSandAcaciaMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/sand_dark_oak_mold"));
        pluginContext.resolveModel().register(new SwordSandDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelSandDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeSandDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeSandDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeSandDarkOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/sand_mangrove_mold"));
        pluginContext.resolveModel().register(new SwordSandMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelSandMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeSandMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeSandMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeSandMangroveMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/sand_cherry_mold"));
        pluginContext.resolveModel().register(new SwordSandCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelSandCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeSandCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeSandCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeSandCherryMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/sand_bamboo_mold"));
        pluginContext.resolveModel().register(new SwordSandBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelSandBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeSandBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeSandBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeSandBambooMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/sand_crimson_mold"));
        pluginContext.resolveModel().register(new SwordSandCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelSandCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeSandCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeSandCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeSandCrimsonMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/sand_warped_mold"));
        pluginContext.resolveModel().register(new SwordSandWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelSandWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeSandWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeSandWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeSandWarpedMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/red_sand_oak_mold"));
        pluginContext.resolveModel().register(new SwordRedSandOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelRedSandOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeRedSandOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeRedSandOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeRedSandOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/red_sand_spruce_mold"));
        pluginContext.resolveModel().register(new SwordRedSandSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelRedSandSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeRedSandSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeRedSandSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeRedSandSpruceMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/red_sand_birch_mold"));
        pluginContext.resolveModel().register(new SwordRedSandBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelRedSandBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeRedSandBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeRedSandBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeRedSandBirchMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/red_sand_jungle_mold"));
        pluginContext.resolveModel().register(new SwordRedSandJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelRedSandJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeRedSandJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeRedSandJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeRedSandJungleMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/red_sand_acacia_mold"));
        pluginContext.resolveModel().register(new SwordRedSandAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelRedSandAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeRedSandAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeRedSandAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeRedSandAcaciaMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/red_sand_dark_oak_mold"));
        pluginContext.resolveModel().register(new SwordRedSandDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelRedSandDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeRedSandDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeRedSandDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeRedSandDarkOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/red_sand_mangrove_mold"));
        pluginContext.resolveModel().register(new SwordRedSandMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelRedSandMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeRedSandMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeRedSandMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeRedSandMangroveMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/red_sand_cherry_mold"));
        pluginContext.resolveModel().register(new SwordRedSandCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelRedSandCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeRedSandCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeRedSandCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeRedSandCherryMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/red_sand_bamboo_mold"));
        pluginContext.resolveModel().register(new SwordRedSandBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelRedSandBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeRedSandBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeRedSandBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeRedSandBambooMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/red_sand_crimson_mold"));
        pluginContext.resolveModel().register(new SwordRedSandCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelRedSandCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeRedSandCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeRedSandCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeRedSandCrimsonMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/red_sand_warped_mold"));
        pluginContext.resolveModel().register(new SwordRedSandWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelRedSandWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeRedSandWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeRedSandWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeRedSandWarpedMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/white_concrete_powder_oak_mold"));
        pluginContext.resolveModel().register(new SwordWhiteConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelWhiteConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeWhiteConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeWhiteConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeWhiteConcretePowderOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/white_concrete_powder_spruce_mold"));
        pluginContext.resolveModel().register(new SwordWhiteConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelWhiteConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeWhiteConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeWhiteConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeWhiteConcretePowderSpruceMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/white_concrete_powder_birch_mold"));
        pluginContext.resolveModel().register(new SwordWhiteConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelWhiteConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeWhiteConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeWhiteConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeWhiteConcretePowderBirchMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/white_concrete_powder_jungle_mold"));
        pluginContext.resolveModel().register(new SwordWhiteConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelWhiteConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeWhiteConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeWhiteConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeWhiteConcretePowderJungleMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/white_concrete_powder_acacia_mold"));
        pluginContext.resolveModel().register(new SwordWhiteConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelWhiteConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeWhiteConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeWhiteConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeWhiteConcretePowderAcaciaMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/white_concrete_powder_dark_oak_mold"));
        pluginContext.resolveModel().register(new SwordWhiteConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelWhiteConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeWhiteConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeWhiteConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeWhiteConcretePowderDarkOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/white_concrete_powder_mangrove_mold"));
        pluginContext.resolveModel().register(new SwordWhiteConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelWhiteConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeWhiteConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeWhiteConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeWhiteConcretePowderMangroveMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/white_concrete_powder_cherry_mold"));
        pluginContext.resolveModel().register(new SwordWhiteConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelWhiteConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeWhiteConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeWhiteConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeWhiteConcretePowderCherryMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/white_concrete_powder_bamboo_mold"));
        pluginContext.resolveModel().register(new SwordWhiteConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelWhiteConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeWhiteConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeWhiteConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeWhiteConcretePowderBambooMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/white_concrete_powder_crimson_mold"));
        pluginContext.resolveModel().register(new SwordWhiteConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelWhiteConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeWhiteConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeWhiteConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeWhiteConcretePowderCrimsonMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/white_concrete_powder_warped_mold"));
        pluginContext.resolveModel().register(new SwordWhiteConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelWhiteConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeWhiteConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeWhiteConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeWhiteConcretePowderWarpedMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/light_gray_concrete_powder_oak_mold"));
        pluginContext.resolveModel().register(new SwordLightGrayConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLightGrayConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLightGrayConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLightGrayConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLightGrayConcretePowderOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/light_gray_concrete_powder_spruce_mold"));
        pluginContext.resolveModel().register(new SwordLightGrayConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLightGrayConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLightGrayConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLightGrayConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLightGrayConcretePowderSpruceMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/light_gray_concrete_powder_birch_mold"));
        pluginContext.resolveModel().register(new SwordLightGrayConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLightGrayConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLightGrayConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLightGrayConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLightGrayConcretePowderBirchMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/light_gray_concrete_powder_jungle_mold"));
        pluginContext.resolveModel().register(new SwordLightGrayConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLightGrayConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLightGrayConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLightGrayConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLightGrayConcretePowderJungleMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/light_gray_concrete_powder_acacia_mold"));
        pluginContext.resolveModel().register(new SwordLightGrayConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLightGrayConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLightGrayConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLightGrayConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLightGrayConcretePowderAcaciaMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/light_gray_concrete_powder_dark_oak_mold"));
        pluginContext.resolveModel().register(new SwordLightGrayConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLightGrayConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLightGrayConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLightGrayConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLightGrayConcretePowderDarkOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/light_gray_concrete_powder_mangrove_mold"));
        pluginContext.resolveModel().register(new SwordLightGrayConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLightGrayConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLightGrayConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLightGrayConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLightGrayConcretePowderMangroveMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/light_gray_concrete_powder_cherry_mold"));
        pluginContext.resolveModel().register(new SwordLightGrayConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLightGrayConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLightGrayConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLightGrayConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLightGrayConcretePowderCherryMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/light_gray_concrete_powder_bamboo_mold"));
        pluginContext.resolveModel().register(new SwordLightGrayConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLightGrayConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLightGrayConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLightGrayConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLightGrayConcretePowderBambooMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/light_gray_concrete_powder_crimson_mold"));
        pluginContext.resolveModel().register(new SwordLightGrayConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLightGrayConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLightGrayConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLightGrayConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLightGrayConcretePowderCrimsonMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/light_gray_concrete_powder_warped_mold"));
        pluginContext.resolveModel().register(new SwordLightGrayConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLightGrayConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLightGrayConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLightGrayConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLightGrayConcretePowderWarpedMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/gray_concrete_powder_oak_mold"));
        pluginContext.resolveModel().register(new SwordGrayConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelGrayConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeGrayConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeGrayConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeGrayConcretePowderOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/gray_concrete_powder_spruce_mold"));
        pluginContext.resolveModel().register(new SwordGrayConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelGrayConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeGrayConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeGrayConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeGrayConcretePowderSpruceMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/gray_concrete_powder_birch_mold"));
        pluginContext.resolveModel().register(new SwordGrayConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelGrayConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeGrayConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeGrayConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeGrayConcretePowderBirchMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/gray_concrete_powder_jungle_mold"));
        pluginContext.resolveModel().register(new SwordGrayConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelGrayConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeGrayConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeGrayConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeGrayConcretePowderJungleMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/gray_concrete_powder_acacia_mold"));
        pluginContext.resolveModel().register(new SwordGrayConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelGrayConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeGrayConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeGrayConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeGrayConcretePowderAcaciaMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/gray_concrete_powder_dark_oak_mold"));
        pluginContext.resolveModel().register(new SwordGrayConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelGrayConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeGrayConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeGrayConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeGrayConcretePowderDarkOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/gray_concrete_powder_mangrove_mold"));
        pluginContext.resolveModel().register(new SwordGrayConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelGrayConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeGrayConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeGrayConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeGrayConcretePowderMangroveMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/gray_concrete_powder_cherry_mold"));
        pluginContext.resolveModel().register(new SwordGrayConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelGrayConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeGrayConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeGrayConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeGrayConcretePowderCherryMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/gray_concrete_powder_bamboo_mold"));
        pluginContext.resolveModel().register(new SwordGrayConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelGrayConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeGrayConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeGrayConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeGrayConcretePowderBambooMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/gray_concrete_powder_crimson_mold"));
        pluginContext.resolveModel().register(new SwordGrayConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelGrayConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeGrayConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeGrayConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeGrayConcretePowderCrimsonMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/gray_concrete_powder_warped_mold"));
        pluginContext.resolveModel().register(new SwordGrayConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelGrayConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeGrayConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeGrayConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeGrayConcretePowderWarpedMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/black_concrete_powder_oak_mold"));
        pluginContext.resolveModel().register(new SwordBlackConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBlackConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBlackConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBlackConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBlackConcretePowderOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/black_concrete_powder_spruce_mold"));
        pluginContext.resolveModel().register(new SwordBlackConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBlackConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBlackConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBlackConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBlackConcretePowderSpruceMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/black_concrete_powder_birch_mold"));
        pluginContext.resolveModel().register(new SwordBlackConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBlackConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBlackConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBlackConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBlackConcretePowderBirchMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/black_concrete_powder_jungle_mold"));
        pluginContext.resolveModel().register(new SwordBlackConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBlackConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBlackConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBlackConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBlackConcretePowderJungleMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/black_concrete_powder_acacia_mold"));
        pluginContext.resolveModel().register(new SwordBlackConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBlackConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBlackConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBlackConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBlackConcretePowderAcaciaMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/black_concrete_powder_dark_oak_mold"));
        pluginContext.resolveModel().register(new SwordBlackConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBlackConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBlackConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBlackConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBlackConcretePowderDarkOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/black_concrete_powder_mangrove_mold"));
        pluginContext.resolveModel().register(new SwordBlackConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBlackConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBlackConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBlackConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBlackConcretePowderMangroveMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/black_concrete_powder_cherry_mold"));
        pluginContext.resolveModel().register(new SwordBlackConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBlackConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBlackConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBlackConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBlackConcretePowderCherryMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/black_concrete_powder_bamboo_mold"));
        pluginContext.resolveModel().register(new SwordBlackConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBlackConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBlackConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBlackConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBlackConcretePowderBambooMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/black_concrete_powder_crimson_mold"));
        pluginContext.resolveModel().register(new SwordBlackConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBlackConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBlackConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBlackConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBlackConcretePowderCrimsonMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/black_concrete_powder_warped_mold"));
        pluginContext.resolveModel().register(new SwordBlackConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBlackConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBlackConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBlackConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBlackConcretePowderWarpedMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/brown_concrete_powder_oak_mold"));
        pluginContext.resolveModel().register(new SwordBrownConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBrownConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBrownConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBrownConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBrownConcretePowderOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/brown_concrete_powder_spruce_mold"));
        pluginContext.resolveModel().register(new SwordBrownConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBrownConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBrownConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBrownConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBrownConcretePowderSpruceMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/brown_concrete_powder_birch_mold"));
        pluginContext.resolveModel().register(new SwordBrownConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBrownConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBrownConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBrownConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBrownConcretePowderBirchMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/brown_concrete_powder_jungle_mold"));
        pluginContext.resolveModel().register(new SwordBrownConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBrownConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBrownConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBrownConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBrownConcretePowderJungleMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/brown_concrete_powder_acacia_mold"));
        pluginContext.resolveModel().register(new SwordBrownConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBrownConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBrownConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBrownConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBrownConcretePowderAcaciaMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/brown_concrete_powder_dark_oak_mold"));
        pluginContext.resolveModel().register(new SwordBrownConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBrownConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBrownConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBrownConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBrownConcretePowderDarkOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/brown_concrete_powder_mangrove_mold"));
        pluginContext.resolveModel().register(new SwordBrownConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBrownConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBrownConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBrownConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBrownConcretePowderMangroveMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/brown_concrete_powder_cherry_mold"));
        pluginContext.resolveModel().register(new SwordBrownConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBrownConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBrownConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBrownConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBrownConcretePowderCherryMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/brown_concrete_powder_bamboo_mold"));
        pluginContext.resolveModel().register(new SwordBrownConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBrownConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBrownConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBrownConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBrownConcretePowderBambooMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/brown_concrete_powder_crimson_mold"));
        pluginContext.resolveModel().register(new SwordBrownConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBrownConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBrownConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBrownConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBrownConcretePowderCrimsonMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/brown_concrete_powder_warped_mold"));
        pluginContext.resolveModel().register(new SwordBrownConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBrownConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBrownConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBrownConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBrownConcretePowderWarpedMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/red_concrete_powder_oak_mold"));
        pluginContext.resolveModel().register(new SwordRedConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelRedConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeRedConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeRedConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeRedConcretePowderOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/red_concrete_powder_spruce_mold"));
        pluginContext.resolveModel().register(new SwordRedConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelRedConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeRedConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeRedConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeRedConcretePowderSpruceMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/red_concrete_powder_birch_mold"));
        pluginContext.resolveModel().register(new SwordRedConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelRedConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeRedConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeRedConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeRedConcretePowderBirchMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/red_concrete_powder_jungle_mold"));
        pluginContext.resolveModel().register(new SwordRedConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelRedConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeRedConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeRedConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeRedConcretePowderJungleMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/red_concrete_powder_acacia_mold"));
        pluginContext.resolveModel().register(new SwordRedConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelRedConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeRedConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeRedConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeRedConcretePowderAcaciaMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/red_concrete_powder_dark_oak_mold"));
        pluginContext.resolveModel().register(new SwordRedConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelRedConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeRedConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeRedConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeRedConcretePowderDarkOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/red_concrete_powder_mangrove_mold"));
        pluginContext.resolveModel().register(new SwordRedConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelRedConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeRedConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeRedConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeRedConcretePowderMangroveMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/red_concrete_powder_cherry_mold"));
        pluginContext.resolveModel().register(new SwordRedConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelRedConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeRedConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeRedConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeRedConcretePowderCherryMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/red_concrete_powder_bamboo_mold"));
        pluginContext.resolveModel().register(new SwordRedConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelRedConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeRedConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeRedConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeRedConcretePowderBambooMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/red_concrete_powder_crimson_mold"));
        pluginContext.resolveModel().register(new SwordRedConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelRedConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeRedConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeRedConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeRedConcretePowderCrimsonMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/red_concrete_powder_warped_mold"));
        pluginContext.resolveModel().register(new SwordRedConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelRedConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeRedConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeRedConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeRedConcretePowderWarpedMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/orange_concrete_powder_oak_mold"));
        pluginContext.resolveModel().register(new SwordOrangeConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelOrangeConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeOrangeConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeOrangeConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeOrangeConcretePowderOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/orange_concrete_powder_spruce_mold"));
        pluginContext.resolveModel().register(new SwordOrangeConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelOrangeConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeOrangeConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeOrangeConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeOrangeConcretePowderSpruceMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/orange_concrete_powder_birch_mold"));
        pluginContext.resolveModel().register(new SwordOrangeConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelOrangeConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeOrangeConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeOrangeConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeOrangeConcretePowderBirchMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/orange_concrete_powder_jungle_mold"));
        pluginContext.resolveModel().register(new SwordOrangeConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelOrangeConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeOrangeConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeOrangeConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeOrangeConcretePowderJungleMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/orange_concrete_powder_acacia_mold"));
        pluginContext.resolveModel().register(new SwordOrangeConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelOrangeConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeOrangeConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeOrangeConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeOrangeConcretePowderAcaciaMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/orange_concrete_powder_dark_oak_mold"));
        pluginContext.resolveModel().register(new SwordOrangeConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelOrangeConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeOrangeConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeOrangeConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeOrangeConcretePowderDarkOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/orange_concrete_powder_mangrove_mold"));
        pluginContext.resolveModel().register(new SwordOrangeConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelOrangeConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeOrangeConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeOrangeConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeOrangeConcretePowderMangroveMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/orange_concrete_powder_cherry_mold"));
        pluginContext.resolveModel().register(new SwordOrangeConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelOrangeConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeOrangeConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeOrangeConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeOrangeConcretePowderCherryMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/orange_concrete_powder_bamboo_mold"));
        pluginContext.resolveModel().register(new SwordOrangeConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelOrangeConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeOrangeConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeOrangeConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeOrangeConcretePowderBambooMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/orange_concrete_powder_crimson_mold"));
        pluginContext.resolveModel().register(new SwordOrangeConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelOrangeConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeOrangeConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeOrangeConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeOrangeConcretePowderCrimsonMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/orange_concrete_powder_warped_mold"));
        pluginContext.resolveModel().register(new SwordOrangeConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelOrangeConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeOrangeConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeOrangeConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeOrangeConcretePowderWarpedMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/yellow_concrete_powder_oak_mold"));
        pluginContext.resolveModel().register(new SwordYellowConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelYellowConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeYellowConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeYellowConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeYellowConcretePowderOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/yellow_concrete_powder_spruce_mold"));
        pluginContext.resolveModel().register(new SwordYellowConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelYellowConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeYellowConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeYellowConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeYellowConcretePowderSpruceMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/yellow_concrete_powder_birch_mold"));
        pluginContext.resolveModel().register(new SwordYellowConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelYellowConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeYellowConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeYellowConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeYellowConcretePowderBirchMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/yellow_concrete_powder_jungle_mold"));
        pluginContext.resolveModel().register(new SwordYellowConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelYellowConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeYellowConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeYellowConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeYellowConcretePowderJungleMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/yellow_concrete_powder_acacia_mold"));
        pluginContext.resolveModel().register(new SwordYellowConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelYellowConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeYellowConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeYellowConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeYellowConcretePowderAcaciaMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/yellow_concrete_powder_dark_oak_mold"));
        pluginContext.resolveModel().register(new SwordYellowConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelYellowConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeYellowConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeYellowConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeYellowConcretePowderDarkOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/yellow_concrete_powder_mangrove_mold"));
        pluginContext.resolveModel().register(new SwordYellowConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelYellowConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeYellowConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeYellowConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeYellowConcretePowderMangroveMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/yellow_concrete_powder_cherry_mold"));
        pluginContext.resolveModel().register(new SwordYellowConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelYellowConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeYellowConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeYellowConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeYellowConcretePowderCherryMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/yellow_concrete_powder_bamboo_mold"));
        pluginContext.resolveModel().register(new SwordYellowConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelYellowConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeYellowConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeYellowConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeYellowConcretePowderBambooMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/yellow_concrete_powder_crimson_mold"));
        pluginContext.resolveModel().register(new SwordYellowConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelYellowConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeYellowConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeYellowConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeYellowConcretePowderCrimsonMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/yellow_concrete_powder_warped_mold"));
        pluginContext.resolveModel().register(new SwordYellowConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelYellowConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeYellowConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeYellowConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeYellowConcretePowderWarpedMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/lime_concrete_powder_oak_mold"));
        pluginContext.resolveModel().register(new SwordLimeConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLimeConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLimeConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLimeConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLimeConcretePowderOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/lime_concrete_powder_spruce_mold"));
        pluginContext.resolveModel().register(new SwordLimeConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLimeConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLimeConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLimeConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLimeConcretePowderSpruceMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/lime_concrete_powder_birch_mold"));
        pluginContext.resolveModel().register(new SwordLimeConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLimeConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLimeConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLimeConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLimeConcretePowderBirchMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/lime_concrete_powder_jungle_mold"));
        pluginContext.resolveModel().register(new SwordLimeConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLimeConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLimeConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLimeConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLimeConcretePowderJungleMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/lime_concrete_powder_acacia_mold"));
        pluginContext.resolveModel().register(new SwordLimeConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLimeConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLimeConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLimeConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLimeConcretePowderAcaciaMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/lime_concrete_powder_dark_oak_mold"));
        pluginContext.resolveModel().register(new SwordLimeConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLimeConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLimeConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLimeConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLimeConcretePowderDarkOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/lime_concrete_powder_mangrove_mold"));
        pluginContext.resolveModel().register(new SwordLimeConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLimeConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLimeConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLimeConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLimeConcretePowderMangroveMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/lime_concrete_powder_cherry_mold"));
        pluginContext.resolveModel().register(new SwordLimeConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLimeConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLimeConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLimeConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLimeConcretePowderCherryMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/lime_concrete_powder_bamboo_mold"));
        pluginContext.resolveModel().register(new SwordLimeConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLimeConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLimeConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLimeConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLimeConcretePowderBambooMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/lime_concrete_powder_crimson_mold"));
        pluginContext.resolveModel().register(new SwordLimeConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLimeConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLimeConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLimeConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLimeConcretePowderCrimsonMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/lime_concrete_powder_warped_mold"));
        pluginContext.resolveModel().register(new SwordLimeConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLimeConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLimeConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLimeConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLimeConcretePowderWarpedMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/green_concrete_powder_oak_mold"));
        pluginContext.resolveModel().register(new SwordGreenConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelGreenConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeGreenConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeGreenConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeGreenConcretePowderOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/green_concrete_powder_spruce_mold"));
        pluginContext.resolveModel().register(new SwordGreenConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelGreenConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeGreenConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeGreenConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeGreenConcretePowderSpruceMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/green_concrete_powder_birch_mold"));
        pluginContext.resolveModel().register(new SwordGreenConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelGreenConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeGreenConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeGreenConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeGreenConcretePowderBirchMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/green_concrete_powder_jungle_mold"));
        pluginContext.resolveModel().register(new SwordGreenConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelGreenConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeGreenConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeGreenConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeGreenConcretePowderJungleMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/green_concrete_powder_acacia_mold"));
        pluginContext.resolveModel().register(new SwordGreenConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelGreenConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeGreenConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeGreenConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeGreenConcretePowderAcaciaMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/green_concrete_powder_dark_oak_mold"));
        pluginContext.resolveModel().register(new SwordGreenConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelGreenConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeGreenConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeGreenConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeGreenConcretePowderDarkOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/green_concrete_powder_mangrove_mold"));
        pluginContext.resolveModel().register(new SwordGreenConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelGreenConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeGreenConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeGreenConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeGreenConcretePowderMangroveMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/green_concrete_powder_cherry_mold"));
        pluginContext.resolveModel().register(new SwordGreenConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelGreenConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeGreenConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeGreenConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeGreenConcretePowderCherryMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/green_concrete_powder_bamboo_mold"));
        pluginContext.resolveModel().register(new SwordGreenConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelGreenConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeGreenConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeGreenConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeGreenConcretePowderBambooMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/green_concrete_powder_crimson_mold"));
        pluginContext.resolveModel().register(new SwordGreenConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelGreenConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeGreenConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeGreenConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeGreenConcretePowderCrimsonMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/green_concrete_powder_warped_mold"));
        pluginContext.resolveModel().register(new SwordGreenConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelGreenConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeGreenConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeGreenConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeGreenConcretePowderWarpedMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/cyan_concrete_powder_oak_mold"));
        pluginContext.resolveModel().register(new SwordCyanConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelCyanConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeCyanConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeCyanConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeCyanConcretePowderOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/cyan_concrete_powder_spruce_mold"));
        pluginContext.resolveModel().register(new SwordCyanConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelCyanConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeCyanConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeCyanConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeCyanConcretePowderSpruceMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/cyan_concrete_powder_birch_mold"));
        pluginContext.resolveModel().register(new SwordCyanConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelCyanConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeCyanConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeCyanConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeCyanConcretePowderBirchMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/cyan_concrete_powder_jungle_mold"));
        pluginContext.resolveModel().register(new SwordCyanConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelCyanConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeCyanConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeCyanConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeCyanConcretePowderJungleMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/cyan_concrete_powder_acacia_mold"));
        pluginContext.resolveModel().register(new SwordCyanConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelCyanConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeCyanConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeCyanConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeCyanConcretePowderAcaciaMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/cyan_concrete_powder_dark_oak_mold"));
        pluginContext.resolveModel().register(new SwordCyanConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelCyanConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeCyanConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeCyanConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeCyanConcretePowderDarkOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/cyan_concrete_powder_mangrove_mold"));
        pluginContext.resolveModel().register(new SwordCyanConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelCyanConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeCyanConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeCyanConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeCyanConcretePowderMangroveMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/cyan_concrete_powder_cherry_mold"));
        pluginContext.resolveModel().register(new SwordCyanConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelCyanConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeCyanConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeCyanConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeCyanConcretePowderCherryMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/cyan_concrete_powder_bamboo_mold"));
        pluginContext.resolveModel().register(new SwordCyanConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelCyanConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeCyanConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeCyanConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeCyanConcretePowderBambooMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/cyan_concrete_powder_crimson_mold"));
        pluginContext.resolveModel().register(new SwordCyanConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelCyanConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeCyanConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeCyanConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeCyanConcretePowderCrimsonMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/cyan_concrete_powder_warped_mold"));
        pluginContext.resolveModel().register(new SwordCyanConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelCyanConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeCyanConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeCyanConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeCyanConcretePowderWarpedMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/light_blue_concrete_powder_oak_mold"));
        pluginContext.resolveModel().register(new SwordLightBlueConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLightBlueConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLightBlueConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLightBlueConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLightBlueConcretePowderOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/light_blue_concrete_powder_spruce_mold"));
        pluginContext.resolveModel().register(new SwordLightBlueConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLightBlueConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLightBlueConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLightBlueConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLightBlueConcretePowderSpruceMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/light_blue_concrete_powder_birch_mold"));
        pluginContext.resolveModel().register(new SwordLightBlueConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLightBlueConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLightBlueConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLightBlueConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLightBlueConcretePowderBirchMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/light_blue_concrete_powder_jungle_mold"));
        pluginContext.resolveModel().register(new SwordLightBlueConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLightBlueConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLightBlueConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLightBlueConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLightBlueConcretePowderJungleMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/light_blue_concrete_powder_acacia_mold"));
        pluginContext.resolveModel().register(new SwordLightBlueConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLightBlueConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLightBlueConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLightBlueConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLightBlueConcretePowderAcaciaMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/light_blue_concrete_powder_dark_oak_mold"));
        pluginContext.resolveModel().register(new SwordLightBlueConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLightBlueConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLightBlueConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLightBlueConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLightBlueConcretePowderDarkOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/light_blue_concrete_powder_mangrove_mold"));
        pluginContext.resolveModel().register(new SwordLightBlueConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLightBlueConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLightBlueConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLightBlueConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLightBlueConcretePowderMangroveMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/light_blue_concrete_powder_cherry_mold"));
        pluginContext.resolveModel().register(new SwordLightBlueConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLightBlueConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLightBlueConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLightBlueConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLightBlueConcretePowderCherryMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/light_blue_concrete_powder_bamboo_mold"));
        pluginContext.resolveModel().register(new SwordLightBlueConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLightBlueConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLightBlueConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLightBlueConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLightBlueConcretePowderBambooMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/light_blue_concrete_powder_crimson_mold"));
        pluginContext.resolveModel().register(new SwordLightBlueConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLightBlueConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLightBlueConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLightBlueConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLightBlueConcretePowderCrimsonMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/light_blue_concrete_powder_warped_mold"));
        pluginContext.resolveModel().register(new SwordLightBlueConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLightBlueConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLightBlueConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLightBlueConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLightBlueConcretePowderWarpedMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/blue_concrete_powder_oak_mold"));
        pluginContext.resolveModel().register(new SwordBlueConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBlueConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBlueConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBlueConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBlueConcretePowderOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/blue_concrete_powder_spruce_mold"));
        pluginContext.resolveModel().register(new SwordBlueConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBlueConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBlueConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBlueConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBlueConcretePowderSpruceMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/blue_concrete_powder_birch_mold"));
        pluginContext.resolveModel().register(new SwordBlueConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBlueConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBlueConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBlueConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBlueConcretePowderBirchMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/blue_concrete_powder_jungle_mold"));
        pluginContext.resolveModel().register(new SwordBlueConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBlueConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBlueConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBlueConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBlueConcretePowderJungleMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/blue_concrete_powder_acacia_mold"));
        pluginContext.resolveModel().register(new SwordBlueConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBlueConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBlueConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBlueConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBlueConcretePowderAcaciaMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/blue_concrete_powder_dark_oak_mold"));
        pluginContext.resolveModel().register(new SwordBlueConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBlueConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBlueConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBlueConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBlueConcretePowderDarkOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/blue_concrete_powder_mangrove_mold"));
        pluginContext.resolveModel().register(new SwordBlueConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBlueConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBlueConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBlueConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBlueConcretePowderMangroveMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/blue_concrete_powder_cherry_mold"));
        pluginContext.resolveModel().register(new SwordBlueConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBlueConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBlueConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBlueConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBlueConcretePowderCherryMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/blue_concrete_powder_bamboo_mold"));
        pluginContext.resolveModel().register(new SwordBlueConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBlueConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBlueConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBlueConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBlueConcretePowderBambooMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/blue_concrete_powder_crimson_mold"));
        pluginContext.resolveModel().register(new SwordBlueConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBlueConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBlueConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBlueConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBlueConcretePowderCrimsonMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/blue_concrete_powder_warped_mold"));
        pluginContext.resolveModel().register(new SwordBlueConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBlueConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBlueConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBlueConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBlueConcretePowderWarpedMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/purple_concrete_powder_oak_mold"));
        pluginContext.resolveModel().register(new SwordPurpleConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelPurpleConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxePurpleConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxePurpleConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoePurpleConcretePowderOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/purple_concrete_powder_spruce_mold"));
        pluginContext.resolveModel().register(new SwordPurpleConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelPurpleConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxePurpleConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxePurpleConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoePurpleConcretePowderSpruceMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/purple_concrete_powder_birch_mold"));
        pluginContext.resolveModel().register(new SwordPurpleConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelPurpleConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxePurpleConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxePurpleConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoePurpleConcretePowderBirchMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/purple_concrete_powder_jungle_mold"));
        pluginContext.resolveModel().register(new SwordPurpleConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelPurpleConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxePurpleConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxePurpleConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoePurpleConcretePowderJungleMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/purple_concrete_powder_acacia_mold"));
        pluginContext.resolveModel().register(new SwordPurpleConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelPurpleConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxePurpleConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxePurpleConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoePurpleConcretePowderAcaciaMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/purple_concrete_powder_dark_oak_mold"));
        pluginContext.resolveModel().register(new SwordPurpleConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelPurpleConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxePurpleConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxePurpleConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoePurpleConcretePowderDarkOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/purple_concrete_powder_mangrove_mold"));
        pluginContext.resolveModel().register(new SwordPurpleConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelPurpleConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxePurpleConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxePurpleConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoePurpleConcretePowderMangroveMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/purple_concrete_powder_cherry_mold"));
        pluginContext.resolveModel().register(new SwordPurpleConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelPurpleConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxePurpleConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxePurpleConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoePurpleConcretePowderCherryMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/purple_concrete_powder_bamboo_mold"));
        pluginContext.resolveModel().register(new SwordPurpleConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelPurpleConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxePurpleConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxePurpleConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoePurpleConcretePowderBambooMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/purple_concrete_powder_crimson_mold"));
        pluginContext.resolveModel().register(new SwordPurpleConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelPurpleConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxePurpleConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxePurpleConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoePurpleConcretePowderCrimsonMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/purple_concrete_powder_warped_mold"));
        pluginContext.resolveModel().register(new SwordPurpleConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelPurpleConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxePurpleConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxePurpleConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoePurpleConcretePowderWarpedMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/magenta_concrete_powder_oak_mold"));
        pluginContext.resolveModel().register(new SwordMagentaConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelMagentaConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeMagentaConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeMagentaConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeMagentaConcretePowderOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/magenta_concrete_powder_spruce_mold"));
        pluginContext.resolveModel().register(new SwordMagentaConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelMagentaConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeMagentaConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeMagentaConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeMagentaConcretePowderSpruceMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/magenta_concrete_powder_birch_mold"));
        pluginContext.resolveModel().register(new SwordMagentaConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelMagentaConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeMagentaConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeMagentaConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeMagentaConcretePowderBirchMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/magenta_concrete_powder_jungle_mold"));
        pluginContext.resolveModel().register(new SwordMagentaConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelMagentaConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeMagentaConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeMagentaConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeMagentaConcretePowderJungleMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/magenta_concrete_powder_acacia_mold"));
        pluginContext.resolveModel().register(new SwordMagentaConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelMagentaConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeMagentaConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeMagentaConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeMagentaConcretePowderAcaciaMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/magenta_concrete_powder_dark_oak_mold"));
        pluginContext.resolveModel().register(new SwordMagentaConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelMagentaConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeMagentaConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeMagentaConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeMagentaConcretePowderDarkOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/magenta_concrete_powder_mangrove_mold"));
        pluginContext.resolveModel().register(new SwordMagentaConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelMagentaConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeMagentaConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeMagentaConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeMagentaConcretePowderMangroveMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/magenta_concrete_powder_cherry_mold"));
        pluginContext.resolveModel().register(new SwordMagentaConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelMagentaConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeMagentaConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeMagentaConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeMagentaConcretePowderCherryMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/magenta_concrete_powder_bamboo_mold"));
        pluginContext.resolveModel().register(new SwordMagentaConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelMagentaConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeMagentaConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeMagentaConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeMagentaConcretePowderBambooMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/magenta_concrete_powder_crimson_mold"));
        pluginContext.resolveModel().register(new SwordMagentaConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelMagentaConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeMagentaConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeMagentaConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeMagentaConcretePowderCrimsonMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/magenta_concrete_powder_warped_mold"));
        pluginContext.resolveModel().register(new SwordMagentaConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelMagentaConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeMagentaConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeMagentaConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeMagentaConcretePowderWarpedMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/pink_concrete_powder_oak_mold"));
        pluginContext.resolveModel().register(new SwordPinkConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelPinkConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxePinkConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxePinkConcretePowderOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoePinkConcretePowderOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/pink_concrete_powder_spruce_mold"));
        pluginContext.resolveModel().register(new SwordPinkConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelPinkConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxePinkConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxePinkConcretePowderSpruceMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoePinkConcretePowderSpruceMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/pink_concrete_powder_birch_mold"));
        pluginContext.resolveModel().register(new SwordPinkConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelPinkConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxePinkConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxePinkConcretePowderBirchMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoePinkConcretePowderBirchMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/pink_concrete_powder_jungle_mold"));
        pluginContext.resolveModel().register(new SwordPinkConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelPinkConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxePinkConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxePinkConcretePowderJungleMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoePinkConcretePowderJungleMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/pink_concrete_powder_acacia_mold"));
        pluginContext.resolveModel().register(new SwordPinkConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelPinkConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxePinkConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxePinkConcretePowderAcaciaMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoePinkConcretePowderAcaciaMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/pink_concrete_powder_dark_oak_mold"));
        pluginContext.resolveModel().register(new SwordPinkConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelPinkConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxePinkConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxePinkConcretePowderDarkOakMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoePinkConcretePowderDarkOakMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/pink_concrete_powder_mangrove_mold"));
        pluginContext.resolveModel().register(new SwordPinkConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelPinkConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxePinkConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxePinkConcretePowderMangroveMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoePinkConcretePowderMangroveMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/pink_concrete_powder_cherry_mold"));
        pluginContext.resolveModel().register(new SwordPinkConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelPinkConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxePinkConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxePinkConcretePowderCherryMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoePinkConcretePowderCherryMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/pink_concrete_powder_bamboo_mold"));
        pluginContext.resolveModel().register(new SwordPinkConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelPinkConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxePinkConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxePinkConcretePowderBambooMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoePinkConcretePowderBambooMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/pink_concrete_powder_crimson_mold"));
        pluginContext.resolveModel().register(new SwordPinkConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelPinkConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxePinkConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxePinkConcretePowderCrimsonMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoePinkConcretePowderCrimsonMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/pink_concrete_powder_warped_mold"));
        pluginContext.resolveModel().register(new SwordPinkConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelPinkConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxePinkConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxePinkConcretePowderWarpedMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoePinkConcretePowderWarpedMoldItemModelResolver());
    }
}
