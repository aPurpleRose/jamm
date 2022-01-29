package io.github.apurplerose.jamm.block.custom;

import io.github.apurplerose.jamm.blockentity.JammBlockEntities;
import io.github.apurplerose.jamm.blockentity.LunarAltarBlockEntity;
import io.github.apurplerose.jamm.item.custom.JammArmorItem;
import io.github.apurplerose.jamm.item.custom.armor.AbstractArmorItem;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LunarAltarBlock extends AbstractAltarBlock {

        public LunarAltarBlock(){
                super();
        }

        @Override
        public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
                return new LunarAltarBlockEntity(pos, state);
        }

        @Override
        public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
                return checkType(type, JammBlockEntities.LUNAR_ALTAR, (world1, pos, state1, lae)
                        -> LunarAltarBlockEntity.tick(world1, pos, state1, (LunarAltarBlockEntity) lae));
        }

        @Override
        public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

                if (!world.isClient() && hand == Hand.MAIN_HAND) {
                        LunarAltarBlockEntity lae;
                        if (state.hasBlockEntity()) {
                                lae = (LunarAltarBlockEntity) world.getBlockEntity(pos);
                                int magic = lae.getMagic();

                                ItemStack chestplate = player.getInventory().getArmorStack(2);

                                if (chestplate.getItem() instanceof AbstractArmorItem) {
                                        AbstractArmorItem aai = (AbstractArmorItem) chestplate.getItem();
                                        int missing_magic = aai.missingMagic(chestplate);

                                        if (magic >= missing_magic) {
                                                lae.removeMagic(missing_magic);
                                                aai.addMagic(chestplate, missing_magic);
                                        } else {
                                                lae.removeMagic(magic);
                                                aai.addMagic(chestplate, magic);
                                        }
                                }
                        }
                }

                return super.onUse(state, world, pos, player, hand, hit);
        }
}
