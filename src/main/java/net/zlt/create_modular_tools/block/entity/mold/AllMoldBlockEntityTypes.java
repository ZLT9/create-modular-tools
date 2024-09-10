package net.zlt.create_modular_tools.block.entity.mold;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.CreateModularTools;

public final class AllMoldBlockEntityTypes {
    private AllMoldBlockEntityTypes() {
    }

    public static final BlockEntityType<SwordSandMoldBlockEntity> SWORD_SAND_MOLD = register("sword_sand_mold", FabricBlockEntityTypeBuilder.create(SwordSandMoldBlockEntity::new, AllMoldBlocks.SWORD_SAND_MOLD).build());
    public static final BlockEntityType<ShovelSandMoldBlockEntity> SHOVEL_SAND_MOLD = register("shovel_sand_mold", FabricBlockEntityTypeBuilder.create(ShovelSandMoldBlockEntity::new, AllMoldBlocks.SHOVEL_SAND_MOLD).build());
    public static final BlockEntityType<PickaxeSandMoldBlockEntity> PICKAXE_SAND_MOLD = register("pickaxe_sand_mold", FabricBlockEntityTypeBuilder.create(PickaxeSandMoldBlockEntity::new, AllMoldBlocks.PICKAXE_SAND_MOLD).build());
    public static final BlockEntityType<AxeSandMoldBlockEntity> AXE_SAND_MOLD = register("axe_sand_mold", FabricBlockEntityTypeBuilder.create(AxeSandMoldBlockEntity::new, AllMoldBlocks.AXE_SAND_MOLD).build());
    public static final BlockEntityType<HoeSandMoldBlockEntity> HOE_SAND_MOLD = register("hoe_sand_mold", FabricBlockEntityTypeBuilder.create(HoeSandMoldBlockEntity::new, AllMoldBlocks.HOE_SAND_MOLD).build());

    private static <T extends BlockEntity> BlockEntityType<T> register(String path, BlockEntityType<T> blockEntityType) {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, CreateModularTools.asResource(path), blockEntityType);
    }

    public static void init() {
    }
}
