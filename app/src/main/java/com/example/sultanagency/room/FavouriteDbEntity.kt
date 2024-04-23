package com.example.sultanagency.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName="publications",
    indices = [Index("id")]
)
data class FavouriteDbEntity (
    @PrimaryKey val id: String,
//    val pictures: MutableList<Bitmap> = mutableListOf(),
//    val openDate: LocalDate,
    @ColumnInfo(name = "street") val street: String,
    @ColumnInfo(name = "house_num") val houseNum: String,
    @ColumnInfo(name = "flat_num") val flatNum: String,
//    val price: Int,
//    val square: Float,
//    val kitchenSquare: Float,
//    val roomsNumber: Int,
//    val floorNumber: Int,
//    val ceiling: Float,
//    val bathroom: BathRoomType,
//    val windowsType: WindowsType,
//    val roomsType: RoomsType,
//    val balconyType: BalconyType,
//    var sellerPhone: String? = null,
//    var sellerName: String? = null,
//    var agentPhone: String? = null,
//    var agentName: String? = null,
//    var closeDate: Date? = null,
//    var isClosed = false
)