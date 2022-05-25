package io.github.apurplerose.jamm.potion;

import io.github.apurplerose.jamm.Jamm;
import io.github.apurplerose.jamm.effect.JammEffects;
import io.github.apurplerose.jamm.mixin.BrewingRecipeRegistryMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class JammPotions {

        public static final Potion FREEZE_POTION = new Potion(new StatusEffectInstance(JammEffects.FREEZE, 200, 0));
        public static final Potion RANDOM_TELEPORT_POTION = new Potion(new StatusEffectInstance(JammEffects.RANDOM_TELEPORT));


        private static Potion register(String name, Potion potion) {
                return Registry.register(Registry.POTION, new Identifier(Jamm.MOD_ID, name), potion);
        }

        public static void registerPotions() {
                register("freeze_potion", FREEZE_POTION);
                register("random_teleport_potion", RANDOM_TELEPORT_POTION);

                registerPotionRecipes(Potions.AWKWARD, Items.ICE, JammPotions.FREEZE_POTION);
                registerPotionRecipes(Potions.AWKWARD, Items.ENDER_PEARL, JammPotions.RANDOM_TELEPORT_POTION);
        }

        private static void registerPotionRecipes(Potion input, Item ingredient, Potion output) {
                BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(input, ingredient, output);
        }

}
