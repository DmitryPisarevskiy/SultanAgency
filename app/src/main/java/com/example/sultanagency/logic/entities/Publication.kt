package com.example.sultanagency.logic.entities

import java.time.LocalDate
import java.util.*

class Publication (
        val openDate: LocalDate,
        val street: String,
        val houseNum: String,
        val flatNum: String,
        val cost: Int,
        val square: Float,
        val roomsNumber: Int,
        val floorNumber: Int,
        val bathroom: BathRoomType,
        val windowsType: WindowsType,
        val roomsType: RoomsType,
        val balconyType: BalconyType,
        var sellerPhone: String? = null,
        var sellerName: String? = null,
        var agentPhone: String? = null,
        var agentName: String? = null,
    ){

        var closeDate: Date? = null
        var isClosed = false
}