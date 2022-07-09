package io.github.apurplerose.jamm;

import io.github.apurplerose.jamm.entity.EntitySpawnPacket;
import io.github.apurplerose.jamm.entity.JammEntities;
import io.github.apurplerose.jamm.fluid.JammFluids;
import io.github.apurplerose.jamm.gui.screen.JammScreens;
import io.github.apurplerose.jamm.util.JammRenderHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.impl.registry.sync.packet.RegistryPacketHandler;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;

import java.util.UUID;

@Environment(EnvType.CLIENT)
public class JammClient implements ClientModInitializer {

        public static final Identifier PacketID = new Identifier(Jamm.MOD_ID, "spawn_packet");


        @Override
        public void onInitializeClient() {
                JammScreens.registerScreens();
                JammRenderHelper.setRenderLayers();

                FluidRenderHandlerRegistry.INSTANCE.register(JammFluids.STARDUST_STILL,
                        new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                                SimpleFluidRenderHandler.WATER_FLOWING,
                                SimpleFluidRenderHandler.WATER_OVERLAY, 0xffffff));
                FluidRenderHandlerRegistry.INSTANCE.register(JammFluids.STARDUST_FLOWING,
                        new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                                SimpleFluidRenderHandler.WATER_FLOWING,
                                SimpleFluidRenderHandler.WATER_OVERLAY, 0xffffff));

                EntityRendererRegistry.register(JammEntities.MagicBulletEntityType, (context) ->
                        new FlyingItemEntityRenderer(context));
                receiveEntityPacket();

        }


        public void receiveEntityPacket()
        {
                ClientPlayNetworking.registerGlobalReceiver(PacketID, ((client, handler, buf, responseSender) -> {
                        EntityType<?> et = Registry.ENTITY_TYPE.get(buf.readVarInt());
                        UUID uuid = buf.readUuid();
                        int entityId = buf.readVarInt();
                        Vec3d pos = EntitySpawnPacket.PacketBufUtil.readVec3d(buf);
                        float pitch = EntitySpawnPacket.PacketBufUtil.readAngle(buf);
                        float yaw = EntitySpawnPacket.PacketBufUtil.readAngle(buf);

                        client.getNetworkHandler().getTaskQueue().execute(() -> {
                                if (MinecraftClient.getInstance().world == null)
                                        throw new IllegalStateException("Tried to spawn entity in a null world!");
                                Entity e = et.create(MinecraftClient.getInstance().world);
                                if (e == null)
                                        throw new IllegalStateException("Failed to create instance of entity \"" + Registry.ENTITY_TYPE.getId(et) + "\"!");
                                e.updateTrackedPosition(pos.x, pos.y, pos.z);
                                e.setPos(pos.x, pos.y, pos.z);
                                e.setPitch(pitch);
                                e.setYaw(yaw);
                                e.setId(entityId);
                                e.setUuid(uuid);
                                MinecraftClient.getInstance().world.addEntity(entityId, e);
                        });
                }));


                /*ClientSidePacketRegistry.INSTANCE.register(PacketID, (ctx, byteBuf) -> {
                        EntityType<?> et = Registry.ENTITY_TYPE.get(byteBuf.readVarInt());
                        UUID uuid = byteBuf.readUuid();
                        int entityId = byteBuf.readVarInt();
                        Vec3d pos = EntitySpawnPacket.PacketBufUtil.readVec3d(byteBuf);
                        float pitch = EntitySpawnPacket.PacketBufUtil.readAngle(byteBuf);
                        float yaw = EntitySpawnPacket.PacketBufUtil.readAngle(byteBuf);
                        ctx.getTaskQueue().execute(() -> {
                                if (MinecraftClient.getInstance().world == null)
                                        throw new IllegalStateException("Tried to spawn entity in a null world!");
                                Entity e = et.create(MinecraftClient.getInstance().world);
                                if (e == null)
                                        throw new IllegalStateException("Failed to create instance of entity \"" + Registry.ENTITY_TYPE.getId(et) + "\"!");
                                e.updateTrackedPosition(pos);
                                e.setPos(pos.x, pos.y, pos.z);
                                e.setPitch(pitch);
                                e.setYaw(yaw);
                                e.setId(entityId);
                                e.setUuid(uuid);
                                MinecraftClient.getInstance().world.addEntity(entityId, e);
                        });
                });*/
        }
}
