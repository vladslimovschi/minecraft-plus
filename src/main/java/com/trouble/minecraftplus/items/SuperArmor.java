package com.trouble.minecraftplus.items;

import com.trouble.minecraftplus.util.RegistryHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class SuperArmor extends ArmorItem {
    public SuperArmor(ArmorMaterial p_40386_, Type p_266831_, Properties p_40388_) {
        super(p_40386_, p_266831_, p_40388_);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> pTooltipComponents,
                                @NotNull TooltipFlag pIsAdvanced) {
        if (pStack.is(RegistryHandler.SUPER_CHESTPLATE.get())){
            pTooltipComponents.add(Component.literal("This piece of armor grants you projectile immunity"));
        }
        if (pStack.is(RegistryHandler.SUPER_LEGGINGS.get())){
            pTooltipComponents.add(Component.literal("This piece of armor grants you lava immunity"));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

}
