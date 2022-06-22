package io.github.apurplerose.jamm.entity;

import io.github.apurplerose.jamm.JammClient;
import io.github.apurplerose.jamm.item.JammItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class MagicBulletEntity extends ThrownItemEntity
{
        public boolean dark = false;


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
                return JammItems.MAGIC_BULLET;
        }

        @Environment(EnvType.CLIENT)
        private ParticleEffect getParticleParameters() {
                ItemStack itemStack = this.getItem();
                return (ParticleEffect)(itemStack.isEmpty() ? ParticleTypes.PORTAL : new ItemStackParticleEffect(ParticleTypes.ITEM, itemStack));
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

        protected void onCollision(HitResult hitResult) {
                super.onCollision(hitResult);
                if (!this.world.isClient) {
                        this.world.sendEntityStatus(this, (byte)3);
                        this.kill();
                }
        }

        @Override
        public boolean hasNoGravity() {
                return true;
        }

        @Override
        public Packet createSpawnPacket() {
                return EntitySpawnPacket.create(this, JammClient.PacketID);
        }
}
