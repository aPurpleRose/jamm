package io.github.apurplerose.jamm.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LunarAltarBlockEntity extends AbstractAltarBlockEntity {

        private int magic;
        private static final int reqTicks = 10;
        private int ticks;
        public static final int MAX_MAGIC = 150;

        public LunarAltarBlockEntity(BlockPos pos, BlockState state) {
                super(JammBlockEntities.LUNAR_ALTAR, pos, state);
                magic = 0;
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
                if (lae.magic < MAX_MAGIC) {
                        lae.ticks += 1;
                        if (lae.ticks > reqTicks) {
                                lae.ticks = 0;
                                lae.magic += 1;
                        }
                }
        }

        public int getMagic() {
                return magic;
        }
        public void removeMagic(int magic1) {
                magic -= magic1;
        }


}