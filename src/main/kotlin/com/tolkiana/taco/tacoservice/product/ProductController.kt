package com.tolkiana.taco.tacoservice.product

import com.tolkiana.taco.tacoservice.dto.Product
import org.apache.commons.io.IOUtils
import org.springframework.core.io.ResourceLoader
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(private val resourceLoader: ResourceLoader, val productService: ProductService) {

    @GetMapping("/tacos", produces = [(MediaType.APPLICATION_JSON_VALUE)])
    fun getTacos(): List<Product> {
        return productService.getProducts(ProductType.TACO)
    }

    @GetMapping("/drinks", produces = [(MediaType.APPLICATION_JSON_VALUE)])
    fun getDrinks(): List<Product> {
        return productService.getProducts(ProductType.DRINK)
    }

    @GetMapping("/salsas", produces = [(MediaType.APPLICATION_JSON_VALUE)])
    fun getSalsas(): List<Product> {
        return productService.getProducts(ProductType.SALSA)
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