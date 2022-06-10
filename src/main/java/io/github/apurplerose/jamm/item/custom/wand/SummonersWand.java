package io.github.apurplerose.jamm.item.custom.wand;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SummonersWand extends WandItem {

        @Override
        public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
                ItemStack stack = user.getStackInHand(hand);
                Vec3d pos = user.getPos();

                // pitch (left right) and yaw (up down)

                FireballEntity type = EntityType.FIREBALL.create(world);
                type.setPos(pos.getX(), pos.getY() + 1, pos.getZ());
                type.setVelocity(0, -1, 0);
                world.spawnEntity(type);

                return TypedActionResult.success(stack);
        }
}
