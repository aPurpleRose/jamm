package io.github.apurplerose.jamm.recipe;

import io.github.apurplerose.jamm.util.AstralAltarInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.ArrayList;

public class AstralAltarRecipe implements Recipe<AstralAltarInventory> {

        private final Ingredient center;
        private final ArrayList<Ingredient> offerings;
        //private final DefaultedList<Ingredient> ingredients;
        private final ItemStack output;
        private final Identifier id;

        public AstralAltarRecipe(Identifier id, Ingredient center, ArrayList<Ingredient> offerings, /*DefaultedList<Ingredient> ingredients,*/ ItemStack output){
                this.id = id;
                this.center = center;
                this.offerings = offerings;
                this.output = output;
                //this.ingredients = ingredients;
        }

        @Override
        public Identifier getId() {
                return this.id;
        }

        @Override
        public RecipeSerializer<?> getSerializer() {
                return AstralAltarRecipeSerializer.INSTANCE;
        }

        @Override
        public ItemStack getOutput() {
                return this.output;
        }

        public Ingredient getCenter() {
                return this.center;
        }

        public Ingredient getOffering(int i) {
                return this.offerings.get(i);
        }

        /*public DefaultedList<Ingredient> getIngredients() {
                return this.ingredients;
        }*/

        @Override
        public boolean fits(int width, int height) {
              return true;
        }

        public boolean matches(AstralAltarInventory inventory, World world) {
                return center.test(inventory.getStack(0))
                        && offerings.get(0).test(inventory.getStack(1)) && offerings.get(1).test(inventory.getStack(2))
                        && offerings.get(2).test(inventory.getStack(3)) && offerings.get(3).test(inventory.getStack(4))
                        && offerings.get(4).test(inventory.getStack(5)) && offerings.get(5).test(inventory.getStack(6));
        }

        @Override
        public ItemStack craft(AstralAltarInventory inventory) {
                return this.getOutput().copy();
        }

        public static class Type implements RecipeType<AstralAltarRecipe> {
                private Type() {}
                public static final Type INSTANCE = new Type();
                public static final String ID = "astral_altar_recipe";
        }
        @Override
        public RecipeType<?> getType() {
                return Type.INSTANCE;
        }

}
