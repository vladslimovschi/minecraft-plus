package com.trouble.minecraftplus.util;

import com.trouble.minecraftplus.Mineplus;
import com.trouble.minecraftplus.enchantments.*;
import com.trouble.minecraftplus.items.SuperArmor;
import com.trouble.minecraftplus.items.SuperSword;
import com.trouble.minecraftplus.items.TreeCapitator;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RegistryHandler {
    public static DeferredRegister<Item> ITEMS= DeferredRegister.create(ForgeRegistries.ITEMS, Mineplus.MODID);
    public static DeferredRegister<Enchantment> ENCHANTS= DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Mineplus.MODID);
    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENCHANTS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    public static final RegistryObject<SwordItem> SUPER_SWORD = ITEMS.register("super_sword", () ->
            new SuperSword(ModItemTier.SUPER, 12, 11.0f, new Item.Properties()));
    public static final RegistryObject<AxeItem> TREECAPITATOR = ITEMS.register("treecapitator",
            ()-> new TreeCapitator(ModItemTier.SUPER, 7, 5.0f, new Item.Properties()));
    public static final RegistryObject<Enchantment> THUNERBOLT = ENCHANTS.register("thunderbolt",
            () ->new ThunderboltEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
    public static final RegistryObject<Enchantment> TOXIC_RETALIATION = ENCHANTS.register("toxic_retaliation",
            () ->new ToxicRetaliation(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.ARMOR,
                    new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET}));
    public static final RegistryObject<Enchantment> DRACULA = ENCHANTS.register("dracula",
            ()-> new DraculaEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
    public static final RegistryObject<Enchantment> LONG_LIFE = ENCHANTS.register("long_life",
            ()-> new LongLifeEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.ARMOR_CHEST, EquipmentSlot.CHEST));
    public static final RegistryObject<Enchantment> TERMINATOR = ENCHANTS.register("terminator",
            ()-> new TerminatorEnchantment(Enchantment.Rarity.RARE, EnchantmentCategory.ARMOR_LEGS, EquipmentSlot.CHEST));
    public static final RegistryObject<Enchantment> VELOCITY = ENCHANTS.register("velocity",
            ()-> new VelocityEnchantment(Enchantment.Rarity.RARE, EnchantmentCategory.ARMOR_FEET, EquipmentSlot.FEET));

    public static final RegistryObject<Item> SUPER_HELMET = ITEMS.register("super_helmet",
            () -> new SuperArmor(ModArmorTier.SUPER, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> SUPER_CHESTPLATE = ITEMS.register("super_chestplate",
            () -> new SuperArmor(ModArmorTier.SUPER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> SUPER_LEGGINGS = ITEMS.register("super_leggings",
            () -> new SuperArmor(ModArmorTier.SUPER, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> SUPER_BOOTS = ITEMS.register("super_boots",
            ()-> new SuperArmor(ModArmorTier.SUPER, ArmorItem.Type.BOOTS, new Item.Properties()));
 }
