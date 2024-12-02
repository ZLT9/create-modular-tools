package net.zlt.create_modular_tools.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.event.client.player.ClientPickBlockApplyCallback;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluids;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.block.AllBlocks;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.AllMoldTopTextures;
import net.zlt.create_modular_tools.block.mold.BaseMoldBlock;
import net.zlt.create_modular_tools.block.mold.MoldBlock;
import net.zlt.create_modular_tools.client.model.CreateModularToolsModelLoadingPlugin;
import net.zlt.create_modular_tools.client.renderer.blockentity.black_concrete_powder.*;
import net.zlt.create_modular_tools.client.renderer.blockentity.blue_concrete_powder.*;
import net.zlt.create_modular_tools.client.renderer.blockentity.brown_concrete_powder.*;
import net.zlt.create_modular_tools.client.renderer.blockentity.cyan_concrete_powder.*;
import net.zlt.create_modular_tools.client.renderer.blockentity.gray_concrete_powder.*;
import net.zlt.create_modular_tools.client.renderer.blockentity.green_concrete_powder.*;
import net.zlt.create_modular_tools.client.renderer.blockentity.light_blue_concrete_powder.*;
import net.zlt.create_modular_tools.client.renderer.blockentity.light_gray_concrete_powder.*;
import net.zlt.create_modular_tools.client.renderer.blockentity.lime_concrete_powder.*;
import net.zlt.create_modular_tools.client.renderer.blockentity.magenta_concrete_powder.*;
import net.zlt.create_modular_tools.client.renderer.blockentity.orange_concrete_powder.*;
import net.zlt.create_modular_tools.client.renderer.blockentity.pink_concrete_powder.*;
import net.zlt.create_modular_tools.client.renderer.blockentity.purple_concrete_powder.*;
import net.zlt.create_modular_tools.client.renderer.blockentity.red_concrete_powder.*;
import net.zlt.create_modular_tools.client.renderer.blockentity.red_sand.*;
import net.zlt.create_modular_tools.client.renderer.blockentity.sand.*;
import net.zlt.create_modular_tools.client.renderer.blockentity.white_concrete_powder.*;
import net.zlt.create_modular_tools.client.renderer.blockentity.yellow_concrete_powder.*;
import net.zlt.create_modular_tools.client.renderer.entity.ThrownBoomerangRenderer;
import net.zlt.create_modular_tools.client.renderer.item.ModularToolRenderer;
import net.zlt.create_modular_tools.entity.AllEntityTypes;
import net.zlt.create_modular_tools.fluid.AllFluids;
import net.zlt.create_modular_tools.item.AllItems;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.item.tool.module.ToolModuleItem;
import net.zlt.create_modular_tools.tool.AllModularTools;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.AllToolModuleTypes;
import net.zlt.create_modular_tools.tool.module.AllToolModules;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CreateModularToolsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ResourceManagerHelper.registerBuiltinResourcePack(CreateModularTools.asResource("hindu_arabic_enchantments"), FabricLoader.getInstance().getModContainer(CreateModularTools.ID).orElseThrow(() -> new IllegalStateException("Create: Modular Tools' ModContainer couldn't be found!")), Component.translatable("create_modular_tools.resource_pack.hindu_arabic_enchantments"), ResourcePackActivationType.NORMAL);

        BuiltinItemRendererRegistry.INSTANCE.register(AllItems.MODULAR_SWORD, new ModularToolRenderer());
        BuiltinItemRendererRegistry.INSTANCE.register(AllItems.MODULAR_SHOVEL, new ModularToolRenderer());
        BuiltinItemRendererRegistry.INSTANCE.register(AllItems.MODULAR_PICKAXE, new ModularToolRenderer());
        BuiltinItemRendererRegistry.INSTANCE.register(AllItems.MODULAR_AXE, new ModularToolRenderer());
        BuiltinItemRendererRegistry.INSTANCE.register(AllItems.MODULAR_HOE, new ModularToolRenderer());

        EntityRendererRegistry.register(AllEntityTypes.WOODEN_PICKAXE_HEAD, context -> new ThrownBoomerangRenderer(CreateModularTools.asResource("item/wooden_pickaxe_head"), CreateModularTools.asResource("textures/item/wooden_pickaxe_head.png"), AllItems.WOODEN_PICKAXE_HEAD, context));
        EntityRendererRegistry.register(AllEntityTypes.OAK_PICKAXE_HEAD, context -> new ThrownBoomerangRenderer(CreateModularTools.asResource("item/oak_pickaxe_head"), CreateModularTools.asResource("textures/item/oak_pickaxe_head.png"), AllItems.OAK_PICKAXE_HEAD, context));
        EntityRendererRegistry.register(AllEntityTypes.SPRUCE_PICKAXE_HEAD, context -> new ThrownBoomerangRenderer(CreateModularTools.asResource("item/spruce_pickaxe_head"), CreateModularTools.asResource("textures/item/spruce_pickaxe_head.png"), AllItems.SPRUCE_PICKAXE_HEAD, context));
        EntityRendererRegistry.register(AllEntityTypes.BIRCH_PICKAXE_HEAD, context -> new ThrownBoomerangRenderer(CreateModularTools.asResource("item/birch_pickaxe_head"), CreateModularTools.asResource("textures/item/birch_pickaxe_head.png"), AllItems.BIRCH_PICKAXE_HEAD, context));
        EntityRendererRegistry.register(AllEntityTypes.JUNGLE_PICKAXE_HEAD, context -> new ThrownBoomerangRenderer(CreateModularTools.asResource("item/jungle_pickaxe_head"), CreateModularTools.asResource("textures/item/jungle_pickaxe_head.png"), AllItems.JUNGLE_PICKAXE_HEAD, context));
        EntityRendererRegistry.register(AllEntityTypes.ACACIA_PICKAXE_HEAD, context -> new ThrownBoomerangRenderer(CreateModularTools.asResource("item/acacia_pickaxe_head"), CreateModularTools.asResource("textures/item/acacia_pickaxe_head.png"), AllItems.ACACIA_PICKAXE_HEAD, context));
        EntityRendererRegistry.register(AllEntityTypes.DARK_OAK_PICKAXE_HEAD, context -> new ThrownBoomerangRenderer(CreateModularTools.asResource("item/dark_oak_pickaxe_head"), CreateModularTools.asResource("textures/item/dark_oak_pickaxe_head.png"), AllItems.DARK_OAK_PICKAXE_HEAD, context));
        EntityRendererRegistry.register(AllEntityTypes.MANGROVE_PICKAXE_HEAD, context -> new ThrownBoomerangRenderer(CreateModularTools.asResource("item/mangrove_pickaxe_head"), CreateModularTools.asResource("textures/item/mangrove_pickaxe_head.png"), AllItems.MANGROVE_PICKAXE_HEAD, context));
        EntityRendererRegistry.register(AllEntityTypes.CHERRY_PICKAXE_HEAD, context -> new ThrownBoomerangRenderer(CreateModularTools.asResource("item/cherry_pickaxe_head"), CreateModularTools.asResource("textures/item/cherry_pickaxe_head.png"), AllItems.CHERRY_PICKAXE_HEAD, context));
        EntityRendererRegistry.register(AllEntityTypes.BAMBOO_PICKAXE_HEAD, context -> new ThrownBoomerangRenderer(CreateModularTools.asResource("item/bamboo_pickaxe_head"), CreateModularTools.asResource("textures/item/bamboo_pickaxe_head.png"), AllItems.BAMBOO_PICKAXE_HEAD, context));
        EntityRendererRegistry.register(AllEntityTypes.CRIMSON_PICKAXE_HEAD, context -> new ThrownBoomerangRenderer(CreateModularTools.asResource("item/crimson_pickaxe_head"), CreateModularTools.asResource("textures/item/crimson_pickaxe_head.png"), AllItems.CRIMSON_PICKAXE_HEAD, context));
        EntityRendererRegistry.register(AllEntityTypes.WARPED_PICKAXE_HEAD, context -> new ThrownBoomerangRenderer(CreateModularTools.asResource("item/warped_pickaxe_head"), CreateModularTools.asResource("textures/item/warped_pickaxe_head.png"), AllItems.WARPED_PICKAXE_HEAD, context));
        EntityRendererRegistry.register(AllEntityTypes.STONE_PICKAXE_HEAD, context -> new ThrownBoomerangRenderer(CreateModularTools.asResource("item/stone_pickaxe_head"), CreateModularTools.asResource("textures/item/stone_pickaxe_head.png"), AllItems.STONE_PICKAXE_HEAD, context));
        EntityRendererRegistry.register(AllEntityTypes.IRON_PICKAXE_HEAD, context -> new ThrownBoomerangRenderer(CreateModularTools.asResource("item/iron_pickaxe_head"), CreateModularTools.asResource("textures/item/iron_pickaxe_head.png"), AllItems.IRON_PICKAXE_HEAD, context));
        EntityRendererRegistry.register(AllEntityTypes.COPPER_PICKAXE_HEAD, context -> new ThrownBoomerangRenderer(CreateModularTools.asResource("item/copper_pickaxe_head"), CreateModularTools.asResource("textures/item/copper_pickaxe_head.png"), AllItems.COPPER_PICKAXE_HEAD, context));
        EntityRendererRegistry.register(AllEntityTypes.GOLDEN_PICKAXE_HEAD, context -> new ThrownBoomerangRenderer(CreateModularTools.asResource("item/golden_pickaxe_head"), CreateModularTools.asResource("textures/item/golden_pickaxe_head.png"), AllItems.GOLDEN_PICKAXE_HEAD, context));
        EntityRendererRegistry.register(AllEntityTypes.NETHERITE_PICKAXE_HEAD, context -> new ThrownBoomerangRenderer(CreateModularTools.asResource("item/netherite_pickaxe_head"), CreateModularTools.asResource("textures/item/netherite_pickaxe_head.png"), AllItems.NETHERITE_PICKAXE_HEAD, context));
        EntityRendererRegistry.register(AllEntityTypes.ZINC_PICKAXE_HEAD, context -> new ThrownBoomerangRenderer(CreateModularTools.asResource("item/zinc_pickaxe_head"), CreateModularTools.asResource("textures/item/zinc_pickaxe_head.png"), AllItems.ZINC_PICKAXE_HEAD, context));
        EntityRendererRegistry.register(AllEntityTypes.BRASS_PICKAXE_HEAD, context -> new ThrownBoomerangRenderer(CreateModularTools.asResource("item/brass_pickaxe_head"), CreateModularTools.asResource("textures/item/brass_pickaxe_head.png"), AllItems.BRASS_PICKAXE_HEAD, context));
        EntityRendererRegistry.register(AllEntityTypes.DIAMOND_PICKAXE_HEAD, context -> new ThrownBoomerangRenderer(CreateModularTools.asResource("item/diamond_pickaxe_head"), CreateModularTools.asResource("textures/item/diamond_pickaxe_head.png"), AllItems.DIAMOND_PICKAXE_HEAD, context));

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_SAND_MOLD, SwordSandMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_SAND_MOLD, ShovelSandMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_SAND_MOLD, PickaxeSandMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_SAND_MOLD, AxeSandMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_SAND_MOLD, HoeSandMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_RED_SAND_MOLD, SwordRedSandMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_RED_SAND_MOLD, ShovelRedSandMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_RED_SAND_MOLD, PickaxeRedSandMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_RED_SAND_MOLD, AxeRedSandMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_RED_SAND_MOLD, HoeRedSandMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_WHITE_CONCRETE_POWDER_MOLD, SwordWhiteConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_WHITE_CONCRETE_POWDER_MOLD, ShovelWhiteConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_WHITE_CONCRETE_POWDER_MOLD, PickaxeWhiteConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_WHITE_CONCRETE_POWDER_MOLD, AxeWhiteConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_WHITE_CONCRETE_POWDER_MOLD, HoeWhiteConcretePowderMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIGHT_GRAY_CONCRETE_POWDER_MOLD, SwordLightGrayConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_MOLD, ShovelLightGrayConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_MOLD, PickaxeLightGrayConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIGHT_GRAY_CONCRETE_POWDER_MOLD, AxeLightGrayConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIGHT_GRAY_CONCRETE_POWDER_MOLD, HoeLightGrayConcretePowderMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_GRAY_CONCRETE_POWDER_MOLD, SwordGrayConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_GRAY_CONCRETE_POWDER_MOLD, ShovelGrayConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_GRAY_CONCRETE_POWDER_MOLD, PickaxeGrayConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_GRAY_CONCRETE_POWDER_MOLD, AxeGrayConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_GRAY_CONCRETE_POWDER_MOLD, HoeGrayConcretePowderMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BLACK_CONCRETE_POWDER_MOLD, SwordBlackConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BLACK_CONCRETE_POWDER_MOLD, ShovelBlackConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BLACK_CONCRETE_POWDER_MOLD, PickaxeBlackConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BLACK_CONCRETE_POWDER_MOLD, AxeBlackConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BLACK_CONCRETE_POWDER_MOLD, HoeBlackConcretePowderMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BROWN_CONCRETE_POWDER_MOLD, SwordBrownConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BROWN_CONCRETE_POWDER_MOLD, ShovelBrownConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BROWN_CONCRETE_POWDER_MOLD, PickaxeBrownConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BROWN_CONCRETE_POWDER_MOLD, AxeBrownConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BROWN_CONCRETE_POWDER_MOLD, HoeBrownConcretePowderMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_RED_CONCRETE_POWDER_MOLD, SwordRedConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_RED_CONCRETE_POWDER_MOLD, ShovelRedConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_RED_CONCRETE_POWDER_MOLD, PickaxeRedConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_RED_CONCRETE_POWDER_MOLD, AxeRedConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_RED_CONCRETE_POWDER_MOLD, HoeRedConcretePowderMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_ORANGE_CONCRETE_POWDER_MOLD, SwordOrangeConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_ORANGE_CONCRETE_POWDER_MOLD, ShovelOrangeConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_ORANGE_CONCRETE_POWDER_MOLD, PickaxeOrangeConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_ORANGE_CONCRETE_POWDER_MOLD, AxeOrangeConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_ORANGE_CONCRETE_POWDER_MOLD, HoeOrangeConcretePowderMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_YELLOW_CONCRETE_POWDER_MOLD, SwordYellowConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_YELLOW_CONCRETE_POWDER_MOLD, ShovelYellowConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_YELLOW_CONCRETE_POWDER_MOLD, PickaxeYellowConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_YELLOW_CONCRETE_POWDER_MOLD, AxeYellowConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_YELLOW_CONCRETE_POWDER_MOLD, HoeYellowConcretePowderMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIME_CONCRETE_POWDER_MOLD, SwordLimeConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIME_CONCRETE_POWDER_MOLD, ShovelLimeConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIME_CONCRETE_POWDER_MOLD, PickaxeLimeConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIME_CONCRETE_POWDER_MOLD, AxeLimeConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIME_CONCRETE_POWDER_MOLD, HoeLimeConcretePowderMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_GREEN_CONCRETE_POWDER_MOLD, SwordGreenConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_GREEN_CONCRETE_POWDER_MOLD, ShovelGreenConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_GREEN_CONCRETE_POWDER_MOLD, PickaxeGreenConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_GREEN_CONCRETE_POWDER_MOLD, AxeGreenConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_GREEN_CONCRETE_POWDER_MOLD, HoeGreenConcretePowderMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_CYAN_CONCRETE_POWDER_MOLD, SwordCyanConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_CYAN_CONCRETE_POWDER_MOLD, ShovelCyanConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_CYAN_CONCRETE_POWDER_MOLD, PickaxeCyanConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_CYAN_CONCRETE_POWDER_MOLD, AxeCyanConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_CYAN_CONCRETE_POWDER_MOLD, HoeCyanConcretePowderMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIGHT_BLUE_CONCRETE_POWDER_MOLD, SwordLightBlueConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_MOLD, ShovelLightBlueConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_MOLD, PickaxeLightBlueConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIGHT_BLUE_CONCRETE_POWDER_MOLD, AxeLightBlueConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIGHT_BLUE_CONCRETE_POWDER_MOLD, HoeLightBlueConcretePowderMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BLUE_CONCRETE_POWDER_MOLD, SwordBlueConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BLUE_CONCRETE_POWDER_MOLD, ShovelBlueConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BLUE_CONCRETE_POWDER_MOLD, PickaxeBlueConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BLUE_CONCRETE_POWDER_MOLD, AxeBlueConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BLUE_CONCRETE_POWDER_MOLD, HoeBlueConcretePowderMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_PURPLE_CONCRETE_POWDER_MOLD, SwordPurpleConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_PURPLE_CONCRETE_POWDER_MOLD, ShovelPurpleConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_PURPLE_CONCRETE_POWDER_MOLD, PickaxePurpleConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_PURPLE_CONCRETE_POWDER_MOLD, AxePurpleConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_PURPLE_CONCRETE_POWDER_MOLD, HoePurpleConcretePowderMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_MAGENTA_CONCRETE_POWDER_MOLD, SwordMagentaConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_MAGENTA_CONCRETE_POWDER_MOLD, ShovelMagentaConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_MAGENTA_CONCRETE_POWDER_MOLD, PickaxeMagentaConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_MAGENTA_CONCRETE_POWDER_MOLD, AxeMagentaConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_MAGENTA_CONCRETE_POWDER_MOLD, HoeMagentaConcretePowderMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_PINK_CONCRETE_POWDER_MOLD, SwordPinkConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_PINK_CONCRETE_POWDER_MOLD, ShovelPinkConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_PINK_CONCRETE_POWDER_MOLD, PickaxePinkConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_PINK_CONCRETE_POWDER_MOLD, AxePinkConcretePowderMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_PINK_CONCRETE_POWDER_MOLD, HoePinkConcretePowderMoldRenderer::new);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutoutMipped(),
            AllBlocks.OAK_MOLD,
            AllBlocks.SPRUCE_MOLD,
            AllBlocks.BIRCH_MOLD,
            AllBlocks.JUNGLE_MOLD,
            AllBlocks.ACACIA_MOLD,
            AllBlocks.DARK_OAK_MOLD,
            AllBlocks.MANGROVE_MOLD,
            AllBlocks.CHERRY_MOLD,
            AllBlocks.BAMBOO_MOLD,
            AllBlocks.CRIMSON_MOLD,
            AllBlocks.WARPED_MOLD,
            AllMoldBlocks.SAND_MOLD,
            AllMoldBlocks.RED_SAND_MOLD,
            AllMoldBlocks.WHITE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.LIGHT_GRAY_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.GRAY_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.BLACK_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.BROWN_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.RED_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.ORANGE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.YELLOW_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.LIME_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.GREEN_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.CYAN_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.LIGHT_BLUE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.BLUE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.PURPLE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.MAGENTA_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.PINK_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SWORD_SAND_MOLD,
            AllMoldBlocks.SHOVEL_SAND_MOLD,
            AllMoldBlocks.PICKAXE_SAND_MOLD,
            AllMoldBlocks.AXE_SAND_MOLD,
            AllMoldBlocks.HOE_SAND_MOLD,
            AllMoldBlocks.SWORD_RED_SAND_MOLD,
            AllMoldBlocks.SHOVEL_RED_SAND_MOLD,
            AllMoldBlocks.PICKAXE_RED_SAND_MOLD,
            AllMoldBlocks.AXE_RED_SAND_MOLD,
            AllMoldBlocks.HOE_RED_SAND_MOLD,
            AllMoldBlocks.SWORD_WHITE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SHOVEL_WHITE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.PICKAXE_WHITE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.AXE_WHITE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.HOE_WHITE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SWORD_LIGHT_GRAY_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.AXE_LIGHT_GRAY_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.HOE_LIGHT_GRAY_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SWORD_GRAY_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SHOVEL_GRAY_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.PICKAXE_GRAY_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.AXE_GRAY_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.HOE_GRAY_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SWORD_BLACK_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SHOVEL_BLACK_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.PICKAXE_BLACK_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.AXE_BLACK_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.HOE_BLACK_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SWORD_BROWN_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SHOVEL_BROWN_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.PICKAXE_BROWN_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.AXE_BROWN_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.HOE_BROWN_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SWORD_RED_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SHOVEL_RED_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.PICKAXE_RED_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.AXE_RED_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.HOE_RED_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SWORD_ORANGE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SHOVEL_ORANGE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.PICKAXE_ORANGE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.AXE_ORANGE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.HOE_ORANGE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SWORD_YELLOW_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SHOVEL_YELLOW_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.PICKAXE_YELLOW_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.AXE_YELLOW_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.HOE_YELLOW_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SWORD_LIME_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SHOVEL_LIME_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.PICKAXE_LIME_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.AXE_LIME_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.HOE_LIME_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SWORD_GREEN_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SHOVEL_GREEN_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.PICKAXE_GREEN_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.AXE_GREEN_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.HOE_GREEN_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SWORD_CYAN_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SHOVEL_CYAN_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.PICKAXE_CYAN_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.AXE_CYAN_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.HOE_CYAN_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SWORD_LIGHT_BLUE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.AXE_LIGHT_BLUE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.HOE_LIGHT_BLUE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SWORD_BLUE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SHOVEL_BLUE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.PICKAXE_BLUE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.AXE_BLUE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.HOE_BLUE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SWORD_PURPLE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SHOVEL_PURPLE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.PICKAXE_PURPLE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.AXE_PURPLE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.HOE_PURPLE_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SWORD_MAGENTA_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SHOVEL_MAGENTA_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.PICKAXE_MAGENTA_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.AXE_MAGENTA_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.HOE_MAGENTA_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SWORD_PINK_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.SHOVEL_PINK_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.PICKAXE_PINK_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.AXE_PINK_CONCRETE_POWDER_MOLD,
            AllMoldBlocks.HOE_PINK_CONCRETE_POWDER_MOLD
        );

        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.MOLTEN_IRON, AllFluids.FLOWING_MOLTEN_IRON, new SimpleFluidRenderHandler(CreateModularTools.asResource("block/molten_iron_still"), CreateModularTools.asResource("block/molten_iron_flow")));
        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.MOLTEN_COPPER, AllFluids.FLOWING_MOLTEN_COPPER, new SimpleFluidRenderHandler(CreateModularTools.asResource("block/molten_copper_still"), CreateModularTools.asResource("block/molten_copper_flow")));
        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.MOLTEN_GOLD, AllFluids.FLOWING_MOLTEN_GOLD, new SimpleFluidRenderHandler(CreateModularTools.asResource("block/molten_gold_still"), CreateModularTools.asResource("block/molten_gold_flow")));
        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.MOLTEN_NETHERITE, AllFluids.FLOWING_MOLTEN_NETHERITE, new SimpleFluidRenderHandler(CreateModularTools.asResource("block/molten_netherite_still"), CreateModularTools.asResource("block/molten_netherite_flow")));
        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.MOLTEN_ZINC, AllFluids.FLOWING_MOLTEN_ZINC, new SimpleFluidRenderHandler(CreateModularTools.asResource("block/molten_zinc_still"), CreateModularTools.asResource("block/molten_zinc_flow")));
        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.MOLTEN_BRASS, AllFluids.FLOWING_MOLTEN_BRASS, new SimpleFluidRenderHandler(CreateModularTools.asResource("block/molten_brass_still"), CreateModularTools.asResource("block/molten_brass_flow")));
        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.MOLTEN_DIAMOND, AllFluids.FLOWING_MOLTEN_DIAMOND, new SimpleFluidRenderHandler(CreateModularTools.asResource("block/molten_diamond_still"), CreateModularTools.asResource("block/molten_diamond_flow")));

        ModelLoadingPlugin.register(new CreateModularToolsModelLoadingPlugin());

        ClientPickBlockApplyCallback.EVENT.register((player, hit, stack) -> {
            if (stack.getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof MoldBlock) {
                CompoundTag nbt = stack.getTag();
                if (nbt != null && !nbt.contains("UUID", Tag.TAG_INT_ARRAY)) {
                    nbt.putUUID("UUID", UUID.randomUUID());
                }
            }
            return stack;
        });

        AllMoldTopTextureIds.init();

        registerForNonSolidSlot(AllMoldTopTextures.SWORD_BLADE, AllToolModuleTypes.SWORD_BLADE,
            AllMoldTopTextureIds.EMPTY_SAND_SWORD_BLADE,
            AllMoldTopTextureIds.EMPTY_RED_SAND_SWORD_BLADE,
            AllMoldTopTextureIds.EMPTY_WHITE_CONCRETE_POWDER_SWORD_BLADE,
            AllMoldTopTextureIds.EMPTY_LIGHT_GRAY_CONCRETE_POWDER_SWORD_BLADE,
            AllMoldTopTextureIds.EMPTY_GRAY_CONCRETE_POWDER_SWORD_BLADE,
            AllMoldTopTextureIds.EMPTY_BLACK_CONCRETE_POWDER_SWORD_BLADE,
            AllMoldTopTextureIds.EMPTY_BROWN_CONCRETE_POWDER_SWORD_BLADE,
            AllMoldTopTextureIds.EMPTY_RED_CONCRETE_POWDER_SWORD_BLADE,
            AllMoldTopTextureIds.EMPTY_ORANGE_CONCRETE_POWDER_SWORD_BLADE,
            AllMoldTopTextureIds.EMPTY_YELLOW_CONCRETE_POWDER_SWORD_BLADE,
            AllMoldTopTextureIds.EMPTY_LIME_CONCRETE_POWDER_SWORD_BLADE,
            AllMoldTopTextureIds.EMPTY_GREEN_CONCRETE_POWDER_SWORD_BLADE,
            AllMoldTopTextureIds.EMPTY_CYAN_CONCRETE_POWDER_SWORD_BLADE,
            AllMoldTopTextureIds.EMPTY_LIGHT_BLUE_CONCRETE_POWDER_SWORD_BLADE,
            AllMoldTopTextureIds.EMPTY_BLUE_CONCRETE_POWDER_SWORD_BLADE,
            AllMoldTopTextureIds.EMPTY_PURPLE_CONCRETE_POWDER_SWORD_BLADE,
            AllMoldTopTextureIds.EMPTY_MAGENTA_CONCRETE_POWDER_SWORD_BLADE,
            AllMoldTopTextureIds.EMPTY_PINK_CONCRETE_POWDER_SWORD_BLADE,
            AllMoldTopTextureIds.LAVA_SWORD_BLADE,
            AllMoldTopTextureIds.MOLTEN_IRON_SWORD_BLADE,
            AllMoldTopTextureIds.MOLTEN_COPPER_SWORD_BLADE,
            AllMoldTopTextureIds.MOLTEN_GOLD_SWORD_BLADE,
            AllMoldTopTextureIds.MOLTEN_NETHERITE_SWORD_BLADE,
            AllMoldTopTextureIds.MOLTEN_ZINC_SWORD_BLADE,
            AllMoldTopTextureIds.MOLTEN_BRASS_SWORD_BLADE,
            AllMoldTopTextureIds.MOLTEN_DIAMOND_SWORD_BLADE
        );

        registerForNonSolidSlot(AllMoldTopTextures.SHOVEL_HEAD, AllToolModuleTypes.SHOVEL_HEAD,
            AllMoldTopTextureIds.EMPTY_SAND_SHOVEL_HEAD,
            AllMoldTopTextureIds.EMPTY_RED_SAND_SHOVEL_HEAD,
            AllMoldTopTextureIds.EMPTY_WHITE_CONCRETE_POWDER_SHOVEL_HEAD,
            AllMoldTopTextureIds.EMPTY_LIGHT_GRAY_CONCRETE_POWDER_SHOVEL_HEAD,
            AllMoldTopTextureIds.EMPTY_GRAY_CONCRETE_POWDER_SHOVEL_HEAD,
            AllMoldTopTextureIds.EMPTY_BLACK_CONCRETE_POWDER_SHOVEL_HEAD,
            AllMoldTopTextureIds.EMPTY_BROWN_CONCRETE_POWDER_SHOVEL_HEAD,
            AllMoldTopTextureIds.EMPTY_RED_CONCRETE_POWDER_SHOVEL_HEAD,
            AllMoldTopTextureIds.EMPTY_ORANGE_CONCRETE_POWDER_SHOVEL_HEAD,
            AllMoldTopTextureIds.EMPTY_YELLOW_CONCRETE_POWDER_SHOVEL_HEAD,
            AllMoldTopTextureIds.EMPTY_LIME_CONCRETE_POWDER_SHOVEL_HEAD,
            AllMoldTopTextureIds.EMPTY_GREEN_CONCRETE_POWDER_SHOVEL_HEAD,
            AllMoldTopTextureIds.EMPTY_CYAN_CONCRETE_POWDER_SHOVEL_HEAD,
            AllMoldTopTextureIds.EMPTY_LIGHT_BLUE_CONCRETE_POWDER_SHOVEL_HEAD,
            AllMoldTopTextureIds.EMPTY_BLUE_CONCRETE_POWDER_SHOVEL_HEAD,
            AllMoldTopTextureIds.EMPTY_PURPLE_CONCRETE_POWDER_SHOVEL_HEAD,
            AllMoldTopTextureIds.EMPTY_MAGENTA_CONCRETE_POWDER_SHOVEL_HEAD,
            AllMoldTopTextureIds.EMPTY_PINK_CONCRETE_POWDER_SHOVEL_HEAD,
            AllMoldTopTextureIds.LAVA_SHOVEL_HEAD,
            AllMoldTopTextureIds.MOLTEN_IRON_SHOVEL_HEAD,
            AllMoldTopTextureIds.MOLTEN_COPPER_SHOVEL_HEAD,
            AllMoldTopTextureIds.MOLTEN_GOLD_SHOVEL_HEAD,
            AllMoldTopTextureIds.MOLTEN_NETHERITE_SHOVEL_HEAD,
            AllMoldTopTextureIds.MOLTEN_ZINC_SHOVEL_HEAD,
            AllMoldTopTextureIds.MOLTEN_BRASS_SHOVEL_HEAD,
            AllMoldTopTextureIds.MOLTEN_DIAMOND_SHOVEL_HEAD
        );

        registerForNonSolidSlot(AllMoldTopTextures.PICKAXE_HEAD, AllToolModuleTypes.PICKAXE_HEAD,
            AllMoldTopTextureIds.EMPTY_SAND_PICKAXE_HEAD,
            AllMoldTopTextureIds.EMPTY_RED_SAND_PICKAXE_HEAD,
            AllMoldTopTextureIds.EMPTY_WHITE_CONCRETE_POWDER_PICKAXE_HEAD,
            AllMoldTopTextureIds.EMPTY_LIGHT_GRAY_CONCRETE_POWDER_PICKAXE_HEAD,
            AllMoldTopTextureIds.EMPTY_GRAY_CONCRETE_POWDER_PICKAXE_HEAD,
            AllMoldTopTextureIds.EMPTY_BLACK_CONCRETE_POWDER_PICKAXE_HEAD,
            AllMoldTopTextureIds.EMPTY_BROWN_CONCRETE_POWDER_PICKAXE_HEAD,
            AllMoldTopTextureIds.EMPTY_RED_CONCRETE_POWDER_PICKAXE_HEAD,
            AllMoldTopTextureIds.EMPTY_ORANGE_CONCRETE_POWDER_PICKAXE_HEAD,
            AllMoldTopTextureIds.EMPTY_YELLOW_CONCRETE_POWDER_PICKAXE_HEAD,
            AllMoldTopTextureIds.EMPTY_LIME_CONCRETE_POWDER_PICKAXE_HEAD,
            AllMoldTopTextureIds.EMPTY_GREEN_CONCRETE_POWDER_PICKAXE_HEAD,
            AllMoldTopTextureIds.EMPTY_CYAN_CONCRETE_POWDER_PICKAXE_HEAD,
            AllMoldTopTextureIds.EMPTY_LIGHT_BLUE_CONCRETE_POWDER_PICKAXE_HEAD,
            AllMoldTopTextureIds.EMPTY_BLUE_CONCRETE_POWDER_PICKAXE_HEAD,
            AllMoldTopTextureIds.EMPTY_PURPLE_CONCRETE_POWDER_PICKAXE_HEAD,
            AllMoldTopTextureIds.EMPTY_MAGENTA_CONCRETE_POWDER_PICKAXE_HEAD,
            AllMoldTopTextureIds.EMPTY_PINK_CONCRETE_POWDER_PICKAXE_HEAD,
            AllMoldTopTextureIds.LAVA_PICKAXE_HEAD,
            AllMoldTopTextureIds.MOLTEN_IRON_PICKAXE_HEAD,
            AllMoldTopTextureIds.MOLTEN_COPPER_PICKAXE_HEAD,
            AllMoldTopTextureIds.MOLTEN_GOLD_PICKAXE_HEAD,
            AllMoldTopTextureIds.MOLTEN_NETHERITE_PICKAXE_HEAD,
            AllMoldTopTextureIds.MOLTEN_ZINC_PICKAXE_HEAD,
            AllMoldTopTextureIds.MOLTEN_BRASS_PICKAXE_HEAD,
            AllMoldTopTextureIds.MOLTEN_DIAMOND_PICKAXE_HEAD
        );

        registerForNonSolidSlot(AllMoldTopTextures.AXE_HEAD, AllToolModuleTypes.AXE_HEAD,
            AllMoldTopTextureIds.EMPTY_SAND_AXE_HEAD,
            AllMoldTopTextureIds.EMPTY_RED_SAND_AXE_HEAD,
            AllMoldTopTextureIds.EMPTY_WHITE_CONCRETE_POWDER_AXE_HEAD,
            AllMoldTopTextureIds.EMPTY_LIGHT_GRAY_CONCRETE_POWDER_AXE_HEAD,
            AllMoldTopTextureIds.EMPTY_GRAY_CONCRETE_POWDER_AXE_HEAD,
            AllMoldTopTextureIds.EMPTY_BLACK_CONCRETE_POWDER_AXE_HEAD,
            AllMoldTopTextureIds.EMPTY_BROWN_CONCRETE_POWDER_AXE_HEAD,
            AllMoldTopTextureIds.EMPTY_RED_CONCRETE_POWDER_AXE_HEAD,
            AllMoldTopTextureIds.EMPTY_ORANGE_CONCRETE_POWDER_AXE_HEAD,
            AllMoldTopTextureIds.EMPTY_YELLOW_CONCRETE_POWDER_AXE_HEAD,
            AllMoldTopTextureIds.EMPTY_LIME_CONCRETE_POWDER_AXE_HEAD,
            AllMoldTopTextureIds.EMPTY_GREEN_CONCRETE_POWDER_AXE_HEAD,
            AllMoldTopTextureIds.EMPTY_CYAN_CONCRETE_POWDER_AXE_HEAD,
            AllMoldTopTextureIds.EMPTY_LIGHT_BLUE_CONCRETE_POWDER_AXE_HEAD,
            AllMoldTopTextureIds.EMPTY_BLUE_CONCRETE_POWDER_AXE_HEAD,
            AllMoldTopTextureIds.EMPTY_PURPLE_CONCRETE_POWDER_AXE_HEAD,
            AllMoldTopTextureIds.EMPTY_MAGENTA_CONCRETE_POWDER_AXE_HEAD,
            AllMoldTopTextureIds.EMPTY_PINK_CONCRETE_POWDER_AXE_HEAD,
            AllMoldTopTextureIds.LAVA_AXE_HEAD,
            AllMoldTopTextureIds.MOLTEN_IRON_AXE_HEAD,
            AllMoldTopTextureIds.MOLTEN_COPPER_AXE_HEAD,
            AllMoldTopTextureIds.MOLTEN_GOLD_AXE_HEAD,
            AllMoldTopTextureIds.MOLTEN_NETHERITE_AXE_HEAD,
            AllMoldTopTextureIds.MOLTEN_ZINC_AXE_HEAD,
            AllMoldTopTextureIds.MOLTEN_BRASS_AXE_HEAD,
            AllMoldTopTextureIds.MOLTEN_DIAMOND_AXE_HEAD
        );

        registerForNonSolidSlot(AllMoldTopTextures.HOE_HEAD, AllToolModuleTypes.HOE_HEAD,
            AllMoldTopTextureIds.EMPTY_SAND_HOE_HEAD,
            AllMoldTopTextureIds.EMPTY_RED_SAND_HOE_HEAD,
            AllMoldTopTextureIds.EMPTY_WHITE_CONCRETE_POWDER_HOE_HEAD,
            AllMoldTopTextureIds.EMPTY_LIGHT_GRAY_CONCRETE_POWDER_HOE_HEAD,
            AllMoldTopTextureIds.EMPTY_GRAY_CONCRETE_POWDER_HOE_HEAD,
            AllMoldTopTextureIds.EMPTY_BLACK_CONCRETE_POWDER_HOE_HEAD,
            AllMoldTopTextureIds.EMPTY_BROWN_CONCRETE_POWDER_HOE_HEAD,
            AllMoldTopTextureIds.EMPTY_RED_CONCRETE_POWDER_HOE_HEAD,
            AllMoldTopTextureIds.EMPTY_ORANGE_CONCRETE_POWDER_HOE_HEAD,
            AllMoldTopTextureIds.EMPTY_YELLOW_CONCRETE_POWDER_HOE_HEAD,
            AllMoldTopTextureIds.EMPTY_LIME_CONCRETE_POWDER_HOE_HEAD,
            AllMoldTopTextureIds.EMPTY_GREEN_CONCRETE_POWDER_HOE_HEAD,
            AllMoldTopTextureIds.EMPTY_CYAN_CONCRETE_POWDER_HOE_HEAD,
            AllMoldTopTextureIds.EMPTY_LIGHT_BLUE_CONCRETE_POWDER_HOE_HEAD,
            AllMoldTopTextureIds.EMPTY_BLUE_CONCRETE_POWDER_HOE_HEAD,
            AllMoldTopTextureIds.EMPTY_PURPLE_CONCRETE_POWDER_HOE_HEAD,
            AllMoldTopTextureIds.EMPTY_MAGENTA_CONCRETE_POWDER_HOE_HEAD,
            AllMoldTopTextureIds.EMPTY_PINK_CONCRETE_POWDER_HOE_HEAD,
            AllMoldTopTextureIds.LAVA_HOE_HEAD,
            AllMoldTopTextureIds.MOLTEN_IRON_HOE_HEAD,
            AllMoldTopTextureIds.MOLTEN_COPPER_HOE_HEAD,
            AllMoldTopTextureIds.MOLTEN_GOLD_HOE_HEAD,
            AllMoldTopTextureIds.MOLTEN_NETHERITE_HOE_HEAD,
            AllMoldTopTextureIds.MOLTEN_ZINC_HOE_HEAD,
            AllMoldTopTextureIds.MOLTEN_BRASS_HOE_HEAD,
            AllMoldTopTextureIds.MOLTEN_DIAMOND_HOE_HEAD
        );

        registerForNonSolidSlot(AllMoldTopTextures.SWORD_HANDLE, AllToolModuleTypes.TOOL_HANDLE,
            AllMoldTopTextureIds.EMPTY_SAND_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_RED_SAND_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_WHITE_CONCRETE_POWDER_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIGHT_GRAY_CONCRETE_POWDER_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_GRAY_CONCRETE_POWDER_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_BLACK_CONCRETE_POWDER_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_BROWN_CONCRETE_POWDER_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_RED_CONCRETE_POWDER_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_ORANGE_CONCRETE_POWDER_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_YELLOW_CONCRETE_POWDER_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIME_CONCRETE_POWDER_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_GREEN_CONCRETE_POWDER_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_CYAN_CONCRETE_POWDER_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIGHT_BLUE_CONCRETE_POWDER_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_BLUE_CONCRETE_POWDER_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_PURPLE_CONCRETE_POWDER_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_MAGENTA_CONCRETE_POWDER_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_PINK_CONCRETE_POWDER_SWORD_HANDLE,
            AllMoldTopTextureIds.LAVA_SWORD_HANDLE,
            AllMoldTopTextureIds.MOLTEN_IRON_SWORD_HANDLE,
            AllMoldTopTextureIds.MOLTEN_COPPER_SWORD_HANDLE,
            AllMoldTopTextureIds.MOLTEN_GOLD_SWORD_HANDLE,
            AllMoldTopTextureIds.MOLTEN_NETHERITE_SWORD_HANDLE,
            AllMoldTopTextureIds.MOLTEN_ZINC_SWORD_HANDLE,
            AllMoldTopTextureIds.MOLTEN_BRASS_SWORD_HANDLE,
            AllMoldTopTextureIds.MOLTEN_DIAMOND_SWORD_HANDLE
        );

        registerForNonSolidSlot(AllMoldTopTextures.POMMEL_SWORD_HANDLE, AllToolModuleTypes.TOOL_HANDLE,
            AllMoldTopTextureIds.EMPTY_SAND_POMMEL_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_RED_SAND_POMMEL_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_WHITE_CONCRETE_POWDER_POMMEL_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIGHT_GRAY_CONCRETE_POWDER_POMMEL_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_GRAY_CONCRETE_POWDER_POMMEL_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_BLACK_CONCRETE_POWDER_POMMEL_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_BROWN_CONCRETE_POWDER_POMMEL_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_RED_CONCRETE_POWDER_POMMEL_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_ORANGE_CONCRETE_POWDER_POMMEL_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_YELLOW_CONCRETE_POWDER_POMMEL_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIME_CONCRETE_POWDER_POMMEL_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_GREEN_CONCRETE_POWDER_POMMEL_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_CYAN_CONCRETE_POWDER_POMMEL_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIGHT_BLUE_CONCRETE_POWDER_POMMEL_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_BLUE_CONCRETE_POWDER_POMMEL_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_PURPLE_CONCRETE_POWDER_POMMEL_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_MAGENTA_CONCRETE_POWDER_POMMEL_SWORD_HANDLE,
            AllMoldTopTextureIds.EMPTY_PINK_CONCRETE_POWDER_POMMEL_SWORD_HANDLE,
            AllMoldTopTextureIds.LAVA_POMMEL_SWORD_HANDLE,
            AllMoldTopTextureIds.MOLTEN_IRON_POMMEL_SWORD_HANDLE,
            AllMoldTopTextureIds.MOLTEN_COPPER_POMMEL_SWORD_HANDLE,
            AllMoldTopTextureIds.MOLTEN_GOLD_POMMEL_SWORD_HANDLE,
            AllMoldTopTextureIds.MOLTEN_NETHERITE_POMMEL_SWORD_HANDLE,
            AllMoldTopTextureIds.MOLTEN_ZINC_POMMEL_SWORD_HANDLE,
            AllMoldTopTextureIds.MOLTEN_BRASS_POMMEL_SWORD_HANDLE,
            AllMoldTopTextureIds.MOLTEN_DIAMOND_POMMEL_SWORD_HANDLE
        );

        registerForNonSolidSlot(AllMoldTopTextures.SHOVEL_HANDLE, AllToolModuleTypes.TOOL_HANDLE,
            AllMoldTopTextureIds.EMPTY_SAND_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_RED_SAND_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_WHITE_CONCRETE_POWDER_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIGHT_GRAY_CONCRETE_POWDER_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_GRAY_CONCRETE_POWDER_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_BLACK_CONCRETE_POWDER_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_BROWN_CONCRETE_POWDER_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_RED_CONCRETE_POWDER_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_ORANGE_CONCRETE_POWDER_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_YELLOW_CONCRETE_POWDER_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIME_CONCRETE_POWDER_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_GREEN_CONCRETE_POWDER_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_CYAN_CONCRETE_POWDER_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIGHT_BLUE_CONCRETE_POWDER_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_BLUE_CONCRETE_POWDER_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_PURPLE_CONCRETE_POWDER_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_MAGENTA_CONCRETE_POWDER_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_PINK_CONCRETE_POWDER_SHOVEL_HANDLE,
            AllMoldTopTextureIds.LAVA_SHOVEL_HANDLE,
            AllMoldTopTextureIds.MOLTEN_IRON_SHOVEL_HANDLE,
            AllMoldTopTextureIds.MOLTEN_COPPER_SHOVEL_HANDLE,
            AllMoldTopTextureIds.MOLTEN_GOLD_SHOVEL_HANDLE,
            AllMoldTopTextureIds.MOLTEN_NETHERITE_SHOVEL_HANDLE,
            AllMoldTopTextureIds.MOLTEN_ZINC_SHOVEL_HANDLE,
            AllMoldTopTextureIds.MOLTEN_BRASS_SHOVEL_HANDLE,
            AllMoldTopTextureIds.MOLTEN_DIAMOND_SHOVEL_HANDLE
        );

        registerForNonSolidSlot(AllMoldTopTextures.GRIP_SHOVEL_HANDLE, AllToolModuleTypes.TOOL_HANDLE,
            AllMoldTopTextureIds.EMPTY_SAND_GRIP_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_RED_SAND_GRIP_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_WHITE_CONCRETE_POWDER_GRIP_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIGHT_GRAY_CONCRETE_POWDER_GRIP_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_GRAY_CONCRETE_POWDER_GRIP_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_BLACK_CONCRETE_POWDER_GRIP_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_BROWN_CONCRETE_POWDER_GRIP_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_RED_CONCRETE_POWDER_GRIP_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_ORANGE_CONCRETE_POWDER_GRIP_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_YELLOW_CONCRETE_POWDER_GRIP_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIME_CONCRETE_POWDER_GRIP_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_GREEN_CONCRETE_POWDER_GRIP_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_CYAN_CONCRETE_POWDER_GRIP_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIGHT_BLUE_CONCRETE_POWDER_GRIP_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_BLUE_CONCRETE_POWDER_GRIP_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_PURPLE_CONCRETE_POWDER_GRIP_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_MAGENTA_CONCRETE_POWDER_GRIP_SHOVEL_HANDLE,
            AllMoldTopTextureIds.EMPTY_PINK_CONCRETE_POWDER_GRIP_SHOVEL_HANDLE,
            AllMoldTopTextureIds.LAVA_GRIP_SHOVEL_HANDLE,
            AllMoldTopTextureIds.MOLTEN_IRON_GRIP_SHOVEL_HANDLE,
            AllMoldTopTextureIds.MOLTEN_COPPER_GRIP_SHOVEL_HANDLE,
            AllMoldTopTextureIds.MOLTEN_GOLD_GRIP_SHOVEL_HANDLE,
            AllMoldTopTextureIds.MOLTEN_NETHERITE_GRIP_SHOVEL_HANDLE,
            AllMoldTopTextureIds.MOLTEN_ZINC_GRIP_SHOVEL_HANDLE,
            AllMoldTopTextureIds.MOLTEN_BRASS_GRIP_SHOVEL_HANDLE,
            AllMoldTopTextureIds.MOLTEN_DIAMOND_GRIP_SHOVEL_HANDLE
        );

        registerForNonSolidSlot(AllMoldTopTextures.PICKAXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE,
            AllMoldTopTextureIds.EMPTY_SAND_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_RED_SAND_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_WHITE_CONCRETE_POWDER_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIGHT_GRAY_CONCRETE_POWDER_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_GRAY_CONCRETE_POWDER_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_BLACK_CONCRETE_POWDER_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_BROWN_CONCRETE_POWDER_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_RED_CONCRETE_POWDER_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_ORANGE_CONCRETE_POWDER_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_YELLOW_CONCRETE_POWDER_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIME_CONCRETE_POWDER_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_GREEN_CONCRETE_POWDER_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_CYAN_CONCRETE_POWDER_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIGHT_BLUE_CONCRETE_POWDER_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_BLUE_CONCRETE_POWDER_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_PURPLE_CONCRETE_POWDER_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_MAGENTA_CONCRETE_POWDER_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_PINK_CONCRETE_POWDER_PICKAXE_HANDLE,
            AllMoldTopTextureIds.LAVA_PICKAXE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_IRON_PICKAXE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_COPPER_PICKAXE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_GOLD_PICKAXE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_NETHERITE_PICKAXE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_ZINC_PICKAXE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_BRASS_PICKAXE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_DIAMOND_PICKAXE_HANDLE
        );

        registerForNonSolidSlot(AllMoldTopTextures.GRIP_PICKAXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE,
            AllMoldTopTextureIds.EMPTY_SAND_GRIP_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_RED_SAND_GRIP_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_WHITE_CONCRETE_POWDER_GRIP_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIGHT_GRAY_CONCRETE_POWDER_GRIP_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_GRAY_CONCRETE_POWDER_GRIP_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_BLACK_CONCRETE_POWDER_GRIP_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_BROWN_CONCRETE_POWDER_GRIP_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_RED_CONCRETE_POWDER_GRIP_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_ORANGE_CONCRETE_POWDER_GRIP_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_YELLOW_CONCRETE_POWDER_GRIP_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIME_CONCRETE_POWDER_GRIP_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_GREEN_CONCRETE_POWDER_GRIP_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_CYAN_CONCRETE_POWDER_GRIP_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIGHT_BLUE_CONCRETE_POWDER_GRIP_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_BLUE_CONCRETE_POWDER_GRIP_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_PURPLE_CONCRETE_POWDER_GRIP_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_MAGENTA_CONCRETE_POWDER_GRIP_PICKAXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_PINK_CONCRETE_POWDER_GRIP_PICKAXE_HANDLE,
            AllMoldTopTextureIds.LAVA_GRIP_PICKAXE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_IRON_GRIP_PICKAXE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_COPPER_GRIP_PICKAXE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_GOLD_GRIP_PICKAXE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_NETHERITE_GRIP_PICKAXE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_ZINC_GRIP_PICKAXE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_BRASS_GRIP_PICKAXE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_DIAMOND_GRIP_PICKAXE_HANDLE
        );

        registerForNonSolidSlot(AllMoldTopTextures.AXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE,
            AllMoldTopTextureIds.EMPTY_SAND_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_RED_SAND_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_WHITE_CONCRETE_POWDER_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIGHT_GRAY_CONCRETE_POWDER_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_GRAY_CONCRETE_POWDER_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_BLACK_CONCRETE_POWDER_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_BROWN_CONCRETE_POWDER_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_RED_CONCRETE_POWDER_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_ORANGE_CONCRETE_POWDER_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_YELLOW_CONCRETE_POWDER_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIME_CONCRETE_POWDER_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_GREEN_CONCRETE_POWDER_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_CYAN_CONCRETE_POWDER_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIGHT_BLUE_CONCRETE_POWDER_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_BLUE_CONCRETE_POWDER_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_PURPLE_CONCRETE_POWDER_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_MAGENTA_CONCRETE_POWDER_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_PINK_CONCRETE_POWDER_AXE_HANDLE,
            AllMoldTopTextureIds.LAVA_AXE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_IRON_AXE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_COPPER_AXE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_GOLD_AXE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_NETHERITE_AXE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_ZINC_AXE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_BRASS_AXE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_DIAMOND_AXE_HANDLE
        );

        registerForNonSolidSlot(AllMoldTopTextures.GRIP_AXE_HANDLE, AllToolModuleTypes.TOOL_HANDLE,
            AllMoldTopTextureIds.EMPTY_SAND_GRIP_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_RED_SAND_GRIP_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_WHITE_CONCRETE_POWDER_GRIP_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIGHT_GRAY_CONCRETE_POWDER_GRIP_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_GRAY_CONCRETE_POWDER_GRIP_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_BLACK_CONCRETE_POWDER_GRIP_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_BROWN_CONCRETE_POWDER_GRIP_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_RED_CONCRETE_POWDER_GRIP_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_ORANGE_CONCRETE_POWDER_GRIP_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_YELLOW_CONCRETE_POWDER_GRIP_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIME_CONCRETE_POWDER_GRIP_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_GREEN_CONCRETE_POWDER_GRIP_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_CYAN_CONCRETE_POWDER_GRIP_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIGHT_BLUE_CONCRETE_POWDER_GRIP_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_BLUE_CONCRETE_POWDER_GRIP_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_PURPLE_CONCRETE_POWDER_GRIP_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_MAGENTA_CONCRETE_POWDER_GRIP_AXE_HANDLE,
            AllMoldTopTextureIds.EMPTY_PINK_CONCRETE_POWDER_GRIP_AXE_HANDLE,
            AllMoldTopTextureIds.LAVA_GRIP_AXE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_IRON_GRIP_AXE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_COPPER_GRIP_AXE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_GOLD_GRIP_AXE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_NETHERITE_GRIP_AXE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_ZINC_GRIP_AXE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_BRASS_GRIP_AXE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_DIAMOND_GRIP_AXE_HANDLE
        );

        registerForNonSolidSlot(AllMoldTopTextures.HOE_HANDLE, AllToolModuleTypes.TOOL_HANDLE,
            AllMoldTopTextureIds.EMPTY_SAND_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_RED_SAND_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_WHITE_CONCRETE_POWDER_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIGHT_GRAY_CONCRETE_POWDER_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_GRAY_CONCRETE_POWDER_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_BLACK_CONCRETE_POWDER_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_BROWN_CONCRETE_POWDER_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_RED_CONCRETE_POWDER_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_ORANGE_CONCRETE_POWDER_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_YELLOW_CONCRETE_POWDER_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIME_CONCRETE_POWDER_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_GREEN_CONCRETE_POWDER_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_CYAN_CONCRETE_POWDER_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIGHT_BLUE_CONCRETE_POWDER_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_BLUE_CONCRETE_POWDER_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_PURPLE_CONCRETE_POWDER_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_MAGENTA_CONCRETE_POWDER_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_PINK_CONCRETE_POWDER_HOE_HANDLE,
            AllMoldTopTextureIds.LAVA_HOE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_IRON_HOE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_COPPER_HOE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_GOLD_HOE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_NETHERITE_HOE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_ZINC_HOE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_BRASS_HOE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_DIAMOND_HOE_HANDLE
        );

        registerForNonSolidSlot(AllMoldTopTextures.GRIP_HOE_HANDLE, AllToolModuleTypes.TOOL_HANDLE,
            AllMoldTopTextureIds.EMPTY_SAND_GRIP_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_RED_SAND_GRIP_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_WHITE_CONCRETE_POWDER_GRIP_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIGHT_GRAY_CONCRETE_POWDER_GRIP_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_GRAY_CONCRETE_POWDER_GRIP_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_BLACK_CONCRETE_POWDER_GRIP_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_BROWN_CONCRETE_POWDER_GRIP_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_RED_CONCRETE_POWDER_GRIP_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_ORANGE_CONCRETE_POWDER_GRIP_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_YELLOW_CONCRETE_POWDER_GRIP_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIME_CONCRETE_POWDER_GRIP_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_GREEN_CONCRETE_POWDER_GRIP_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_CYAN_CONCRETE_POWDER_GRIP_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_LIGHT_BLUE_CONCRETE_POWDER_GRIP_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_BLUE_CONCRETE_POWDER_GRIP_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_PURPLE_CONCRETE_POWDER_GRIP_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_MAGENTA_CONCRETE_POWDER_GRIP_HOE_HANDLE,
            AllMoldTopTextureIds.EMPTY_PINK_CONCRETE_POWDER_GRIP_HOE_HANDLE,
            AllMoldTopTextureIds.LAVA_GRIP_HOE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_IRON_GRIP_HOE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_COPPER_GRIP_HOE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_GOLD_GRIP_HOE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_NETHERITE_GRIP_HOE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_ZINC_GRIP_HOE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_BRASS_GRIP_HOE_HANDLE,
            AllMoldTopTextureIds.MOLTEN_DIAMOND_GRIP_HOE_HANDLE
        );

        registerForNonSolidSlot(AllMoldTopTextures.GRIP, AllToolModuleTypes.TOOL_GRIP,
            AllMoldTopTextureIds.EMPTY_SAND_GRIP,
            AllMoldTopTextureIds.EMPTY_RED_SAND_GRIP,
            AllMoldTopTextureIds.EMPTY_WHITE_CONCRETE_POWDER_GRIP,
            AllMoldTopTextureIds.EMPTY_LIGHT_GRAY_CONCRETE_POWDER_GRIP,
            AllMoldTopTextureIds.EMPTY_GRAY_CONCRETE_POWDER_GRIP,
            AllMoldTopTextureIds.EMPTY_BLACK_CONCRETE_POWDER_GRIP,
            AllMoldTopTextureIds.EMPTY_BROWN_CONCRETE_POWDER_GRIP,
            AllMoldTopTextureIds.EMPTY_RED_CONCRETE_POWDER_GRIP,
            AllMoldTopTextureIds.EMPTY_ORANGE_CONCRETE_POWDER_GRIP,
            AllMoldTopTextureIds.EMPTY_YELLOW_CONCRETE_POWDER_GRIP,
            AllMoldTopTextureIds.EMPTY_LIME_CONCRETE_POWDER_GRIP,
            AllMoldTopTextureIds.EMPTY_GREEN_CONCRETE_POWDER_GRIP,
            AllMoldTopTextureIds.EMPTY_CYAN_CONCRETE_POWDER_GRIP,
            AllMoldTopTextureIds.EMPTY_LIGHT_BLUE_CONCRETE_POWDER_GRIP,
            AllMoldTopTextureIds.EMPTY_BLUE_CONCRETE_POWDER_GRIP,
            AllMoldTopTextureIds.EMPTY_PURPLE_CONCRETE_POWDER_GRIP,
            AllMoldTopTextureIds.EMPTY_MAGENTA_CONCRETE_POWDER_GRIP,
            AllMoldTopTextureIds.EMPTY_PINK_CONCRETE_POWDER_GRIP,
            AllMoldTopTextureIds.LAVA_GRIP,
            AllMoldTopTextureIds.MOLTEN_IRON_GRIP,
            AllMoldTopTextureIds.MOLTEN_COPPER_GRIP,
            AllMoldTopTextureIds.MOLTEN_GOLD_GRIP,
            AllMoldTopTextureIds.MOLTEN_NETHERITE_GRIP,
            AllMoldTopTextureIds.MOLTEN_ZINC_GRIP,
            AllMoldTopTextureIds.MOLTEN_BRASS_GRIP,
            AllMoldTopTextureIds.MOLTEN_DIAMOND_GRIP
        );

        registerForNonSolidSlot(AllMoldTopTextures.GUARD, AllToolModuleTypes.SWORD_GUARD,
            AllMoldTopTextureIds.EMPTY_SAND_GUARD,
            AllMoldTopTextureIds.EMPTY_RED_SAND_GUARD,
            AllMoldTopTextureIds.EMPTY_WHITE_CONCRETE_POWDER_GUARD,
            AllMoldTopTextureIds.EMPTY_LIGHT_GRAY_CONCRETE_POWDER_GUARD,
            AllMoldTopTextureIds.EMPTY_GRAY_CONCRETE_POWDER_GUARD,
            AllMoldTopTextureIds.EMPTY_BLACK_CONCRETE_POWDER_GUARD,
            AllMoldTopTextureIds.EMPTY_BROWN_CONCRETE_POWDER_GUARD,
            AllMoldTopTextureIds.EMPTY_RED_CONCRETE_POWDER_GUARD,
            AllMoldTopTextureIds.EMPTY_ORANGE_CONCRETE_POWDER_GUARD,
            AllMoldTopTextureIds.EMPTY_YELLOW_CONCRETE_POWDER_GUARD,
            AllMoldTopTextureIds.EMPTY_LIME_CONCRETE_POWDER_GUARD,
            AllMoldTopTextureIds.EMPTY_GREEN_CONCRETE_POWDER_GUARD,
            AllMoldTopTextureIds.EMPTY_CYAN_CONCRETE_POWDER_GUARD,
            AllMoldTopTextureIds.EMPTY_LIGHT_BLUE_CONCRETE_POWDER_GUARD,
            AllMoldTopTextureIds.EMPTY_BLUE_CONCRETE_POWDER_GUARD,
            AllMoldTopTextureIds.EMPTY_PURPLE_CONCRETE_POWDER_GUARD,
            AllMoldTopTextureIds.EMPTY_MAGENTA_CONCRETE_POWDER_GUARD,
            AllMoldTopTextureIds.EMPTY_PINK_CONCRETE_POWDER_GUARD,
            AllMoldTopTextureIds.LAVA_GUARD,
            AllMoldTopTextureIds.MOLTEN_IRON_GUARD,
            AllMoldTopTextureIds.MOLTEN_COPPER_GUARD,
            AllMoldTopTextureIds.MOLTEN_GOLD_GUARD,
            AllMoldTopTextureIds.MOLTEN_NETHERITE_GUARD,
            AllMoldTopTextureIds.MOLTEN_ZINC_GUARD,
            AllMoldTopTextureIds.MOLTEN_BRASS_GUARD,
            AllMoldTopTextureIds.MOLTEN_DIAMOND_GUARD
        );

        registerForNonSolidSlot(AllMoldTopTextures.POMMEL, AllToolModuleTypes.SWORD_POMMEL,
            AllMoldTopTextureIds.EMPTY_SAND_POMMEL,
            AllMoldTopTextureIds.EMPTY_RED_SAND_POMMEL,
            AllMoldTopTextureIds.EMPTY_WHITE_CONCRETE_POWDER_POMMEL,
            AllMoldTopTextureIds.EMPTY_LIGHT_GRAY_CONCRETE_POWDER_POMMEL,
            AllMoldTopTextureIds.EMPTY_GRAY_CONCRETE_POWDER_POMMEL,
            AllMoldTopTextureIds.EMPTY_BLACK_CONCRETE_POWDER_POMMEL,
            AllMoldTopTextureIds.EMPTY_BROWN_CONCRETE_POWDER_POMMEL,
            AllMoldTopTextureIds.EMPTY_RED_CONCRETE_POWDER_POMMEL,
            AllMoldTopTextureIds.EMPTY_ORANGE_CONCRETE_POWDER_POMMEL,
            AllMoldTopTextureIds.EMPTY_YELLOW_CONCRETE_POWDER_POMMEL,
            AllMoldTopTextureIds.EMPTY_LIME_CONCRETE_POWDER_POMMEL,
            AllMoldTopTextureIds.EMPTY_GREEN_CONCRETE_POWDER_POMMEL,
            AllMoldTopTextureIds.EMPTY_CYAN_CONCRETE_POWDER_POMMEL,
            AllMoldTopTextureIds.EMPTY_LIGHT_BLUE_CONCRETE_POWDER_POMMEL,
            AllMoldTopTextureIds.EMPTY_BLUE_CONCRETE_POWDER_POMMEL,
            AllMoldTopTextureIds.EMPTY_PURPLE_CONCRETE_POWDER_POMMEL,
            AllMoldTopTextureIds.EMPTY_MAGENTA_CONCRETE_POWDER_POMMEL,
            AllMoldTopTextureIds.EMPTY_PINK_CONCRETE_POWDER_POMMEL,
            AllMoldTopTextureIds.LAVA_POMMEL,
            AllMoldTopTextureIds.MOLTEN_IRON_POMMEL,
            AllMoldTopTextureIds.MOLTEN_COPPER_POMMEL,
            AllMoldTopTextureIds.MOLTEN_GOLD_POMMEL,
            AllMoldTopTextureIds.MOLTEN_NETHERITE_POMMEL,
            AllMoldTopTextureIds.MOLTEN_ZINC_POMMEL,
            AllMoldTopTextureIds.MOLTEN_BRASS_POMMEL,
            AllMoldTopTextureIds.MOLTEN_DIAMOND_POMMEL
        );

        AllToolModuleModelIds.init();

        // Sword Blades

        registerForBasicToolModule(AllToolModules.WOODEN_SWORD_BLADE, AllToolModuleModelIds.WOODEN_SWORD_BLADE);
        registerForBasicToolModule(AllToolModules.OAK_SWORD_BLADE, AllToolModuleModelIds.OAK_SWORD_BLADE);
        registerForBasicToolModule(AllToolModules.SPRUCE_SWORD_BLADE, AllToolModuleModelIds.SPRUCE_SWORD_BLADE);
        registerForBasicToolModule(AllToolModules.BIRCH_SWORD_BLADE, AllToolModuleModelIds.BIRCH_SWORD_BLADE);
        registerForBasicToolModule(AllToolModules.JUNGLE_SWORD_BLADE, AllToolModuleModelIds.JUNGLE_SWORD_BLADE);
        registerForBasicToolModule(AllToolModules.ACACIA_SWORD_BLADE, AllToolModuleModelIds.ACACIA_SWORD_BLADE);
        registerForBasicToolModule(AllToolModules.DARK_OAK_SWORD_BLADE, AllToolModuleModelIds.DARK_OAK_SWORD_BLADE);
        registerForBasicToolModule(AllToolModules.MANGROVE_SWORD_BLADE, AllToolModuleModelIds.MANGROVE_SWORD_BLADE);
        registerForBasicToolModule(AllToolModules.CHERRY_SWORD_BLADE, AllToolModuleModelIds.CHERRY_SWORD_BLADE);
        registerForBasicToolModule(AllToolModules.BAMBOO_SWORD_BLADE, AllToolModuleModelIds.BAMBOO_SWORD_BLADE);
        registerForBasicToolModule(AllToolModules.CRIMSON_SWORD_BLADE, AllToolModuleModelIds.CRIMSON_SWORD_BLADE);
        registerForBasicToolModule(AllToolModules.WARPED_SWORD_BLADE, AllToolModuleModelIds.WARPED_SWORD_BLADE);
        registerForBasicToolModule(AllToolModules.STONE_SWORD_BLADE, AllToolModuleModelIds.STONE_SWORD_BLADE);
        registerForBasicToolModule(AllToolModules.IRON_SWORD_BLADE, AllToolModuleModelIds.IRON_SWORD_BLADE);
        registerForBasicToolModule(AllToolModules.COPPER_SWORD_BLADE, AllToolModuleModelIds.COPPER_SWORD_BLADE);
        registerForBasicToolModule(AllToolModules.GOLDEN_SWORD_BLADE, AllToolModuleModelIds.GOLDEN_SWORD_BLADE);
        registerForBasicToolModule(AllToolModules.NETHERITE_SWORD_BLADE, AllToolModuleModelIds.NETHERITE_SWORD_BLADE);
        registerForBasicToolModule(AllToolModules.ZINC_SWORD_BLADE, AllToolModuleModelIds.ZINC_SWORD_BLADE);
        registerForBasicToolModule(AllToolModules.BRASS_SWORD_BLADE, AllToolModuleModelIds.BRASS_SWORD_BLADE);
        registerForBasicToolModule(AllToolModules.DIAMOND_SWORD_BLADE, AllToolModuleModelIds.DIAMOND_SWORD_BLADE);

        // Shovel Heads

        registerForBasicToolModule(AllToolModules.WOODEN_SHOVEL_HEAD, AllToolModuleModelIds.WOODEN_SHOVEL_HEAD);
        registerForBasicToolModule(AllToolModules.OAK_SHOVEL_HEAD, AllToolModuleModelIds.OAK_SHOVEL_HEAD);
        registerForBasicToolModule(AllToolModules.SPRUCE_SHOVEL_HEAD, AllToolModuleModelIds.SPRUCE_SHOVEL_HEAD);
        registerForBasicToolModule(AllToolModules.BIRCH_SHOVEL_HEAD, AllToolModuleModelIds.BIRCH_SHOVEL_HEAD);
        registerForBasicToolModule(AllToolModules.JUNGLE_SHOVEL_HEAD, AllToolModuleModelIds.JUNGLE_SHOVEL_HEAD);
        registerForBasicToolModule(AllToolModules.ACACIA_SHOVEL_HEAD, AllToolModuleModelIds.ACACIA_SHOVEL_HEAD);
        registerForBasicToolModule(AllToolModules.DARK_OAK_SHOVEL_HEAD, AllToolModuleModelIds.DARK_OAK_SHOVEL_HEAD);
        registerForBasicToolModule(AllToolModules.MANGROVE_SHOVEL_HEAD, AllToolModuleModelIds.MANGROVE_SHOVEL_HEAD);
        registerForBasicToolModule(AllToolModules.CHERRY_SHOVEL_HEAD, AllToolModuleModelIds.CHERRY_SHOVEL_HEAD);
        registerForBasicToolModule(AllToolModules.BAMBOO_SHOVEL_HEAD, AllToolModuleModelIds.BAMBOO_SHOVEL_HEAD);
        registerForBasicToolModule(AllToolModules.CRIMSON_SHOVEL_HEAD, AllToolModuleModelIds.CRIMSON_SHOVEL_HEAD);
        registerForBasicToolModule(AllToolModules.WARPED_SHOVEL_HEAD, AllToolModuleModelIds.WARPED_SHOVEL_HEAD);
        registerForBasicToolModule(AllToolModules.STONE_SHOVEL_HEAD, AllToolModuleModelIds.STONE_SHOVEL_HEAD);
        registerForBasicToolModule(AllToolModules.IRON_SHOVEL_HEAD, AllToolModuleModelIds.IRON_SHOVEL_HEAD);
        registerForBasicToolModule(AllToolModules.COPPER_SHOVEL_HEAD, AllToolModuleModelIds.COPPER_SHOVEL_HEAD);
        registerForBasicToolModule(AllToolModules.GOLDEN_SHOVEL_HEAD, AllToolModuleModelIds.GOLDEN_SHOVEL_HEAD);
        registerForBasicToolModule(AllToolModules.NETHERITE_SHOVEL_HEAD, AllToolModuleModelIds.NETHERITE_SHOVEL_HEAD);
        registerForBasicToolModule(AllToolModules.ZINC_SHOVEL_HEAD, AllToolModuleModelIds.ZINC_SHOVEL_HEAD);
        registerForBasicToolModule(AllToolModules.BRASS_SHOVEL_HEAD, AllToolModuleModelIds.BRASS_SHOVEL_HEAD);
        registerForBasicToolModule(AllToolModules.DIAMOND_SHOVEL_HEAD, AllToolModuleModelIds.DIAMOND_SHOVEL_HEAD);

        // Pickaxe Heads

        registerForPickaxeHead(AllToolModules.WOODEN_PICKAXE_HEAD, AllToolModuleModelIds.WOODEN_PICKAXE_HEAD, AllToolModuleModelIds.WOODEN_PICKAXE_HEAD_ITEM);
        registerForPickaxeHead(AllToolModules.OAK_PICKAXE_HEAD, AllToolModuleModelIds.OAK_PICKAXE_HEAD, AllToolModuleModelIds.OAK_PICKAXE_HEAD_ITEM);
        registerForPickaxeHead(AllToolModules.SPRUCE_PICKAXE_HEAD, AllToolModuleModelIds.SPRUCE_PICKAXE_HEAD, AllToolModuleModelIds.SPRUCE_PICKAXE_HEAD_ITEM);
        registerForPickaxeHead(AllToolModules.BIRCH_PICKAXE_HEAD, AllToolModuleModelIds.BIRCH_PICKAXE_HEAD, AllToolModuleModelIds.BIRCH_PICKAXE_HEAD_ITEM);
        registerForPickaxeHead(AllToolModules.JUNGLE_PICKAXE_HEAD, AllToolModuleModelIds.JUNGLE_PICKAXE_HEAD, AllToolModuleModelIds.JUNGLE_PICKAXE_HEAD_ITEM);
        registerForPickaxeHead(AllToolModules.ACACIA_PICKAXE_HEAD, AllToolModuleModelIds.ACACIA_PICKAXE_HEAD, AllToolModuleModelIds.ACACIA_PICKAXE_HEAD_ITEM);
        registerForPickaxeHead(AllToolModules.DARK_OAK_PICKAXE_HEAD, AllToolModuleModelIds.DARK_OAK_PICKAXE_HEAD, AllToolModuleModelIds.DARK_OAK_PICKAXE_HEAD_ITEM);
        registerForPickaxeHead(AllToolModules.MANGROVE_PICKAXE_HEAD, AllToolModuleModelIds.MANGROVE_PICKAXE_HEAD, AllToolModuleModelIds.MANGROVE_PICKAXE_HEAD_ITEM);
        registerForPickaxeHead(AllToolModules.CHERRY_PICKAXE_HEAD, AllToolModuleModelIds.CHERRY_PICKAXE_HEAD, AllToolModuleModelIds.CHERRY_PICKAXE_HEAD_ITEM);
        registerForPickaxeHead(AllToolModules.BAMBOO_PICKAXE_HEAD, AllToolModuleModelIds.BAMBOO_PICKAXE_HEAD, AllToolModuleModelIds.BAMBOO_PICKAXE_HEAD_ITEM);
        registerForPickaxeHead(AllToolModules.CRIMSON_PICKAXE_HEAD, AllToolModuleModelIds.CRIMSON_PICKAXE_HEAD, AllToolModuleModelIds.CRIMSON_PICKAXE_HEAD_ITEM);
        registerForPickaxeHead(AllToolModules.WARPED_PICKAXE_HEAD, AllToolModuleModelIds.WARPED_PICKAXE_HEAD, AllToolModuleModelIds.WARPED_PICKAXE_HEAD_ITEM);
        registerForPickaxeHead(AllToolModules.STONE_PICKAXE_HEAD, AllToolModuleModelIds.STONE_PICKAXE_HEAD, AllToolModuleModelIds.STONE_PICKAXE_HEAD_ITEM);
        registerForPickaxeHead(AllToolModules.IRON_PICKAXE_HEAD, AllToolModuleModelIds.IRON_PICKAXE_HEAD, AllToolModuleModelIds.IRON_PICKAXE_HEAD_ITEM);
        registerForPickaxeHead(AllToolModules.COPPER_PICKAXE_HEAD, AllToolModuleModelIds.COPPER_PICKAXE_HEAD, AllToolModuleModelIds.COPPER_PICKAXE_HEAD_ITEM);
        registerForPickaxeHead(AllToolModules.GOLDEN_PICKAXE_HEAD, AllToolModuleModelIds.GOLDEN_PICKAXE_HEAD, AllToolModuleModelIds.GOLDEN_PICKAXE_HEAD_ITEM);
        registerForPickaxeHead(AllToolModules.NETHERITE_PICKAXE_HEAD, AllToolModuleModelIds.NETHERITE_PICKAXE_HEAD, AllToolModuleModelIds.NETHERITE_PICKAXE_HEAD_ITEM);
        registerForPickaxeHead(AllToolModules.ZINC_PICKAXE_HEAD, AllToolModuleModelIds.ZINC_PICKAXE_HEAD, AllToolModuleModelIds.ZINC_PICKAXE_HEAD_ITEM);
        registerForPickaxeHead(AllToolModules.BRASS_PICKAXE_HEAD, AllToolModuleModelIds.BRASS_PICKAXE_HEAD, AllToolModuleModelIds.BRASS_PICKAXE_HEAD_ITEM);
        registerForPickaxeHead(AllToolModules.DIAMOND_PICKAXE_HEAD, AllToolModuleModelIds.DIAMOND_PICKAXE_HEAD, AllToolModuleModelIds.DIAMOND_PICKAXE_HEAD_ITEM);

        // Axe Heads

        registerForBasicToolModule(AllToolModules.WOODEN_AXE_HEAD, AllToolModuleModelIds.WOODEN_AXE_HEAD);
        registerForBasicToolModule(AllToolModules.OAK_AXE_HEAD, AllToolModuleModelIds.OAK_AXE_HEAD);
        registerForBasicToolModule(AllToolModules.SPRUCE_AXE_HEAD, AllToolModuleModelIds.SPRUCE_AXE_HEAD);
        registerForBasicToolModule(AllToolModules.BIRCH_AXE_HEAD, AllToolModuleModelIds.BIRCH_AXE_HEAD);
        registerForBasicToolModule(AllToolModules.JUNGLE_AXE_HEAD, AllToolModuleModelIds.JUNGLE_AXE_HEAD);
        registerForBasicToolModule(AllToolModules.ACACIA_AXE_HEAD, AllToolModuleModelIds.ACACIA_AXE_HEAD);
        registerForBasicToolModule(AllToolModules.DARK_OAK_AXE_HEAD, AllToolModuleModelIds.DARK_OAK_AXE_HEAD);
        registerForBasicToolModule(AllToolModules.MANGROVE_AXE_HEAD, AllToolModuleModelIds.MANGROVE_AXE_HEAD);
        registerForBasicToolModule(AllToolModules.CHERRY_AXE_HEAD, AllToolModuleModelIds.CHERRY_AXE_HEAD);
        registerForBasicToolModule(AllToolModules.BAMBOO_AXE_HEAD, AllToolModuleModelIds.BAMBOO_AXE_HEAD);
        registerForBasicToolModule(AllToolModules.CRIMSON_AXE_HEAD, AllToolModuleModelIds.CRIMSON_AXE_HEAD);
        registerForBasicToolModule(AllToolModules.WARPED_AXE_HEAD, AllToolModuleModelIds.WARPED_AXE_HEAD);
        registerForBasicToolModule(AllToolModules.STONE_AXE_HEAD, AllToolModuleModelIds.STONE_AXE_HEAD);
        registerForBasicToolModule(AllToolModules.IRON_AXE_HEAD, AllToolModuleModelIds.IRON_AXE_HEAD);
        registerForBasicToolModule(AllToolModules.COPPER_AXE_HEAD, AllToolModuleModelIds.COPPER_AXE_HEAD);
        registerForBasicToolModule(AllToolModules.GOLDEN_AXE_HEAD, AllToolModuleModelIds.GOLDEN_AXE_HEAD);
        registerForBasicToolModule(AllToolModules.NETHERITE_AXE_HEAD, AllToolModuleModelIds.NETHERITE_AXE_HEAD);
        registerForBasicToolModule(AllToolModules.ZINC_AXE_HEAD, AllToolModuleModelIds.ZINC_AXE_HEAD);
        registerForBasicToolModule(AllToolModules.BRASS_AXE_HEAD, AllToolModuleModelIds.BRASS_AXE_HEAD);
        registerForBasicToolModule(AllToolModules.DIAMOND_AXE_HEAD, AllToolModuleModelIds.DIAMOND_AXE_HEAD);

        // Hoe Heads

        registerForBasicToolModule(AllToolModules.WOODEN_HOE_HEAD, AllToolModuleModelIds.WOODEN_HOE_HEAD);
        registerForBasicToolModule(AllToolModules.OAK_HOE_HEAD, AllToolModuleModelIds.OAK_HOE_HEAD);
        registerForBasicToolModule(AllToolModules.SPRUCE_HOE_HEAD, AllToolModuleModelIds.SPRUCE_HOE_HEAD);
        registerForBasicToolModule(AllToolModules.BIRCH_HOE_HEAD, AllToolModuleModelIds.BIRCH_HOE_HEAD);
        registerForBasicToolModule(AllToolModules.JUNGLE_HOE_HEAD, AllToolModuleModelIds.JUNGLE_HOE_HEAD);
        registerForBasicToolModule(AllToolModules.ACACIA_HOE_HEAD, AllToolModuleModelIds.ACACIA_HOE_HEAD);
        registerForBasicToolModule(AllToolModules.DARK_OAK_HOE_HEAD, AllToolModuleModelIds.DARK_OAK_HOE_HEAD);
        registerForBasicToolModule(AllToolModules.MANGROVE_HOE_HEAD, AllToolModuleModelIds.MANGROVE_HOE_HEAD);
        registerForBasicToolModule(AllToolModules.CHERRY_HOE_HEAD, AllToolModuleModelIds.CHERRY_HOE_HEAD);
        registerForBasicToolModule(AllToolModules.BAMBOO_HOE_HEAD, AllToolModuleModelIds.BAMBOO_HOE_HEAD);
        registerForBasicToolModule(AllToolModules.CRIMSON_HOE_HEAD, AllToolModuleModelIds.CRIMSON_HOE_HEAD);
        registerForBasicToolModule(AllToolModules.WARPED_HOE_HEAD, AllToolModuleModelIds.WARPED_HOE_HEAD);
        registerForBasicToolModule(AllToolModules.STONE_HOE_HEAD, AllToolModuleModelIds.STONE_HOE_HEAD);
        registerForBasicToolModule(AllToolModules.IRON_HOE_HEAD, AllToolModuleModelIds.IRON_HOE_HEAD);
        registerForBasicToolModule(AllToolModules.COPPER_HOE_HEAD, AllToolModuleModelIds.COPPER_HOE_HEAD);
        registerForBasicToolModule(AllToolModules.GOLDEN_HOE_HEAD, AllToolModuleModelIds.GOLDEN_HOE_HEAD);
        registerForBasicToolModule(AllToolModules.NETHERITE_HOE_HEAD, AllToolModuleModelIds.NETHERITE_HOE_HEAD);
        registerForBasicToolModule(AllToolModules.ZINC_HOE_HEAD, AllToolModuleModelIds.ZINC_HOE_HEAD);
        registerForBasicToolModule(AllToolModules.BRASS_HOE_HEAD, AllToolModuleModelIds.BRASS_HOE_HEAD);
        registerForBasicToolModule(AllToolModules.DIAMOND_HOE_HEAD, AllToolModuleModelIds.DIAMOND_HOE_HEAD);

        // Tool Handles

        registerForToolHandle(AllToolModules.WOODEN_TOOL_HANDLE, AllToolModuleModelIds.WOODEN_SWORD_HANDLE, AllToolModuleModelIds.WOODEN_POMMEL_SWORD_HANDLE, AllToolModuleModelIds.WOODEN_WRAP_SWORD_HANDLE, AllToolModuleModelIds.WOODEN_POMMEL_WRAP_SWORD_HANDLE, AllToolModuleModelIds.WOODEN_SHOVEL_HANDLE, AllToolModuleModelIds.WOODEN_GRIP_SHOVEL_HANDLE, AllToolModuleModelIds.WOODEN_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.WOODEN_GRIP_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.WOODEN_PICKAXE_HANDLE, AllToolModuleModelIds.WOODEN_GRIP_PICKAXE_HANDLE, AllToolModuleModelIds.WOODEN_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.WOODEN_GRIP_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.WOODEN_AXE_HANDLE, AllToolModuleModelIds.WOODEN_GRIP_AXE_HANDLE, AllToolModuleModelIds.WOODEN_WRAP_AXE_HANDLE, AllToolModuleModelIds.WOODEN_GRIP_WRAP_AXE_HANDLE, AllToolModuleModelIds.WOODEN_HOE_HANDLE, AllToolModuleModelIds.WOODEN_GRIP_HOE_HANDLE, AllToolModuleModelIds.WOODEN_WRAP_HOE_HANDLE, AllToolModuleModelIds.WOODEN_GRIP_WRAP_HOE_HANDLE);
        registerForToolHandle(AllToolModules.OAK_TOOL_HANDLE, AllToolModuleModelIds.OAK_SWORD_HANDLE, AllToolModuleModelIds.OAK_POMMEL_SWORD_HANDLE, AllToolModuleModelIds.OAK_WRAP_SWORD_HANDLE, AllToolModuleModelIds.OAK_POMMEL_WRAP_SWORD_HANDLE, AllToolModuleModelIds.OAK_SHOVEL_HANDLE, AllToolModuleModelIds.OAK_GRIP_SHOVEL_HANDLE, AllToolModuleModelIds.OAK_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.OAK_GRIP_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.OAK_PICKAXE_HANDLE, AllToolModuleModelIds.OAK_GRIP_PICKAXE_HANDLE, AllToolModuleModelIds.OAK_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.OAK_GRIP_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.OAK_AXE_HANDLE, AllToolModuleModelIds.OAK_GRIP_AXE_HANDLE, AllToolModuleModelIds.OAK_WRAP_AXE_HANDLE, AllToolModuleModelIds.OAK_GRIP_WRAP_AXE_HANDLE, AllToolModuleModelIds.OAK_HOE_HANDLE, AllToolModuleModelIds.OAK_GRIP_HOE_HANDLE, AllToolModuleModelIds.OAK_WRAP_HOE_HANDLE, AllToolModuleModelIds.OAK_GRIP_WRAP_HOE_HANDLE);
        registerForToolHandle(AllToolModules.SPRUCE_TOOL_HANDLE, AllToolModuleModelIds.SPRUCE_SWORD_HANDLE, AllToolModuleModelIds.SPRUCE_POMMEL_SWORD_HANDLE, AllToolModuleModelIds.SPRUCE_WRAP_SWORD_HANDLE, AllToolModuleModelIds.SPRUCE_POMMEL_WRAP_SWORD_HANDLE, AllToolModuleModelIds.SPRUCE_SHOVEL_HANDLE, AllToolModuleModelIds.SPRUCE_GRIP_SHOVEL_HANDLE, AllToolModuleModelIds.SPRUCE_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.SPRUCE_GRIP_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.SPRUCE_PICKAXE_HANDLE, AllToolModuleModelIds.SPRUCE_GRIP_PICKAXE_HANDLE, AllToolModuleModelIds.SPRUCE_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.SPRUCE_GRIP_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.SPRUCE_AXE_HANDLE, AllToolModuleModelIds.SPRUCE_GRIP_AXE_HANDLE, AllToolModuleModelIds.SPRUCE_WRAP_AXE_HANDLE, AllToolModuleModelIds.SPRUCE_GRIP_WRAP_AXE_HANDLE, AllToolModuleModelIds.SPRUCE_HOE_HANDLE, AllToolModuleModelIds.SPRUCE_GRIP_HOE_HANDLE, AllToolModuleModelIds.SPRUCE_WRAP_HOE_HANDLE, AllToolModuleModelIds.SPRUCE_GRIP_WRAP_HOE_HANDLE);
        registerForToolHandle(AllToolModules.BIRCH_TOOL_HANDLE, AllToolModuleModelIds.BIRCH_SWORD_HANDLE, AllToolModuleModelIds.BIRCH_POMMEL_SWORD_HANDLE, AllToolModuleModelIds.BIRCH_WRAP_SWORD_HANDLE, AllToolModuleModelIds.BIRCH_POMMEL_WRAP_SWORD_HANDLE, AllToolModuleModelIds.BIRCH_SHOVEL_HANDLE, AllToolModuleModelIds.BIRCH_GRIP_SHOVEL_HANDLE, AllToolModuleModelIds.BIRCH_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.BIRCH_GRIP_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.BIRCH_PICKAXE_HANDLE, AllToolModuleModelIds.BIRCH_GRIP_PICKAXE_HANDLE, AllToolModuleModelIds.BIRCH_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.BIRCH_GRIP_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.BIRCH_AXE_HANDLE, AllToolModuleModelIds.BIRCH_GRIP_AXE_HANDLE, AllToolModuleModelIds.BIRCH_WRAP_AXE_HANDLE, AllToolModuleModelIds.BIRCH_GRIP_WRAP_AXE_HANDLE, AllToolModuleModelIds.BIRCH_HOE_HANDLE, AllToolModuleModelIds.BIRCH_GRIP_HOE_HANDLE, AllToolModuleModelIds.BIRCH_WRAP_HOE_HANDLE, AllToolModuleModelIds.BIRCH_GRIP_WRAP_HOE_HANDLE);
        registerForToolHandle(AllToolModules.JUNGLE_TOOL_HANDLE, AllToolModuleModelIds.JUNGLE_SWORD_HANDLE, AllToolModuleModelIds.JUNGLE_POMMEL_SWORD_HANDLE, AllToolModuleModelIds.JUNGLE_WRAP_SWORD_HANDLE, AllToolModuleModelIds.JUNGLE_POMMEL_WRAP_SWORD_HANDLE, AllToolModuleModelIds.JUNGLE_SHOVEL_HANDLE, AllToolModuleModelIds.JUNGLE_GRIP_SHOVEL_HANDLE, AllToolModuleModelIds.JUNGLE_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.JUNGLE_GRIP_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.JUNGLE_PICKAXE_HANDLE, AllToolModuleModelIds.JUNGLE_GRIP_PICKAXE_HANDLE, AllToolModuleModelIds.JUNGLE_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.JUNGLE_GRIP_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.JUNGLE_AXE_HANDLE, AllToolModuleModelIds.JUNGLE_GRIP_AXE_HANDLE, AllToolModuleModelIds.JUNGLE_WRAP_AXE_HANDLE, AllToolModuleModelIds.JUNGLE_GRIP_WRAP_AXE_HANDLE, AllToolModuleModelIds.JUNGLE_HOE_HANDLE, AllToolModuleModelIds.JUNGLE_GRIP_HOE_HANDLE, AllToolModuleModelIds.JUNGLE_WRAP_HOE_HANDLE, AllToolModuleModelIds.JUNGLE_GRIP_WRAP_HOE_HANDLE);
        registerForToolHandle(AllToolModules.ACACIA_TOOL_HANDLE, AllToolModuleModelIds.ACACIA_SWORD_HANDLE, AllToolModuleModelIds.ACACIA_POMMEL_SWORD_HANDLE, AllToolModuleModelIds.ACACIA_WRAP_SWORD_HANDLE, AllToolModuleModelIds.ACACIA_POMMEL_WRAP_SWORD_HANDLE, AllToolModuleModelIds.ACACIA_SHOVEL_HANDLE, AllToolModuleModelIds.ACACIA_GRIP_SHOVEL_HANDLE, AllToolModuleModelIds.ACACIA_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.ACACIA_GRIP_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.ACACIA_PICKAXE_HANDLE, AllToolModuleModelIds.ACACIA_GRIP_PICKAXE_HANDLE, AllToolModuleModelIds.ACACIA_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.ACACIA_GRIP_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.ACACIA_AXE_HANDLE, AllToolModuleModelIds.ACACIA_GRIP_AXE_HANDLE, AllToolModuleModelIds.ACACIA_WRAP_AXE_HANDLE, AllToolModuleModelIds.ACACIA_GRIP_WRAP_AXE_HANDLE, AllToolModuleModelIds.ACACIA_HOE_HANDLE, AllToolModuleModelIds.ACACIA_GRIP_HOE_HANDLE, AllToolModuleModelIds.ACACIA_WRAP_HOE_HANDLE, AllToolModuleModelIds.ACACIA_GRIP_WRAP_HOE_HANDLE);
        registerForToolHandle(AllToolModules.DARK_OAK_TOOL_HANDLE, AllToolModuleModelIds.DARK_OAK_SWORD_HANDLE, AllToolModuleModelIds.DARK_OAK_POMMEL_SWORD_HANDLE, AllToolModuleModelIds.DARK_OAK_WRAP_SWORD_HANDLE, AllToolModuleModelIds.DARK_OAK_POMMEL_WRAP_SWORD_HANDLE, AllToolModuleModelIds.DARK_OAK_SHOVEL_HANDLE, AllToolModuleModelIds.DARK_OAK_GRIP_SHOVEL_HANDLE, AllToolModuleModelIds.DARK_OAK_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.DARK_OAK_GRIP_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.DARK_OAK_PICKAXE_HANDLE, AllToolModuleModelIds.DARK_OAK_GRIP_PICKAXE_HANDLE, AllToolModuleModelIds.DARK_OAK_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.DARK_OAK_GRIP_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.DARK_OAK_AXE_HANDLE, AllToolModuleModelIds.DARK_OAK_GRIP_AXE_HANDLE, AllToolModuleModelIds.DARK_OAK_WRAP_AXE_HANDLE, AllToolModuleModelIds.DARK_OAK_GRIP_WRAP_AXE_HANDLE, AllToolModuleModelIds.DARK_OAK_HOE_HANDLE, AllToolModuleModelIds.DARK_OAK_GRIP_HOE_HANDLE, AllToolModuleModelIds.DARK_OAK_WRAP_HOE_HANDLE, AllToolModuleModelIds.DARK_OAK_GRIP_WRAP_HOE_HANDLE);
        registerForToolHandle(AllToolModules.MANGROVE_TOOL_HANDLE, AllToolModuleModelIds.MANGROVE_SWORD_HANDLE, AllToolModuleModelIds.MANGROVE_POMMEL_SWORD_HANDLE, AllToolModuleModelIds.MANGROVE_WRAP_SWORD_HANDLE, AllToolModuleModelIds.MANGROVE_POMMEL_WRAP_SWORD_HANDLE, AllToolModuleModelIds.MANGROVE_SHOVEL_HANDLE, AllToolModuleModelIds.MANGROVE_GRIP_SHOVEL_HANDLE, AllToolModuleModelIds.MANGROVE_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.MANGROVE_GRIP_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.MANGROVE_PICKAXE_HANDLE, AllToolModuleModelIds.MANGROVE_GRIP_PICKAXE_HANDLE, AllToolModuleModelIds.MANGROVE_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.MANGROVE_GRIP_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.MANGROVE_AXE_HANDLE, AllToolModuleModelIds.MANGROVE_GRIP_AXE_HANDLE, AllToolModuleModelIds.MANGROVE_WRAP_AXE_HANDLE, AllToolModuleModelIds.MANGROVE_GRIP_WRAP_AXE_HANDLE, AllToolModuleModelIds.MANGROVE_HOE_HANDLE, AllToolModuleModelIds.MANGROVE_GRIP_HOE_HANDLE, AllToolModuleModelIds.MANGROVE_WRAP_HOE_HANDLE, AllToolModuleModelIds.MANGROVE_GRIP_WRAP_HOE_HANDLE);
        registerForToolHandle(AllToolModules.CHERRY_TOOL_HANDLE, AllToolModuleModelIds.CHERRY_SWORD_HANDLE, AllToolModuleModelIds.CHERRY_POMMEL_SWORD_HANDLE, AllToolModuleModelIds.CHERRY_WRAP_SWORD_HANDLE, AllToolModuleModelIds.CHERRY_POMMEL_WRAP_SWORD_HANDLE, AllToolModuleModelIds.CHERRY_SHOVEL_HANDLE, AllToolModuleModelIds.CHERRY_GRIP_SHOVEL_HANDLE, AllToolModuleModelIds.CHERRY_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.CHERRY_GRIP_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.CHERRY_PICKAXE_HANDLE, AllToolModuleModelIds.CHERRY_GRIP_PICKAXE_HANDLE, AllToolModuleModelIds.CHERRY_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.CHERRY_GRIP_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.CHERRY_AXE_HANDLE, AllToolModuleModelIds.CHERRY_GRIP_AXE_HANDLE, AllToolModuleModelIds.CHERRY_WRAP_AXE_HANDLE, AllToolModuleModelIds.CHERRY_GRIP_WRAP_AXE_HANDLE, AllToolModuleModelIds.CHERRY_HOE_HANDLE, AllToolModuleModelIds.CHERRY_GRIP_HOE_HANDLE, AllToolModuleModelIds.CHERRY_WRAP_HOE_HANDLE, AllToolModuleModelIds.CHERRY_GRIP_WRAP_HOE_HANDLE);
        registerForToolHandle(AllToolModules.BAMBOO_TOOL_HANDLE, AllToolModuleModelIds.BAMBOO_SWORD_HANDLE, AllToolModuleModelIds.BAMBOO_POMMEL_SWORD_HANDLE, AllToolModuleModelIds.BAMBOO_WRAP_SWORD_HANDLE, AllToolModuleModelIds.BAMBOO_POMMEL_WRAP_SWORD_HANDLE, AllToolModuleModelIds.BAMBOO_SHOVEL_HANDLE, AllToolModuleModelIds.BAMBOO_GRIP_SHOVEL_HANDLE, AllToolModuleModelIds.BAMBOO_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.BAMBOO_GRIP_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.BAMBOO_PICKAXE_HANDLE, AllToolModuleModelIds.BAMBOO_GRIP_PICKAXE_HANDLE, AllToolModuleModelIds.BAMBOO_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.BAMBOO_GRIP_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.BAMBOO_AXE_HANDLE, AllToolModuleModelIds.BAMBOO_GRIP_AXE_HANDLE, AllToolModuleModelIds.BAMBOO_WRAP_AXE_HANDLE, AllToolModuleModelIds.BAMBOO_GRIP_WRAP_AXE_HANDLE, AllToolModuleModelIds.BAMBOO_HOE_HANDLE, AllToolModuleModelIds.BAMBOO_GRIP_HOE_HANDLE, AllToolModuleModelIds.BAMBOO_WRAP_HOE_HANDLE, AllToolModuleModelIds.BAMBOO_GRIP_WRAP_HOE_HANDLE);
        registerForToolHandle(AllToolModules.CRIMSON_TOOL_HANDLE, AllToolModuleModelIds.CRIMSON_SWORD_HANDLE, AllToolModuleModelIds.CRIMSON_POMMEL_SWORD_HANDLE, AllToolModuleModelIds.CRIMSON_WRAP_SWORD_HANDLE, AllToolModuleModelIds.CRIMSON_POMMEL_WRAP_SWORD_HANDLE, AllToolModuleModelIds.CRIMSON_SHOVEL_HANDLE, AllToolModuleModelIds.CRIMSON_GRIP_SHOVEL_HANDLE, AllToolModuleModelIds.CRIMSON_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.CRIMSON_GRIP_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.CRIMSON_PICKAXE_HANDLE, AllToolModuleModelIds.CRIMSON_GRIP_PICKAXE_HANDLE, AllToolModuleModelIds.CRIMSON_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.CRIMSON_GRIP_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.CRIMSON_AXE_HANDLE, AllToolModuleModelIds.CRIMSON_GRIP_AXE_HANDLE, AllToolModuleModelIds.CRIMSON_WRAP_AXE_HANDLE, AllToolModuleModelIds.CRIMSON_GRIP_WRAP_AXE_HANDLE, AllToolModuleModelIds.CRIMSON_HOE_HANDLE, AllToolModuleModelIds.CRIMSON_GRIP_HOE_HANDLE, AllToolModuleModelIds.CRIMSON_WRAP_HOE_HANDLE, AllToolModuleModelIds.CRIMSON_GRIP_WRAP_HOE_HANDLE);
        registerForToolHandle(AllToolModules.WARPED_TOOL_HANDLE, AllToolModuleModelIds.WARPED_SWORD_HANDLE, AllToolModuleModelIds.WARPED_POMMEL_SWORD_HANDLE, AllToolModuleModelIds.WARPED_WRAP_SWORD_HANDLE, AllToolModuleModelIds.WARPED_POMMEL_WRAP_SWORD_HANDLE, AllToolModuleModelIds.WARPED_SHOVEL_HANDLE, AllToolModuleModelIds.WARPED_GRIP_SHOVEL_HANDLE, AllToolModuleModelIds.WARPED_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.WARPED_GRIP_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.WARPED_PICKAXE_HANDLE, AllToolModuleModelIds.WARPED_GRIP_PICKAXE_HANDLE, AllToolModuleModelIds.WARPED_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.WARPED_GRIP_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.WARPED_AXE_HANDLE, AllToolModuleModelIds.WARPED_GRIP_AXE_HANDLE, AllToolModuleModelIds.WARPED_WRAP_AXE_HANDLE, AllToolModuleModelIds.WARPED_GRIP_WRAP_AXE_HANDLE, AllToolModuleModelIds.WARPED_HOE_HANDLE, AllToolModuleModelIds.WARPED_GRIP_HOE_HANDLE, AllToolModuleModelIds.WARPED_WRAP_HOE_HANDLE, AllToolModuleModelIds.WARPED_GRIP_WRAP_HOE_HANDLE);
        registerForToolHandle(AllToolModules.STONE_TOOL_HANDLE, AllToolModuleModelIds.STONE_SWORD_HANDLE, AllToolModuleModelIds.STONE_POMMEL_SWORD_HANDLE, AllToolModuleModelIds.STONE_WRAP_SWORD_HANDLE, AllToolModuleModelIds.STONE_POMMEL_WRAP_SWORD_HANDLE, AllToolModuleModelIds.STONE_SHOVEL_HANDLE, AllToolModuleModelIds.STONE_GRIP_SHOVEL_HANDLE, AllToolModuleModelIds.STONE_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.STONE_GRIP_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.STONE_PICKAXE_HANDLE, AllToolModuleModelIds.STONE_GRIP_PICKAXE_HANDLE, AllToolModuleModelIds.STONE_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.STONE_GRIP_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.STONE_AXE_HANDLE, AllToolModuleModelIds.STONE_GRIP_AXE_HANDLE, AllToolModuleModelIds.STONE_WRAP_AXE_HANDLE, AllToolModuleModelIds.STONE_GRIP_WRAP_AXE_HANDLE, AllToolModuleModelIds.STONE_HOE_HANDLE, AllToolModuleModelIds.STONE_GRIP_HOE_HANDLE, AllToolModuleModelIds.STONE_WRAP_HOE_HANDLE, AllToolModuleModelIds.STONE_GRIP_WRAP_HOE_HANDLE);
        registerForToolHandle(AllToolModules.IRON_TOOL_HANDLE, AllToolModuleModelIds.IRON_SWORD_HANDLE, AllToolModuleModelIds.IRON_POMMEL_SWORD_HANDLE, AllToolModuleModelIds.IRON_WRAP_SWORD_HANDLE, AllToolModuleModelIds.IRON_POMMEL_WRAP_SWORD_HANDLE, AllToolModuleModelIds.IRON_SHOVEL_HANDLE, AllToolModuleModelIds.IRON_GRIP_SHOVEL_HANDLE, AllToolModuleModelIds.IRON_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.IRON_GRIP_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.IRON_PICKAXE_HANDLE, AllToolModuleModelIds.IRON_GRIP_PICKAXE_HANDLE, AllToolModuleModelIds.IRON_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.IRON_GRIP_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.IRON_AXE_HANDLE, AllToolModuleModelIds.IRON_GRIP_AXE_HANDLE, AllToolModuleModelIds.IRON_WRAP_AXE_HANDLE, AllToolModuleModelIds.IRON_GRIP_WRAP_AXE_HANDLE, AllToolModuleModelIds.IRON_HOE_HANDLE, AllToolModuleModelIds.IRON_GRIP_HOE_HANDLE, AllToolModuleModelIds.IRON_WRAP_HOE_HANDLE, AllToolModuleModelIds.IRON_GRIP_WRAP_HOE_HANDLE);
        registerForToolHandle(AllToolModules.COPPER_TOOL_HANDLE, AllToolModuleModelIds.COPPER_SWORD_HANDLE, AllToolModuleModelIds.COPPER_POMMEL_SWORD_HANDLE, AllToolModuleModelIds.COPPER_WRAP_SWORD_HANDLE, AllToolModuleModelIds.COPPER_POMMEL_WRAP_SWORD_HANDLE, AllToolModuleModelIds.COPPER_SHOVEL_HANDLE, AllToolModuleModelIds.COPPER_GRIP_SHOVEL_HANDLE, AllToolModuleModelIds.COPPER_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.COPPER_GRIP_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.COPPER_PICKAXE_HANDLE, AllToolModuleModelIds.COPPER_GRIP_PICKAXE_HANDLE, AllToolModuleModelIds.COPPER_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.COPPER_GRIP_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.COPPER_AXE_HANDLE, AllToolModuleModelIds.COPPER_GRIP_AXE_HANDLE, AllToolModuleModelIds.COPPER_WRAP_AXE_HANDLE, AllToolModuleModelIds.COPPER_GRIP_WRAP_AXE_HANDLE, AllToolModuleModelIds.COPPER_HOE_HANDLE, AllToolModuleModelIds.COPPER_GRIP_HOE_HANDLE, AllToolModuleModelIds.COPPER_WRAP_HOE_HANDLE, AllToolModuleModelIds.COPPER_GRIP_WRAP_HOE_HANDLE);
        registerForToolHandle(AllToolModules.GOLDEN_TOOL_HANDLE, AllToolModuleModelIds.GOLDEN_SWORD_HANDLE, AllToolModuleModelIds.GOLDEN_POMMEL_SWORD_HANDLE, AllToolModuleModelIds.GOLDEN_WRAP_SWORD_HANDLE, AllToolModuleModelIds.GOLDEN_POMMEL_WRAP_SWORD_HANDLE, AllToolModuleModelIds.GOLDEN_SHOVEL_HANDLE, AllToolModuleModelIds.GOLDEN_GRIP_SHOVEL_HANDLE, AllToolModuleModelIds.GOLDEN_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.GOLDEN_GRIP_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.GOLDEN_PICKAXE_HANDLE, AllToolModuleModelIds.GOLDEN_GRIP_PICKAXE_HANDLE, AllToolModuleModelIds.GOLDEN_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.GOLDEN_GRIP_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.GOLDEN_AXE_HANDLE, AllToolModuleModelIds.GOLDEN_GRIP_AXE_HANDLE, AllToolModuleModelIds.GOLDEN_WRAP_AXE_HANDLE, AllToolModuleModelIds.GOLDEN_GRIP_WRAP_AXE_HANDLE, AllToolModuleModelIds.GOLDEN_HOE_HANDLE, AllToolModuleModelIds.GOLDEN_GRIP_HOE_HANDLE, AllToolModuleModelIds.GOLDEN_WRAP_HOE_HANDLE, AllToolModuleModelIds.GOLDEN_GRIP_WRAP_HOE_HANDLE);
        registerForToolHandle(AllToolModules.NETHERITE_TOOL_HANDLE, AllToolModuleModelIds.NETHERITE_SWORD_HANDLE, AllToolModuleModelIds.NETHERITE_POMMEL_SWORD_HANDLE, AllToolModuleModelIds.NETHERITE_WRAP_SWORD_HANDLE, AllToolModuleModelIds.NETHERITE_POMMEL_WRAP_SWORD_HANDLE, AllToolModuleModelIds.NETHERITE_SHOVEL_HANDLE, AllToolModuleModelIds.NETHERITE_GRIP_SHOVEL_HANDLE, AllToolModuleModelIds.NETHERITE_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.NETHERITE_GRIP_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.NETHERITE_PICKAXE_HANDLE, AllToolModuleModelIds.NETHERITE_GRIP_PICKAXE_HANDLE, AllToolModuleModelIds.NETHERITE_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.NETHERITE_GRIP_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.NETHERITE_AXE_HANDLE, AllToolModuleModelIds.NETHERITE_GRIP_AXE_HANDLE, AllToolModuleModelIds.NETHERITE_WRAP_AXE_HANDLE, AllToolModuleModelIds.NETHERITE_GRIP_WRAP_AXE_HANDLE, AllToolModuleModelIds.NETHERITE_HOE_HANDLE, AllToolModuleModelIds.NETHERITE_GRIP_HOE_HANDLE, AllToolModuleModelIds.NETHERITE_WRAP_HOE_HANDLE, AllToolModuleModelIds.NETHERITE_GRIP_WRAP_HOE_HANDLE);
        registerForToolHandle(AllToolModules.ZINC_TOOL_HANDLE, AllToolModuleModelIds.ZINC_SWORD_HANDLE, AllToolModuleModelIds.ZINC_POMMEL_SWORD_HANDLE, AllToolModuleModelIds.ZINC_WRAP_SWORD_HANDLE, AllToolModuleModelIds.ZINC_POMMEL_WRAP_SWORD_HANDLE, AllToolModuleModelIds.ZINC_SHOVEL_HANDLE, AllToolModuleModelIds.ZINC_GRIP_SHOVEL_HANDLE, AllToolModuleModelIds.ZINC_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.ZINC_GRIP_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.ZINC_PICKAXE_HANDLE, AllToolModuleModelIds.ZINC_GRIP_PICKAXE_HANDLE, AllToolModuleModelIds.ZINC_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.ZINC_GRIP_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.ZINC_AXE_HANDLE, AllToolModuleModelIds.ZINC_GRIP_AXE_HANDLE, AllToolModuleModelIds.ZINC_WRAP_AXE_HANDLE, AllToolModuleModelIds.ZINC_GRIP_WRAP_AXE_HANDLE, AllToolModuleModelIds.ZINC_HOE_HANDLE, AllToolModuleModelIds.ZINC_GRIP_HOE_HANDLE, AllToolModuleModelIds.ZINC_WRAP_HOE_HANDLE, AllToolModuleModelIds.ZINC_GRIP_WRAP_HOE_HANDLE);
        registerForToolHandle(AllToolModules.BRASS_TOOL_HANDLE, AllToolModuleModelIds.BRASS_SWORD_HANDLE, AllToolModuleModelIds.BRASS_POMMEL_SWORD_HANDLE, AllToolModuleModelIds.BRASS_WRAP_SWORD_HANDLE, AllToolModuleModelIds.BRASS_POMMEL_WRAP_SWORD_HANDLE, AllToolModuleModelIds.BRASS_SHOVEL_HANDLE, AllToolModuleModelIds.BRASS_GRIP_SHOVEL_HANDLE, AllToolModuleModelIds.BRASS_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.BRASS_GRIP_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.BRASS_PICKAXE_HANDLE, AllToolModuleModelIds.BRASS_GRIP_PICKAXE_HANDLE, AllToolModuleModelIds.BRASS_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.BRASS_GRIP_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.BRASS_AXE_HANDLE, AllToolModuleModelIds.BRASS_GRIP_AXE_HANDLE, AllToolModuleModelIds.BRASS_WRAP_AXE_HANDLE, AllToolModuleModelIds.BRASS_GRIP_WRAP_AXE_HANDLE, AllToolModuleModelIds.BRASS_HOE_HANDLE, AllToolModuleModelIds.BRASS_GRIP_HOE_HANDLE, AllToolModuleModelIds.BRASS_WRAP_HOE_HANDLE, AllToolModuleModelIds.BRASS_GRIP_WRAP_HOE_HANDLE);
        registerForToolHandle(AllToolModules.DIAMOND_TOOL_HANDLE, AllToolModuleModelIds.DIAMOND_SWORD_HANDLE, AllToolModuleModelIds.DIAMOND_POMMEL_SWORD_HANDLE, AllToolModuleModelIds.DIAMOND_WRAP_SWORD_HANDLE, AllToolModuleModelIds.DIAMOND_POMMEL_WRAP_SWORD_HANDLE, AllToolModuleModelIds.DIAMOND_SHOVEL_HANDLE, AllToolModuleModelIds.DIAMOND_GRIP_SHOVEL_HANDLE, AllToolModuleModelIds.DIAMOND_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.DIAMOND_GRIP_WRAP_SHOVEL_HANDLE, AllToolModuleModelIds.DIAMOND_PICKAXE_HANDLE, AllToolModuleModelIds.DIAMOND_GRIP_PICKAXE_HANDLE, AllToolModuleModelIds.DIAMOND_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.DIAMOND_GRIP_WRAP_PICKAXE_HANDLE, AllToolModuleModelIds.DIAMOND_AXE_HANDLE, AllToolModuleModelIds.DIAMOND_GRIP_AXE_HANDLE, AllToolModuleModelIds.DIAMOND_WRAP_AXE_HANDLE, AllToolModuleModelIds.DIAMOND_GRIP_WRAP_AXE_HANDLE, AllToolModuleModelIds.DIAMOND_HOE_HANDLE, AllToolModuleModelIds.DIAMOND_GRIP_HOE_HANDLE, AllToolModuleModelIds.DIAMOND_WRAP_HOE_HANDLE, AllToolModuleModelIds.DIAMOND_GRIP_WRAP_HOE_HANDLE);

        // Tool Grips

        registerForBasicToolModule(AllToolModules.WOODEN_TOOL_GRIP, AllToolModuleModelIds.WOODEN_GRIP);
        registerForBasicToolModule(AllToolModules.OAK_TOOL_GRIP, AllToolModuleModelIds.OAK_GRIP);
        registerForBasicToolModule(AllToolModules.SPRUCE_TOOL_GRIP, AllToolModuleModelIds.SPRUCE_GRIP);
        registerForBasicToolModule(AllToolModules.BIRCH_TOOL_GRIP, AllToolModuleModelIds.BIRCH_GRIP);
        registerForBasicToolModule(AllToolModules.JUNGLE_TOOL_GRIP, AllToolModuleModelIds.JUNGLE_GRIP);
        registerForBasicToolModule(AllToolModules.ACACIA_TOOL_GRIP, AllToolModuleModelIds.ACACIA_GRIP);
        registerForBasicToolModule(AllToolModules.DARK_OAK_TOOL_GRIP, AllToolModuleModelIds.DARK_OAK_GRIP);
        registerForBasicToolModule(AllToolModules.MANGROVE_TOOL_GRIP, AllToolModuleModelIds.MANGROVE_GRIP);
        registerForBasicToolModule(AllToolModules.CHERRY_TOOL_GRIP, AllToolModuleModelIds.CHERRY_GRIP);
        registerForBasicToolModule(AllToolModules.BAMBOO_TOOL_GRIP, AllToolModuleModelIds.BAMBOO_GRIP);
        registerForBasicToolModule(AllToolModules.CRIMSON_TOOL_GRIP, AllToolModuleModelIds.CRIMSON_GRIP);
        registerForBasicToolModule(AllToolModules.WARPED_TOOL_GRIP, AllToolModuleModelIds.WARPED_GRIP);
        registerForBasicToolModule(AllToolModules.STONE_TOOL_GRIP, AllToolModuleModelIds.STONE_GRIP);
        registerForBasicToolModule(AllToolModules.IRON_TOOL_GRIP, AllToolModuleModelIds.IRON_GRIP);
        registerForBasicToolModule(AllToolModules.COPPER_TOOL_GRIP, AllToolModuleModelIds.COPPER_GRIP);
        registerForBasicToolModule(AllToolModules.GOLDEN_TOOL_GRIP, AllToolModuleModelIds.GOLDEN_GRIP);
        registerForBasicToolModule(AllToolModules.NETHERITE_TOOL_GRIP, AllToolModuleModelIds.NETHERITE_GRIP);
        registerForBasicToolModule(AllToolModules.ZINC_TOOL_GRIP, AllToolModuleModelIds.ZINC_GRIP);
        registerForBasicToolModule(AllToolModules.BRASS_TOOL_GRIP, AllToolModuleModelIds.BRASS_GRIP);
        registerForBasicToolModule(AllToolModules.DIAMOND_TOOL_GRIP, AllToolModuleModelIds.DIAMOND_GRIP);

        // Sword Guards

        registerForBasicToolModule(AllToolModules.WOODEN_SWORD_GUARD, AllToolModuleModelIds.WOODEN_GUARD);
        registerForBasicToolModule(AllToolModules.OAK_SWORD_GUARD, AllToolModuleModelIds.OAK_GUARD);
        registerForBasicToolModule(AllToolModules.SPRUCE_SWORD_GUARD, AllToolModuleModelIds.SPRUCE_GUARD);
        registerForBasicToolModule(AllToolModules.BIRCH_SWORD_GUARD, AllToolModuleModelIds.BIRCH_GUARD);
        registerForBasicToolModule(AllToolModules.JUNGLE_SWORD_GUARD, AllToolModuleModelIds.JUNGLE_GUARD);
        registerForBasicToolModule(AllToolModules.ACACIA_SWORD_GUARD, AllToolModuleModelIds.ACACIA_GUARD);
        registerForBasicToolModule(AllToolModules.DARK_OAK_SWORD_GUARD, AllToolModuleModelIds.DARK_OAK_GUARD);
        registerForBasicToolModule(AllToolModules.MANGROVE_SWORD_GUARD, AllToolModuleModelIds.MANGROVE_GUARD);
        registerForBasicToolModule(AllToolModules.CHERRY_SWORD_GUARD, AllToolModuleModelIds.CHERRY_GUARD);
        registerForBasicToolModule(AllToolModules.BAMBOO_SWORD_GUARD, AllToolModuleModelIds.BAMBOO_GUARD);
        registerForBasicToolModule(AllToolModules.CRIMSON_SWORD_GUARD, AllToolModuleModelIds.CRIMSON_GUARD);
        registerForBasicToolModule(AllToolModules.WARPED_SWORD_GUARD, AllToolModuleModelIds.WARPED_GUARD);
        registerForBasicToolModule(AllToolModules.STONE_SWORD_GUARD, AllToolModuleModelIds.STONE_GUARD);
        registerForBasicToolModule(AllToolModules.IRON_SWORD_GUARD, AllToolModuleModelIds.IRON_GUARD);
        registerForBasicToolModule(AllToolModules.COPPER_SWORD_GUARD, AllToolModuleModelIds.COPPER_GUARD);
        registerForBasicToolModule(AllToolModules.GOLDEN_SWORD_GUARD, AllToolModuleModelIds.GOLDEN_GUARD);
        registerForBasicToolModule(AllToolModules.NETHERITE_SWORD_GUARD, AllToolModuleModelIds.NETHERITE_GUARD);
        registerForBasicToolModule(AllToolModules.ZINC_SWORD_GUARD, AllToolModuleModelIds.ZINC_GUARD);
        registerForBasicToolModule(AllToolModules.BRASS_SWORD_GUARD, AllToolModuleModelIds.BRASS_GUARD);
        registerForBasicToolModule(AllToolModules.DIAMOND_SWORD_GUARD, AllToolModuleModelIds.DIAMOND_GUARD);

        // Sword Pommels

        registerForBasicToolModule(AllToolModules.WOODEN_SWORD_POMMEL, AllToolModuleModelIds.WOODEN_POMMEL);
        registerForBasicToolModule(AllToolModules.OAK_SWORD_POMMEL, AllToolModuleModelIds.OAK_POMMEL);
        registerForBasicToolModule(AllToolModules.SPRUCE_SWORD_POMMEL, AllToolModuleModelIds.SPRUCE_POMMEL);
        registerForBasicToolModule(AllToolModules.BIRCH_SWORD_POMMEL, AllToolModuleModelIds.BIRCH_POMMEL);
        registerForBasicToolModule(AllToolModules.JUNGLE_SWORD_POMMEL, AllToolModuleModelIds.JUNGLE_POMMEL);
        registerForBasicToolModule(AllToolModules.ACACIA_SWORD_POMMEL, AllToolModuleModelIds.ACACIA_POMMEL);
        registerForBasicToolModule(AllToolModules.DARK_OAK_SWORD_POMMEL, AllToolModuleModelIds.DARK_OAK_POMMEL);
        registerForBasicToolModule(AllToolModules.MANGROVE_SWORD_POMMEL, AllToolModuleModelIds.MANGROVE_POMMEL);
        registerForBasicToolModule(AllToolModules.CHERRY_SWORD_POMMEL, AllToolModuleModelIds.CHERRY_POMMEL);
        registerForBasicToolModule(AllToolModules.BAMBOO_SWORD_POMMEL, AllToolModuleModelIds.BAMBOO_POMMEL);
        registerForBasicToolModule(AllToolModules.CRIMSON_SWORD_POMMEL, AllToolModuleModelIds.CRIMSON_POMMEL);
        registerForBasicToolModule(AllToolModules.WARPED_SWORD_POMMEL, AllToolModuleModelIds.WARPED_POMMEL);
        registerForBasicToolModule(AllToolModules.STONE_SWORD_POMMEL, AllToolModuleModelIds.STONE_POMMEL);
        registerForBasicToolModule(AllToolModules.IRON_SWORD_POMMEL, AllToolModuleModelIds.IRON_POMMEL);
        registerForBasicToolModule(AllToolModules.COPPER_SWORD_POMMEL, AllToolModuleModelIds.COPPER_POMMEL);
        registerForBasicToolModule(AllToolModules.GOLDEN_SWORD_POMMEL, AllToolModuleModelIds.GOLDEN_POMMEL);
        registerForBasicToolModule(AllToolModules.NETHERITE_SWORD_POMMEL, AllToolModuleModelIds.NETHERITE_POMMEL);
        registerForBasicToolModule(AllToolModules.ZINC_SWORD_POMMEL, AllToolModuleModelIds.ZINC_POMMEL);
        registerForBasicToolModule(AllToolModules.BRASS_SWORD_POMMEL, AllToolModuleModelIds.BRASS_POMMEL);
        registerForBasicToolModule(AllToolModules.DIAMOND_SWORD_POMMEL, AllToolModuleModelIds.DIAMOND_POMMEL);

        // Tool Wraps

        registerForToolWrap(AllToolModules.WHITE_WOOL_TOOL_WRAP, AllToolModuleModelIds.WHITE_WOOL_SWORD_WRAP, AllToolModuleModelIds.WHITE_WOOL_POMMEL_SWORD_WRAP, AllToolModuleModelIds.WHITE_WOOL_SHOVEL_WRAP, AllToolModuleModelIds.WHITE_WOOL_GRIP_SHOVEL_WRAP, AllToolModuleModelIds.WHITE_WOOL_PICKAXE_WRAP, AllToolModuleModelIds.WHITE_WOOL_GRIP_PICKAXE_WRAP, AllToolModuleModelIds.WHITE_WOOL_AXE_WRAP, AllToolModuleModelIds.WHITE_WOOL_GRIP_AXE_WRAP, AllToolModuleModelIds.WHITE_WOOL_HOE_WRAP, AllToolModuleModelIds.WHITE_WOOL_GRIP_HOE_WRAP);
        registerForToolWrap(AllToolModules.LIGHT_GRAY_WOOL_TOOL_WRAP, AllToolModuleModelIds.LIGHT_GRAY_WOOL_SWORD_WRAP, AllToolModuleModelIds.LIGHT_GRAY_WOOL_POMMEL_SWORD_WRAP, AllToolModuleModelIds.LIGHT_GRAY_WOOL_SHOVEL_WRAP, AllToolModuleModelIds.LIGHT_GRAY_WOOL_GRIP_SHOVEL_WRAP, AllToolModuleModelIds.LIGHT_GRAY_WOOL_PICKAXE_WRAP, AllToolModuleModelIds.LIGHT_GRAY_WOOL_GRIP_PICKAXE_WRAP, AllToolModuleModelIds.LIGHT_GRAY_WOOL_AXE_WRAP, AllToolModuleModelIds.LIGHT_GRAY_WOOL_GRIP_AXE_WRAP, AllToolModuleModelIds.LIGHT_GRAY_WOOL_HOE_WRAP, AllToolModuleModelIds.LIGHT_GRAY_WOOL_GRIP_HOE_WRAP);
        registerForToolWrap(AllToolModules.GRAY_WOOL_TOOL_WRAP, AllToolModuleModelIds.GRAY_WOOL_SWORD_WRAP, AllToolModuleModelIds.GRAY_WOOL_POMMEL_SWORD_WRAP, AllToolModuleModelIds.GRAY_WOOL_SHOVEL_WRAP, AllToolModuleModelIds.GRAY_WOOL_GRIP_SHOVEL_WRAP, AllToolModuleModelIds.GRAY_WOOL_PICKAXE_WRAP, AllToolModuleModelIds.GRAY_WOOL_GRIP_PICKAXE_WRAP, AllToolModuleModelIds.GRAY_WOOL_AXE_WRAP, AllToolModuleModelIds.GRAY_WOOL_GRIP_AXE_WRAP, AllToolModuleModelIds.GRAY_WOOL_HOE_WRAP, AllToolModuleModelIds.GRAY_WOOL_GRIP_HOE_WRAP);
        registerForToolWrap(AllToolModules.BLACK_WOOL_TOOL_WRAP, AllToolModuleModelIds.BLACK_WOOL_SWORD_WRAP, AllToolModuleModelIds.BLACK_WOOL_POMMEL_SWORD_WRAP, AllToolModuleModelIds.BLACK_WOOL_SHOVEL_WRAP, AllToolModuleModelIds.BLACK_WOOL_GRIP_SHOVEL_WRAP, AllToolModuleModelIds.BLACK_WOOL_PICKAXE_WRAP, AllToolModuleModelIds.BLACK_WOOL_GRIP_PICKAXE_WRAP, AllToolModuleModelIds.BLACK_WOOL_AXE_WRAP, AllToolModuleModelIds.BLACK_WOOL_GRIP_AXE_WRAP, AllToolModuleModelIds.BLACK_WOOL_HOE_WRAP, AllToolModuleModelIds.BLACK_WOOL_GRIP_HOE_WRAP);
        registerForToolWrap(AllToolModules.BROWN_WOOL_TOOL_WRAP, AllToolModuleModelIds.BROWN_WOOL_SWORD_WRAP, AllToolModuleModelIds.BROWN_WOOL_POMMEL_SWORD_WRAP, AllToolModuleModelIds.BROWN_WOOL_SHOVEL_WRAP, AllToolModuleModelIds.BROWN_WOOL_GRIP_SHOVEL_WRAP, AllToolModuleModelIds.BROWN_WOOL_PICKAXE_WRAP, AllToolModuleModelIds.BROWN_WOOL_GRIP_PICKAXE_WRAP, AllToolModuleModelIds.BROWN_WOOL_AXE_WRAP, AllToolModuleModelIds.BROWN_WOOL_GRIP_AXE_WRAP, AllToolModuleModelIds.BROWN_WOOL_HOE_WRAP, AllToolModuleModelIds.BROWN_WOOL_GRIP_HOE_WRAP);
        registerForToolWrap(AllToolModules.RED_WOOL_TOOL_WRAP, AllToolModuleModelIds.RED_WOOL_SWORD_WRAP, AllToolModuleModelIds.RED_WOOL_POMMEL_SWORD_WRAP, AllToolModuleModelIds.RED_WOOL_SHOVEL_WRAP, AllToolModuleModelIds.RED_WOOL_GRIP_SHOVEL_WRAP, AllToolModuleModelIds.RED_WOOL_PICKAXE_WRAP, AllToolModuleModelIds.RED_WOOL_GRIP_PICKAXE_WRAP, AllToolModuleModelIds.RED_WOOL_AXE_WRAP, AllToolModuleModelIds.RED_WOOL_GRIP_AXE_WRAP, AllToolModuleModelIds.RED_WOOL_HOE_WRAP, AllToolModuleModelIds.RED_WOOL_GRIP_HOE_WRAP);
        registerForToolWrap(AllToolModules.ORANGE_WOOL_TOOL_WRAP, AllToolModuleModelIds.ORANGE_WOOL_SWORD_WRAP, AllToolModuleModelIds.ORANGE_WOOL_POMMEL_SWORD_WRAP, AllToolModuleModelIds.ORANGE_WOOL_SHOVEL_WRAP, AllToolModuleModelIds.ORANGE_WOOL_GRIP_SHOVEL_WRAP, AllToolModuleModelIds.ORANGE_WOOL_PICKAXE_WRAP, AllToolModuleModelIds.ORANGE_WOOL_GRIP_PICKAXE_WRAP, AllToolModuleModelIds.ORANGE_WOOL_AXE_WRAP, AllToolModuleModelIds.ORANGE_WOOL_GRIP_AXE_WRAP, AllToolModuleModelIds.ORANGE_WOOL_HOE_WRAP, AllToolModuleModelIds.ORANGE_WOOL_GRIP_HOE_WRAP);
        registerForToolWrap(AllToolModules.YELLOW_WOOL_TOOL_WRAP, AllToolModuleModelIds.YELLOW_WOOL_SWORD_WRAP, AllToolModuleModelIds.YELLOW_WOOL_POMMEL_SWORD_WRAP, AllToolModuleModelIds.YELLOW_WOOL_SHOVEL_WRAP, AllToolModuleModelIds.YELLOW_WOOL_GRIP_SHOVEL_WRAP, AllToolModuleModelIds.YELLOW_WOOL_PICKAXE_WRAP, AllToolModuleModelIds.YELLOW_WOOL_GRIP_PICKAXE_WRAP, AllToolModuleModelIds.YELLOW_WOOL_AXE_WRAP, AllToolModuleModelIds.YELLOW_WOOL_GRIP_AXE_WRAP, AllToolModuleModelIds.YELLOW_WOOL_HOE_WRAP, AllToolModuleModelIds.YELLOW_WOOL_GRIP_HOE_WRAP);
        registerForToolWrap(AllToolModules.LIME_WOOL_TOOL_WRAP, AllToolModuleModelIds.LIME_WOOL_SWORD_WRAP, AllToolModuleModelIds.LIME_WOOL_POMMEL_SWORD_WRAP, AllToolModuleModelIds.LIME_WOOL_SHOVEL_WRAP, AllToolModuleModelIds.LIME_WOOL_GRIP_SHOVEL_WRAP, AllToolModuleModelIds.LIME_WOOL_PICKAXE_WRAP, AllToolModuleModelIds.LIME_WOOL_GRIP_PICKAXE_WRAP, AllToolModuleModelIds.LIME_WOOL_AXE_WRAP, AllToolModuleModelIds.LIME_WOOL_GRIP_AXE_WRAP, AllToolModuleModelIds.LIME_WOOL_HOE_WRAP, AllToolModuleModelIds.LIME_WOOL_GRIP_HOE_WRAP);
        registerForToolWrap(AllToolModules.GREEN_WOOL_TOOL_WRAP, AllToolModuleModelIds.GREEN_WOOL_SWORD_WRAP, AllToolModuleModelIds.GREEN_WOOL_POMMEL_SWORD_WRAP, AllToolModuleModelIds.GREEN_WOOL_SHOVEL_WRAP, AllToolModuleModelIds.GREEN_WOOL_GRIP_SHOVEL_WRAP, AllToolModuleModelIds.GREEN_WOOL_PICKAXE_WRAP, AllToolModuleModelIds.GREEN_WOOL_GRIP_PICKAXE_WRAP, AllToolModuleModelIds.GREEN_WOOL_AXE_WRAP, AllToolModuleModelIds.GREEN_WOOL_GRIP_AXE_WRAP, AllToolModuleModelIds.GREEN_WOOL_HOE_WRAP, AllToolModuleModelIds.GREEN_WOOL_GRIP_HOE_WRAP);
        registerForToolWrap(AllToolModules.CYAN_WOOL_TOOL_WRAP, AllToolModuleModelIds.CYAN_WOOL_SWORD_WRAP, AllToolModuleModelIds.CYAN_WOOL_POMMEL_SWORD_WRAP, AllToolModuleModelIds.CYAN_WOOL_SHOVEL_WRAP, AllToolModuleModelIds.CYAN_WOOL_GRIP_SHOVEL_WRAP, AllToolModuleModelIds.CYAN_WOOL_PICKAXE_WRAP, AllToolModuleModelIds.CYAN_WOOL_GRIP_PICKAXE_WRAP, AllToolModuleModelIds.CYAN_WOOL_AXE_WRAP, AllToolModuleModelIds.CYAN_WOOL_GRIP_AXE_WRAP, AllToolModuleModelIds.CYAN_WOOL_HOE_WRAP, AllToolModuleModelIds.CYAN_WOOL_GRIP_HOE_WRAP);
        registerForToolWrap(AllToolModules.LIGHT_BLUE_WOOL_TOOL_WRAP, AllToolModuleModelIds.LIGHT_BLUE_WOOL_SWORD_WRAP, AllToolModuleModelIds.LIGHT_BLUE_WOOL_POMMEL_SWORD_WRAP, AllToolModuleModelIds.LIGHT_BLUE_WOOL_SHOVEL_WRAP, AllToolModuleModelIds.LIGHT_BLUE_WOOL_GRIP_SHOVEL_WRAP, AllToolModuleModelIds.LIGHT_BLUE_WOOL_PICKAXE_WRAP, AllToolModuleModelIds.LIGHT_BLUE_WOOL_GRIP_PICKAXE_WRAP, AllToolModuleModelIds.LIGHT_BLUE_WOOL_AXE_WRAP, AllToolModuleModelIds.LIGHT_BLUE_WOOL_GRIP_AXE_WRAP, AllToolModuleModelIds.LIGHT_BLUE_WOOL_HOE_WRAP, AllToolModuleModelIds.LIGHT_BLUE_WOOL_GRIP_HOE_WRAP);
        registerForToolWrap(AllToolModules.BLUE_WOOL_TOOL_WRAP, AllToolModuleModelIds.BLUE_WOOL_SWORD_WRAP, AllToolModuleModelIds.BLUE_WOOL_POMMEL_SWORD_WRAP, AllToolModuleModelIds.BLUE_WOOL_SHOVEL_WRAP, AllToolModuleModelIds.BLUE_WOOL_GRIP_SHOVEL_WRAP, AllToolModuleModelIds.BLUE_WOOL_PICKAXE_WRAP, AllToolModuleModelIds.BLUE_WOOL_GRIP_PICKAXE_WRAP, AllToolModuleModelIds.BLUE_WOOL_AXE_WRAP, AllToolModuleModelIds.BLUE_WOOL_GRIP_AXE_WRAP, AllToolModuleModelIds.BLUE_WOOL_HOE_WRAP, AllToolModuleModelIds.BLUE_WOOL_GRIP_HOE_WRAP);
        registerForToolWrap(AllToolModules.PURPLE_WOOL_TOOL_WRAP, AllToolModuleModelIds.PURPLE_WOOL_SWORD_WRAP, AllToolModuleModelIds.PURPLE_WOOL_POMMEL_SWORD_WRAP, AllToolModuleModelIds.PURPLE_WOOL_SHOVEL_WRAP, AllToolModuleModelIds.PURPLE_WOOL_GRIP_SHOVEL_WRAP, AllToolModuleModelIds.PURPLE_WOOL_PICKAXE_WRAP, AllToolModuleModelIds.PURPLE_WOOL_GRIP_PICKAXE_WRAP, AllToolModuleModelIds.PURPLE_WOOL_AXE_WRAP, AllToolModuleModelIds.PURPLE_WOOL_GRIP_AXE_WRAP, AllToolModuleModelIds.PURPLE_WOOL_HOE_WRAP, AllToolModuleModelIds.PURPLE_WOOL_GRIP_HOE_WRAP);
        registerForToolWrap(AllToolModules.MAGENTA_WOOL_TOOL_WRAP, AllToolModuleModelIds.MAGENTA_WOOL_SWORD_WRAP, AllToolModuleModelIds.MAGENTA_WOOL_POMMEL_SWORD_WRAP, AllToolModuleModelIds.MAGENTA_WOOL_SHOVEL_WRAP, AllToolModuleModelIds.MAGENTA_WOOL_GRIP_SHOVEL_WRAP, AllToolModuleModelIds.MAGENTA_WOOL_PICKAXE_WRAP, AllToolModuleModelIds.MAGENTA_WOOL_GRIP_PICKAXE_WRAP, AllToolModuleModelIds.MAGENTA_WOOL_AXE_WRAP, AllToolModuleModelIds.MAGENTA_WOOL_GRIP_AXE_WRAP, AllToolModuleModelIds.MAGENTA_WOOL_HOE_WRAP, AllToolModuleModelIds.MAGENTA_WOOL_GRIP_HOE_WRAP);
        registerForToolWrap(AllToolModules.PINK_WOOL_TOOL_WRAP, AllToolModuleModelIds.PINK_WOOL_SWORD_WRAP, AllToolModuleModelIds.PINK_WOOL_POMMEL_SWORD_WRAP, AllToolModuleModelIds.PINK_WOOL_SHOVEL_WRAP, AllToolModuleModelIds.PINK_WOOL_GRIP_SHOVEL_WRAP, AllToolModuleModelIds.PINK_WOOL_PICKAXE_WRAP, AllToolModuleModelIds.PINK_WOOL_GRIP_PICKAXE_WRAP, AllToolModuleModelIds.PINK_WOOL_AXE_WRAP, AllToolModuleModelIds.PINK_WOOL_GRIP_AXE_WRAP, AllToolModuleModelIds.PINK_WOOL_HOE_WRAP, AllToolModuleModelIds.PINK_WOOL_GRIP_HOE_WRAP);
    }

    private static void registerToolModuleModelIds(ToolModuleItem toolModule, ResourceLocation... modelIds) {
        toolModule.registerModelIds(() -> List.of(modelIds));
    }

    private static void registerToolModuleBaseModelIdGetter(ToolModuleItem toolModule, ResourceLocation baseModelId) {
        toolModule.registerModelIdGetter((original, modularTool, nbt) -> original == null ? baseModelId : original);
    }

    private static void registerToolModuleModelIdGetterForTool(ToolModuleItem toolModule, ModularToolItem tool, ResourceLocation toolModelId) {
        toolModule.registerModelIdGetter((original, modularTool, nbt) -> original == null && modularTool == tool ? toolModelId : original);
    }

    private static void registerToolModuleModelIdGetterForToolWithModules(ToolModuleItem toolModule, ModularToolItem tool, List<ToolModuleType> toolModuleTypes, ResourceLocation modelId) {
        toolModule.registerModelIdGetter((original, modularTool, nbt) -> original == null && modularTool == tool && toolModuleTypes.stream().allMatch(toolModuleType -> nbt.contains(toolModuleType.getTag(), Tag.TAG_COMPOUND)) ? modelId : original);
    }

    private static void registerToolModuleModelIdGetterForToolWithoutModules(ToolModuleItem toolModule, ModularToolItem tool, List<ToolModuleType> toolModuleTypes, ResourceLocation modelId) {
        toolModule.registerModelIdGetter((original, modularTool, nbt) -> original == null && modularTool == tool && toolModuleTypes.stream().noneMatch(toolModuleType -> nbt.contains(toolModuleType.getTag(), Tag.TAG_COMPOUND)) ? modelId : original);
    }

    private static void registerToolModuleModelIdGetterForToolWithAndWithoutModules(ToolModuleItem toolModule, ModularToolItem tool, List<ToolModuleType> includedToolModuleTypes, List<ToolModuleType> excludedToolModuleTypes, ResourceLocation modelId) {
        toolModule.registerModelIdGetter((original, modularTool, nbt) -> original == null && modularTool == tool && includedToolModuleTypes.stream().allMatch(toolModuleType -> nbt.contains(toolModuleType.getTag(), Tag.TAG_COMPOUND)) && excludedToolModuleTypes.stream().noneMatch(toolModuleType -> nbt.contains(toolModuleType.getTag(), Tag.TAG_COMPOUND)) ? modelId : original);
    }

    private static void registerEmptyMoldTopTextureIdGetter(ToolModuleType.MoldTopTexture moldTopTexture, Set<BaseMoldBlock> moldBlocks, ToolModuleType toolModuleType, ResourceLocation textureId) {
        moldTopTexture.registerTextureIdGetter((original, baseMoldBlock, nbt) -> original == null && moldBlocks.contains(baseMoldBlock) && ToolUtils.MoldSlotState.fromName(nbt.getCompound(toolModuleType.getTag()).getString("state")) == ToolUtils.MoldSlotState.EMPTY ? textureId : original);
    }

    private static void registerFullMoldTopTextureIdGetter(ToolModuleType.MoldTopTexture moldTopTexture, ToolModuleType toolModuleType, FlowingFluid fluid, ResourceLocation textureId) {
        moldTopTexture.registerTextureIdGetter((original, sandMoldBlock, nbt) -> {
            CompoundTag slotNbt = nbt.getCompound(toolModuleType.getTag());
            return original == null && ToolUtils.MoldSlotState.fromName(slotNbt.getString("state")) == ToolUtils.MoldSlotState.FLUID && slotNbt.getString("id").equals(BuiltInRegistries.FLUID.getKey(fluid).toString()) ? textureId : original;
        });
    }

    private static void registerForBasicToolModule(ToolModuleItem toolModule, ResourceLocation id) {
        registerToolModuleModelIds(toolModule, id);

        registerToolModuleBaseModelIdGetter(toolModule, id);
    }

    private static void registerForPickaxeHead(ToolModuleItem pickaxeHead, ResourceLocation id, ResourceLocation itemId) {
        registerToolModuleModelIds(pickaxeHead, id, itemId);

        registerToolModuleBaseModelIdGetter(pickaxeHead, id);
    }

    private static void registerForToolHandle(ToolModuleItem toolHandle, ResourceLocation idSword, ResourceLocation idPommelSword, ResourceLocation idWrapSword, ResourceLocation idPommelWrapSword, ResourceLocation idShovel, ResourceLocation idGripShovel, ResourceLocation idWrapShovel, ResourceLocation idGripWrapShovel, ResourceLocation idPickaxe, ResourceLocation idGripPickaxe, ResourceLocation idWrapPickaxe, ResourceLocation idGripWrapPickaxe, ResourceLocation idAxe, ResourceLocation idGripAxe, ResourceLocation idWrapAxe, ResourceLocation idGripWrapAxe, ResourceLocation idHoe, ResourceLocation idGripHoe, ResourceLocation idWrapHoe, ResourceLocation idGripWrapHoe) {
        registerToolModuleModelIds(toolHandle, idSword, idPommelSword, idWrapSword, idPommelWrapSword, idShovel, idGripShovel, idWrapShovel, idGripWrapShovel, idPickaxe, idGripPickaxe, idWrapPickaxe, idGripWrapPickaxe, idAxe, idGripAxe, idWrapAxe, idGripWrapAxe, idHoe, idGripHoe, idWrapHoe, idGripWrapHoe);

        registerToolModuleModelIdGetterForToolWithoutModules(toolHandle, AllModularTools.SWORD, List.of(AllToolModuleTypes.SWORD_POMMEL, AllToolModuleTypes.TOOL_WRAP), idSword);
        registerToolModuleModelIdGetterForToolWithoutModules(toolHandle, AllModularTools.SHOVEL, List.of(AllToolModuleTypes.TOOL_GRIP, AllToolModuleTypes.TOOL_WRAP), idShovel);
        registerToolModuleModelIdGetterForToolWithoutModules(toolHandle, AllModularTools.PICKAXE, List.of(AllToolModuleTypes.TOOL_GRIP, AllToolModuleTypes.TOOL_WRAP), idPickaxe);
        registerToolModuleModelIdGetterForToolWithoutModules(toolHandle, AllModularTools.AXE, List.of(AllToolModuleTypes.TOOL_GRIP, AllToolModuleTypes.TOOL_WRAP), idAxe);
        registerToolModuleModelIdGetterForToolWithoutModules(toolHandle, AllModularTools.HOE, List.of(AllToolModuleTypes.TOOL_GRIP, AllToolModuleTypes.TOOL_WRAP), idHoe);

        registerToolModuleModelIdGetterForToolWithAndWithoutModules(toolHandle, AllModularTools.SWORD, List.of(AllToolModuleTypes.SWORD_POMMEL), List.of(AllToolModuleTypes.TOOL_WRAP), idPommelSword);
        registerToolModuleModelIdGetterForToolWithAndWithoutModules(toolHandle, AllModularTools.SHOVEL, List.of(AllToolModuleTypes.TOOL_GRIP), List.of(AllToolModuleTypes.TOOL_WRAP), idGripShovel);
        registerToolModuleModelIdGetterForToolWithAndWithoutModules(toolHandle, AllModularTools.PICKAXE, List.of(AllToolModuleTypes.TOOL_GRIP), List.of(AllToolModuleTypes.TOOL_WRAP), idGripPickaxe);
        registerToolModuleModelIdGetterForToolWithAndWithoutModules(toolHandle, AllModularTools.AXE, List.of(AllToolModuleTypes.TOOL_GRIP), List.of(AllToolModuleTypes.TOOL_WRAP), idGripAxe);
        registerToolModuleModelIdGetterForToolWithAndWithoutModules(toolHandle, AllModularTools.HOE, List.of(AllToolModuleTypes.TOOL_GRIP), List.of(AllToolModuleTypes.TOOL_WRAP), idGripHoe);

        registerToolModuleModelIdGetterForToolWithAndWithoutModules(toolHandle, AllModularTools.SWORD, List.of(AllToolModuleTypes.TOOL_WRAP), List.of(AllToolModuleTypes.SWORD_POMMEL), idWrapSword);
        registerToolModuleModelIdGetterForToolWithAndWithoutModules(toolHandle, AllModularTools.SHOVEL, List.of(AllToolModuleTypes.TOOL_WRAP), List.of(AllToolModuleTypes.TOOL_GRIP), idWrapShovel);
        registerToolModuleModelIdGetterForToolWithAndWithoutModules(toolHandle, AllModularTools.PICKAXE, List.of(AllToolModuleTypes.TOOL_WRAP), List.of(AllToolModuleTypes.TOOL_GRIP), idWrapPickaxe);
        registerToolModuleModelIdGetterForToolWithAndWithoutModules(toolHandle, AllModularTools.AXE, List.of(AllToolModuleTypes.TOOL_WRAP), List.of(AllToolModuleTypes.TOOL_GRIP), idWrapAxe);
        registerToolModuleModelIdGetterForToolWithAndWithoutModules(toolHandle, AllModularTools.HOE, List.of(AllToolModuleTypes.TOOL_WRAP), List.of(AllToolModuleTypes.TOOL_GRIP), idWrapHoe);

        registerToolModuleModelIdGetterForToolWithModules(toolHandle, AllModularTools.SWORD, List.of(AllToolModuleTypes.SWORD_POMMEL, AllToolModuleTypes.TOOL_WRAP), idPommelWrapSword);
        registerToolModuleModelIdGetterForToolWithModules(toolHandle, AllModularTools.SHOVEL, List.of(AllToolModuleTypes.TOOL_GRIP, AllToolModuleTypes.TOOL_WRAP), idGripWrapShovel);
        registerToolModuleModelIdGetterForToolWithModules(toolHandle, AllModularTools.PICKAXE, List.of(AllToolModuleTypes.TOOL_GRIP, AllToolModuleTypes.TOOL_WRAP), idGripWrapPickaxe);
        registerToolModuleModelIdGetterForToolWithModules(toolHandle, AllModularTools.AXE, List.of(AllToolModuleTypes.TOOL_GRIP, AllToolModuleTypes.TOOL_WRAP), idGripWrapAxe);
        registerToolModuleModelIdGetterForToolWithModules(toolHandle, AllModularTools.HOE, List.of(AllToolModuleTypes.TOOL_GRIP, AllToolModuleTypes.TOOL_WRAP), idGripWrapHoe);
    }

    private static void registerForToolWrap(ToolModuleItem toolWrap, ResourceLocation idSword, ResourceLocation idPommelSword, ResourceLocation idShovel, ResourceLocation idGripShovel, ResourceLocation idPickaxe, ResourceLocation idGripPickaxe, ResourceLocation idAxe, ResourceLocation idGripAxe, ResourceLocation idHoe, ResourceLocation idGripHoe) {
        registerToolModuleModelIds(toolWrap, idSword, idPommelSword, idShovel, idGripShovel, idPickaxe, idGripPickaxe, idAxe, idGripAxe, idHoe, idGripHoe);

        registerToolModuleModelIdGetterForToolWithoutModules(toolWrap, AllModularTools.SWORD, List.of(AllToolModuleTypes.SWORD_POMMEL), idSword);
        registerToolModuleModelIdGetterForToolWithoutModules(toolWrap, AllModularTools.SHOVEL, List.of(AllToolModuleTypes.TOOL_GRIP), idShovel);
        registerToolModuleModelIdGetterForToolWithoutModules(toolWrap, AllModularTools.PICKAXE, List.of(AllToolModuleTypes.TOOL_GRIP), idPickaxe);
        registerToolModuleModelIdGetterForToolWithoutModules(toolWrap, AllModularTools.AXE, List.of(AllToolModuleTypes.TOOL_GRIP), idAxe);
        registerToolModuleModelIdGetterForToolWithoutModules(toolWrap, AllModularTools.HOE, List.of(AllToolModuleTypes.TOOL_GRIP), idHoe);

        registerToolModuleModelIdGetterForToolWithModules(toolWrap, AllModularTools.SWORD, List.of(AllToolModuleTypes.SWORD_POMMEL), idPommelSword);
        registerToolModuleModelIdGetterForToolWithModules(toolWrap, AllModularTools.SHOVEL, List.of(AllToolModuleTypes.TOOL_GRIP), idGripShovel);
        registerToolModuleModelIdGetterForToolWithModules(toolWrap, AllModularTools.PICKAXE, List.of(AllToolModuleTypes.TOOL_GRIP), idGripPickaxe);
        registerToolModuleModelIdGetterForToolWithModules(toolWrap, AllModularTools.AXE, List.of(AllToolModuleTypes.TOOL_GRIP), idGripAxe);
        registerToolModuleModelIdGetterForToolWithModules(toolWrap, AllModularTools.HOE, List.of(AllToolModuleTypes.TOOL_GRIP), idGripHoe);
    }

    private static void registerForNonSolidSlot(ToolModuleType.MoldTopTexture moldTopTexture, ToolModuleType toolModuleType, ResourceLocation idEmptySand, ResourceLocation idEmptyRedSand, ResourceLocation idEmptyWhiteConcretePowder, ResourceLocation idEmptyLightGrayConcretePowder, ResourceLocation idEmptyGrayConcretePowder, ResourceLocation idEmptyBlackConcretePowder, ResourceLocation idEmptyBrownConcretePowder, ResourceLocation idEmptyRedConcretePowder, ResourceLocation idEmptyOrangeConcretePowder, ResourceLocation idEmptyYellowConcretePowder, ResourceLocation idEmptyLimeConcretePowder, ResourceLocation idEmptyGreenConcretePowder, ResourceLocation idEmptyCyanConcretePowder, ResourceLocation idEmptyLightBlueConcretePowder, ResourceLocation idEmptyBlueConcretePowder, ResourceLocation idEmptyPurpleConcretePowder, ResourceLocation idEmptyMagentaConcretePowder, ResourceLocation idEmptyPinkConcretePowder, ResourceLocation idLava, ResourceLocation idMoltenIron, ResourceLocation idMoltenCopper, ResourceLocation idMoltenGold, ResourceLocation idMoltenNetherite, ResourceLocation idMoltenZinc, ResourceLocation idMoltenBrass, ResourceLocation idMoltenDiamond) {
        registerEmptyMoldTopTextureIdGetter(moldTopTexture, AllMoldBlocks.SAND_MOLDS, toolModuleType, idEmptySand);
        registerEmptyMoldTopTextureIdGetter(moldTopTexture, AllMoldBlocks.RED_SAND_MOLDS, toolModuleType, idEmptyRedSand);
        registerEmptyMoldTopTextureIdGetter(moldTopTexture, AllMoldBlocks.WHITE_CONCRETE_POWDER_MOLDS, toolModuleType, idEmptyWhiteConcretePowder);
        registerEmptyMoldTopTextureIdGetter(moldTopTexture, AllMoldBlocks.LIGHT_GRAY_CONCRETE_POWDER_MOLDS, toolModuleType, idEmptyLightGrayConcretePowder);
        registerEmptyMoldTopTextureIdGetter(moldTopTexture, AllMoldBlocks.GRAY_CONCRETE_POWDER_MOLDS, toolModuleType, idEmptyGrayConcretePowder);
        registerEmptyMoldTopTextureIdGetter(moldTopTexture, AllMoldBlocks.BLACK_CONCRETE_POWDER_MOLDS, toolModuleType, idEmptyBlackConcretePowder);
        registerEmptyMoldTopTextureIdGetter(moldTopTexture, AllMoldBlocks.BROWN_CONCRETE_POWDER_MOLDS, toolModuleType, idEmptyBrownConcretePowder);
        registerEmptyMoldTopTextureIdGetter(moldTopTexture, AllMoldBlocks.RED_CONCRETE_POWDER_MOLDS, toolModuleType, idEmptyRedConcretePowder);
        registerEmptyMoldTopTextureIdGetter(moldTopTexture, AllMoldBlocks.ORANGE_CONCRETE_POWDER_MOLDS, toolModuleType, idEmptyOrangeConcretePowder);
        registerEmptyMoldTopTextureIdGetter(moldTopTexture, AllMoldBlocks.YELLOW_CONCRETE_POWDER_MOLDS, toolModuleType, idEmptyYellowConcretePowder);
        registerEmptyMoldTopTextureIdGetter(moldTopTexture, AllMoldBlocks.LIME_CONCRETE_POWDER_MOLDS, toolModuleType, idEmptyLimeConcretePowder);
        registerEmptyMoldTopTextureIdGetter(moldTopTexture, AllMoldBlocks.GREEN_CONCRETE_POWDER_MOLDS, toolModuleType, idEmptyGreenConcretePowder);
        registerEmptyMoldTopTextureIdGetter(moldTopTexture, AllMoldBlocks.CYAN_CONCRETE_POWDER_MOLDS, toolModuleType, idEmptyCyanConcretePowder);
        registerEmptyMoldTopTextureIdGetter(moldTopTexture, AllMoldBlocks.LIGHT_BLUE_CONCRETE_POWDER_MOLDS, toolModuleType, idEmptyLightBlueConcretePowder);
        registerEmptyMoldTopTextureIdGetter(moldTopTexture, AllMoldBlocks.BLUE_CONCRETE_POWDER_MOLDS, toolModuleType, idEmptyBlueConcretePowder);
        registerEmptyMoldTopTextureIdGetter(moldTopTexture, AllMoldBlocks.PURPLE_CONCRETE_POWDER_MOLDS, toolModuleType, idEmptyPurpleConcretePowder);
        registerEmptyMoldTopTextureIdGetter(moldTopTexture, AllMoldBlocks.MAGENTA_CONCRETE_POWDER_MOLDS, toolModuleType, idEmptyMagentaConcretePowder);
        registerEmptyMoldTopTextureIdGetter(moldTopTexture, AllMoldBlocks.PINK_CONCRETE_POWDER_MOLDS, toolModuleType, idEmptyPinkConcretePowder);
        registerFullMoldTopTextureIdGetter(moldTopTexture, toolModuleType, Fluids.LAVA, idLava);
        registerFullMoldTopTextureIdGetter(moldTopTexture, toolModuleType, AllFluids.MOLTEN_IRON, idMoltenIron);
        registerFullMoldTopTextureIdGetter(moldTopTexture, toolModuleType, AllFluids.MOLTEN_COPPER, idMoltenCopper);
        registerFullMoldTopTextureIdGetter(moldTopTexture, toolModuleType, AllFluids.MOLTEN_GOLD, idMoltenGold);
        registerFullMoldTopTextureIdGetter(moldTopTexture, toolModuleType, AllFluids.MOLTEN_NETHERITE, idMoltenNetherite);
        registerFullMoldTopTextureIdGetter(moldTopTexture, toolModuleType, AllFluids.MOLTEN_ZINC, idMoltenZinc);
        registerFullMoldTopTextureIdGetter(moldTopTexture, toolModuleType, AllFluids.MOLTEN_BRASS, idMoltenBrass);
        registerFullMoldTopTextureIdGetter(moldTopTexture, toolModuleType, AllFluids.MOLTEN_DIAMOND, idMoltenDiamond);
    }
}
