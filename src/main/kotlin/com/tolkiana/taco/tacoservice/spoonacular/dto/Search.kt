package com.tolkiana.taco.tacoservice.spoonacular.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Search(val results : List<Result>, val baseUri: String)