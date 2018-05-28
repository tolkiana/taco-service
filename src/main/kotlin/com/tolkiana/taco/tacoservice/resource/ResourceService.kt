package com.tolkiana.taco.tacoservice.resource

import com.tolkiana.taco.tacoservice.dto.Product

interface ResourceService {

    fun uploadProducts(name: String, product: List<Product>)

    fun getProducts(name: String): List<Product>
}