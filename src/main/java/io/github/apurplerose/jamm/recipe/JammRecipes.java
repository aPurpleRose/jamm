package io.github.apurplerose.jamm.recipe;

import io.github.apurplerose.jamm.Jamm;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class JammRecipes {

        public static void registerRecipes() {
                Registry.register(Registry.RECIPE_SERIALIZER, AstralAltarRecipeSerializer.ID, AstralAltarRecipeSerializer.INSTANCE);
                Registry.register(Registry.RECIPE_TYPE, new Identifier(Jamm.MOD_ID, AstralAltarRecipe.Type.ID), AstralAltarRecipe.Type.INSTANCE);
        }

}
