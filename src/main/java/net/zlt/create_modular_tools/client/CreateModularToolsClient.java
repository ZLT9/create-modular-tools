package net.zlt.create_modular_tools.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.event.client.player.ClientPickBlockApplyCallback;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluids;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.AllMoldTopTextures;
import net.zlt.create_modular_tools.block.mold.SandMoldBlock;
import net.zlt.create_modular_tools.client.model.CreateModularToolsModelLoadingPlugin;
import net.zlt.create_modular_tools.client.renderer.blockentity.*;
import net.zlt.create_modular_tools.client.renderer.entity.*;
import net.zlt.create_modular_tools.container.menu.AllMenuTypes;
import net.zlt.create_modular_tools.container.screen.CreativeModularToolTableScreen;
import net.zlt.create_modular_tools.entity.AllEntityTypes;
import net.zlt.create_modular_tools.fluid.AllFluids;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.tool.AllModularTools;
import net.zlt.create_modular_tools.tool.module.AllToolModuleTypes;
import net.zlt.create_modular_tools.tool.module.AllToolModules;
import net.zlt.create_modular_tools.tool.module.ToolModule;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.UUID;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CreateModularToolsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(AllEntityTypes.WOOD_PICKAXE_HEAD, ThrownWoodPickaxeHeadRenderer::new);
        EntityRendererRegistry.register(AllEntityTypes.STONE_PICKAXE_HEAD, ThrownStonePickaxeHeadRenderer::new);
        EntityRendererRegistry.register(AllEntityTypes.IRON_PICKAXE_HEAD, ThrownIronPickaxeHeadRenderer::new);
        EntityRendererRegistry.register(AllEntityTypes.COPPER_PICKAXE_HEAD, ThrownCopperPickaxeHeadRenderer::new);
        EntityRendererRegistry.register(AllEntityTypes.GOLD_PICKAXE_HEAD, ThrownGoldPickaxeHeadRenderer::new);
        EntityRendererRegistry.register(AllEntityTypes.NETHERITE_PICKAXE_HEAD, ThrownNetheritePickaxeHeadRenderer::new);
        EntityRendererRegistry.register(AllEntityTypes.ZINC_PICKAXE_HEAD, ThrownZincPickaxeHeadRenderer::new);
        EntityRendererRegistry.register(AllEntityTypes.BRASS_PICKAXE_HEAD, ThrownBrassPickaxeHeadRenderer::new);
        EntityRendererRegistry.register(AllEntityTypes.DIAMOND_PICKAXE_HEAD, ThrownDiamondPickaxeHeadRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_SAND_MOLD, SwordSandMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_SAND_MOLD, ShovelSandMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_SAND_MOLD, PickaxeSandMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_SAND_MOLD, AxeSandMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_SAND_MOLD, HoeSandMoldRenderer::new);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutoutMipped(), AllMoldBlocks.SAND_MOLD, AllMoldBlocks.SWORD_SAND_MOLD, AllMoldBlocks.SHOVEL_SAND_MOLD, AllMoldBlocks.PICKAXE_SAND_MOLD, AllMoldBlocks.AXE_SAND_MOLD, AllMoldBlocks.HOE_SAND_MOLD);

        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.MOLTEN_IRON, AllFluids.FLOWING_MOLTEN_IRON, new SimpleFluidRenderHandler(CreateModularTools.asResource("block/molten_iron_still"), CreateModularTools.asResource("block/molten_iron_flow")));
        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.MOLTEN_COPPER, AllFluids.FLOWING_MOLTEN_COPPER, new SimpleFluidRenderHandler(CreateModularTools.asResource("block/molten_copper_still"), CreateModularTools.asResource("block/molten_copper_flow")));
        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.MOLTEN_GOLD, AllFluids.FLOWING_MOLTEN_GOLD, new SimpleFluidRenderHandler(CreateModularTools.asResource("block/molten_gold_still"), CreateModularTools.asResource("block/molten_gold_flow")));
        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.MOLTEN_NETHERITE, AllFluids.FLOWING_MOLTEN_NETHERITE, new SimpleFluidRenderHandler(CreateModularTools.asResource("block/molten_netherite_still"), CreateModularTools.asResource("block/molten_netherite_flow")));
        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.MOLTEN_ZINC, AllFluids.FLOWING_MOLTEN_ZINC, new SimpleFluidRenderHandler(CreateModularTools.asResource("block/molten_zinc_still"), CreateModularTools.asResource("block/molten_zinc_flow")));
        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.MOLTEN_BRASS, AllFluids.FLOWING_MOLTEN_BRASS, new SimpleFluidRenderHandler(CreateModularTools.asResource("block/molten_brass_still"), CreateModularTools.asResource("block/molten_brass_flow")));
        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.MOLTEN_DIAMOND, AllFluids.FLOWING_MOLTEN_DIAMOND, new SimpleFluidRenderHandler(CreateModularTools.asResource("block/molten_diamond_still"), CreateModularTools.asResource("block/molten_diamond_flow")));

        ModelLoadingPlugin.register(new CreateModularToolsModelLoadingPlugin());

        MenuScreens.register(AllMenuTypes.CREATIVE_MODULAR_TOOL_TABLE, CreativeModularToolTableScreen::new);

        ClientPickBlockApplyCallback.EVENT.register((player, hit, stack) -> {
            if (stack.getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof SandMoldBlock) {
                CompoundTag nbt = stack.getTag();
                if (nbt != null && !nbt.contains("UUID", Tag.TAG_INT_ARRAY)) {
                    nbt.putUUID("UUID", UUID.randomUUID());
                }
            }
            return stack;
        });

        AllToolModuleTypes.SWORD_BLADE.putIcon(AllModularTools.SWORD, CreateModularTools.asResource("textures/gui/container/sword_blade.png"));
        AllToolModuleTypes.SHOVEL_HEAD.putIcon(AllModularTools.SHOVEL, CreateModularTools.asResource("textures/gui/container/shovel_head.png"));
        AllToolModuleTypes.PICKAXE_HEAD.putIcon(AllModularTools.PICKAXE, CreateModularTools.asResource("textures/gui/container/pickaxe_head.png"));
        AllToolModuleTypes.AXE_HEAD.putIcon(AllModularTools.AXE, CreateModularTools.asResource("textures/gui/container/axe_head.png"));
        AllToolModuleTypes.HOE_HEAD.putIcon(AllModularTools.HOE, CreateModularTools.asResource("textures/gui/container/hoe_head.png"));
        AllToolModuleTypes.TOOL_HANDLE.putIcon(AllModularTools.SWORD, CreateModularTools.asResource("textures/gui/container/sword_handle.png"));
        AllToolModuleTypes.TOOL_HANDLE.putIcon(AllModularTools.SHOVEL, CreateModularTools.asResource("textures/gui/container/shovel_handle.png"));
        AllToolModuleTypes.TOOL_HANDLE.putIcon(AllModularTools.PICKAXE, CreateModularTools.asResource("textures/gui/container/pickaxe_handle.png"));
        AllToolModuleTypes.TOOL_HANDLE.putIcon(AllModularTools.AXE, CreateModularTools.asResource("textures/gui/container/axe_handle.png"));
        AllToolModuleTypes.TOOL_HANDLE.putIcon(AllModularTools.HOE, CreateModularTools.asResource("textures/gui/container/hoe_handle.png"));
        AllToolModuleTypes.TOOL_GRIP.putIcon(AllModularTools.SHOVEL, CreateModularTools.asResource("textures/gui/container/shovel_grip.png"));
        AllToolModuleTypes.TOOL_GRIP.putIcon(AllModularTools.PICKAXE, CreateModularTools.asResource("textures/gui/container/pickaxe_grip.png"));
        AllToolModuleTypes.TOOL_GRIP.putIcon(AllModularTools.AXE, CreateModularTools.asResource("textures/gui/container/axe_grip.png"));
        AllToolModuleTypes.TOOL_GRIP.putIcon(AllModularTools.HOE, CreateModularTools.asResource("textures/gui/container/hoe_grip.png"));
        AllToolModuleTypes.SWORD_GUARD.putIcon(AllModularTools.SWORD, CreateModularTools.asResource("textures/gui/container/guard.png"));
        AllToolModuleTypes.SWORD_POMMEL.putIcon(AllModularTools.SWORD, CreateModularTools.asResource("textures/gui/container/pommel.png"));

        AllToolModuleModelIds.init();

        registerToolModuleModelIds(AllToolModules.WOODEN_SWORD_BLADE, AllToolModuleModelIds.WOODEN_SWORD_BLADE);
        registerToolModuleModelIds(AllToolModules.STONE_SWORD_BLADE, AllToolModuleModelIds.STONE_SWORD_BLADE);
        registerToolModuleModelIds(AllToolModules.IRON_SWORD_BLADE, AllToolModuleModelIds.IRON_SWORD_BLADE);
        registerToolModuleModelIds(AllToolModules.COPPER_SWORD_BLADE, AllToolModuleModelIds.COPPER_SWORD_BLADE);
        registerToolModuleModelIds(AllToolModules.GOLDEN_SWORD_BLADE, AllToolModuleModelIds.GOLDEN_SWORD_BLADE);
        registerToolModuleModelIds(AllToolModules.NETHERITE_SWORD_BLADE, AllToolModuleModelIds.NETHERITE_SWORD_BLADE);
        registerToolModuleModelIds(AllToolModules.ZINC_SWORD_BLADE, AllToolModuleModelIds.ZINC_SWORD_BLADE);
        registerToolModuleModelIds(AllToolModules.BRASS_SWORD_BLADE, AllToolModuleModelIds.BRASS_SWORD_BLADE);
        registerToolModuleModelIds(AllToolModules.DIAMOND_SWORD_BLADE, AllToolModuleModelIds.DIAMOND_SWORD_BLADE);

        registerToolModuleModelIds(AllToolModules.WOODEN_SHOVEL_HEAD, AllToolModuleModelIds.WOODEN_SHOVEL_HEAD);
        registerToolModuleModelIds(AllToolModules.STONE_SHOVEL_HEAD, AllToolModuleModelIds.STONE_SHOVEL_HEAD);
        registerToolModuleModelIds(AllToolModules.IRON_SHOVEL_HEAD, AllToolModuleModelIds.IRON_SHOVEL_HEAD);
        registerToolModuleModelIds(AllToolModules.COPPER_SHOVEL_HEAD, AllToolModuleModelIds.COPPER_SHOVEL_HEAD);
        registerToolModuleModelIds(AllToolModules.GOLDEN_SHOVEL_HEAD, AllToolModuleModelIds.GOLDEN_SHOVEL_HEAD);
        registerToolModuleModelIds(AllToolModules.NETHERITE_SHOVEL_HEAD, AllToolModuleModelIds.NETHERITE_SHOVEL_HEAD);
        registerToolModuleModelIds(AllToolModules.ZINC_SHOVEL_HEAD, AllToolModuleModelIds.ZINC_SHOVEL_HEAD);
        registerToolModuleModelIds(AllToolModules.BRASS_SHOVEL_HEAD, AllToolModuleModelIds.BRASS_SHOVEL_HEAD);
        registerToolModuleModelIds(AllToolModules.DIAMOND_SHOVEL_HEAD, AllToolModuleModelIds.DIAMOND_SHOVEL_HEAD);

        registerToolModuleModelIds(AllToolModules.WOODEN_PICKAXE_HEAD, AllToolModuleModelIds.WOODEN_PICKAXE_HEAD);
        registerToolModuleModelIds(AllToolModules.STONE_PICKAXE_HEAD, AllToolModuleModelIds.STONE_PICKAXE_HEAD);
        registerToolModuleModelIds(AllToolModules.IRON_PICKAXE_HEAD, AllToolModuleModelIds.IRON_PICKAXE_HEAD);
        registerToolModuleModelIds(AllToolModules.COPPER_PICKAXE_HEAD, AllToolModuleModelIds.COPPER_PICKAXE_HEAD);
        registerToolModuleModelIds(AllToolModules.GOLDEN_PICKAXE_HEAD, AllToolModuleModelIds.GOLDEN_PICKAXE_HEAD);
        registerToolModuleModelIds(AllToolModules.NETHERITE_PICKAXE_HEAD, AllToolModuleModelIds.NETHERITE_PICKAXE_HEAD);
        registerToolModuleModelIds(AllToolModules.ZINC_PICKAXE_HEAD, AllToolModuleModelIds.ZINC_PICKAXE_HEAD);
        registerToolModuleModelIds(AllToolModules.BRASS_PICKAXE_HEAD, AllToolModuleModelIds.BRASS_PICKAXE_HEAD);
        registerToolModuleModelIds(AllToolModules.DIAMOND_PICKAXE_HEAD, AllToolModuleModelIds.DIAMOND_PICKAXE_HEAD);

        registerToolModuleModelIds(AllToolModules.WOODEN_PICKAXE_HEAD, AllToolModuleModelIds.WOODEN_PICKAXE_HEAD_ITEM);
        registerToolModuleModelIds(AllToolModules.STONE_PICKAXE_HEAD, AllToolModuleModelIds.STONE_PICKAXE_HEAD_ITEM);
        registerToolModuleModelIds(AllToolModules.IRON_PICKAXE_HEAD, AllToolModuleModelIds.IRON_PICKAXE_HEAD_ITEM);
        registerToolModuleModelIds(AllToolModules.COPPER_PICKAXE_HEAD, AllToolModuleModelIds.COPPER_PICKAXE_HEAD_ITEM);
        registerToolModuleModelIds(AllToolModules.GOLDEN_PICKAXE_HEAD, AllToolModuleModelIds.GOLDEN_PICKAXE_HEAD_ITEM);
        registerToolModuleModelIds(AllToolModules.NETHERITE_PICKAXE_HEAD, AllToolModuleModelIds.NETHERITE_PICKAXE_HEAD_ITEM);
        registerToolModuleModelIds(AllToolModules.ZINC_PICKAXE_HEAD, AllToolModuleModelIds.ZINC_PICKAXE_HEAD_ITEM);
        registerToolModuleModelIds(AllToolModules.BRASS_PICKAXE_HEAD, AllToolModuleModelIds.BRASS_PICKAXE_HEAD_ITEM);
        registerToolModuleModelIds(AllToolModules.DIAMOND_PICKAXE_HEAD, AllToolModuleModelIds.DIAMOND_PICKAXE_HEAD_ITEM);

        registerToolModuleModelIds(AllToolModules.WOODEN_AXE_HEAD, AllToolModuleModelIds.WOODEN_AXE_HEAD);
        registerToolModuleModelIds(AllToolModules.STONE_AXE_HEAD, AllToolModuleModelIds.STONE_AXE_HEAD);
        registerToolModuleModelIds(AllToolModules.IRON_AXE_HEAD, AllToolModuleModelIds.IRON_AXE_HEAD);
        registerToolModuleModelIds(AllToolModules.COPPER_AXE_HEAD, AllToolModuleModelIds.COPPER_AXE_HEAD);
        registerToolModuleModelIds(AllToolModules.GOLDEN_AXE_HEAD, AllToolModuleModelIds.GOLDEN_AXE_HEAD);
        registerToolModuleModelIds(AllToolModules.NETHERITE_AXE_HEAD, AllToolModuleModelIds.NETHERITE_AXE_HEAD);
        registerToolModuleModelIds(AllToolModules.ZINC_AXE_HEAD, AllToolModuleModelIds.ZINC_AXE_HEAD);
        registerToolModuleModelIds(AllToolModules.BRASS_AXE_HEAD, AllToolModuleModelIds.BRASS_AXE_HEAD);
        registerToolModuleModelIds(AllToolModules.DIAMOND_AXE_HEAD, AllToolModuleModelIds.DIAMOND_AXE_HEAD);

        registerToolModuleModelIds(AllToolModules.WOODEN_HOE_HEAD, AllToolModuleModelIds.WOODEN_HOE_HEAD);
        registerToolModuleModelIds(AllToolModules.STONE_HOE_HEAD, AllToolModuleModelIds.STONE_HOE_HEAD);
        registerToolModuleModelIds(AllToolModules.IRON_HOE_HEAD, AllToolModuleModelIds.IRON_HOE_HEAD);
        registerToolModuleModelIds(AllToolModules.COPPER_HOE_HEAD, AllToolModuleModelIds.COPPER_HOE_HEAD);
        registerToolModuleModelIds(AllToolModules.GOLDEN_HOE_HEAD, AllToolModuleModelIds.GOLDEN_HOE_HEAD);
        registerToolModuleModelIds(AllToolModules.NETHERITE_HOE_HEAD, AllToolModuleModelIds.NETHERITE_HOE_HEAD);
        registerToolModuleModelIds(AllToolModules.ZINC_HOE_HEAD, AllToolModuleModelIds.ZINC_HOE_HEAD);
        registerToolModuleModelIds(AllToolModules.BRASS_HOE_HEAD, AllToolModuleModelIds.BRASS_HOE_HEAD);
        registerToolModuleModelIds(AllToolModules.DIAMOND_HOE_HEAD, AllToolModuleModelIds.DIAMOND_HOE_HEAD);

        registerToolModuleModelIds(AllToolModules.WOODEN_TOOL_HANDLE, AllToolModuleModelIds.WOODEN_SWORD_HANDLE, AllToolModuleModelIds.WOODEN_POMMEL_SWORD_HANDLE, AllToolModuleModelIds.WOODEN_SHOVEL_HANDLE, AllToolModuleModelIds.WOODEN_GRIP_SHOVEL_HANDLE, AllToolModuleModelIds.WOODEN_PICKAXE_HANDLE, AllToolModuleModelIds.WOODEN_GRIP_PICKAXE_HANDLE, AllToolModuleModelIds.WOODEN_AXE_HANDLE, AllToolModuleModelIds.WOODEN_GRIP_AXE_HANDLE, AllToolModuleModelIds.WOODEN_HOE_HANDLE, AllToolModuleModelIds.WOODEN_GRIP_HOE_HANDLE);
        registerToolModuleModelIds(AllToolModules.STONE_TOOL_HANDLE, AllToolModuleModelIds.STONE_SWORD_HANDLE, AllToolModuleModelIds.STONE_POMMEL_SWORD_HANDLE, AllToolModuleModelIds.STONE_SHOVEL_HANDLE, AllToolModuleModelIds.STONE_GRIP_SHOVEL_HANDLE, AllToolModuleModelIds.STONE_PICKAXE_HANDLE, AllToolModuleModelIds.STONE_GRIP_PICKAXE_HANDLE, AllToolModuleModelIds.STONE_AXE_HANDLE, AllToolModuleModelIds.STONE_GRIP_AXE_HANDLE, AllToolModuleModelIds.STONE_HOE_HANDLE, AllToolModuleModelIds.STONE_GRIP_HOE_HANDLE);
        registerToolModuleModelIds(AllToolModules.IRON_TOOL_HANDLE, AllToolModuleModelIds.IRON_SWORD_HANDLE, AllToolModuleModelIds.IRON_POMMEL_SWORD_HANDLE, AllToolModuleModelIds.IRON_SHOVEL_HANDLE, AllToolModuleModelIds.IRON_GRIP_SHOVEL_HANDLE, AllToolModuleModelIds.IRON_PICKAXE_HANDLE, AllToolModuleModelIds.IRON_GRIP_PICKAXE_HANDLE, AllToolModuleModelIds.IRON_AXE_HANDLE, AllToolModuleModelIds.IRON_GRIP_AXE_HANDLE, AllToolModuleModelIds.IRON_HOE_HANDLE, AllToolModuleModelIds.IRON_GRIP_HOE_HANDLE);
        registerToolModuleModelIds(AllToolModules.COPPER_TOOL_HANDLE, AllToolModuleModelIds.COPPER_SWORD_HANDLE, AllToolModuleModelIds.COPPER_POMMEL_SWORD_HANDLE, AllToolModuleModelIds.COPPER_SHOVEL_HANDLE, AllToolModuleModelIds.COPPER_GRIP_SHOVEL_HANDLE, AllToolModuleModelIds.COPPER_PICKAXE_HANDLE, AllToolModuleModelIds.COPPER_GRIP_PICKAXE_HANDLE, AllToolModuleModelIds.COPPER_AXE_HANDLE, AllToolModuleModelIds.COPPER_GRIP_AXE_HANDLE, AllToolModuleModelIds.COPPER_HOE_HANDLE, AllToolModuleModelIds.COPPER_GRIP_HOE_HANDLE);
        registerToolModuleModelIds(AllToolModules.GOLDEN_TOOL_HANDLE, AllToolModuleModelIds.GOLDEN_SWORD_HANDLE, AllToolModuleModelIds.GOLDEN_POMMEL_SWORD_HANDLE, AllToolModuleModelIds.GOLDEN_SHOVEL_HANDLE, AllToolModuleModelIds.GOLDEN_GRIP_SHOVEL_HANDLE, AllToolModuleModelIds.GOLDEN_PICKAXE_HANDLE, AllToolModuleModelIds.GOLDEN_GRIP_PICKAXE_HANDLE, AllToolModuleModelIds.GOLDEN_AXE_HANDLE, AllToolModuleModelIds.GOLDEN_GRIP_AXE_HANDLE, AllToolModuleModelIds.GOLDEN_HOE_HANDLE, AllToolModuleModelIds.GOLDEN_GRIP_HOE_HANDLE);
        registerToolModuleModelIds(AllToolModules.NETHERITE_TOOL_HANDLE, AllToolModuleModelIds.NETHERITE_SWORD_HANDLE, AllToolModuleModelIds.NETHERITE_POMMEL_SWORD_HANDLE, AllToolModuleModelIds.NETHERITE_SHOVEL_HANDLE, AllToolModuleModelIds.NETHERITE_GRIP_SHOVEL_HANDLE, AllToolModuleModelIds.NETHERITE_PICKAXE_HANDLE, AllToolModuleModelIds.NETHERITE_GRIP_PICKAXE_HANDLE, AllToolModuleModelIds.NETHERITE_AXE_HANDLE, AllToolModuleModelIds.NETHERITE_GRIP_AXE_HANDLE, AllToolModuleModelIds.NETHERITE_HOE_HANDLE, AllToolModuleModelIds.NETHERITE_GRIP_HOE_HANDLE);
        registerToolModuleModelIds(AllToolModules.ZINC_TOOL_HANDLE, AllToolModuleModelIds.ZINC_SWORD_HANDLE, AllToolModuleModelIds.ZINC_POMMEL_SWORD_HANDLE, AllToolModuleModelIds.ZINC_SHOVEL_HANDLE, AllToolModuleModelIds.ZINC_GRIP_SHOVEL_HANDLE, AllToolModuleModelIds.ZINC_PICKAXE_HANDLE, AllToolModuleModelIds.ZINC_GRIP_PICKAXE_HANDLE, AllToolModuleModelIds.ZINC_AXE_HANDLE, AllToolModuleModelIds.ZINC_GRIP_AXE_HANDLE, AllToolModuleModelIds.ZINC_HOE_HANDLE, AllToolModuleModelIds.ZINC_GRIP_HOE_HANDLE);
        registerToolModuleModelIds(AllToolModules.BRASS_TOOL_HANDLE, AllToolModuleModelIds.BRASS_SWORD_HANDLE, AllToolModuleModelIds.BRASS_POMMEL_SWORD_HANDLE, AllToolModuleModelIds.BRASS_SHOVEL_HANDLE, AllToolModuleModelIds.BRASS_GRIP_SHOVEL_HANDLE, AllToolModuleModelIds.BRASS_PICKAXE_HANDLE, AllToolModuleModelIds.BRASS_GRIP_PICKAXE_HANDLE, AllToolModuleModelIds.BRASS_AXE_HANDLE, AllToolModuleModelIds.BRASS_GRIP_AXE_HANDLE, AllToolModuleModelIds.BRASS_HOE_HANDLE, AllToolModuleModelIds.BRASS_GRIP_HOE_HANDLE);
        registerToolModuleModelIds(AllToolModules.DIAMOND_TOOL_HANDLE, AllToolModuleModelIds.DIAMOND_SWORD_HANDLE, AllToolModuleModelIds.DIAMOND_POMMEL_SWORD_HANDLE, AllToolModuleModelIds.DIAMOND_SHOVEL_HANDLE, AllToolModuleModelIds.DIAMOND_GRIP_SHOVEL_HANDLE, AllToolModuleModelIds.DIAMOND_PICKAXE_HANDLE, AllToolModuleModelIds.DIAMOND_GRIP_PICKAXE_HANDLE, AllToolModuleModelIds.DIAMOND_AXE_HANDLE, AllToolModuleModelIds.DIAMOND_GRIP_AXE_HANDLE, AllToolModuleModelIds.DIAMOND_HOE_HANDLE, AllToolModuleModelIds.DIAMOND_GRIP_HOE_HANDLE);

        registerToolModuleModelIds(AllToolModules.WOODEN_TOOL_GRIP, AllToolModuleModelIds.WOODEN_GRIP);
        registerToolModuleModelIds(AllToolModules.STONE_TOOL_GRIP, AllToolModuleModelIds.STONE_GRIP);
        registerToolModuleModelIds(AllToolModules.IRON_TOOL_GRIP, AllToolModuleModelIds.IRON_GRIP);
        registerToolModuleModelIds(AllToolModules.COPPER_TOOL_GRIP, AllToolModuleModelIds.COPPER_GRIP);
        registerToolModuleModelIds(AllToolModules.GOLDEN_TOOL_GRIP, AllToolModuleModelIds.GOLDEN_GRIP);
        registerToolModuleModelIds(AllToolModules.NETHERITE_TOOL_GRIP, AllToolModuleModelIds.NETHERITE_GRIP);
        registerToolModuleModelIds(AllToolModules.ZINC_TOOL_GRIP, AllToolModuleModelIds.ZINC_GRIP);
        registerToolModuleModelIds(AllToolModules.BRASS_TOOL_GRIP, AllToolModuleModelIds.BRASS_GRIP);
        registerToolModuleModelIds(AllToolModules.DIAMOND_TOOL_GRIP, AllToolModuleModelIds.DIAMOND_GRIP);

        registerToolModuleModelIds(AllToolModules.WOODEN_SWORD_GUARD, AllToolModuleModelIds.WOODEN_GUARD);
        registerToolModuleModelIds(AllToolModules.STONE_SWORD_GUARD, AllToolModuleModelIds.STONE_GUARD);
        registerToolModuleModelIds(AllToolModules.IRON_SWORD_GUARD, AllToolModuleModelIds.IRON_GUARD);
        registerToolModuleModelIds(AllToolModules.COPPER_SWORD_GUARD, AllToolModuleModelIds.COPPER_GUARD);
        registerToolModuleModelIds(AllToolModules.GOLDEN_SWORD_GUARD, AllToolModuleModelIds.GOLDEN_GUARD);
        registerToolModuleModelIds(AllToolModules.NETHERITE_SWORD_GUARD, AllToolModuleModelIds.NETHERITE_GUARD);
        registerToolModuleModelIds(AllToolModules.ZINC_SWORD_GUARD, AllToolModuleModelIds.ZINC_GUARD);
        registerToolModuleModelIds(AllToolModules.BRASS_SWORD_GUARD, AllToolModuleModelIds.BRASS_GUARD);
        registerToolModuleModelIds(AllToolModules.DIAMOND_SWORD_GUARD, AllToolModuleModelIds.DIAMOND_GUARD);

        registerToolModuleModelIds(AllToolModules.WOODEN_SWORD_POMMEL, AllToolModuleModelIds.WOODEN_POMMEL);
        registerToolModuleModelIds(AllToolModules.STONE_SWORD_POMMEL, AllToolModuleModelIds.STONE_POMMEL);
        registerToolModuleModelIds(AllToolModules.IRON_SWORD_POMMEL, AllToolModuleModelIds.IRON_POMMEL);
        registerToolModuleModelIds(AllToolModules.COPPER_SWORD_POMMEL, AllToolModuleModelIds.COPPER_POMMEL);
        registerToolModuleModelIds(AllToolModules.GOLDEN_SWORD_POMMEL, AllToolModuleModelIds.GOLDEN_POMMEL);
        registerToolModuleModelIds(AllToolModules.NETHERITE_SWORD_POMMEL, AllToolModuleModelIds.NETHERITE_POMMEL);
        registerToolModuleModelIds(AllToolModules.ZINC_SWORD_POMMEL, AllToolModuleModelIds.ZINC_POMMEL);
        registerToolModuleModelIds(AllToolModules.BRASS_SWORD_POMMEL, AllToolModuleModelIds.BRASS_POMMEL);
        registerToolModuleModelIds(AllToolModules.DIAMOND_SWORD_POMMEL, AllToolModuleModelIds.DIAMOND_POMMEL);

        registerToolModuleBaseModelIdGetter(AllToolModules.WOODEN_SWORD_BLADE, AllToolModuleModelIds.WOODEN_SWORD_BLADE);
        registerToolModuleBaseModelIdGetter(AllToolModules.STONE_SWORD_BLADE, AllToolModuleModelIds.STONE_SWORD_BLADE);
        registerToolModuleBaseModelIdGetter(AllToolModules.IRON_SWORD_BLADE, AllToolModuleModelIds.IRON_SWORD_BLADE);
        registerToolModuleBaseModelIdGetter(AllToolModules.COPPER_SWORD_BLADE, AllToolModuleModelIds.COPPER_SWORD_BLADE);
        registerToolModuleBaseModelIdGetter(AllToolModules.GOLDEN_SWORD_BLADE, AllToolModuleModelIds.GOLDEN_SWORD_BLADE);
        registerToolModuleBaseModelIdGetter(AllToolModules.NETHERITE_SWORD_BLADE, AllToolModuleModelIds.NETHERITE_SWORD_BLADE);
        registerToolModuleBaseModelIdGetter(AllToolModules.ZINC_SWORD_BLADE, AllToolModuleModelIds.ZINC_SWORD_BLADE);
        registerToolModuleBaseModelIdGetter(AllToolModules.BRASS_SWORD_BLADE, AllToolModuleModelIds.BRASS_SWORD_BLADE);
        registerToolModuleBaseModelIdGetter(AllToolModules.DIAMOND_SWORD_BLADE, AllToolModuleModelIds.DIAMOND_SWORD_BLADE);

        registerToolModuleBaseModelIdGetter(AllToolModules.WOODEN_SHOVEL_HEAD, AllToolModuleModelIds.WOODEN_SHOVEL_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.STONE_SHOVEL_HEAD, AllToolModuleModelIds.STONE_SHOVEL_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.IRON_SHOVEL_HEAD, AllToolModuleModelIds.IRON_SHOVEL_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.COPPER_SHOVEL_HEAD, AllToolModuleModelIds.COPPER_SHOVEL_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.GOLDEN_SHOVEL_HEAD, AllToolModuleModelIds.GOLDEN_SHOVEL_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.NETHERITE_SHOVEL_HEAD, AllToolModuleModelIds.NETHERITE_SHOVEL_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.ZINC_SHOVEL_HEAD, AllToolModuleModelIds.ZINC_SHOVEL_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.BRASS_SHOVEL_HEAD, AllToolModuleModelIds.BRASS_SHOVEL_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.DIAMOND_SHOVEL_HEAD, AllToolModuleModelIds.DIAMOND_SHOVEL_HEAD);

        registerToolModuleBaseModelIdGetter(AllToolModules.WOODEN_PICKAXE_HEAD, AllToolModuleModelIds.WOODEN_PICKAXE_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.STONE_PICKAXE_HEAD, AllToolModuleModelIds.STONE_PICKAXE_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.IRON_PICKAXE_HEAD, AllToolModuleModelIds.IRON_PICKAXE_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.COPPER_PICKAXE_HEAD, AllToolModuleModelIds.COPPER_PICKAXE_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.GOLDEN_PICKAXE_HEAD, AllToolModuleModelIds.GOLDEN_PICKAXE_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.NETHERITE_PICKAXE_HEAD, AllToolModuleModelIds.NETHERITE_PICKAXE_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.ZINC_PICKAXE_HEAD, AllToolModuleModelIds.ZINC_PICKAXE_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.BRASS_PICKAXE_HEAD, AllToolModuleModelIds.BRASS_PICKAXE_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.DIAMOND_PICKAXE_HEAD, AllToolModuleModelIds.DIAMOND_PICKAXE_HEAD);

        registerToolModuleBaseModelIdGetter(AllToolModules.WOODEN_AXE_HEAD, AllToolModuleModelIds.WOODEN_AXE_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.STONE_AXE_HEAD, AllToolModuleModelIds.STONE_AXE_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.IRON_AXE_HEAD, AllToolModuleModelIds.IRON_AXE_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.COPPER_AXE_HEAD, AllToolModuleModelIds.COPPER_AXE_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.GOLDEN_AXE_HEAD, AllToolModuleModelIds.GOLDEN_AXE_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.NETHERITE_AXE_HEAD, AllToolModuleModelIds.NETHERITE_AXE_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.ZINC_AXE_HEAD, AllToolModuleModelIds.ZINC_AXE_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.BRASS_AXE_HEAD, AllToolModuleModelIds.BRASS_AXE_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.DIAMOND_AXE_HEAD, AllToolModuleModelIds.DIAMOND_AXE_HEAD);

        registerToolModuleBaseModelIdGetter(AllToolModules.WOODEN_HOE_HEAD, AllToolModuleModelIds.WOODEN_HOE_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.STONE_HOE_HEAD, AllToolModuleModelIds.STONE_HOE_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.IRON_HOE_HEAD, AllToolModuleModelIds.IRON_HOE_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.COPPER_HOE_HEAD, AllToolModuleModelIds.COPPER_HOE_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.GOLDEN_HOE_HEAD, AllToolModuleModelIds.GOLDEN_HOE_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.NETHERITE_HOE_HEAD, AllToolModuleModelIds.NETHERITE_HOE_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.ZINC_HOE_HEAD, AllToolModuleModelIds.ZINC_HOE_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.BRASS_HOE_HEAD, AllToolModuleModelIds.BRASS_HOE_HEAD);
        registerToolModuleBaseModelIdGetter(AllToolModules.DIAMOND_HOE_HEAD, AllToolModuleModelIds.DIAMOND_HOE_HEAD);

        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.WOODEN_TOOL_HANDLE, AllModularTools.SWORD, AllToolModuleTypes.SWORD_POMMEL, AllToolModuleModelIds.WOODEN_SWORD_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.STONE_TOOL_HANDLE, AllModularTools.SWORD, AllToolModuleTypes.SWORD_POMMEL, AllToolModuleModelIds.STONE_SWORD_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.IRON_TOOL_HANDLE, AllModularTools.SWORD, AllToolModuleTypes.SWORD_POMMEL, AllToolModuleModelIds.IRON_SWORD_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.COPPER_TOOL_HANDLE, AllModularTools.SWORD, AllToolModuleTypes.SWORD_POMMEL, AllToolModuleModelIds.COPPER_SWORD_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.GOLDEN_TOOL_HANDLE, AllModularTools.SWORD, AllToolModuleTypes.SWORD_POMMEL, AllToolModuleModelIds.GOLDEN_SWORD_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.NETHERITE_TOOL_HANDLE, AllModularTools.SWORD, AllToolModuleTypes.SWORD_POMMEL, AllToolModuleModelIds.NETHERITE_SWORD_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.ZINC_TOOL_HANDLE, AllModularTools.SWORD, AllToolModuleTypes.SWORD_POMMEL, AllToolModuleModelIds.ZINC_SWORD_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.BRASS_TOOL_HANDLE, AllModularTools.SWORD, AllToolModuleTypes.SWORD_POMMEL, AllToolModuleModelIds.BRASS_SWORD_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.DIAMOND_TOOL_HANDLE, AllModularTools.SWORD, AllToolModuleTypes.SWORD_POMMEL, AllToolModuleModelIds.DIAMOND_SWORD_HANDLE);

        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.WOODEN_TOOL_HANDLE, AllModularTools.SHOVEL, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.WOODEN_SHOVEL_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.STONE_TOOL_HANDLE, AllModularTools.SHOVEL, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.STONE_SHOVEL_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.IRON_TOOL_HANDLE, AllModularTools.SHOVEL, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.IRON_SHOVEL_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.COPPER_TOOL_HANDLE, AllModularTools.SHOVEL, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.COPPER_SHOVEL_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.GOLDEN_TOOL_HANDLE, AllModularTools.SHOVEL, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.GOLDEN_SHOVEL_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.NETHERITE_TOOL_HANDLE, AllModularTools.SHOVEL, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.NETHERITE_SHOVEL_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.ZINC_TOOL_HANDLE, AllModularTools.SHOVEL, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.ZINC_SHOVEL_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.BRASS_TOOL_HANDLE, AllModularTools.SHOVEL, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.BRASS_SHOVEL_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.DIAMOND_TOOL_HANDLE, AllModularTools.SHOVEL, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.DIAMOND_SHOVEL_HANDLE);

        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.WOODEN_TOOL_HANDLE, AllModularTools.PICKAXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.WOODEN_PICKAXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.STONE_TOOL_HANDLE, AllModularTools.PICKAXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.STONE_PICKAXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.IRON_TOOL_HANDLE, AllModularTools.PICKAXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.IRON_PICKAXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.COPPER_TOOL_HANDLE, AllModularTools.PICKAXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.COPPER_PICKAXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.GOLDEN_TOOL_HANDLE, AllModularTools.PICKAXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.GOLDEN_PICKAXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.NETHERITE_TOOL_HANDLE, AllModularTools.PICKAXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.NETHERITE_PICKAXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.ZINC_TOOL_HANDLE, AllModularTools.PICKAXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.ZINC_PICKAXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.BRASS_TOOL_HANDLE, AllModularTools.PICKAXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.BRASS_PICKAXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.DIAMOND_TOOL_HANDLE, AllModularTools.PICKAXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.DIAMOND_PICKAXE_HANDLE);

        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.WOODEN_TOOL_HANDLE, AllModularTools.AXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.WOODEN_AXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.STONE_TOOL_HANDLE, AllModularTools.AXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.STONE_AXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.IRON_TOOL_HANDLE, AllModularTools.AXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.IRON_AXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.COPPER_TOOL_HANDLE, AllModularTools.AXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.COPPER_AXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.GOLDEN_TOOL_HANDLE, AllModularTools.AXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.GOLDEN_AXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.NETHERITE_TOOL_HANDLE, AllModularTools.AXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.NETHERITE_AXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.ZINC_TOOL_HANDLE, AllModularTools.AXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.ZINC_AXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.BRASS_TOOL_HANDLE, AllModularTools.AXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.BRASS_AXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.DIAMOND_TOOL_HANDLE, AllModularTools.AXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.DIAMOND_AXE_HANDLE);

        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.WOODEN_TOOL_HANDLE, AllModularTools.HOE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.WOODEN_HOE_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.STONE_TOOL_HANDLE, AllModularTools.HOE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.STONE_HOE_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.IRON_TOOL_HANDLE, AllModularTools.HOE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.IRON_HOE_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.COPPER_TOOL_HANDLE, AllModularTools.HOE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.COPPER_HOE_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.GOLDEN_TOOL_HANDLE, AllModularTools.HOE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.GOLDEN_HOE_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.NETHERITE_TOOL_HANDLE, AllModularTools.HOE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.NETHERITE_HOE_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.ZINC_TOOL_HANDLE, AllModularTools.HOE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.ZINC_HOE_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.BRASS_TOOL_HANDLE, AllModularTools.HOE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.BRASS_HOE_HANDLE);
        registerToolModuleModelIdGetterForToolWithoutModule(AllToolModules.DIAMOND_TOOL_HANDLE, AllModularTools.HOE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.DIAMOND_HOE_HANDLE);

        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.WOODEN_TOOL_HANDLE, AllModularTools.SWORD, AllToolModuleTypes.SWORD_POMMEL, AllToolModuleModelIds.WOODEN_POMMEL_SWORD_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.STONE_TOOL_HANDLE, AllModularTools.SWORD, AllToolModuleTypes.SWORD_POMMEL, AllToolModuleModelIds.STONE_POMMEL_SWORD_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.IRON_TOOL_HANDLE, AllModularTools.SWORD, AllToolModuleTypes.SWORD_POMMEL, AllToolModuleModelIds.IRON_POMMEL_SWORD_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.COPPER_TOOL_HANDLE, AllModularTools.SWORD, AllToolModuleTypes.SWORD_POMMEL, AllToolModuleModelIds.COPPER_POMMEL_SWORD_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.GOLDEN_TOOL_HANDLE, AllModularTools.SWORD, AllToolModuleTypes.SWORD_POMMEL, AllToolModuleModelIds.GOLDEN_POMMEL_SWORD_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.NETHERITE_TOOL_HANDLE, AllModularTools.SWORD, AllToolModuleTypes.SWORD_POMMEL, AllToolModuleModelIds.NETHERITE_POMMEL_SWORD_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.ZINC_TOOL_HANDLE, AllModularTools.SWORD, AllToolModuleTypes.SWORD_POMMEL, AllToolModuleModelIds.ZINC_POMMEL_SWORD_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.BRASS_TOOL_HANDLE, AllModularTools.SWORD, AllToolModuleTypes.SWORD_POMMEL, AllToolModuleModelIds.BRASS_POMMEL_SWORD_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.DIAMOND_TOOL_HANDLE, AllModularTools.SWORD, AllToolModuleTypes.SWORD_POMMEL, AllToolModuleModelIds.DIAMOND_POMMEL_SWORD_HANDLE);

        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.WOODEN_TOOL_HANDLE, AllModularTools.SHOVEL, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.WOODEN_GRIP_SHOVEL_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.STONE_TOOL_HANDLE, AllModularTools.SHOVEL, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.STONE_GRIP_SHOVEL_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.IRON_TOOL_HANDLE, AllModularTools.SHOVEL, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.IRON_GRIP_SHOVEL_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.COPPER_TOOL_HANDLE, AllModularTools.SHOVEL, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.COPPER_GRIP_SHOVEL_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.GOLDEN_TOOL_HANDLE, AllModularTools.SHOVEL, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.GOLDEN_GRIP_SHOVEL_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.NETHERITE_TOOL_HANDLE, AllModularTools.SHOVEL, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.NETHERITE_GRIP_SHOVEL_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.ZINC_TOOL_HANDLE, AllModularTools.SHOVEL, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.ZINC_GRIP_SHOVEL_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.BRASS_TOOL_HANDLE, AllModularTools.SHOVEL, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.BRASS_GRIP_SHOVEL_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.DIAMOND_TOOL_HANDLE, AllModularTools.SHOVEL, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.DIAMOND_GRIP_SHOVEL_HANDLE);

        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.WOODEN_TOOL_HANDLE, AllModularTools.PICKAXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.WOODEN_GRIP_PICKAXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.STONE_TOOL_HANDLE, AllModularTools.PICKAXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.STONE_GRIP_PICKAXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.IRON_TOOL_HANDLE, AllModularTools.PICKAXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.IRON_GRIP_PICKAXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.COPPER_TOOL_HANDLE, AllModularTools.PICKAXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.COPPER_GRIP_PICKAXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.GOLDEN_TOOL_HANDLE, AllModularTools.PICKAXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.GOLDEN_GRIP_PICKAXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.NETHERITE_TOOL_HANDLE, AllModularTools.PICKAXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.NETHERITE_GRIP_PICKAXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.ZINC_TOOL_HANDLE, AllModularTools.PICKAXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.ZINC_GRIP_PICKAXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.BRASS_TOOL_HANDLE, AllModularTools.PICKAXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.BRASS_GRIP_PICKAXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.DIAMOND_TOOL_HANDLE, AllModularTools.PICKAXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.DIAMOND_GRIP_PICKAXE_HANDLE);

        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.WOODEN_TOOL_HANDLE, AllModularTools.AXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.WOODEN_GRIP_AXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.STONE_TOOL_HANDLE, AllModularTools.AXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.STONE_GRIP_AXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.IRON_TOOL_HANDLE, AllModularTools.AXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.IRON_GRIP_AXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.COPPER_TOOL_HANDLE, AllModularTools.AXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.COPPER_GRIP_AXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.GOLDEN_TOOL_HANDLE, AllModularTools.AXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.GOLDEN_GRIP_AXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.NETHERITE_TOOL_HANDLE, AllModularTools.AXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.NETHERITE_GRIP_AXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.ZINC_TOOL_HANDLE, AllModularTools.AXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.ZINC_GRIP_AXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.BRASS_TOOL_HANDLE, AllModularTools.AXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.BRASS_GRIP_AXE_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.DIAMOND_TOOL_HANDLE, AllModularTools.AXE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.DIAMOND_GRIP_AXE_HANDLE);

        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.WOODEN_TOOL_HANDLE, AllModularTools.HOE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.WOODEN_GRIP_HOE_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.STONE_TOOL_HANDLE, AllModularTools.HOE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.STONE_GRIP_HOE_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.IRON_TOOL_HANDLE, AllModularTools.HOE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.IRON_GRIP_HOE_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.COPPER_TOOL_HANDLE, AllModularTools.HOE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.COPPER_GRIP_HOE_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.GOLDEN_TOOL_HANDLE, AllModularTools.HOE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.GOLDEN_GRIP_HOE_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.NETHERITE_TOOL_HANDLE, AllModularTools.HOE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.NETHERITE_GRIP_HOE_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.ZINC_TOOL_HANDLE, AllModularTools.HOE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.ZINC_GRIP_HOE_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.BRASS_TOOL_HANDLE, AllModularTools.HOE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.BRASS_GRIP_HOE_HANDLE);
        registerToolModuleModelIdGetterForToolWithModule(AllToolModules.DIAMOND_TOOL_HANDLE, AllModularTools.HOE, AllToolModuleTypes.TOOL_GRIP, AllToolModuleModelIds.DIAMOND_GRIP_HOE_HANDLE);

        registerToolModuleBaseModelIdGetter(AllToolModules.WOODEN_TOOL_GRIP, AllToolModuleModelIds.WOODEN_GRIP);
        registerToolModuleBaseModelIdGetter(AllToolModules.STONE_TOOL_GRIP, AllToolModuleModelIds.STONE_GRIP);
        registerToolModuleBaseModelIdGetter(AllToolModules.IRON_TOOL_GRIP, AllToolModuleModelIds.IRON_GRIP);
        registerToolModuleBaseModelIdGetter(AllToolModules.COPPER_TOOL_GRIP, AllToolModuleModelIds.COPPER_GRIP);
        registerToolModuleBaseModelIdGetter(AllToolModules.GOLDEN_TOOL_GRIP, AllToolModuleModelIds.GOLDEN_GRIP);
        registerToolModuleBaseModelIdGetter(AllToolModules.NETHERITE_TOOL_GRIP, AllToolModuleModelIds.NETHERITE_GRIP);
        registerToolModuleBaseModelIdGetter(AllToolModules.ZINC_TOOL_GRIP, AllToolModuleModelIds.ZINC_GRIP);
        registerToolModuleBaseModelIdGetter(AllToolModules.BRASS_TOOL_GRIP, AllToolModuleModelIds.BRASS_GRIP);
        registerToolModuleBaseModelIdGetter(AllToolModules.DIAMOND_TOOL_GRIP, AllToolModuleModelIds.DIAMOND_GRIP);

        registerToolModuleBaseModelIdGetter(AllToolModules.WOODEN_SWORD_GUARD, AllToolModuleModelIds.WOODEN_GUARD);
        registerToolModuleBaseModelIdGetter(AllToolModules.STONE_SWORD_GUARD, AllToolModuleModelIds.STONE_GUARD);
        registerToolModuleBaseModelIdGetter(AllToolModules.IRON_SWORD_GUARD, AllToolModuleModelIds.IRON_GUARD);
        registerToolModuleBaseModelIdGetter(AllToolModules.COPPER_SWORD_GUARD, AllToolModuleModelIds.COPPER_GUARD);
        registerToolModuleBaseModelIdGetter(AllToolModules.GOLDEN_SWORD_GUARD, AllToolModuleModelIds.GOLDEN_GUARD);
        registerToolModuleBaseModelIdGetter(AllToolModules.NETHERITE_SWORD_GUARD, AllToolModuleModelIds.NETHERITE_GUARD);
        registerToolModuleBaseModelIdGetter(AllToolModules.ZINC_SWORD_GUARD, AllToolModuleModelIds.ZINC_GUARD);
        registerToolModuleBaseModelIdGetter(AllToolModules.BRASS_SWORD_GUARD, AllToolModuleModelIds.BRASS_GUARD);
        registerToolModuleBaseModelIdGetter(AllToolModules.DIAMOND_SWORD_GUARD, AllToolModuleModelIds.DIAMOND_GUARD);

        registerToolModuleBaseModelIdGetter(AllToolModules.WOODEN_SWORD_POMMEL, AllToolModuleModelIds.WOODEN_POMMEL);
        registerToolModuleBaseModelIdGetter(AllToolModules.STONE_SWORD_POMMEL, AllToolModuleModelIds.STONE_POMMEL);
        registerToolModuleBaseModelIdGetter(AllToolModules.IRON_SWORD_POMMEL, AllToolModuleModelIds.IRON_POMMEL);
        registerToolModuleBaseModelIdGetter(AllToolModules.COPPER_SWORD_POMMEL, AllToolModuleModelIds.COPPER_POMMEL);
        registerToolModuleBaseModelIdGetter(AllToolModules.GOLDEN_SWORD_POMMEL, AllToolModuleModelIds.GOLDEN_POMMEL);
        registerToolModuleBaseModelIdGetter(AllToolModules.NETHERITE_SWORD_POMMEL, AllToolModuleModelIds.NETHERITE_POMMEL);
        registerToolModuleBaseModelIdGetter(AllToolModules.ZINC_SWORD_POMMEL, AllToolModuleModelIds.ZINC_POMMEL);
        registerToolModuleBaseModelIdGetter(AllToolModules.BRASS_SWORD_POMMEL, AllToolModuleModelIds.BRASS_POMMEL);
        registerToolModuleBaseModelIdGetter(AllToolModules.DIAMOND_SWORD_POMMEL, AllToolModuleModelIds.DIAMOND_POMMEL);

        AllMoldTopTextureIds.init();

        registerEmptyMoldTopTextureIdGetter(AllMoldTopTextures.SWORD_BLADE, AllToolModuleTypes.SWORD_BLADE, AllMoldTopTextureIds.EMPTY_SWORD_BLADE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SWORD_BLADE, AllToolModuleTypes.SWORD_BLADE, Fluids.LAVA, AllMoldTopTextureIds.LAVA_SWORD_BLADE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SWORD_BLADE, AllToolModuleTypes.SWORD_BLADE, AllFluids.MOLTEN_IRON, AllMoldTopTextureIds.MOLTEN_IRON_SWORD_BLADE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SWORD_BLADE, AllToolModuleTypes.SWORD_BLADE, AllFluids.MOLTEN_COPPER, AllMoldTopTextureIds.MOLTEN_COPPER_SWORD_BLADE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SWORD_BLADE, AllToolModuleTypes.SWORD_BLADE, AllFluids.MOLTEN_GOLD, AllMoldTopTextureIds.MOLTEN_GOLD_SWORD_BLADE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SWORD_BLADE, AllToolModuleTypes.SWORD_BLADE, AllFluids.MOLTEN_NETHERITE, AllMoldTopTextureIds.MOLTEN_NETHERITE_SWORD_BLADE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SWORD_BLADE, AllToolModuleTypes.SWORD_BLADE, AllFluids.MOLTEN_ZINC, AllMoldTopTextureIds.MOLTEN_ZINC_SWORD_BLADE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SWORD_BLADE, AllToolModuleTypes.SWORD_BLADE, AllFluids.MOLTEN_BRASS, AllMoldTopTextureIds.MOLTEN_BRASS_SWORD_BLADE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SWORD_BLADE, AllToolModuleTypes.SWORD_BLADE, AllFluids.MOLTEN_DIAMOND, AllMoldTopTextureIds.MOLTEN_DIAMOND_SWORD_BLADE);

        registerEmptyMoldTopTextureIdGetter(AllMoldTopTextures.SHOVEL_HEAD, AllToolModuleTypes.SHOVEL_HEAD, AllMoldTopTextureIds.EMPTY_SHOVEL_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SHOVEL_HEAD, AllToolModuleTypes.SHOVEL_HEAD, Fluids.LAVA, AllMoldTopTextureIds.LAVA_SHOVEL_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SHOVEL_HEAD, AllToolModuleTypes.SHOVEL_HEAD, AllFluids.MOLTEN_IRON, AllMoldTopTextureIds.MOLTEN_IRON_SHOVEL_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SHOVEL_HEAD, AllToolModuleTypes.SHOVEL_HEAD, AllFluids.MOLTEN_COPPER, AllMoldTopTextureIds.MOLTEN_COPPER_SHOVEL_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SHOVEL_HEAD, AllToolModuleTypes.SHOVEL_HEAD, AllFluids.MOLTEN_GOLD, AllMoldTopTextureIds.MOLTEN_GOLD_SHOVEL_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SHOVEL_HEAD, AllToolModuleTypes.SHOVEL_HEAD, AllFluids.MOLTEN_NETHERITE, AllMoldTopTextureIds.MOLTEN_NETHERITE_SHOVEL_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SHOVEL_HEAD, AllToolModuleTypes.SHOVEL_HEAD, AllFluids.MOLTEN_ZINC, AllMoldTopTextureIds.MOLTEN_ZINC_SHOVEL_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SHOVEL_HEAD, AllToolModuleTypes.SHOVEL_HEAD, AllFluids.MOLTEN_BRASS, AllMoldTopTextureIds.MOLTEN_BRASS_SHOVEL_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SHOVEL_HEAD, AllToolModuleTypes.SHOVEL_HEAD, AllFluids.MOLTEN_DIAMOND, AllMoldTopTextureIds.MOLTEN_DIAMOND_SHOVEL_HEAD);

        registerEmptyMoldTopTextureIdGetter(AllMoldTopTextures.PICKAXE_HEAD, AllToolModuleTypes.PICKAXE_HEAD, AllMoldTopTextureIds.EMPTY_PICKAXE_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.PICKAXE_HEAD, AllToolModuleTypes.PICKAXE_HEAD, Fluids.LAVA, AllMoldTopTextureIds.LAVA_PICKAXE_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.PICKAXE_HEAD, AllToolModuleTypes.PICKAXE_HEAD, AllFluids.MOLTEN_IRON, AllMoldTopTextureIds.MOLTEN_IRON_PICKAXE_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.PICKAXE_HEAD, AllToolModuleTypes.PICKAXE_HEAD, AllFluids.MOLTEN_COPPER, AllMoldTopTextureIds.MOLTEN_COPPER_PICKAXE_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.PICKAXE_HEAD, AllToolModuleTypes.PICKAXE_HEAD, AllFluids.MOLTEN_GOLD, AllMoldTopTextureIds.MOLTEN_GOLD_PICKAXE_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.PICKAXE_HEAD, AllToolModuleTypes.PICKAXE_HEAD, AllFluids.MOLTEN_NETHERITE, AllMoldTopTextureIds.MOLTEN_NETHERITE_PICKAXE_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.PICKAXE_HEAD, AllToolModuleTypes.PICKAXE_HEAD, AllFluids.MOLTEN_ZINC, AllMoldTopTextureIds.MOLTEN_ZINC_PICKAXE_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.PICKAXE_HEAD, AllToolModuleTypes.PICKAXE_HEAD, AllFluids.MOLTEN_BRASS, AllMoldTopTextureIds.MOLTEN_BRASS_PICKAXE_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.PICKAXE_HEAD, AllToolModuleTypes.PICKAXE_HEAD, AllFluids.MOLTEN_DIAMOND, AllMoldTopTextureIds.MOLTEN_DIAMOND_PICKAXE_HEAD);

        registerEmptyMoldTopTextureIdGetter(AllMoldTopTextures.AXE_HEAD, AllToolModuleTypes.AXE_HEAD, AllMoldTopTextureIds.EMPTY_AXE_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.AXE_HEAD, AllToolModuleTypes.AXE_HEAD, Fluids.LAVA, AllMoldTopTextureIds.LAVA_AXE_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.AXE_HEAD, AllToolModuleTypes.AXE_HEAD, AllFluids.MOLTEN_IRON, AllMoldTopTextureIds.MOLTEN_IRON_AXE_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.AXE_HEAD, AllToolModuleTypes.AXE_HEAD, AllFluids.MOLTEN_COPPER, AllMoldTopTextureIds.MOLTEN_COPPER_AXE_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.AXE_HEAD, AllToolModuleTypes.AXE_HEAD, AllFluids.MOLTEN_GOLD, AllMoldTopTextureIds.MOLTEN_GOLD_AXE_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.AXE_HEAD, AllToolModuleTypes.AXE_HEAD, AllFluids.MOLTEN_NETHERITE, AllMoldTopTextureIds.MOLTEN_NETHERITE_AXE_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.AXE_HEAD, AllToolModuleTypes.AXE_HEAD, AllFluids.MOLTEN_ZINC, AllMoldTopTextureIds.MOLTEN_ZINC_AXE_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.AXE_HEAD, AllToolModuleTypes.AXE_HEAD, AllFluids.MOLTEN_BRASS, AllMoldTopTextureIds.MOLTEN_BRASS_AXE_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.AXE_HEAD, AllToolModuleTypes.AXE_HEAD, AllFluids.MOLTEN_DIAMOND, AllMoldTopTextureIds.MOLTEN_DIAMOND_AXE_HEAD);

        registerEmptyMoldTopTextureIdGetter(AllMoldTopTextures.HOE_HEAD, AllToolModuleTypes.HOE_HEAD, AllMoldTopTextureIds.EMPTY_HOE_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.HOE_HEAD, AllToolModuleTypes.HOE_HEAD, Fluids.LAVA, AllMoldTopTextureIds.LAVA_HOE_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.HOE_HEAD, AllToolModuleTypes.HOE_HEAD, AllFluids.MOLTEN_IRON, AllMoldTopTextureIds.MOLTEN_IRON_HOE_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.HOE_HEAD, AllToolModuleTypes.HOE_HEAD, AllFluids.MOLTEN_COPPER, AllMoldTopTextureIds.MOLTEN_COPPER_HOE_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.HOE_HEAD, AllToolModuleTypes.HOE_HEAD, AllFluids.MOLTEN_GOLD, AllMoldTopTextureIds.MOLTEN_GOLD_HOE_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.HOE_HEAD, AllToolModuleTypes.HOE_HEAD, AllFluids.MOLTEN_NETHERITE, AllMoldTopTextureIds.MOLTEN_NETHERITE_HOE_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.HOE_HEAD, AllToolModuleTypes.HOE_HEAD, AllFluids.MOLTEN_ZINC, AllMoldTopTextureIds.MOLTEN_ZINC_HOE_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.HOE_HEAD, AllToolModuleTypes.HOE_HEAD, AllFluids.MOLTEN_BRASS, AllMoldTopTextureIds.MOLTEN_BRASS_HOE_HEAD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.HOE_HEAD, AllToolModuleTypes.HOE_HEAD, AllFluids.MOLTEN_DIAMOND, AllMoldTopTextureIds.MOLTEN_DIAMOND_HOE_HEAD);

        registerEmptyMoldTopTextureIdGetter(AllMoldTopTextures.SWORD_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllMoldTopTextureIds.EMPTY_SWORD_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SWORD_HANDLE, AllToolModuleTypes.TOOL_HANDLE, Fluids.LAVA, AllMoldTopTextureIds.LAVA_SWORD_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SWORD_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_IRON, AllMoldTopTextureIds.MOLTEN_IRON_SWORD_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SWORD_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_COPPER, AllMoldTopTextureIds.MOLTEN_COPPER_SWORD_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SWORD_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_GOLD, AllMoldTopTextureIds.MOLTEN_GOLD_SWORD_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SWORD_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_NETHERITE, AllMoldTopTextureIds.MOLTEN_NETHERITE_SWORD_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SWORD_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_ZINC, AllMoldTopTextureIds.MOLTEN_ZINC_SWORD_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SWORD_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_BRASS, AllMoldTopTextureIds.MOLTEN_BRASS_SWORD_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SWORD_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_DIAMOND, AllMoldTopTextureIds.MOLTEN_DIAMOND_SWORD_HANDLE);

        registerEmptyMoldTopTextureIdGetter(AllMoldTopTextures.POMMEL_SWORD_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllMoldTopTextureIds.EMPTY_POMMEL_SWORD_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.POMMEL_SWORD_HANDLE, AllToolModuleTypes.TOOL_HANDLE, Fluids.LAVA, AllMoldTopTextureIds.LAVA_POMMEL_SWORD_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.POMMEL_SWORD_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_IRON, AllMoldTopTextureIds.MOLTEN_IRON_POMMEL_SWORD_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.POMMEL_SWORD_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_COPPER, AllMoldTopTextureIds.MOLTEN_COPPER_POMMEL_SWORD_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.POMMEL_SWORD_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_GOLD, AllMoldTopTextureIds.MOLTEN_GOLD_POMMEL_SWORD_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.POMMEL_SWORD_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_NETHERITE, AllMoldTopTextureIds.MOLTEN_NETHERITE_POMMEL_SWORD_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.POMMEL_SWORD_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_ZINC, AllMoldTopTextureIds.MOLTEN_ZINC_POMMEL_SWORD_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.POMMEL_SWORD_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_BRASS, AllMoldTopTextureIds.MOLTEN_BRASS_POMMEL_SWORD_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.POMMEL_SWORD_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_DIAMOND, AllMoldTopTextureIds.MOLTEN_DIAMOND_POMMEL_SWORD_HANDLE);

        registerEmptyMoldTopTextureIdGetter(AllMoldTopTextures.SHOVEL_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllMoldTopTextureIds.EMPTY_SHOVEL_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SHOVEL_HANDLE, AllToolModuleTypes.TOOL_HANDLE, Fluids.LAVA, AllMoldTopTextureIds.LAVA_SHOVEL_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SHOVEL_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_IRON, AllMoldTopTextureIds.MOLTEN_IRON_SHOVEL_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SHOVEL_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_COPPER, AllMoldTopTextureIds.MOLTEN_COPPER_SHOVEL_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SHOVEL_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_GOLD, AllMoldTopTextureIds.MOLTEN_GOLD_SHOVEL_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SHOVEL_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_NETHERITE, AllMoldTopTextureIds.MOLTEN_NETHERITE_SHOVEL_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SHOVEL_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_ZINC, AllMoldTopTextureIds.MOLTEN_ZINC_SHOVEL_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SHOVEL_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_BRASS, AllMoldTopTextureIds.MOLTEN_BRASS_SHOVEL_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.SHOVEL_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_DIAMOND, AllMoldTopTextureIds.MOLTEN_DIAMOND_SHOVEL_HANDLE);

        registerEmptyMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_SHOVEL_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllMoldTopTextureIds.EMPTY_GRIP_SHOVEL_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_SHOVEL_HANDLE, AllToolModuleTypes.TOOL_HANDLE, Fluids.LAVA, AllMoldTopTextureIds.LAVA_GRIP_SHOVEL_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_SHOVEL_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_IRON, AllMoldTopTextureIds.MOLTEN_IRON_GRIP_SHOVEL_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_SHOVEL_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_COPPER, AllMoldTopTextureIds.MOLTEN_COPPER_GRIP_SHOVEL_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_SHOVEL_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_GOLD, AllMoldTopTextureIds.MOLTEN_GOLD_GRIP_SHOVEL_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_SHOVEL_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_NETHERITE, AllMoldTopTextureIds.MOLTEN_NETHERITE_GRIP_SHOVEL_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_SHOVEL_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_ZINC, AllMoldTopTextureIds.MOLTEN_ZINC_GRIP_SHOVEL_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_SHOVEL_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_BRASS, AllMoldTopTextureIds.MOLTEN_BRASS_GRIP_SHOVEL_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_SHOVEL_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_DIAMOND, AllMoldTopTextureIds.MOLTEN_DIAMOND_GRIP_SHOVEL_HANDLE);

        registerEmptyMoldTopTextureIdGetter(AllMoldTopTextures.PICKAXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllMoldTopTextureIds.EMPTY_PICKAXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.PICKAXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, Fluids.LAVA, AllMoldTopTextureIds.LAVA_PICKAXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.PICKAXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_IRON, AllMoldTopTextureIds.MOLTEN_IRON_PICKAXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.PICKAXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_COPPER, AllMoldTopTextureIds.MOLTEN_COPPER_PICKAXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.PICKAXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_GOLD, AllMoldTopTextureIds.MOLTEN_GOLD_PICKAXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.PICKAXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_NETHERITE, AllMoldTopTextureIds.MOLTEN_NETHERITE_PICKAXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.PICKAXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_ZINC, AllMoldTopTextureIds.MOLTEN_ZINC_PICKAXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.PICKAXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_BRASS, AllMoldTopTextureIds.MOLTEN_BRASS_PICKAXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.PICKAXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_DIAMOND, AllMoldTopTextureIds.MOLTEN_DIAMOND_PICKAXE_HANDLE);

        registerEmptyMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_PICKAXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllMoldTopTextureIds.EMPTY_GRIP_PICKAXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_PICKAXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, Fluids.LAVA, AllMoldTopTextureIds.LAVA_GRIP_PICKAXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_PICKAXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_IRON, AllMoldTopTextureIds.MOLTEN_IRON_GRIP_PICKAXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_PICKAXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_COPPER, AllMoldTopTextureIds.MOLTEN_COPPER_GRIP_PICKAXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_PICKAXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_GOLD, AllMoldTopTextureIds.MOLTEN_GOLD_GRIP_PICKAXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_PICKAXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_NETHERITE, AllMoldTopTextureIds.MOLTEN_NETHERITE_GRIP_PICKAXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_PICKAXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_ZINC, AllMoldTopTextureIds.MOLTEN_ZINC_GRIP_PICKAXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_PICKAXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_BRASS, AllMoldTopTextureIds.MOLTEN_BRASS_GRIP_PICKAXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_PICKAXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_DIAMOND, AllMoldTopTextureIds.MOLTEN_DIAMOND_GRIP_PICKAXE_HANDLE);

        registerEmptyMoldTopTextureIdGetter(AllMoldTopTextures.AXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllMoldTopTextureIds.EMPTY_AXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.AXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, Fluids.LAVA, AllMoldTopTextureIds.LAVA_AXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.AXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_IRON, AllMoldTopTextureIds.MOLTEN_IRON_AXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.AXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_COPPER, AllMoldTopTextureIds.MOLTEN_COPPER_AXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.AXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_GOLD, AllMoldTopTextureIds.MOLTEN_GOLD_AXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.AXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_NETHERITE, AllMoldTopTextureIds.MOLTEN_NETHERITE_AXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.AXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_ZINC, AllMoldTopTextureIds.MOLTEN_ZINC_AXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.AXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_BRASS, AllMoldTopTextureIds.MOLTEN_BRASS_AXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.AXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_DIAMOND, AllMoldTopTextureIds.MOLTEN_DIAMOND_AXE_HANDLE);

        registerEmptyMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_AXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllMoldTopTextureIds.EMPTY_GRIP_AXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_AXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, Fluids.LAVA, AllMoldTopTextureIds.LAVA_GRIP_AXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_AXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_IRON, AllMoldTopTextureIds.MOLTEN_IRON_GRIP_AXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_AXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_COPPER, AllMoldTopTextureIds.MOLTEN_COPPER_GRIP_AXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_AXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_GOLD, AllMoldTopTextureIds.MOLTEN_GOLD_GRIP_AXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_AXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_NETHERITE, AllMoldTopTextureIds.MOLTEN_NETHERITE_GRIP_AXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_AXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_ZINC, AllMoldTopTextureIds.MOLTEN_ZINC_GRIP_AXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_AXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_BRASS, AllMoldTopTextureIds.MOLTEN_BRASS_GRIP_AXE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_AXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_DIAMOND, AllMoldTopTextureIds.MOLTEN_DIAMOND_GRIP_AXE_HANDLE);

        registerEmptyMoldTopTextureIdGetter(AllMoldTopTextures.HOE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllMoldTopTextureIds.EMPTY_HOE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.HOE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, Fluids.LAVA, AllMoldTopTextureIds.LAVA_HOE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.HOE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_IRON, AllMoldTopTextureIds.MOLTEN_IRON_HOE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.HOE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_COPPER, AllMoldTopTextureIds.MOLTEN_COPPER_HOE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.HOE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_GOLD, AllMoldTopTextureIds.MOLTEN_GOLD_HOE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.HOE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_NETHERITE, AllMoldTopTextureIds.MOLTEN_NETHERITE_HOE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.HOE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_ZINC, AllMoldTopTextureIds.MOLTEN_ZINC_HOE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.HOE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_BRASS, AllMoldTopTextureIds.MOLTEN_BRASS_HOE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.HOE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_DIAMOND, AllMoldTopTextureIds.MOLTEN_DIAMOND_HOE_HANDLE);

        registerEmptyMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_HOE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllMoldTopTextureIds.EMPTY_GRIP_HOE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_HOE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, Fluids.LAVA, AllMoldTopTextureIds.LAVA_GRIP_HOE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_HOE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_IRON, AllMoldTopTextureIds.MOLTEN_IRON_GRIP_HOE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_HOE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_COPPER, AllMoldTopTextureIds.MOLTEN_COPPER_GRIP_HOE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_HOE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_GOLD, AllMoldTopTextureIds.MOLTEN_GOLD_GRIP_HOE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_HOE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_NETHERITE, AllMoldTopTextureIds.MOLTEN_NETHERITE_GRIP_HOE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_HOE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_ZINC, AllMoldTopTextureIds.MOLTEN_ZINC_GRIP_HOE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_HOE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_BRASS, AllMoldTopTextureIds.MOLTEN_BRASS_GRIP_HOE_HANDLE);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP_HOE_HANDLE, AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_DIAMOND, AllMoldTopTextureIds.MOLTEN_DIAMOND_GRIP_HOE_HANDLE);

        registerEmptyMoldTopTextureIdGetter(AllMoldTopTextures.GRIP, AllToolModuleTypes.TOOL_GRIP, AllMoldTopTextureIds.EMPTY_GRIP);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP, AllToolModuleTypes.TOOL_GRIP, Fluids.LAVA, AllMoldTopTextureIds.LAVA_GRIP);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP, AllToolModuleTypes.TOOL_GRIP, AllFluids.MOLTEN_IRON, AllMoldTopTextureIds.MOLTEN_IRON_GRIP);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP, AllToolModuleTypes.TOOL_GRIP, AllFluids.MOLTEN_COPPER, AllMoldTopTextureIds.MOLTEN_COPPER_GRIP);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP, AllToolModuleTypes.TOOL_GRIP, AllFluids.MOLTEN_GOLD, AllMoldTopTextureIds.MOLTEN_GOLD_GRIP);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP, AllToolModuleTypes.TOOL_GRIP, AllFluids.MOLTEN_NETHERITE, AllMoldTopTextureIds.MOLTEN_NETHERITE_GRIP);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP, AllToolModuleTypes.TOOL_GRIP, AllFluids.MOLTEN_ZINC, AllMoldTopTextureIds.MOLTEN_ZINC_GRIP);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP, AllToolModuleTypes.TOOL_GRIP, AllFluids.MOLTEN_BRASS, AllMoldTopTextureIds.MOLTEN_BRASS_GRIP);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GRIP, AllToolModuleTypes.TOOL_GRIP, AllFluids.MOLTEN_DIAMOND, AllMoldTopTextureIds.MOLTEN_DIAMOND_GRIP);

        registerEmptyMoldTopTextureIdGetter(AllMoldTopTextures.GUARD, AllToolModuleTypes.SWORD_GUARD, AllMoldTopTextureIds.EMPTY_GUARD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GUARD, AllToolModuleTypes.SWORD_GUARD, Fluids.LAVA, AllMoldTopTextureIds.LAVA_GUARD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GUARD, AllToolModuleTypes.SWORD_GUARD, AllFluids.MOLTEN_IRON, AllMoldTopTextureIds.MOLTEN_IRON_GUARD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GUARD, AllToolModuleTypes.SWORD_GUARD, AllFluids.MOLTEN_COPPER, AllMoldTopTextureIds.MOLTEN_COPPER_GUARD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GUARD, AllToolModuleTypes.SWORD_GUARD, AllFluids.MOLTEN_GOLD, AllMoldTopTextureIds.MOLTEN_GOLD_GUARD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GUARD, AllToolModuleTypes.SWORD_GUARD, AllFluids.MOLTEN_NETHERITE, AllMoldTopTextureIds.MOLTEN_NETHERITE_GUARD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GUARD, AllToolModuleTypes.SWORD_GUARD, AllFluids.MOLTEN_ZINC, AllMoldTopTextureIds.MOLTEN_ZINC_GUARD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GUARD, AllToolModuleTypes.SWORD_GUARD, AllFluids.MOLTEN_BRASS, AllMoldTopTextureIds.MOLTEN_BRASS_GUARD);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.GUARD, AllToolModuleTypes.SWORD_GUARD, AllFluids.MOLTEN_DIAMOND, AllMoldTopTextureIds.MOLTEN_DIAMOND_GUARD);

        registerEmptyMoldTopTextureIdGetter(AllMoldTopTextures.POMMEL, AllToolModuleTypes.SWORD_POMMEL, AllMoldTopTextureIds.EMPTY_POMMEL);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.POMMEL, AllToolModuleTypes.SWORD_POMMEL, Fluids.LAVA, AllMoldTopTextureIds.LAVA_POMMEL);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.POMMEL, AllToolModuleTypes.SWORD_POMMEL, AllFluids.MOLTEN_IRON, AllMoldTopTextureIds.MOLTEN_IRON_POMMEL);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.POMMEL, AllToolModuleTypes.SWORD_POMMEL, AllFluids.MOLTEN_COPPER, AllMoldTopTextureIds.MOLTEN_COPPER_POMMEL);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.POMMEL, AllToolModuleTypes.SWORD_POMMEL, AllFluids.MOLTEN_GOLD, AllMoldTopTextureIds.MOLTEN_GOLD_POMMEL);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.POMMEL, AllToolModuleTypes.SWORD_POMMEL, AllFluids.MOLTEN_NETHERITE, AllMoldTopTextureIds.MOLTEN_NETHERITE_POMMEL);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.POMMEL, AllToolModuleTypes.SWORD_POMMEL, AllFluids.MOLTEN_ZINC, AllMoldTopTextureIds.MOLTEN_ZINC_POMMEL);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.POMMEL, AllToolModuleTypes.SWORD_POMMEL, AllFluids.MOLTEN_BRASS, AllMoldTopTextureIds.MOLTEN_BRASS_POMMEL);
        registerFullMoldTopTextureIdGetter(AllMoldTopTextures.POMMEL, AllToolModuleTypes.SWORD_POMMEL, AllFluids.MOLTEN_DIAMOND, AllMoldTopTextureIds.MOLTEN_DIAMOND_POMMEL);
    }

    private static void registerToolModuleModelIds(ToolModule toolModule, ResourceLocation... modelIds) {
        toolModule.registerModelIds(() -> List.of(modelIds));
    }

    private static void registerToolModuleBaseModelIdGetter(ToolModule toolModule, ResourceLocation baseModelId) {
        toolModule.registerModelIdGetter((original, modularTool, nbt) -> original == null ? baseModelId : original);
    }

    private static void registerToolModuleModelIdGetterForTool(ToolModule toolModule, ModularToolItem tool, ResourceLocation toolModelId) {
        toolModule.registerModelIdGetter((original, modularTool, nbt) -> original == null && modularTool == tool ? toolModelId : original);
    }

    private static void registerToolModuleModelIdGetterForToolWithModule(ToolModule toolModule, ModularToolItem tool, ToolModuleType toolModuleType, ResourceLocation modelId) {
        toolModule.registerModelIdGetter((original, modularTool, nbt) -> original == null && modularTool == tool && nbt.contains(toolModuleType.getTag(), Tag.TAG_STRING) ? modelId : original);
    }

    private static void registerToolModuleModelIdGetterForToolWithoutModule(ToolModule toolModule, ModularToolItem tool, ToolModuleType toolModuleType, ResourceLocation modelId) {
        toolModule.registerModelIdGetter((original, modularTool, nbt) -> original == null && modularTool == tool && !nbt.contains(toolModuleType.getTag(), Tag.TAG_STRING) ? modelId : original);
    }

    private static void registerEmptyMoldTopTextureIdGetter(ToolModuleType.MoldTopTexture moldTopTexture, ToolModuleType toolModuleType, ResourceLocation textureId) {
        moldTopTexture.registerTextureIdGetter((original, sandMoldBlock, nbt) -> original == null && nbt.getString(toolModuleType.getTag()).isEmpty() ? textureId : original);
    }

    private static void registerFullMoldTopTextureIdGetter(ToolModuleType.MoldTopTexture moldTopTexture, ToolModuleType toolModuleType, FlowingFluid fluid, ResourceLocation textureId) {
        moldTopTexture.registerTextureIdGetter((original, sandMoldBlock, nbt) -> original == null && nbt.getString(toolModuleType.getTag()).equals(BuiltInRegistries.FLUID.getKey(fluid).toString()) ? textureId : original);
    }
}
