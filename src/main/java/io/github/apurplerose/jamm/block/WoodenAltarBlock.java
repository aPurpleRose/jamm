package io.github.apurplerose.jamm.block;

import io.github.apurplerose.jamm.blockentity.WoodenAltarBlockEntity;
import io.github.apurplerose.jamm.item.JammItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WoodenAltarBlock extends BlockWithEntity {

        private static final Settings SETTINGS = Settings
                .of(Material.WOOD)
                .strength(.5f)
                .nonOpaque();

        public WoodenAltarBlock(){
                super(SETTINGS);
        }

        @Override
        public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
                return new WoodenAltarBlockEntity(pos, state);
        }

        @Override
        public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
                if(world.isClient()) {
                        if(hand==Hand.MAIN_HAND) {
                                player.sendMessage(Text.literal(player.getActiveItem().toString()), false);
                        }
                        //player.sendMessage(new LiteralText(player.getItemsHand().toString()),false);
                        if (player.getItemsHand() == JammItems.AMETHYST_WAND) {
                                player.sendMessage(Text.literal("hi"),false);
                        }
                }

                return super.onUse(state, world, pos, player, hand, hit);
        }

}
