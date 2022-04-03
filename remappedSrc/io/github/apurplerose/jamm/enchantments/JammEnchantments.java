package io.github.apurplerose.jamm.enchantments;

import io.github.apurplerose.jamm.Jamm;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class JammEnchantments {

        public static final Enchantment LIGHTNING_STRIKER = new LightningStrikerEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON,
                EquipmentSlot.MAINHAND);
        public static final Enchantment LAUNCH = new LaunchEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON,
                EquipmentSlot.MAINHAND);


        private static Enchantment register(String name, Enchantment enchantment){
                return Registry.register(Registry.ENCHANTMENT, new Identifier(Jamm.MOD_ID, name), enchantment);
        }

        public static void registerEnchantments() {
                System.out.println("Registering ModEnchantments for "+ Jamm.MOD_ID);

                register("lightning_striker", LIGHTNING_STRIKER);
                register("launch", LAUNCH);
        }
}
