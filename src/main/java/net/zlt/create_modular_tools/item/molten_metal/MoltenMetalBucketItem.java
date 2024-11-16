package net.zlt.create_modular_tools.item.molten_metal;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.level.material.Fluid;

public class MoltenMetalBucketItem extends BucketItem {
    public MoltenMetalBucketItem(Fluid content, Properties properties) {
        super(content, properties);
        FuelRegistry.INSTANCE.add(this, (int) Short.MAX_VALUE);
    }
}
