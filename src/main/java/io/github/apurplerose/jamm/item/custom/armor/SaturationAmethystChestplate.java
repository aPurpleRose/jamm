package io.github.apurplerose.jamm.item.custom.armor;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SaturationAmethystChestplate extends AbstractArmorItem {

        private final int MAX_MAGIC = 100;

        public SaturationAmethystChestplate(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
                super(material, slot, settings);
        }

        @Override
        public void addMagic(ItemStack item, int magic) {
                NbtCompound nbtData = item.getNbt();
                nbtData.putInt("magic", nbtData.getInt("magic") + magic);
                item.setNbt(nbtData);
        }

        @Override
        public int missingMagic(ItemStack item) {
                NbtCompound nbtData = item.getNbt();
                return MAX_MAGIC - nbtData.getInt("magic");
        }

        public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                tooltip.add(Text.translatable("tooltip_1.item.jamm.amethyst_chestplate")
                        .formatted(Formatting.ITALIC, Formatting.LIGHT_PURPLE));
                tooltip.add(Text.translatable("tooltip_2.item.jamm.amethyst_chestplate", stack.getNbt().getInt("magic"), MAX_MAGIC).
                        formatted(Formatting.ITALIC, Formatting.LIGHT_PURPLE));
        }

        @Override
        public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
                if (entity instanceof PlayerEntity) {
                        PlayerEntity player = (PlayerEntity)entity;

                        int food = player.getHungerManager().getFoodLevel();
                        float saturation = player.getHungerManager().getSaturationLevel();

                        if (!world.isClient()) {
                                if (food < 20 || saturation < 3) {
                                        ItemStack chestplate = player.getInventory().getArmorStack(2);
                                        NbtCompound nbtData = chestplate.getNbt();
                                        if (nbtData == null) return;
                                        int magic = nbtData.getInt("magic");
                                        if (magic > 0) {
                                                nbtData.putInt("magic", magic - 1);
                                                chestplate.setNbt(nbtData);

                                                player.getHungerManager().setFoodLevel(20);
                                                player.getHungerManager().setSaturationLevel(10);
                                        }
                                }
                        } /*else {
                                //testing only
                                player.sendMessage(new LiteralText("food: " + food), false);
                                player.sendMessage(new LiteralText("saturation: " + saturation), false);
                        }*/
                }
        }

        @Override
        protected void evaluateArmorEffects(PlayerEntity player) {
        }

        @Override
        protected void addStatusEffect(PlayerEntity player, StatusEffectInstance effect) {
        }
}
