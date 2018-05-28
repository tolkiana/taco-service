package com.tolkiana.taco.tacoservice.recipe.spoonacular

import com.tolkiana.taco.tacoservice.recipe.spoonacular.dto.Recipe
import com.tolkiana.taco.tacoservice.recipe.spoonacular.dto.Search
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "spoonacular", url = "\${feign.client.config.spoonacular.url}")
interface SpoonacularClient {

    @RequestMapping(method = [GET], value = ["/recipes/search"])
    fun searchRecipe(@RequestHeader("X-Mashape-Key") key: String,
                     @RequestHeader("X-Mashape-Host") host: String,
                     @RequestParam("query") query: String,
                     @RequestParam("number") number: Int = 1,
                     @RequestParam("offset") offset: Int = 0): Search

    @RequestMapping(method = [GET], value = ["/recipes/{id}/information"])
    fun getRecipe(@RequestHeader("X-Mashape-Key") key: String,
                  @RequestHeader("X-Mashape-Host") host: String,
                  @PathVariable("id") id: Int): Recipe

}