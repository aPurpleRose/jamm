package io.github.apurplerose.jamm.recipe;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import io.github.apurplerose.jamm.Jamm;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AltarRecipeSerializer implements RecipeSerializer<AltarRecipe> {

        private AltarRecipeSerializer() {}

        public static final AltarRecipeSerializer INSTANCE = new AltarRecipeSerializer();

        public static final Identifier ID = new Identifier(Jamm.MOD_ID, "altar_recipe");


        @Override
        public AltarRecipe read(Identifier id, JsonObject json) {
                AltarRecipeJsonFormat recipeJson = new Gson().fromJson(json, AltarRecipeJsonFormat.class);

                if (recipeJson.inputA == null || recipeJson.inputB == null || recipeJson.result == null) {
                        throw new JsonSyntaxException("A required attribute is missing!");
                }
                if (recipeJson.amount == 0) recipeJson.amount = 1;

                Ingredient inputA = Ingredient.fromJson(recipeJson.inputA);
                Ingredient inputB = Ingredient.fromJson(recipeJson.inputB);

                Item result = Registry.ITEM.getOrEmpty(new Identifier(recipeJson.result))
                        .orElseThrow(() -> new JsonSyntaxException("No such item " + recipeJson.result));
                ItemStack output = new ItemStack(result, recipeJson.amount);

                return new AltarRecipe(id, inputA, inputB, output);
        }

        @Override
        public void write(PacketByteBuf buf, AltarRecipe recipe) {
                recipe.getInputA().write(buf);
                recipe.getInputB().write(buf);
                buf.writeItemStack(recipe.getOutput());
        }

        @Override
        public AltarRecipe read(Identifier id, PacketByteBuf buf) {
                Ingredient inputA = Ingredient.fromPacket(buf);
                Ingredient inputB = Ingredient.fromPacket(buf);
                ItemStack output = buf.readItemStack();
                return new AltarRecipe(id, inputA, inputB, output);
        }
}
