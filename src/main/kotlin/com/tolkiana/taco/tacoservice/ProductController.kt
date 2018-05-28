package com.tolkiana.taco.tacoservice

import org.apache.commons.io.IOUtils
import org.springframework.core.io.ResourceLoader
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(private val resourceLoader: ResourceLoader) {

    @GetMapping("/tacos", produces = [(MediaType.APPLICATION_JSON_VALUE)])
    fun getTacos(): String {
        return getStringResource("classpath:/tacos.json")
    }

    @GetMapping("/drinks", produces = [(MediaType.APPLICATION_JSON_VALUE)])
    fun getDrinks(): String {
        return getStringResource("classpath:/drinks.json")
    }

    @GetMapping("/salsas", produces = [(MediaType.APPLICATION_JSON_VALUE)])
    fun getSalsas(): String {
        return getStringResource("classpath:/salsas.json")
    }

    @GetMapping("/facts", produces = [(MediaType.APPLICATION_JSON_VALUE)])
    fun getFacts(): String {
        return getStringResource("classpath:/facts.json")
    }

    private fun getStringResource(file: String): String {
        val resource = resourceLoader.getResource(file)
        val inputStream = resource?.inputStream
        return IOUtils.toString(inputStream)
    }
}