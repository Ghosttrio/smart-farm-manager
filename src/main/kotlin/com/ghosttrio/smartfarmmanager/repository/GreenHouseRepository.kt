package com.ghosttrio.smartfarmmanager.repository

import com.ghosttrio.smartfarmmanager.domain.greenhouse.GreenHouse
import org.springframework.data.jpa.repository.JpaRepository

interface GreenHouseRepository: JpaRepository<GreenHouse, Long> {
}