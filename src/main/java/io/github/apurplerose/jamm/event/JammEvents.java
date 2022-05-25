package io.github.apurplerose.jamm.event;

import net.fabricmc.fabric.api.entity.event.v1.EntitySleepEvents;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.ActionResult;

public class JammEvents {

        public static void registerEvents() {

                /*AttackBlockCallback.EVENT.register((player, world, hand, pos, direction)->
                {
                        BlockState state = world.getBlockState(pos);

                        if (state.isToolRequired() && !player.isSpectator() &&
                                player.getMainHandStack().isEmpty()) {
                                player.damage(DamageSource.GENERIC, 1.0F);
                        }
                        return ActionResult.PASS;
                });*/

        }

}
