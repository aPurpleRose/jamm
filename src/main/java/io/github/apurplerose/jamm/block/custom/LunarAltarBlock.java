package io.github.apurplerose.jamm.block.custom;

import io.github.apurplerose.jamm.blockentity.JammBlockEntities;
import io.github.apurplerose.jamm.blockentity.LunarAltarBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LunarAltarBlock extends AbstractAltarBlock {

        public LunarAltarBlock(){
                super();
        }

        @Override
        public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
                return new LunarAltarBlockEntity(pos, state);
        }

        @Override
        public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
                return checkType(type, JammBlockEntities.LUNAR_ALTAR, (world1, pos, state1, lae) -> LunarAltarBlockEntity.tick(world1, pos, state1, (LunarAltarBlockEntity) lae));
        }

        @Override
        public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

                LunarAltarBlockEntity lae;
                if(state.hasBlockEntity()) {
                        lae = (LunarAltarBlockEntity)world.getBlockEntity(pos);
                        String magic = Integer.toString(lae.getMagic());
                        player.sendMessage(new LiteralText(magic),false);
                }

                return super.onUse(state, world, pos, player, hand, hit);
        }
}
