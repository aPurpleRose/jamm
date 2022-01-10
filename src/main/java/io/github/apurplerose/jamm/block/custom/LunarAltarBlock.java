package io.github.apurplerose.jamm.block.custom;

import io.github.apurplerose.jamm.blockentity.LunarAltarBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class LunarAltarBlock extends BlockWithEntity {

    private static final Settings SETTINGS = Settings
            .of(Material.WOOD)
            .strength(.5f)
            .nonOpaque();

    public LunarAltarBlock(){
        super(SETTINGS);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new LunarAltarBlockEntity(pos, state);
    }

}
