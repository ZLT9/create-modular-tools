package net.zlt.create_modular_tools.block.mold;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.zlt.create_modular_tools.CreateModularTools;

public final class AllMoldBlocks {
    private AllMoldBlocks() {
    }

    public static final SandMoldBlock SAND_MOLD = register("sand_mold", new SandMoldBlock(BlockBehaviour.Properties.of()));

    public static final SandMoldBlock SWORD_SAND_MOLD = register("sword_sand_mold", new SwordSandMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(PickaxeSandMoldBlock.LIGHT_LEVEL))));
    public static final SandMoldBlock SHOVEL_SAND_MOLD = register("shovel_sand_mold", new ShovelSandMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(PickaxeSandMoldBlock.LIGHT_LEVEL))));
    public static final SandMoldBlock PICKAXE_SAND_MOLD = register("pickaxe_sand_mold", new PickaxeSandMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(PickaxeSandMoldBlock.LIGHT_LEVEL))));
    public static final SandMoldBlock AXE_SAND_MOLD = register("axe_sand_mold", new AxeSandMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(PickaxeSandMoldBlock.LIGHT_LEVEL))));
    public static final SandMoldBlock HOE_SAND_MOLD = register("hoe_sand_mold", new HoeSandMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(PickaxeSandMoldBlock.LIGHT_LEVEL))));

    private static SandMoldBlock register(String path, SandMoldBlock block) {
        return Registry.register(BuiltInRegistries.BLOCK, CreateModularTools.asResource(path), block);
    }

    public static void init() {
    }
}
