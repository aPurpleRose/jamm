package io.github.apurplerose.jamm.util;

import io.github.apurplerose.jamm.Jamm;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class JammTags {
    // https://fabricmc.net/wiki/tutorial:tags for common tags
    public static class Blocks {
        public static final Tag.Identified<Block> VALUABLE_BLOCKS = createTag("valuable_blocks");

        private static Tag.Identified<Block> createTag(String name) {
            return TagFactory.BLOCK.create(new Identifier("c", name));
        }

        private static Tag.Identified<Block> createCommonTag(String name) {
            return TagFactory.BLOCK.create(new Identifier("c", name));
        }
    }

    public static class Items {



        private static Tag.Identified<Item> createTag(String name) {
            return TagFactory.ITEM.create(new Identifier(Jamm.MOD_ID, name));
        }

        private static Tag.Identified<Item> createCommonTag(String name) {
            return TagFactory.ITEM.create(new Identifier(Jamm.MOD_ID, name));
        }
    }
}
