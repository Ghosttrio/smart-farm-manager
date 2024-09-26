package com.ghosttrio.smartfarmmanager.domain.light

enum class Lamp(val kr: String) {
    INCANDECENT("백열전구"),
    FLUORESCENCE("형광램프"),
    MERCURY("수은램프"),
    METALHALIDE("메탈할레이드램프"),
    HIGHPRESSURESODIUM("고압나트륨램프"),
    LOWPRESSURESODIUMLAMP("저압나트륨램프"),
    LIGHTEMITTINGDIODE("발광다이오드")
}