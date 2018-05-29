package com.tolkiana.taco.tacoservice.sync

import com.tolkiana.taco.tacoservice.product.ProductService
import com.tolkiana.taco.tacoservice.sync.dto.SyncRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SyncController(val syncService: SyncService, val productService: ProductService) {

    @PostMapping("/sync")
    fun synchronize(@RequestBody request: SyncRequest): String {
        syncService.synchronize(request)
        return "sync'ed!"
    }

    @PostMapping("/sync-products")
    fun synchronizeLocal(): String {
        productService.loadProducts()
        return "sync'ed!"
    }
}