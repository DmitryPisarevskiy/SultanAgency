package com.example.sultanagency.logic.entities

enum class RoomsType {
    COMBINED, SEPARATE;

    companion object {
        fun getRoomsType(name: String): RoomsType {
            when (name) {
                "COMBINED" ->return RoomsType.COMBINED
                "SEPARATE" ->return RoomsType.SEPARATE
            }
            return COMBINED
        }
    }
}