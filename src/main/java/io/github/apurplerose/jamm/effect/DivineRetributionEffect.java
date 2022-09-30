package io.github.apurplerose.jamm.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;

public class DivineRetributionEffect extends StatusEffect {

        public DivineRetributionEffect(StatusEffectCategory category, int color) {
                super(category, color);
        }


        @Override
        public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
                if (amplifier > 2) {
                        entity.addStatusEffect(new StatusEffectInstance(JammEffects.IMMINENT_DEATH, 24000));
                }

                super.onApplied(entity, attributes, amplifier);
        }

        @Override
        public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {

                super.onRemoved(entity, attributes, amplifier);
        }

        @Override
        public void applyUpdateEffect(LivingEntity entity, int amplifier) {



                super.applyUpdateEffect(entity, amplifier);
        }

        @Override
        public boolean canApplyUpdateEffect(int duration, int amplifier) {
                return true;
        }
}
