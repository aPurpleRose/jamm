package io.github.apurplerose.jamm.item.custom;

import io.github.apurplerose.jamm.block.JammBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DarkAmethystWandItem extends Item {
    public DarkAmethystWandItem(Settings settings) {
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
