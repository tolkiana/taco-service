package com.tolkiana.taco.tacoservice.product

import com.tolkiana.taco.tacoservice.dto.Product

interface ProductService {

    fun getProducts(productType: ProductType): List<Product>
}