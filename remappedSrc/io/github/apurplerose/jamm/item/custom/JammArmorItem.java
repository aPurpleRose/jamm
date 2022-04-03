package io.github.apurplerose.jamm.item.custom;

import com.google.common.collect.ImmutableMap;
import io.github.apurplerose.jamm.item.JammArmorMaterial;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class JammArmorItem extends ArmorItem {

        static StatusEffect[] AMETHYST_EFFECT = new StatusEffect[]{StatusEffects.JUMP_BOOST, StatusEffects.SPEED};

        private static final ImmutableMap<ArmorMaterial, StatusEffect[]> MATERIAL_TO_EFFECT_MAP =
                (new ImmutableMap.Builder<ArmorMaterial, StatusEffect[]>())
                        .put(JammArmorMaterial.AMETHYST, AMETHYST_EFFECT).build();

        public JammArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
                super(material, slot, settings);
                magic = 0;
        }


        private final int MAX_MAGIC = 10;
        private int magic;
        public int missingMagic() {
                return MAX_MAGIC-magic;
        }
        public void addMagic(int magic) {
                this.magic += magic;
        }

        @Override
        public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                tooltip.add(new TranslatableText("item.jamm.amethyst_chestplate.tooltip_1").formatted(Formatting.ITALIC));
                tooltip.add(new TranslatableText("item.jamm.amethyst_chestplate.tooltip_2", magic, MAX_MAGIC).formatted(Formatting.ITALIC));
        }

        @Override
        public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
                if (!world.isClient()) {
                        if (entity instanceof PlayerEntity) {
                                PlayerEntity player = (PlayerEntity)entity;

                                if (hasFullSet(player)) {
                                        evaluateArmorEffects(player);
                                }
                        }
                }

                super.inventoryTick(stack, world, entity, slot, selected);
        }

        private void evaluateArmorEffects(PlayerEntity player) {
                for (Map.Entry<ArmorMaterial, StatusEffect[]> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
                        ArmorMaterial material = entry.getKey();
                        StatusEffect[] effects = entry.getValue();

                        if (hasCorrectSet(material, player)) {
                                for (StatusEffect effect : effects) {
                                        addStatusEffect(player, material, effect);
                                }
                        }
                }
        }

        private boolean hasFullSet(PlayerEntity player) {
                ItemStack boots = player.getInventory().getArmorStack(0);
                ItemStack leggings = player.getInventory().getArmorStack(1);
                ItemStack chestplate = player.getInventory().getArmorStack(2);
                ItemStack helmet = player.getInventory().getArmorStack(3);

                return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
        }

        private boolean hasCorrectSet(ArmorMaterial material, PlayerEntity player) {
                ArmorItem boots = ((ArmorItem)player.getInventory().getArmorStack(0).getItem());
                ArmorItem leggings = ((ArmorItem)player.getInventory().getArmorStack(1).getItem());
                ArmorItem chestplate = ((ArmorItem)player.getInventory().getArmorStack(2).getItem());
                ArmorItem helmet = ((ArmorItem)player.getInventory().getArmorStack(3).getItem());

                return helmet.getMaterial() == material && chestplate.getMaterial() == material
                        && leggings.getMaterial() == material && boots.getMaterial() == material;
        }

        private void addStatusEffect(PlayerEntity player, ArmorMaterial material, StatusEffect effect) {
                boolean hasPlayerEffect = player.hasStatusEffect(effect);

                if (!hasPlayerEffect) {
                        if (magic > 0) {
                                player.addStatusEffect(new StatusEffectInstance(effect, 200));
                                magic -= 1;
                        }
                }
        }

}
