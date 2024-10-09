package com.ghosttrio.smartfarmmanager.controller.greenhouse

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/greenhouses")
class UpdateGreenhouseController {

    @Operation(description = "온실 정보를 수정합니다.")
    @PatchMapping
    fun updateGreenhouse() {
    }
}