package net.zlt.create_modular_tools.tool.module;

import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.tool.module.axe_head.*;
import net.zlt.create_modular_tools.tool.module.tool_grip.*;
import net.zlt.create_modular_tools.tool.module.sword_guard.*;
import net.zlt.create_modular_tools.tool.module.tool_handle.*;
import net.zlt.create_modular_tools.tool.module.hoe_head.*;
import net.zlt.create_modular_tools.tool.module.pickaxe_head.*;
import net.zlt.create_modular_tools.tool.module.sword_pommel.*;
import net.zlt.create_modular_tools.tool.module.shovel_head.*;
import net.zlt.create_modular_tools.tool.module.sword_blade.*;

public final class AllToolModules {
    private AllToolModules() {
    }

    public static final ToolModule WOODEN_SWORD_BLADE = register("sword_blade/wood", new WoodenSwordBladeToolModule());
    public static final ToolModule STONE_SWORD_BLADE = register("sword_blade/stone", new StoneSwordBladeToolModule());
    public static final ToolModule IRON_SWORD_BLADE = register("sword_blade/iron", new IronSwordBladeToolModule());
    public static final ToolModule COPPER_SWORD_BLADE = register("sword_blade/copper", new CopperSwordBladeToolModule());
    public static final ToolModule GOLDEN_SWORD_BLADE = register("sword_blade/gold", new GoldenSwordBladeToolModule());
    public static final ToolModule NETHERITE_SWORD_BLADE = register("sword_blade/netherite", new NetheriteSwordBladeToolModule());
    public static final ToolModule ZINC_SWORD_BLADE = register("sword_blade/zinc", new ZincSwordBladeToolModule());
    public static final ToolModule BRASS_SWORD_BLADE = register("sword_blade/brass", new BrassSwordBladeToolModule());
    public static final ToolModule DIAMOND_SWORD_BLADE = register("sword_blade/diamond", new DiamondSwordBladeToolModule());

    public static final ToolModule WOODEN_SHOVEL_HEAD = register("shovel_head/wood", new WoodenShovelHeadToolModule());
    public static final ToolModule STONE_SHOVEL_HEAD = register("shovel_head/stone", new StoneShovelHeadToolModule());
    public static final ToolModule IRON_SHOVEL_HEAD = register("shovel_head/iron", new IronShovelHeadToolModule());
    public static final ToolModule COPPER_SHOVEL_HEAD = register("shovel_head/copper", new CopperShovelHeadToolModule());
    public static final ToolModule GOLDEN_SHOVEL_HEAD = register("shovel_head/gold", new GoldenShovelHeadToolModule());
    public static final ToolModule NETHERITE_SHOVEL_HEAD = register("shovel_head/netherite", new NetheriteShovelHeadToolModule());
    public static final ToolModule ZINC_SHOVEL_HEAD = register("shovel_head/zinc", new ZincShovelHeadToolModule());
    public static final ToolModule BRASS_SHOVEL_HEAD = register("shovel_head/brass", new BrassShovelHeadToolModule());
    public static final ToolModule DIAMOND_SHOVEL_HEAD = register("shovel_head/diamond", new DiamondShovelHeadToolModule());

    public static final ToolModule WOODEN_PICKAXE_HEAD = register("pickaxe_head/wood", new WoodenPickaxeHeadToolModule());
    public static final ToolModule STONE_PICKAXE_HEAD = register("pickaxe_head/stone", new StonePickaxeHeadToolModule());
    public static final ToolModule IRON_PICKAXE_HEAD = register("pickaxe_head/iron", new IronPickaxeHeadToolModule());
    public static final ToolModule COPPER_PICKAXE_HEAD = register("pickaxe_head/copper", new CopperPickaxeHeadToolModule());
    public static final ToolModule GOLDEN_PICKAXE_HEAD = register("pickaxe_head/gold", new GoldenPickaxeHeadToolModule());
    public static final ToolModule NETHERITE_PICKAXE_HEAD = register("pickaxe_head/netherite", new NetheritePickaxeHeadToolModule());
    public static final ToolModule ZINC_PICKAXE_HEAD = register("pickaxe_head/zinc", new ZincPickaxeHeadToolModule());
    public static final ToolModule BRASS_PICKAXE_HEAD = register("pickaxe_head/brass", new BrassPickaxeHeadToolModule());
    public static final ToolModule DIAMOND_PICKAXE_HEAD = register("pickaxe_head/diamond", new DiamondPickaxeHeadToolModule());

