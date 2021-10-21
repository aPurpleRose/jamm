package net.purple_rose.jamm.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.purple_rose.jamm.item.ModItems;

public class TemplateAltarBlock extends Block {
    public TemplateAltarBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(world.isClient()) {
            if(hand==Hand.MAIN_HAND) {
                player.sendMessage(new LiteralText(player.getActiveItem().toString()), false);
            }
            //player.sendMessage(new LiteralText(player.getItemsHand().toString()),false);
            if (player.getItemsHand() == ModItems.AMETHYST_WAND) {
                player.sendMessage(new LiteralText("hi"),false);
            }
        }

        return super.onUse(state, world, pos, player, hand, hit);
    }


}
