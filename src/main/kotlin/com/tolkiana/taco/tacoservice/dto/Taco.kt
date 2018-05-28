package com.tolkiana.taco.tacoservice.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Taco(@JsonProperty("code") val code: String,
                @JsonProperty("name") val name: String,
                @JsonProperty("imageURL") val imageUrl: String,
                @JsonProperty("ingredients") val ingredients: List<String>,
                @JsonProperty("preparation") val preparation: List<String>,
                @JsonProperty("pairingSalsas") val pairingSalsas: List<String>)