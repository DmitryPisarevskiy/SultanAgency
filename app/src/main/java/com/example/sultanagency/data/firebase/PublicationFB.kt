package com.example.sultanagency.data.firebase

class PublicationFB (
    val picturesRef: MutableList<String> = mutableListOf(),
//    val openDate: Long,
    val street: String = "",
    val houseNum: String= "",
    val flatNum: String= "",
    val price: Int=0,
    val square: Float=0f,
    val kitchenSquare: Float=0f,
    val roomsNumber: Int=0,
    val floorNumber: Int=0,
    val ceiling: Float=0f,
    val bathroom: String= "",
    val windowsType: String= "",
    val roomsType: String= "",
    val balconyType: String= "",
    var sellerPhone: String = "",
    var sellerName: String = "",
    var agentPhone: String = "",
    var agentName: String = "",
    var isFavourite: Boolean = false,
    var isClosed: Boolean = false,
) {
//    var closeDate: Long = 0
//    val id = "$street ${houseNum}-$flatNum"
}