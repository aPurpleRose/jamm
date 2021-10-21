package net.purple_rose.jamm.item.custom;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.purple_rose.jamm.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class DowsingRodItem extends Item {
    public DowsingRodItem(Settings settings){
        super (settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context){
        if(context.getWorld().isClient()){
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = Objects.requireNonNull(context.getPlayer());
            boolean foundBlock = false;

            for(int i = 0; i<= positionClicked.getY(); i++){
                Block blockBelow = context.getWorld().getBlockState(positionClicked.down(i)).getBlock();

                if(isValuableBlock(blockBelow)){
                    outputValuableFound(blockBelow, player);
                    foundBlock = true;
                    break;
                }
            }
            if(!foundBlock){
                player.sendMessage(new LiteralText("Didn't find any magical valuables below!"), false);
            }
        }

        context.getStack().damage(1, context.getPlayer(), (player) -> player.sendToolBreakStatus(player.getActiveHand()));

        return super.useOnBlock(context);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("tooltip.item.jamm.dowsing_rod"));
    }

    private boolean isValuableBlock(Block block){
        return block == ModBlocks.AMETHYST_ORE || block == ModBlocks.AMETHYST_BLOCK;
    }

    private void outputValuableFound(Block blockFound, PlayerEntity player){
        player.sendMessage(new LiteralText("Found " + blockFound.asItem().getName().getString()), false);
    }
}