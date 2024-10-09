package com.ghosttrio.smartfarmmanager.service

import com.ghosttrio.smartfarmmanager.repository.GreenhouseRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeleteGreenHouseService(
    private val greenHouseRepository: GreenhouseRepository
) {

    @Transactional
    fun remove(id: Long) {
        greenHouseRepository.deleteById(id)
    }

    @Transactional
    fun removeAll() {
        greenHouseRepository.deleteAll()
    }
}