package io.github.apurplerose.jamm.block;

import io.github.apurplerose.jamm.blockentity.AstralAltarBlockEntity;
import io.github.apurplerose.jamm.item.JammItems;
import io.github.apurplerose.jamm.recipe.AstralAltarRecipe;
import io.github.apurplerose.jamm.util.AstralAltarInventory;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Optional;

public class AstralAltarBlock extends BlockWithEntity {

        private static final Settings SETTINGS = Settings
                .of(Material.WOOD)
                .strength(.5f)
                .nonOpaque();

        public AstralAltarBlock(){
                super(SETTINGS);
        }


        @Override
        public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
                return new AstralAltarBlockEntity(pos, state);
        }

        @Override
        public BlockRenderType getRenderType(BlockState state) {
                return BlockRenderType.MODEL;
        }

        @Override
        public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
                if (hand == Hand.OFF_HAND) return ActionResult.PASS;
                if(world.isClient) return ActionResult.SUCCESS;

                if (player.getStackInHand(hand).isOf(JammItems.AMETHYST_WAND)) {
                        AstralAltarInventory inventory = (AstralAltarInventory) world.getBlockEntity(pos);

                        Optional<AstralAltarRecipe> match = world.getRecipeManager().getFirstMatch(AstralAltarRecipe.Type.INSTANCE, inventory, world);

                        if (match.isPresent()) {
                                player.sendMessage(new LiteralText("match!"), false);

                                for (int i = 0; i < 7; i++) {
                                        inventory.getStack(i).decrement(1);
                                }

                                player.getInventory().offerOrDrop(match.get().getOutput().copy());
                        } else {
                                player.sendMessage(new LiteralText("No match!"), false);
                        }

                } else {
                        NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);

                        if (screenHandlerFactory != null) {
                                player.openHandledScreen(screenHandlerFactory);
                        }
                }
                return ActionResult.CONSUME;
        }

        @Override
        public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
                if(state.getBlock() != newState.getBlock()){
                        BlockEntity blockEntity = world.getBlockEntity(pos);
                        if(blockEntity instanceof AstralAltarBlockEntity){
                                ItemScatterer.spawn(world, pos, (AstralAltarBlockEntity)blockEntity);
                                world.updateComparators(pos, this);
                        }
                        super.onStateReplaced(state, world, pos, newState, moved);
                }
        }

        @Override
        public boolean hasComparatorOutput(BlockState state) {
                return true;
        }

        @Override
        public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
                return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
        }
}
