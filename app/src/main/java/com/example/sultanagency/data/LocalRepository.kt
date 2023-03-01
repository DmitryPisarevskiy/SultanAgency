package com.example.sultanagency.data

import com.example.sultanagency.logic.entities.*
import java.util.*

class LocalRepository {
    val publicationList: MutableList<Publication> = mutableListOf()

    init {
        publicationList.add(
            Publication(
                openDate = Date(1326546468),
                closeDate = null,
                adress = "РБ, г.Салават, ул. Калинина, д.54, кв.36",
                cost = 5000,
                square = 50.2f,
                roomsNumber = 2,
                floorNumber = 4,
                balconyType = BalconyType.BALCONY,
                bathroom = BathRoomType.COMBINED,
                windowsType = WindowsType.TO_YARD,
                roomsType = RoomsType.COMBINED
            )
        )
        publicationList.add(
            Publication(
                openDate = Date(64645213891325),
                closeDate = Date(64645213895000),
                adress = "РБ, г.Салават, ул. Калинина, д.54, кв.36",
                cost = 5000,
                square = 50.2f,
                roomsNumber = 2,
                floorNumber = 4,
                balconyType = BalconyType.BALCONY,
                bathroom = BathRoomType.COMBINED,
                windowsType = WindowsType.TO_YARD,
                roomsType = RoomsType.COMBINED
            )
        )
    }
}