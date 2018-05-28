package com.tolkiana.taco.tacoservice.spoonacular.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Result(val id: Int, val title: String, val image: String)