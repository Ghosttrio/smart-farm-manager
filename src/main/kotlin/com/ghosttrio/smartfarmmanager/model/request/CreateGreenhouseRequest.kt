package com.ghosttrio.smartfarmmanager.model.request

data class CreateGreenhouseRequest(
    val name: String,
    val location: String,
    val area: Double
)
