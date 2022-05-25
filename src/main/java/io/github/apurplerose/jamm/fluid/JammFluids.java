package io.github.apurplerose.jamm.fluid;

import io.github.apurplerose.jamm.Jamm;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class JammFluids {

        public static final FlowableFluid STARDUST_STILL = register("stardust_still", new LiquidStardustFluid.Still());
        public static final FlowableFluid STARDUST_FLOWING = register("stardust_flowing", new LiquidStardustFluid.Flowing());

        private static FlowableFluid register(String name, FlowableFluid flowableFluid) {
                return Registry.register(Registry.FLUID, new Identifier(Jamm.MOD_ID, name), flowableFluid);
        }

}
