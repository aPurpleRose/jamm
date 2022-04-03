package io.github.apurplerose.jamm.block;

import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class DarkAmethystOre extends OreBlock {

        private static final Settings SETTINGS = Settings
                .of(Material.STONE)
                .strength(4.0f)
                .requiresTool();

        private static final UniformIntProvider EXPERIENCE = UniformIntProvider.create(7, 13);

        public DarkAmethystOre() {
                super(SETTINGS, EXPERIENCE);
        }

}
