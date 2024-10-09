package com.ghosttrio.smartfarmmanager.repository

import com.ghosttrio.smartfarmmanager.domain.greenhouse.Greenhouse
import org.springframework.data.jpa.repository.JpaRepository

interface GreenhouseRepository: JpaRepository<Greenhouse, Long> {
}