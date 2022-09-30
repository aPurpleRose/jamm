package io.github.apurplerose.jamm.gui.screen;

import io.github.apurplerose.jamm.gui.AstralAltarGuiDescription;
import io.github.apurplerose.jamm.gui.handler.JammHandlers;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class JammScreens {

        public static void registerScreens(){
                ScreenRegistry.<AstralAltarGuiDescription, AstralAltarScreen>register(JammHandlers.ASTRAL_ALTAR, (gui, inventory, title)
                        -> new AstralAltarScreen(gui, inventory.player, title));
        }
}
