package com.example.sultanagency.logic.entities

class PublicationFireBase (
    val picturesRef: MutableList<String> = mutableListOf(),
//    val openDate: Long,
    val street: String,
    val houseNum: String,
    val flatNum: String,
    val price: Int,
    val square: Float,
    val kitchenSquare: Float,
    val roomsNumber: Int,
    val floorNumber: Int,
    val ceiling: Float,
    val bathroom: String,
    val windowsType: String,
    val roomsType: String,
    val balconyType: String,
    var sellerPhone: String = "",
    var sellerName: String = "",
    var agentPhone: String = "",
    var agentName: String = "",
    var isFavourite: Boolean = false,
    var isClosed: Boolean = false,
) {
//    var closeDate: Long = 0
    val id = "$street ${houseNum}-$flatNum"
}