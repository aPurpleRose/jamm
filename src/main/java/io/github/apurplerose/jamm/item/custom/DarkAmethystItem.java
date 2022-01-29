package io.github.apurplerose.jamm.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DarkAmethystItem extends Item {

        public DarkAmethystItem(Settings settings) {
                super(settings);
        }

        @Override
        public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                tooltip.add(new TranslatableText("tooltip.item.jamm.dark_amethyst").formatted(Formatting.ITALIC, Formatting.LIGHT_PURPLE));
        }
}
