package io.github.apurplerose.jamm.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class LightningStrikerEnchantment extends Enchantment {

        protected LightningStrikerEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
                super(weight, type, slotTypes);
        }

        @Override
        public int getMaxLevel() {
                return 2;
        }

        @Override
        public void onTargetDamaged(LivingEntity user, Entity target, int level) {
                if(!user.world.isClient()) {
                        ServerWorld world = (ServerWorld)user.world;
                        PlayerEntity player = (PlayerEntity)user;
                        BlockPos pos = target.getBlockPos();

                        if(level == 1) {
                                EntityType.LIGHTNING_BOLT.spawn(world, null, null, player, pos,
                                        SpawnReason.TRIGGERED, true, true);
                        }

                        if(level == 2) {
                                EntityType.LIGHTNING_BOLT.spawn(world, null, null, player, pos,
                                        SpawnReason.TRIGGERED, true, true);

                                EntityType.LIGHTNING_BOLT.spawn(world, null, null, player, pos,
                                        SpawnReason.TRIGGERED, true, true);
                        }
                }

                super.onTargetDamaged(user, target, level);
        }

        @Override
        public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
                if (!user.world.isClient()) {
                        ServerWorld world = (ServerWorld) user.world;
                        PlayerEntity player = (PlayerEntity) user;
                        BlockPos pos = attacker.getBlockPos();

                        if (level == 1) {
                                EntityType.LIGHTNING_BOLT.spawn(world, null, null, player, pos,
                                        SpawnReason.TRIGGERED, true, true);
                        }

                        if (level == 2) {
                                EntityType.LIGHTNING_BOLT.spawn(world, null, null, player, pos,
                                        SpawnReason.TRIGGERED, true, true);

                                EntityType.LIGHTNING_BOLT.spawn(world, null, null, player, pos,
                                        SpawnReason.TRIGGERED, true, true);
                        }
                }

                super.onUserDamaged(user, attacker, level);
        }
}
