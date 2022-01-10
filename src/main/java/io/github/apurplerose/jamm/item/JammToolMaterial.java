package io.github.apurplerose.jamm.item;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum JammToolMaterial implements ToolMaterial {
    /*WOOD(MiningLevels.WOOD, 59, 2.0F, 0.0F, 15, () -> {
        return Ingredient.fromTag(ItemTags.PLANKS);
    }),
    STONE(MiningLevels.STONE, 131, 4.0F, 1.0F, 5, () -> {
        return Ingredient.fromTag(ItemTags.STONE_TOOL_MATERIALS);
    }),
    IRON(MiningLevels.IRON, 250, 6.0F, 2.0F, 14, () -> {
        return Ingredient.ofItems(Items.IRON_INGOT);
    }),
    DIAMOND(MiningLevels.DIAMOND, 1561, 8.0F, 3.0F, 10, () -> {
        return Ingredient.ofItems(Items.DIAMOND);
    }),
    GOLD(MiningLevels.WOOD, 32, 12.0F, 0.0F, 22, () -> {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }),
    NETHERITE(MiningLevels.NETHERITE, 2031, 9.0F, 4.0F, 15, () -> {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    });*/
    AMETHYST(MiningLevels.IRON, 750, 7.0F, 2.5F, 22, Ingredient.ofItems(JammItems.AMETHYST));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Ingredient repairIngredient;

    private JammToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Ingredient repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }
}
