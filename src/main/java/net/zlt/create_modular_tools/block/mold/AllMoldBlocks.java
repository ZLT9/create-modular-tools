package net.zlt.create_modular_tools.block.mold;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.zlt.create_modular_tools.CreateModularTools;

public final class AllMoldBlocks {
    private AllMoldBlocks() {
    }

    public static final MoldBlock SAND_MOLD = register("sand_mold", new SandMoldBlock(BlockBehaviour.Properties.of()));
    public static final MoldBlock RED_SAND_MOLD = register("red_sand_mold", new RedSandMoldBlock(BlockBehaviour.Properties.of()));

    public static final BaseMoldBlock SWORD_SAND_MOLD = register("sword_sand_mold", new SwordSandMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MoldBlock.LIGHT_LEVEL))));
    public static final BaseMoldBlock SHOVEL_SAND_MOLD = register("shovel_sand_mold", new ShovelSandMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MoldBlock.LIGHT_LEVEL))));
    public static final BaseMoldBlock PICKAXE_SAND_MOLD = register("pickaxe_sand_mold", new PickaxeSandMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MoldBlock.LIGHT_LEVEL))));
    public static final BaseMoldBlock AXE_SAND_MOLD = register("axe_sand_mold", new AxeSandMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MoldBlock.LIGHT_LEVEL))));
    public static final BaseMoldBlock HOE_SAND_MOLD = register("hoe_sand_mold", new HoeSandMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MoldBlock.LIGHT_LEVEL))));

    public static final BaseMoldBlock SWORD_RED_SAND_MOLD = register("sword_red_sand_mold", new SwordRedSandMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MoldBlock.LIGHT_LEVEL))));
    public static final BaseMoldBlock SHOVEL_RED_SAND_MOLD = register("shovel_red_sand_mold", new ShovelRedSandMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MoldBlock.LIGHT_LEVEL))));
    public static final BaseMoldBlock PICKAXE_RED_SAND_MOLD = register("pickaxe_red_sand_mold", new PickaxeRedSandMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MoldBlock.LIGHT_LEVEL))));
    public static final BaseMoldBlock AXE_RED_SAND_MOLD = register("axe_red_sand_mold", new AxeRedSandMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MoldBlock.LIGHT_LEVEL))));
    public static final BaseMoldBlock HOE_RED_SAND_MOLD = register("hoe_red_sand_mold", new HoeRedSandMoldBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(MoldBlock.LIGHT_LEVEL))));

    private static MoldBlock register(String path, MoldBlock block) {
        return Registry.register(BuiltInRegistries.BLOCK, CreateModularTools.asResource(path), block);
    }

    private static BaseMoldBlock register(String path, BaseMoldBlock block) {
        return (BaseMoldBlock) register(path, (MoldBlock) block);
    }

    public static void init() {
    }
}
