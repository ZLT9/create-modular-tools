package net.zlt.create_modular_tools.entity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.zlt.create_modular_tools.item.AllItems;
import net.zlt.create_modular_tools.tool.module.AllToolModules;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ThrownCrimsonPickaxeHead extends ThrownBoomerang {
    public ThrownCrimsonPickaxeHead(EntityType<? extends ThrownBoomerang> entityType, Level level) {
        super(AllToolModules.CRIMSON_PICKAXE_HEAD, AllItems.CRIMSON_PICKAXE_HEAD, entityType, level);
    }

    public ThrownCrimsonPickaxeHead(Level level, LivingEntity shooter, ItemStack stack) {
        super(AllToolModules.CRIMSON_PICKAXE_HEAD, AllEntityTypes.CRIMSON_PICKAXE_HEAD, level, shooter, stack);
    }

    @Override
    protected float getAttackDamage() {
        return AllToolModules.CRIMSON_PICKAXE_HEAD.getAttackDamageWhenAttached();
    }
}
