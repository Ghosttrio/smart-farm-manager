package com.ghosttrio.smartfarmmanager.controller.greenhouse

import com.ghosttrio.smartfarmmanager.service.DeleteGreenHouseService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/greenhouses")
class DeleteGreenHouseController(
    private val deleteGreenHouseService: DeleteGreenHouseService
) {

    @Operation(description = "등록한 특정 온실 정보를 삭제합니다.")
    @DeleteMapping("/{id}")
    fun deleteGreenHouse(@PathVariable id: Long) {
        deleteGreenHouseService.remove(id)
    }

    @Operation(description = "등록한 모든 온실 정보를 삭제합니다.")
    @DeleteMapping
    fun deleteAllGreenHouse() {
        deleteGreenHouseService.removeAll()
    }
}