package io.github.apurplerose.jamm.registries;

import io.github.apurplerose.jamm.block.JammBlocks;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class JammRegistries {

        public static void registerRegistries() {
                registerStrippables();
        }

        public static void registerStrippables() {
                StrippableBlockRegistry.register(JammBlocks.MYSTICAL_LOG, JammBlocks.STRIPPED_MYSTICAL_LOG);
                StrippableBlockRegistry.register(JammBlocks.MYSTICAL_WOOD, JammBlocks.STRIPPED_MYSTICAL_WOOD);
        }
}
