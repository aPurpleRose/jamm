package io.github.apurplerose.jamm.fluid;

import blue.endless.jankson.annotation.Nullable;
import io.github.apurplerose.jamm.block.JammBlocks;
import io.github.apurplerose.jamm.item.JammItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import java.util.Optional;
import java.util.Random;

public abstract class LiquidStardustFluid extends FlowableFluid {

        public Fluid getFlowing() {
                return JammFluids.STARDUST_FLOWING;
        }

        public Fluid getStill() {
                return JammFluids.STARDUST_STILL;
        }

        public Item getBucketItem() {
                return JammItems.STARDUST_BUCKET;
        }

        /*public void randomDisplayTick(World world, BlockPos pos, FluidState state, Random random) {
                if (!state.isStill() && !(Boolean)state.get(FALLING)) {
                        if (random.nextInt(128) == 0) {
                                world.playSound((double)pos.getX() + 0.5D,
                                        (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D,
                                        SoundEvents.BLOCK_HONEY_BLOCK_SLIDE, SoundCategory.BLOCKS,
                                        random.nextFloat() * 0.25F + 0.75F, random.nextFloat() + 0.5F,
                                        false);
                        }     // SoundEvent probably has to change
                } else if (random.nextInt(20) == 0) {
                        world.addParticle(ParticleTypes.UNDERWATER, (double)pos.getX() + random.nextDouble(),
                                (double)pos.getY() + random.nextDouble(),
                                (double)pos.getZ() + random.nextDouble(),
                                0.0D, 0.0D, 0.0D);
                }

        }*/

        @Nullable
        public ParticleEffect getParticle() {
                return ParticleTypes.DRIPPING_WATER;
        }

        protected boolean isInfinite() {
                return false;
        }

        protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
                BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
                Block.dropStacks(state, world, pos, blockEntity);
        }

        public int getFlowSpeed(WorldView world) {
                return 7;
        }

        public BlockState toBlockState(FluidState state) {
                return JammBlocks.LIQUID_STARDUST_BLOCK.getDefaultState().with(FluidBlock.LEVEL, getBlockStateLevel(state));
        }

        public boolean matchesType(Fluid fluid) {
                return fluid == JammFluids.STARDUST_STILL || fluid == JammFluids.STARDUST_FLOWING;
        }

        public int getLevelDecreasePerBlock(WorldView world) {
                return 1;
        }

        public int getTickRate(WorldView world) {
                return 10;
        }

        public boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
                return direction == Direction.DOWN && !fluid.isIn(FluidTags.WATER);
        }

        protected float getBlastResistance() {
                return 100.0F;
        }

        public Optional<SoundEvent> getBucketFillSound() {
                return Optional.of(SoundEvents.ITEM_BUCKET_FILL);
        }

        public static class Flowing extends LiquidStardustFluid {

                protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
                        super.appendProperties(builder);
                        builder.add(LEVEL);
                }

                public int getLevel(FluidState state) {
                        return (Integer)state.get(LEVEL);
                }

                public boolean isStill(FluidState state) {
                        return false;
                }
        }

        public static class Still extends LiquidStardustFluid {

                public int getLevel(FluidState state) {
                        return 8;
                }

                public boolean isStill(FluidState state) {
                        return true;
                }
        }

}
