package net.zlt.create_modular_tools.client.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.client.model.item.mold.*;
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
    }
}
