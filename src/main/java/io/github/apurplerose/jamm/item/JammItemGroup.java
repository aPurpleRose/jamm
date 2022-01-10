package io.github.apurplerose.jamm.item;

import io.github.apurplerose.jamm.Jamm;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class JammItemGroup {
    public static final ItemGroup JAMM = FabricItemGroupBuilder.build(new Identifier(Jamm.MOD_ID, "jamm"),
            () -> new ItemStack(JammItems.AMETHYST_WAND));
}
