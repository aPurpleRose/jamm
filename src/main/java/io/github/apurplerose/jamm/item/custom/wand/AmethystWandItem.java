package io.github.apurplerose.jamm.item.custom.wand;

import io.github.apurplerose.jamm.item.JammItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AmethystWandItem extends Item {

        private static final Settings SETTINGS = new FabricItemSettings()
                .group(JammItemGroup.JAMM)
                .maxCount(1);
        private final int MAX_MAGIC = 50;
        StatusEffectInstance[] EFFECTS;

        public AmethystWandItem() {
                super(SETTINGS);
        }

        public AmethystWandItem(StatusEffectInstance... effects) {
                super(SETTINGS);
                EFFECTS = effects;
        }

        public void addMagic(ItemStack stack, int magic) {
                NbtCompound nbtData = stack.getNbt();
                nbtData.putInt("magic", nbtData.getInt("magic") + magic);
                stack.setNbt(nbtData);
        }

        public int missingMagic(ItemStack stack) {
                NbtCompound nbtData = stack.getNbt();
                return MAX_MAGIC - nbtData.getInt("magic");
        }

        public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                NbtCompound nbtData = stack.getNbt();
                int magic = 0;

                if (nbtData == null) {
                        nbtData = new NbtCompound();
                        nbtData.putInt("magic", 0);
                        stack.setNbt(nbtData);
                } else {
                        magic = nbtData.getInt("magic");
                }

                tooltip.add(new TranslatableText("tooltip.item.jamm.amethyst_wand", magic, MAX_MAGIC).formatted(Formatting.ITALIC, Formatting.LIGHT_PURPLE));
        }

        @Override
        public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
                if (user.isSneaking() && !world.isClient()) {
                        for (StatusEffectInstance effect : EFFECTS) {
                                user.addStatusEffect(new StatusEffectInstance(effect));
                        }
                }

                return super.use(world, user, hand);
        }

        @Override
        public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
                if (EFFECTS == null) return ActionResult.PASS;
                if (user.isSneaking()) return ActionResult.PASS;

                for (StatusEffectInstance effect : EFFECTS) {
                        NbtCompound nbtData = stack.getNbt();
                        if (nbtData.getInt("magic") > 0) {
                                addMagic(stack, -1);
                                entity.addStatusEffect(new StatusEffectInstance(effect));
                        }

                }
                return ActionResult.SUCCESS;
        }

}
