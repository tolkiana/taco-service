package com.tolkiana.taco.tacoservice.sync.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class ProductRequest(@JsonProperty("file") val file: String,
                          @JsonProperty("products") val products: List<ProductSearch>)