package io.github.apurplerose.jamm.effect;

import io.github.apurplerose.jamm.Jamm;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class JammEffects  {

        public static StatusEffect DIVINE_RETRIBUTION = new DivineRetributionEffect(StatusEffectCategory.HARMFUL, 6447714);
        public static StatusEffect FREEZE = new FreezeEffect(StatusEffectCategory.HARMFUL, 4375295);
        public static StatusEffect IMMINENT_DEATH = new ImminentDeathEffect(StatusEffectCategory.HARMFUL, 3031123);
        public static StatusEffect RANDOM_TELEPORT = new RandomTeleportationEffect(StatusEffectCategory.HARMFUL, 3031123);


        public static StatusEffect register(String name, StatusEffect effect) {
                return Registry.register(Registry.STATUS_EFFECT, new Identifier(Jamm.MOD_ID, name), effect);
        }

        public static void registerEffects() {
                register("divine_retribution", DIVINE_RETRIBUTION);
                register("freeze", FREEZE);
                register("imminent_death", IMMINENT_DEATH);
                register("random_teleport", RANDOM_TELEPORT);
        }

}
