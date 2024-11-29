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

    public static final EntityType<ThrownWoodenPickaxeHead> WOODEN_PICKAXE_HEAD = register("wooden_pickaxe_head",
        FabricEntityTypeBuilder.<ThrownWoodenPickaxeHead>create(MobCategory.MISC, ThrownWoodenPickaxeHead::new)
            .dimensions(EntityDimensions.scalable(0.5f, 0.5f))
            .trackRangeChunks(4)
            .trackedUpdateRate(20)
            .forceTrackedVelocityUpdates(true));

    public static final EntityType<ThrownOakPickaxeHead> OAK_PICKAXE_HEAD = register("oak_pickaxe_head",
        FabricEntityTypeBuilder.<ThrownOakPickaxeHead>create(MobCategory.MISC, ThrownOakPickaxeHead::new)
            .dimensions(EntityDimensions.scalable(0.5f, 0.5f))
            .trackRangeChunks(4)
            .trackedUpdateRate(20)
            .forceTrackedVelocityUpdates(true));

    public static final EntityType<ThrownSprucePickaxeHead> SPRUCE_PICKAXE_HEAD = register("spruce_pickaxe_head",
        FabricEntityTypeBuilder.<ThrownSprucePickaxeHead>create(MobCategory.MISC, ThrownSprucePickaxeHead::new)
            .dimensions(EntityDimensions.scalable(0.5f, 0.5f))
            .trackRangeChunks(4)
            .trackedUpdateRate(20)
            .forceTrackedVelocityUpdates(true));

    public static final EntityType<ThrownBirchPickaxeHead> BIRCH_PICKAXE_HEAD = register("birch_pickaxe_head",
        FabricEntityTypeBuilder.<ThrownBirchPickaxeHead>create(MobCategory.MISC, ThrownBirchPickaxeHead::new)
            .dimensions(EntityDimensions.scalable(0.5f, 0.5f))
            .trackRangeChunks(4)
            .trackedUpdateRate(20)
            .forceTrackedVelocityUpdates(true));

    public static final EntityType<ThrownJunglePickaxeHead> JUNGLE_PICKAXE_HEAD = register("jungle_pickaxe_head",
        FabricEntityTypeBuilder.<ThrownJunglePickaxeHead>create(MobCategory.MISC, ThrownJunglePickaxeHead::new)
            .dimensions(EntityDimensions.scalable(0.5f, 0.5f))
            .trackRangeChunks(4)
            .trackedUpdateRate(20)
            .forceTrackedVelocityUpdates(true));

    public static final EntityType<ThrownAcaciaPickaxeHead> ACACIA_PICKAXE_HEAD = register("acacia_pickaxe_head",
        FabricEntityTypeBuilder.<ThrownAcaciaPickaxeHead>create(MobCategory.MISC, ThrownAcaciaPickaxeHead::new)
            .dimensions(EntityDimensions.scalable(0.5f, 0.5f))
            .trackRangeChunks(4)
            .trackedUpdateRate(20)
            .forceTrackedVelocityUpdates(true));

    public static final EntityType<ThrownDarkOakPickaxeHead> DARK_OAK_PICKAXE_HEAD = register("dark_oak_pickaxe_head",
        FabricEntityTypeBuilder.<ThrownDarkOakPickaxeHead>create(MobCategory.MISC, ThrownDarkOakPickaxeHead::new)
            .dimensions(EntityDimensions.scalable(0.5f, 0.5f))
            .trackRangeChunks(4)
            .trackedUpdateRate(20)
            .forceTrackedVelocityUpdates(true));

    public static final EntityType<ThrownMangrovePickaxeHead> MANGROVE_PICKAXE_HEAD = register("mangrove_pickaxe_head",
        FabricEntityTypeBuilder.<ThrownMangrovePickaxeHead>create(MobCategory.MISC, ThrownMangrovePickaxeHead::new)
            .dimensions(EntityDimensions.scalable(0.5f, 0.5f))
            .trackRangeChunks(4)
            .trackedUpdateRate(20)
            .forceTrackedVelocityUpdates(true));

    public static final EntityType<ThrownCherryPickaxeHead> CHERRY_PICKAXE_HEAD = register("cherry_pickaxe_head",
        FabricEntityTypeBuilder.<ThrownCherryPickaxeHead>create(MobCategory.MISC, ThrownCherryPickaxeHead::new)
            .dimensions(EntityDimensions.scalable(0.5f, 0.5f))
            .trackRangeChunks(4)
            .trackedUpdateRate(20)
            .forceTrackedVelocityUpdates(true));

    public static final EntityType<ThrownBambooPickaxeHead> BAMBOO_PICKAXE_HEAD = register("bamboo_pickaxe_head",
        FabricEntityTypeBuilder.<ThrownBambooPickaxeHead>create(MobCategory.MISC, ThrownBambooPickaxeHead::new)
            .dimensions(EntityDimensions.scalable(0.5f, 0.5f))
            .trackRangeChunks(4)
            .trackedUpdateRate(20)
            .forceTrackedVelocityUpdates(true));

    public static final EntityType<ThrownCrimsonPickaxeHead> CRIMSON_PICKAXE_HEAD = register("crimson_pickaxe_head",
        FabricEntityTypeBuilder.<ThrownCrimsonPickaxeHead>create(MobCategory.MISC, ThrownCrimsonPickaxeHead::new)
            .dimensions(EntityDimensions.scalable(0.5f, 0.5f))
            .trackRangeChunks(4)
            .trackedUpdateRate(20)
            .forceTrackedVelocityUpdates(true));

    public static final EntityType<ThrownWarpedPickaxeHead> WARPED_PICKAXE_HEAD = register("warped_pickaxe_head",
        FabricEntityTypeBuilder.<ThrownWarpedPickaxeHead>create(MobCategory.MISC, ThrownWarpedPickaxeHead::new)
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

    public static final EntityType<ThrownGoldenPickaxeHead> GOLDEN_PICKAXE_HEAD = register("golden_pickaxe_head",
        FabricEntityTypeBuilder.<ThrownGoldenPickaxeHead>create(MobCategory.MISC, ThrownGoldenPickaxeHead::new)
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
