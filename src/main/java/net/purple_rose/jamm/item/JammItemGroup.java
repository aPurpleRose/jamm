package net.purple_rose.jamm.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.purple_rose.jamm.Jamm;

public class JammItemGroup {
    public static final ItemGroup JAMM = FabricItemGroupBuilder.build(new Identifier(Jamm.MOD_ID, "jamm"),
            () -> new ItemStack(JammItems.AMETHYST_WAND));
}
