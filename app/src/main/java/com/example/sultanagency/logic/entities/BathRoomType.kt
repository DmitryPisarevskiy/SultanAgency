package com.example.sultanagency.logic.entities

enum class BathRoomType {
    COMBINED, SEPARATE;

    companion object {
        fun getBathRoomType(name: String): BathRoomType {
            when (name) {
                "COMBINED" ->return BathRoomType.COMBINED
                "SEPARATE" ->return BathRoomType.SEPARATE
            }
            return COMBINED
        }
    }
}