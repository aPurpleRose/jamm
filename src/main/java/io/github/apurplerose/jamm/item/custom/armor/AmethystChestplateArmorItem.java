package io.github.apurplerose.jamm.item.custom.armor;

import com.google.common.collect.ImmutableMap;
import io.github.apurplerose.jamm.item.JammArmorMaterial;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
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

public class AmethystChestplateArmorItem extends AbstractArmorItem {

        private final ImmutableMap<ArmorMaterial, StatusEffectInstance[]> MATERIAL_TO_EFFECT_MAP;
        private final int MAX_MAGIC = 200;
        private final ArmorMaterial restOfArmor = JammArmorMaterial.AMETHYST;


        public AmethystChestplateArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings, StatusEffectInstance... effects) {
                super(material, slot, settings);
                NbtCompound nbtData = new NbtCompound();
                nbtData.putInt("magic", 0);
                MATERIAL_TO_EFFECT_MAP = (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance[]>()).put(material, effects).build();
        }

        @Override
        public void addMagic(ItemStack item, int magic) {
                NbtCompound nbtData = item.getNbt();
                nbtData.putInt("magic", nbtData.getInt("magic") + magic);
                item.setNbt(nbtData);
        }

        @Override
        public boolean hasRecipeRemainder() {
                return super.hasRecipeRemainder();
        }

        @Override
        public int missingMagic(ItemStack item) {
                NbtCompound nbtData = item.getNbt();
                return MAX_MAGIC - nbtData.getInt("magic");
        }

        public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                tooltip.add(new TranslatableText("tooltip_1.item.jamm.amethyst_chestplate")
                        .formatted(Formatting.ITALIC, Formatting.LIGHT_PURPLE));
                tooltip.add(new TranslatableText("tooltip_2.item.jamm.amethyst_chestplate", stack.getNbt().getInt("magic"), MAX_MAGIC).
                        formatted(Formatting.ITALIC, Formatting.LIGHT_PURPLE));
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

        protected void evaluateArmorEffects(PlayerEntity player) {
                for (Map.Entry<ArmorMaterial, StatusEffectInstance[]> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
                        ArmorMaterial material = entry.getKey();
                        StatusEffectInstance[] effects = entry.getValue();

                        if (hasCorrectSet(material, restOfArmor, player)) {
                                for (StatusEffectInstance effect : effects) {
                                        addStatusEffect(player, effect);
                                }
                        }
                }
        }

        protected void addStatusEffect(PlayerEntity player, StatusEffectInstance effect) {
                boolean hasPlayerEffect = player.hasStatusEffect(effect.getEffectType());

                if (!hasPlayerEffect) {
                        ItemStack chestplate = player.getInventory().getArmorStack(2);
                        NbtCompound nbtData = chestplate.getNbt();
                        int magic = nbtData.getInt("magic");
                        if (magic > 0) {
                                player.addStatusEffect(new StatusEffectInstance(effect));
                                nbtData.putInt("magic", magic - 1);
                                chestplate.setNbt(nbtData);
                        }
                }
        }
}
