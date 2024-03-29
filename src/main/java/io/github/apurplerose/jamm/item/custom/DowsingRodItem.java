package io.github.apurplerose.jamm.item.custom;

import io.github.apurplerose.jamm.item.JammItemGroup;
import io.github.apurplerose.jamm.util.JammTags;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class DowsingRodItem extends Item {

        private static final Settings SETTINGS = new FabricItemSettings()
                .group(JammItemGroup.JAMM)
                .maxCount(16);

        public DowsingRodItem(){
                super (SETTINGS);
        }

        //might rework into a staff only working at night; might let it detect other valuables too when upgraded
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
                                player.sendMessage(Text.literal("Didn't find any magical valuables below!"), false);
                        }
                }

                context.getStack().damage(1, context.getPlayer(), (player) -> player.sendToolBreakStatus(player.getActiveHand()));

                return super.useOnBlock(context);
        }

        @Override
        public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                tooltip.add(Text.translatable("tooltip.item.jamm.dowsing_rod"));
        }

        private boolean isValuableBlock(Block block){
                return block.getDefaultState().isIn(JammTags.Blocks.VALUABLE_BLOCKS);
        }

        private void outputValuableFound(Block blockFound, PlayerEntity player){
                player.sendMessage(Text.literal("Found " + blockFound.asItem().getName().getString()), false);
        }

}