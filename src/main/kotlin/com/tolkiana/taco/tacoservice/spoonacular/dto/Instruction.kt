package com.tolkiana.taco.tacoservice.spoonacular.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Instruction(@JsonProperty("number") val number: Int,
                       @JsonProperty("step") val action: String)