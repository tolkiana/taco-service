package com.tolkiana.taco.tacoservice.recipe.spoonacular.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Recipe(@JsonProperty("title") val title: String,
                  @JsonProperty("image") val image: String,
                  @JsonProperty("extendedIngredients") val ingredients: List<Ingredient>,
                  @JsonProperty("analyzedInstructions") val instructions: List<Instructions>)