package io.github.apurplerose.jamm.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LunarAltarBlockEntity extends BlockEntity {

        private static int magic;
        private static final int reqTicks = 20;
        private static int ticks;

        public LunarAltarBlockEntity(BlockPos pos, BlockState state) {
                super(JammBlockEntities.LUNAR_ALTAR, pos, state);
        }

        @Override
        public NbtCompound writeNbt(NbtCompound nbt) {
                super.writeNbt(nbt);
                nbt.putInt("magic", magic);
                return nbt;
        }

        @Override
        public void readNbt(NbtCompound nbt) {
                super.readNbt(nbt);
                magic = nbt.getInt("magic");
        }

        public static void tick(World world, BlockPos pos, BlockState state, LunarAltarBlockEntity lae) {
                ticks += 1;
                if (ticks > reqTicks) {
                        ticks = 0;
                        magic += 1;
                }
        }

        public int getMagic() {
                return magic;
        }
}