package com.example.sultanagency.logic.entities

import android.graphics.Bitmap
import java.time.LocalDate
import java.util.*

class Publication (
        val pictures: MutableList<Bitmap> = mutableListOf(),
        val picturesRef: MutableList<String> = mutableListOf(),
        val openDate: LocalDate,
        val street: String,
        val houseNum: String,
        val flatNum: String,
        val price: Int,
        val square: Float,
        val kitchenSquare: Float,
        val roomsNumber: Int,
        val floorNumber: Int,
        val ceiling: Float,
        val bathroom: BathRoomType,
        val windowsType: WindowsType,
        val roomsType: RoomsType,
        val balconyType: BalconyType,
        var sellerPhone: String? = null,
        var sellerName: String? = null,
        var agentPhone: String? = null,
        var agentName: String? = null,
        var isFavourite: Boolean = false,
        var closeDate: Date? = null,
        var isClosed: Boolean = false,
    ) {
        val id = "$street ${houseNum}-$flatNum"
}