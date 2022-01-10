package io.github.apurplerose.jamm.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

abstract public class AbstractAltarBlockEntity extends BlockEntity /*implements Tickable*/ {

    public AbstractAltarBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
}
