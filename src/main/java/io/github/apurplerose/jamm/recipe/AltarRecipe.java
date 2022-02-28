package io.github.apurplerose.jamm.recipe;

import io.github.apurplerose.jamm.util.ImplementedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class AltarRecipe implements Recipe<ImplementedInventory> {

        private final Ingredient inputA;
        private final Ingredient inputB;
        private final ItemStack result;
        private final Identifier id;

        public AltarRecipe(Identifier id, Ingredient inputA, Ingredient inputB, ItemStack result) {
                this.id = id;
                this.inputA = inputA;
                this.inputB = inputB;
                this.result = result;
        }


        public Ingredient getInputA(){
                return this.inputA;
        }

        public Ingredient getInputB(){
                return this.inputB;
        }

        @Override
        public ItemStack getOutput() {
                return this.result;
        }

        @Override
        public Identifier getId() {
                return this.id;
        }

        @Override
        public ItemStack craft(ImplementedInventory inventory) {
                return this.getOutput().copy();
        }

        @Override
        public boolean fits(int width, int height) {
                return true;
        }

        public boolean matches(ImplementedInventory inventory, World world) {
                if (inventory.size() < 2) return false;
                return inputA.test(inventory.getStack(0)) && inputB.test(inventory.getStack(1));
        }

        public static class Type implements RecipeType<AltarRecipe> {
                private Type() {}
                public static final Type INSTANCE = new Type();
                public static final String ID = "altar_recipe";
        }
        @Override
        public RecipeType<?> getType() {
                return Type.INSTANCE;
        }

        @Override
        public RecipeSerializer<?> getSerializer() {
                return AltarRecipeSerializer.INSTANCE;
        }
}
