package io.github.apurplerose.jamm.item;

import io.github.apurplerose.jamm.entity.MagicBulletEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class MagicBulletItem extends Item
{
        // this exists for debug reasons only, will be removed later

        public MagicBulletItem(Item.Settings settings) {
                super(settings);
        }

        @Override
        public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
                ItemStack itemStack = user.getStackInHand(hand);
                world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_ENDER_PEARL_THROW, SoundCategory.NEUTRAL, 0.5f, 1f);
                user.getItemCooldownManager().set(this, 5);

                if (!world.isClient) {
                        MagicBulletEntity magicBulletEntity = new MagicBulletEntity(world, user);
                        magicBulletEntity.setItem(itemStack);
                        magicBulletEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0, 1.5f, 0f);
                        world.spawnEntity(magicBulletEntity);
                }

                return TypedActionResult.success(itemStack, world.isClient);
        }
}
