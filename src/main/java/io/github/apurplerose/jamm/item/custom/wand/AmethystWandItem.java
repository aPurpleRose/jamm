package io.github.apurplerose.jamm.item.custom.wand;

import io.github.apurplerose.jamm.item.JammItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import io.github.apurplerose.jamm.block.JammBlocks;

public class AmethystWandItem extends Item {

        private static final Settings SETTINGS = new FabricItemSettings()
                .group(JammItemGroup.JAMM)
                .maxCount(1);

        public AmethystWandItem() {
                super(SETTINGS);
        }

        @Override
        public ActionResult useOnBlock(ItemUsageContext context) {
                World world = context.getWorld();
                BlockPos pos = context.getBlockPos();
                BlockState state = world.getBlockState(pos);
                PlayerEntity player = context.getPlayer();


                /*if(state.isOf(JammBlocks.TEMPLATE_ALTAR)){
                        world.breakBlock(pos, true);
                } else {
                        return ActionResult.PASS;
                }*/

                return super.useOnBlock(context);
        }

        @Override
        public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 100, 2));

                return super.useOnEntity(stack, user, entity, hand);
        }

}
