package net.purple_rose.jamm.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

import net.purple_rose.jamm.blockentity.LunarAltarEntity;


public class LunarAltarBlock extends Block implements BlockEntityProvider {
    public LunarAltarBlock(Settings settings) {
        super(settings);
    }


    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new LunarAltarEntity(pos, state);
    }

}
