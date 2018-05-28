package com.tolkiana.taco.tacoservice.spoonacular.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Instructions(@JsonProperty("steps") val instructions: List<Instruction>)