package io.github.apurplerose.jamm.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import io.github.apurplerose.jamm.gui.AstralAltarGuiDescription;
import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class AstralAltarScreen extends CottonInventoryScreen<AstralAltarGuiDescription> {

        private static final Identifier TEXTURE = new Identifier("jamm", "textures/gui/container/astral_altar.png");

        public AstralAltarScreen(AstralAltarGuiDescription gui, PlayerEntity player, Text title) {
                super(gui, player, title);
        }


        /*@Override
        protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
                RenderSystem.setShader(GameRenderer::getPositionTexShader);
                RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
                RenderSystem.setShaderTexture(0, TEXTURE);
                int x = (width - backgroundWidth) / 2;
                int y = (height - backgroundHeight) / 2;
                drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);
        }*/

}
