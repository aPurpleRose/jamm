package io.github.apurplerose.jamm.item.custom.wand;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SummonersWand extends WandItem {

        @Override
        public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
                ItemStack stack = user.getStackInHand(hand);

                FireballEntity type = EntityType.FIREBALL.create(world);
                type.setPos(user.getPos().getX(), user.getPos().getY(), user.getPos().getZ());
                world.spawnEntity(type);

                return TypedActionResult.success(stack);
        }
}
