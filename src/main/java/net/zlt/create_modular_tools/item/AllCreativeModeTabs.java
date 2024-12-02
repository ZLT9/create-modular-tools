package net.zlt.create_modular_tools.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.block.entity.mold.ToolMaterialMoldBlockEntity;
import net.zlt.create_modular_tools.item.mold.AllMoldItems;
import net.zlt.create_modular_tools.tool.module.AllToolModuleTypes;
import net.zlt.create_modular_tools.tool.module.AllToolModules;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class AllCreativeModeTabs {
    private AllCreativeModeTabs() {
    }

    public static final ResourceKey<CreativeModeTab> BASE_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), CreateModularTools.asResource("base"));
    public static final CreativeModeTab BASE = register(BASE_KEY, FabricItemGroup.builder()
        .icon(() -> {
            ItemStack stack = new ItemStack(AllItems.MODULAR_PICKAXE);
            CompoundTag stackNbt = stack.getOrCreateTag();
            CompoundTag toolModulesNbt = new CompoundTag();
            CompoundTag pickaxeHeadNbt = new CompoundTag();
            pickaxeHeadNbt.putString("id", AllToolModules.BRASS_PICKAXE_HEAD.getId());
            toolModulesNbt.put(AllToolModuleTypes.PICKAXE_HEAD.getTag(), pickaxeHeadNbt);
            CompoundTag toolHandleNbt = new CompoundTag();
            toolHandleNbt.putString("id", AllToolModules.NETHERITE_TOOL_HANDLE.getId());
            toolModulesNbt.put(AllToolModuleTypes.TOOL_HANDLE.getTag(), toolHandleNbt);
            CompoundTag toolGripNbt = new CompoundTag();
            toolGripNbt.putString("id", AllToolModules.ZINC_TOOL_GRIP.getId());
            toolModulesNbt.put(AllToolModuleTypes.TOOL_GRIP.getTag(), toolGripNbt);
            stackNbt.put(ToolMaterialMoldBlockEntity.TOOL_MODULES_TAG, toolModulesNbt);
            CompoundTag toolWrapNbt = new CompoundTag();
            toolWrapNbt.putString("id", AllToolModules.PURPLE_WOOL_TOOL_WRAP.getId());
            toolModulesNbt.put(AllToolModuleTypes.TOOL_WRAP.getTag(), toolWrapNbt);
            stackNbt.put(ToolMaterialMoldBlockEntity.TOOL_MODULES_TAG, toolModulesNbt);
            return stack;
        })
        .title(Component.translatable("itemGroup.create_modular_tools.base"))
        .build());

    private static CreativeModeTab register(ResourceKey<CreativeModeTab> key, CreativeModeTab tab) {
        return Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, key, tab);
    }

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(BASE_KEY).register(entries -> {
            entries.accept(AllItems.MOLTEN_IRON_BUCKET);
            entries.accept(AllItems.MOLTEN_COPPER_BUCKET);
            entries.accept(AllItems.MOLTEN_GOLD_BUCKET);
            entries.accept(AllItems.MOLTEN_NETHERITE_BUCKET);
            entries.accept(AllItems.MOLTEN_ZINC_BUCKET);
            entries.accept(AllItems.MOLTEN_BRASS_BUCKET);
            entries.accept(AllItems.MOLTEN_DIAMOND_BUCKET);

            entries.accept(AllItems.OAK_MOLD);
            entries.accept(AllItems.SPRUCE_MOLD);
            entries.accept(AllItems.BIRCH_MOLD);
            entries.accept(AllItems.JUNGLE_MOLD);
            entries.accept(AllItems.ACACIA_MOLD);
            entries.accept(AllItems.DARK_OAK_MOLD);
            entries.accept(AllItems.MANGROVE_MOLD);
            entries.accept(AllItems.CHERRY_MOLD);
            entries.accept(AllItems.BAMBOO_MOLD);
            entries.accept(AllItems.CRIMSON_MOLD);
            entries.accept(AllItems.WARPED_MOLD);

            entries.accept(AllMoldItems.SAND_OAK_MOLD);
            entries.accept(AllMoldItems.SAND_SPRUCE_MOLD);
            entries.accept(AllMoldItems.SAND_BIRCH_MOLD);
            entries.accept(AllMoldItems.SAND_JUNGLE_MOLD);
            entries.accept(AllMoldItems.SAND_ACACIA_MOLD);
            entries.accept(AllMoldItems.SAND_DARK_OAK_MOLD);
            entries.accept(AllMoldItems.SAND_MANGROVE_MOLD);
            entries.accept(AllMoldItems.SAND_CHERRY_MOLD);
            entries.accept(AllMoldItems.SAND_BAMBOO_MOLD);
            entries.accept(AllMoldItems.SAND_CRIMSON_MOLD);
            entries.accept(AllMoldItems.SAND_WARPED_MOLD);

            entries.accept(AllMoldItems.RED_SAND_OAK_MOLD);
            entries.accept(AllMoldItems.RED_SAND_SPRUCE_MOLD);
            entries.accept(AllMoldItems.RED_SAND_BIRCH_MOLD);
            entries.accept(AllMoldItems.RED_SAND_JUNGLE_MOLD);
            entries.accept(AllMoldItems.RED_SAND_ACACIA_MOLD);
            entries.accept(AllMoldItems.RED_SAND_DARK_OAK_MOLD);
            entries.accept(AllMoldItems.RED_SAND_MANGROVE_MOLD);
            entries.accept(AllMoldItems.RED_SAND_CHERRY_MOLD);
            entries.accept(AllMoldItems.RED_SAND_BAMBOO_MOLD);
            entries.accept(AllMoldItems.RED_SAND_CRIMSON_MOLD);
            entries.accept(AllMoldItems.RED_SAND_WARPED_MOLD);

            entries.accept(AllMoldItems.WHITE_CONCRETE_POWDER_OAK_MOLD);
            entries.accept(AllMoldItems.WHITE_CONCRETE_POWDER_SPRUCE_MOLD);
            entries.accept(AllMoldItems.WHITE_CONCRETE_POWDER_BIRCH_MOLD);
            entries.accept(AllMoldItems.WHITE_CONCRETE_POWDER_JUNGLE_MOLD);
            entries.accept(AllMoldItems.WHITE_CONCRETE_POWDER_ACACIA_MOLD);
            entries.accept(AllMoldItems.WHITE_CONCRETE_POWDER_DARK_OAK_MOLD);
            entries.accept(AllMoldItems.WHITE_CONCRETE_POWDER_MANGROVE_MOLD);
            entries.accept(AllMoldItems.WHITE_CONCRETE_POWDER_CHERRY_MOLD);
            entries.accept(AllMoldItems.WHITE_CONCRETE_POWDER_BAMBOO_MOLD);
            entries.accept(AllMoldItems.WHITE_CONCRETE_POWDER_CRIMSON_MOLD);
            entries.accept(AllMoldItems.WHITE_CONCRETE_POWDER_WARPED_MOLD);

            entries.accept(AllMoldItems.LIGHT_GRAY_CONCRETE_POWDER_OAK_MOLD);
            entries.accept(AllMoldItems.LIGHT_GRAY_CONCRETE_POWDER_SPRUCE_MOLD);
            entries.accept(AllMoldItems.LIGHT_GRAY_CONCRETE_POWDER_BIRCH_MOLD);
            entries.accept(AllMoldItems.LIGHT_GRAY_CONCRETE_POWDER_JUNGLE_MOLD);
            entries.accept(AllMoldItems.LIGHT_GRAY_CONCRETE_POWDER_ACACIA_MOLD);
            entries.accept(AllMoldItems.LIGHT_GRAY_CONCRETE_POWDER_DARK_OAK_MOLD);
            entries.accept(AllMoldItems.LIGHT_GRAY_CONCRETE_POWDER_MANGROVE_MOLD);
            entries.accept(AllMoldItems.LIGHT_GRAY_CONCRETE_POWDER_CHERRY_MOLD);
            entries.accept(AllMoldItems.LIGHT_GRAY_CONCRETE_POWDER_BAMBOO_MOLD);
            entries.accept(AllMoldItems.LIGHT_GRAY_CONCRETE_POWDER_CRIMSON_MOLD);
            entries.accept(AllMoldItems.LIGHT_GRAY_CONCRETE_POWDER_WARPED_MOLD);

            entries.accept(AllMoldItems.GRAY_CONCRETE_POWDER_OAK_MOLD);
            entries.accept(AllMoldItems.GRAY_CONCRETE_POWDER_SPRUCE_MOLD);
            entries.accept(AllMoldItems.GRAY_CONCRETE_POWDER_BIRCH_MOLD);
            entries.accept(AllMoldItems.GRAY_CONCRETE_POWDER_JUNGLE_MOLD);
            entries.accept(AllMoldItems.GRAY_CONCRETE_POWDER_ACACIA_MOLD);
            entries.accept(AllMoldItems.GRAY_CONCRETE_POWDER_DARK_OAK_MOLD);
            entries.accept(AllMoldItems.GRAY_CONCRETE_POWDER_MANGROVE_MOLD);
            entries.accept(AllMoldItems.GRAY_CONCRETE_POWDER_CHERRY_MOLD);
            entries.accept(AllMoldItems.GRAY_CONCRETE_POWDER_BAMBOO_MOLD);
            entries.accept(AllMoldItems.GRAY_CONCRETE_POWDER_CRIMSON_MOLD);
            entries.accept(AllMoldItems.GRAY_CONCRETE_POWDER_WARPED_MOLD);

            entries.accept(AllMoldItems.BLACK_CONCRETE_POWDER_OAK_MOLD);
            entries.accept(AllMoldItems.BLACK_CONCRETE_POWDER_SPRUCE_MOLD);
            entries.accept(AllMoldItems.BLACK_CONCRETE_POWDER_BIRCH_MOLD);
            entries.accept(AllMoldItems.BLACK_CONCRETE_POWDER_JUNGLE_MOLD);
            entries.accept(AllMoldItems.BLACK_CONCRETE_POWDER_ACACIA_MOLD);
            entries.accept(AllMoldItems.BLACK_CONCRETE_POWDER_DARK_OAK_MOLD);
            entries.accept(AllMoldItems.BLACK_CONCRETE_POWDER_MANGROVE_MOLD);
            entries.accept(AllMoldItems.BLACK_CONCRETE_POWDER_CHERRY_MOLD);
            entries.accept(AllMoldItems.BLACK_CONCRETE_POWDER_BAMBOO_MOLD);
            entries.accept(AllMoldItems.BLACK_CONCRETE_POWDER_CRIMSON_MOLD);
            entries.accept(AllMoldItems.BLACK_CONCRETE_POWDER_WARPED_MOLD);

            entries.accept(AllMoldItems.BROWN_CONCRETE_POWDER_OAK_MOLD);
            entries.accept(AllMoldItems.BROWN_CONCRETE_POWDER_SPRUCE_MOLD);
            entries.accept(AllMoldItems.BROWN_CONCRETE_POWDER_BIRCH_MOLD);
            entries.accept(AllMoldItems.BROWN_CONCRETE_POWDER_JUNGLE_MOLD);
            entries.accept(AllMoldItems.BROWN_CONCRETE_POWDER_ACACIA_MOLD);
            entries.accept(AllMoldItems.BROWN_CONCRETE_POWDER_DARK_OAK_MOLD);
            entries.accept(AllMoldItems.BROWN_CONCRETE_POWDER_MANGROVE_MOLD);
            entries.accept(AllMoldItems.BROWN_CONCRETE_POWDER_CHERRY_MOLD);
            entries.accept(AllMoldItems.BROWN_CONCRETE_POWDER_BAMBOO_MOLD);
            entries.accept(AllMoldItems.BROWN_CONCRETE_POWDER_CRIMSON_MOLD);
            entries.accept(AllMoldItems.BROWN_CONCRETE_POWDER_WARPED_MOLD);

            entries.accept(AllMoldItems.RED_CONCRETE_POWDER_OAK_MOLD);
            entries.accept(AllMoldItems.RED_CONCRETE_POWDER_SPRUCE_MOLD);
            entries.accept(AllMoldItems.RED_CONCRETE_POWDER_BIRCH_MOLD);
            entries.accept(AllMoldItems.RED_CONCRETE_POWDER_JUNGLE_MOLD);
            entries.accept(AllMoldItems.RED_CONCRETE_POWDER_ACACIA_MOLD);
            entries.accept(AllMoldItems.RED_CONCRETE_POWDER_DARK_OAK_MOLD);
            entries.accept(AllMoldItems.RED_CONCRETE_POWDER_MANGROVE_MOLD);
            entries.accept(AllMoldItems.RED_CONCRETE_POWDER_CHERRY_MOLD);
            entries.accept(AllMoldItems.RED_CONCRETE_POWDER_BAMBOO_MOLD);
            entries.accept(AllMoldItems.RED_CONCRETE_POWDER_CRIMSON_MOLD);
            entries.accept(AllMoldItems.RED_CONCRETE_POWDER_WARPED_MOLD);

            entries.accept(AllMoldItems.ORANGE_CONCRETE_POWDER_OAK_MOLD);
            entries.accept(AllMoldItems.ORANGE_CONCRETE_POWDER_SPRUCE_MOLD);
            entries.accept(AllMoldItems.ORANGE_CONCRETE_POWDER_BIRCH_MOLD);
            entries.accept(AllMoldItems.ORANGE_CONCRETE_POWDER_JUNGLE_MOLD);
            entries.accept(AllMoldItems.ORANGE_CONCRETE_POWDER_ACACIA_MOLD);
            entries.accept(AllMoldItems.ORANGE_CONCRETE_POWDER_DARK_OAK_MOLD);
            entries.accept(AllMoldItems.ORANGE_CONCRETE_POWDER_MANGROVE_MOLD);
            entries.accept(AllMoldItems.ORANGE_CONCRETE_POWDER_CHERRY_MOLD);
            entries.accept(AllMoldItems.ORANGE_CONCRETE_POWDER_BAMBOO_MOLD);
            entries.accept(AllMoldItems.ORANGE_CONCRETE_POWDER_CRIMSON_MOLD);
            entries.accept(AllMoldItems.ORANGE_CONCRETE_POWDER_WARPED_MOLD);

            entries.accept(AllMoldItems.YELLOW_CONCRETE_POWDER_OAK_MOLD);
            entries.accept(AllMoldItems.YELLOW_CONCRETE_POWDER_SPRUCE_MOLD);
            entries.accept(AllMoldItems.YELLOW_CONCRETE_POWDER_BIRCH_MOLD);
            entries.accept(AllMoldItems.YELLOW_CONCRETE_POWDER_JUNGLE_MOLD);
            entries.accept(AllMoldItems.YELLOW_CONCRETE_POWDER_ACACIA_MOLD);
            entries.accept(AllMoldItems.YELLOW_CONCRETE_POWDER_DARK_OAK_MOLD);
            entries.accept(AllMoldItems.YELLOW_CONCRETE_POWDER_MANGROVE_MOLD);
            entries.accept(AllMoldItems.YELLOW_CONCRETE_POWDER_CHERRY_MOLD);
            entries.accept(AllMoldItems.YELLOW_CONCRETE_POWDER_BAMBOO_MOLD);
            entries.accept(AllMoldItems.YELLOW_CONCRETE_POWDER_CRIMSON_MOLD);
            entries.accept(AllMoldItems.YELLOW_CONCRETE_POWDER_WARPED_MOLD);

            entries.accept(AllMoldItems.LIME_CONCRETE_POWDER_OAK_MOLD);
            entries.accept(AllMoldItems.LIME_CONCRETE_POWDER_SPRUCE_MOLD);
            entries.accept(AllMoldItems.LIME_CONCRETE_POWDER_BIRCH_MOLD);
            entries.accept(AllMoldItems.LIME_CONCRETE_POWDER_JUNGLE_MOLD);
            entries.accept(AllMoldItems.LIME_CONCRETE_POWDER_ACACIA_MOLD);
            entries.accept(AllMoldItems.LIME_CONCRETE_POWDER_DARK_OAK_MOLD);
            entries.accept(AllMoldItems.LIME_CONCRETE_POWDER_MANGROVE_MOLD);
            entries.accept(AllMoldItems.LIME_CONCRETE_POWDER_CHERRY_MOLD);
            entries.accept(AllMoldItems.LIME_CONCRETE_POWDER_BAMBOO_MOLD);
            entries.accept(AllMoldItems.LIME_CONCRETE_POWDER_CRIMSON_MOLD);
            entries.accept(AllMoldItems.LIME_CONCRETE_POWDER_WARPED_MOLD);

            entries.accept(AllMoldItems.GREEN_CONCRETE_POWDER_OAK_MOLD);
            entries.accept(AllMoldItems.GREEN_CONCRETE_POWDER_SPRUCE_MOLD);
            entries.accept(AllMoldItems.GREEN_CONCRETE_POWDER_BIRCH_MOLD);
            entries.accept(AllMoldItems.GREEN_CONCRETE_POWDER_JUNGLE_MOLD);
            entries.accept(AllMoldItems.GREEN_CONCRETE_POWDER_ACACIA_MOLD);
            entries.accept(AllMoldItems.GREEN_CONCRETE_POWDER_DARK_OAK_MOLD);
            entries.accept(AllMoldItems.GREEN_CONCRETE_POWDER_MANGROVE_MOLD);
            entries.accept(AllMoldItems.GREEN_CONCRETE_POWDER_CHERRY_MOLD);
            entries.accept(AllMoldItems.GREEN_CONCRETE_POWDER_BAMBOO_MOLD);
            entries.accept(AllMoldItems.GREEN_CONCRETE_POWDER_CRIMSON_MOLD);
            entries.accept(AllMoldItems.GREEN_CONCRETE_POWDER_WARPED_MOLD);

            entries.accept(AllMoldItems.CYAN_CONCRETE_POWDER_OAK_MOLD);
            entries.accept(AllMoldItems.CYAN_CONCRETE_POWDER_SPRUCE_MOLD);
            entries.accept(AllMoldItems.CYAN_CONCRETE_POWDER_BIRCH_MOLD);
            entries.accept(AllMoldItems.CYAN_CONCRETE_POWDER_JUNGLE_MOLD);
            entries.accept(AllMoldItems.CYAN_CONCRETE_POWDER_ACACIA_MOLD);
            entries.accept(AllMoldItems.CYAN_CONCRETE_POWDER_DARK_OAK_MOLD);
            entries.accept(AllMoldItems.CYAN_CONCRETE_POWDER_MANGROVE_MOLD);
            entries.accept(AllMoldItems.CYAN_CONCRETE_POWDER_CHERRY_MOLD);
            entries.accept(AllMoldItems.CYAN_CONCRETE_POWDER_BAMBOO_MOLD);
            entries.accept(AllMoldItems.CYAN_CONCRETE_POWDER_CRIMSON_MOLD);
            entries.accept(AllMoldItems.CYAN_CONCRETE_POWDER_WARPED_MOLD);

            entries.accept(AllMoldItems.LIGHT_BLUE_CONCRETE_POWDER_OAK_MOLD);
            entries.accept(AllMoldItems.LIGHT_BLUE_CONCRETE_POWDER_SPRUCE_MOLD);
            entries.accept(AllMoldItems.LIGHT_BLUE_CONCRETE_POWDER_BIRCH_MOLD);
            entries.accept(AllMoldItems.LIGHT_BLUE_CONCRETE_POWDER_JUNGLE_MOLD);
            entries.accept(AllMoldItems.LIGHT_BLUE_CONCRETE_POWDER_ACACIA_MOLD);
            entries.accept(AllMoldItems.LIGHT_BLUE_CONCRETE_POWDER_DARK_OAK_MOLD);
            entries.accept(AllMoldItems.LIGHT_BLUE_CONCRETE_POWDER_MANGROVE_MOLD);
            entries.accept(AllMoldItems.LIGHT_BLUE_CONCRETE_POWDER_CHERRY_MOLD);
            entries.accept(AllMoldItems.LIGHT_BLUE_CONCRETE_POWDER_BAMBOO_MOLD);
            entries.accept(AllMoldItems.LIGHT_BLUE_CONCRETE_POWDER_CRIMSON_MOLD);
            entries.accept(AllMoldItems.LIGHT_BLUE_CONCRETE_POWDER_WARPED_MOLD);

            entries.accept(AllMoldItems.BLUE_CONCRETE_POWDER_OAK_MOLD);
            entries.accept(AllMoldItems.BLUE_CONCRETE_POWDER_SPRUCE_MOLD);
            entries.accept(AllMoldItems.BLUE_CONCRETE_POWDER_BIRCH_MOLD);
            entries.accept(AllMoldItems.BLUE_CONCRETE_POWDER_JUNGLE_MOLD);
            entries.accept(AllMoldItems.BLUE_CONCRETE_POWDER_ACACIA_MOLD);
            entries.accept(AllMoldItems.BLUE_CONCRETE_POWDER_DARK_OAK_MOLD);
            entries.accept(AllMoldItems.BLUE_CONCRETE_POWDER_MANGROVE_MOLD);
            entries.accept(AllMoldItems.BLUE_CONCRETE_POWDER_CHERRY_MOLD);
            entries.accept(AllMoldItems.BLUE_CONCRETE_POWDER_BAMBOO_MOLD);
            entries.accept(AllMoldItems.BLUE_CONCRETE_POWDER_CRIMSON_MOLD);
            entries.accept(AllMoldItems.BLUE_CONCRETE_POWDER_WARPED_MOLD);

            entries.accept(AllMoldItems.PURPLE_CONCRETE_POWDER_OAK_MOLD);
            entries.accept(AllMoldItems.PURPLE_CONCRETE_POWDER_SPRUCE_MOLD);
            entries.accept(AllMoldItems.PURPLE_CONCRETE_POWDER_BIRCH_MOLD);
            entries.accept(AllMoldItems.PURPLE_CONCRETE_POWDER_JUNGLE_MOLD);
            entries.accept(AllMoldItems.PURPLE_CONCRETE_POWDER_ACACIA_MOLD);
            entries.accept(AllMoldItems.PURPLE_CONCRETE_POWDER_DARK_OAK_MOLD);
            entries.accept(AllMoldItems.PURPLE_CONCRETE_POWDER_MANGROVE_MOLD);
            entries.accept(AllMoldItems.PURPLE_CONCRETE_POWDER_CHERRY_MOLD);
            entries.accept(AllMoldItems.PURPLE_CONCRETE_POWDER_BAMBOO_MOLD);
            entries.accept(AllMoldItems.PURPLE_CONCRETE_POWDER_CRIMSON_MOLD);
            entries.accept(AllMoldItems.PURPLE_CONCRETE_POWDER_WARPED_MOLD);

            entries.accept(AllMoldItems.MAGENTA_CONCRETE_POWDER_OAK_MOLD);
            entries.accept(AllMoldItems.MAGENTA_CONCRETE_POWDER_SPRUCE_MOLD);
            entries.accept(AllMoldItems.MAGENTA_CONCRETE_POWDER_BIRCH_MOLD);
            entries.accept(AllMoldItems.MAGENTA_CONCRETE_POWDER_JUNGLE_MOLD);
            entries.accept(AllMoldItems.MAGENTA_CONCRETE_POWDER_ACACIA_MOLD);
            entries.accept(AllMoldItems.MAGENTA_CONCRETE_POWDER_DARK_OAK_MOLD);
            entries.accept(AllMoldItems.MAGENTA_CONCRETE_POWDER_MANGROVE_MOLD);
            entries.accept(AllMoldItems.MAGENTA_CONCRETE_POWDER_CHERRY_MOLD);
            entries.accept(AllMoldItems.MAGENTA_CONCRETE_POWDER_BAMBOO_MOLD);
            entries.accept(AllMoldItems.MAGENTA_CONCRETE_POWDER_CRIMSON_MOLD);
            entries.accept(AllMoldItems.MAGENTA_CONCRETE_POWDER_WARPED_MOLD);

            entries.accept(AllMoldItems.PINK_CONCRETE_POWDER_OAK_MOLD);
            entries.accept(AllMoldItems.PINK_CONCRETE_POWDER_SPRUCE_MOLD);
            entries.accept(AllMoldItems.PINK_CONCRETE_POWDER_BIRCH_MOLD);
            entries.accept(AllMoldItems.PINK_CONCRETE_POWDER_JUNGLE_MOLD);
            entries.accept(AllMoldItems.PINK_CONCRETE_POWDER_ACACIA_MOLD);
            entries.accept(AllMoldItems.PINK_CONCRETE_POWDER_DARK_OAK_MOLD);
            entries.accept(AllMoldItems.PINK_CONCRETE_POWDER_MANGROVE_MOLD);
            entries.accept(AllMoldItems.PINK_CONCRETE_POWDER_CHERRY_MOLD);
            entries.accept(AllMoldItems.PINK_CONCRETE_POWDER_BAMBOO_MOLD);
            entries.accept(AllMoldItems.PINK_CONCRETE_POWDER_CRIMSON_MOLD);
            entries.accept(AllMoldItems.PINK_CONCRETE_POWDER_WARPED_MOLD);

            entries.accept(AllItems.WOODEN_TOOL_HANDLE);
            entries.accept(AllItems.OAK_TOOL_HANDLE);
            entries.accept(AllItems.SPRUCE_TOOL_HANDLE);
            entries.accept(AllItems.BIRCH_TOOL_HANDLE);
            entries.accept(AllItems.JUNGLE_TOOL_HANDLE);
            entries.accept(AllItems.ACACIA_TOOL_HANDLE);
            entries.accept(AllItems.DARK_OAK_TOOL_HANDLE);
            entries.accept(AllItems.MANGROVE_TOOL_HANDLE);
            entries.accept(AllItems.CHERRY_TOOL_HANDLE);
            entries.accept(AllItems.BAMBOO_TOOL_HANDLE);
            entries.accept(AllItems.CRIMSON_TOOL_HANDLE);
            entries.accept(AllItems.WARPED_TOOL_HANDLE);
            entries.accept(AllItems.STONE_TOOL_HANDLE);
            entries.accept(AllItems.IRON_TOOL_HANDLE);
            entries.accept(AllItems.COPPER_TOOL_HANDLE);
            entries.accept(AllItems.GOLDEN_TOOL_HANDLE);
            entries.accept(AllItems.NETHERITE_TOOL_HANDLE);
            entries.accept(AllItems.ZINC_TOOL_HANDLE);
            entries.accept(AllItems.BRASS_TOOL_HANDLE);
            entries.accept(AllItems.DIAMOND_TOOL_HANDLE);

            entries.accept(AllItems.WOODEN_SWORD_BLADE);
            entries.accept(AllItems.OAK_SWORD_BLADE);
            entries.accept(AllItems.SPRUCE_SWORD_BLADE);
            entries.accept(AllItems.BIRCH_SWORD_BLADE);
            entries.accept(AllItems.JUNGLE_SWORD_BLADE);
            entries.accept(AllItems.ACACIA_SWORD_BLADE);
            entries.accept(AllItems.DARK_OAK_SWORD_BLADE);
            entries.accept(AllItems.MANGROVE_SWORD_BLADE);
            entries.accept(AllItems.CHERRY_SWORD_BLADE);
            entries.accept(AllItems.BAMBOO_SWORD_BLADE);
            entries.accept(AllItems.CRIMSON_SWORD_BLADE);
            entries.accept(AllItems.WARPED_SWORD_BLADE);
            entries.accept(AllItems.STONE_SWORD_BLADE);
            entries.accept(AllItems.IRON_SWORD_BLADE);
            entries.accept(AllItems.COPPER_SWORD_BLADE);
            entries.accept(AllItems.GOLDEN_SWORD_BLADE);
            entries.accept(AllItems.NETHERITE_SWORD_BLADE);
            entries.accept(AllItems.ZINC_SWORD_BLADE);
            entries.accept(AllItems.BRASS_SWORD_BLADE);
            entries.accept(AllItems.DIAMOND_SWORD_BLADE);

            entries.accept(AllItems.WOODEN_SHOVEL_HEAD);
            entries.accept(AllItems.OAK_SHOVEL_HEAD);
            entries.accept(AllItems.SPRUCE_SHOVEL_HEAD);
            entries.accept(AllItems.BIRCH_SHOVEL_HEAD);
            entries.accept(AllItems.JUNGLE_SHOVEL_HEAD);
            entries.accept(AllItems.ACACIA_SHOVEL_HEAD);
            entries.accept(AllItems.DARK_OAK_SHOVEL_HEAD);
            entries.accept(AllItems.MANGROVE_SHOVEL_HEAD);
            entries.accept(AllItems.CHERRY_SHOVEL_HEAD);
            entries.accept(AllItems.BAMBOO_SHOVEL_HEAD);
            entries.accept(AllItems.CRIMSON_SHOVEL_HEAD);
            entries.accept(AllItems.WARPED_SHOVEL_HEAD);
            entries.accept(AllItems.STONE_SHOVEL_HEAD);
            entries.accept(AllItems.IRON_SHOVEL_HEAD);
            entries.accept(AllItems.COPPER_SHOVEL_HEAD);
            entries.accept(AllItems.GOLDEN_SHOVEL_HEAD);
            entries.accept(AllItems.NETHERITE_SHOVEL_HEAD);
            entries.accept(AllItems.ZINC_SHOVEL_HEAD);
            entries.accept(AllItems.BRASS_SHOVEL_HEAD);
            entries.accept(AllItems.DIAMOND_SHOVEL_HEAD);

            entries.accept(AllItems.WOODEN_PICKAXE_HEAD);
            entries.accept(AllItems.OAK_PICKAXE_HEAD);
            entries.accept(AllItems.SPRUCE_PICKAXE_HEAD);
            entries.accept(AllItems.BIRCH_PICKAXE_HEAD);
            entries.accept(AllItems.JUNGLE_PICKAXE_HEAD);
            entries.accept(AllItems.ACACIA_PICKAXE_HEAD);
            entries.accept(AllItems.DARK_OAK_PICKAXE_HEAD);
            entries.accept(AllItems.MANGROVE_PICKAXE_HEAD);
            entries.accept(AllItems.CHERRY_PICKAXE_HEAD);
            entries.accept(AllItems.BAMBOO_PICKAXE_HEAD);
            entries.accept(AllItems.CRIMSON_PICKAXE_HEAD);
            entries.accept(AllItems.WARPED_PICKAXE_HEAD);
            entries.accept(AllItems.STONE_PICKAXE_HEAD);
            entries.accept(AllItems.IRON_PICKAXE_HEAD);
            entries.accept(AllItems.COPPER_PICKAXE_HEAD);
            entries.accept(AllItems.GOLDEN_PICKAXE_HEAD);
            entries.accept(AllItems.NETHERITE_PICKAXE_HEAD);
            entries.accept(AllItems.ZINC_PICKAXE_HEAD);
            entries.accept(AllItems.BRASS_PICKAXE_HEAD);
            entries.accept(AllItems.DIAMOND_PICKAXE_HEAD);

            entries.accept(AllItems.WOODEN_AXE_HEAD);
            entries.accept(AllItems.OAK_AXE_HEAD);
            entries.accept(AllItems.SPRUCE_AXE_HEAD);
            entries.accept(AllItems.BIRCH_AXE_HEAD);
            entries.accept(AllItems.JUNGLE_AXE_HEAD);
            entries.accept(AllItems.ACACIA_AXE_HEAD);
            entries.accept(AllItems.DARK_OAK_AXE_HEAD);
            entries.accept(AllItems.MANGROVE_AXE_HEAD);
            entries.accept(AllItems.CHERRY_AXE_HEAD);
            entries.accept(AllItems.BAMBOO_AXE_HEAD);
            entries.accept(AllItems.CRIMSON_AXE_HEAD);
            entries.accept(AllItems.WARPED_AXE_HEAD);
            entries.accept(AllItems.STONE_AXE_HEAD);
            entries.accept(AllItems.IRON_AXE_HEAD);
            entries.accept(AllItems.COPPER_AXE_HEAD);
            entries.accept(AllItems.GOLDEN_AXE_HEAD);
            entries.accept(AllItems.NETHERITE_AXE_HEAD);
            entries.accept(AllItems.ZINC_AXE_HEAD);
            entries.accept(AllItems.BRASS_AXE_HEAD);
            entries.accept(AllItems.DIAMOND_AXE_HEAD);

            entries.accept(AllItems.WOODEN_HOE_HEAD);
            entries.accept(AllItems.OAK_HOE_HEAD);
            entries.accept(AllItems.SPRUCE_HOE_HEAD);
            entries.accept(AllItems.BIRCH_HOE_HEAD);
            entries.accept(AllItems.JUNGLE_HOE_HEAD);
            entries.accept(AllItems.ACACIA_HOE_HEAD);
            entries.accept(AllItems.DARK_OAK_HOE_HEAD);
            entries.accept(AllItems.MANGROVE_HOE_HEAD);
            entries.accept(AllItems.CHERRY_HOE_HEAD);
            entries.accept(AllItems.BAMBOO_HOE_HEAD);
            entries.accept(AllItems.CRIMSON_HOE_HEAD);
            entries.accept(AllItems.WARPED_HOE_HEAD);
            entries.accept(AllItems.STONE_HOE_HEAD);
            entries.accept(AllItems.IRON_HOE_HEAD);
            entries.accept(AllItems.COPPER_HOE_HEAD);
            entries.accept(AllItems.GOLDEN_HOE_HEAD);
            entries.accept(AllItems.NETHERITE_HOE_HEAD);
            entries.accept(AllItems.ZINC_HOE_HEAD);
            entries.accept(AllItems.BRASS_HOE_HEAD);
            entries.accept(AllItems.DIAMOND_HOE_HEAD);

            entries.accept(AllItems.WOODEN_TOOL_GRIP);
            entries.accept(AllItems.OAK_TOOL_GRIP);
            entries.accept(AllItems.SPRUCE_TOOL_GRIP);
            entries.accept(AllItems.BIRCH_TOOL_GRIP);
            entries.accept(AllItems.JUNGLE_TOOL_GRIP);
            entries.accept(AllItems.ACACIA_TOOL_GRIP);
            entries.accept(AllItems.DARK_OAK_TOOL_GRIP);
            entries.accept(AllItems.MANGROVE_TOOL_GRIP);
            entries.accept(AllItems.CHERRY_TOOL_GRIP);
            entries.accept(AllItems.BAMBOO_TOOL_GRIP);
            entries.accept(AllItems.CRIMSON_TOOL_GRIP);
            entries.accept(AllItems.WARPED_TOOL_GRIP);
            entries.accept(AllItems.STONE_TOOL_GRIP);
            entries.accept(AllItems.IRON_TOOL_GRIP);
            entries.accept(AllItems.COPPER_TOOL_GRIP);
            entries.accept(AllItems.GOLDEN_TOOL_GRIP);
            entries.accept(AllItems.NETHERITE_TOOL_GRIP);
            entries.accept(AllItems.ZINC_TOOL_GRIP);
            entries.accept(AllItems.BRASS_TOOL_GRIP);
            entries.accept(AllItems.DIAMOND_TOOL_GRIP);

            entries.accept(AllItems.WOODEN_SWORD_GUARD);
            entries.accept(AllItems.OAK_SWORD_GUARD);
            entries.accept(AllItems.SPRUCE_SWORD_GUARD);
            entries.accept(AllItems.BIRCH_SWORD_GUARD);
            entries.accept(AllItems.JUNGLE_SWORD_GUARD);
            entries.accept(AllItems.ACACIA_SWORD_GUARD);
            entries.accept(AllItems.DARK_OAK_SWORD_GUARD);
            entries.accept(AllItems.MANGROVE_SWORD_GUARD);
            entries.accept(AllItems.CHERRY_SWORD_GUARD);
            entries.accept(AllItems.BAMBOO_SWORD_GUARD);
            entries.accept(AllItems.CRIMSON_SWORD_GUARD);
            entries.accept(AllItems.WARPED_SWORD_GUARD);
            entries.accept(AllItems.STONE_SWORD_GUARD);
            entries.accept(AllItems.IRON_SWORD_GUARD);
            entries.accept(AllItems.COPPER_SWORD_GUARD);
            entries.accept(AllItems.GOLDEN_SWORD_GUARD);
            entries.accept(AllItems.NETHERITE_SWORD_GUARD);
            entries.accept(AllItems.ZINC_SWORD_GUARD);
            entries.accept(AllItems.BRASS_SWORD_GUARD);
            entries.accept(AllItems.DIAMOND_SWORD_GUARD);

            entries.accept(AllItems.WOODEN_SWORD_POMMEL);
            entries.accept(AllItems.OAK_SWORD_POMMEL);
            entries.accept(AllItems.SPRUCE_SWORD_POMMEL);
            entries.accept(AllItems.BIRCH_SWORD_POMMEL);
            entries.accept(AllItems.JUNGLE_SWORD_POMMEL);
            entries.accept(AllItems.ACACIA_SWORD_POMMEL);
            entries.accept(AllItems.DARK_OAK_SWORD_POMMEL);
            entries.accept(AllItems.MANGROVE_SWORD_POMMEL);
            entries.accept(AllItems.CHERRY_SWORD_POMMEL);
            entries.accept(AllItems.BAMBOO_SWORD_POMMEL);
            entries.accept(AllItems.CRIMSON_SWORD_POMMEL);
            entries.accept(AllItems.WARPED_SWORD_POMMEL);
            entries.accept(AllItems.STONE_SWORD_POMMEL);
            entries.accept(AllItems.IRON_SWORD_POMMEL);
            entries.accept(AllItems.COPPER_SWORD_POMMEL);
            entries.accept(AllItems.GOLDEN_SWORD_POMMEL);
            entries.accept(AllItems.NETHERITE_SWORD_POMMEL);
            entries.accept(AllItems.ZINC_SWORD_POMMEL);
            entries.accept(AllItems.BRASS_SWORD_POMMEL);
            entries.accept(AllItems.DIAMOND_SWORD_POMMEL);

            entries.accept(AllItems.WHITE_WOOL_TOOL_WRAP);
            entries.accept(AllItems.LIGHT_GRAY_WOOL_TOOL_WRAP);
            entries.accept(AllItems.GRAY_WOOL_TOOL_WRAP);
            entries.accept(AllItems.BLACK_WOOL_TOOL_WRAP);
            entries.accept(AllItems.BROWN_WOOL_TOOL_WRAP);
            entries.accept(AllItems.RED_WOOL_TOOL_WRAP);
            entries.accept(AllItems.ORANGE_WOOL_TOOL_WRAP);
            entries.accept(AllItems.YELLOW_WOOL_TOOL_WRAP);
            entries.accept(AllItems.LIME_WOOL_TOOL_WRAP);
            entries.accept(AllItems.GREEN_WOOL_TOOL_WRAP);
            entries.accept(AllItems.CYAN_WOOL_TOOL_WRAP);
            entries.accept(AllItems.LIGHT_BLUE_WOOL_TOOL_WRAP);
            entries.accept(AllItems.BLUE_WOOL_TOOL_WRAP);
            entries.accept(AllItems.PURPLE_WOOL_TOOL_WRAP);
            entries.accept(AllItems.MAGENTA_WOOL_TOOL_WRAP);
            entries.accept(AllItems.PINK_WOOL_TOOL_WRAP);
        });
    }
}
