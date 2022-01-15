package io.github.apurplerose.jamm.item.custom.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;

public abstract class AbstractArmorItem extends ArmorItem {

        //static StatusEffect[] AMETHYST_EFFECT = new StatusEffect[]{StatusEffects.JUMP_BOOST, StatusEffects.SPEED};

        /*private static ImmutableMap<ArmorMaterial, StatusEffect[]> MATERIAL_TO_EFFECT_MAP; =
                (new ImmutableMap.Builder<ArmorMaterial, StatusEffect[]>())
                        .put(JammArmorMaterial.AMETHYST, AMETHYST_EFFECT).build();*/

        public AbstractArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
                super(material, slot, settings);
        }

        
        //private int MAX_MAGIC;
        //private int magic;
        public abstract int missingMagic();
        public abstract void addMagic(int magic);


        protected abstract void evaluateArmorEffects(PlayerEntity player);
        /*protected void evaluateArmorEffects(PlayerEntity player) {
                for (Map.Entry<ArmorMaterial, StatusEffect[]> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
                        ArmorMaterial material = entry.getKey();
                        StatusEffect[] effects = entry.getValue();

                        if (hasCorrectSet(material, player)) {
                                for (StatusEffect effect : effects) {
                                        addStatusEffect(player, effect);
                                }
                        }
                }
        }*/

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

        protected abstract void addStatusEffect(PlayerEntity player, StatusEffect effect);

}
