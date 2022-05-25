package io.github.apurplerose.jamm.stat;

import io.github.apurplerose.jamm.Jamm;
import net.minecraft.stat.StatFormatter;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class JammStats {

        public static final Identifier TELEPORTED = new Identifier(Jamm.MOD_ID, "teleported");


        public static void registerStats() {
                Registry.register(Registry.CUSTOM_STAT, "teleported", TELEPORTED);
                Stats.CUSTOM.getOrCreateStat(TELEPORTED, StatFormatter.DEFAULT);


        }


}
