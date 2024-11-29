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
public class ThrownMangrovePickaxeHead extends ThrownBoomerang {
    public ThrownMangrovePickaxeHead(EntityType<? extends ThrownBoomerang> entityType, Level level) {
        super(AllToolModules.MANGROVE_PICKAXE_HEAD, AllItems.MANGROVE_PICKAXE_HEAD, entityType, level);
    }

    public ThrownMangrovePickaxeHead(Level level, LivingEntity shooter, ItemStack stack) {
        super(AllToolModules.MANGROVE_PICKAXE_HEAD, AllEntityTypes.MANGROVE_PICKAXE_HEAD, level, shooter, stack);
    }

    @Override
    protected float getAttackDamage() {
        return AllToolModules.MANGROVE_PICKAXE_HEAD.getAttackDamageWhenAttached();
    }
}
