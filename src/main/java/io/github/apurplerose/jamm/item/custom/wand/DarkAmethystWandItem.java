package io.github.apurplerose.jamm.item.custom.wand;

import io.github.apurplerose.jamm.block.JammBlocks;
import io.github.apurplerose.jamm.item.JammItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DarkAmethystWandItem extends Item {

    private static final Settings SETTINGS = new FabricItemSettings()
            .group(JammItemGroup.JAMM)
            .maxCount(1);

    public DarkAmethystWandItem() {
        super(SETTINGS);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.isOf(JammBlocks.WOODEN_ALTAR)){

        } else {
            return ActionResult.PASS;
        }

        return super.useOnBlock(context);
    }


}
