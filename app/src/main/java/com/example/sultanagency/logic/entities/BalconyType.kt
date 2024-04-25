package com.example.sultanagency.logic.entities

enum class BalconyType {
    BALCONY, LOGGIA, NO_BALCONY;

    companion object {
        fun getBalconyType(name: String): BalconyType {
            when (name) {
                "BALCONY" ->return BALCONY
                "LOGGIA" ->return LOGGIA
                "NO_BALCONY" ->return NO_BALCONY
            }
            return NO_BALCONY
        }
    }
}