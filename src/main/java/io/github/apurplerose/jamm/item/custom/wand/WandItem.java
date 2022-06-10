package io.github.apurplerose.jamm.item.custom.wand;

import io.github.apurplerose.jamm.item.JammItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WandItem extends Item {

        protected int MAX_MAGIC = 50;

        private static final Item.Settings SETTINGS = new FabricItemSettings()
                .group(JammItemGroup.JAMM)
                .maxCount(1);

        public WandItem() {
                super(SETTINGS);
        }


        public void addMagic(ItemStack stack, int magic)
        {
                NbtCompound nbtData = stack.getNbt();
                nbtData.putInt("magic", nbtData.getInt("magic") + magic);
                stack.setNbt(nbtData);
        }

        public int getMagic(ItemStack stack)
        {
                NbtCompound nbtData = stack.getNbt();
                return nbtData != null ? nbtData.getInt("magic") : 0;
        }

        public int missingMagic(ItemStack stack)
        {
                NbtCompound nbtData = stack.getNbt();
                return MAX_MAGIC - (nbtData != null ? nbtData.getInt("magic") : 0);
        }

        public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context)
        {
                NbtCompound nbtData = stack.getNbt();
                int magic = 0;

                if (nbtData == null) {
                        nbtData = new NbtCompound();
                        nbtData.putInt("magic", 0);
                        stack.setNbt(nbtData);
                }else {
                        magic = nbtData.getInt("magic");
                }

                tooltip.add(new TranslatableText("tooltip.item.jamm.wand", magic, MAX_MAGIC).formatted(Formatting.ITALIC, Formatting.LIGHT_PURPLE));
        }

        public boolean isRanged(){
                return false;
        }
        public boolean isDirect(){
                return false;
        }


}
