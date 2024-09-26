package com.ghosttrio.smartfarmmanager.model.request

data class CreateGreenHouseRequest(
    val name: String,
    val location: String,
    val area: Double
)
