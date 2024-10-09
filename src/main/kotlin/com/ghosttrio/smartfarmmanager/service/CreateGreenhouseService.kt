package com.ghosttrio.smartfarmmanager.service

import com.ghosttrio.smartfarmmanager.domain.greenhouse.Greenhouse
import com.ghosttrio.smartfarmmanager.repository.GreenhouseRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateGreenhouseService(
    private val greenhouseRepository: GreenhouseRepository
) {
    @Transactional
    fun create(name: String, location: String, area: Double) {
        val greenhouse = Greenhouse.create(name, location, area)
        greenhouseRepository.save(greenhouse)
    }
}