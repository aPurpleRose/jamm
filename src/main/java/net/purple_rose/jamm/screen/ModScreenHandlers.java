package net.purple_rose.jamm.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.purple_rose.jamm.Jamm;


public class ModScreenHandlers {

    public static final ScreenHandlerType<AstralAltarScreenHandler> ASTRAL_ALTAR_SCREEN_HANDLER
            = ScreenHandlerRegistry.registerSimple(new Identifier(Jamm.MOD_ID, "astral_altar_screen"), AstralAltarScreenHandler::new);

    public static void registerModScreenHandlers(){
        System.out.println("Registering Mod Screen Handlers for " + Jamm.MOD_ID);
    }
}
