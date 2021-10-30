package net.purple_rose.jamm.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.purple_rose.jamm.block.JammBlocks;

public class AmethystWandItem extends Item {
    public AmethystWandItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        if(blockState.isOf(JammBlocks.TEMPLATE_ALTAR)){

        } else {
            return ActionResult.PASS;
        }

        return super.useOnBlock(context);
    }


}
