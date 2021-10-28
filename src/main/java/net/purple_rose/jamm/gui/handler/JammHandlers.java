package net.purple_rose.jamm.gui.handler;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.purple_rose.jamm.Jamm;


public class JammHandlers {

    public static ScreenHandlerType<AstralAltarHandler> ASTRAL_ALTAR;

    public static void registerHandlers(){
        ASTRAL_ALTAR = ScreenHandlerRegistry.registerSimple(new Identifier(Jamm.MOD_ID, "astral_altar_screen"), AstralAltarHandler::new);
    }


}
