package com.tolkiana.taco.tacoservice.product

import com.tolkiana.taco.tacoservice.dto.Product

interface ProductService {

    fun loadProducts()

    fun getProducts(productType: ProductType): List<Product>
}