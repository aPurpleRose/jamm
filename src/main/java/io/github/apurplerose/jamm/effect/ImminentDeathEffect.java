package io.github.apurplerose.jamm.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class ImminentDeathEffect extends StatusEffect {

        public ImminentDeathEffect(StatusEffectCategory category, int color) {
                super(category, color);
        }

        @Override
        public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
                entity.kill();
                super.onRemoved(entity, attributes, amplifier);
        }
}