    public static final ToolModule WOODEN_AXE_HEAD = register("axe_head/wood", new WoodenAxeHeadToolModule());
    public static final ToolModule STONE_AXE_HEAD = register("axe_head/stone", new StoneAxeHeadToolModule());
    public static final ToolModule IRON_AXE_HEAD = register("axe_head/iron", new IronAxeHeadToolModule());
    public static final ToolModule COPPER_AXE_HEAD = register("axe_head/copper", new CopperAxeHeadToolModule());
    public static final ToolModule GOLDEN_AXE_HEAD = register("axe_head/gold", new GoldenAxeHeadToolModule());
    public static final ToolModule NETHERITE_AXE_HEAD = register("axe_head/netherite", new NetheriteAxeHeadToolModule());
    public static final ToolModule ZINC_AXE_HEAD = register("axe_head/zinc", new ZincAxeHeadToolModule());
    public static final ToolModule BRASS_AXE_HEAD = register("axe_head/brass", new BrassAxeHeadToolModule());
    public static final ToolModule DIAMOND_AXE_HEAD = register("axe_head/diamond", new DiamondAxeHeadToolModule());

    public static final ToolModule WOODEN_HOE_HEAD = register("hoe_head/wood", new WoodenHoeHeadToolModule());
    public static final ToolModule STONE_HOE_HEAD = register("hoe_head/stone", new StoneHoeHeadToolModule());
    public static final ToolModule IRON_HOE_HEAD = register("hoe_head/iron", new IronHoeHeadToolModule());
    public static final ToolModule COPPER_HOE_HEAD = register("hoe_head/copper", new CopperHoeHeadToolModule());
    public static final ToolModule GOLDEN_HOE_HEAD = register("hoe_head/gold", new GoldenHoeHeadToolModule());
    public static final ToolModule NETHERITE_HOE_HEAD = register("hoe_head/netherite", new NetheriteHoeHeadToolModule());
    public static final ToolModule ZINC_HOE_HEAD = register("hoe_head/zinc", new ZincHoeHeadToolModule());
    public static final ToolModule BRASS_HOE_HEAD = register("hoe_head/brass", new BrassHoeHeadToolModule());
    public static final ToolModule DIAMOND_HOE_HEAD = register("hoe_head/diamond", new DiamondHoeHeadToolModule());

    public static final ToolModule WOODEN_TOOL_HANDLE = register("tool_handle/wood", new WoodenToolHandleToolModule());
    public static final ToolModule STONE_TOOL_HANDLE = register("tool_handle/stone", new StoneToolHandleToolModule());
    public static final ToolModule IRON_TOOL_HANDLE = register("tool_handle/iron", new IronToolHandleToolModule());
    public static final ToolModule COPPER_TOOL_HANDLE = register("tool_handle/copper", new CopperToolHandleToolModule());
    public static final ToolModule GOLDEN_TOOL_HANDLE = register("tool_handle/gold", new GoldenToolHandleToolModule());
    public static final ToolModule NETHERITE_TOOL_HANDLE = register("tool_handle/netherite", new NetheriteToolHandleToolModule());
    public static final ToolModule ZINC_TOOL_HANDLE = register("tool_handle/zinc", new ZincToolHandleToolModule());
    public static final ToolModule BRASS_TOOL_HANDLE = register("tool_handle/brass", new BrassToolHandleToolModule());
    public static final ToolModule DIAMOND_TOOL_HANDLE = register("tool_handle/diamond", new DiamondToolHandleToolModule());

