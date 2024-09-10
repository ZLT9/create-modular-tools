package net.zlt.create_modular_tools.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.zlt.create_modular_tools.CreateModularTools;

public final class AllEntityTypes {
    private AllEntityTypes() {
    }

    public static final EntityType<ThrownWoodPickaxeHead> WOOD_PICKAXE_HEAD = register("wood_pickaxe_head",
        FabricEntityTypeBuilder.<ThrownWoodPickaxeHead>create(MobCategory.MISC, ThrownWoodPickaxeHead::new)
            .dimensions(EntityDimensions.scalable(0.5f, 0.5f))
            .trackRangeChunks(4)
            .trackedUpdateRate(20)
            .forceTrackedVelocityUpdates(true));

    public static final EntityType<ThrownStonePickaxeHead> STONE_PICKAXE_HEAD = register("stone_pickaxe_head",
        FabricEntityTypeBuilder.<ThrownStonePickaxeHead>create(MobCategory.MISC, ThrownStonePickaxeHead::new)
            .dimensions(EntityDimensions.scalable(0.5f, 0.5f))
            .trackRangeChunks(4)
            .trackedUpdateRate(20)
            .forceTrackedVelocityUpdates(true));

    public static final EntityType<ThrownIronPickaxeHead> IRON_PICKAXE_HEAD = register("iron_pickaxe_head",
        FabricEntityTypeBuilder.<ThrownIronPickaxeHead>create(MobCategory.MISC, ThrownIronPickaxeHead::new)
            .dimensions(EntityDimensions.scalable(0.5f, 0.5f))
            .trackRangeChunks(4)
            .trackedUpdateRate(20)
            .forceTrackedVelocityUpdates(true));

    public static final EntityType<ThrownCopperPickaxeHead> COPPER_PICKAXE_HEAD = register("copper_pickaxe_head",
        FabricEntityTypeBuilder.<ThrownCopperPickaxeHead>create(MobCategory.MISC, ThrownCopperPickaxeHead::new)
            .dimensions(EntityDimensions.scalable(0.5f, 0.5f))
            .trackRangeChunks(4)
            .trackedUpdateRate(20)
            .forceTrackedVelocityUpdates(true));

    public static final EntityType<ThrownGoldPickaxeHead> GOLD_PICKAXE_HEAD = register("gold_pickaxe_head",
        FabricEntityTypeBuilder.<ThrownGoldPickaxeHead>create(MobCategory.MISC, ThrownGoldPickaxeHead::new)
            .dimensions(EntityDimensions.scalable(0.5f, 0.5f))
            .trackRangeChunks(4)
            .trackedUpdateRate(20)
            .forceTrackedVelocityUpdates(true));

    public static final EntityType<ThrownNetheritePickaxeHead> NETHERITE_PICKAXE_HEAD = register("netherite_pickaxe_head",
        FabricEntityTypeBuilder.<ThrownNetheritePickaxeHead>create(MobCategory.MISC, ThrownNetheritePickaxeHead::new)
            .dimensions(EntityDimensions.scalable(0.5f, 0.5f))
            .trackRangeChunks(4)
            .trackedUpdateRate(20)
            .forceTrackedVelocityUpdates(true));

    public static final EntityType<ThrownZincPickaxeHead> ZINC_PICKAXE_HEAD = register("zinc_pickaxe_head",
        FabricEntityTypeBuilder.<ThrownZincPickaxeHead>create(MobCategory.MISC, ThrownZincPickaxeHead::new)
            .dimensions(EntityDimensions.scalable(0.5f, 0.5f))
            .trackRangeChunks(4)
            .trackedUpdateRate(20)
            .forceTrackedVelocityUpdates(true));

    public static final EntityType<ThrownBrassPickaxeHead> BRASS_PICKAXE_HEAD = register("brass_pickaxe_head",
        FabricEntityTypeBuilder.<ThrownBrassPickaxeHead>create(MobCategory.MISC, ThrownBrassPickaxeHead::new)
            .dimensions(EntityDimensions.scalable(0.5f, 0.5f))
            .trackRangeChunks(4)
            .trackedUpdateRate(20)
            .forceTrackedVelocityUpdates(true));

    public static final EntityType<ThrownDiamondPickaxeHead> DIAMOND_PICKAXE_HEAD = register("diamond_pickaxe_head",
        FabricEntityTypeBuilder.<ThrownDiamondPickaxeHead>create(MobCategory.MISC, ThrownDiamondPickaxeHead::new)
            .dimensions(EntityDimensions.scalable(0.5f, 0.5f))
            .trackRangeChunks(4)
            .trackedUpdateRate(20)
            .forceTrackedVelocityUpdates(true));

    private static <T extends Entity> EntityType<T> register(String path, FabricEntityTypeBuilder<T> entityTypeBuilder) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, CreateModularTools.asResource(path), entityTypeBuilder.build());
    }

    public static void init() {
    }
}
