package com.example.sultanagency.logic.entities

enum class WindowsType {
    TO_STREET, TO_YARD;

    companion object {
        fun getWindowsType(name: String): WindowsType {
            when (name) {
                "TO_STREET" ->return WindowsType.TO_STREET
                "TO_YARD" ->return WindowsType.TO_YARD
            }
            return TO_YARD
        }
    }
}