package com.tolkiana.taco.tacoservice.recipe.spoonacular.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Ingredient(val original: String)