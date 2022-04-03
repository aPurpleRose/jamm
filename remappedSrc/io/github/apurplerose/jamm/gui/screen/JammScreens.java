package io.github.apurplerose.jamm.gui.screen;

import io.github.apurplerose.jamm.gui.AstralAltarGuiDescription;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import io.github.apurplerose.jamm.gui.handler.JammHandlers;

@Environment(EnvType.CLIENT)
public class JammScreens {

    public static void registerScreens(){
        ScreenRegistry.<AstralAltarGuiDescription, AstralAltarScreen>register(JammHandlers.ASTRAL_ALTAR, (gui, inventory, title)
                -> new AstralAltarScreen(gui, inventory.player, title));
    }
}
