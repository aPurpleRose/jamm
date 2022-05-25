package io.github.apurplerose.jamm.effect;

import io.github.apurplerose.jamm.Jamm;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class JammEffects  {

        public static StatusEffect FREEZE = new FreezeEffect(StatusEffectCategory.HARMFUL, 4375295);
        public static StatusEffect RANDOM_TELEPORT = new RandomTeleportationEffect(StatusEffectCategory.HARMFUL, 4375295);


        public static StatusEffect register(String name, StatusEffect effect) {
                return Registry.register(Registry.STATUS_EFFECT, new Identifier(Jamm.MOD_ID, name), effect);
        }

        public static void registerEffects() {
                register("freeze", FREEZE);
                register("random_teleport", RANDOM_TELEPORT);
        }

}
