package com.ghosttrio.smartfarmmanager.controller.greenhouse

import com.ghosttrio.smartfarmmanager.service.DeleteGreenHouseService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/greenhouses")
class DeleteGreenHouseController(
    private val deleteGreenHouseService: DeleteGreenHouseService
) {

    @DeleteMapping("/{id}")
    fun deleteGreenHouse(@PathVariable id: Long) {
        deleteGreenHouseService.remove(id)
    }

    @DeleteMapping
    fun deleteAllGreenHouse() {
        deleteGreenHouseService.removeAll()
    }
}