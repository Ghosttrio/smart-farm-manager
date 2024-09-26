package com.ghosttrio.smartfarmmanager.controller.greenhouse

import com.ghosttrio.smartfarmmanager.model.request.CreateGreenHouseRequest
import com.ghosttrio.smartfarmmanager.service.CreateGreenHouseService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/greenhouses")
class CreateGreenHouseController(
    private val createGreenHouseService: CreateGreenHouseService
) {
    @PostMapping
    fun createGreenHouse(@RequestBody request: CreateGreenHouseRequest) {
        createGreenHouseService.create(request.name, request.location, request.area)
    }
}

