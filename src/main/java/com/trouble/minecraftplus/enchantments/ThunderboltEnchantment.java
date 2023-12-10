package com.trouble.minecraftplus.enchantments;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.jetbrains.annotations.NotNull;

public class ThunderboltEnchantment extends Enchantment {
    public ThunderboltEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostAttack(@NotNull LivingEntity pAttacker, @NotNull Entity pTarget, int pLevel) {
        ServerLevel level=((ServerLevel) pAttacker.level());
        BlockPos pos=pTarget.blockPosition();
        for (int i=0; i<pLevel; i++){
            EntityType.LIGHTNING_BOLT.spawn(level, null, (Player) null, pos, MobSpawnType.TRIGGERED,
                    true, true);
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

}
