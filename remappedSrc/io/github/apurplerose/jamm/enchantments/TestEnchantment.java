package io.github.apurplerose.jamm.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class TestEnchantment extends Enchantment {

        protected TestEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
                super(weight, type, slotTypes);
        }

        @Override
        public int getMaxLevel() {
                return 1;
        }

        @Override
        public void onTargetDamaged(LivingEntity user, Entity target, int level) {
                if(!user.world.isClient()) {

                }

                super.onTargetDamaged(user, target, level);
        }
}
