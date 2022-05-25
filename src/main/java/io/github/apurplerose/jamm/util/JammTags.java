package io.github.apurplerose.jamm.util;

import io.github.apurplerose.jamm.Jamm;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class JammTags {
        // https://fabricmc.net/wiki/tutorial:tags for common tags
        public static class Blocks {
                public static final TagKey<Block> VALUABLE_BLOCKS = createTag("valuable_blocks");

                private static TagKey<Block> createTag(String name) {
                        return TagKey.of(Registry.BLOCK_KEY, new Identifier(Jamm.MOD_ID, name));
                }

                private static TagKey<Block> createCommonTag(String name) {
                        return TagKey.of(Registry.BLOCK_KEY, new Identifier("c", name));
                }
        }

        public static class Items {
                public static final TagKey<Item> AMETHYSTS = createCommonTag("amethysts");
                public static final TagKey<Item> WANDS = createTag("wands");

                private static TagKey<Item> createTag(String name) {
                        return TagKey.of(Registry.ITEM_KEY, new Identifier(Jamm.MOD_ID, name));
                }

                private static TagKey<Item> createCommonTag(String name) {
                        return TagKey.of(Registry.ITEM_KEY, new Identifier("c", name));
                }
        }
}
