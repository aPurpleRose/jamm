package io.github.apurplerose.jamm.item.custom;

import io.github.apurplerose.jamm.gui.handler.TutorialBookHandler;
import io.github.apurplerose.jamm.gui.screen.TutorialBookScreen;
import io.github.apurplerose.jamm.item.JammItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class TutorialBookItem extends Item {

        private static final Item.Settings SETTINGS = new FabricItemSettings()
                .group(JammItemGroup.JAMM)
                .maxCount(1);

        public TutorialBookItem() {
                super(SETTINGS);
        }

        @Override
        public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
                if (world.isClient()) {
                        MinecraftClient.getInstance().setScreen(new TutorialBookScreen(new TutorialBookHandler()));
                }
                return super.use(world, user, hand);
        }
}
