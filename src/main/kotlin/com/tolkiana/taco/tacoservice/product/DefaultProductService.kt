package com.tolkiana.taco.tacoservice.product

import com.tolkiana.taco.tacoservice.dto.Product
import com.tolkiana.taco.tacoservice.resource.ResourceService
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap
import javax.annotation.PostConstruct

@Service
class DefaultProductService(val resourceService: ResourceService) : ProductService {

    private var products = ConcurrentHashMap<ProductType, List<Product>>()

    @PostConstruct
    override fun loadProducts() {
        ProductType.values().forEach {
            products[it] = resourceService.getProducts(it.file)
        }
    }

    override fun getProducts(productType: ProductType) : List<Product> {
        return products[productType] ?: throw ServerException("The ProductType: $productType was not loaded.")
    }
}