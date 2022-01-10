package io.github.apurplerose.jamm.block.custom;

import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;

abstract public class AbstractAltarBlock extends BlockWithEntity/*extends Block implements BlockEntityProvider*/ {

    public static final int TANK_SIZE = 100;
    public static final Settings SETTINGS = Settings
            .of(Material.WOOD)
            .strength(.5f)
            .nonOpaque();

    public AbstractAltarBlock() {
        super(SETTINGS);
    }
}
