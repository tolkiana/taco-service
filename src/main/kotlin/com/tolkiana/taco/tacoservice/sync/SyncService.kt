package com.tolkiana.taco.tacoservice.sync

import com.tolkiana.taco.tacoservice.product.ProductService
import com.tolkiana.taco.tacoservice.recipe.RecipeNotFoundException
import com.tolkiana.taco.tacoservice.recipe.RecipeService
import com.tolkiana.taco.tacoservice.resource.ResourceService
import com.tolkiana.taco.tacoservice.sync.dto.SyncRequest
import org.springframework.stereotype.Service

@Service
class SyncService(val resourceService: ResourceService, val recipeService: RecipeService, val productService: ProductService) {

    fun synchronize(request: SyncRequest) {
        request.sync.forEach {
            val products = it.products.mapNotNull {
                try {
                    recipeService.searchRecipeForProduct(it.search)
                } catch (e: RecipeNotFoundException) {
                    null
                }
            }
            resourceService.uploadProducts(it.file, products)
            productService.loadProducts()
        }
    }
}