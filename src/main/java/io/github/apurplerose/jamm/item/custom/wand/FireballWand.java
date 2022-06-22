package io.github.apurplerose.jamm.item.custom.wand;

import io.github.apurplerose.jamm.block.JammBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.ArrayList;

public class FireballWand extends WandItem
{
        ArrayList<FireballEntity> list = new ArrayList<>();

        @Override
        public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
        {
                ItemStack stack = user.getStackInHand(hand);

                if (getMagic(stack) < 5) return TypedActionResult.pass(stack);


                MinecraftClient client = MinecraftClient.getInstance();
                HitResult hit = client.crosshairTarget;
                if (hit.getType() == HitResult.Type.BLOCK) {
                        BlockHitResult blockHit = (BlockHitResult) hit;
                        BlockPos blockPos = blockHit.getBlockPos();
                        BlockState blockState = world.getBlockState(blockPos);
                        Block block = blockState.getBlock();
                        if (block == JammBlocks.LUNAR_ALTAR) return TypedActionResult.pass(stack);
                }

                addMagic(stack, -5);


                Vec3d pos = user.getEyePos();

                FireballEntity type = EntityType.FIREBALL.create(world);
                type.setPos(pos.getX(), pos.getY(), pos.getZ());
                type.setVelocity(user.getRotationVector().multiply(3));

                world.spawnEntity(type);
                list.add(type);

                return TypedActionResult.success(stack);
        }

        @Override
        public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
        {
                for (FireballEntity fireball : list) {
                        fireball.setVelocity(fireball.getVelocity().normalize());
                        if (fireball.age > 60) {
                                fireball.remove(Entity.RemovalReason.DISCARDED);
                        }
                }
        }
}
