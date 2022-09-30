package io.github.apurplerose.jamm.entity;

import io.github.apurplerose.jamm.JammClient;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.SkeletonHorseEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class MagicBulletEntity extends ThrownItemEntity
{
        public boolean dark = false;

        public int kind;


        public MagicBulletEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
                super(entityType, world);
        }

        public MagicBulletEntity(World world, LivingEntity owner) {
                super(JammEntities.MagicBulletEntityType, owner, world);
        }

        public MagicBulletEntity(World world, double x, double y, double z) {
                super(JammEntities.MagicBulletEntityType, x, y, z, world);
        }

        @Override
        protected Item getDefaultItem() {
                return null;
        }

        @Environment(EnvType.CLIENT)
        private ParticleEffect getParticleParameters() {
                ItemStack itemStack = this.getItem();
                return itemStack.isEmpty() ? ParticleTypes.PORTAL : new ItemStackParticleEffect(ParticleTypes.ITEM, itemStack);
        }

        @Environment(EnvType.CLIENT)
        public void handleStatus(byte status) {
                if (status == 3) {
                        ParticleEffect particleEffect = this.getParticleParameters();

                        for (int i = 0; i < 8; i++) {
                                this.world.addParticle(particleEffect, this.getX(), this.getY(), this.getZ(), 0, 0, 0);
                        }
                }
        }

        protected void onEntityHit(EntityHitResult entityHitResult) {
                super.onEntityHit(entityHitResult);
                Entity entity = entityHitResult.getEntity();
                entity.damage(DamageSource.MAGIC, 1);
                if (dark) {
                        if (entity instanceof LivingEntity livingEntity) {
                                livingEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.BLINDNESS, 60, 0)));
                                livingEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.SLOWNESS, 60, 2)));
                                livingEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.POISON, 60, 1)));
                                livingEntity.playSound(SoundEvents.AMBIENT_CAVE, 2, 1);
                        }
                }
        }

        @Override
        protected void onBlockHit(BlockHitResult blockHitResult) {
                super.onBlockHit(blockHitResult);
                BlockPos pos = blockHitResult.getBlockPos();

                switch (kind) {
                        case 1: //break
                                world.breakBlock(pos, true);
                        default:
                }

                this.world.sendEntityStatus(this, (byte)3);
                this.kill();
        }

        protected void onCollision(HitResult hitResult) {
                super.onCollision(hitResult);
                if (this.world.isClient) return;

                Vec3d pos =  hitResult.getPos();
                switch (kind) {
                        case 2: // launch
                                int launchVelocity = dark ? 3 : 2;

                                List<Entity> entities1 = world.getOtherEntities(this, Box.of(pos, 10, 10, 10));
                                for (Entity entity:entities1) {
                                        if (!(entity instanceof LivingEntity livingEntity)) continue;

                                        Vec3d v = entity.getVelocity();
                                        livingEntity.setVelocity(v.getX(), launchVelocity, v.getZ());
                                }

                                break;
                        case 3: // lightning
                                LightningEntity lightning_bolt = EntityType.LIGHTNING_BOLT.create(world);
                                lightning_bolt.setPos(pos.getX(), pos.getY(), pos.getZ());
                                world.spawnEntity(lightning_bolt);
                                break;
                        case 4: // spawn entities/necromancy?
                                // skeleton, skeleton horseman, stray, wither skeleton
                                if (random.nextInt(7) == 0) {
                                        SkeletonHorseEntity entity = EntityType.SKELETON_HORSE.create(world);
                                        entity.setTrapped(true);
                                        entity.setPos(pos.getX(), pos.getY(), pos.getZ());
                                        world.spawnEntity(entity);
                                } else {
                                        LivingEntity entity = switch (random.nextInt(4)) {
                                                case 1 -> EntityType.STRAY.create(world);
                                                case 2 -> EntityType.WITHER_SKELETON.create(world);
                                                case 3 -> EntityType.SKELETON_HORSE.create(world);
                                                default -> EntityType.SKELETON.create(world);
                                        };
                                        entity.setPos(pos.getX(), pos.getY(), pos.getZ());
                                        world.spawnEntity(entity);
                                }
                                break;
                        case 5: //repulsion
                                List<Entity> entities = world.getOtherEntities(this, Box.of(pos, 10, 10, 10));
                                for (Entity entity : entities) {
                                        if (!(entity instanceof LivingEntity livingEntity)) continue;

                                        Vec3d ePos = livingEntity.getPos();
                                        Vec3d diff = ePos.subtract(pos);
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

                                        livingEntity.setVelocity(norm.multiply((8.7 - distance) * 0.6));
                                }
                                break;
                        default:
                }

                this.world.sendEntityStatus(this, (byte)3);
                this.kill();
        }

        @Override
        public boolean hasNoGravity() {
                return true;
        }

        @Override
        public Packet createSpawnPacket() {
                return EntitySpawnPacket.create(this, JammClient.SPAWN_PACKET);
        }
}
