package net.zlt.create_modular_tools.tool.module;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.minecraft.network.chat.Component;

@SuppressWarnings("UnstableApiUsage")
public final class AllToolModuleTypes {
    private AllToolModuleTypes() {
    }

    public static final ToolModuleType SWORD_BLADE = ToolModuleTypeRegistry.register(new ToolModuleType(Component.translatable("tool_module_type.create_modular_tools.sword_blade"), "SwordBlade", 1, FluidConstants.INGOT * 2 - FluidConstants.NUGGET - FluidConstants.INGOT / 2));
    public static final ToolModuleType SHOVEL_HEAD = ToolModuleTypeRegistry.register(new ToolModuleType(Component.translatable("tool_module_type.create_modular_tools.shovel_head"), "ShovelHead", 1, FluidConstants.INGOT));
    public static final ToolModuleType PICKAXE_HEAD = ToolModuleTypeRegistry.register(new ToolModuleType(Component.translatable("tool_module_type.create_modular_tools.pickaxe_head"), "PickaxeHead", 1, FluidConstants.INGOT * 3));
    public static final ToolModuleType AXE_HEAD = ToolModuleTypeRegistry.register(new ToolModuleType(Component.translatable("tool_module_type.create_modular_tools.axe_head"), "AxeHead", 1, FluidConstants.INGOT * 3));
    public static final ToolModuleType HOE_HEAD = ToolModuleTypeRegistry.register(new ToolModuleType(Component.translatable("tool_module_type.create_modular_tools.hoe_head"), "HoeHead", 1, FluidConstants.INGOT * 2));
    public static final ToolModuleType TOOL_HANDLE = ToolModuleTypeRegistry.register(new ToolModuleType(Component.translatable("tool_module_type.create_modular_tools.tool_handle"), "ToolHandle", 0, FluidConstants.INGOT));
    public static final ToolModuleType TOOL_GRIP = ToolModuleTypeRegistry.register(new ToolModuleType(Component.translatable("tool_module_type.create_modular_tools.tool_grip"), "ToolGrip", 1, FluidConstants.NUGGET));
    public static final ToolModuleType SWORD_GUARD = ToolModuleTypeRegistry.register(new ToolModuleType(Component.translatable("tool_module_type.create_modular_tools.sword_guard"), "SwordGuard", 2, FluidConstants.INGOT / 2));
    public static final ToolModuleType SWORD_POMMEL = ToolModuleTypeRegistry.register(new ToolModuleType(Component.translatable("tool_module_type.create_modular_tools.sword_pommel"), "SwordPommel", 1, FluidConstants.NUGGET));
    public static final ToolModuleType TOOL_WRAP = ToolModuleTypeRegistry.register(new ToolModuleType(Component.translatable("tool_module_type.create_modular_tools.tool_wrap"), "ToolWrap", 1, 0));

    public static void init() {
    }
}
