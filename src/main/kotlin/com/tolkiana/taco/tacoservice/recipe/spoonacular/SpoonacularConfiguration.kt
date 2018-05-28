package com.tolkiana.taco.tacoservice.recipe.spoonacular

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "spoonacular")
class SpoonacularConfiguration {
    var key: String? = null
    var host: String? = null
}