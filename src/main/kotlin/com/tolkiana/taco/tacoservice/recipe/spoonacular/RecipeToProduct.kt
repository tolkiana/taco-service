package com.tolkiana.taco.tacoservice.recipe.spoonacular

import com.tolkiana.taco.tacoservice.dto.Product
import com.tolkiana.taco.tacoservice.recipe.spoonacular.dto.Recipe
import org.springframework.stereotype.Component
import java.util.UUID
import java.util.function.Function

@Component
class RecipeToProduct : Function<Recipe, Product> {

    override fun apply(recipe: Recipe): Product {
        val ingredients = recipe.ingredients
                .map { it.original }
        val instructions = recipe.instructions
        val preparation = if (instructions.isEmpty()) emptyList() else instructions.first().steps.map { it.action }
        return Product(UUID.randomUUID().toString(), recipe.title, recipe.image, ingredients, preparation)
    }
}