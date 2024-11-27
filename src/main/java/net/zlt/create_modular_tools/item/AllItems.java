package net.zlt.create_modular_tools.item;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.fluid.AllFluids;
import net.zlt.create_modular_tools.item.molten_metal.MoltenMetalBucketItem;
import net.zlt.create_modular_tools.item.tool.*;
import net.zlt.create_modular_tools.item.tool.module.axe_head.*;
import net.zlt.create_modular_tools.item.tool.module.hoe_head.*;
import net.zlt.create_modular_tools.item.tool.module.pickaxe_head.*;
import net.zlt.create_modular_tools.item.tool.module.shovel_head.*;
import net.zlt.create_modular_tools.item.tool.module.sword_blade.*;
import net.zlt.create_modular_tools.item.tool.module.sword_guard.*;
import net.zlt.create_modular_tools.item.tool.module.sword_pommel.*;
import net.zlt.create_modular_tools.item.tool.module.tool_grip.*;
import net.zlt.create_modular_tools.item.tool.module.tool_handle.*;
import net.zlt.create_modular_tools.item.tool.module.tool_wrap.WoolToolWrapToolModuleItem;
import net.zlt.create_modular_tools.tool.module.ToolModuleConstants;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class AllItems {
    private AllItems() {
    }

    public static final Item MOLTEN_IRON_BUCKET = register("molten_iron_bucket", new MoltenMetalBucketItem(AllFluids.MOLTEN_IRON, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final Item MOLTEN_COPPER_BUCKET = register("molten_copper_bucket", new MoltenMetalBucketItem(AllFluids.MOLTEN_COPPER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final Item MOLTEN_GOLD_BUCKET = register("molten_gold_bucket", new MoltenMetalBucketItem(AllFluids.MOLTEN_GOLD, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final Item MOLTEN_NETHERITE_BUCKET = register("molten_netherite_bucket", new MoltenMetalBucketItem(AllFluids.MOLTEN_NETHERITE, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final Item MOLTEN_ZINC_BUCKET = register("molten_zinc_bucket", new MoltenMetalBucketItem(AllFluids.MOLTEN_ZINC, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final Item MOLTEN_BRASS_BUCKET = register("molten_brass_bucket", new MoltenMetalBucketItem(AllFluids.MOLTEN_BRASS, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final Item MOLTEN_DIAMOND_BUCKET = register("molten_diamond_bucket", new MoltenMetalBucketItem(AllFluids.MOLTEN_DIAMOND, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final Item MODULAR_SWORD = register("modular_sword", new ModularSwordItem(new Item.Properties()));
    public static final Item MODULAR_SHOVEL = register("modular_shovel", new ModularShovelItem(new Item.Properties()));
    public static final Item MODULAR_PICKAXE = register("modular_pickaxe", new ModularPickaxeItem(new Item.Properties()));
    public static final Item MODULAR_AXE = register("modular_axe", new ModularAxeItem(new Item.Properties()));
    public static final Item MODULAR_HOE = register("modular_hoe", new ModularHoeItem(new Item.Properties()));

    public static final Item WOODEN_SWORD_BLADE = register("wooden_sword_blade", new WoodenSwordBladeToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item OAK_SWORD_BLADE = register("oak_sword_blade", new WoodenSwordBladeToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item SPRUCE_SWORD_BLADE = register("spruce_sword_blade", new WoodenSwordBladeToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item BIRCH_SWORD_BLADE = register("birch_sword_blade", new WoodenSwordBladeToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item JUNGLE_SWORD_BLADE = register("jungle_sword_blade", new WoodenSwordBladeToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item ACACIA_SWORD_BLADE = register("acacia_sword_blade", new WoodenSwordBladeToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item DARK_OAK_SWORD_BLADE = register("dark_oak_sword_blade", new WoodenSwordBladeToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item MANGROVE_SWORD_BLADE = register("mangrove_sword_blade", new WoodenSwordBladeToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item CHERRY_SWORD_BLADE = register("cherry_sword_blade", new WoodenSwordBladeToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.CHERRY_WOOD_SOUND;
        }
    });
    public static final Item BAMBOO_SWORD_BLADE = register("bamboo_sword_blade", new WoodenSwordBladeToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.BAMBOO_WOOD_SOUND;
        }
    });
    public static final Item CRIMSON_SWORD_BLADE = register("crimson_sword_blade", new WoodenSwordBladeToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.NETHER_WOOD_SOUND;
        }
    });
    public static final Item WARPED_SWORD_BLADE = register("warped_sword_blade", new WoodenSwordBladeToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.NETHER_WOOD_SOUND;
        }
    });
    public static final Item STONE_SWORD_BLADE = register("stone_sword_blade", new StoneSwordBladeToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item IRON_SWORD_BLADE = register("iron_sword_blade", new IronSwordBladeToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item COPPER_SWORD_BLADE = register("copper_sword_blade", new CopperSwordBladeToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item GOLDEN_SWORD_BLADE = register("golden_sword_blade", new GoldenSwordBladeToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item NETHERITE_SWORD_BLADE = register("netherite_sword_blade", new NetheriteSwordBladeToolModuleItem(new Item.Properties().stacksTo(1).fireResistant()));
    public static final Item ZINC_SWORD_BLADE = register("zinc_sword_blade", new ZincSwordBladeToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item BRASS_SWORD_BLADE = register("brass_sword_blade", new BrassSwordBladeToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item DIAMOND_SWORD_BLADE = register("diamond_sword_blade", new DiamondSwordBladeToolModuleItem(new Item.Properties().stacksTo(1)));

    public static final Item WOODEN_SHOVEL_HEAD = register("wooden_shovel_head", new WoodenShovelHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item OAK_SHOVEL_HEAD = register("oak_shovel_head", new WoodenShovelHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item SPRUCE_SHOVEL_HEAD = register("spruce_shovel_head", new WoodenShovelHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item BIRCH_SHOVEL_HEAD = register("birch_shovel_head", new WoodenShovelHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item JUNGLE_SHOVEL_HEAD = register("jungle_shovel_head", new WoodenShovelHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item ACACIA_SHOVEL_HEAD = register("acacia_shovel_head", new WoodenShovelHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item DARK_OAK_SHOVEL_HEAD = register("dark_oak_shovel_head", new WoodenShovelHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item MANGROVE_SHOVEL_HEAD = register("mangrove_shovel_head", new WoodenShovelHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item CHERRY_SHOVEL_HEAD = register("cherry_shovel_head", new WoodenShovelHeadToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.CHERRY_WOOD_SOUND;
        }
    });
    public static final Item BAMBOO_SHOVEL_HEAD = register("bamboo_shovel_head", new WoodenShovelHeadToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.BAMBOO_WOOD_SOUND;
        }
    });
    public static final Item CRIMSON_SHOVEL_HEAD = register("crimson_shovel_head", new WoodenShovelHeadToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.NETHER_WOOD_SOUND;
        }
    });
    public static final Item WARPED_SHOVEL_HEAD = register("warped_shovel_head", new WoodenShovelHeadToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.NETHER_WOOD_SOUND;
        }
    });
    public static final Item STONE_SHOVEL_HEAD = register("stone_shovel_head", new StoneShovelHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item IRON_SHOVEL_HEAD = register("iron_shovel_head", new IronShovelHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item COPPER_SHOVEL_HEAD = register("copper_shovel_head", new CopperShovelHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item GOLDEN_SHOVEL_HEAD = register("golden_shovel_head", new GoldenShovelHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item NETHERITE_SHOVEL_HEAD = register("netherite_shovel_head", new NetheriteShovelHeadToolModuleItem(new Item.Properties().stacksTo(1).fireResistant()));
    public static final Item ZINC_SHOVEL_HEAD = register("zinc_shovel_head", new ZincShovelHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item BRASS_SHOVEL_HEAD = register("brass_shovel_head", new BrassShovelHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item DIAMOND_SHOVEL_HEAD = register("diamond_shovel_head", new DiamondShovelHeadToolModuleItem(new Item.Properties().stacksTo(1)));

    public static final Item WOODEN_PICKAXE_HEAD = register("wooden_pickaxe_head", new WoodenPickaxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item OAK_PICKAXE_HEAD = register("oak_pickaxe_head", new WoodenPickaxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item SPRUCE_PICKAXE_HEAD = register("spruce_pickaxe_head", new WoodenPickaxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item BIRCH_PICKAXE_HEAD = register("birch_pickaxe_head", new WoodenPickaxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item JUNGLE_PICKAXE_HEAD = register("jungle_pickaxe_head", new WoodenPickaxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item ACACIA_PICKAXE_HEAD = register("acacia_pickaxe_head", new WoodenPickaxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item DARK_OAK_PICKAXE_HEAD = register("dark_oak_pickaxe_head", new WoodenPickaxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item MANGROVE_PICKAXE_HEAD = register("mangrove_pickaxe_head", new WoodenPickaxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item CHERRY_PICKAXE_HEAD = register("cherry_pickaxe_head", new WoodenPickaxeHeadToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.CHERRY_WOOD_SOUND;
        }
    });
    public static final Item BAMBOO_PICKAXE_HEAD = register("bamboo_pickaxe_head", new WoodenPickaxeHeadToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.BAMBOO_WOOD_SOUND;
        }
    });
    public static final Item CRIMSON_PICKAXE_HEAD = register("crimson_pickaxe_head", new WoodenPickaxeHeadToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.NETHER_WOOD_SOUND;
        }
    });
    public static final Item WARPED_PICKAXE_HEAD = register("warped_pickaxe_head", new WoodenPickaxeHeadToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.NETHER_WOOD_SOUND;
        }
    });
    public static final Item STONE_PICKAXE_HEAD = register("stone_pickaxe_head", new StonePickaxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item IRON_PICKAXE_HEAD = register("iron_pickaxe_head", new IronPickaxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item COPPER_PICKAXE_HEAD = register("copper_pickaxe_head", new CopperPickaxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item GOLDEN_PICKAXE_HEAD = register("golden_pickaxe_head", new GoldenPickaxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item NETHERITE_PICKAXE_HEAD = register("netherite_pickaxe_head", new NetheritePickaxeHeadToolModuleItem(new Item.Properties().stacksTo(1).fireResistant()));
    public static final Item ZINC_PICKAXE_HEAD = register("zinc_pickaxe_head", new ZincPickaxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item BRASS_PICKAXE_HEAD = register("brass_pickaxe_head", new BrassPickaxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item DIAMOND_PICKAXE_HEAD = register("diamond_pickaxe_head", new DiamondPickaxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));

    public static final Item WOODEN_AXE_HEAD = register("wooden_axe_head", new WoodenAxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item OAK_AXE_HEAD = register("oak_axe_head", new WoodenAxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item SPRUCE_AXE_HEAD = register("spruce_axe_head", new WoodenAxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item BIRCH_AXE_HEAD = register("birch_axe_head", new WoodenAxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item JUNGLE_AXE_HEAD = register("jungle_axe_head", new WoodenAxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item ACACIA_AXE_HEAD = register("acacia_axe_head", new WoodenAxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item DARK_OAK_AXE_HEAD = register("dark_oak_axe_head", new WoodenAxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item MANGROVE_AXE_HEAD = register("mangrove_axe_head", new WoodenAxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item CHERRY_AXE_HEAD = register("cherry_axe_head", new WoodenAxeHeadToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.CHERRY_WOOD_SOUND;
        }
    });
    public static final Item BAMBOO_AXE_HEAD = register("bamboo_axe_head", new WoodenAxeHeadToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.BAMBOO_WOOD_SOUND;
        }
    });
    public static final Item CRIMSON_AXE_HEAD = register("crimson_axe_head", new WoodenAxeHeadToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.NETHER_WOOD_SOUND;
        }
    });
    public static final Item WARPED_AXE_HEAD = register("warped_axe_head", new WoodenAxeHeadToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.NETHER_WOOD_SOUND;
        }
    });
    public static final Item STONE_AXE_HEAD = register("stone_axe_head", new StoneAxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item IRON_AXE_HEAD = register("iron_axe_head", new IronAxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item COPPER_AXE_HEAD = register("copper_axe_head", new CopperAxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item GOLDEN_AXE_HEAD = register("golden_axe_head", new GoldenAxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item NETHERITE_AXE_HEAD = register("netherite_axe_head", new NetheriteAxeHeadToolModuleItem(new Item.Properties().stacksTo(1).fireResistant()));
    public static final Item ZINC_AXE_HEAD = register("zinc_axe_head", new ZincAxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item BRASS_AXE_HEAD = register("brass_axe_head", new BrassAxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item DIAMOND_AXE_HEAD = register("diamond_axe_head", new DiamondAxeHeadToolModuleItem(new Item.Properties().stacksTo(1)));

    public static final Item WOODEN_HOE_HEAD = register("wooden_hoe_head", new WoodenHoeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item OAK_HOE_HEAD = register("oak_hoe_head", new WoodenHoeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item SPRUCE_HOE_HEAD = register("spruce_hoe_head", new WoodenHoeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item BIRCH_HOE_HEAD = register("birch_hoe_head", new WoodenHoeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item JUNGLE_HOE_HEAD = register("jungle_hoe_head", new WoodenHoeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item ACACIA_HOE_HEAD = register("acacia_hoe_head", new WoodenHoeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item DARK_OAK_HOE_HEAD = register("dark_oak_hoe_head", new WoodenHoeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item MANGROVE_HOE_HEAD = register("mangrove_hoe_head", new WoodenHoeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item CHERRY_HOE_HEAD = register("cherry_hoe_head", new WoodenHoeHeadToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.CHERRY_WOOD_SOUND;
        }
    });
    public static final Item BAMBOO_HOE_HEAD = register("bamboo_hoe_head", new WoodenHoeHeadToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.BAMBOO_WOOD_SOUND;
        }
    });
    public static final Item CRIMSON_HOE_HEAD = register("crimson_hoe_head", new WoodenHoeHeadToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.NETHER_WOOD_SOUND;
        }
    });
    public static final Item WARPED_HOE_HEAD = register("warped_hoe_head", new WoodenHoeHeadToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.NETHER_WOOD_SOUND;
        }
    });
    public static final Item STONE_HOE_HEAD = register("stone_hoe_head", new StoneHoeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item IRON_HOE_HEAD = register("iron_hoe_head", new IronHoeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item COPPER_HOE_HEAD = register("copper_hoe_head", new CopperHoeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item GOLDEN_HOE_HEAD = register("golden_hoe_head", new GoldenHoeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item NETHERITE_HOE_HEAD = register("netherite_hoe_head", new NetheriteHoeHeadToolModuleItem(new Item.Properties().stacksTo(1).fireResistant()));
    public static final Item ZINC_HOE_HEAD = register("zinc_hoe_head", new ZincHoeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item BRASS_HOE_HEAD = register("brass_hoe_head", new BrassHoeHeadToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item DIAMOND_HOE_HEAD = register("diamond_hoe_head", new DiamondHoeHeadToolModuleItem(new Item.Properties().stacksTo(1)));

    public static final Item WOODEN_TOOL_HANDLE = register("wooden_tool_handle", new WoodenToolHandleToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item OAK_TOOL_HANDLE = register("oak_tool_handle", new WoodenToolHandleToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item SPRUCE_TOOL_HANDLE = register("spruce_tool_handle", new WoodenToolHandleToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item BIRCH_TOOL_HANDLE = register("birch_tool_handle", new WoodenToolHandleToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item JUNGLE_TOOL_HANDLE = register("jungle_tool_handle", new WoodenToolHandleToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item ACACIA_TOOL_HANDLE = register("acacia_tool_handle", new WoodenToolHandleToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item DARK_OAK_TOOL_HANDLE = register("dark_oak_tool_handle", new WoodenToolHandleToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item MANGROVE_TOOL_HANDLE = register("mangrove_tool_handle", new WoodenToolHandleToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item CHERRY_TOOL_HANDLE = register("cherry_tool_handle", new WoodenToolHandleToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.CHERRY_WOOD_SOUND;
        }
    });
    public static final Item BAMBOO_TOOL_HANDLE = register("bamboo_tool_handle", new WoodenToolHandleToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.BAMBOO_WOOD_SOUND;
        }
    });
    public static final Item CRIMSON_TOOL_HANDLE = register("crimson_tool_handle", new WoodenToolHandleToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.NETHER_WOOD_SOUND;
        }
    });
    public static final Item WARPED_TOOL_HANDLE = register("warped_tool_handle", new WoodenToolHandleToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.NETHER_WOOD_SOUND;
        }
    });
    public static final Item STONE_TOOL_HANDLE = register("stone_tool_handle", new StoneToolHandleToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item IRON_TOOL_HANDLE = register("iron_tool_handle", new IronToolHandleToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item COPPER_TOOL_HANDLE = register("copper_tool_handle", new CopperToolHandleToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item GOLDEN_TOOL_HANDLE = register("golden_tool_handle", new GoldenToolHandleToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item NETHERITE_TOOL_HANDLE = register("netherite_tool_handle", new NetheriteToolHandleToolModuleItem(new Item.Properties().stacksTo(1).fireResistant()));
    public static final Item ZINC_TOOL_HANDLE = register("zinc_tool_handle", new ZincToolHandleToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item BRASS_TOOL_HANDLE = register("brass_tool_handle", new BrassToolHandleToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item DIAMOND_TOOL_HANDLE = register("diamond_tool_handle", new DiamondToolHandleToolModuleItem(new Item.Properties().stacksTo(1)));

    public static final Item WOODEN_TOOL_GRIP = register("wooden_tool_grip", new WoodenToolGripToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item OAK_TOOL_GRIP = register("oak_tool_grip", new WoodenToolGripToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item SPRUCE_TOOL_GRIP = register("spruce_tool_grip", new WoodenToolGripToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item BIRCH_TOOL_GRIP = register("birch_tool_grip", new WoodenToolGripToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item JUNGLE_TOOL_GRIP = register("jungle_tool_grip", new WoodenToolGripToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item ACACIA_TOOL_GRIP = register("acacia_tool_grip", new WoodenToolGripToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item DARK_OAK_TOOL_GRIP = register("dark_oak_tool_grip", new WoodenToolGripToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item MANGROVE_TOOL_GRIP = register("mangrove_tool_grip", new WoodenToolGripToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item CHERRY_TOOL_GRIP = register("cherry_tool_grip", new WoodenToolGripToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.CHERRY_WOOD_SOUND;
        }
    });
    public static final Item BAMBOO_TOOL_GRIP = register("bamboo_tool_grip", new WoodenToolGripToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.BAMBOO_WOOD_SOUND;
        }
    });
    public static final Item CRIMSON_TOOL_GRIP = register("crimson_tool_grip", new WoodenToolGripToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.NETHER_WOOD_SOUND;
        }
    });
    public static final Item WARPED_TOOL_GRIP = register("warped_tool_grip", new WoodenToolGripToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.NETHER_WOOD_SOUND;
        }
    });
    public static final Item STONE_TOOL_GRIP = register("stone_tool_grip", new StoneToolGripToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item IRON_TOOL_GRIP = register("iron_tool_grip", new IronToolGripToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item COPPER_TOOL_GRIP = register("copper_tool_grip", new CopperToolGripToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item GOLDEN_TOOL_GRIP = register("golden_tool_grip", new GoldenToolGripToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item NETHERITE_TOOL_GRIP = register("netherite_tool_grip", new NetheriteToolGripToolModuleItem(new Item.Properties().stacksTo(1).fireResistant()));
    public static final Item ZINC_TOOL_GRIP = register("zinc_tool_grip", new ZincToolGripToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item BRASS_TOOL_GRIP = register("brass_tool_grip", new BrassToolGripToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item DIAMOND_TOOL_GRIP = register("diamond_tool_grip", new DiamondToolGripToolModuleItem(new Item.Properties().stacksTo(1)));

    public static final Item WOODEN_SWORD_GUARD = register("wooden_sword_guard", new WoodenSwordGuardToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item OAK_SWORD_GUARD = register("oak_sword_guard", new WoodenSwordGuardToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item SPRUCE_SWORD_GUARD = register("spruce_sword_guard", new WoodenSwordGuardToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item BIRCH_SWORD_GUARD = register("birch_sword_guard", new WoodenSwordGuardToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item JUNGLE_SWORD_GUARD = register("jungle_sword_guard", new WoodenSwordGuardToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item ACACIA_SWORD_GUARD = register("acacia_sword_guard", new WoodenSwordGuardToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item DARK_OAK_SWORD_GUARD = register("dark_oak_sword_guard", new WoodenSwordGuardToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item MANGROVE_SWORD_GUARD = register("mangrove_sword_guard", new WoodenSwordGuardToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item CHERRY_SWORD_GUARD = register("cherry_sword_guard", new WoodenSwordGuardToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.CHERRY_WOOD_SOUND;
        }
    });
    public static final Item BAMBOO_SWORD_GUARD = register("bamboo_sword_guard", new WoodenSwordGuardToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.BAMBOO_WOOD_SOUND;
        }
    });
    public static final Item CRIMSON_SWORD_GUARD = register("crimson_sword_guard", new WoodenSwordGuardToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.NETHER_WOOD_SOUND;
        }
    });
    public static final Item WARPED_SWORD_GUARD = register("warped_sword_guard", new WoodenSwordGuardToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.NETHER_WOOD_SOUND;
        }
    });
    public static final Item STONE_SWORD_GUARD = register("stone_sword_guard", new StoneSwordGuardToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item IRON_SWORD_GUARD = register("iron_sword_guard", new IronSwordGuardToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item COPPER_SWORD_GUARD = register("copper_sword_guard", new CopperSwordGuardToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item GOLDEN_SWORD_GUARD = register("golden_sword_guard", new GoldenSwordGuardToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item NETHERITE_SWORD_GUARD = register("netherite_sword_guard", new NetheriteSwordGuardToolModuleItem(new Item.Properties().stacksTo(1).fireResistant()));
    public static final Item ZINC_SWORD_GUARD = register("zinc_sword_guard", new ZincSwordGuardToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item BRASS_SWORD_GUARD = register("brass_sword_guard", new BrassSwordGuardToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item DIAMOND_SWORD_GUARD = register("diamond_sword_guard", new DiamondSwordGuardToolModuleItem(new Item.Properties().stacksTo(1)));

    public static final Item WOODEN_SWORD_POMMEL = register("wooden_sword_pommel", new WoodenSwordPommelToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item OAK_SWORD_POMMEL = register("oak_sword_pommel", new WoodenSwordPommelToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item SPRUCE_SWORD_POMMEL = register("spruce_sword_pommel", new WoodenSwordPommelToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item BIRCH_SWORD_POMMEL = register("birch_sword_pommel", new WoodenSwordPommelToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item JUNGLE_SWORD_POMMEL = register("jungle_sword_pommel", new WoodenSwordPommelToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item ACACIA_SWORD_POMMEL = register("acacia_sword_pommel", new WoodenSwordPommelToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item DARK_OAK_SWORD_POMMEL = register("dark_oak_sword_pommel", new WoodenSwordPommelToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item MANGROVE_SWORD_POMMEL = register("mangrove_sword_pommel", new WoodenSwordPommelToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item CHERRY_SWORD_POMMEL = register("cherry_sword_pommel", new WoodenSwordPommelToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.CHERRY_WOOD_SOUND;
        }
    });
    public static final Item BAMBOO_SWORD_POMMEL = register("bamboo_sword_pommel", new WoodenSwordPommelToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.BAMBOO_WOOD_SOUND;
        }
    });
    public static final Item CRIMSON_SWORD_POMMEL = register("crimson_sword_pommel", new WoodenSwordPommelToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.NETHER_WOOD_SOUND;
        }
    });
    public static final Item WARPED_SWORD_POMMEL = register("warped_sword_pommel", new WoodenSwordPommelToolModuleItem(new Item.Properties().stacksTo(1)) {
        @Override
        public SoundEvent getSound() {
            return ToolModuleConstants.NETHER_WOOD_SOUND;
        }
    });
    public static final Item STONE_SWORD_POMMEL = register("stone_sword_pommel", new StoneSwordPommelToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item IRON_SWORD_POMMEL = register("iron_sword_pommel", new IronSwordPommelToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item COPPER_SWORD_POMMEL = register("copper_sword_pommel", new CopperSwordPommelToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item GOLDEN_SWORD_POMMEL = register("golden_sword_pommel", new GoldenSwordPommelToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item NETHERITE_SWORD_POMMEL = register("netherite_sword_pommel", new NetheriteSwordPommelToolModuleItem(new Item.Properties().stacksTo(1).fireResistant()));
    public static final Item ZINC_SWORD_POMMEL = register("zinc_sword_pommel", new ZincSwordPommelToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item BRASS_SWORD_POMMEL = register("brass_sword_pommel", new BrassSwordPommelToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item DIAMOND_SWORD_POMMEL = register("diamond_sword_pommel", new DiamondSwordPommelToolModuleItem(new Item.Properties().stacksTo(1)));

    public static final Item WHITE_WOOL_TOOL_WRAP = register("white_wool_tool_wrap", new WoolToolWrapToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item LIGHT_GRAY_WOOL_TOOL_WRAP = register("light_gray_wool_tool_wrap", new WoolToolWrapToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item GRAY_WOOL_TOOL_WRAP = register("gray_wool_tool_wrap", new WoolToolWrapToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item BLACK_WOOL_TOOL_WRAP = register("black_wool_tool_wrap", new WoolToolWrapToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item BROWN_WOOL_TOOL_WRAP = register("brown_wool_tool_wrap", new WoolToolWrapToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item RED_WOOL_TOOL_WRAP = register("red_wool_tool_wrap", new WoolToolWrapToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item ORANGE_WOOL_TOOL_WRAP = register("orange_wool_tool_wrap", new WoolToolWrapToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item YELLOW_WOOL_TOOL_WRAP = register("yellow_wool_tool_wrap", new WoolToolWrapToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item LIME_WOOL_TOOL_WRAP = register("lime_wool_tool_wrap", new WoolToolWrapToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item GREEN_WOOL_TOOL_WRAP = register("green_wool_tool_wrap", new WoolToolWrapToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item CYAN_WOOL_TOOL_WRAP = register("cyan_wool_tool_wrap", new WoolToolWrapToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item LIGHT_BLUE_WOOL_TOOL_WRAP = register("light_blue_wool_tool_wrap", new WoolToolWrapToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item BLUE_WOOL_TOOL_WRAP = register("blue_wool_tool_wrap", new WoolToolWrapToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item PURPLE_WOOL_TOOL_WRAP = register("purple_wool_tool_wrap", new WoolToolWrapToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item MAGENTA_WOOL_TOOL_WRAP = register("magenta_wool_tool_wrap", new WoolToolWrapToolModuleItem(new Item.Properties().stacksTo(1)));
    public static final Item PINK_WOOL_TOOL_WRAP = register("pink_wool_tool_wrap", new WoolToolWrapToolModuleItem(new Item.Properties().stacksTo(1)));

    private static Item register(String path, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, CreateModularTools.asResource(path), item);
    }

    private static void registerToolModuleFuel(Item... toolModules) {
        for (Item toolModule : toolModules) {
            FuelRegistry.INSTANCE.add(toolModule, 100);
        }
    }

    public static void init() {
        registerToolModuleFuel(
            WOODEN_SWORD_BLADE,
            OAK_SWORD_BLADE,
            SPRUCE_SWORD_BLADE,
            BIRCH_SWORD_BLADE,
            JUNGLE_SWORD_BLADE,
            ACACIA_SWORD_BLADE,
            DARK_OAK_SWORD_BLADE,
            MANGROVE_SWORD_BLADE,
            CHERRY_SWORD_BLADE,
            BAMBOO_SWORD_BLADE,

            WOODEN_SHOVEL_HEAD,
            OAK_SHOVEL_HEAD,
            SPRUCE_SHOVEL_HEAD,
            BIRCH_SHOVEL_HEAD,
            JUNGLE_SHOVEL_HEAD,
            ACACIA_SHOVEL_HEAD,
            DARK_OAK_SHOVEL_HEAD,
            MANGROVE_SHOVEL_HEAD,
            CHERRY_SHOVEL_HEAD,
            BAMBOO_SHOVEL_HEAD,

            WOODEN_PICKAXE_HEAD,
            OAK_PICKAXE_HEAD,
            SPRUCE_PICKAXE_HEAD,
            BIRCH_PICKAXE_HEAD,
            JUNGLE_PICKAXE_HEAD,
            ACACIA_PICKAXE_HEAD,
            DARK_OAK_PICKAXE_HEAD,
            MANGROVE_PICKAXE_HEAD,
            CHERRY_PICKAXE_HEAD,
            BAMBOO_PICKAXE_HEAD,

            WOODEN_AXE_HEAD,
            OAK_AXE_HEAD,
            SPRUCE_AXE_HEAD,
            BIRCH_AXE_HEAD,
            JUNGLE_AXE_HEAD,
            ACACIA_AXE_HEAD,
            DARK_OAK_AXE_HEAD,
            MANGROVE_AXE_HEAD,
            CHERRY_AXE_HEAD,
            BAMBOO_AXE_HEAD,

            WOODEN_HOE_HEAD,
            OAK_HOE_HEAD,
            SPRUCE_HOE_HEAD,
            BIRCH_HOE_HEAD,
            JUNGLE_HOE_HEAD,
            ACACIA_HOE_HEAD,
            DARK_OAK_HOE_HEAD,
            MANGROVE_HOE_HEAD,
            CHERRY_HOE_HEAD,
            BAMBOO_HOE_HEAD,

            WOODEN_TOOL_HANDLE,
            OAK_TOOL_HANDLE,
            SPRUCE_TOOL_HANDLE,
            BIRCH_TOOL_HANDLE,
            JUNGLE_TOOL_HANDLE,
            ACACIA_TOOL_HANDLE,
            DARK_OAK_TOOL_HANDLE,
            MANGROVE_TOOL_HANDLE,
            CHERRY_TOOL_HANDLE,
            BAMBOO_TOOL_HANDLE,

            WOODEN_TOOL_GRIP,
            OAK_TOOL_GRIP,
            SPRUCE_TOOL_GRIP,
            BIRCH_TOOL_GRIP,
            JUNGLE_TOOL_GRIP,
            ACACIA_TOOL_GRIP,
            DARK_OAK_TOOL_GRIP,
            MANGROVE_TOOL_GRIP,
            CHERRY_TOOL_GRIP,
            BAMBOO_TOOL_GRIP,
            CRIMSON_TOOL_GRIP,
            WARPED_TOOL_GRIP,

            WOODEN_SWORD_GUARD,
            OAK_SWORD_GUARD,
            SPRUCE_SWORD_GUARD,
            BIRCH_SWORD_GUARD,
            JUNGLE_SWORD_GUARD,
            ACACIA_SWORD_GUARD,
            DARK_OAK_SWORD_GUARD,
            MANGROVE_SWORD_GUARD,
            CHERRY_SWORD_GUARD,
            BAMBOO_SWORD_GUARD,
            CRIMSON_SWORD_GUARD,
            WARPED_SWORD_GUARD,

            WOODEN_SWORD_POMMEL,
            OAK_SWORD_POMMEL,
            SPRUCE_SWORD_POMMEL,
            BIRCH_SWORD_POMMEL,
            JUNGLE_SWORD_POMMEL,
            ACACIA_SWORD_POMMEL,
            DARK_OAK_SWORD_POMMEL,
            MANGROVE_SWORD_POMMEL,
            CHERRY_SWORD_POMMEL,
            BAMBOO_SWORD_POMMEL,
            CRIMSON_SWORD_POMMEL,
            WARPED_SWORD_POMMEL
        );
    }
}
