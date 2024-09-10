package net.zlt.create_modular_tools.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.block.AllBlocks;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class AllBlockEntityTypes {
    private AllBlockEntityTypes() {
    }

    public static final BlockEntityType<?> CREATIVE_MODULAR_TOOL_TABLE = register("creative_modular_tool_table", FabricBlockEntityTypeBuilder.create(CreativeModularToolTableBlockEntity::new, AllBlocks.CREATIVE_MODULAR_TOOL_TABLE).build());

    private static <T extends BlockEntity> BlockEntityType<T> register(String path, BlockEntityType<T> blockEntityType) {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, CreateModularTools.asResource(path), blockEntityType);
    }

    public static void init() {
    }
}
