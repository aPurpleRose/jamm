package io.github.apurplerose.jamm.block.custom;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Material;

abstract public class AbstractAltarBlock extends BlockWithEntity {

        public static final int TANK_SIZE = 100;
        public static final Settings SETTINGS = Settings
                .of(Material.WOOD)
                .strength(.5f)
                .nonOpaque();

        public AbstractAltarBlock() {
                super(SETTINGS);
        }

        @Override
        public BlockRenderType getRenderType(BlockState state) {
                return BlockRenderType.MODEL;
        }

}
