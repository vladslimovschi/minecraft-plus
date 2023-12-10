package com.trouble.minecraftplus.enchantments;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.jetbrains.annotations.NotNull;

public class ToxicRetaliation extends Enchantment {
    public ToxicRetaliation(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot[] pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }


    @Override
    public void doPostHurt(@NotNull LivingEntity user, @NotNull Entity attacker, int level) {
        if (attacker instanceof LivingEntity) {
            ((LivingEntity)attacker).forceAddEffect(new MobEffectInstance(MobEffects.POISON, 20*(level+1), level), user);
        }
    }
//    public void doPostHurt(@NotNull LivingEntity pTarget, @NotNull Entity pAttacker, int pLevel) {
//        if (pAttacker instanceof LivingEntity){
//            ((LivingEntity)pAttacker).forceAddEffect(new MobEffectInstance(MobEffects.POISON, 20*getMaxLevel()), pAttacker);
//        }
//        super.doPostHurt(pTarget, pAttacker, pLevel);
//
//    }

    @Override
    public int getMaxLevel() {
        return 10;
    }
}
