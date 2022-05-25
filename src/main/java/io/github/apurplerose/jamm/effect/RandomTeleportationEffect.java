package io.github.apurplerose.jamm.effect;

import io.github.apurplerose.jamm.stat.JammStats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class RandomTeleportationEffect extends StatusEffect {
        // on level 1 teleports randomly once, applies nausea or blindness, gaining one of these effects becomes rarer the more you teleport (player statistics?)
        // on level 2 it teleports randomly multiple times

        public RandomTeleportationEffect(StatusEffectCategory category, int color) {
                super(category, color);
        }

        @Override
        public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
                /*if (target instanceof PlayerEntity) {

                }*/

                double bad = 0.8; // depends on a player stat
                double num = Math.random();
                if (num < bad/2) {
                        target.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 3));
                } else if (num <= bad) {
                        target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 60, 3));
                        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 60, 3));
                }

                Random r = new Random();
                double x = target.getX() + r.nextInt(-50, 51);
                double z = target.getZ() + r.nextInt(-50, 51);

                double y = 255;
                while (true) {
                        BlockPos pos = new BlockPos(x, y, z);
                        if (!target.getWorld().getBlockState(pos).isAir()) {
                             break;
                        }
                        --y;
                }

                target.teleport(x, y + 1, z);
                // height check in the future, so you don't land inside a block

                if (target instanceof PlayerEntity) {
                        ((PlayerEntity) target).incrementStat(JammStats.TELEPORTED);
                }
        }

        @Override
        public boolean isInstant() {
                return true;
        }
}
