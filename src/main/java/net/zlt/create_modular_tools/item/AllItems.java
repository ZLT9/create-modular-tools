package net.zlt.create_modular_tools.item;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.block.AllBlocks;
import net.zlt.create_modular_tools.entity.*;
import net.zlt.create_modular_tools.fluid.AllFluids;
import net.zlt.create_modular_tools.item.tool.*;
import net.zlt.create_modular_tools.item.tool.module.BoomerangItem;
import net.zlt.create_modular_tools.item.tool.module.ToolModuleItem;
import net.zlt.create_modular_tools.tool.module.AllToolModules;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class AllItems {
    private AllItems() {
    }

    public static final Item MOLTEN_IRON_BUCKET = register("molten_iron_bucket", new BucketItem(AllFluids.MOLTEN_IRON, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final Item MOLTEN_COPPER_BUCKET = register("molten_copper_bucket", new BucketItem(AllFluids.MOLTEN_COPPER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final Item MOLTEN_GOLD_BUCKET = register("molten_gold_bucket", new BucketItem(AllFluids.MOLTEN_GOLD, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final Item MOLTEN_NETHERITE_BUCKET = register("molten_netherite_bucket", new BucketItem(AllFluids.MOLTEN_NETHERITE, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final Item MOLTEN_ZINC_BUCKET = register("molten_zinc_bucket", new BucketItem(AllFluids.MOLTEN_ZINC, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final Item MOLTEN_BRASS_BUCKET = register("molten_brass_bucket", new BucketItem(AllFluids.MOLTEN_BRASS, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final Item MOLTEN_DIAMOND_BUCKET = register("molten_diamond_bucket", new BucketItem(AllFluids.MOLTEN_DIAMOND, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final Item CREATIVE_MODULAR_TOOL_TABLE = register("creative_modular_tool_table", new BlockItem(AllBlocks.CREATIVE_MODULAR_TOOL_TABLE, new Item.Properties().rarity(Rarity.EPIC)));

    public static final Item MODULAR_SWORD = register("modular_sword", new ModularSwordItem(new Item.Properties()));
    public static final Item MODULAR_SHOVEL = register("modular_shovel", new ModularShovelItem(new Item.Properties()));
    public static final Item MODULAR_PICKAXE = register("modular_pickaxe", new ModularPickaxeItem(new Item.Properties()));
    public static final Item MODULAR_AXE = register("modular_axe", new ModularAxeItem(new Item.Properties()));
    public static final Item MODULAR_HOE = register("modular_hoe", new ModularHoeItem(new Item.Properties()));

    public static final Item WOODEN_SWORD_BLADE = register("wooden_sword_blade", new ToolModuleItem(AllToolModules.WOODEN_SWORD_BLADE, new Item.Properties()));
    public static final Item STONE_SWORD_BLADE = register("stone_sword_blade", new ToolModuleItem(AllToolModules.STONE_SWORD_BLADE, new Item.Properties()));
    public static final Item IRON_SWORD_BLADE = register("iron_sword_blade", new ToolModuleItem(AllToolModules.IRON_SWORD_BLADE, new Item.Properties()));
    public static final Item COPPER_SWORD_BLADE = register("copper_sword_blade", new ToolModuleItem(AllToolModules.COPPER_SWORD_BLADE, new Item.Properties()));
    public static final Item GOLDEN_SWORD_BLADE = register("golden_sword_blade", new ToolModuleItem(AllToolModules.GOLDEN_SWORD_BLADE, new Item.Properties()));
    public static final Item NETHERITE_SWORD_BLADE = register("netherite_sword_blade", new ToolModuleItem(AllToolModules.NETHERITE_SWORD_BLADE, new Item.Properties().fireResistant()));
    public static final Item ZINC_SWORD_BLADE = register("zinc_sword_blade", new ToolModuleItem(AllToolModules.ZINC_SWORD_BLADE, new Item.Properties()));
    public static final Item BRASS_SWORD_BLADE = register("brass_sword_blade", new ToolModuleItem(AllToolModules.BRASS_SWORD_BLADE, new Item.Properties()));
    public static final Item DIAMOND_SWORD_BLADE = register("diamond_sword_blade", new ToolModuleItem(AllToolModules.DIAMOND_SWORD_BLADE, new Item.Properties()));

    public static final Item WOODEN_SHOVEL_HEAD = register("wooden_shovel_head", new ToolModuleItem(AllToolModules.WOODEN_SHOVEL_HEAD, new Item.Properties()));
    public static final Item STONE_SHOVEL_HEAD = register("stone_shovel_head", new ToolModuleItem(AllToolModules.STONE_SHOVEL_HEAD, new Item.Properties()));
    public static final Item IRON_SHOVEL_HEAD = register("iron_shovel_head", new ToolModuleItem(AllToolModules.IRON_SHOVEL_HEAD, new Item.Properties()));
    public static final Item COPPER_SHOVEL_HEAD = register("copper_shovel_head", new ToolModuleItem(AllToolModules.COPPER_SHOVEL_HEAD, new Item.Properties()));
    public static final Item GOLDEN_SHOVEL_HEAD = register("golden_shovel_head", new ToolModuleItem(AllToolModules.GOLDEN_SHOVEL_HEAD, new Item.Properties()));
    public static final Item NETHERITE_SHOVEL_HEAD = register("netherite_shovel_head", new ToolModuleItem(AllToolModules.NETHERITE_SHOVEL_HEAD, new Item.Properties().fireResistant()));
    public static final Item ZINC_SHOVEL_HEAD = register("zinc_shovel_head", new ToolModuleItem(AllToolModules.ZINC_SHOVEL_HEAD, new Item.Properties()));
    public static final Item BRASS_SHOVEL_HEAD = register("brass_shovel_head", new ToolModuleItem(AllToolModules.BRASS_SHOVEL_HEAD, new Item.Properties()));
    public static final Item DIAMOND_SHOVEL_HEAD = register("diamond_shovel_head", new ToolModuleItem(AllToolModules.DIAMOND_SHOVEL_HEAD, new Item.Properties()));

    public static final Item WOODEN_PICKAXE_HEAD = register("wooden_pickaxe_head", new BoomerangItem(AllToolModules.WOODEN_PICKAXE_HEAD, new Item.Properties()) {
        @Override
        protected ThrownBoomerang createThrownBoomerang(Level level, LivingEntity shooter, ItemStack stack) {
            return new ThrownWoodenPickaxeHead(level, shooter, stack);
        }
    });
    public static final Item STONE_PICKAXE_HEAD = register("stone_pickaxe_head", new BoomerangItem(AllToolModules.STONE_PICKAXE_HEAD, new Item.Properties()) {
        @Override
        protected ThrownBoomerang createThrownBoomerang(Level level, LivingEntity shooter, ItemStack stack) {
            return new ThrownStonePickaxeHead(level, shooter, stack);
        }
    });
    public static final Item IRON_PICKAXE_HEAD = register("iron_pickaxe_head", new BoomerangItem(AllToolModules.IRON_PICKAXE_HEAD, new Item.Properties()) {
        @Override
        protected ThrownBoomerang createThrownBoomerang(Level level, LivingEntity shooter, ItemStack stack) {
            return new ThrownIronPickaxeHead(level, shooter, stack);
        }
    });
    public static final Item COPPER_PICKAXE_HEAD = register("copper_pickaxe_head", new BoomerangItem(AllToolModules.COPPER_PICKAXE_HEAD, new Item.Properties()) {
        @Override
        protected ThrownBoomerang createThrownBoomerang(Level level, LivingEntity shooter, ItemStack stack) {
            return new ThrownCopperPickaxeHead(level, shooter, stack);
        }
    });
    public static final Item GOLDEN_PICKAXE_HEAD = register("golden_pickaxe_head", new BoomerangItem(AllToolModules.GOLDEN_PICKAXE_HEAD, new Item.Properties()) {
        @Override
        protected ThrownBoomerang createThrownBoomerang(Level level, LivingEntity shooter, ItemStack stack) {
            return new ThrownGoldPickaxeHead(level, shooter, stack);
        }
    });
    public static final Item NETHERITE_PICKAXE_HEAD = register("netherite_pickaxe_head", new BoomerangItem(AllToolModules.NETHERITE_PICKAXE_HEAD, new Item.Properties().fireResistant()) {
        @Override
        protected ThrownBoomerang createThrownBoomerang(Level level, LivingEntity shooter, ItemStack stack) {
            return new ThrownNetheritePickaxeHead(level, shooter, stack);
        }
    });
    public static final Item ZINC_PICKAXE_HEAD = register("zinc_pickaxe_head", new BoomerangItem(AllToolModules.ZINC_PICKAXE_HEAD, new Item.Properties()) {
        @Override
        protected ThrownBoomerang createThrownBoomerang(Level level, LivingEntity shooter, ItemStack stack) {
            return new ThrownZincPickaxeHead(level, shooter, stack);
        }
    });
    public static final Item BRASS_PICKAXE_HEAD = register("brass_pickaxe_head", new BoomerangItem(AllToolModules.BRASS_PICKAXE_HEAD, new Item.Properties()) {
        @Override
        protected ThrownBoomerang createThrownBoomerang(Level level, LivingEntity shooter, ItemStack stack) {
            return new ThrownBrassPickaxeHead(level, shooter, stack);
        }
    });
    public static final Item DIAMOND_PICKAXE_HEAD = register("diamond_pickaxe_head", new BoomerangItem(AllToolModules.DIAMOND_PICKAXE_HEAD, new Item.Properties()) {
        @Override
        protected ThrownBoomerang createThrownBoomerang(Level level, LivingEntity shooter, ItemStack stack) {
            return new ThrownDiamondPickaxeHead(level, shooter, stack);
        }
    });

    public static final Item WOODEN_AXE_HEAD = register("wooden_axe_head", new ToolModuleItem(AllToolModules.WOODEN_AXE_HEAD, new Item.Properties()));
    public static final Item STONE_AXE_HEAD = register("stone_axe_head", new ToolModuleItem(AllToolModules.STONE_AXE_HEAD, new Item.Properties()));
    public static final Item IRON_AXE_HEAD = register("iron_axe_head", new ToolModuleItem(AllToolModules.IRON_AXE_HEAD, new Item.Properties()));
    public static final Item COPPER_AXE_HEAD = register("copper_axe_head", new ToolModuleItem(AllToolModules.COPPER_AXE_HEAD, new Item.Properties()));
    public static final Item GOLDEN_AXE_HEAD = register("golden_axe_head", new ToolModuleItem(AllToolModules.GOLDEN_AXE_HEAD, new Item.Properties()));
    public static final Item NETHERITE_AXE_HEAD = register("netherite_axe_head", new ToolModuleItem(AllToolModules.NETHERITE_AXE_HEAD, new Item.Properties().fireResistant()));
    public static final Item ZINC_AXE_HEAD = register("zinc_axe_head", new ToolModuleItem(AllToolModules.ZINC_AXE_HEAD, new Item.Properties()));
    public static final Item BRASS_AXE_HEAD = register("brass_axe_head", new ToolModuleItem(AllToolModules.BRASS_AXE_HEAD, new Item.Properties()));
    public static final Item DIAMOND_AXE_HEAD = register("diamond_axe_head", new ToolModuleItem(AllToolModules.DIAMOND_AXE_HEAD, new Item.Properties()));

    public static final Item WOODEN_HOE_HEAD = register("wooden_hoe_head", new ToolModuleItem(AllToolModules.WOODEN_HOE_HEAD, new Item.Properties()));
    public static final Item STONE_HOE_HEAD = register("stone_hoe_head", new ToolModuleItem(AllToolModules.STONE_HOE_HEAD, new Item.Properties()));
    public static final Item IRON_HOE_HEAD = register("iron_hoe_head", new ToolModuleItem(AllToolModules.IRON_HOE_HEAD, new Item.Properties()));
    public static final Item COPPER_HOE_HEAD = register("copper_hoe_head", new ToolModuleItem(AllToolModules.COPPER_HOE_HEAD, new Item.Properties()));
    public static final Item GOLDEN_HOE_HEAD = register("golden_hoe_head", new ToolModuleItem(AllToolModules.GOLDEN_HOE_HEAD, new Item.Properties()));
    public static final Item NETHERITE_HOE_HEAD = register("netherite_hoe_head", new ToolModuleItem(AllToolModules.NETHERITE_HOE_HEAD, new Item.Properties().fireResistant()));
    public static final Item ZINC_HOE_HEAD = register("zinc_hoe_head", new ToolModuleItem(AllToolModules.ZINC_HOE_HEAD, new Item.Properties()));
    public static final Item BRASS_HOE_HEAD = register("brass_hoe_head", new ToolModuleItem(AllToolModules.BRASS_HOE_HEAD, new Item.Properties()));
    public static final Item DIAMOND_HOE_HEAD = register("diamond_hoe_head", new ToolModuleItem(AllToolModules.DIAMOND_HOE_HEAD, new Item.Properties()));

    public static final Item STONE_TOOL_HANDLE = register("stone_tool_handle", new ToolModuleItem(AllToolModules.STONE_TOOL_HANDLE, new Item.Properties()));
    public static final Item IRON_TOOL_HANDLE = register("iron_tool_handle", new ToolModuleItem(AllToolModules.IRON_TOOL_HANDLE, new Item.Properties()));
    public static final Item COPPER_TOOL_HANDLE = register("copper_tool_handle", new ToolModuleItem(AllToolModules.COPPER_TOOL_HANDLE, new Item.Properties()));
    public static final Item GOLDEN_TOOL_HANDLE = register("golden_tool_handle", new ToolModuleItem(AllToolModules.GOLDEN_TOOL_HANDLE, new Item.Properties()));
    public static final Item NETHERITE_TOOL_HANDLE = register("netherite_tool_handle", new ToolModuleItem(AllToolModules.NETHERITE_TOOL_HANDLE, new Item.Properties().fireResistant()));
    public static final Item ZINC_TOOL_HANDLE = register("zinc_tool_handle", new ToolModuleItem(AllToolModules.ZINC_TOOL_HANDLE, new Item.Properties()));
    public static final Item BRASS_TOOL_HANDLE = register("brass_tool_handle", new ToolModuleItem(AllToolModules.BRASS_TOOL_HANDLE, new Item.Properties()));
    public static final Item DIAMOND_TOOL_HANDLE = register("diamond_tool_handle", new ToolModuleItem(AllToolModules.DIAMOND_TOOL_HANDLE, new Item.Properties()));

    public static final Item WOODEN_TOOL_GRIP = register("wooden_tool_grip", new ToolModuleItem(AllToolModules.WOODEN_TOOL_GRIP, new Item.Properties()));
    public static final Item STONE_TOOL_GRIP = register("stone_tool_grip", new ToolModuleItem(AllToolModules.STONE_TOOL_GRIP, new Item.Properties()));
    public static final Item IRON_TOOL_GRIP = register("iron_tool_grip", new ToolModuleItem(AllToolModules.IRON_TOOL_GRIP, new Item.Properties()));
    public static final Item COPPER_TOOL_GRIP = register("copper_tool_grip", new ToolModuleItem(AllToolModules.COPPER_TOOL_GRIP, new Item.Properties()));
    public static final Item GOLDEN_TOOL_GRIP = register("golden_tool_grip", new ToolModuleItem(AllToolModules.GOLDEN_TOOL_GRIP, new Item.Properties()));
    public static final Item NETHERITE_TOOL_GRIP = register("netherite_tool_grip", new ToolModuleItem(AllToolModules.NETHERITE_TOOL_GRIP, new Item.Properties().fireResistant()));
    public static final Item ZINC_TOOL_GRIP = register("zinc_tool_grip", new ToolModuleItem(AllToolModules.ZINC_TOOL_GRIP, new Item.Properties()));
    public static final Item BRASS_TOOL_GRIP = register("brass_tool_grip", new ToolModuleItem(AllToolModules.BRASS_TOOL_GRIP, new Item.Properties()));
    public static final Item DIAMOND_TOOL_GRIP = register("diamond_tool_grip", new ToolModuleItem(AllToolModules.DIAMOND_TOOL_GRIP, new Item.Properties()));

    public static final Item WOODEN_SWORD_GUARD = register("wooden_sword_guard", new ToolModuleItem(AllToolModules.WOODEN_SWORD_GUARD, new Item.Properties()));
    public static final Item STONE_SWORD_GUARD = register("stone_sword_guard", new ToolModuleItem(AllToolModules.STONE_SWORD_GUARD, new Item.Properties()));
    public static final Item IRON_SWORD_GUARD = register("iron_sword_guard", new ToolModuleItem(AllToolModules.IRON_SWORD_GUARD, new Item.Properties()));
    public static final Item COPPER_SWORD_GUARD = register("copper_sword_guard", new ToolModuleItem(AllToolModules.COPPER_SWORD_GUARD, new Item.Properties()));
    public static final Item GOLDEN_SWORD_GUARD = register("golden_sword_guard", new ToolModuleItem(AllToolModules.GOLDEN_SWORD_GUARD, new Item.Properties()));
    public static final Item NETHERITE_SWORD_GUARD = register("netherite_sword_guard", new ToolModuleItem(AllToolModules.NETHERITE_SWORD_GUARD, new Item.Properties().fireResistant()));
    public static final Item ZINC_SWORD_GUARD = register("zinc_sword_guard", new ToolModuleItem(AllToolModules.ZINC_SWORD_GUARD, new Item.Properties()));
    public static final Item BRASS_SWORD_GUARD = register("brass_sword_guard", new ToolModuleItem(AllToolModules.BRASS_SWORD_GUARD, new Item.Properties()));
    public static final Item DIAMOND_SWORD_GUARD = register("diamond_sword_guard", new ToolModuleItem(AllToolModules.DIAMOND_SWORD_GUARD, new Item.Properties()));

    public static final Item WOODEN_SWORD_POMMEL = register("wooden_sword_pommel", new ToolModuleItem(AllToolModules.WOODEN_SWORD_POMMEL, new Item.Properties()));
    public static final Item STONE_SWORD_POMMEL = register("stone_sword_pommel", new ToolModuleItem(AllToolModules.STONE_SWORD_POMMEL, new Item.Properties()));
    public static final Item IRON_SWORD_POMMEL = register("iron_sword_pommel", new ToolModuleItem(AllToolModules.IRON_SWORD_POMMEL, new Item.Properties()));
    public static final Item COPPER_SWORD_POMMEL = register("copper_sword_pommel", new ToolModuleItem(AllToolModules.COPPER_SWORD_POMMEL, new Item.Properties()));
    public static final Item GOLDEN_SWORD_POMMEL = register("golden_sword_pommel", new ToolModuleItem(AllToolModules.GOLDEN_SWORD_POMMEL, new Item.Properties()));
    public static final Item NETHERITE_SWORD_POMMEL = register("netherite_sword_pommel", new ToolModuleItem(AllToolModules.NETHERITE_SWORD_POMMEL, new Item.Properties().fireResistant()));
    public static final Item ZINC_SWORD_POMMEL = register("zinc_sword_pommel", new ToolModuleItem(AllToolModules.ZINC_SWORD_POMMEL, new Item.Properties()));
    public static final Item BRASS_SWORD_POMMEL = register("brass_sword_pommel", new ToolModuleItem(AllToolModules.BRASS_SWORD_POMMEL, new Item.Properties()));
    public static final Item DIAMOND_SWORD_POMMEL = register("diamond_sword_pommel", new ToolModuleItem(AllToolModules.DIAMOND_SWORD_POMMEL, new Item.Properties()));

    private static Item register(String path, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, CreateModularTools.asResource(path), item);
    }

    public static void init() {
    }
}
