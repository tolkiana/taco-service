package com.tolkiana.taco.tacoservice.spoonacular.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Recipe(@JsonProperty("extendedIngredients") val ingredients: List<Ingredient>,
                  @JsonProperty("analyzedInstructions") val instructions: List<Instructions>)