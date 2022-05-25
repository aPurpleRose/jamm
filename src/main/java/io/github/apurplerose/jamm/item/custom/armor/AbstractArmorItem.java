package io.github.apurplerose.jamm.item.custom.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;

public abstract class AbstractArmorItem extends ArmorItem {

        public AbstractArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
                super(material, slot, settings);
        }

        public abstract int missingMagic(ItemStack item);
        public abstract void addMagic(ItemStack item, int magic);


        protected abstract void evaluateArmorEffects(PlayerEntity player);

        protected boolean hasFullSet(PlayerEntity player) {
                ItemStack boots = player.getInventory().getArmorStack(0);
                ItemStack leggings = player.getInventory().getArmorStack(1);
                ItemStack chestplate = player.getInventory().getArmorStack(2);
                ItemStack helmet = player.getInventory().getArmorStack(3);

                return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
        }

        protected boolean hasCorrectSet(ArmorMaterial material, ArmorMaterial material2, PlayerEntity player) {
                ArmorItem boots = ((ArmorItem)player.getInventory().getArmorStack(0).getItem());
                ArmorItem leggings = ((ArmorItem)player.getInventory().getArmorStack(1).getItem());
                ArmorItem chestplate = ((ArmorItem)player.getInventory().getArmorStack(2).getItem());
                ArmorItem helmet = ((ArmorItem)player.getInventory().getArmorStack(3).getItem());

                return helmet.getMaterial() == material2 && chestplate.getMaterial() == material
                        && leggings.getMaterial() == material2 && boots.getMaterial() == material2;
        }

        protected abstract void addStatusEffect(PlayerEntity player, StatusEffectInstance effect);

}
