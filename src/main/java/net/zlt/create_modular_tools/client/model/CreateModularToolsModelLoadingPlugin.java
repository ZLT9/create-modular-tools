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

        pluginContext.addModels(CreateModularTools.asResource("block/sand_mold"));
        pluginContext.resolveModel().register(new SwordSandMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelSandMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeSandMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeSandMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeSandMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/red_sand_mold"));
        pluginContext.resolveModel().register(new SwordRedSandMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelRedSandMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeRedSandMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeRedSandMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeRedSandMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/white_concrete_powder_mold"));
        pluginContext.resolveModel().register(new SwordWhiteConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelWhiteConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeWhiteConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeWhiteConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeWhiteConcretePowderMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/light_gray_concrete_powder_mold"));
        pluginContext.resolveModel().register(new SwordLightGrayConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLightGrayConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLightGrayConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLightGrayConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLightGrayConcretePowderMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/gray_concrete_powder_mold"));
        pluginContext.resolveModel().register(new SwordGrayConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelGrayConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeGrayConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeGrayConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeGrayConcretePowderMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/black_concrete_powder_mold"));
        pluginContext.resolveModel().register(new SwordBlackConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBlackConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBlackConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBlackConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBlackConcretePowderMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/brown_concrete_powder_mold"));
        pluginContext.resolveModel().register(new SwordBrownConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBrownConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBrownConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBrownConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBrownConcretePowderMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/red_concrete_powder_mold"));
        pluginContext.resolveModel().register(new SwordRedConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelRedConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeRedConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeRedConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeRedConcretePowderMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/orange_concrete_powder_mold"));
        pluginContext.resolveModel().register(new SwordOrangeConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelOrangeConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeOrangeConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeOrangeConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeOrangeConcretePowderMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/yellow_concrete_powder_mold"));
        pluginContext.resolveModel().register(new SwordYellowConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelYellowConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeYellowConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeYellowConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeYellowConcretePowderMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/lime_concrete_powder_mold"));
        pluginContext.resolveModel().register(new SwordLimeConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLimeConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLimeConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLimeConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLimeConcretePowderMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/green_concrete_powder_mold"));
        pluginContext.resolveModel().register(new SwordGreenConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelGreenConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeGreenConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeGreenConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeGreenConcretePowderMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/cyan_concrete_powder_mold"));
        pluginContext.resolveModel().register(new SwordCyanConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelCyanConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeCyanConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeCyanConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeCyanConcretePowderMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/light_blue_concrete_powder_mold"));
        pluginContext.resolveModel().register(new SwordLightBlueConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelLightBlueConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeLightBlueConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeLightBlueConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeLightBlueConcretePowderMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/blue_concrete_powder_mold"));
        pluginContext.resolveModel().register(new SwordBlueConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelBlueConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeBlueConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeBlueConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeBlueConcretePowderMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/purple_concrete_powder_mold"));
        pluginContext.resolveModel().register(new SwordPurpleConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelPurpleConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxePurpleConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxePurpleConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoePurpleConcretePowderMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/magenta_concrete_powder_mold"));
        pluginContext.resolveModel().register(new SwordMagentaConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelMagentaConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxeMagentaConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxeMagentaConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoeMagentaConcretePowderMoldItemModelResolver());

        pluginContext.addModels(CreateModularTools.asResource("block/pink_concrete_powder_mold"));
        pluginContext.resolveModel().register(new SwordPinkConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new ShovelPinkConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new PickaxePinkConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new AxePinkConcretePowderMoldItemModelResolver());
        pluginContext.resolveModel().register(new HoePinkConcretePowderMoldItemModelResolver());
    }
}
