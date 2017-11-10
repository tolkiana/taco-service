package com.tolkiana.taco.tacoservice

import org.apache.commons.io.IOUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ResourceLoader
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(val resourceLoader: ResourceLoader) {

    @GetMapping("/tacos")
    fun getTacos(): String {
        return getStringResource("classpath:/tacos.json")
    }

    @GetMapping("/drinks")
    fun getDrinks(): String {
        return getStringResource("classpath:/drinks.json")
    }

    @GetMapping("/salsas")
    fun getSalsas(): String {
        return getStringResource("classpath:/salsas.json")
    }

    private fun getStringResource(file: String): String {
        val resource = resourceLoader.getResource(file)
        val inputStream = resource?.inputStream
        return IOUtils.toString(inputStream)
    }
}