package com.ghosttrio.smartfarmmanager.domain.plant

import jakarta.persistence.*
import lombok.AccessLevel
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "plant")
class Plant(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val kind: String,
    val greenhouseId: Long
) {
}