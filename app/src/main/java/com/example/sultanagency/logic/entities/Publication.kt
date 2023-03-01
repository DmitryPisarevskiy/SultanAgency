package com.example.sultanagency.logic.entities

import java.util.*

class Publication (
        val openDate: Date,
        val closeDate: Date?,
        val adress: String,
        val cost: Int,
        val square: Float,
        val roomsNumber: Int,
        val floorNumber: Int,
        val bathroom: BathRoomType,
        val windowsType: WindowsType,
        val roomsType: RoomsType,
        val balconyType: BalconyType,
    ){

}