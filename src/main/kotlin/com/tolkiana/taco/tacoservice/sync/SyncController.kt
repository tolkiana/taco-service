package com.tolkiana.taco.tacoservice.sync

import com.tolkiana.taco.tacoservice.sync.dto.SyncRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SyncController(val syncService: SyncService) {

    @PostMapping("/sync")
    fun synchronize(@RequestBody request: SyncRequest): String {
        syncService.synchronize(request)
        return "sync'ed!"
    }
}