package net.zlt.create_modular_tools.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.zlt.create_modular_tools.fluid.AllFluids;
import net.zlt.create_modular_tools.CreateModularTools;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class AllBlocks {
    private AllBlocks() {
    }

    public static final Block MOLTEN_IRON = register("molten_iron", new LiquidBlock(AllFluids.MOLTEN_IRON, FabricBlockSettings.copy(Blocks.LAVA)));
    public static final Block MOLTEN_COPPER = register("molten_copper", new LiquidBlock(AllFluids.MOLTEN_COPPER, FabricBlockSettings.copy(Blocks.LAVA)));
    public static final Block MOLTEN_GOLD = register("molten_gold", new LiquidBlock(AllFluids.MOLTEN_GOLD, FabricBlockSettings.copy(Blocks.LAVA)));
    public static final Block MOLTEN_NETHERITE = register("molten_netherite", new LiquidBlock(AllFluids.MOLTEN_NETHERITE, FabricBlockSettings.copy(Blocks.LAVA)));
    public static final Block MOLTEN_ZINC = register("molten_zinc", new LiquidBlock(AllFluids.MOLTEN_ZINC, FabricBlockSettings.copy(Blocks.LAVA)));
    public static final Block MOLTEN_BRASS = register("molten_brass", new LiquidBlock(AllFluids.MOLTEN_BRASS, FabricBlockSettings.copy(Blocks.LAVA)));
    public static final Block MOLTEN_DIAMOND = register("molten_diamond", new LiquidBlock(AllFluids.MOLTEN_DIAMOND, FabricBlockSettings.copy(Blocks.LAVA)));

    public static final Block CREATIVE_MODULAR_TOOL_TABLE = register("creative_modular_tool_table", new CreativeModularToolTableBlock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).mapColor(MapColor.COLOR_PURPLE)));

    private static Block register(String path, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, CreateModularTools.asResource(path), block);
    }

    public static void init() {
    }
}
