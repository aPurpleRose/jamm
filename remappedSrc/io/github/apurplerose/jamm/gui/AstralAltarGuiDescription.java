package io.github.apurplerose.jamm.gui;

import io.github.apurplerose.jamm.gui.handler.JammHandlers;
import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;

public class AstralAltarGuiDescription extends SyncedGuiDescription {

        private static final int INVENTORY_SIZE = 7;

        public AstralAltarGuiDescription(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
                super(JammHandlers.ASTRAL_ALTAR, syncId, playerInventory, getBlockInventory(context, INVENTORY_SIZE), getBlockPropertyDelegate(context));

                WPlainPanel root = new WPlainPanel();
                setRootPanel(root);
                root.setSize(162, 162); // 9*18 (size of a slot)
                root.setInsets(Insets.ROOT_PANEL);

                //WIte mSlot mainSlots = WItemSlot.of(blockInventory, 0, 3, 3);
                //root.ad d(mainSlots, 4, 10);

                //WIt emSlot amethystSlot = WItemSlot.of(blockInventory, 9);
                //root.add(amethystSlot, 144, 55);

                /*WIte mSlot outputSlot = WItemSlot.outputOf(blockInventory, 10);
                outputSlot.setInsertingAllowed(false);
                root.add(outputSlot, 70, 28);*/

                WItemSlot centerSlot = WItemSlot.of(blockInventory, 0);
                root.add(centerSlot, 70, 46);
                WItemSlot aSlot = WItemSlot.of(blockInventory, 1);
                root.add(aSlot, 70, 10);
                WItemSlot bSlot = WItemSlot.of(blockInventory, 2);
                root.add(bSlot, 101, 28);
                WItemSlot cSlot = WItemSlot.of(blockInventory, 3);
                root.add(cSlot, 101, 64);
                WItemSlot dSlot = WItemSlot.of(blockInventory, 4);
                root.add(dSlot, 70, 82);
                WItemSlot eSlot = WItemSlot.of(blockInventory, 5);
                root.add(eSlot, 39, 64);
                WItemSlot fSlot = WItemSlot.of(blockInventory, 6);
                root.add(fSlot, 39, 28);


                root.add(this.createPlayerInventoryPanel(), 0, 118);

                root.validate(this);
        }

}
