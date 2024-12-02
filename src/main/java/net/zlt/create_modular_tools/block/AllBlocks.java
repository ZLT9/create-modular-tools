package net.zlt.create_modular_tools.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.fluid.AllFluids;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class AllBlocks {
    private AllBlocks() {
    }

    public static final Block OAK_MOLD = register("oak_mold", new EmptyMoldBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block SPRUCE_MOLD = register("spruce_mold", new EmptyMoldBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_PLANKS)));
    public static final Block BIRCH_MOLD = register("birch_mold", new EmptyMoldBlock(FabricBlockSettings.copyOf(Blocks.BIRCH_PLANKS)));
    public static final Block JUNGLE_MOLD = register("jungle_mold", new EmptyMoldBlock(FabricBlockSettings.copyOf(Blocks.JUNGLE_PLANKS)));
    public static final Block ACACIA_MOLD = register("acacia_mold", new EmptyMoldBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_PLANKS)));
    public static final Block DARK_OAK_MOLD = register("dark_oak_mold", new EmptyMoldBlock(FabricBlockSettings.copyOf(Blocks.DARK_OAK_PLANKS)));
    public static final Block MANGROVE_MOLD = register("mangrove_mold", new EmptyMoldBlock(FabricBlockSettings.copyOf(Blocks.MANGROVE_PLANKS)));
    public static final Block CHERRY_MOLD = register("cherry_mold", new EmptyMoldBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_PLANKS)));
    public static final Block BAMBOO_MOLD = register("bamboo_mold", new EmptyMoldBlock(FabricBlockSettings.copyOf(Blocks.BAMBOO_PLANKS)));
    public static final Block CRIMSON_MOLD = register("crimson_mold", new EmptyMoldBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_PLANKS)));
    public static final Block WARPED_MOLD = register("warped_mold", new EmptyMoldBlock(FabricBlockSettings.copyOf(Blocks.WARPED_PLANKS)));

    public static final Block MOLTEN_IRON = register("molten_iron", new LiquidBlock(AllFluids.MOLTEN_IRON, FabricBlockSettings.copy(Blocks.LAVA)));
    public static final Block MOLTEN_COPPER = register("molten_copper", new LiquidBlock(AllFluids.MOLTEN_COPPER, FabricBlockSettings.copy(Blocks.LAVA)));
    public static final Block MOLTEN_GOLD = register("molten_gold", new LiquidBlock(AllFluids.MOLTEN_GOLD, FabricBlockSettings.copy(Blocks.LAVA)));
    public static final Block MOLTEN_NETHERITE = register("molten_netherite", new LiquidBlock(AllFluids.MOLTEN_NETHERITE, FabricBlockSettings.copy(Blocks.LAVA)));
    public static final Block MOLTEN_ZINC = register("molten_zinc", new LiquidBlock(AllFluids.MOLTEN_ZINC, FabricBlockSettings.copy(Blocks.LAVA)));
    public static final Block MOLTEN_BRASS = register("molten_brass", new LiquidBlock(AllFluids.MOLTEN_BRASS, FabricBlockSettings.copy(Blocks.LAVA)));
    public static final Block MOLTEN_DIAMOND = register("molten_diamond", new LiquidBlock(AllFluids.MOLTEN_DIAMOND, FabricBlockSettings.copy(Blocks.LAVA)));

    private static Block register(String path, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, CreateModularTools.asResource(path), block);
    }

    public static void init() {
    }
}
