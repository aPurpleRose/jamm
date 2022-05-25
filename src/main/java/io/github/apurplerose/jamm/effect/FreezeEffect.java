package io.github.apurplerose.jamm.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class FreezeEffect extends StatusEffect {

        public FreezeEffect(StatusEffectCategory category, int color) {
                super(category, color);
        }

        @Override
        public void applyUpdateEffect(LivingEntity entity, int amplifier) {
                if (!entity.world.isClient()) {
                        double x = entity.getX();
                        double y = entity.getY();
                        double z = entity.getZ();

                        entity.setVelocity(0, 0, 0);
                        entity.teleport(x, y, z);

                        //entity.setPos(x, y, z);
                }

                super.applyUpdateEffect(entity, amplifier);
        }

        @Override
        public boolean canApplyUpdateEffect(int duration, int amplifier) {
                return true;
        }
}
