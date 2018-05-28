package com.tolkiana.taco.tacoservice.recipe

import com.tolkiana.taco.tacoservice.dto.Product

interface RecipeService {

    fun searchRecipeForProduct(productSearch: String): Product
}