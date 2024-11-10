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
public class ThrownGoldenPickaxeHead extends ThrownBoomerang {
    public ThrownGoldenPickaxeHead(EntityType<? extends ThrownBoomerang> entityType, Level level) {
        super(AllToolModules.GOLDEN_PICKAXE_HEAD, AllItems.GOLDEN_PICKAXE_HEAD, entityType, level);
    }

    public ThrownGoldenPickaxeHead(Level level, LivingEntity shooter, ItemStack stack) {
        super(AllToolModules.GOLDEN_PICKAXE_HEAD, AllEntityTypes.GOLDEN_PICKAXE_HEAD, level, shooter, stack);
    }

    @Override
    protected float getAttackDamage() {
        return AllToolModules.GOLDEN_PICKAXE_HEAD.getAttackDamageWhenAttached();
    }
}
