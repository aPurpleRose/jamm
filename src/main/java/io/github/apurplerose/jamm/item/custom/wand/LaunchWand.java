package io.github.apurplerose.jamm.item.custom.wand;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class LaunchWand extends WandItem
{
        private boolean dark = false;

        public LaunchWand() {
                super();
        }
        public LaunchWand(int max_magic, boolean dark) {
                super();
                MAX_MAGIC = max_magic;
                this.dark = dark;
        }


        @Override
        public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
        {
                ItemStack stack = user.getStackInHand(hand);
                int launchVelocity = dark ? 3 : 2;

                if (user.isSneaking() && getMagic(stack) >= 2) {
                        Vec3d v = user.getVelocity();
                        user.setVelocity(v.getX(), launchVelocity, v.getZ());
                        addMagic(stack, -2);
                        return TypedActionResult.success(stack);
                }

                int magic = getMagic(stack) - 1;
                List<Entity> entities = world.getOtherEntities(user, Box.of(user.getPos(), 10, 10, 10));
                for (Entity entity:entities) {
                        if (magic <= 0) break;
                        if (!(entity instanceof LivingEntity livingEntity)) continue;

                        magic--;
                        Vec3d v = entity.getVelocity();
                        livingEntity.setVelocity(v.getX(), launchVelocity, v.getZ());
                }
                addMagic(stack, magic);

                return TypedActionResult.success(stack);
        }
}
