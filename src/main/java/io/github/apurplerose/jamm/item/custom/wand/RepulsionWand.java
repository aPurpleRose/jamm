package io.github.apurplerose.jamm.item.custom.wand;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class RepulsionWand extends WandItem
{

        private boolean dark = false;

        public RepulsionWand() {}
        public RepulsionWand(int max_magic, boolean dark) {
                MAX_MAGIC = max_magic;
                this.dark = dark;
        }

        @Override
        public int missingMagic(ItemStack stack)
        {
                NbtCompound nbtData = stack.getNbt();
                return MAX_MAGIC - (nbtData != null ? nbtData.getInt("magic") : 0);
        }

        @Override
        public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
        {
                ItemStack stack = user.getStackInHand(hand);
                boolean used = false;

                List<Entity> entities = world.getOtherEntities(user, Box.of(user.getPos(), 10, 10, 10));
                for (Entity entity:entities) {
                        if (getMagic(stack) == 0) break;
                        if (!(entity instanceof LivingEntity livingEntity)) continue;
                        used = true;

                        Vec3d userPos = user.getPos();
                        Vec3d pos = livingEntity.getPos();

                        Vec3d diff = pos.subtract(userPos);
                        user.sendMessage(new LiteralText(diff + ""), false);
                        double distance = diff.length();

                        Vec3d norm;
                        if (dark) {
                                diff = new Vec3d(diff.getX(), 0, diff.getZ());
                                norm = diff.normalize();
                                norm = norm.add(0, 1, 0);
                                norm = norm.normalize();
                        } else {
                                norm = diff.normalize();
                        }

                        user.sendMessage(new LiteralText(norm + ""), false);

                        livingEntity.setVelocity(norm.multiply((8.7-distance)*0.6));

                        //livingEntity.setVelocity(v.getX(), 3, v.getZ());
                }

                if (used) return TypedActionResult.success(stack);
                return TypedActionResult.pass(stack);
        }
}
