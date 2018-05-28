package com.tolkiana.taco.tacoservice.sync.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class ProductSearch(@JsonProperty("search") val search: String)