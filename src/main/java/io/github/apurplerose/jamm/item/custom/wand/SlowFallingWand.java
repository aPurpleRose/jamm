package io.github.apurplerose.jamm.item.custom.wand;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SlowFallingWand extends WandItem
{

        @Override
        public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
        {
                ItemStack stack = user.getStackInHand(hand);

                if (user.hasStatusEffect(StatusEffects.SLOW_FALLING)) {
                        user.removeStatusEffect(StatusEffects.SLOW_FALLING);
                } else {
                        user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 200, 0, false, false));
                }

                return TypedActionResult.success(stack);
        }

        @Override
        public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
        {
                if (!selected) return;

                if (entity instanceof PlayerEntity playerEntity) {
                        BlockPos pos = playerEntity.getLandingPos();
                        playerEntity.sendMessage(new LiteralText(pos.getY() + " : " + entity.getPos().getY()), false);
                }
        }
}
