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
public class ThrownIronPickaxeHead extends ThrownBoomerang {
    public ThrownIronPickaxeHead(EntityType<? extends ThrownBoomerang> entityType, Level level) {
        super(AllToolModules.IRON_PICKAXE_HEAD, AllItems.IRON_PICKAXE_HEAD, entityType, level);
    }

    public ThrownIronPickaxeHead(Level level, LivingEntity shooter, ItemStack stack) {
        super(AllToolModules.IRON_PICKAXE_HEAD, AllEntityTypes.IRON_PICKAXE_HEAD, level, shooter, stack);
    }

    @Override
    protected float getAttackDamage() {
        return AllToolModules.IRON_PICKAXE_HEAD.getAttackDamageWhenAttached();
    }
}
