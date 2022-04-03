package io.github.apurplerose.jamm.item.custom.wand;

import io.github.apurplerose.jamm.block.JammBlocks;
import io.github.apurplerose.jamm.item.JammItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AmethystBreakWandItem extends AmethystWandItem {

        private static final Settings SETTINGS = new FabricItemSettings()
                .group(JammItemGroup.JAMM)
                .maxCount(1);
        private final int MAX_MAGIC = 100;

        public AmethystBreakWandItem() {
                super();
        }

        @Override
        public ActionResult useOnBlock(ItemUsageContext context) {
                World world = context.getWorld();
                BlockPos pos = context.getBlockPos();
                ItemStack stack = context.getStack();
                BlockState state = world.getBlockState(pos);

                NbtCompound nbtData = stack.getNbt();
                if (nbtData.getInt("magic") <= 0 || state.isOf(JammBlocks.LUNAR_ALTAR) || state.isOf(Blocks.BEDROCK)) return super.useOnBlock(context);
                addMagic(stack, -1);
                world.breakBlock(pos, true);

                return ActionResult.SUCCESS;
        }

        @Override
        public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
                NbtCompound nbtData = stack.getNbt();
                if (nbtData.getInt("magic") > 0) {
                        addMagic(stack, -1);
                        entity.damage(DamageSource.MAGIC, 3);
                }

                return super.useOnEntity(stack, user, entity, hand);
        }

        /*public void addMagic(ItemStack stack, int magic) {
                NbtCompound nbtData = stack.getNbt();
                nbtData.putInt("magic", nbtData.getInt("magic") + magic);
                stack.setNbt(nbtData);
        }*/

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

                tooltip.add(new TranslatableText("tooltip.item.jamm.amethyst_wand", magic, MAX_MAGIC).formatted(Formatting.ITALIC, Formatting.LIGHT_PURPLE));
        }

}
