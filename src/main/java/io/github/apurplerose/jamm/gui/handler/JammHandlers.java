package io.github.apurplerose.jamm.gui.handler;

import io.github.apurplerose.jamm.Jamm;
import io.github.apurplerose.jamm.gui.AstralAltarGuiDescription;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;


public class JammHandlers {

    public static ScreenHandlerType<AstralAltarGuiDescription> ASTRAL_ALTAR;

    public static void registerHandlers(){
        ASTRAL_ALTAR = ScreenHandlerRegistry.registerSimple(new Identifier(Jamm.MOD_ID, "astral_altar_screen"), (syncId, inventory)
                -> new AstralAltarGuiDescription(syncId, inventory, ScreenHandlerContext.EMPTY));
    }


}
