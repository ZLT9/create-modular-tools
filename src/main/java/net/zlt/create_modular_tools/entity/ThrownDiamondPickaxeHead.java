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
public class ThrownDiamondPickaxeHead extends ThrownBoomerang {
    public ThrownDiamondPickaxeHead(EntityType<? extends ThrownBoomerang> entityType, Level level) {
        super(AllToolModules.DIAMOND_PICKAXE_HEAD, AllItems.DIAMOND_PICKAXE_HEAD, entityType, level);
    }

    public ThrownDiamondPickaxeHead(Level level, LivingEntity shooter, ItemStack stack) {
        super(AllToolModules.DIAMOND_PICKAXE_HEAD, AllEntityTypes.DIAMOND_PICKAXE_HEAD, level, shooter, stack);
    }

    @Override
    protected float getAttackDamage() {
        return AllToolModules.DIAMOND_PICKAXE_HEAD.getAttackDamage();
    }
}
