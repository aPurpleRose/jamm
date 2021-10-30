package net.purple_rose.jamm.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LunarAltarEntity extends BlockEntity {
    public LunarAltarEntity(BlockPos pos, BlockState state) {
        super(JammBlockEntities.LUNAR_ALTAR_ENTITY, pos, state);
    }

    private int number = 0;

    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("number", number);
        return nbt;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        number = nbt.getInt("number");
    }

    public static void tick(World world, BlockPos pos, BlockState state, LunarAltarEntity lae){

    }
}