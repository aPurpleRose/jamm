package io.github.apurplerose.jamm.blockentity;

import io.github.apurplerose.jamm.gui.AstralAltarGuiDescription;
import io.github.apurplerose.jamm.util.AstralAltarInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;


public class AstralAltarBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, AstralAltarInventory {

        private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(7, ItemStack.EMPTY);

        public AstralAltarBlockEntity(BlockPos pos, BlockState state){
                super(JammBlockEntities.ASTRAL_ALTAR, pos, state);
        }


        @Override
        public DefaultedList<ItemStack> getItems() {
                return inventory;
        }

        @Override
        public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
                return new AstralAltarGuiDescription(syncId, inv, ScreenHandlerContext.create(world, pos));
        }

        @Override
        public Text getDisplayName() {
                return Text.translatable(getCachedState().getBlock().getTranslationKey());
        }

        @Override
        public void readNbt(NbtCompound nbt) {
                super.readNbt(nbt);
                Inventories.readNbt(nbt, this.inventory);
        }

        @Override
        protected void writeNbt(NbtCompound nbt) {
                Inventories.writeNbt(nbt, this.inventory);
                super.writeNbt(nbt);
        }



        //item received with an empty hand right click, look at ItemFrameEntity, has to be adjusted

}
