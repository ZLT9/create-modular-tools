package net.zlt.create_modular_tools.container.menu;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.zlt.create_modular_tools.CreateModularTools;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class AllMenuTypes {
    private AllMenuTypes() {
    }

    public static final MenuType<CreativeModularToolTableMenu> CREATIVE_MODULAR_TOOL_TABLE = register("creative_modular_tool_table", CreativeModularToolTableMenu::new);

    private static <T extends AbstractContainerMenu> MenuType<T> register(String path, MenuType.MenuSupplier<T> constructor) {
        return Registry.register(BuiltInRegistries.MENU, CreateModularTools.asResource(path), new MenuType<>(constructor, FeatureFlags.VANILLA_SET));
    }

    public static void init() {
    }
}
