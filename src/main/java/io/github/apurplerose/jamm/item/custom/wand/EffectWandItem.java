package io.github.apurplerose.jamm.item.custom.wand;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class EffectWandItem extends WandItem {

        StatusEffectInstance[] EFFECTS;

        public EffectWandItem(StatusEffectInstance... effects) {
                super();
                EFFECTS = effects;
        }
        public EffectWandItem(int max_magic, StatusEffectInstance... effects) {
                super();
                EFFECTS = effects;
                MAX_MAGIC = max_magic;
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