    public static final ToolModule WOODEN_TOOL_GRIP = register("tool_grip/wood", new WoodenToolGripToolModule());
    public static final ToolModule STONE_TOOL_GRIP = register("tool_grip/stone", new StoneToolGripToolModule());
    public static final ToolModule IRON_TOOL_GRIP = register("tool_grip/iron", new IronToolGripToolModule());
    public static final ToolModule COPPER_TOOL_GRIP = register("tool_grip/copper", new CopperToolGripToolModule());
    public static final ToolModule GOLDEN_TOOL_GRIP = register("tool_grip/gold", new GoldenToolGripToolModule());
    public static final ToolModule NETHERITE_TOOL_GRIP = register("tool_grip/netherite", new NetheriteToolGripToolModule());
    public static final ToolModule ZINC_TOOL_GRIP = register("tool_grip/zinc", new ZincToolGripToolModule());
    public static final ToolModule BRASS_TOOL_GRIP = register("tool_grip/brass", new BrassToolGripToolModule());
    public static final ToolModule DIAMOND_TOOL_GRIP = register("tool_grip/diamond", new DiamondToolGripToolModule());

    public static final ToolModule WOODEN_SWORD_GUARD = register("sword_guard/wood", new WoodenSwordGuardToolModule());
    public static final ToolModule STONE_SWORD_GUARD = register("sword_guard/stone", new StoneSwordGuardToolModule());
    public static final ToolModule IRON_SWORD_GUARD = register("sword_guard/iron", new IronSwordGuardToolModule());
    public static final ToolModule COPPER_SWORD_GUARD = register("sword_guard/copper", new CopperSwordGuardToolModule());
    public static final ToolModule GOLDEN_SWORD_GUARD = register("sword_guard/gold", new GoldenSwordGuardToolModule());
    public static final ToolModule NETHERITE_SWORD_GUARD = register("sword_guard/netherite", new NetheriteSwordGuardToolModule());
    public static final ToolModule ZINC_SWORD_GUARD = register("sword_guard/zinc", new ZincSwordGuardToolModule());
    public static final ToolModule BRASS_SWORD_GUARD = register("sword_guard/brass", new BrassSwordGuardToolModule());
    public static final ToolModule DIAMOND_SWORD_GUARD = register("sword_guard/diamond", new DiamondSwordGuardToolModule());

    public static final ToolModule WOODEN_SWORD_POMMEL = register("sword_pommel/wood", new WoodenSwordPommelToolModule());
    public static final ToolModule STONE_SWORD_POMMEL = register("sword_pommel/stone", new StoneSwordPommelToolModule());
    public static final ToolModule IRON_SWORD_POMMEL = register("sword_pommel/iron", new IronSwordPommelToolModule());
    public static final ToolModule COPPER_SWORD_POMMEL = register("sword_pommel/copper", new CopperSwordPommelToolModule());
    public static final ToolModule GOLDEN_SWORD_POMMEL = register("sword_pommel/gold", new GoldenSwordPommelToolModule());
    public static final ToolModule NETHERITE_SWORD_POMMEL = register("sword_pommel/netherite", new NetheriteSwordPommelToolModule());
    public static final ToolModule ZINC_SWORD_POMMEL = register("sword_pommel/zinc", new ZincSwordPommelToolModule());
    public static final ToolModule BRASS_SWORD_POMMEL = register("sword_pommel/brass", new BrassSwordPommelToolModule());
    public static final ToolModule DIAMOND_SWORD_POMMEL = register("sword_pommel/diamond", new DiamondSwordPommelToolModule());

    private static ToolModule register(String path, ToolModule toolModule) {
        return ToolModuleRegistry.register(CreateModularTools.asResource(path), toolModule);
    }
    
    public static void init() {
    }
}
