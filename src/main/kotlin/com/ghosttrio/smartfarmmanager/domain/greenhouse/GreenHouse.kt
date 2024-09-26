package com.ghosttrio.smartfarmmanager.domain.greenhouse

import com.ghosttrio.smartfarmmanager.domain.common.BaseTime
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.AccessLevel
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "greenhouse")
class GreenHouse(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val location: String,
    val area: Double
) : BaseTime() {
    companion object {
        fun create(name: String, location: String, area: Double): GreenHouse {
            return GreenHouse(name = name, location = location, area = area)
        }
    }
}

/**
 * 온실 정보
 * - id
 * - 온실이름
 * - 온실위치
 * - 온실 데이터 생성일
 * - 온실 데이터 수정일
 * - 온실 설비
 */