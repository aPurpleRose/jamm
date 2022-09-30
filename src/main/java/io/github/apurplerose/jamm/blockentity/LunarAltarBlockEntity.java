package io.github.apurplerose.jamm.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LunarAltarBlockEntity extends AbstractAltarBlockEntity {

        private int magic;
        public static final int MAX_MAGIC = 150;
        private static final int REQ_TICKS = 40;
        private int ticks;


        public LunarAltarBlockEntity(BlockPos pos, BlockState state) {
                super(JammBlockEntities.LUNAR_ALTAR, pos, state);
                magic = 0;
        }

        @Override
        public void writeNbt(NbtCompound nbt) {
                super.writeNbt(nbt);
                nbt.putInt("magic", magic);
        }

        @Override
        public void readNbt(NbtCompound nbt) {
                super.readNbt(nbt);
                magic = nbt.getInt("magic");
        }

        public static void tick(World world, BlockPos pos, BlockState state, LunarAltarBlockEntity lae) {
                float multiplier = 1;

                if (world.isNight()) {
                        multiplier += world.getMoonSize();
                        multiplier *= 2;
                }


                if (lae.magic < MAX_MAGIC) {
                        lae.ticks ++;
                        if (lae.ticks > (REQ_TICKS/multiplier)) {
                                lae.ticks = 0;
                                lae.magic ++;
                        }
                }

        }

        public int getMagic() {
                return magic;
        }

        public void removeMagic(int magic) {
                this.magic -= magic;
        }

}