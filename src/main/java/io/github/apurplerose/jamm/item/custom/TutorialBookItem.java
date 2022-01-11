package io.github.apurplerose.jamm.item.custom;

import io.github.apurplerose.jamm.item.JammItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.WrittenBookItem;

public class TutorialBookItem extends WrittenBookItem {

    private static final Settings SETTINGS = new FabricItemSettings()
            .group(JammItemGroup.JAMM)
            .maxCount(1);

    public TutorialBookItem() {
        super(SETTINGS);
    }



}
