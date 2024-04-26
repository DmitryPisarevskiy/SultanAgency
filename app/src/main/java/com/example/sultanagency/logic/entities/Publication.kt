package com.example.sultanagency.logic.entities

import android.graphics.Bitmap
import java.time.LocalDate
import java.util.*

class Publication (
        var pictures: MutableList<Bitmap> = mutableListOf(),
        var picturesRef: MutableList<String> = mutableListOf(),
        var openDate: LocalDate? = null,
        val street: String,
        val houseNum: String,
        val flatNum: String,
        var price: Int,
        var square: Float,
        var kitchenSquare: Float,
        var roomsNumber: Int,
        var floorNumber: Int,
        var ceiling: Float,
        var bathroom: BathRoomType,
        var windowsType: WindowsType,
        var roomsType: RoomsType,
        var balconyType: BalconyType,
        var sellerPhone: String? = null,
        var sellerName: String? = null,
        var agentPhone: String? = null,
        var agentName: String? = null,
        var isFavourite: Boolean = false,
        var closeDate: Date? = null,
        var isClosed: Boolean = false,
    ) {
        val id = "$street ${houseNum}-$flatNum".replace(".", "")
}