package io.github.apurplerose.jamm.gui.handler;

import io.github.apurplerose.jamm.Jamm;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;


public class JammHandlers {

    public static ScreenHandlerType<AstralAltarHandler> ASTRAL_ALTAR;

    public static void registerHandlers(){
        ASTRAL_ALTAR = ScreenHandlerRegistry.registerSimple(new Identifier(Jamm.MOD_ID, "astral_altar_screen"), AstralAltarHandler::new);
    }


}
