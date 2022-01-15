package io.github.apurplerose.jamm.item.custom.armor;

import com.google.common.collect.ImmutableMap;
import io.github.apurplerose.jamm.item.JammArmorMaterial;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class DarkAmethystChestplateArmorItem extends AbstractArmorItem {

        private ImmutableMap<ArmorMaterial, StatusEffect[]> MATERIAL_TO_EFFECT_MAP;
        private final int MAX_MAGIC = 100;
        private int magic;
        private ArmorMaterial restOfArmor = JammArmorMaterial.DARK_AMETHYST;


        public DarkAmethystChestplateArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings, StatusEffect[] effects) {
                super(material, slot, settings);
                magic = 0;
                MATERIAL_TO_EFFECT_MAP = (new ImmutableMap.Builder<ArmorMaterial, StatusEffect[]>())
                                .put(material, effects).build();
        }

        @Override
        public int missingMagic() {
                return MAX_MAGIC - magic;
        }

        @Override
        public void addMagic(int magic) {
                this.magic += magic;
        }

        public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                tooltip.add(new TranslatableText("item.jamm.amethyst_chestplate.tooltip_1").formatted(Formatting.ITALIC, Formatting.LIGHT_PURPLE));
                tooltip.add(new TranslatableText("item.jamm.amethyst_chestplate.tooltip_2", magic, MAX_MAGIC).formatted(Formatting.ITALIC, Formatting.LIGHT_PURPLE));
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

        //@Override
        protected void evaluateArmorEffects(PlayerEntity player) {
                for (Map.Entry<ArmorMaterial, StatusEffect[]> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
                        ArmorMaterial material = entry.getKey();
                        StatusEffect[] effects = entry.getValue();

                        if (hasCorrectSet(material, restOfArmor, player)) {
                                for (StatusEffect effect : effects) {
                                        addStatusEffect(player, effect);
                                }
                        }
                }
        }

        //@Override
        protected void addStatusEffect(PlayerEntity player, StatusEffect effect) {
                boolean hasPlayerEffect = player.hasStatusEffect(effect);

                if (!hasPlayerEffect) {
                        if (magic > 0) {
                                player.addStatusEffect(new StatusEffectInstance(effect, 200));
                                magic -= 1;
                        }
                }
        }
}
