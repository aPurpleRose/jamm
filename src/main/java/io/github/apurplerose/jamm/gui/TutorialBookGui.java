package io.github.apurplerose.jamm.gui;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

public class TutorialBookGui extends LightweightGuiDescription {

        public TutorialBookGui() {
                WPlainPanel root = new WPlainPanel();
                setRootPanel(root);
                root.setSize(256, 192);

                /*root.setBackgroundPainter(new BackgroundPainter() {
                        @Override
                        public void paintBackground(MatrixStack matrices, int left, int top, WWidget panel) {

                        }
                });*/

                WSprite icon = new WSprite(new Identifier("minecraft:textures/item/redstone.png"));
                root.add(icon, 8, 8, 16, 16);

                WButton button = new WButton(new TranslatableText("gui.jamm.examplebutton"));
                root.add(button, 32, 17, 64, 16);

                WLabel label = new WLabel(new LiteralText("Hello World!"));
                root.add(label, 16, 40, 32, 16);

                root.validate(this);
        }

}
