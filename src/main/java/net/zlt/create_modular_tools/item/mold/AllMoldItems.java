package net.zlt.create_modular_tools.item.mold;

import com.simibubi.create.AllItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;

public final class AllMoldItems {
    private AllMoldItems() {
    }

    public static final Item SAND_MOLD = register("sand_mold", new BlockItem(AllMoldBlocks.SAND_MOLD, new Item.Properties()));

    public static final Item SWORD_SAND_MOLD = register("sword_sand_mold", new SwordSandMoldItem(AllMoldBlocks.SWORD_SAND_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item SHOVEL_SAND_MOLD = register("shovel_sand_mold", new ShovelSandMoldItem(AllMoldBlocks.SHOVEL_SAND_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item PICKAXE_SAND_MOLD = register("pickaxe_sand_mold", new PickaxeSandMoldItem(AllMoldBlocks.PICKAXE_SAND_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item AXE_SAND_MOLD = register("axe_sand_mold", new AxeSandMoldItem(AllMoldBlocks.AXE_SAND_MOLD, new Item.Properties().stacksTo(1)));
    public static final Item HOE_SAND_MOLD = register("hoe_sand_mold", new HoeSandMoldItem(AllMoldBlocks.HOE_SAND_MOLD, new Item.Properties().stacksTo(1)));

    private static Item register(String path, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, CreateModularTools.asResource(path), item);
    }

    public static void init() {
    }
}
