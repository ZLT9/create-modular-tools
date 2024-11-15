package net.zlt.create_modular_tools.tool.module;

public final class AllToolModuleFeatures {
    private AllToolModuleFeatures() {
    }

    public static final String FIREPROOF = create("fireproof");
    public static final String WATERPROOF = create("waterproof");
    public static final String WRENCHING = create("wrenching");

    private static String create(String name) {
        return "feature.create_modular_tools." + name;
    }

    public static void init() {
    }
}
