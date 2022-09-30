package io.github.apurplerose.jamm.recipe;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import io.github.apurplerose.jamm.Jamm;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;

import static net.minecraft.recipe.Ingredient.fromPacket;

public class AstralAltarRecipeSerializer implements RecipeSerializer<AstralAltarRecipe> {

        private AstralAltarRecipeSerializer() {}

        public static final AstralAltarRecipeSerializer INSTANCE = new AstralAltarRecipeSerializer();

        public static final Identifier ID = new Identifier(Jamm.MOD_ID, "astral_altar_recipe");


        @Override
        public AstralAltarRecipe read(Identifier id, JsonObject json) {
                AstralAltarRecipeJsonFormat recipeJson = new Gson().fromJson(json, AstralAltarRecipeJsonFormat.class);

                if (recipeJson.center == null || recipeJson.result == null) {
                        throw new JsonSyntaxException("A required attribute is missing!");
                }
                if (recipeJson.amount == 0) recipeJson.amount = 1;

                Ingredient center = Ingredient.fromJson(recipeJson.center);
                Ingredient offering1 = Ingredient.fromJson(recipeJson.offering1);
                Ingredient offering2 = Ingredient.fromJson(recipeJson.offering2);
                Ingredient offering3 = Ingredient.fromJson(recipeJson.offering3);
                Ingredient offering4 = Ingredient.fromJson(recipeJson.offering4);
                Ingredient offering5 = Ingredient.fromJson(recipeJson.offering5);
                Ingredient offering6 = Ingredient.fromJson(recipeJson.offering6);
                ArrayList<Ingredient> offerings = new ArrayList<>();
                offerings.add(offering1);
                offerings.add(offering2);
                offerings.add(offering3);
                offerings.add(offering4);
                offerings.add(offering5);
                offerings.add(offering6);

                //DefaultedList<Ingredient> ingredients = getIngredients(JsonHelper.getArray(json, "ingredients"));

                Item result = Registry.ITEM.getOrEmpty(new Identifier(recipeJson.result))
                        .orElseThrow(() -> new JsonSyntaxException("No such item " + recipeJson.result));
                ItemStack output = new ItemStack(result, recipeJson.amount);

                return new AstralAltarRecipe(id, center, offerings, /*ingredients,*/ output);
        }

        @Override
        public void write(PacketByteBuf buf, AstralAltarRecipe recipe) {
                recipe.getCenter().write(buf);
                recipe.getOffering(0).write(buf);
                recipe.getOffering(1).write(buf);
                recipe.getOffering(2).write(buf);
                recipe.getOffering(3).write(buf);
                recipe.getOffering(4).write(buf);
                recipe.getOffering(5).write(buf);

                /*DefaultedList<Ingredient> ingredients = recipe.getIngredients();
                buf.writeVarInt(ingredients.size());
                for (Ingredient ingredient : ingredients) {
                        ingredient.write(buf);
                }*/

                buf.writeItemStack(recipe.getOutput());
        }

        @Override
        public AstralAltarRecipe read(Identifier id, PacketByteBuf buf) {
                Ingredient center = fromPacket(buf);
                ArrayList<Ingredient> offerings = new ArrayList<>();
                offerings.add(fromPacket(buf));
                offerings.add(fromPacket(buf));
                offerings.add(fromPacket(buf));
                offerings.add(fromPacket(buf));
                offerings.add(fromPacket(buf));
                offerings.add(fromPacket(buf));

                /*int i = buf.readVarInt();
                DefaultedList<Ingredient> ingredients = DefaultedList.ofSize(i, Ingredient.EMPTY);
                for (int j = 0; j < ingredients.size(); ++j) {
                        ingredients.set(j, Ingredient.fromPacket(buf));
                }*/

                ItemStack output = buf.readItemStack();
                return new AstralAltarRecipe(id, center, offerings, /*ingredients,*/ output);
        }

        private static DefaultedList<Ingredient> getIngredients(JsonArray json) {
                DefaultedList<Ingredient> defaultedList = DefaultedList.of();
                for (int i = 0; i < json.size(); ++i) {
                        Ingredient ingredient = Ingredient.fromJson(json.get(i));
                        if (ingredient.isEmpty()) continue;
                        defaultedList.add(ingredient);
                }
                return defaultedList;
        }
}
