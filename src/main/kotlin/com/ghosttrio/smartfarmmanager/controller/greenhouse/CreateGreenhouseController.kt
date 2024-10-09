package com.ghosttrio.smartfarmmanager.controller.greenhouse

import com.ghosttrio.smartfarmmanager.model.request.CreateGreenhouseRequest
import com.ghosttrio.smartfarmmanager.service.CreateGreenhouseService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/greenhouses")
class CreateGreenhouseController(
    private val createGreenhouseService: CreateGreenhouseService
) {

    @Operation(description = "온실 정보를 등록합니다.")
    @PostMapping
    fun createGreenhouse(@RequestBody request: CreateGreenhouseRequest) {
        createGreenhouseService.create(request.name, request.location, request.area)
    }
}

