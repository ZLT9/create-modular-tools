package net.zlt.create_modular_tools.item;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.*;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.block.AllBlocks;
import net.zlt.create_modular_tools.fluid.AllFluids;
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

    public static final Item WOODEN_SWORD_BLADE = register("wooden_sword_blade", new WoodenSwordBladeToolModuleItem(new Item.Properties()));
    public static final Item STONE_SWORD_BLADE = register("stone_sword_blade", new StoneSwordBladeToolModuleItem(new Item.Properties()));
    public static final Item IRON_SWORD_BLADE = register("iron_sword_blade", new IronSwordBladeToolModuleItem(new Item.Properties()));
    public static final Item COPPER_SWORD_BLADE = register("copper_sword_blade", new CopperSwordBladeToolModuleItem(new Item.Properties()));
    public static final Item GOLDEN_SWORD_BLADE = register("golden_sword_blade", new GoldenSwordBladeToolModuleItem(new Item.Properties()));
    public static final Item NETHERITE_SWORD_BLADE = register("netherite_sword_blade", new NetheriteSwordBladeToolModuleItem(new Item.Properties().fireResistant()));
    public static final Item ZINC_SWORD_BLADE = register("zinc_sword_blade", new ZincSwordBladeToolModuleItem(new Item.Properties()));
    public static final Item BRASS_SWORD_BLADE = register("brass_sword_blade", new BrassSwordBladeToolModuleItem(new Item.Properties()));
    public static final Item DIAMOND_SWORD_BLADE = register("diamond_sword_blade", new DiamondSwordBladeToolModuleItem(new Item.Properties()));

    public static final Item WOODEN_SHOVEL_HEAD = register("wooden_shovel_head", new WoodenShovelHeadToolModuleItem(new Item.Properties()));
    public static final Item STONE_SHOVEL_HEAD = register("stone_shovel_head", new StoneShovelHeadToolModuleItem(new Item.Properties()));
    public static final Item IRON_SHOVEL_HEAD = register("iron_shovel_head", new IronShovelHeadToolModuleItem(new Item.Properties()));
    public static final Item COPPER_SHOVEL_HEAD = register("copper_shovel_head", new CopperShovelHeadToolModuleItem(new Item.Properties()));
    public static final Item GOLDEN_SHOVEL_HEAD = register("golden_shovel_head", new GoldenShovelHeadToolModuleItem(new Item.Properties()));
    public static final Item NETHERITE_SHOVEL_HEAD = register("netherite_shovel_head", new NetheriteShovelHeadToolModuleItem(new Item.Properties().fireResistant()));
    public static final Item ZINC_SHOVEL_HEAD = register("zinc_shovel_head", new ZincShovelHeadToolModuleItem(new Item.Properties()));
    public static final Item BRASS_SHOVEL_HEAD = register("brass_shovel_head", new BrassShovelHeadToolModuleItem(new Item.Properties()));
    public static final Item DIAMOND_SHOVEL_HEAD = register("diamond_shovel_head", new DiamondShovelHeadToolModuleItem(new Item.Properties()));

    public static final Item WOODEN_PICKAXE_HEAD = register("wooden_pickaxe_head", new WoodenPickaxeHeadToolModuleItem(new Item.Properties()));
    public static final Item STONE_PICKAXE_HEAD = register("stone_pickaxe_head", new StonePickaxeHeadToolModuleItem(new Item.Properties()));
    public static final Item IRON_PICKAXE_HEAD = register("iron_pickaxe_head", new IronPickaxeHeadToolModuleItem(new Item.Properties()));
    public static final Item COPPER_PICKAXE_HEAD = register("copper_pickaxe_head", new CopperPickaxeHeadToolModuleItem(new Item.Properties()));
    public static final Item GOLDEN_PICKAXE_HEAD = register("golden_pickaxe_head", new GoldenPickaxeHeadToolModuleItem(new Item.Properties()));
    public static final Item NETHERITE_PICKAXE_HEAD = register("netherite_pickaxe_head", new NetheritePickaxeHeadToolModuleItem(new Item.Properties().fireResistant()));
    public static final Item ZINC_PICKAXE_HEAD = register("zinc_pickaxe_head", new ZincPickaxeHeadToolModuleItem(new Item.Properties()));
    public static final Item BRASS_PICKAXE_HEAD = register("brass_pickaxe_head", new BrassPickaxeHeadToolModuleItem(new Item.Properties()));
    public static final Item DIAMOND_PICKAXE_HEAD = register("diamond_pickaxe_head", new DiamondPickaxeHeadToolModuleItem(new Item.Properties()));

    public static final Item WOODEN_AXE_HEAD = register("wooden_axe_head", new WoodenAxeHeadToolModuleItem(new Item.Properties()));
    public static final Item STONE_AXE_HEAD = register("stone_axe_head", new StoneAxeHeadToolModuleItem(new Item.Properties()));
    public static final Item IRON_AXE_HEAD = register("iron_axe_head", new IronAxeHeadToolModuleItem(new Item.Properties()));
    public static final Item COPPER_AXE_HEAD = register("copper_axe_head", new CopperAxeHeadToolModuleItem(new Item.Properties()));
    public static final Item GOLDEN_AXE_HEAD = register("golden_axe_head", new GoldenAxeHeadToolModuleItem(new Item.Properties()));
    public static final Item NETHERITE_AXE_HEAD = register("netherite_axe_head", new NetheriteAxeHeadToolModuleItem(new Item.Properties().fireResistant()));
    public static final Item ZINC_AXE_HEAD = register("zinc_axe_head", new ZincAxeHeadToolModuleItem(new Item.Properties()));
    public static final Item BRASS_AXE_HEAD = register("brass_axe_head", new BrassAxeHeadToolModuleItem(new Item.Properties()));
    public static final Item DIAMOND_AXE_HEAD = register("diamond_axe_head", new DiamondAxeHeadToolModuleItem(new Item.Properties()));

    public static final Item WOODEN_HOE_HEAD = register("wooden_hoe_head", new WoodenHoeHeadToolModuleItem(new Item.Properties()));
    public static final Item STONE_HOE_HEAD = register("stone_hoe_head", new StoneHoeHeadToolModuleItem(new Item.Properties()));
    public static final Item IRON_HOE_HEAD = register("iron_hoe_head", new IronHoeHeadToolModuleItem(new Item.Properties()));
    public static final Item COPPER_HOE_HEAD = register("copper_hoe_head", new CopperHoeHeadToolModuleItem(new Item.Properties()));
    public static final Item GOLDEN_HOE_HEAD = register("golden_hoe_head", new GoldenHoeHeadToolModuleItem(new Item.Properties()));
    public static final Item NETHERITE_HOE_HEAD = register("netherite_hoe_head", new NetheriteHoeHeadToolModuleItem(new Item.Properties().fireResistant()));
    public static final Item ZINC_HOE_HEAD = register("zinc_hoe_head", new ZincHoeHeadToolModuleItem(new Item.Properties()));
    public static final Item BRASS_HOE_HEAD = register("brass_hoe_head", new BrassHoeHeadToolModuleItem(new Item.Properties()));
    public static final Item DIAMOND_HOE_HEAD = register("diamond_hoe_head", new DiamondHoeHeadToolModuleItem(new Item.Properties()));

    public static final Item WOODEN_TOOL_HANDLE = register("wooden_tool_handle", new WoodenToolHandleToolModuleItem(new Item.Properties()));
    public static final Item STONE_TOOL_HANDLE = register("stone_tool_handle", new StoneToolHandleToolModuleItem(new Item.Properties()));
    public static final Item IRON_TOOL_HANDLE = register("iron_tool_handle", new IronToolHandleToolModuleItem(new Item.Properties()));
    public static final Item COPPER_TOOL_HANDLE = register("copper_tool_handle", new CopperToolHandleToolModuleItem(new Item.Properties()));
    public static final Item GOLDEN_TOOL_HANDLE = register("golden_tool_handle", new GoldenToolHandleToolModuleItem(new Item.Properties()));
    public static final Item NETHERITE_TOOL_HANDLE = register("netherite_tool_handle", new NetheriteToolHandleToolModuleItem(new Item.Properties().fireResistant()));
    public static final Item ZINC_TOOL_HANDLE = register("zinc_tool_handle", new ZincToolHandleToolModuleItem(new Item.Properties()));
    public static final Item BRASS_TOOL_HANDLE = register("brass_tool_handle", new BrassToolHandleToolModuleItem(new Item.Properties()));
    public static final Item DIAMOND_TOOL_HANDLE = register("diamond_tool_handle", new DiamondToolHandleToolModuleItem(new Item.Properties()));

    public static final Item WOODEN_TOOL_GRIP = register("wooden_tool_grip", new WoodenToolGripToolModuleItem(new Item.Properties()));
    public static final Item STONE_TOOL_GRIP = register("stone_tool_grip", new StoneToolGripToolModuleItem(new Item.Properties()));
    public static final Item IRON_TOOL_GRIP = register("iron_tool_grip", new IronToolGripToolModuleItem(new Item.Properties()));
    public static final Item COPPER_TOOL_GRIP = register("copper_tool_grip", new CopperToolGripToolModuleItem(new Item.Properties()));
    public static final Item GOLDEN_TOOL_GRIP = register("golden_tool_grip", new GoldenToolGripToolModuleItem(new Item.Properties()));
    public static final Item NETHERITE_TOOL_GRIP = register("netherite_tool_grip", new NetheriteToolGripToolModuleItem(new Item.Properties().fireResistant()));
    public static final Item ZINC_TOOL_GRIP = register("zinc_tool_grip", new ZincToolGripToolModuleItem(new Item.Properties()));
    public static final Item BRASS_TOOL_GRIP = register("brass_tool_grip", new BrassToolGripToolModuleItem(new Item.Properties()));
    public static final Item DIAMOND_TOOL_GRIP = register("diamond_tool_grip", new DiamondToolGripToolModuleItem(new Item.Properties()));

    public static final Item WOODEN_SWORD_GUARD = register("wooden_sword_guard", new WoodenSwordGuardToolModuleItem(new Item.Properties()));
    public static final Item STONE_SWORD_GUARD = register("stone_sword_guard", new StoneSwordGuardToolModuleItem(new Item.Properties()));
    public static final Item IRON_SWORD_GUARD = register("iron_sword_guard", new IronSwordGuardToolModuleItem(new Item.Properties()));
    public static final Item COPPER_SWORD_GUARD = register("copper_sword_guard", new CopperSwordGuardToolModuleItem(new Item.Properties()));
    public static final Item GOLDEN_SWORD_GUARD = register("golden_sword_guard", new GoldenSwordGuardToolModuleItem(new Item.Properties()));
    public static final Item NETHERITE_SWORD_GUARD = register("netherite_sword_guard", new NetheriteSwordGuardToolModuleItem(new Item.Properties().fireResistant()));
    public static final Item ZINC_SWORD_GUARD = register("zinc_sword_guard", new ZincSwordGuardToolModuleItem(new Item.Properties()));
    public static final Item BRASS_SWORD_GUARD = register("brass_sword_guard", new BrassSwordGuardToolModuleItem(new Item.Properties()));
    public static final Item DIAMOND_SWORD_GUARD = register("diamond_sword_guard", new DiamondSwordGuardToolModuleItem(new Item.Properties()));

    public static final Item WOODEN_SWORD_POMMEL = register("wooden_sword_pommel", new WoodenSwordPommelToolModuleItem(new Item.Properties()));
    public static final Item STONE_SWORD_POMMEL = register("stone_sword_pommel", new StoneSwordPommelToolModuleItem(new Item.Properties()));
    public static final Item IRON_SWORD_POMMEL = register("iron_sword_pommel", new IronSwordPommelToolModuleItem(new Item.Properties()));
    public static final Item COPPER_SWORD_POMMEL = register("copper_sword_pommel", new CopperSwordPommelToolModuleItem(new Item.Properties()));
    public static final Item GOLDEN_SWORD_POMMEL = register("golden_sword_pommel", new GoldenSwordPommelToolModuleItem(new Item.Properties()));
    public static final Item NETHERITE_SWORD_POMMEL = register("netherite_sword_pommel", new NetheriteSwordPommelToolModuleItem(new Item.Properties().fireResistant()));
    public static final Item ZINC_SWORD_POMMEL = register("zinc_sword_pommel", new ZincSwordPommelToolModuleItem(new Item.Properties()));
    public static final Item BRASS_SWORD_POMMEL = register("brass_sword_pommel", new BrassSwordPommelToolModuleItem(new Item.Properties()));
    public static final Item DIAMOND_SWORD_POMMEL = register("diamond_sword_pommel", new DiamondSwordPommelToolModuleItem(new Item.Properties()));

    private static Item register(String path, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, CreateModularTools.asResource(path), item);
    }

    public static void init() {
    }
}
