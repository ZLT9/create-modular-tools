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
import net.zlt.create_modular_tools.AllTagNames;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.block.AllBlocks;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.AllMoldTopTextures;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;
import net.zlt.create_modular_tools.block.mold.MaterialMoldBlock;
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

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_SAND_OAK_MOLD, SwordSandOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_SAND_OAK_MOLD, ShovelSandOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_SAND_OAK_MOLD, PickaxeSandOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_SAND_OAK_MOLD, AxeSandOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_SAND_OAK_MOLD, HoeSandOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_SAND_SPRUCE_MOLD, SwordSandSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_SAND_SPRUCE_MOLD, ShovelSandSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_SAND_SPRUCE_MOLD, PickaxeSandSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_SAND_SPRUCE_MOLD, AxeSandSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_SAND_SPRUCE_MOLD, HoeSandSpruceMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_SAND_BIRCH_MOLD, SwordSandBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_SAND_BIRCH_MOLD, ShovelSandBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_SAND_BIRCH_MOLD, PickaxeSandBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_SAND_BIRCH_MOLD, AxeSandBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_SAND_BIRCH_MOLD, HoeSandBirchMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_SAND_JUNGLE_MOLD, SwordSandJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_SAND_JUNGLE_MOLD, ShovelSandJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_SAND_JUNGLE_MOLD, PickaxeSandJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_SAND_JUNGLE_MOLD, AxeSandJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_SAND_JUNGLE_MOLD, HoeSandJungleMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_SAND_ACACIA_MOLD, SwordSandAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_SAND_ACACIA_MOLD, ShovelSandAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_SAND_ACACIA_MOLD, PickaxeSandAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_SAND_ACACIA_MOLD, AxeSandAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_SAND_ACACIA_MOLD, HoeSandAcaciaMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_SAND_DARK_OAK_MOLD, SwordSandDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_SAND_DARK_OAK_MOLD, ShovelSandDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_SAND_DARK_OAK_MOLD, PickaxeSandDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_SAND_DARK_OAK_MOLD, AxeSandDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_SAND_DARK_OAK_MOLD, HoeSandDarkOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_SAND_MANGROVE_MOLD, SwordSandMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_SAND_MANGROVE_MOLD, ShovelSandMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_SAND_MANGROVE_MOLD, PickaxeSandMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_SAND_MANGROVE_MOLD, AxeSandMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_SAND_MANGROVE_MOLD, HoeSandMangroveMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_SAND_CHERRY_MOLD, SwordSandCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_SAND_CHERRY_MOLD, ShovelSandCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_SAND_CHERRY_MOLD, PickaxeSandCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_SAND_CHERRY_MOLD, AxeSandCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_SAND_CHERRY_MOLD, HoeSandCherryMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_SAND_BAMBOO_MOLD, SwordSandBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_SAND_BAMBOO_MOLD, ShovelSandBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_SAND_BAMBOO_MOLD, PickaxeSandBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_SAND_BAMBOO_MOLD, AxeSandBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_SAND_BAMBOO_MOLD, HoeSandBambooMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_SAND_CRIMSON_MOLD, SwordSandCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_SAND_CRIMSON_MOLD, ShovelSandCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_SAND_CRIMSON_MOLD, PickaxeSandCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_SAND_CRIMSON_MOLD, AxeSandCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_SAND_CRIMSON_MOLD, HoeSandCrimsonMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_SAND_WARPED_MOLD, SwordSandWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_SAND_WARPED_MOLD, ShovelSandWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_SAND_WARPED_MOLD, PickaxeSandWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_SAND_WARPED_MOLD, AxeSandWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_SAND_WARPED_MOLD, HoeSandWarpedMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_RED_SAND_OAK_MOLD, SwordRedSandOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_RED_SAND_OAK_MOLD, ShovelRedSandOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_RED_SAND_OAK_MOLD, PickaxeRedSandOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_RED_SAND_OAK_MOLD, AxeRedSandOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_RED_SAND_OAK_MOLD, HoeRedSandOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_RED_SAND_SPRUCE_MOLD, SwordRedSandSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_RED_SAND_SPRUCE_MOLD, ShovelRedSandSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_RED_SAND_SPRUCE_MOLD, PickaxeRedSandSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_RED_SAND_SPRUCE_MOLD, AxeRedSandSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_RED_SAND_SPRUCE_MOLD, HoeRedSandSpruceMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_RED_SAND_BIRCH_MOLD, SwordRedSandBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_RED_SAND_BIRCH_MOLD, ShovelRedSandBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_RED_SAND_BIRCH_MOLD, PickaxeRedSandBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_RED_SAND_BIRCH_MOLD, AxeRedSandBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_RED_SAND_BIRCH_MOLD, HoeRedSandBirchMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_RED_SAND_JUNGLE_MOLD, SwordRedSandJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_RED_SAND_JUNGLE_MOLD, ShovelRedSandJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_RED_SAND_JUNGLE_MOLD, PickaxeRedSandJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_RED_SAND_JUNGLE_MOLD, AxeRedSandJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_RED_SAND_JUNGLE_MOLD, HoeRedSandJungleMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_RED_SAND_ACACIA_MOLD, SwordRedSandAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_RED_SAND_ACACIA_MOLD, ShovelRedSandAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_RED_SAND_ACACIA_MOLD, PickaxeRedSandAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_RED_SAND_ACACIA_MOLD, AxeRedSandAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_RED_SAND_ACACIA_MOLD, HoeRedSandAcaciaMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_RED_SAND_DARK_OAK_MOLD, SwordRedSandDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_RED_SAND_DARK_OAK_MOLD, ShovelRedSandDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_RED_SAND_DARK_OAK_MOLD, PickaxeRedSandDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_RED_SAND_DARK_OAK_MOLD, AxeRedSandDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_RED_SAND_DARK_OAK_MOLD, HoeRedSandDarkOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_RED_SAND_MANGROVE_MOLD, SwordRedSandMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_RED_SAND_MANGROVE_MOLD, ShovelRedSandMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_RED_SAND_MANGROVE_MOLD, PickaxeRedSandMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_RED_SAND_MANGROVE_MOLD, AxeRedSandMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_RED_SAND_MANGROVE_MOLD, HoeRedSandMangroveMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_RED_SAND_CHERRY_MOLD, SwordRedSandCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_RED_SAND_CHERRY_MOLD, ShovelRedSandCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_RED_SAND_CHERRY_MOLD, PickaxeRedSandCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_RED_SAND_CHERRY_MOLD, AxeRedSandCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_RED_SAND_CHERRY_MOLD, HoeRedSandCherryMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_RED_SAND_BAMBOO_MOLD, SwordRedSandBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_RED_SAND_BAMBOO_MOLD, ShovelRedSandBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_RED_SAND_BAMBOO_MOLD, PickaxeRedSandBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_RED_SAND_BAMBOO_MOLD, AxeRedSandBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_RED_SAND_BAMBOO_MOLD, HoeRedSandBambooMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_RED_SAND_CRIMSON_MOLD, SwordRedSandCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_RED_SAND_CRIMSON_MOLD, ShovelRedSandCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_RED_SAND_CRIMSON_MOLD, PickaxeRedSandCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_RED_SAND_CRIMSON_MOLD, AxeRedSandCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_RED_SAND_CRIMSON_MOLD, HoeRedSandCrimsonMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_RED_SAND_WARPED_MOLD, SwordRedSandWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_RED_SAND_WARPED_MOLD, ShovelRedSandWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_RED_SAND_WARPED_MOLD, PickaxeRedSandWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_RED_SAND_WARPED_MOLD, AxeRedSandWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_RED_SAND_WARPED_MOLD, HoeRedSandWarpedMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_WHITE_CONCRETE_POWDER_OAK_MOLD, SwordWhiteConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_WHITE_CONCRETE_POWDER_OAK_MOLD, ShovelWhiteConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_WHITE_CONCRETE_POWDER_OAK_MOLD, PickaxeWhiteConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_WHITE_CONCRETE_POWDER_OAK_MOLD, AxeWhiteConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_WHITE_CONCRETE_POWDER_OAK_MOLD, HoeWhiteConcretePowderOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_WHITE_CONCRETE_POWDER_SPRUCE_MOLD, SwordWhiteConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_WHITE_CONCRETE_POWDER_SPRUCE_MOLD, ShovelWhiteConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_WHITE_CONCRETE_POWDER_SPRUCE_MOLD, PickaxeWhiteConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_WHITE_CONCRETE_POWDER_SPRUCE_MOLD, AxeWhiteConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_WHITE_CONCRETE_POWDER_SPRUCE_MOLD, HoeWhiteConcretePowderSpruceMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_WHITE_CONCRETE_POWDER_BIRCH_MOLD, SwordWhiteConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_WHITE_CONCRETE_POWDER_BIRCH_MOLD, ShovelWhiteConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_WHITE_CONCRETE_POWDER_BIRCH_MOLD, PickaxeWhiteConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_WHITE_CONCRETE_POWDER_BIRCH_MOLD, AxeWhiteConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_WHITE_CONCRETE_POWDER_BIRCH_MOLD, HoeWhiteConcretePowderBirchMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_WHITE_CONCRETE_POWDER_JUNGLE_MOLD, SwordWhiteConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_WHITE_CONCRETE_POWDER_JUNGLE_MOLD, ShovelWhiteConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_WHITE_CONCRETE_POWDER_JUNGLE_MOLD, PickaxeWhiteConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_WHITE_CONCRETE_POWDER_JUNGLE_MOLD, AxeWhiteConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_WHITE_CONCRETE_POWDER_JUNGLE_MOLD, HoeWhiteConcretePowderJungleMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_WHITE_CONCRETE_POWDER_ACACIA_MOLD, SwordWhiteConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_WHITE_CONCRETE_POWDER_ACACIA_MOLD, ShovelWhiteConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_WHITE_CONCRETE_POWDER_ACACIA_MOLD, PickaxeWhiteConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_WHITE_CONCRETE_POWDER_ACACIA_MOLD, AxeWhiteConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_WHITE_CONCRETE_POWDER_ACACIA_MOLD, HoeWhiteConcretePowderAcaciaMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_WHITE_CONCRETE_POWDER_DARK_OAK_MOLD, SwordWhiteConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_WHITE_CONCRETE_POWDER_DARK_OAK_MOLD, ShovelWhiteConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_WHITE_CONCRETE_POWDER_DARK_OAK_MOLD, PickaxeWhiteConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_WHITE_CONCRETE_POWDER_DARK_OAK_MOLD, AxeWhiteConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_WHITE_CONCRETE_POWDER_DARK_OAK_MOLD, HoeWhiteConcretePowderDarkOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_WHITE_CONCRETE_POWDER_MANGROVE_MOLD, SwordWhiteConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_WHITE_CONCRETE_POWDER_MANGROVE_MOLD, ShovelWhiteConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_WHITE_CONCRETE_POWDER_MANGROVE_MOLD, PickaxeWhiteConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_WHITE_CONCRETE_POWDER_MANGROVE_MOLD, AxeWhiteConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_WHITE_CONCRETE_POWDER_MANGROVE_MOLD, HoeWhiteConcretePowderMangroveMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_WHITE_CONCRETE_POWDER_CHERRY_MOLD, SwordWhiteConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_WHITE_CONCRETE_POWDER_CHERRY_MOLD, ShovelWhiteConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_WHITE_CONCRETE_POWDER_CHERRY_MOLD, PickaxeWhiteConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_WHITE_CONCRETE_POWDER_CHERRY_MOLD, AxeWhiteConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_WHITE_CONCRETE_POWDER_CHERRY_MOLD, HoeWhiteConcretePowderCherryMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_WHITE_CONCRETE_POWDER_BAMBOO_MOLD, SwordWhiteConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_WHITE_CONCRETE_POWDER_BAMBOO_MOLD, ShovelWhiteConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_WHITE_CONCRETE_POWDER_BAMBOO_MOLD, PickaxeWhiteConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_WHITE_CONCRETE_POWDER_BAMBOO_MOLD, AxeWhiteConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_WHITE_CONCRETE_POWDER_BAMBOO_MOLD, HoeWhiteConcretePowderBambooMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_WHITE_CONCRETE_POWDER_CRIMSON_MOLD, SwordWhiteConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_WHITE_CONCRETE_POWDER_CRIMSON_MOLD, ShovelWhiteConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_WHITE_CONCRETE_POWDER_CRIMSON_MOLD, PickaxeWhiteConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_WHITE_CONCRETE_POWDER_CRIMSON_MOLD, AxeWhiteConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_WHITE_CONCRETE_POWDER_CRIMSON_MOLD, HoeWhiteConcretePowderCrimsonMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_WHITE_CONCRETE_POWDER_WARPED_MOLD, SwordWhiteConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_WHITE_CONCRETE_POWDER_WARPED_MOLD, ShovelWhiteConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_WHITE_CONCRETE_POWDER_WARPED_MOLD, PickaxeWhiteConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_WHITE_CONCRETE_POWDER_WARPED_MOLD, AxeWhiteConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_WHITE_CONCRETE_POWDER_WARPED_MOLD, HoeWhiteConcretePowderWarpedMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIGHT_GRAY_CONCRETE_POWDER_OAK_MOLD, SwordLightGrayConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_OAK_MOLD, ShovelLightGrayConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_OAK_MOLD, PickaxeLightGrayConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIGHT_GRAY_CONCRETE_POWDER_OAK_MOLD, AxeLightGrayConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIGHT_GRAY_CONCRETE_POWDER_OAK_MOLD, HoeLightGrayConcretePowderOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIGHT_GRAY_CONCRETE_POWDER_SPRUCE_MOLD, SwordLightGrayConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_SPRUCE_MOLD, ShovelLightGrayConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_SPRUCE_MOLD, PickaxeLightGrayConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIGHT_GRAY_CONCRETE_POWDER_SPRUCE_MOLD, AxeLightGrayConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIGHT_GRAY_CONCRETE_POWDER_SPRUCE_MOLD, HoeLightGrayConcretePowderSpruceMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIGHT_GRAY_CONCRETE_POWDER_BIRCH_MOLD, SwordLightGrayConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_BIRCH_MOLD, ShovelLightGrayConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_BIRCH_MOLD, PickaxeLightGrayConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIGHT_GRAY_CONCRETE_POWDER_BIRCH_MOLD, AxeLightGrayConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIGHT_GRAY_CONCRETE_POWDER_BIRCH_MOLD, HoeLightGrayConcretePowderBirchMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIGHT_GRAY_CONCRETE_POWDER_JUNGLE_MOLD, SwordLightGrayConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_JUNGLE_MOLD, ShovelLightGrayConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_JUNGLE_MOLD, PickaxeLightGrayConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIGHT_GRAY_CONCRETE_POWDER_JUNGLE_MOLD, AxeLightGrayConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIGHT_GRAY_CONCRETE_POWDER_JUNGLE_MOLD, HoeLightGrayConcretePowderJungleMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIGHT_GRAY_CONCRETE_POWDER_ACACIA_MOLD, SwordLightGrayConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_ACACIA_MOLD, ShovelLightGrayConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_ACACIA_MOLD, PickaxeLightGrayConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIGHT_GRAY_CONCRETE_POWDER_ACACIA_MOLD, AxeLightGrayConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIGHT_GRAY_CONCRETE_POWDER_ACACIA_MOLD, HoeLightGrayConcretePowderAcaciaMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIGHT_GRAY_CONCRETE_POWDER_DARK_OAK_MOLD, SwordLightGrayConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_DARK_OAK_MOLD, ShovelLightGrayConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_DARK_OAK_MOLD, PickaxeLightGrayConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIGHT_GRAY_CONCRETE_POWDER_DARK_OAK_MOLD, AxeLightGrayConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIGHT_GRAY_CONCRETE_POWDER_DARK_OAK_MOLD, HoeLightGrayConcretePowderDarkOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIGHT_GRAY_CONCRETE_POWDER_MANGROVE_MOLD, SwordLightGrayConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_MANGROVE_MOLD, ShovelLightGrayConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_MANGROVE_MOLD, PickaxeLightGrayConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIGHT_GRAY_CONCRETE_POWDER_MANGROVE_MOLD, AxeLightGrayConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIGHT_GRAY_CONCRETE_POWDER_MANGROVE_MOLD, HoeLightGrayConcretePowderMangroveMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIGHT_GRAY_CONCRETE_POWDER_CHERRY_MOLD, SwordLightGrayConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_CHERRY_MOLD, ShovelLightGrayConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_CHERRY_MOLD, PickaxeLightGrayConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIGHT_GRAY_CONCRETE_POWDER_CHERRY_MOLD, AxeLightGrayConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIGHT_GRAY_CONCRETE_POWDER_CHERRY_MOLD, HoeLightGrayConcretePowderCherryMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIGHT_GRAY_CONCRETE_POWDER_BAMBOO_MOLD, SwordLightGrayConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_BAMBOO_MOLD, ShovelLightGrayConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_BAMBOO_MOLD, PickaxeLightGrayConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIGHT_GRAY_CONCRETE_POWDER_BAMBOO_MOLD, AxeLightGrayConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIGHT_GRAY_CONCRETE_POWDER_BAMBOO_MOLD, HoeLightGrayConcretePowderBambooMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIGHT_GRAY_CONCRETE_POWDER_CRIMSON_MOLD, SwordLightGrayConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_CRIMSON_MOLD, ShovelLightGrayConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_CRIMSON_MOLD, PickaxeLightGrayConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIGHT_GRAY_CONCRETE_POWDER_CRIMSON_MOLD, AxeLightGrayConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIGHT_GRAY_CONCRETE_POWDER_CRIMSON_MOLD, HoeLightGrayConcretePowderCrimsonMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIGHT_GRAY_CONCRETE_POWDER_WARPED_MOLD, SwordLightGrayConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_WARPED_MOLD, ShovelLightGrayConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_WARPED_MOLD, PickaxeLightGrayConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIGHT_GRAY_CONCRETE_POWDER_WARPED_MOLD, AxeLightGrayConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIGHT_GRAY_CONCRETE_POWDER_WARPED_MOLD, HoeLightGrayConcretePowderWarpedMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_GRAY_CONCRETE_POWDER_OAK_MOLD, SwordGrayConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_GRAY_CONCRETE_POWDER_OAK_MOLD, ShovelGrayConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_GRAY_CONCRETE_POWDER_OAK_MOLD, PickaxeGrayConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_GRAY_CONCRETE_POWDER_OAK_MOLD, AxeGrayConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_GRAY_CONCRETE_POWDER_OAK_MOLD, HoeGrayConcretePowderOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_GRAY_CONCRETE_POWDER_SPRUCE_MOLD, SwordGrayConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_GRAY_CONCRETE_POWDER_SPRUCE_MOLD, ShovelGrayConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_GRAY_CONCRETE_POWDER_SPRUCE_MOLD, PickaxeGrayConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_GRAY_CONCRETE_POWDER_SPRUCE_MOLD, AxeGrayConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_GRAY_CONCRETE_POWDER_SPRUCE_MOLD, HoeGrayConcretePowderSpruceMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_GRAY_CONCRETE_POWDER_BIRCH_MOLD, SwordGrayConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_GRAY_CONCRETE_POWDER_BIRCH_MOLD, ShovelGrayConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_GRAY_CONCRETE_POWDER_BIRCH_MOLD, PickaxeGrayConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_GRAY_CONCRETE_POWDER_BIRCH_MOLD, AxeGrayConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_GRAY_CONCRETE_POWDER_BIRCH_MOLD, HoeGrayConcretePowderBirchMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_GRAY_CONCRETE_POWDER_JUNGLE_MOLD, SwordGrayConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_GRAY_CONCRETE_POWDER_JUNGLE_MOLD, ShovelGrayConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_GRAY_CONCRETE_POWDER_JUNGLE_MOLD, PickaxeGrayConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_GRAY_CONCRETE_POWDER_JUNGLE_MOLD, AxeGrayConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_GRAY_CONCRETE_POWDER_JUNGLE_MOLD, HoeGrayConcretePowderJungleMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_GRAY_CONCRETE_POWDER_ACACIA_MOLD, SwordGrayConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_GRAY_CONCRETE_POWDER_ACACIA_MOLD, ShovelGrayConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_GRAY_CONCRETE_POWDER_ACACIA_MOLD, PickaxeGrayConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_GRAY_CONCRETE_POWDER_ACACIA_MOLD, AxeGrayConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_GRAY_CONCRETE_POWDER_ACACIA_MOLD, HoeGrayConcretePowderAcaciaMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_GRAY_CONCRETE_POWDER_DARK_OAK_MOLD, SwordGrayConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_GRAY_CONCRETE_POWDER_DARK_OAK_MOLD, ShovelGrayConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_GRAY_CONCRETE_POWDER_DARK_OAK_MOLD, PickaxeGrayConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_GRAY_CONCRETE_POWDER_DARK_OAK_MOLD, AxeGrayConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_GRAY_CONCRETE_POWDER_DARK_OAK_MOLD, HoeGrayConcretePowderDarkOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_GRAY_CONCRETE_POWDER_MANGROVE_MOLD, SwordGrayConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_GRAY_CONCRETE_POWDER_MANGROVE_MOLD, ShovelGrayConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_GRAY_CONCRETE_POWDER_MANGROVE_MOLD, PickaxeGrayConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_GRAY_CONCRETE_POWDER_MANGROVE_MOLD, AxeGrayConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_GRAY_CONCRETE_POWDER_MANGROVE_MOLD, HoeGrayConcretePowderMangroveMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_GRAY_CONCRETE_POWDER_CHERRY_MOLD, SwordGrayConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_GRAY_CONCRETE_POWDER_CHERRY_MOLD, ShovelGrayConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_GRAY_CONCRETE_POWDER_CHERRY_MOLD, PickaxeGrayConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_GRAY_CONCRETE_POWDER_CHERRY_MOLD, AxeGrayConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_GRAY_CONCRETE_POWDER_CHERRY_MOLD, HoeGrayConcretePowderCherryMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_GRAY_CONCRETE_POWDER_BAMBOO_MOLD, SwordGrayConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_GRAY_CONCRETE_POWDER_BAMBOO_MOLD, ShovelGrayConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_GRAY_CONCRETE_POWDER_BAMBOO_MOLD, PickaxeGrayConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_GRAY_CONCRETE_POWDER_BAMBOO_MOLD, AxeGrayConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_GRAY_CONCRETE_POWDER_BAMBOO_MOLD, HoeGrayConcretePowderBambooMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_GRAY_CONCRETE_POWDER_CRIMSON_MOLD, SwordGrayConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_GRAY_CONCRETE_POWDER_CRIMSON_MOLD, ShovelGrayConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_GRAY_CONCRETE_POWDER_CRIMSON_MOLD, PickaxeGrayConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_GRAY_CONCRETE_POWDER_CRIMSON_MOLD, AxeGrayConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_GRAY_CONCRETE_POWDER_CRIMSON_MOLD, HoeGrayConcretePowderCrimsonMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_GRAY_CONCRETE_POWDER_WARPED_MOLD, SwordGrayConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_GRAY_CONCRETE_POWDER_WARPED_MOLD, ShovelGrayConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_GRAY_CONCRETE_POWDER_WARPED_MOLD, PickaxeGrayConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_GRAY_CONCRETE_POWDER_WARPED_MOLD, AxeGrayConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_GRAY_CONCRETE_POWDER_WARPED_MOLD, HoeGrayConcretePowderWarpedMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BLACK_CONCRETE_POWDER_OAK_MOLD, SwordBlackConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BLACK_CONCRETE_POWDER_OAK_MOLD, ShovelBlackConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BLACK_CONCRETE_POWDER_OAK_MOLD, PickaxeBlackConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BLACK_CONCRETE_POWDER_OAK_MOLD, AxeBlackConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BLACK_CONCRETE_POWDER_OAK_MOLD, HoeBlackConcretePowderOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BLACK_CONCRETE_POWDER_SPRUCE_MOLD, SwordBlackConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BLACK_CONCRETE_POWDER_SPRUCE_MOLD, ShovelBlackConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BLACK_CONCRETE_POWDER_SPRUCE_MOLD, PickaxeBlackConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BLACK_CONCRETE_POWDER_SPRUCE_MOLD, AxeBlackConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BLACK_CONCRETE_POWDER_SPRUCE_MOLD, HoeBlackConcretePowderSpruceMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BLACK_CONCRETE_POWDER_BIRCH_MOLD, SwordBlackConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BLACK_CONCRETE_POWDER_BIRCH_MOLD, ShovelBlackConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BLACK_CONCRETE_POWDER_BIRCH_MOLD, PickaxeBlackConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BLACK_CONCRETE_POWDER_BIRCH_MOLD, AxeBlackConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BLACK_CONCRETE_POWDER_BIRCH_MOLD, HoeBlackConcretePowderBirchMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BLACK_CONCRETE_POWDER_JUNGLE_MOLD, SwordBlackConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BLACK_CONCRETE_POWDER_JUNGLE_MOLD, ShovelBlackConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BLACK_CONCRETE_POWDER_JUNGLE_MOLD, PickaxeBlackConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BLACK_CONCRETE_POWDER_JUNGLE_MOLD, AxeBlackConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BLACK_CONCRETE_POWDER_JUNGLE_MOLD, HoeBlackConcretePowderJungleMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BLACK_CONCRETE_POWDER_ACACIA_MOLD, SwordBlackConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BLACK_CONCRETE_POWDER_ACACIA_MOLD, ShovelBlackConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BLACK_CONCRETE_POWDER_ACACIA_MOLD, PickaxeBlackConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BLACK_CONCRETE_POWDER_ACACIA_MOLD, AxeBlackConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BLACK_CONCRETE_POWDER_ACACIA_MOLD, HoeBlackConcretePowderAcaciaMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BLACK_CONCRETE_POWDER_DARK_OAK_MOLD, SwordBlackConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BLACK_CONCRETE_POWDER_DARK_OAK_MOLD, ShovelBlackConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BLACK_CONCRETE_POWDER_DARK_OAK_MOLD, PickaxeBlackConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BLACK_CONCRETE_POWDER_DARK_OAK_MOLD, AxeBlackConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BLACK_CONCRETE_POWDER_DARK_OAK_MOLD, HoeBlackConcretePowderDarkOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BLACK_CONCRETE_POWDER_MANGROVE_MOLD, SwordBlackConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BLACK_CONCRETE_POWDER_MANGROVE_MOLD, ShovelBlackConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BLACK_CONCRETE_POWDER_MANGROVE_MOLD, PickaxeBlackConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BLACK_CONCRETE_POWDER_MANGROVE_MOLD, AxeBlackConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BLACK_CONCRETE_POWDER_MANGROVE_MOLD, HoeBlackConcretePowderMangroveMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BLACK_CONCRETE_POWDER_CHERRY_MOLD, SwordBlackConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BLACK_CONCRETE_POWDER_CHERRY_MOLD, ShovelBlackConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BLACK_CONCRETE_POWDER_CHERRY_MOLD, PickaxeBlackConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BLACK_CONCRETE_POWDER_CHERRY_MOLD, AxeBlackConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BLACK_CONCRETE_POWDER_CHERRY_MOLD, HoeBlackConcretePowderCherryMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BLACK_CONCRETE_POWDER_BAMBOO_MOLD, SwordBlackConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BLACK_CONCRETE_POWDER_BAMBOO_MOLD, ShovelBlackConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BLACK_CONCRETE_POWDER_BAMBOO_MOLD, PickaxeBlackConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BLACK_CONCRETE_POWDER_BAMBOO_MOLD, AxeBlackConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BLACK_CONCRETE_POWDER_BAMBOO_MOLD, HoeBlackConcretePowderBambooMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BLACK_CONCRETE_POWDER_CRIMSON_MOLD, SwordBlackConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BLACK_CONCRETE_POWDER_CRIMSON_MOLD, ShovelBlackConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BLACK_CONCRETE_POWDER_CRIMSON_MOLD, PickaxeBlackConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BLACK_CONCRETE_POWDER_CRIMSON_MOLD, AxeBlackConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BLACK_CONCRETE_POWDER_CRIMSON_MOLD, HoeBlackConcretePowderCrimsonMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BLACK_CONCRETE_POWDER_WARPED_MOLD, SwordBlackConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BLACK_CONCRETE_POWDER_WARPED_MOLD, ShovelBlackConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BLACK_CONCRETE_POWDER_WARPED_MOLD, PickaxeBlackConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BLACK_CONCRETE_POWDER_WARPED_MOLD, AxeBlackConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BLACK_CONCRETE_POWDER_WARPED_MOLD, HoeBlackConcretePowderWarpedMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BROWN_CONCRETE_POWDER_OAK_MOLD, SwordBrownConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BROWN_CONCRETE_POWDER_OAK_MOLD, ShovelBrownConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BROWN_CONCRETE_POWDER_OAK_MOLD, PickaxeBrownConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BROWN_CONCRETE_POWDER_OAK_MOLD, AxeBrownConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BROWN_CONCRETE_POWDER_OAK_MOLD, HoeBrownConcretePowderOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BROWN_CONCRETE_POWDER_SPRUCE_MOLD, SwordBrownConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BROWN_CONCRETE_POWDER_SPRUCE_MOLD, ShovelBrownConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BROWN_CONCRETE_POWDER_SPRUCE_MOLD, PickaxeBrownConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BROWN_CONCRETE_POWDER_SPRUCE_MOLD, AxeBrownConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BROWN_CONCRETE_POWDER_SPRUCE_MOLD, HoeBrownConcretePowderSpruceMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BROWN_CONCRETE_POWDER_BIRCH_MOLD, SwordBrownConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BROWN_CONCRETE_POWDER_BIRCH_MOLD, ShovelBrownConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BROWN_CONCRETE_POWDER_BIRCH_MOLD, PickaxeBrownConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BROWN_CONCRETE_POWDER_BIRCH_MOLD, AxeBrownConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BROWN_CONCRETE_POWDER_BIRCH_MOLD, HoeBrownConcretePowderBirchMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BROWN_CONCRETE_POWDER_JUNGLE_MOLD, SwordBrownConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BROWN_CONCRETE_POWDER_JUNGLE_MOLD, ShovelBrownConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BROWN_CONCRETE_POWDER_JUNGLE_MOLD, PickaxeBrownConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BROWN_CONCRETE_POWDER_JUNGLE_MOLD, AxeBrownConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BROWN_CONCRETE_POWDER_JUNGLE_MOLD, HoeBrownConcretePowderJungleMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BROWN_CONCRETE_POWDER_ACACIA_MOLD, SwordBrownConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BROWN_CONCRETE_POWDER_ACACIA_MOLD, ShovelBrownConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BROWN_CONCRETE_POWDER_ACACIA_MOLD, PickaxeBrownConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BROWN_CONCRETE_POWDER_ACACIA_MOLD, AxeBrownConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BROWN_CONCRETE_POWDER_ACACIA_MOLD, HoeBrownConcretePowderAcaciaMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BROWN_CONCRETE_POWDER_DARK_OAK_MOLD, SwordBrownConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BROWN_CONCRETE_POWDER_DARK_OAK_MOLD, ShovelBrownConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BROWN_CONCRETE_POWDER_DARK_OAK_MOLD, PickaxeBrownConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BROWN_CONCRETE_POWDER_DARK_OAK_MOLD, AxeBrownConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BROWN_CONCRETE_POWDER_DARK_OAK_MOLD, HoeBrownConcretePowderDarkOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BROWN_CONCRETE_POWDER_MANGROVE_MOLD, SwordBrownConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BROWN_CONCRETE_POWDER_MANGROVE_MOLD, ShovelBrownConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BROWN_CONCRETE_POWDER_MANGROVE_MOLD, PickaxeBrownConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BROWN_CONCRETE_POWDER_MANGROVE_MOLD, AxeBrownConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BROWN_CONCRETE_POWDER_MANGROVE_MOLD, HoeBrownConcretePowderMangroveMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BROWN_CONCRETE_POWDER_CHERRY_MOLD, SwordBrownConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BROWN_CONCRETE_POWDER_CHERRY_MOLD, ShovelBrownConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BROWN_CONCRETE_POWDER_CHERRY_MOLD, PickaxeBrownConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BROWN_CONCRETE_POWDER_CHERRY_MOLD, AxeBrownConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BROWN_CONCRETE_POWDER_CHERRY_MOLD, HoeBrownConcretePowderCherryMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BROWN_CONCRETE_POWDER_BAMBOO_MOLD, SwordBrownConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BROWN_CONCRETE_POWDER_BAMBOO_MOLD, ShovelBrownConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BROWN_CONCRETE_POWDER_BAMBOO_MOLD, PickaxeBrownConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BROWN_CONCRETE_POWDER_BAMBOO_MOLD, AxeBrownConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BROWN_CONCRETE_POWDER_BAMBOO_MOLD, HoeBrownConcretePowderBambooMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BROWN_CONCRETE_POWDER_CRIMSON_MOLD, SwordBrownConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BROWN_CONCRETE_POWDER_CRIMSON_MOLD, ShovelBrownConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BROWN_CONCRETE_POWDER_CRIMSON_MOLD, PickaxeBrownConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BROWN_CONCRETE_POWDER_CRIMSON_MOLD, AxeBrownConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BROWN_CONCRETE_POWDER_CRIMSON_MOLD, HoeBrownConcretePowderCrimsonMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BROWN_CONCRETE_POWDER_WARPED_MOLD, SwordBrownConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BROWN_CONCRETE_POWDER_WARPED_MOLD, ShovelBrownConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BROWN_CONCRETE_POWDER_WARPED_MOLD, PickaxeBrownConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BROWN_CONCRETE_POWDER_WARPED_MOLD, AxeBrownConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BROWN_CONCRETE_POWDER_WARPED_MOLD, HoeBrownConcretePowderWarpedMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_RED_CONCRETE_POWDER_OAK_MOLD, SwordRedConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_RED_CONCRETE_POWDER_OAK_MOLD, ShovelRedConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_RED_CONCRETE_POWDER_OAK_MOLD, PickaxeRedConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_RED_CONCRETE_POWDER_OAK_MOLD, AxeRedConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_RED_CONCRETE_POWDER_OAK_MOLD, HoeRedConcretePowderOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_RED_CONCRETE_POWDER_SPRUCE_MOLD, SwordRedConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_RED_CONCRETE_POWDER_SPRUCE_MOLD, ShovelRedConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_RED_CONCRETE_POWDER_SPRUCE_MOLD, PickaxeRedConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_RED_CONCRETE_POWDER_SPRUCE_MOLD, AxeRedConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_RED_CONCRETE_POWDER_SPRUCE_MOLD, HoeRedConcretePowderSpruceMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_RED_CONCRETE_POWDER_BIRCH_MOLD, SwordRedConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_RED_CONCRETE_POWDER_BIRCH_MOLD, ShovelRedConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_RED_CONCRETE_POWDER_BIRCH_MOLD, PickaxeRedConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_RED_CONCRETE_POWDER_BIRCH_MOLD, AxeRedConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_RED_CONCRETE_POWDER_BIRCH_MOLD, HoeRedConcretePowderBirchMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_RED_CONCRETE_POWDER_JUNGLE_MOLD, SwordRedConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_RED_CONCRETE_POWDER_JUNGLE_MOLD, ShovelRedConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_RED_CONCRETE_POWDER_JUNGLE_MOLD, PickaxeRedConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_RED_CONCRETE_POWDER_JUNGLE_MOLD, AxeRedConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_RED_CONCRETE_POWDER_JUNGLE_MOLD, HoeRedConcretePowderJungleMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_RED_CONCRETE_POWDER_ACACIA_MOLD, SwordRedConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_RED_CONCRETE_POWDER_ACACIA_MOLD, ShovelRedConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_RED_CONCRETE_POWDER_ACACIA_MOLD, PickaxeRedConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_RED_CONCRETE_POWDER_ACACIA_MOLD, AxeRedConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_RED_CONCRETE_POWDER_ACACIA_MOLD, HoeRedConcretePowderAcaciaMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_RED_CONCRETE_POWDER_DARK_OAK_MOLD, SwordRedConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_RED_CONCRETE_POWDER_DARK_OAK_MOLD, ShovelRedConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_RED_CONCRETE_POWDER_DARK_OAK_MOLD, PickaxeRedConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_RED_CONCRETE_POWDER_DARK_OAK_MOLD, AxeRedConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_RED_CONCRETE_POWDER_DARK_OAK_MOLD, HoeRedConcretePowderDarkOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_RED_CONCRETE_POWDER_MANGROVE_MOLD, SwordRedConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_RED_CONCRETE_POWDER_MANGROVE_MOLD, ShovelRedConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_RED_CONCRETE_POWDER_MANGROVE_MOLD, PickaxeRedConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_RED_CONCRETE_POWDER_MANGROVE_MOLD, AxeRedConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_RED_CONCRETE_POWDER_MANGROVE_MOLD, HoeRedConcretePowderMangroveMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_RED_CONCRETE_POWDER_CHERRY_MOLD, SwordRedConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_RED_CONCRETE_POWDER_CHERRY_MOLD, ShovelRedConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_RED_CONCRETE_POWDER_CHERRY_MOLD, PickaxeRedConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_RED_CONCRETE_POWDER_CHERRY_MOLD, AxeRedConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_RED_CONCRETE_POWDER_CHERRY_MOLD, HoeRedConcretePowderCherryMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_RED_CONCRETE_POWDER_BAMBOO_MOLD, SwordRedConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_RED_CONCRETE_POWDER_BAMBOO_MOLD, ShovelRedConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_RED_CONCRETE_POWDER_BAMBOO_MOLD, PickaxeRedConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_RED_CONCRETE_POWDER_BAMBOO_MOLD, AxeRedConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_RED_CONCRETE_POWDER_BAMBOO_MOLD, HoeRedConcretePowderBambooMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_RED_CONCRETE_POWDER_CRIMSON_MOLD, SwordRedConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_RED_CONCRETE_POWDER_CRIMSON_MOLD, ShovelRedConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_RED_CONCRETE_POWDER_CRIMSON_MOLD, PickaxeRedConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_RED_CONCRETE_POWDER_CRIMSON_MOLD, AxeRedConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_RED_CONCRETE_POWDER_CRIMSON_MOLD, HoeRedConcretePowderCrimsonMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_RED_CONCRETE_POWDER_WARPED_MOLD, SwordRedConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_RED_CONCRETE_POWDER_WARPED_MOLD, ShovelRedConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_RED_CONCRETE_POWDER_WARPED_MOLD, PickaxeRedConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_RED_CONCRETE_POWDER_WARPED_MOLD, AxeRedConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_RED_CONCRETE_POWDER_WARPED_MOLD, HoeRedConcretePowderWarpedMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_ORANGE_CONCRETE_POWDER_OAK_MOLD, SwordOrangeConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_ORANGE_CONCRETE_POWDER_OAK_MOLD, ShovelOrangeConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_ORANGE_CONCRETE_POWDER_OAK_MOLD, PickaxeOrangeConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_ORANGE_CONCRETE_POWDER_OAK_MOLD, AxeOrangeConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_ORANGE_CONCRETE_POWDER_OAK_MOLD, HoeOrangeConcretePowderOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_ORANGE_CONCRETE_POWDER_SPRUCE_MOLD, SwordOrangeConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_ORANGE_CONCRETE_POWDER_SPRUCE_MOLD, ShovelOrangeConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_ORANGE_CONCRETE_POWDER_SPRUCE_MOLD, PickaxeOrangeConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_ORANGE_CONCRETE_POWDER_SPRUCE_MOLD, AxeOrangeConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_ORANGE_CONCRETE_POWDER_SPRUCE_MOLD, HoeOrangeConcretePowderSpruceMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_ORANGE_CONCRETE_POWDER_BIRCH_MOLD, SwordOrangeConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_ORANGE_CONCRETE_POWDER_BIRCH_MOLD, ShovelOrangeConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_ORANGE_CONCRETE_POWDER_BIRCH_MOLD, PickaxeOrangeConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_ORANGE_CONCRETE_POWDER_BIRCH_MOLD, AxeOrangeConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_ORANGE_CONCRETE_POWDER_BIRCH_MOLD, HoeOrangeConcretePowderBirchMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_ORANGE_CONCRETE_POWDER_JUNGLE_MOLD, SwordOrangeConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_ORANGE_CONCRETE_POWDER_JUNGLE_MOLD, ShovelOrangeConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_ORANGE_CONCRETE_POWDER_JUNGLE_MOLD, PickaxeOrangeConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_ORANGE_CONCRETE_POWDER_JUNGLE_MOLD, AxeOrangeConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_ORANGE_CONCRETE_POWDER_JUNGLE_MOLD, HoeOrangeConcretePowderJungleMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_ORANGE_CONCRETE_POWDER_ACACIA_MOLD, SwordOrangeConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_ORANGE_CONCRETE_POWDER_ACACIA_MOLD, ShovelOrangeConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_ORANGE_CONCRETE_POWDER_ACACIA_MOLD, PickaxeOrangeConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_ORANGE_CONCRETE_POWDER_ACACIA_MOLD, AxeOrangeConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_ORANGE_CONCRETE_POWDER_ACACIA_MOLD, HoeOrangeConcretePowderAcaciaMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_ORANGE_CONCRETE_POWDER_DARK_OAK_MOLD, SwordOrangeConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_ORANGE_CONCRETE_POWDER_DARK_OAK_MOLD, ShovelOrangeConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_ORANGE_CONCRETE_POWDER_DARK_OAK_MOLD, PickaxeOrangeConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_ORANGE_CONCRETE_POWDER_DARK_OAK_MOLD, AxeOrangeConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_ORANGE_CONCRETE_POWDER_DARK_OAK_MOLD, HoeOrangeConcretePowderDarkOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_ORANGE_CONCRETE_POWDER_MANGROVE_MOLD, SwordOrangeConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_ORANGE_CONCRETE_POWDER_MANGROVE_MOLD, ShovelOrangeConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_ORANGE_CONCRETE_POWDER_MANGROVE_MOLD, PickaxeOrangeConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_ORANGE_CONCRETE_POWDER_MANGROVE_MOLD, AxeOrangeConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_ORANGE_CONCRETE_POWDER_MANGROVE_MOLD, HoeOrangeConcretePowderMangroveMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_ORANGE_CONCRETE_POWDER_CHERRY_MOLD, SwordOrangeConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_ORANGE_CONCRETE_POWDER_CHERRY_MOLD, ShovelOrangeConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_ORANGE_CONCRETE_POWDER_CHERRY_MOLD, PickaxeOrangeConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_ORANGE_CONCRETE_POWDER_CHERRY_MOLD, AxeOrangeConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_ORANGE_CONCRETE_POWDER_CHERRY_MOLD, HoeOrangeConcretePowderCherryMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_ORANGE_CONCRETE_POWDER_BAMBOO_MOLD, SwordOrangeConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_ORANGE_CONCRETE_POWDER_BAMBOO_MOLD, ShovelOrangeConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_ORANGE_CONCRETE_POWDER_BAMBOO_MOLD, PickaxeOrangeConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_ORANGE_CONCRETE_POWDER_BAMBOO_MOLD, AxeOrangeConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_ORANGE_CONCRETE_POWDER_BAMBOO_MOLD, HoeOrangeConcretePowderBambooMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_ORANGE_CONCRETE_POWDER_CRIMSON_MOLD, SwordOrangeConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_ORANGE_CONCRETE_POWDER_CRIMSON_MOLD, ShovelOrangeConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_ORANGE_CONCRETE_POWDER_CRIMSON_MOLD, PickaxeOrangeConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_ORANGE_CONCRETE_POWDER_CRIMSON_MOLD, AxeOrangeConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_ORANGE_CONCRETE_POWDER_CRIMSON_MOLD, HoeOrangeConcretePowderCrimsonMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_ORANGE_CONCRETE_POWDER_WARPED_MOLD, SwordOrangeConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_ORANGE_CONCRETE_POWDER_WARPED_MOLD, ShovelOrangeConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_ORANGE_CONCRETE_POWDER_WARPED_MOLD, PickaxeOrangeConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_ORANGE_CONCRETE_POWDER_WARPED_MOLD, AxeOrangeConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_ORANGE_CONCRETE_POWDER_WARPED_MOLD, HoeOrangeConcretePowderWarpedMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_YELLOW_CONCRETE_POWDER_OAK_MOLD, SwordYellowConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_YELLOW_CONCRETE_POWDER_OAK_MOLD, ShovelYellowConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_YELLOW_CONCRETE_POWDER_OAK_MOLD, PickaxeYellowConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_YELLOW_CONCRETE_POWDER_OAK_MOLD, AxeYellowConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_YELLOW_CONCRETE_POWDER_OAK_MOLD, HoeYellowConcretePowderOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_YELLOW_CONCRETE_POWDER_SPRUCE_MOLD, SwordYellowConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_YELLOW_CONCRETE_POWDER_SPRUCE_MOLD, ShovelYellowConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_YELLOW_CONCRETE_POWDER_SPRUCE_MOLD, PickaxeYellowConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_YELLOW_CONCRETE_POWDER_SPRUCE_MOLD, AxeYellowConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_YELLOW_CONCRETE_POWDER_SPRUCE_MOLD, HoeYellowConcretePowderSpruceMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_YELLOW_CONCRETE_POWDER_BIRCH_MOLD, SwordYellowConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_YELLOW_CONCRETE_POWDER_BIRCH_MOLD, ShovelYellowConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_YELLOW_CONCRETE_POWDER_BIRCH_MOLD, PickaxeYellowConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_YELLOW_CONCRETE_POWDER_BIRCH_MOLD, AxeYellowConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_YELLOW_CONCRETE_POWDER_BIRCH_MOLD, HoeYellowConcretePowderBirchMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_YELLOW_CONCRETE_POWDER_JUNGLE_MOLD, SwordYellowConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_YELLOW_CONCRETE_POWDER_JUNGLE_MOLD, ShovelYellowConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_YELLOW_CONCRETE_POWDER_JUNGLE_MOLD, PickaxeYellowConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_YELLOW_CONCRETE_POWDER_JUNGLE_MOLD, AxeYellowConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_YELLOW_CONCRETE_POWDER_JUNGLE_MOLD, HoeYellowConcretePowderJungleMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_YELLOW_CONCRETE_POWDER_ACACIA_MOLD, SwordYellowConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_YELLOW_CONCRETE_POWDER_ACACIA_MOLD, ShovelYellowConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_YELLOW_CONCRETE_POWDER_ACACIA_MOLD, PickaxeYellowConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_YELLOW_CONCRETE_POWDER_ACACIA_MOLD, AxeYellowConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_YELLOW_CONCRETE_POWDER_ACACIA_MOLD, HoeYellowConcretePowderAcaciaMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_YELLOW_CONCRETE_POWDER_DARK_OAK_MOLD, SwordYellowConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_YELLOW_CONCRETE_POWDER_DARK_OAK_MOLD, ShovelYellowConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_YELLOW_CONCRETE_POWDER_DARK_OAK_MOLD, PickaxeYellowConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_YELLOW_CONCRETE_POWDER_DARK_OAK_MOLD, AxeYellowConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_YELLOW_CONCRETE_POWDER_DARK_OAK_MOLD, HoeYellowConcretePowderDarkOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_YELLOW_CONCRETE_POWDER_MANGROVE_MOLD, SwordYellowConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_YELLOW_CONCRETE_POWDER_MANGROVE_MOLD, ShovelYellowConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_YELLOW_CONCRETE_POWDER_MANGROVE_MOLD, PickaxeYellowConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_YELLOW_CONCRETE_POWDER_MANGROVE_MOLD, AxeYellowConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_YELLOW_CONCRETE_POWDER_MANGROVE_MOLD, HoeYellowConcretePowderMangroveMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_YELLOW_CONCRETE_POWDER_CHERRY_MOLD, SwordYellowConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_YELLOW_CONCRETE_POWDER_CHERRY_MOLD, ShovelYellowConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_YELLOW_CONCRETE_POWDER_CHERRY_MOLD, PickaxeYellowConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_YELLOW_CONCRETE_POWDER_CHERRY_MOLD, AxeYellowConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_YELLOW_CONCRETE_POWDER_CHERRY_MOLD, HoeYellowConcretePowderCherryMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_YELLOW_CONCRETE_POWDER_BAMBOO_MOLD, SwordYellowConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_YELLOW_CONCRETE_POWDER_BAMBOO_MOLD, ShovelYellowConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_YELLOW_CONCRETE_POWDER_BAMBOO_MOLD, PickaxeYellowConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_YELLOW_CONCRETE_POWDER_BAMBOO_MOLD, AxeYellowConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_YELLOW_CONCRETE_POWDER_BAMBOO_MOLD, HoeYellowConcretePowderBambooMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_YELLOW_CONCRETE_POWDER_CRIMSON_MOLD, SwordYellowConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_YELLOW_CONCRETE_POWDER_CRIMSON_MOLD, ShovelYellowConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_YELLOW_CONCRETE_POWDER_CRIMSON_MOLD, PickaxeYellowConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_YELLOW_CONCRETE_POWDER_CRIMSON_MOLD, AxeYellowConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_YELLOW_CONCRETE_POWDER_CRIMSON_MOLD, HoeYellowConcretePowderCrimsonMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_YELLOW_CONCRETE_POWDER_WARPED_MOLD, SwordYellowConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_YELLOW_CONCRETE_POWDER_WARPED_MOLD, ShovelYellowConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_YELLOW_CONCRETE_POWDER_WARPED_MOLD, PickaxeYellowConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_YELLOW_CONCRETE_POWDER_WARPED_MOLD, AxeYellowConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_YELLOW_CONCRETE_POWDER_WARPED_MOLD, HoeYellowConcretePowderWarpedMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIME_CONCRETE_POWDER_OAK_MOLD, SwordLimeConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIME_CONCRETE_POWDER_OAK_MOLD, ShovelLimeConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIME_CONCRETE_POWDER_OAK_MOLD, PickaxeLimeConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIME_CONCRETE_POWDER_OAK_MOLD, AxeLimeConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIME_CONCRETE_POWDER_OAK_MOLD, HoeLimeConcretePowderOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIME_CONCRETE_POWDER_SPRUCE_MOLD, SwordLimeConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIME_CONCRETE_POWDER_SPRUCE_MOLD, ShovelLimeConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIME_CONCRETE_POWDER_SPRUCE_MOLD, PickaxeLimeConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIME_CONCRETE_POWDER_SPRUCE_MOLD, AxeLimeConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIME_CONCRETE_POWDER_SPRUCE_MOLD, HoeLimeConcretePowderSpruceMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIME_CONCRETE_POWDER_BIRCH_MOLD, SwordLimeConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIME_CONCRETE_POWDER_BIRCH_MOLD, ShovelLimeConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIME_CONCRETE_POWDER_BIRCH_MOLD, PickaxeLimeConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIME_CONCRETE_POWDER_BIRCH_MOLD, AxeLimeConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIME_CONCRETE_POWDER_BIRCH_MOLD, HoeLimeConcretePowderBirchMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIME_CONCRETE_POWDER_JUNGLE_MOLD, SwordLimeConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIME_CONCRETE_POWDER_JUNGLE_MOLD, ShovelLimeConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIME_CONCRETE_POWDER_JUNGLE_MOLD, PickaxeLimeConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIME_CONCRETE_POWDER_JUNGLE_MOLD, AxeLimeConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIME_CONCRETE_POWDER_JUNGLE_MOLD, HoeLimeConcretePowderJungleMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIME_CONCRETE_POWDER_ACACIA_MOLD, SwordLimeConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIME_CONCRETE_POWDER_ACACIA_MOLD, ShovelLimeConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIME_CONCRETE_POWDER_ACACIA_MOLD, PickaxeLimeConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIME_CONCRETE_POWDER_ACACIA_MOLD, AxeLimeConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIME_CONCRETE_POWDER_ACACIA_MOLD, HoeLimeConcretePowderAcaciaMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIME_CONCRETE_POWDER_DARK_OAK_MOLD, SwordLimeConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIME_CONCRETE_POWDER_DARK_OAK_MOLD, ShovelLimeConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIME_CONCRETE_POWDER_DARK_OAK_MOLD, PickaxeLimeConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIME_CONCRETE_POWDER_DARK_OAK_MOLD, AxeLimeConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIME_CONCRETE_POWDER_DARK_OAK_MOLD, HoeLimeConcretePowderDarkOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIME_CONCRETE_POWDER_MANGROVE_MOLD, SwordLimeConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIME_CONCRETE_POWDER_MANGROVE_MOLD, ShovelLimeConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIME_CONCRETE_POWDER_MANGROVE_MOLD, PickaxeLimeConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIME_CONCRETE_POWDER_MANGROVE_MOLD, AxeLimeConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIME_CONCRETE_POWDER_MANGROVE_MOLD, HoeLimeConcretePowderMangroveMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIME_CONCRETE_POWDER_CHERRY_MOLD, SwordLimeConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIME_CONCRETE_POWDER_CHERRY_MOLD, ShovelLimeConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIME_CONCRETE_POWDER_CHERRY_MOLD, PickaxeLimeConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIME_CONCRETE_POWDER_CHERRY_MOLD, AxeLimeConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIME_CONCRETE_POWDER_CHERRY_MOLD, HoeLimeConcretePowderCherryMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIME_CONCRETE_POWDER_BAMBOO_MOLD, SwordLimeConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIME_CONCRETE_POWDER_BAMBOO_MOLD, ShovelLimeConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIME_CONCRETE_POWDER_BAMBOO_MOLD, PickaxeLimeConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIME_CONCRETE_POWDER_BAMBOO_MOLD, AxeLimeConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIME_CONCRETE_POWDER_BAMBOO_MOLD, HoeLimeConcretePowderBambooMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIME_CONCRETE_POWDER_CRIMSON_MOLD, SwordLimeConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIME_CONCRETE_POWDER_CRIMSON_MOLD, ShovelLimeConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIME_CONCRETE_POWDER_CRIMSON_MOLD, PickaxeLimeConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIME_CONCRETE_POWDER_CRIMSON_MOLD, AxeLimeConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIME_CONCRETE_POWDER_CRIMSON_MOLD, HoeLimeConcretePowderCrimsonMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIME_CONCRETE_POWDER_WARPED_MOLD, SwordLimeConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIME_CONCRETE_POWDER_WARPED_MOLD, ShovelLimeConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIME_CONCRETE_POWDER_WARPED_MOLD, PickaxeLimeConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIME_CONCRETE_POWDER_WARPED_MOLD, AxeLimeConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIME_CONCRETE_POWDER_WARPED_MOLD, HoeLimeConcretePowderWarpedMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_GREEN_CONCRETE_POWDER_OAK_MOLD, SwordGreenConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_GREEN_CONCRETE_POWDER_OAK_MOLD, ShovelGreenConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_GREEN_CONCRETE_POWDER_OAK_MOLD, PickaxeGreenConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_GREEN_CONCRETE_POWDER_OAK_MOLD, AxeGreenConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_GREEN_CONCRETE_POWDER_OAK_MOLD, HoeGreenConcretePowderOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_GREEN_CONCRETE_POWDER_SPRUCE_MOLD, SwordGreenConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_GREEN_CONCRETE_POWDER_SPRUCE_MOLD, ShovelGreenConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_GREEN_CONCRETE_POWDER_SPRUCE_MOLD, PickaxeGreenConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_GREEN_CONCRETE_POWDER_SPRUCE_MOLD, AxeGreenConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_GREEN_CONCRETE_POWDER_SPRUCE_MOLD, HoeGreenConcretePowderSpruceMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_GREEN_CONCRETE_POWDER_BIRCH_MOLD, SwordGreenConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_GREEN_CONCRETE_POWDER_BIRCH_MOLD, ShovelGreenConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_GREEN_CONCRETE_POWDER_BIRCH_MOLD, PickaxeGreenConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_GREEN_CONCRETE_POWDER_BIRCH_MOLD, AxeGreenConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_GREEN_CONCRETE_POWDER_BIRCH_MOLD, HoeGreenConcretePowderBirchMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_GREEN_CONCRETE_POWDER_JUNGLE_MOLD, SwordGreenConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_GREEN_CONCRETE_POWDER_JUNGLE_MOLD, ShovelGreenConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_GREEN_CONCRETE_POWDER_JUNGLE_MOLD, PickaxeGreenConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_GREEN_CONCRETE_POWDER_JUNGLE_MOLD, AxeGreenConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_GREEN_CONCRETE_POWDER_JUNGLE_MOLD, HoeGreenConcretePowderJungleMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_GREEN_CONCRETE_POWDER_ACACIA_MOLD, SwordGreenConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_GREEN_CONCRETE_POWDER_ACACIA_MOLD, ShovelGreenConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_GREEN_CONCRETE_POWDER_ACACIA_MOLD, PickaxeGreenConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_GREEN_CONCRETE_POWDER_ACACIA_MOLD, AxeGreenConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_GREEN_CONCRETE_POWDER_ACACIA_MOLD, HoeGreenConcretePowderAcaciaMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_GREEN_CONCRETE_POWDER_DARK_OAK_MOLD, SwordGreenConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_GREEN_CONCRETE_POWDER_DARK_OAK_MOLD, ShovelGreenConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_GREEN_CONCRETE_POWDER_DARK_OAK_MOLD, PickaxeGreenConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_GREEN_CONCRETE_POWDER_DARK_OAK_MOLD, AxeGreenConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_GREEN_CONCRETE_POWDER_DARK_OAK_MOLD, HoeGreenConcretePowderDarkOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_GREEN_CONCRETE_POWDER_MANGROVE_MOLD, SwordGreenConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_GREEN_CONCRETE_POWDER_MANGROVE_MOLD, ShovelGreenConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_GREEN_CONCRETE_POWDER_MANGROVE_MOLD, PickaxeGreenConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_GREEN_CONCRETE_POWDER_MANGROVE_MOLD, AxeGreenConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_GREEN_CONCRETE_POWDER_MANGROVE_MOLD, HoeGreenConcretePowderMangroveMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_GREEN_CONCRETE_POWDER_CHERRY_MOLD, SwordGreenConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_GREEN_CONCRETE_POWDER_CHERRY_MOLD, ShovelGreenConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_GREEN_CONCRETE_POWDER_CHERRY_MOLD, PickaxeGreenConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_GREEN_CONCRETE_POWDER_CHERRY_MOLD, AxeGreenConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_GREEN_CONCRETE_POWDER_CHERRY_MOLD, HoeGreenConcretePowderCherryMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_GREEN_CONCRETE_POWDER_BAMBOO_MOLD, SwordGreenConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_GREEN_CONCRETE_POWDER_BAMBOO_MOLD, ShovelGreenConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_GREEN_CONCRETE_POWDER_BAMBOO_MOLD, PickaxeGreenConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_GREEN_CONCRETE_POWDER_BAMBOO_MOLD, AxeGreenConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_GREEN_CONCRETE_POWDER_BAMBOO_MOLD, HoeGreenConcretePowderBambooMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_GREEN_CONCRETE_POWDER_CRIMSON_MOLD, SwordGreenConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_GREEN_CONCRETE_POWDER_CRIMSON_MOLD, ShovelGreenConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_GREEN_CONCRETE_POWDER_CRIMSON_MOLD, PickaxeGreenConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_GREEN_CONCRETE_POWDER_CRIMSON_MOLD, AxeGreenConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_GREEN_CONCRETE_POWDER_CRIMSON_MOLD, HoeGreenConcretePowderCrimsonMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_GREEN_CONCRETE_POWDER_WARPED_MOLD, SwordGreenConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_GREEN_CONCRETE_POWDER_WARPED_MOLD, ShovelGreenConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_GREEN_CONCRETE_POWDER_WARPED_MOLD, PickaxeGreenConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_GREEN_CONCRETE_POWDER_WARPED_MOLD, AxeGreenConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_GREEN_CONCRETE_POWDER_WARPED_MOLD, HoeGreenConcretePowderWarpedMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_CYAN_CONCRETE_POWDER_OAK_MOLD, SwordCyanConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_CYAN_CONCRETE_POWDER_OAK_MOLD, ShovelCyanConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_CYAN_CONCRETE_POWDER_OAK_MOLD, PickaxeCyanConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_CYAN_CONCRETE_POWDER_OAK_MOLD, AxeCyanConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_CYAN_CONCRETE_POWDER_OAK_MOLD, HoeCyanConcretePowderOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_CYAN_CONCRETE_POWDER_SPRUCE_MOLD, SwordCyanConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_CYAN_CONCRETE_POWDER_SPRUCE_MOLD, ShovelCyanConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_CYAN_CONCRETE_POWDER_SPRUCE_MOLD, PickaxeCyanConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_CYAN_CONCRETE_POWDER_SPRUCE_MOLD, AxeCyanConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_CYAN_CONCRETE_POWDER_SPRUCE_MOLD, HoeCyanConcretePowderSpruceMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_CYAN_CONCRETE_POWDER_BIRCH_MOLD, SwordCyanConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_CYAN_CONCRETE_POWDER_BIRCH_MOLD, ShovelCyanConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_CYAN_CONCRETE_POWDER_BIRCH_MOLD, PickaxeCyanConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_CYAN_CONCRETE_POWDER_BIRCH_MOLD, AxeCyanConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_CYAN_CONCRETE_POWDER_BIRCH_MOLD, HoeCyanConcretePowderBirchMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_CYAN_CONCRETE_POWDER_JUNGLE_MOLD, SwordCyanConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_CYAN_CONCRETE_POWDER_JUNGLE_MOLD, ShovelCyanConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_CYAN_CONCRETE_POWDER_JUNGLE_MOLD, PickaxeCyanConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_CYAN_CONCRETE_POWDER_JUNGLE_MOLD, AxeCyanConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_CYAN_CONCRETE_POWDER_JUNGLE_MOLD, HoeCyanConcretePowderJungleMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_CYAN_CONCRETE_POWDER_ACACIA_MOLD, SwordCyanConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_CYAN_CONCRETE_POWDER_ACACIA_MOLD, ShovelCyanConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_CYAN_CONCRETE_POWDER_ACACIA_MOLD, PickaxeCyanConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_CYAN_CONCRETE_POWDER_ACACIA_MOLD, AxeCyanConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_CYAN_CONCRETE_POWDER_ACACIA_MOLD, HoeCyanConcretePowderAcaciaMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_CYAN_CONCRETE_POWDER_DARK_OAK_MOLD, SwordCyanConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_CYAN_CONCRETE_POWDER_DARK_OAK_MOLD, ShovelCyanConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_CYAN_CONCRETE_POWDER_DARK_OAK_MOLD, PickaxeCyanConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_CYAN_CONCRETE_POWDER_DARK_OAK_MOLD, AxeCyanConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_CYAN_CONCRETE_POWDER_DARK_OAK_MOLD, HoeCyanConcretePowderDarkOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_CYAN_CONCRETE_POWDER_MANGROVE_MOLD, SwordCyanConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_CYAN_CONCRETE_POWDER_MANGROVE_MOLD, ShovelCyanConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_CYAN_CONCRETE_POWDER_MANGROVE_MOLD, PickaxeCyanConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_CYAN_CONCRETE_POWDER_MANGROVE_MOLD, AxeCyanConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_CYAN_CONCRETE_POWDER_MANGROVE_MOLD, HoeCyanConcretePowderMangroveMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_CYAN_CONCRETE_POWDER_CHERRY_MOLD, SwordCyanConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_CYAN_CONCRETE_POWDER_CHERRY_MOLD, ShovelCyanConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_CYAN_CONCRETE_POWDER_CHERRY_MOLD, PickaxeCyanConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_CYAN_CONCRETE_POWDER_CHERRY_MOLD, AxeCyanConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_CYAN_CONCRETE_POWDER_CHERRY_MOLD, HoeCyanConcretePowderCherryMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_CYAN_CONCRETE_POWDER_BAMBOO_MOLD, SwordCyanConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_CYAN_CONCRETE_POWDER_BAMBOO_MOLD, ShovelCyanConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_CYAN_CONCRETE_POWDER_BAMBOO_MOLD, PickaxeCyanConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_CYAN_CONCRETE_POWDER_BAMBOO_MOLD, AxeCyanConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_CYAN_CONCRETE_POWDER_BAMBOO_MOLD, HoeCyanConcretePowderBambooMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_CYAN_CONCRETE_POWDER_CRIMSON_MOLD, SwordCyanConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_CYAN_CONCRETE_POWDER_CRIMSON_MOLD, ShovelCyanConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_CYAN_CONCRETE_POWDER_CRIMSON_MOLD, PickaxeCyanConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_CYAN_CONCRETE_POWDER_CRIMSON_MOLD, AxeCyanConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_CYAN_CONCRETE_POWDER_CRIMSON_MOLD, HoeCyanConcretePowderCrimsonMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_CYAN_CONCRETE_POWDER_WARPED_MOLD, SwordCyanConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_CYAN_CONCRETE_POWDER_WARPED_MOLD, ShovelCyanConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_CYAN_CONCRETE_POWDER_WARPED_MOLD, PickaxeCyanConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_CYAN_CONCRETE_POWDER_WARPED_MOLD, AxeCyanConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_CYAN_CONCRETE_POWDER_WARPED_MOLD, HoeCyanConcretePowderWarpedMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIGHT_BLUE_CONCRETE_POWDER_OAK_MOLD, SwordLightBlueConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_OAK_MOLD, ShovelLightBlueConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_OAK_MOLD, PickaxeLightBlueConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIGHT_BLUE_CONCRETE_POWDER_OAK_MOLD, AxeLightBlueConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIGHT_BLUE_CONCRETE_POWDER_OAK_MOLD, HoeLightBlueConcretePowderOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIGHT_BLUE_CONCRETE_POWDER_SPRUCE_MOLD, SwordLightBlueConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_SPRUCE_MOLD, ShovelLightBlueConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_SPRUCE_MOLD, PickaxeLightBlueConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIGHT_BLUE_CONCRETE_POWDER_SPRUCE_MOLD, AxeLightBlueConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIGHT_BLUE_CONCRETE_POWDER_SPRUCE_MOLD, HoeLightBlueConcretePowderSpruceMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIGHT_BLUE_CONCRETE_POWDER_BIRCH_MOLD, SwordLightBlueConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_BIRCH_MOLD, ShovelLightBlueConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_BIRCH_MOLD, PickaxeLightBlueConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIGHT_BLUE_CONCRETE_POWDER_BIRCH_MOLD, AxeLightBlueConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIGHT_BLUE_CONCRETE_POWDER_BIRCH_MOLD, HoeLightBlueConcretePowderBirchMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIGHT_BLUE_CONCRETE_POWDER_JUNGLE_MOLD, SwordLightBlueConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_JUNGLE_MOLD, ShovelLightBlueConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_JUNGLE_MOLD, PickaxeLightBlueConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIGHT_BLUE_CONCRETE_POWDER_JUNGLE_MOLD, AxeLightBlueConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIGHT_BLUE_CONCRETE_POWDER_JUNGLE_MOLD, HoeLightBlueConcretePowderJungleMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIGHT_BLUE_CONCRETE_POWDER_ACACIA_MOLD, SwordLightBlueConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_ACACIA_MOLD, ShovelLightBlueConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_ACACIA_MOLD, PickaxeLightBlueConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIGHT_BLUE_CONCRETE_POWDER_ACACIA_MOLD, AxeLightBlueConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIGHT_BLUE_CONCRETE_POWDER_ACACIA_MOLD, HoeLightBlueConcretePowderAcaciaMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIGHT_BLUE_CONCRETE_POWDER_DARK_OAK_MOLD, SwordLightBlueConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_DARK_OAK_MOLD, ShovelLightBlueConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_DARK_OAK_MOLD, PickaxeLightBlueConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIGHT_BLUE_CONCRETE_POWDER_DARK_OAK_MOLD, AxeLightBlueConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIGHT_BLUE_CONCRETE_POWDER_DARK_OAK_MOLD, HoeLightBlueConcretePowderDarkOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIGHT_BLUE_CONCRETE_POWDER_MANGROVE_MOLD, SwordLightBlueConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_MANGROVE_MOLD, ShovelLightBlueConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_MANGROVE_MOLD, PickaxeLightBlueConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIGHT_BLUE_CONCRETE_POWDER_MANGROVE_MOLD, AxeLightBlueConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIGHT_BLUE_CONCRETE_POWDER_MANGROVE_MOLD, HoeLightBlueConcretePowderMangroveMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIGHT_BLUE_CONCRETE_POWDER_CHERRY_MOLD, SwordLightBlueConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_CHERRY_MOLD, ShovelLightBlueConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_CHERRY_MOLD, PickaxeLightBlueConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIGHT_BLUE_CONCRETE_POWDER_CHERRY_MOLD, AxeLightBlueConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIGHT_BLUE_CONCRETE_POWDER_CHERRY_MOLD, HoeLightBlueConcretePowderCherryMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIGHT_BLUE_CONCRETE_POWDER_BAMBOO_MOLD, SwordLightBlueConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_BAMBOO_MOLD, ShovelLightBlueConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_BAMBOO_MOLD, PickaxeLightBlueConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIGHT_BLUE_CONCRETE_POWDER_BAMBOO_MOLD, AxeLightBlueConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIGHT_BLUE_CONCRETE_POWDER_BAMBOO_MOLD, HoeLightBlueConcretePowderBambooMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIGHT_BLUE_CONCRETE_POWDER_CRIMSON_MOLD, SwordLightBlueConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_CRIMSON_MOLD, ShovelLightBlueConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_CRIMSON_MOLD, PickaxeLightBlueConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIGHT_BLUE_CONCRETE_POWDER_CRIMSON_MOLD, AxeLightBlueConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIGHT_BLUE_CONCRETE_POWDER_CRIMSON_MOLD, HoeLightBlueConcretePowderCrimsonMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_LIGHT_BLUE_CONCRETE_POWDER_WARPED_MOLD, SwordLightBlueConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_WARPED_MOLD, ShovelLightBlueConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_WARPED_MOLD, PickaxeLightBlueConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_LIGHT_BLUE_CONCRETE_POWDER_WARPED_MOLD, AxeLightBlueConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_LIGHT_BLUE_CONCRETE_POWDER_WARPED_MOLD, HoeLightBlueConcretePowderWarpedMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BLUE_CONCRETE_POWDER_OAK_MOLD, SwordBlueConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BLUE_CONCRETE_POWDER_OAK_MOLD, ShovelBlueConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BLUE_CONCRETE_POWDER_OAK_MOLD, PickaxeBlueConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BLUE_CONCRETE_POWDER_OAK_MOLD, AxeBlueConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BLUE_CONCRETE_POWDER_OAK_MOLD, HoeBlueConcretePowderOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BLUE_CONCRETE_POWDER_SPRUCE_MOLD, SwordBlueConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BLUE_CONCRETE_POWDER_SPRUCE_MOLD, ShovelBlueConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BLUE_CONCRETE_POWDER_SPRUCE_MOLD, PickaxeBlueConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BLUE_CONCRETE_POWDER_SPRUCE_MOLD, AxeBlueConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BLUE_CONCRETE_POWDER_SPRUCE_MOLD, HoeBlueConcretePowderSpruceMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BLUE_CONCRETE_POWDER_BIRCH_MOLD, SwordBlueConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BLUE_CONCRETE_POWDER_BIRCH_MOLD, ShovelBlueConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BLUE_CONCRETE_POWDER_BIRCH_MOLD, PickaxeBlueConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BLUE_CONCRETE_POWDER_BIRCH_MOLD, AxeBlueConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BLUE_CONCRETE_POWDER_BIRCH_MOLD, HoeBlueConcretePowderBirchMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BLUE_CONCRETE_POWDER_JUNGLE_MOLD, SwordBlueConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BLUE_CONCRETE_POWDER_JUNGLE_MOLD, ShovelBlueConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BLUE_CONCRETE_POWDER_JUNGLE_MOLD, PickaxeBlueConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BLUE_CONCRETE_POWDER_JUNGLE_MOLD, AxeBlueConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BLUE_CONCRETE_POWDER_JUNGLE_MOLD, HoeBlueConcretePowderJungleMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BLUE_CONCRETE_POWDER_ACACIA_MOLD, SwordBlueConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BLUE_CONCRETE_POWDER_ACACIA_MOLD, ShovelBlueConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BLUE_CONCRETE_POWDER_ACACIA_MOLD, PickaxeBlueConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BLUE_CONCRETE_POWDER_ACACIA_MOLD, AxeBlueConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BLUE_CONCRETE_POWDER_ACACIA_MOLD, HoeBlueConcretePowderAcaciaMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BLUE_CONCRETE_POWDER_DARK_OAK_MOLD, SwordBlueConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BLUE_CONCRETE_POWDER_DARK_OAK_MOLD, ShovelBlueConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BLUE_CONCRETE_POWDER_DARK_OAK_MOLD, PickaxeBlueConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BLUE_CONCRETE_POWDER_DARK_OAK_MOLD, AxeBlueConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BLUE_CONCRETE_POWDER_DARK_OAK_MOLD, HoeBlueConcretePowderDarkOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BLUE_CONCRETE_POWDER_MANGROVE_MOLD, SwordBlueConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BLUE_CONCRETE_POWDER_MANGROVE_MOLD, ShovelBlueConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BLUE_CONCRETE_POWDER_MANGROVE_MOLD, PickaxeBlueConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BLUE_CONCRETE_POWDER_MANGROVE_MOLD, AxeBlueConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BLUE_CONCRETE_POWDER_MANGROVE_MOLD, HoeBlueConcretePowderMangroveMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BLUE_CONCRETE_POWDER_CHERRY_MOLD, SwordBlueConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BLUE_CONCRETE_POWDER_CHERRY_MOLD, ShovelBlueConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BLUE_CONCRETE_POWDER_CHERRY_MOLD, PickaxeBlueConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BLUE_CONCRETE_POWDER_CHERRY_MOLD, AxeBlueConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BLUE_CONCRETE_POWDER_CHERRY_MOLD, HoeBlueConcretePowderCherryMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BLUE_CONCRETE_POWDER_BAMBOO_MOLD, SwordBlueConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BLUE_CONCRETE_POWDER_BAMBOO_MOLD, ShovelBlueConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BLUE_CONCRETE_POWDER_BAMBOO_MOLD, PickaxeBlueConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BLUE_CONCRETE_POWDER_BAMBOO_MOLD, AxeBlueConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BLUE_CONCRETE_POWDER_BAMBOO_MOLD, HoeBlueConcretePowderBambooMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BLUE_CONCRETE_POWDER_CRIMSON_MOLD, SwordBlueConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BLUE_CONCRETE_POWDER_CRIMSON_MOLD, ShovelBlueConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BLUE_CONCRETE_POWDER_CRIMSON_MOLD, PickaxeBlueConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BLUE_CONCRETE_POWDER_CRIMSON_MOLD, AxeBlueConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BLUE_CONCRETE_POWDER_CRIMSON_MOLD, HoeBlueConcretePowderCrimsonMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_BLUE_CONCRETE_POWDER_WARPED_MOLD, SwordBlueConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_BLUE_CONCRETE_POWDER_WARPED_MOLD, ShovelBlueConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_BLUE_CONCRETE_POWDER_WARPED_MOLD, PickaxeBlueConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_BLUE_CONCRETE_POWDER_WARPED_MOLD, AxeBlueConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_BLUE_CONCRETE_POWDER_WARPED_MOLD, HoeBlueConcretePowderWarpedMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_PURPLE_CONCRETE_POWDER_OAK_MOLD, SwordPurpleConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_PURPLE_CONCRETE_POWDER_OAK_MOLD, ShovelPurpleConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_PURPLE_CONCRETE_POWDER_OAK_MOLD, PickaxePurpleConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_PURPLE_CONCRETE_POWDER_OAK_MOLD, AxePurpleConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_PURPLE_CONCRETE_POWDER_OAK_MOLD, HoePurpleConcretePowderOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_PURPLE_CONCRETE_POWDER_SPRUCE_MOLD, SwordPurpleConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_PURPLE_CONCRETE_POWDER_SPRUCE_MOLD, ShovelPurpleConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_PURPLE_CONCRETE_POWDER_SPRUCE_MOLD, PickaxePurpleConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_PURPLE_CONCRETE_POWDER_SPRUCE_MOLD, AxePurpleConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_PURPLE_CONCRETE_POWDER_SPRUCE_MOLD, HoePurpleConcretePowderSpruceMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_PURPLE_CONCRETE_POWDER_BIRCH_MOLD, SwordPurpleConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_PURPLE_CONCRETE_POWDER_BIRCH_MOLD, ShovelPurpleConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_PURPLE_CONCRETE_POWDER_BIRCH_MOLD, PickaxePurpleConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_PURPLE_CONCRETE_POWDER_BIRCH_MOLD, AxePurpleConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_PURPLE_CONCRETE_POWDER_BIRCH_MOLD, HoePurpleConcretePowderBirchMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_PURPLE_CONCRETE_POWDER_JUNGLE_MOLD, SwordPurpleConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_PURPLE_CONCRETE_POWDER_JUNGLE_MOLD, ShovelPurpleConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_PURPLE_CONCRETE_POWDER_JUNGLE_MOLD, PickaxePurpleConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_PURPLE_CONCRETE_POWDER_JUNGLE_MOLD, AxePurpleConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_PURPLE_CONCRETE_POWDER_JUNGLE_MOLD, HoePurpleConcretePowderJungleMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_PURPLE_CONCRETE_POWDER_ACACIA_MOLD, SwordPurpleConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_PURPLE_CONCRETE_POWDER_ACACIA_MOLD, ShovelPurpleConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_PURPLE_CONCRETE_POWDER_ACACIA_MOLD, PickaxePurpleConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_PURPLE_CONCRETE_POWDER_ACACIA_MOLD, AxePurpleConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_PURPLE_CONCRETE_POWDER_ACACIA_MOLD, HoePurpleConcretePowderAcaciaMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_PURPLE_CONCRETE_POWDER_DARK_OAK_MOLD, SwordPurpleConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_PURPLE_CONCRETE_POWDER_DARK_OAK_MOLD, ShovelPurpleConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_PURPLE_CONCRETE_POWDER_DARK_OAK_MOLD, PickaxePurpleConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_PURPLE_CONCRETE_POWDER_DARK_OAK_MOLD, AxePurpleConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_PURPLE_CONCRETE_POWDER_DARK_OAK_MOLD, HoePurpleConcretePowderDarkOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_PURPLE_CONCRETE_POWDER_MANGROVE_MOLD, SwordPurpleConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_PURPLE_CONCRETE_POWDER_MANGROVE_MOLD, ShovelPurpleConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_PURPLE_CONCRETE_POWDER_MANGROVE_MOLD, PickaxePurpleConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_PURPLE_CONCRETE_POWDER_MANGROVE_MOLD, AxePurpleConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_PURPLE_CONCRETE_POWDER_MANGROVE_MOLD, HoePurpleConcretePowderMangroveMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_PURPLE_CONCRETE_POWDER_CHERRY_MOLD, SwordPurpleConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_PURPLE_CONCRETE_POWDER_CHERRY_MOLD, ShovelPurpleConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_PURPLE_CONCRETE_POWDER_CHERRY_MOLD, PickaxePurpleConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_PURPLE_CONCRETE_POWDER_CHERRY_MOLD, AxePurpleConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_PURPLE_CONCRETE_POWDER_CHERRY_MOLD, HoePurpleConcretePowderCherryMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_PURPLE_CONCRETE_POWDER_BAMBOO_MOLD, SwordPurpleConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_PURPLE_CONCRETE_POWDER_BAMBOO_MOLD, ShovelPurpleConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_PURPLE_CONCRETE_POWDER_BAMBOO_MOLD, PickaxePurpleConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_PURPLE_CONCRETE_POWDER_BAMBOO_MOLD, AxePurpleConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_PURPLE_CONCRETE_POWDER_BAMBOO_MOLD, HoePurpleConcretePowderBambooMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_PURPLE_CONCRETE_POWDER_CRIMSON_MOLD, SwordPurpleConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_PURPLE_CONCRETE_POWDER_CRIMSON_MOLD, ShovelPurpleConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_PURPLE_CONCRETE_POWDER_CRIMSON_MOLD, PickaxePurpleConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_PURPLE_CONCRETE_POWDER_CRIMSON_MOLD, AxePurpleConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_PURPLE_CONCRETE_POWDER_CRIMSON_MOLD, HoePurpleConcretePowderCrimsonMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_PURPLE_CONCRETE_POWDER_WARPED_MOLD, SwordPurpleConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_PURPLE_CONCRETE_POWDER_WARPED_MOLD, ShovelPurpleConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_PURPLE_CONCRETE_POWDER_WARPED_MOLD, PickaxePurpleConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_PURPLE_CONCRETE_POWDER_WARPED_MOLD, AxePurpleConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_PURPLE_CONCRETE_POWDER_WARPED_MOLD, HoePurpleConcretePowderWarpedMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_MAGENTA_CONCRETE_POWDER_OAK_MOLD, SwordMagentaConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_MAGENTA_CONCRETE_POWDER_OAK_MOLD, ShovelMagentaConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_MAGENTA_CONCRETE_POWDER_OAK_MOLD, PickaxeMagentaConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_MAGENTA_CONCRETE_POWDER_OAK_MOLD, AxeMagentaConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_MAGENTA_CONCRETE_POWDER_OAK_MOLD, HoeMagentaConcretePowderOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_MAGENTA_CONCRETE_POWDER_SPRUCE_MOLD, SwordMagentaConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_MAGENTA_CONCRETE_POWDER_SPRUCE_MOLD, ShovelMagentaConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_MAGENTA_CONCRETE_POWDER_SPRUCE_MOLD, PickaxeMagentaConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_MAGENTA_CONCRETE_POWDER_SPRUCE_MOLD, AxeMagentaConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_MAGENTA_CONCRETE_POWDER_SPRUCE_MOLD, HoeMagentaConcretePowderSpruceMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_MAGENTA_CONCRETE_POWDER_BIRCH_MOLD, SwordMagentaConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_MAGENTA_CONCRETE_POWDER_BIRCH_MOLD, ShovelMagentaConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_MAGENTA_CONCRETE_POWDER_BIRCH_MOLD, PickaxeMagentaConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_MAGENTA_CONCRETE_POWDER_BIRCH_MOLD, AxeMagentaConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_MAGENTA_CONCRETE_POWDER_BIRCH_MOLD, HoeMagentaConcretePowderBirchMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_MAGENTA_CONCRETE_POWDER_JUNGLE_MOLD, SwordMagentaConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_MAGENTA_CONCRETE_POWDER_JUNGLE_MOLD, ShovelMagentaConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_MAGENTA_CONCRETE_POWDER_JUNGLE_MOLD, PickaxeMagentaConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_MAGENTA_CONCRETE_POWDER_JUNGLE_MOLD, AxeMagentaConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_MAGENTA_CONCRETE_POWDER_JUNGLE_MOLD, HoeMagentaConcretePowderJungleMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_MAGENTA_CONCRETE_POWDER_ACACIA_MOLD, SwordMagentaConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_MAGENTA_CONCRETE_POWDER_ACACIA_MOLD, ShovelMagentaConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_MAGENTA_CONCRETE_POWDER_ACACIA_MOLD, PickaxeMagentaConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_MAGENTA_CONCRETE_POWDER_ACACIA_MOLD, AxeMagentaConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_MAGENTA_CONCRETE_POWDER_ACACIA_MOLD, HoeMagentaConcretePowderAcaciaMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_MAGENTA_CONCRETE_POWDER_DARK_OAK_MOLD, SwordMagentaConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_MAGENTA_CONCRETE_POWDER_DARK_OAK_MOLD, ShovelMagentaConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_MAGENTA_CONCRETE_POWDER_DARK_OAK_MOLD, PickaxeMagentaConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_MAGENTA_CONCRETE_POWDER_DARK_OAK_MOLD, AxeMagentaConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_MAGENTA_CONCRETE_POWDER_DARK_OAK_MOLD, HoeMagentaConcretePowderDarkOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_MAGENTA_CONCRETE_POWDER_MANGROVE_MOLD, SwordMagentaConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_MAGENTA_CONCRETE_POWDER_MANGROVE_MOLD, ShovelMagentaConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_MAGENTA_CONCRETE_POWDER_MANGROVE_MOLD, PickaxeMagentaConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_MAGENTA_CONCRETE_POWDER_MANGROVE_MOLD, AxeMagentaConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_MAGENTA_CONCRETE_POWDER_MANGROVE_MOLD, HoeMagentaConcretePowderMangroveMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_MAGENTA_CONCRETE_POWDER_CHERRY_MOLD, SwordMagentaConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_MAGENTA_CONCRETE_POWDER_CHERRY_MOLD, ShovelMagentaConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_MAGENTA_CONCRETE_POWDER_CHERRY_MOLD, PickaxeMagentaConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_MAGENTA_CONCRETE_POWDER_CHERRY_MOLD, AxeMagentaConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_MAGENTA_CONCRETE_POWDER_CHERRY_MOLD, HoeMagentaConcretePowderCherryMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_MAGENTA_CONCRETE_POWDER_BAMBOO_MOLD, SwordMagentaConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_MAGENTA_CONCRETE_POWDER_BAMBOO_MOLD, ShovelMagentaConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_MAGENTA_CONCRETE_POWDER_BAMBOO_MOLD, PickaxeMagentaConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_MAGENTA_CONCRETE_POWDER_BAMBOO_MOLD, AxeMagentaConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_MAGENTA_CONCRETE_POWDER_BAMBOO_MOLD, HoeMagentaConcretePowderBambooMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_MAGENTA_CONCRETE_POWDER_CRIMSON_MOLD, SwordMagentaConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_MAGENTA_CONCRETE_POWDER_CRIMSON_MOLD, ShovelMagentaConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_MAGENTA_CONCRETE_POWDER_CRIMSON_MOLD, PickaxeMagentaConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_MAGENTA_CONCRETE_POWDER_CRIMSON_MOLD, AxeMagentaConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_MAGENTA_CONCRETE_POWDER_CRIMSON_MOLD, HoeMagentaConcretePowderCrimsonMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_MAGENTA_CONCRETE_POWDER_WARPED_MOLD, SwordMagentaConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_MAGENTA_CONCRETE_POWDER_WARPED_MOLD, ShovelMagentaConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_MAGENTA_CONCRETE_POWDER_WARPED_MOLD, PickaxeMagentaConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_MAGENTA_CONCRETE_POWDER_WARPED_MOLD, AxeMagentaConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_MAGENTA_CONCRETE_POWDER_WARPED_MOLD, HoeMagentaConcretePowderWarpedMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_PINK_CONCRETE_POWDER_OAK_MOLD, SwordPinkConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_PINK_CONCRETE_POWDER_OAK_MOLD, ShovelPinkConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_PINK_CONCRETE_POWDER_OAK_MOLD, PickaxePinkConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_PINK_CONCRETE_POWDER_OAK_MOLD, AxePinkConcretePowderOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_PINK_CONCRETE_POWDER_OAK_MOLD, HoePinkConcretePowderOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_PINK_CONCRETE_POWDER_SPRUCE_MOLD, SwordPinkConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_PINK_CONCRETE_POWDER_SPRUCE_MOLD, ShovelPinkConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_PINK_CONCRETE_POWDER_SPRUCE_MOLD, PickaxePinkConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_PINK_CONCRETE_POWDER_SPRUCE_MOLD, AxePinkConcretePowderSpruceMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_PINK_CONCRETE_POWDER_SPRUCE_MOLD, HoePinkConcretePowderSpruceMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_PINK_CONCRETE_POWDER_BIRCH_MOLD, SwordPinkConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_PINK_CONCRETE_POWDER_BIRCH_MOLD, ShovelPinkConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_PINK_CONCRETE_POWDER_BIRCH_MOLD, PickaxePinkConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_PINK_CONCRETE_POWDER_BIRCH_MOLD, AxePinkConcretePowderBirchMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_PINK_CONCRETE_POWDER_BIRCH_MOLD, HoePinkConcretePowderBirchMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_PINK_CONCRETE_POWDER_JUNGLE_MOLD, SwordPinkConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_PINK_CONCRETE_POWDER_JUNGLE_MOLD, ShovelPinkConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_PINK_CONCRETE_POWDER_JUNGLE_MOLD, PickaxePinkConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_PINK_CONCRETE_POWDER_JUNGLE_MOLD, AxePinkConcretePowderJungleMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_PINK_CONCRETE_POWDER_JUNGLE_MOLD, HoePinkConcretePowderJungleMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_PINK_CONCRETE_POWDER_ACACIA_MOLD, SwordPinkConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_PINK_CONCRETE_POWDER_ACACIA_MOLD, ShovelPinkConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_PINK_CONCRETE_POWDER_ACACIA_MOLD, PickaxePinkConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_PINK_CONCRETE_POWDER_ACACIA_MOLD, AxePinkConcretePowderAcaciaMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_PINK_CONCRETE_POWDER_ACACIA_MOLD, HoePinkConcretePowderAcaciaMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_PINK_CONCRETE_POWDER_DARK_OAK_MOLD, SwordPinkConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_PINK_CONCRETE_POWDER_DARK_OAK_MOLD, ShovelPinkConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_PINK_CONCRETE_POWDER_DARK_OAK_MOLD, PickaxePinkConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_PINK_CONCRETE_POWDER_DARK_OAK_MOLD, AxePinkConcretePowderDarkOakMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_PINK_CONCRETE_POWDER_DARK_OAK_MOLD, HoePinkConcretePowderDarkOakMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_PINK_CONCRETE_POWDER_MANGROVE_MOLD, SwordPinkConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_PINK_CONCRETE_POWDER_MANGROVE_MOLD, ShovelPinkConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_PINK_CONCRETE_POWDER_MANGROVE_MOLD, PickaxePinkConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_PINK_CONCRETE_POWDER_MANGROVE_MOLD, AxePinkConcretePowderMangroveMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_PINK_CONCRETE_POWDER_MANGROVE_MOLD, HoePinkConcretePowderMangroveMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_PINK_CONCRETE_POWDER_CHERRY_MOLD, SwordPinkConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_PINK_CONCRETE_POWDER_CHERRY_MOLD, ShovelPinkConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_PINK_CONCRETE_POWDER_CHERRY_MOLD, PickaxePinkConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_PINK_CONCRETE_POWDER_CHERRY_MOLD, AxePinkConcretePowderCherryMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_PINK_CONCRETE_POWDER_CHERRY_MOLD, HoePinkConcretePowderCherryMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_PINK_CONCRETE_POWDER_BAMBOO_MOLD, SwordPinkConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_PINK_CONCRETE_POWDER_BAMBOO_MOLD, ShovelPinkConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_PINK_CONCRETE_POWDER_BAMBOO_MOLD, PickaxePinkConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_PINK_CONCRETE_POWDER_BAMBOO_MOLD, AxePinkConcretePowderBambooMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_PINK_CONCRETE_POWDER_BAMBOO_MOLD, HoePinkConcretePowderBambooMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_PINK_CONCRETE_POWDER_CRIMSON_MOLD, SwordPinkConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_PINK_CONCRETE_POWDER_CRIMSON_MOLD, ShovelPinkConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_PINK_CONCRETE_POWDER_CRIMSON_MOLD, PickaxePinkConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_PINK_CONCRETE_POWDER_CRIMSON_MOLD, AxePinkConcretePowderCrimsonMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_PINK_CONCRETE_POWDER_CRIMSON_MOLD, HoePinkConcretePowderCrimsonMoldRenderer::new);

        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SWORD_PINK_CONCRETE_POWDER_WARPED_MOLD, SwordPinkConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.SHOVEL_PINK_CONCRETE_POWDER_WARPED_MOLD, ShovelPinkConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.PICKAXE_PINK_CONCRETE_POWDER_WARPED_MOLD, PickaxePinkConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.AXE_PINK_CONCRETE_POWDER_WARPED_MOLD, AxePinkConcretePowderWarpedMoldRenderer::new);
        BlockEntityRenderers.register(AllMoldBlockEntityTypes.HOE_PINK_CONCRETE_POWDER_WARPED_MOLD, HoePinkConcretePowderWarpedMoldRenderer::new);

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
            AllMoldBlocks.SAND_OAK_MOLD,
            AllMoldBlocks.SAND_SPRUCE_MOLD,
            AllMoldBlocks.SAND_BIRCH_MOLD,
            AllMoldBlocks.SAND_JUNGLE_MOLD,
            AllMoldBlocks.SAND_ACACIA_MOLD,
            AllMoldBlocks.SAND_DARK_OAK_MOLD,
            AllMoldBlocks.SAND_MANGROVE_MOLD,
            AllMoldBlocks.SAND_CHERRY_MOLD,
            AllMoldBlocks.SAND_BAMBOO_MOLD,
            AllMoldBlocks.SAND_CRIMSON_MOLD,
            AllMoldBlocks.SAND_WARPED_MOLD,
            AllMoldBlocks.RED_SAND_OAK_MOLD,
            AllMoldBlocks.RED_SAND_SPRUCE_MOLD,
            AllMoldBlocks.RED_SAND_BIRCH_MOLD,
            AllMoldBlocks.RED_SAND_JUNGLE_MOLD,
            AllMoldBlocks.RED_SAND_ACACIA_MOLD,
            AllMoldBlocks.RED_SAND_DARK_OAK_MOLD,
            AllMoldBlocks.RED_SAND_MANGROVE_MOLD,
            AllMoldBlocks.RED_SAND_CHERRY_MOLD,
            AllMoldBlocks.RED_SAND_BAMBOO_MOLD,
            AllMoldBlocks.RED_SAND_CRIMSON_MOLD,
            AllMoldBlocks.RED_SAND_WARPED_MOLD,
            AllMoldBlocks.WHITE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.WHITE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.WHITE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.WHITE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.WHITE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.WHITE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.WHITE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.WHITE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.WHITE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.WHITE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.WHITE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.LIGHT_GRAY_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.LIGHT_GRAY_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.LIGHT_GRAY_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.LIGHT_GRAY_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.LIGHT_GRAY_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.LIGHT_GRAY_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.LIGHT_GRAY_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.LIGHT_GRAY_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.LIGHT_GRAY_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.LIGHT_GRAY_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.LIGHT_GRAY_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.GRAY_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.GRAY_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.GRAY_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.GRAY_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.GRAY_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.GRAY_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.GRAY_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.GRAY_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.GRAY_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.GRAY_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.GRAY_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.BLACK_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.BLACK_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.BLACK_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.BLACK_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.BLACK_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.BLACK_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.BLACK_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.BLACK_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.BLACK_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.BLACK_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.BLACK_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.BROWN_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.BROWN_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.BROWN_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.BROWN_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.BROWN_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.BROWN_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.BROWN_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.BROWN_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.BROWN_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.BROWN_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.BROWN_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.RED_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.RED_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.RED_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.RED_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.RED_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.RED_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.RED_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.RED_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.RED_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.RED_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.RED_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.ORANGE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.ORANGE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.ORANGE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.ORANGE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.ORANGE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.ORANGE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.ORANGE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.ORANGE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.ORANGE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.ORANGE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.ORANGE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.YELLOW_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.YELLOW_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.YELLOW_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.YELLOW_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.YELLOW_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.YELLOW_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.YELLOW_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.YELLOW_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.YELLOW_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.YELLOW_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.YELLOW_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.LIME_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.LIME_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.LIME_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.LIME_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.LIME_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.LIME_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.LIME_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.LIME_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.LIME_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.LIME_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.LIME_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.GREEN_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.GREEN_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.GREEN_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.GREEN_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.GREEN_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.GREEN_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.GREEN_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.GREEN_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.GREEN_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.GREEN_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.GREEN_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.CYAN_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.CYAN_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.CYAN_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.CYAN_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.CYAN_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.CYAN_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.CYAN_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.CYAN_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.CYAN_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.CYAN_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.CYAN_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.LIGHT_BLUE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.LIGHT_BLUE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.LIGHT_BLUE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.LIGHT_BLUE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.LIGHT_BLUE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.LIGHT_BLUE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.LIGHT_BLUE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.LIGHT_BLUE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.LIGHT_BLUE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.LIGHT_BLUE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.LIGHT_BLUE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.BLUE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.BLUE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.BLUE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.BLUE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.BLUE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.BLUE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.BLUE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.BLUE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.BLUE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.BLUE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.BLUE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.PURPLE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.PURPLE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.PURPLE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.PURPLE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.PURPLE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.PURPLE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.PURPLE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.PURPLE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.PURPLE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.PURPLE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.PURPLE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.MAGENTA_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.MAGENTA_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.MAGENTA_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.MAGENTA_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.MAGENTA_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.MAGENTA_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.MAGENTA_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.MAGENTA_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.MAGENTA_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.MAGENTA_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.MAGENTA_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.PINK_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.PINK_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.PINK_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.PINK_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.PINK_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.PINK_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.PINK_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.PINK_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.PINK_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.PINK_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.PINK_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SWORD_SAND_OAK_MOLD,
            AllMoldBlocks.SHOVEL_SAND_OAK_MOLD,
            AllMoldBlocks.PICKAXE_SAND_OAK_MOLD,
            AllMoldBlocks.AXE_SAND_OAK_MOLD,
            AllMoldBlocks.HOE_SAND_OAK_MOLD,
            AllMoldBlocks.SWORD_SAND_SPRUCE_MOLD,
            AllMoldBlocks.SHOVEL_SAND_SPRUCE_MOLD,
            AllMoldBlocks.PICKAXE_SAND_SPRUCE_MOLD,
            AllMoldBlocks.AXE_SAND_SPRUCE_MOLD,
            AllMoldBlocks.HOE_SAND_SPRUCE_MOLD,
            AllMoldBlocks.SWORD_SAND_BIRCH_MOLD,
            AllMoldBlocks.SHOVEL_SAND_BIRCH_MOLD,
            AllMoldBlocks.PICKAXE_SAND_BIRCH_MOLD,
            AllMoldBlocks.AXE_SAND_BIRCH_MOLD,
            AllMoldBlocks.HOE_SAND_BIRCH_MOLD,
            AllMoldBlocks.SWORD_SAND_JUNGLE_MOLD,
            AllMoldBlocks.SHOVEL_SAND_JUNGLE_MOLD,
            AllMoldBlocks.PICKAXE_SAND_JUNGLE_MOLD,
            AllMoldBlocks.AXE_SAND_JUNGLE_MOLD,
            AllMoldBlocks.HOE_SAND_JUNGLE_MOLD,
            AllMoldBlocks.SWORD_SAND_ACACIA_MOLD,
            AllMoldBlocks.SHOVEL_SAND_ACACIA_MOLD,
            AllMoldBlocks.PICKAXE_SAND_ACACIA_MOLD,
            AllMoldBlocks.AXE_SAND_ACACIA_MOLD,
            AllMoldBlocks.HOE_SAND_ACACIA_MOLD,
            AllMoldBlocks.SWORD_SAND_DARK_OAK_MOLD,
            AllMoldBlocks.SHOVEL_SAND_DARK_OAK_MOLD,
            AllMoldBlocks.PICKAXE_SAND_DARK_OAK_MOLD,
            AllMoldBlocks.AXE_SAND_DARK_OAK_MOLD,
            AllMoldBlocks.HOE_SAND_DARK_OAK_MOLD,
            AllMoldBlocks.SWORD_SAND_MANGROVE_MOLD,
            AllMoldBlocks.SHOVEL_SAND_MANGROVE_MOLD,
            AllMoldBlocks.PICKAXE_SAND_MANGROVE_MOLD,
            AllMoldBlocks.AXE_SAND_MANGROVE_MOLD,
            AllMoldBlocks.HOE_SAND_MANGROVE_MOLD,
            AllMoldBlocks.SWORD_SAND_CHERRY_MOLD,
            AllMoldBlocks.SHOVEL_SAND_CHERRY_MOLD,
            AllMoldBlocks.PICKAXE_SAND_CHERRY_MOLD,
            AllMoldBlocks.AXE_SAND_CHERRY_MOLD,
            AllMoldBlocks.HOE_SAND_CHERRY_MOLD,
            AllMoldBlocks.SWORD_SAND_BAMBOO_MOLD,
            AllMoldBlocks.SHOVEL_SAND_BAMBOO_MOLD,
            AllMoldBlocks.PICKAXE_SAND_BAMBOO_MOLD,
            AllMoldBlocks.AXE_SAND_BAMBOO_MOLD,
            AllMoldBlocks.HOE_SAND_BAMBOO_MOLD,
            AllMoldBlocks.SWORD_SAND_CRIMSON_MOLD,
            AllMoldBlocks.SHOVEL_SAND_CRIMSON_MOLD,
            AllMoldBlocks.PICKAXE_SAND_CRIMSON_MOLD,
            AllMoldBlocks.AXE_SAND_CRIMSON_MOLD,
            AllMoldBlocks.HOE_SAND_CRIMSON_MOLD,
            AllMoldBlocks.SWORD_SAND_WARPED_MOLD,
            AllMoldBlocks.SHOVEL_SAND_WARPED_MOLD,
            AllMoldBlocks.PICKAXE_SAND_WARPED_MOLD,
            AllMoldBlocks.AXE_SAND_WARPED_MOLD,
            AllMoldBlocks.HOE_SAND_WARPED_MOLD,
            AllMoldBlocks.SWORD_RED_SAND_OAK_MOLD,
            AllMoldBlocks.SHOVEL_RED_SAND_OAK_MOLD,
            AllMoldBlocks.PICKAXE_RED_SAND_OAK_MOLD,
            AllMoldBlocks.AXE_RED_SAND_OAK_MOLD,
            AllMoldBlocks.HOE_RED_SAND_OAK_MOLD,
            AllMoldBlocks.SWORD_RED_SAND_SPRUCE_MOLD,
            AllMoldBlocks.SHOVEL_RED_SAND_SPRUCE_MOLD,
            AllMoldBlocks.PICKAXE_RED_SAND_SPRUCE_MOLD,
            AllMoldBlocks.AXE_RED_SAND_SPRUCE_MOLD,
            AllMoldBlocks.HOE_RED_SAND_SPRUCE_MOLD,
            AllMoldBlocks.SWORD_RED_SAND_BIRCH_MOLD,
            AllMoldBlocks.SHOVEL_RED_SAND_BIRCH_MOLD,
            AllMoldBlocks.PICKAXE_RED_SAND_BIRCH_MOLD,
            AllMoldBlocks.AXE_RED_SAND_BIRCH_MOLD,
            AllMoldBlocks.HOE_RED_SAND_BIRCH_MOLD,
            AllMoldBlocks.SWORD_RED_SAND_JUNGLE_MOLD,
            AllMoldBlocks.SHOVEL_RED_SAND_JUNGLE_MOLD,
            AllMoldBlocks.PICKAXE_RED_SAND_JUNGLE_MOLD,
            AllMoldBlocks.AXE_RED_SAND_JUNGLE_MOLD,
            AllMoldBlocks.HOE_RED_SAND_JUNGLE_MOLD,
            AllMoldBlocks.SWORD_RED_SAND_ACACIA_MOLD,
            AllMoldBlocks.SHOVEL_RED_SAND_ACACIA_MOLD,
            AllMoldBlocks.PICKAXE_RED_SAND_ACACIA_MOLD,
            AllMoldBlocks.AXE_RED_SAND_ACACIA_MOLD,
            AllMoldBlocks.HOE_RED_SAND_ACACIA_MOLD,
            AllMoldBlocks.SWORD_RED_SAND_DARK_OAK_MOLD,
            AllMoldBlocks.SHOVEL_RED_SAND_DARK_OAK_MOLD,
            AllMoldBlocks.PICKAXE_RED_SAND_DARK_OAK_MOLD,
            AllMoldBlocks.AXE_RED_SAND_DARK_OAK_MOLD,
            AllMoldBlocks.HOE_RED_SAND_DARK_OAK_MOLD,
            AllMoldBlocks.SWORD_RED_SAND_MANGROVE_MOLD,
            AllMoldBlocks.SHOVEL_RED_SAND_MANGROVE_MOLD,
            AllMoldBlocks.PICKAXE_RED_SAND_MANGROVE_MOLD,
            AllMoldBlocks.AXE_RED_SAND_MANGROVE_MOLD,
            AllMoldBlocks.HOE_RED_SAND_MANGROVE_MOLD,
            AllMoldBlocks.SWORD_RED_SAND_CHERRY_MOLD,
            AllMoldBlocks.SHOVEL_RED_SAND_CHERRY_MOLD,
            AllMoldBlocks.PICKAXE_RED_SAND_CHERRY_MOLD,
            AllMoldBlocks.AXE_RED_SAND_CHERRY_MOLD,
            AllMoldBlocks.HOE_RED_SAND_CHERRY_MOLD,
            AllMoldBlocks.SWORD_RED_SAND_BAMBOO_MOLD,
            AllMoldBlocks.SHOVEL_RED_SAND_BAMBOO_MOLD,
            AllMoldBlocks.PICKAXE_RED_SAND_BAMBOO_MOLD,
            AllMoldBlocks.AXE_RED_SAND_BAMBOO_MOLD,
            AllMoldBlocks.HOE_RED_SAND_BAMBOO_MOLD,
            AllMoldBlocks.SWORD_RED_SAND_CRIMSON_MOLD,
            AllMoldBlocks.SHOVEL_RED_SAND_CRIMSON_MOLD,
            AllMoldBlocks.PICKAXE_RED_SAND_CRIMSON_MOLD,
            AllMoldBlocks.AXE_RED_SAND_CRIMSON_MOLD,
            AllMoldBlocks.HOE_RED_SAND_CRIMSON_MOLD,
            AllMoldBlocks.SWORD_RED_SAND_WARPED_MOLD,
            AllMoldBlocks.SHOVEL_RED_SAND_WARPED_MOLD,
            AllMoldBlocks.PICKAXE_RED_SAND_WARPED_MOLD,
            AllMoldBlocks.AXE_RED_SAND_WARPED_MOLD,
            AllMoldBlocks.HOE_RED_SAND_WARPED_MOLD,
            AllMoldBlocks.SWORD_WHITE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SHOVEL_WHITE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.PICKAXE_WHITE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.AXE_WHITE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.HOE_WHITE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SWORD_WHITE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SHOVEL_WHITE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.PICKAXE_WHITE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.AXE_WHITE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.HOE_WHITE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SWORD_WHITE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SHOVEL_WHITE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.PICKAXE_WHITE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.AXE_WHITE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.HOE_WHITE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SWORD_WHITE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SHOVEL_WHITE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.PICKAXE_WHITE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.AXE_WHITE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.HOE_WHITE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SWORD_WHITE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SHOVEL_WHITE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.PICKAXE_WHITE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.AXE_WHITE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.HOE_WHITE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SWORD_WHITE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SHOVEL_WHITE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.PICKAXE_WHITE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.AXE_WHITE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.HOE_WHITE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SWORD_WHITE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SHOVEL_WHITE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.PICKAXE_WHITE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.AXE_WHITE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.HOE_WHITE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SWORD_WHITE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SHOVEL_WHITE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.PICKAXE_WHITE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.AXE_WHITE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.HOE_WHITE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SWORD_WHITE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SHOVEL_WHITE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.PICKAXE_WHITE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.AXE_WHITE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.HOE_WHITE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SWORD_WHITE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SHOVEL_WHITE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.PICKAXE_WHITE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.AXE_WHITE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.HOE_WHITE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SWORD_WHITE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SHOVEL_WHITE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.PICKAXE_WHITE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.AXE_WHITE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.HOE_WHITE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SWORD_LIGHT_GRAY_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.AXE_LIGHT_GRAY_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.HOE_LIGHT_GRAY_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SWORD_LIGHT_GRAY_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.AXE_LIGHT_GRAY_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.HOE_LIGHT_GRAY_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SWORD_LIGHT_GRAY_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.AXE_LIGHT_GRAY_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.HOE_LIGHT_GRAY_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SWORD_LIGHT_GRAY_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.AXE_LIGHT_GRAY_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.HOE_LIGHT_GRAY_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SWORD_LIGHT_GRAY_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.AXE_LIGHT_GRAY_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.HOE_LIGHT_GRAY_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SWORD_LIGHT_GRAY_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.AXE_LIGHT_GRAY_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.HOE_LIGHT_GRAY_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SWORD_LIGHT_GRAY_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.AXE_LIGHT_GRAY_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.HOE_LIGHT_GRAY_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SWORD_LIGHT_GRAY_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.AXE_LIGHT_GRAY_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.HOE_LIGHT_GRAY_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SWORD_LIGHT_GRAY_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.AXE_LIGHT_GRAY_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.HOE_LIGHT_GRAY_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SWORD_LIGHT_GRAY_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.AXE_LIGHT_GRAY_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.HOE_LIGHT_GRAY_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SWORD_LIGHT_GRAY_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.AXE_LIGHT_GRAY_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.HOE_LIGHT_GRAY_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SWORD_GRAY_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SHOVEL_GRAY_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.PICKAXE_GRAY_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.AXE_GRAY_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.HOE_GRAY_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SWORD_GRAY_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SHOVEL_GRAY_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.PICKAXE_GRAY_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.AXE_GRAY_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.HOE_GRAY_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SWORD_GRAY_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SHOVEL_GRAY_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.PICKAXE_GRAY_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.AXE_GRAY_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.HOE_GRAY_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SWORD_GRAY_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SHOVEL_GRAY_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.PICKAXE_GRAY_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.AXE_GRAY_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.HOE_GRAY_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SWORD_GRAY_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SHOVEL_GRAY_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.PICKAXE_GRAY_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.AXE_GRAY_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.HOE_GRAY_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SWORD_GRAY_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SHOVEL_GRAY_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.PICKAXE_GRAY_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.AXE_GRAY_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.HOE_GRAY_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SWORD_GRAY_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SHOVEL_GRAY_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.PICKAXE_GRAY_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.AXE_GRAY_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.HOE_GRAY_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SWORD_GRAY_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SHOVEL_GRAY_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.PICKAXE_GRAY_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.AXE_GRAY_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.HOE_GRAY_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SWORD_GRAY_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SHOVEL_GRAY_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.PICKAXE_GRAY_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.AXE_GRAY_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.HOE_GRAY_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SWORD_GRAY_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SHOVEL_GRAY_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.PICKAXE_GRAY_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.AXE_GRAY_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.HOE_GRAY_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SWORD_GRAY_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SHOVEL_GRAY_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.PICKAXE_GRAY_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.AXE_GRAY_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.HOE_GRAY_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SWORD_BLACK_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SHOVEL_BLACK_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.PICKAXE_BLACK_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.AXE_BLACK_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.HOE_BLACK_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SWORD_BLACK_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SHOVEL_BLACK_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.PICKAXE_BLACK_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.AXE_BLACK_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.HOE_BLACK_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SWORD_BLACK_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SHOVEL_BLACK_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.PICKAXE_BLACK_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.AXE_BLACK_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.HOE_BLACK_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SWORD_BLACK_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SHOVEL_BLACK_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.PICKAXE_BLACK_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.AXE_BLACK_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.HOE_BLACK_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SWORD_BLACK_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SHOVEL_BLACK_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.PICKAXE_BLACK_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.AXE_BLACK_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.HOE_BLACK_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SWORD_BLACK_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SHOVEL_BLACK_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.PICKAXE_BLACK_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.AXE_BLACK_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.HOE_BLACK_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SWORD_BLACK_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SHOVEL_BLACK_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.PICKAXE_BLACK_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.AXE_BLACK_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.HOE_BLACK_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SWORD_BLACK_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SHOVEL_BLACK_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.PICKAXE_BLACK_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.AXE_BLACK_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.HOE_BLACK_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SWORD_BLACK_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SHOVEL_BLACK_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.PICKAXE_BLACK_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.AXE_BLACK_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.HOE_BLACK_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SWORD_BLACK_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SHOVEL_BLACK_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.PICKAXE_BLACK_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.AXE_BLACK_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.HOE_BLACK_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SWORD_BLACK_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SHOVEL_BLACK_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.PICKAXE_BLACK_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.AXE_BLACK_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.HOE_BLACK_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SWORD_BROWN_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SHOVEL_BROWN_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.PICKAXE_BROWN_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.AXE_BROWN_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.HOE_BROWN_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SWORD_BROWN_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SHOVEL_BROWN_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.PICKAXE_BROWN_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.AXE_BROWN_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.HOE_BROWN_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SWORD_BROWN_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SHOVEL_BROWN_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.PICKAXE_BROWN_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.AXE_BROWN_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.HOE_BROWN_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SWORD_BROWN_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SHOVEL_BROWN_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.PICKAXE_BROWN_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.AXE_BROWN_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.HOE_BROWN_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SWORD_BROWN_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SHOVEL_BROWN_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.PICKAXE_BROWN_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.AXE_BROWN_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.HOE_BROWN_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SWORD_BROWN_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SHOVEL_BROWN_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.PICKAXE_BROWN_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.AXE_BROWN_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.HOE_BROWN_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SWORD_BROWN_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SHOVEL_BROWN_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.PICKAXE_BROWN_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.AXE_BROWN_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.HOE_BROWN_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SWORD_BROWN_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SHOVEL_BROWN_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.PICKAXE_BROWN_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.AXE_BROWN_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.HOE_BROWN_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SWORD_BROWN_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SHOVEL_BROWN_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.PICKAXE_BROWN_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.AXE_BROWN_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.HOE_BROWN_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SWORD_BROWN_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SHOVEL_BROWN_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.PICKAXE_BROWN_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.AXE_BROWN_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.HOE_BROWN_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SWORD_BROWN_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SHOVEL_BROWN_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.PICKAXE_BROWN_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.AXE_BROWN_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.HOE_BROWN_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SWORD_RED_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SHOVEL_RED_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.PICKAXE_RED_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.AXE_RED_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.HOE_RED_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SWORD_RED_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SHOVEL_RED_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.PICKAXE_RED_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.AXE_RED_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.HOE_RED_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SWORD_RED_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SHOVEL_RED_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.PICKAXE_RED_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.AXE_RED_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.HOE_RED_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SWORD_RED_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SHOVEL_RED_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.PICKAXE_RED_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.AXE_RED_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.HOE_RED_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SWORD_RED_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SHOVEL_RED_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.PICKAXE_RED_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.AXE_RED_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.HOE_RED_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SWORD_RED_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SHOVEL_RED_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.PICKAXE_RED_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.AXE_RED_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.HOE_RED_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SWORD_RED_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SHOVEL_RED_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.PICKAXE_RED_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.AXE_RED_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.HOE_RED_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SWORD_RED_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SHOVEL_RED_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.PICKAXE_RED_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.AXE_RED_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.HOE_RED_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SWORD_RED_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SHOVEL_RED_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.PICKAXE_RED_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.AXE_RED_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.HOE_RED_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SWORD_RED_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SHOVEL_RED_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.PICKAXE_RED_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.AXE_RED_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.HOE_RED_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SWORD_RED_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SHOVEL_RED_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.PICKAXE_RED_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.AXE_RED_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.HOE_RED_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SWORD_ORANGE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SHOVEL_ORANGE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.PICKAXE_ORANGE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.AXE_ORANGE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.HOE_ORANGE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SWORD_ORANGE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SHOVEL_ORANGE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.PICKAXE_ORANGE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.AXE_ORANGE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.HOE_ORANGE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SWORD_ORANGE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SHOVEL_ORANGE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.PICKAXE_ORANGE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.AXE_ORANGE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.HOE_ORANGE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SWORD_ORANGE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SHOVEL_ORANGE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.PICKAXE_ORANGE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.AXE_ORANGE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.HOE_ORANGE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SWORD_ORANGE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SHOVEL_ORANGE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.PICKAXE_ORANGE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.AXE_ORANGE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.HOE_ORANGE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SWORD_ORANGE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SHOVEL_ORANGE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.PICKAXE_ORANGE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.AXE_ORANGE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.HOE_ORANGE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SWORD_ORANGE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SHOVEL_ORANGE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.PICKAXE_ORANGE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.AXE_ORANGE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.HOE_ORANGE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SWORD_ORANGE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SHOVEL_ORANGE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.PICKAXE_ORANGE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.AXE_ORANGE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.HOE_ORANGE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SWORD_ORANGE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SHOVEL_ORANGE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.PICKAXE_ORANGE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.AXE_ORANGE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.HOE_ORANGE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SWORD_ORANGE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SHOVEL_ORANGE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.PICKAXE_ORANGE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.AXE_ORANGE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.HOE_ORANGE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SWORD_ORANGE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SHOVEL_ORANGE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.PICKAXE_ORANGE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.AXE_ORANGE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.HOE_ORANGE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SWORD_YELLOW_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SHOVEL_YELLOW_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.PICKAXE_YELLOW_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.AXE_YELLOW_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.HOE_YELLOW_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SWORD_YELLOW_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SHOVEL_YELLOW_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.PICKAXE_YELLOW_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.AXE_YELLOW_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.HOE_YELLOW_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SWORD_YELLOW_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SHOVEL_YELLOW_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.PICKAXE_YELLOW_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.AXE_YELLOW_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.HOE_YELLOW_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SWORD_YELLOW_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SHOVEL_YELLOW_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.PICKAXE_YELLOW_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.AXE_YELLOW_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.HOE_YELLOW_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SWORD_YELLOW_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SHOVEL_YELLOW_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.PICKAXE_YELLOW_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.AXE_YELLOW_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.HOE_YELLOW_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SWORD_YELLOW_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SHOVEL_YELLOW_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.PICKAXE_YELLOW_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.AXE_YELLOW_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.HOE_YELLOW_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SWORD_YELLOW_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SHOVEL_YELLOW_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.PICKAXE_YELLOW_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.AXE_YELLOW_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.HOE_YELLOW_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SWORD_YELLOW_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SHOVEL_YELLOW_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.PICKAXE_YELLOW_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.AXE_YELLOW_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.HOE_YELLOW_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SWORD_YELLOW_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SHOVEL_YELLOW_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.PICKAXE_YELLOW_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.AXE_YELLOW_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.HOE_YELLOW_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SWORD_YELLOW_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SHOVEL_YELLOW_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.PICKAXE_YELLOW_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.AXE_YELLOW_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.HOE_YELLOW_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SWORD_YELLOW_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SHOVEL_YELLOW_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.PICKAXE_YELLOW_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.AXE_YELLOW_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.HOE_YELLOW_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SWORD_LIME_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SHOVEL_LIME_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.PICKAXE_LIME_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.AXE_LIME_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.HOE_LIME_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SWORD_LIME_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SHOVEL_LIME_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.PICKAXE_LIME_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.AXE_LIME_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.HOE_LIME_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SWORD_LIME_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SHOVEL_LIME_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.PICKAXE_LIME_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.AXE_LIME_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.HOE_LIME_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SWORD_LIME_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SHOVEL_LIME_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.PICKAXE_LIME_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.AXE_LIME_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.HOE_LIME_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SWORD_LIME_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SHOVEL_LIME_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.PICKAXE_LIME_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.AXE_LIME_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.HOE_LIME_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SWORD_LIME_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SHOVEL_LIME_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.PICKAXE_LIME_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.AXE_LIME_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.HOE_LIME_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SWORD_LIME_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SHOVEL_LIME_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.PICKAXE_LIME_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.AXE_LIME_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.HOE_LIME_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SWORD_LIME_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SHOVEL_LIME_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.PICKAXE_LIME_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.AXE_LIME_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.HOE_LIME_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SWORD_LIME_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SHOVEL_LIME_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.PICKAXE_LIME_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.AXE_LIME_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.HOE_LIME_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SWORD_LIME_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SHOVEL_LIME_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.PICKAXE_LIME_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.AXE_LIME_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.HOE_LIME_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SWORD_LIME_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SHOVEL_LIME_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.PICKAXE_LIME_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.AXE_LIME_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.HOE_LIME_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SWORD_GREEN_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SHOVEL_GREEN_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.PICKAXE_GREEN_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.AXE_GREEN_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.HOE_GREEN_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SWORD_GREEN_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SHOVEL_GREEN_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.PICKAXE_GREEN_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.AXE_GREEN_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.HOE_GREEN_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SWORD_GREEN_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SHOVEL_GREEN_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.PICKAXE_GREEN_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.AXE_GREEN_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.HOE_GREEN_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SWORD_GREEN_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SHOVEL_GREEN_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.PICKAXE_GREEN_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.AXE_GREEN_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.HOE_GREEN_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SWORD_GREEN_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SHOVEL_GREEN_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.PICKAXE_GREEN_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.AXE_GREEN_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.HOE_GREEN_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SWORD_GREEN_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SHOVEL_GREEN_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.PICKAXE_GREEN_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.AXE_GREEN_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.HOE_GREEN_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SWORD_GREEN_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SHOVEL_GREEN_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.PICKAXE_GREEN_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.AXE_GREEN_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.HOE_GREEN_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SWORD_GREEN_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SHOVEL_GREEN_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.PICKAXE_GREEN_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.AXE_GREEN_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.HOE_GREEN_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SWORD_GREEN_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SHOVEL_GREEN_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.PICKAXE_GREEN_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.AXE_GREEN_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.HOE_GREEN_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SWORD_GREEN_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SHOVEL_GREEN_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.PICKAXE_GREEN_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.AXE_GREEN_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.HOE_GREEN_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SWORD_GREEN_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SHOVEL_GREEN_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.PICKAXE_GREEN_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.AXE_GREEN_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.HOE_GREEN_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SWORD_CYAN_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SHOVEL_CYAN_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.PICKAXE_CYAN_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.AXE_CYAN_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.HOE_CYAN_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SWORD_CYAN_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SHOVEL_CYAN_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.PICKAXE_CYAN_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.AXE_CYAN_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.HOE_CYAN_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SWORD_CYAN_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SHOVEL_CYAN_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.PICKAXE_CYAN_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.AXE_CYAN_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.HOE_CYAN_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SWORD_CYAN_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SHOVEL_CYAN_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.PICKAXE_CYAN_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.AXE_CYAN_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.HOE_CYAN_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SWORD_CYAN_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SHOVEL_CYAN_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.PICKAXE_CYAN_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.AXE_CYAN_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.HOE_CYAN_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SWORD_CYAN_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SHOVEL_CYAN_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.PICKAXE_CYAN_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.AXE_CYAN_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.HOE_CYAN_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SWORD_CYAN_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SHOVEL_CYAN_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.PICKAXE_CYAN_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.AXE_CYAN_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.HOE_CYAN_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SWORD_CYAN_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SHOVEL_CYAN_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.PICKAXE_CYAN_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.AXE_CYAN_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.HOE_CYAN_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SWORD_CYAN_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SHOVEL_CYAN_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.PICKAXE_CYAN_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.AXE_CYAN_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.HOE_CYAN_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SWORD_CYAN_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SHOVEL_CYAN_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.PICKAXE_CYAN_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.AXE_CYAN_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.HOE_CYAN_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SWORD_CYAN_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SHOVEL_CYAN_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.PICKAXE_CYAN_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.AXE_CYAN_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.HOE_CYAN_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SWORD_LIGHT_BLUE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.AXE_LIGHT_BLUE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.HOE_LIGHT_BLUE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SWORD_LIGHT_BLUE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.AXE_LIGHT_BLUE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.HOE_LIGHT_BLUE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SWORD_LIGHT_BLUE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.AXE_LIGHT_BLUE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.HOE_LIGHT_BLUE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SWORD_LIGHT_BLUE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.AXE_LIGHT_BLUE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.HOE_LIGHT_BLUE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SWORD_LIGHT_BLUE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.AXE_LIGHT_BLUE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.HOE_LIGHT_BLUE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SWORD_LIGHT_BLUE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.AXE_LIGHT_BLUE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.HOE_LIGHT_BLUE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SWORD_LIGHT_BLUE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.AXE_LIGHT_BLUE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.HOE_LIGHT_BLUE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SWORD_LIGHT_BLUE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.AXE_LIGHT_BLUE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.HOE_LIGHT_BLUE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SWORD_LIGHT_BLUE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.AXE_LIGHT_BLUE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.HOE_LIGHT_BLUE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SWORD_LIGHT_BLUE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.AXE_LIGHT_BLUE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.HOE_LIGHT_BLUE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SWORD_LIGHT_BLUE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.AXE_LIGHT_BLUE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.HOE_LIGHT_BLUE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SWORD_BLUE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SHOVEL_BLUE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.PICKAXE_BLUE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.AXE_BLUE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.HOE_BLUE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SWORD_BLUE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SHOVEL_BLUE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.PICKAXE_BLUE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.AXE_BLUE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.HOE_BLUE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SWORD_BLUE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SHOVEL_BLUE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.PICKAXE_BLUE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.AXE_BLUE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.HOE_BLUE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SWORD_BLUE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SHOVEL_BLUE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.PICKAXE_BLUE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.AXE_BLUE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.HOE_BLUE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SWORD_BLUE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SHOVEL_BLUE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.PICKAXE_BLUE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.AXE_BLUE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.HOE_BLUE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SWORD_BLUE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SHOVEL_BLUE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.PICKAXE_BLUE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.AXE_BLUE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.HOE_BLUE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SWORD_BLUE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SHOVEL_BLUE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.PICKAXE_BLUE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.AXE_BLUE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.HOE_BLUE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SWORD_BLUE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SHOVEL_BLUE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.PICKAXE_BLUE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.AXE_BLUE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.HOE_BLUE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SWORD_BLUE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SHOVEL_BLUE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.PICKAXE_BLUE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.AXE_BLUE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.HOE_BLUE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SWORD_BLUE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SHOVEL_BLUE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.PICKAXE_BLUE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.AXE_BLUE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.HOE_BLUE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SWORD_BLUE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SHOVEL_BLUE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.PICKAXE_BLUE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.AXE_BLUE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.HOE_BLUE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SWORD_PURPLE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SHOVEL_PURPLE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.PICKAXE_PURPLE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.AXE_PURPLE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.HOE_PURPLE_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SWORD_PURPLE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SHOVEL_PURPLE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.PICKAXE_PURPLE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.AXE_PURPLE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.HOE_PURPLE_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SWORD_PURPLE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SHOVEL_PURPLE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.PICKAXE_PURPLE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.AXE_PURPLE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.HOE_PURPLE_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SWORD_PURPLE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SHOVEL_PURPLE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.PICKAXE_PURPLE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.AXE_PURPLE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.HOE_PURPLE_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SWORD_PURPLE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SHOVEL_PURPLE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.PICKAXE_PURPLE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.AXE_PURPLE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.HOE_PURPLE_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SWORD_PURPLE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SHOVEL_PURPLE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.PICKAXE_PURPLE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.AXE_PURPLE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.HOE_PURPLE_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SWORD_PURPLE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SHOVEL_PURPLE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.PICKAXE_PURPLE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.AXE_PURPLE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.HOE_PURPLE_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SWORD_PURPLE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SHOVEL_PURPLE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.PICKAXE_PURPLE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.AXE_PURPLE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.HOE_PURPLE_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SWORD_PURPLE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SHOVEL_PURPLE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.PICKAXE_PURPLE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.AXE_PURPLE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.HOE_PURPLE_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SWORD_PURPLE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SHOVEL_PURPLE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.PICKAXE_PURPLE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.AXE_PURPLE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.HOE_PURPLE_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SWORD_PURPLE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SHOVEL_PURPLE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.PICKAXE_PURPLE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.AXE_PURPLE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.HOE_PURPLE_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SWORD_MAGENTA_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SHOVEL_MAGENTA_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.PICKAXE_MAGENTA_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.AXE_MAGENTA_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.HOE_MAGENTA_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SWORD_MAGENTA_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SHOVEL_MAGENTA_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.PICKAXE_MAGENTA_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.AXE_MAGENTA_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.HOE_MAGENTA_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SWORD_MAGENTA_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SHOVEL_MAGENTA_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.PICKAXE_MAGENTA_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.AXE_MAGENTA_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.HOE_MAGENTA_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SWORD_MAGENTA_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SHOVEL_MAGENTA_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.PICKAXE_MAGENTA_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.AXE_MAGENTA_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.HOE_MAGENTA_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SWORD_MAGENTA_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SHOVEL_MAGENTA_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.PICKAXE_MAGENTA_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.AXE_MAGENTA_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.HOE_MAGENTA_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SWORD_MAGENTA_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SHOVEL_MAGENTA_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.PICKAXE_MAGENTA_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.AXE_MAGENTA_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.HOE_MAGENTA_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SWORD_MAGENTA_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SHOVEL_MAGENTA_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.PICKAXE_MAGENTA_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.AXE_MAGENTA_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.HOE_MAGENTA_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SWORD_MAGENTA_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SHOVEL_MAGENTA_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.PICKAXE_MAGENTA_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.AXE_MAGENTA_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.HOE_MAGENTA_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SWORD_MAGENTA_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SHOVEL_MAGENTA_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.PICKAXE_MAGENTA_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.AXE_MAGENTA_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.HOE_MAGENTA_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SWORD_MAGENTA_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SHOVEL_MAGENTA_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.PICKAXE_MAGENTA_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.AXE_MAGENTA_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.HOE_MAGENTA_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SWORD_MAGENTA_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SHOVEL_MAGENTA_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.PICKAXE_MAGENTA_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.AXE_MAGENTA_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.HOE_MAGENTA_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SWORD_PINK_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SHOVEL_PINK_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.PICKAXE_PINK_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.AXE_PINK_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.HOE_PINK_CONCRETE_POWDER_OAK_MOLD,
            AllMoldBlocks.SWORD_PINK_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SHOVEL_PINK_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.PICKAXE_PINK_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.AXE_PINK_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.HOE_PINK_CONCRETE_POWDER_SPRUCE_MOLD,
            AllMoldBlocks.SWORD_PINK_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SHOVEL_PINK_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.PICKAXE_PINK_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.AXE_PINK_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.HOE_PINK_CONCRETE_POWDER_BIRCH_MOLD,
            AllMoldBlocks.SWORD_PINK_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SHOVEL_PINK_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.PICKAXE_PINK_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.AXE_PINK_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.HOE_PINK_CONCRETE_POWDER_JUNGLE_MOLD,
            AllMoldBlocks.SWORD_PINK_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SHOVEL_PINK_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.PICKAXE_PINK_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.AXE_PINK_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.HOE_PINK_CONCRETE_POWDER_ACACIA_MOLD,
            AllMoldBlocks.SWORD_PINK_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SHOVEL_PINK_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.PICKAXE_PINK_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.AXE_PINK_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.HOE_PINK_CONCRETE_POWDER_DARK_OAK_MOLD,
            AllMoldBlocks.SWORD_PINK_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SHOVEL_PINK_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.PICKAXE_PINK_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.AXE_PINK_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.HOE_PINK_CONCRETE_POWDER_MANGROVE_MOLD,
            AllMoldBlocks.SWORD_PINK_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SHOVEL_PINK_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.PICKAXE_PINK_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.AXE_PINK_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.HOE_PINK_CONCRETE_POWDER_CHERRY_MOLD,
            AllMoldBlocks.SWORD_PINK_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SHOVEL_PINK_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.PICKAXE_PINK_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.AXE_PINK_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.HOE_PINK_CONCRETE_POWDER_BAMBOO_MOLD,
            AllMoldBlocks.SWORD_PINK_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SHOVEL_PINK_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.PICKAXE_PINK_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.AXE_PINK_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.HOE_PINK_CONCRETE_POWDER_CRIMSON_MOLD,
            AllMoldBlocks.SWORD_PINK_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.SHOVEL_PINK_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.PICKAXE_PINK_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.AXE_PINK_CONCRETE_POWDER_WARPED_MOLD,
            AllMoldBlocks.HOE_PINK_CONCRETE_POWDER_WARPED_MOLD
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
            if (stack.getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof MaterialMoldBlock) {
                CompoundTag nbt = stack.getTag();
                if (nbt != null && !nbt.contains(AllTagNames.ITEM_STACK_UNIQUE_ID, Tag.TAG_INT_ARRAY)) {
                    nbt.putUUID(AllTagNames.ITEM_STACK_UNIQUE_ID, UUID.randomUUID());
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

    private static void registerEmptyMoldTopTextureIdGetter(ToolModuleType.MoldTopTexture moldTopTexture, Set<ToolMaterialMoldBlock> moldBlocks, ToolModuleType toolModuleType, ResourceLocation textureId) {
        moldTopTexture.registerTextureIdGetter((original, baseMoldBlock, nbt) -> original == null && moldBlocks.contains(baseMoldBlock) && ToolUtils.MoldSlotState.fromName(nbt.getCompound(toolModuleType.getTag()).getString(AllTagNames.MOLD_SLOT_STATE)) == ToolUtils.MoldSlotState.EMPTY ? textureId : original);
    }

    private static void registerFullMoldTopTextureIdGetter(ToolModuleType.MoldTopTexture moldTopTexture, ToolModuleType toolModuleType, FlowingFluid fluid, ResourceLocation textureId) {
        moldTopTexture.registerTextureIdGetter((original, sandMoldBlock, nbt) -> {
            CompoundTag slotNbt = nbt.getCompound(toolModuleType.getTag());
            return original == null && ToolUtils.MoldSlotState.fromName(slotNbt.getString(AllTagNames.MOLD_SLOT_STATE)) == ToolUtils.MoldSlotState.FLUID && slotNbt.getString(AllTagNames.TOOL_MODULE_ID).equals(BuiltInRegistries.FLUID.getKey(fluid).toString()) ? textureId : original;
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
