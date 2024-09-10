package net.zlt.create_modular_tools;

import com.simibubi.create.Create;
import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import net.fabricmc.api.ModInitializer;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluids;
import net.zlt.create_modular_tools.advancement.AllCriterionTriggers;
import net.zlt.create_modular_tools.block.AllBlocks;
import net.zlt.create_modular_tools.block.AllSoundTypes;
import net.zlt.create_modular_tools.block.entity.AllBlockEntityTypes;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.mold.*;
import net.zlt.create_modular_tools.container.menu.AllMenuTypes;
import net.zlt.create_modular_tools.entity.AllEntityTypes;
import net.zlt.create_modular_tools.fluid.AllFluids;
import net.zlt.create_modular_tools.item.AllCreativeModeTabs;
import net.zlt.create_modular_tools.item.AllItemTags;
import net.zlt.create_modular_tools.item.AllItems;
import net.zlt.create_modular_tools.item.mold.AllMoldItems;
import net.zlt.create_modular_tools.loot.function.AllLootItemFunctionTypes;
import net.zlt.create_modular_tools.recipe.AllRecipeTypes;
import net.zlt.create_modular_tools.tool.AllModularTools;
import net.zlt.create_modular_tools.tool.module.AllToolModuleTypes;
import net.zlt.create_modular_tools.tool.module.AllToolModules;
import net.zlt.create_modular_tools.tool.module.ToolModuleRecipeRegistry;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateModularTools implements ModInitializer {
    public static final String ID = "create_modular_tools";
    public static final String NAME = "Create: Modular Tools";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    @Override
    public void onInitialize() {
        LOGGER.info("Create addon mod [{}] is loading alongside Create [{}]!", NAME, Create.VERSION);
        LOGGER.info(EnvExecutor.unsafeRunForDist(
            () -> () -> "{} is accessing Porting Lib from the client!",
            () -> () -> "{} is accessing Porting Lib from the server!"
        ), NAME);

        AllItemTags.init();
        AllSoundTypes.init();
        AllFluids.init();
        AllBlocks.init();
        AllBlockEntityTypes.init();
        AllToolModuleTypes.init();
        AllToolModules.init();
        AllItems.init();
        AllModularTools.init();
        AllMoldBlocks.init();
        AllMoldBlockEntityTypes.init();
        AllMoldItems.init();
        AllCreativeModeTabs.init();
        AllMenuTypes.init();
        AllLootItemFunctionTypes.init();
        AllRecipeTypes.init();
        AllMoldTopTextures.init();
        AllEntityTypes.init();
        AllCriterionTriggers.init();

        SwordSandMoldBlock.addRequired(AllToolModuleTypes.TOOL_HANDLE, AllToolModuleTypes.SWORD_BLADE);
        SwordSandMoldBlock.addCompatible(AllToolModuleTypes.SWORD_POMMEL, AllToolModuleTypes.SWORD_GUARD);

        ShovelSandMoldBlock.addRequired(AllToolModuleTypes.TOOL_HANDLE, AllToolModuleTypes.SHOVEL_HEAD);
        ShovelSandMoldBlock.addCompatible(AllToolModuleTypes.TOOL_GRIP);

        PickaxeSandMoldBlock.addRequired(AllToolModuleTypes.TOOL_HANDLE, AllToolModuleTypes.PICKAXE_HEAD);
        PickaxeSandMoldBlock.addCompatible(AllToolModuleTypes.TOOL_GRIP);

        AxeSandMoldBlock.addRequired(AllToolModuleTypes.TOOL_HANDLE, AllToolModuleTypes.AXE_HEAD);
        AxeSandMoldBlock.addCompatible(AllToolModuleTypes.TOOL_GRIP);

        HoeSandMoldBlock.addRequired(AllToolModuleTypes.TOOL_HANDLE, AllToolModuleTypes.HOE_HEAD);
        HoeSandMoldBlock.addCompatible(AllToolModuleTypes.TOOL_GRIP);

        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_BLADE, Fluids.LAVA, AllToolModules.STONE_SWORD_BLADE);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_BLADE, AllFluids.MOLTEN_IRON, AllToolModules.IRON_SWORD_BLADE);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_BLADE, AllFluids.MOLTEN_COPPER, AllToolModules.COPPER_SWORD_BLADE);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_BLADE, AllFluids.MOLTEN_GOLD, AllToolModules.GOLDEN_SWORD_BLADE);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_BLADE, AllFluids.MOLTEN_NETHERITE, AllToolModules.NETHERITE_SWORD_BLADE);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_BLADE, AllFluids.MOLTEN_ZINC, AllToolModules.ZINC_SWORD_BLADE);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_BLADE, AllFluids.MOLTEN_BRASS, AllToolModules.BRASS_SWORD_BLADE);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_BLADE, AllFluids.MOLTEN_DIAMOND, AllToolModules.DIAMOND_SWORD_BLADE);

        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SHOVEL_HEAD, Fluids.LAVA, AllToolModules.STONE_SHOVEL_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SHOVEL_HEAD, AllFluids.MOLTEN_IRON, AllToolModules.IRON_SHOVEL_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SHOVEL_HEAD, AllFluids.MOLTEN_COPPER, AllToolModules.COPPER_SHOVEL_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SHOVEL_HEAD, AllFluids.MOLTEN_GOLD, AllToolModules.GOLDEN_SHOVEL_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SHOVEL_HEAD, AllFluids.MOLTEN_NETHERITE, AllToolModules.NETHERITE_SHOVEL_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SHOVEL_HEAD, AllFluids.MOLTEN_ZINC, AllToolModules.ZINC_SHOVEL_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SHOVEL_HEAD, AllFluids.MOLTEN_BRASS, AllToolModules.BRASS_SHOVEL_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SHOVEL_HEAD, AllFluids.MOLTEN_DIAMOND, AllToolModules.DIAMOND_SHOVEL_HEAD);

        ToolModuleRecipeRegistry.register(AllToolModuleTypes.PICKAXE_HEAD, Fluids.LAVA, AllToolModules.STONE_PICKAXE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.PICKAXE_HEAD, AllFluids.MOLTEN_IRON, AllToolModules.IRON_PICKAXE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.PICKAXE_HEAD, AllFluids.MOLTEN_COPPER, AllToolModules.COPPER_PICKAXE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.PICKAXE_HEAD, AllFluids.MOLTEN_GOLD, AllToolModules.GOLDEN_PICKAXE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.PICKAXE_HEAD, AllFluids.MOLTEN_NETHERITE, AllToolModules.NETHERITE_PICKAXE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.PICKAXE_HEAD, AllFluids.MOLTEN_ZINC, AllToolModules.ZINC_PICKAXE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.PICKAXE_HEAD, AllFluids.MOLTEN_BRASS, AllToolModules.BRASS_PICKAXE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.PICKAXE_HEAD, AllFluids.MOLTEN_DIAMOND, AllToolModules.DIAMOND_PICKAXE_HEAD);

        ToolModuleRecipeRegistry.register(AllToolModuleTypes.AXE_HEAD, Fluids.LAVA, AllToolModules.STONE_AXE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.AXE_HEAD, AllFluids.MOLTEN_IRON, AllToolModules.IRON_AXE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.AXE_HEAD, AllFluids.MOLTEN_COPPER, AllToolModules.COPPER_AXE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.AXE_HEAD, AllFluids.MOLTEN_GOLD, AllToolModules.GOLDEN_AXE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.AXE_HEAD, AllFluids.MOLTEN_NETHERITE, AllToolModules.NETHERITE_AXE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.AXE_HEAD, AllFluids.MOLTEN_ZINC, AllToolModules.ZINC_AXE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.AXE_HEAD, AllFluids.MOLTEN_BRASS, AllToolModules.BRASS_AXE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.AXE_HEAD, AllFluids.MOLTEN_DIAMOND, AllToolModules.DIAMOND_AXE_HEAD);

        ToolModuleRecipeRegistry.register(AllToolModuleTypes.HOE_HEAD, Fluids.LAVA, AllToolModules.STONE_HOE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.HOE_HEAD, AllFluids.MOLTEN_IRON, AllToolModules.IRON_HOE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.HOE_HEAD, AllFluids.MOLTEN_COPPER, AllToolModules.COPPER_HOE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.HOE_HEAD, AllFluids.MOLTEN_GOLD, AllToolModules.GOLDEN_HOE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.HOE_HEAD, AllFluids.MOLTEN_NETHERITE, AllToolModules.NETHERITE_HOE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.HOE_HEAD, AllFluids.MOLTEN_ZINC, AllToolModules.ZINC_HOE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.HOE_HEAD, AllFluids.MOLTEN_BRASS, AllToolModules.BRASS_HOE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.HOE_HEAD, AllFluids.MOLTEN_DIAMOND, AllToolModules.DIAMOND_HOE_HEAD);

        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_HANDLE, Fluids.LAVA, AllToolModules.STONE_TOOL_HANDLE);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_IRON, AllToolModules.IRON_TOOL_HANDLE);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_COPPER, AllToolModules.COPPER_TOOL_HANDLE);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_GOLD, AllToolModules.GOLDEN_TOOL_HANDLE);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_NETHERITE, AllToolModules.NETHERITE_TOOL_HANDLE);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_ZINC, AllToolModules.ZINC_TOOL_HANDLE);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_BRASS, AllToolModules.BRASS_TOOL_HANDLE);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_DIAMOND, AllToolModules.DIAMOND_TOOL_HANDLE);

        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_GRIP, Fluids.LAVA, AllToolModules.STONE_TOOL_GRIP);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_GRIP, AllFluids.MOLTEN_IRON, AllToolModules.IRON_TOOL_GRIP);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_GRIP, AllFluids.MOLTEN_COPPER, AllToolModules.COPPER_TOOL_GRIP);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_GRIP, AllFluids.MOLTEN_GOLD, AllToolModules.GOLDEN_TOOL_GRIP);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_GRIP, AllFluids.MOLTEN_NETHERITE, AllToolModules.NETHERITE_TOOL_GRIP);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_GRIP, AllFluids.MOLTEN_ZINC, AllToolModules.ZINC_TOOL_GRIP);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_GRIP, AllFluids.MOLTEN_BRASS, AllToolModules.BRASS_TOOL_GRIP);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_GRIP, AllFluids.MOLTEN_DIAMOND, AllToolModules.DIAMOND_TOOL_GRIP);

        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_GUARD, Fluids.LAVA, AllToolModules.STONE_SWORD_GUARD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_GUARD, AllFluids.MOLTEN_IRON, AllToolModules.IRON_SWORD_GUARD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_GUARD, AllFluids.MOLTEN_COPPER, AllToolModules.COPPER_SWORD_GUARD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_GUARD, AllFluids.MOLTEN_GOLD, AllToolModules.GOLDEN_SWORD_GUARD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_GUARD, AllFluids.MOLTEN_NETHERITE, AllToolModules.NETHERITE_SWORD_GUARD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_GUARD, AllFluids.MOLTEN_ZINC, AllToolModules.ZINC_SWORD_GUARD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_GUARD, AllFluids.MOLTEN_BRASS, AllToolModules.BRASS_SWORD_GUARD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_GUARD, AllFluids.MOLTEN_DIAMOND, AllToolModules.DIAMOND_SWORD_GUARD);

        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_POMMEL, Fluids.LAVA, AllToolModules.STONE_SWORD_POMMEL);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_POMMEL, AllFluids.MOLTEN_IRON, AllToolModules.IRON_SWORD_POMMEL);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_POMMEL, AllFluids.MOLTEN_COPPER, AllToolModules.COPPER_SWORD_POMMEL);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_POMMEL, AllFluids.MOLTEN_GOLD, AllToolModules.GOLDEN_SWORD_POMMEL);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_POMMEL, AllFluids.MOLTEN_NETHERITE, AllToolModules.NETHERITE_SWORD_POMMEL);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_POMMEL, AllFluids.MOLTEN_ZINC, AllToolModules.ZINC_SWORD_POMMEL);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_POMMEL, AllFluids.MOLTEN_BRASS, AllToolModules.BRASS_SWORD_POMMEL);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_POMMEL, AllFluids.MOLTEN_DIAMOND, AllToolModules.DIAMOND_SWORD_POMMEL);

        registerMoldTopTextureGetter(AllToolModuleTypes.SWORD_BLADE, AllMoldTopTextures.SWORD_BLADE);

        registerMoldTopTextureGetter(AllToolModuleTypes.SHOVEL_HEAD, AllMoldTopTextures.SHOVEL_HEAD);

        registerMoldTopTextureGetter(AllToolModuleTypes.PICKAXE_HEAD, AllMoldTopTextures.PICKAXE_HEAD);

        registerMoldTopTextureGetter(AllToolModuleTypes.AXE_HEAD, AllMoldTopTextures.AXE_HEAD);

        registerMoldTopTextureGetter(AllToolModuleTypes.HOE_HEAD, AllMoldTopTextures.HOE_HEAD);

        registerMoldTopTextureGetterForMoldWithoutModule(AllToolModuleTypes.TOOL_HANDLE, AllMoldBlocks.SWORD_SAND_MOLD, AllToolModuleTypes.SWORD_POMMEL, AllMoldTopTextures.SWORD_HANDLE);
        registerMoldTopTextureGetterForMoldWithModule(AllToolModuleTypes.TOOL_HANDLE, AllMoldBlocks.SWORD_SAND_MOLD, AllToolModuleTypes.SWORD_POMMEL, AllMoldTopTextures.POMMEL_SWORD_HANDLE);

        registerMoldTopTextureGetterForMoldWithoutModule(AllToolModuleTypes.TOOL_HANDLE, AllMoldBlocks.SHOVEL_SAND_MOLD, AllToolModuleTypes.TOOL_GRIP, AllMoldTopTextures.SHOVEL_HANDLE);
        registerMoldTopTextureGetterForMoldWithModule(AllToolModuleTypes.TOOL_HANDLE, AllMoldBlocks.SHOVEL_SAND_MOLD, AllToolModuleTypes.TOOL_GRIP, AllMoldTopTextures.GRIP_SHOVEL_HANDLE);

        registerMoldTopTextureGetterForMoldWithoutModule(AllToolModuleTypes.TOOL_HANDLE, AllMoldBlocks.PICKAXE_SAND_MOLD, AllToolModuleTypes.TOOL_GRIP, AllMoldTopTextures.PICKAXE_HANDLE);
        registerMoldTopTextureGetterForMoldWithModule(AllToolModuleTypes.TOOL_HANDLE, AllMoldBlocks.PICKAXE_SAND_MOLD, AllToolModuleTypes.TOOL_GRIP, AllMoldTopTextures.GRIP_PICKAXE_HANDLE);

        registerMoldTopTextureGetterForMoldWithoutModule(AllToolModuleTypes.TOOL_HANDLE, AllMoldBlocks.AXE_SAND_MOLD, AllToolModuleTypes.TOOL_GRIP, AllMoldTopTextures.AXE_HANDLE);
        registerMoldTopTextureGetterForMoldWithModule(AllToolModuleTypes.TOOL_HANDLE, AllMoldBlocks.AXE_SAND_MOLD, AllToolModuleTypes.TOOL_GRIP, AllMoldTopTextures.GRIP_AXE_HANDLE);

        registerMoldTopTextureGetterForMoldWithoutModule(AllToolModuleTypes.TOOL_HANDLE, AllMoldBlocks.HOE_SAND_MOLD, AllToolModuleTypes.TOOL_GRIP, AllMoldTopTextures.HOE_HANDLE);
        registerMoldTopTextureGetterForMoldWithModule(AllToolModuleTypes.TOOL_HANDLE, AllMoldBlocks.HOE_SAND_MOLD, AllToolModuleTypes.TOOL_GRIP, AllMoldTopTextures.GRIP_HOE_HANDLE);

        registerMoldTopTextureGetter(AllToolModuleTypes.TOOL_GRIP, AllMoldTopTextures.GRIP);

        registerMoldTopTextureGetter(AllToolModuleTypes.SWORD_GUARD, AllMoldTopTextures.GUARD);

        registerMoldTopTextureGetter(AllToolModuleTypes.SWORD_POMMEL, AllMoldTopTextures.POMMEL);
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(ID, path);
    }

    private static void registerMoldTopTextureGetter(ToolModuleType toolModuleType, ToolModuleType.MoldTopTexture moldTopTexture) {
        toolModuleType.registerMoldTopTextureGetter((original, sandMoldBlock, nbt) -> original == null ? moldTopTexture : original);
    }

    private static void registerMoldTopTextureGetterForMold(ToolModuleType toolModuleType, SandMoldBlock moldBlock, ToolModuleType.MoldTopTexture moldTopTexture) {
        toolModuleType.registerMoldTopTextureGetter((original, sandMoldBlock, nbt) -> original == null && sandMoldBlock == moldBlock ? moldTopTexture : original);
    }

    private static void registerMoldTopTextureGetterForMoldWithModule(ToolModuleType toolModuleType, SandMoldBlock moldBlock, ToolModuleType otherToolModuleType, ToolModuleType.MoldTopTexture moldTopTexture) {
        toolModuleType.registerMoldTopTextureGetter((original, sandMoldBlock, nbt) -> original == null && sandMoldBlock == moldBlock && nbt.contains(otherToolModuleType.getTag(), Tag.TAG_STRING) ? moldTopTexture : original);
    }

    private static void registerMoldTopTextureGetterForMoldWithoutModule(ToolModuleType toolModuleType, SandMoldBlock moldBlock, ToolModuleType otherToolModuleType, ToolModuleType.MoldTopTexture moldTopTexture) {
        toolModuleType.registerMoldTopTextureGetter((original, sandMoldBlock, nbt) -> original == null && sandMoldBlock == moldBlock && !nbt.contains(otherToolModuleType.getTag(), Tag.TAG_STRING) ? moldTopTexture : original);
    }
}
