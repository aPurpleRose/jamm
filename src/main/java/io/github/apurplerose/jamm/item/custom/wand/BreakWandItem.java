package io.github.apurplerose.jamm.item.custom.wand;

import io.github.apurplerose.jamm.block.JammBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BreakWandItem extends WandItem {

        private final int MAX_MAGIC = 700;

        public BreakWandItem() {
                super();
        }

        @Override
        public ActionResult useOnBlock(ItemUsageContext context) {
                World world = context.getWorld();
                BlockPos pos = context.getBlockPos();
                ItemStack stack = context.getStack();
                BlockState state = world.getBlockState(pos);
                int hardness = (int)state.getHardness(world, pos);

                NbtCompound nbtData = stack.getNbt();

                if (nbtData.getInt("magic") - hardness < 0 || state.isOf(JammBlocks.LUNAR_ALTAR) || hardness == -1) return ActionResult.FAIL;

                addMagic(stack, -hardness);
                world.breakBlock(pos, true);

                return ActionResult.SUCCESS;
        }

        @Override
        public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
                NbtCompound nbtData = stack.getNbt();

                if (nbtData.getInt("magic") <= 0) return ActionResult.PASS;
                addMagic(stack, -1);
                entity.damage(DamageSource.MAGIC, 4);

                return ActionResult.SUCCESS;
        }

        public int missingMagic(ItemStack stack) {
                NbtCompound nbtData = stack.getNbt();
                return MAX_MAGIC - nbtData.getInt("magic");
        }

        public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                NbtCompound nbtData = stack.getNbt();
                int magic;

                if (nbtData == null) {
                        magic = 0;
                        nbtData = new NbtCompound();
                        nbtData.putInt("magic", magic);
                        stack.setNbt(nbtData);
                } else {
                        magic = nbtData.getInt("magic");
                }

                tooltip.add(Text.translatable("tooltip.item.jamm.wand", magic, MAX_MAGIC).formatted(Formatting.ITALIC, Formatting.LIGHT_PURPLE));
        }

}
