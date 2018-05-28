package com.tolkiana.taco.tacoservice.recipe.spoonacular

import com.tolkiana.taco.tacoservice.dto.Product
import com.tolkiana.taco.tacoservice.recipe.RecipeService
import com.tolkiana.taco.tacoservice.recipe.spoonacular.dto.Recipe
import org.springframework.stereotype.Service
import java.util.function.Function

@Service
class SpoonacularRecipeService(private val client: SpoonacularClient,
                               private val config: SpoonacularConfiguration,
                               private val mapper: Function<Recipe, Product>): RecipeService {

    private val invalidConfigurationMessage = "Spoonacular's Client is not appropriately configured."

    override fun searchRecipeForProduct(productSearch: String): Product {
        val key = config.key ?: throw IllegalStateException(invalidConfigurationMessage)
        val host = config.host ?: throw IllegalStateException(invalidConfigurationMessage)

        val search = client.searchRecipe(key, host, productSearch)
        val recipe = client.getRecipe(key, host, search.results.first().id)
        return mapper.apply(recipe)
    }
}