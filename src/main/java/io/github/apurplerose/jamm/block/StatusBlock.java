package io.github.apurplerose.jamm.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class StatusBlock extends Block {

        private static final Settings SETTINGS = Settings
                .of(Material.STONE)
                .strength(5.0f)
                .requiresTool();

        public StatusBlock(){
                super (SETTINGS);
        }

        @Override
        public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
                if(!world.isClient()){
                        if(hand == Hand.MAIN_HAND){
                                BlockPos playerBlockPos = player.getBlockPos();
                                player.sendMessage(Text.literal("SERVER: You are " + player.getDisplayName().getString()
                                        + " at Position (" + playerBlockPos.getX() + ", " + playerBlockPos.getY() + ", " + playerBlockPos.getZ() + ")"),false);
                        }
                } else {
                        if(hand == Hand.MAIN_HAND){
                                player.sendMessage(Text.literal("CLIENT: This is THE CLIENT! MAIN HAND!"), false);
                        }else{
                                player.sendMessage(Text.literal("CLIENT: This is THE CLIENT! OFF HAND!"), false);
                        }
                }

                return ActionResult.PASS;
        }
}