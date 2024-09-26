package com.ghosttrio.smartfarmmanager.service

import com.ghosttrio.smartfarmmanager.domain.greenhouse.GreenHouse
import com.ghosttrio.smartfarmmanager.repository.GreenHouseRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateGreenHouseService(
    private val greenHouseRepository: GreenHouseRepository
) {

    @Transactional
    fun create(name: String, location: String, area: Double) {
        val greenhouse = GreenHouse.create(name, location, area)
        greenHouseRepository.save(greenhouse)
    }
}