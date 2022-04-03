package io.github.apurplerose.jamm.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

abstract public class AbstractAltarBlockEntity extends BlockEntity {

        public AbstractAltarBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
                super(type, pos, state);
        }


}
