package com.trouble.minecraftplus.util;

import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.trouble.minecraftplus.Mineplus.MODID;

@Mod.EventBusSubscriber(modid =MODID, bus=Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModEventHandler {


    @SubscribeEvent
    public static void FallEvent(LivingFallEvent event){
        if (!(event.getEntity() instanceof Player player)) return;
        //Check if the damage should be removed
        if (player.getItemBySlot(EquipmentSlot.FEET).is(RegistryHandler.SUPER_BOOTS.get())){
        event.setDistance(0F);
        }
    }

    @SubscribeEvent
    public static void onLavaDamage(LivingDamageEvent event){
        if (!(event.getEntity() instanceof Player player)) return;
        if (event.getSource().is(DamageTypes.LAVA) && player.getItemBySlot(EquipmentSlot.LEGS).is(
                RegistryHandler.SUPER_LEGGINGS.get())){
            event.setAmount(0);
        }
    }

    @SubscribeEvent
    public static void onEquipmentChange(LivingEquipmentChangeEvent event) {
        if (!(event.getEntity()  instanceof Player player)) return;
        var chestplate = player.getItemBySlot(EquipmentSlot.CHEST);
        var leggings = player.getItemBySlot(EquipmentSlot.LEGS);
        var boots = player.getItemBySlot(EquipmentSlot.FEET);
        var enchants_chestplate = chestplate.getAllEnchantments();
        var enchants_leggings=leggings.getAllEnchantments();
        var enchants_boots = boots.getAllEnchantments();

        if ((enchants_chestplate.containsKey(RegistryHandler.LONG_LIFE.get()))) {
                        Objects.requireNonNull(player.getAttribute(Attributes.MAX_HEALTH)).setBaseValue(
                            20+enchants_chestplate.get(RegistryHandler.LONG_LIFE.get())*4
                        );
        } else {
            Objects.requireNonNull(player.getAttribute(Attributes.MAX_HEALTH)).setBaseValue(20);
        }
        if (enchants_leggings.containsKey(RegistryHandler.TERMINATOR.get())) {
            Objects.requireNonNull(player.getAttribute(Attributes.ATTACK_DAMAGE)).setBaseValue(1+0.2*enchants_leggings.
                    get(RegistryHandler.TERMINATOR.get()));
        } else {
            Objects.requireNonNull(player.getAttribute(Attributes.ATTACK_DAMAGE)).setBaseValue(1);
        }
        if (enchants_boots.containsKey(RegistryHandler.VELOCITY.get())){
            Objects.requireNonNull(player.getAttribute(Attributes.MOVEMENT_SPEED)).setBaseValue(0.1+ (double) enchants_boots
                    .get(RegistryHandler.VELOCITY.get()) /15);
        } else {
            Objects.requireNonNull(player.getAttribute(Attributes.MOVEMENT_SPEED)).setBaseValue(0.1);
        }
    }
}
