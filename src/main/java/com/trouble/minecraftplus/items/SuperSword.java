package com.trouble.minecraftplus.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SuperSword extends SwordItem {
    public SuperSword(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }
    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level worldIn,
                                List<Component> tooltip, @NotNull TooltipFlag flagIn) {
        tooltip.add(Component.literal("Teleports you where you're looking").withStyle(ChatFormatting.DARK_AQUA));

        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel,
                                                           @NotNull Player pPlayer, @NotNull InteractionHand pUsedHand) {
        pPlayer.move(MoverType.PLAYER, pPlayer.getLookAngle().scale(14));
        pPlayer.playSound(SoundEvents.ENDERMAN_TELEPORT);
        return super.use(pLevel, pPlayer, pUsedHand);
    }

}

