package io.github.apurplerose.jamm.item.custom.wand;

import io.github.apurplerose.jamm.block.JammBlocks;
import io.github.apurplerose.jamm.entity.MagicBulletEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BulletWandItem extends WandItem {

        private final int kind;
        private boolean dark = false;

        public BulletWandItem(int kind) {
                this.kind = kind;
        }

        public BulletWandItem(int kind, boolean dark) {
                this.kind = kind;
                this.dark = dark;
        }


        @Override
        public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
        {
                ItemStack stack = user.getStackInHand(hand);
                if (getMagic(stack) <= 0) return TypedActionResult.pass(stack);

                MinecraftClient client = MinecraftClient.getInstance();
                HitResult hit = client.crosshairTarget;
                if (hit.getType() == HitResult.Type.BLOCK) {
                        BlockHitResult blockHit = (BlockHitResult) hit;
                        BlockPos blockPos = blockHit.getBlockPos();
                        BlockState blockState = world.getBlockState(blockPos);
                        Block block = blockState.getBlock();
                        if (block == JammBlocks.LUNAR_ALTAR) return TypedActionResult.pass(stack);
                }

                addMagic(stack, -1);

                world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_ENDER_PEARL_THROW, SoundCategory.NEUTRAL, 0.5f, 1f);
                user.getItemCooldownManager().set(this, 5);

                if (!world.isClient) {
                        MagicBulletEntity magicBulletEntity = new MagicBulletEntity(world, user);
                        magicBulletEntity.kind = kind;
                        magicBulletEntity.dark = dark;
                        //magicBulletEntity.setItem(stack);
                        magicBulletEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0, 1.5f, 0f);
                        world.spawnEntity(magicBulletEntity);
                }

                return TypedActionResult.success(stack, world.isClient);
        }

}
