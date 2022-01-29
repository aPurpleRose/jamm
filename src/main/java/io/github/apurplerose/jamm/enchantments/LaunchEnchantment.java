package io.github.apurplerose.jamm.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class LaunchEnchantment extends Enchantment {

        protected LaunchEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
                super(weight, type, slotTypes);
        }

        @Override
        public int getMaxLevel() {
                return 2;
        }

        @Override
        public void onTargetDamaged(LivingEntity user, Entity target, int level) {
                if(!user.world.isClient()) {
                        if(level == 1) {
                                target.addVelocity(0, .5, 0);
                        }
                        if(level == 2) {
                                target.addVelocity(0, .7, 0);
                        }
                }

                super.onTargetDamaged(user, target, level);
        }
}
