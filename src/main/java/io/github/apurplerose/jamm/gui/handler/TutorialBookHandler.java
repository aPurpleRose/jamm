package io.github.apurplerose.jamm.gui.handler;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.data.Insets;

public class TutorialBookHandler extends LightweightGuiDescription {

        public TutorialBookHandler() {
                WGridPanel root = new WGridPanel();
                setRootPanel(root);
                root.setSize(300, 200);

                root.validate(this);
        }


}
