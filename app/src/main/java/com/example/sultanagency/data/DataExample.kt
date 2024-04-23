package com.example.sultanagency.data

import android.annotation.TargetApi
import android.graphics.BitmapFactory
import android.os.Build
import com.example.sultanagency.App
import com.example.sultanagency.R
import com.example.sultanagency.logic.entities.BalconyType
import com.example.sultanagency.logic.entities.BathRoomType
import com.example.sultanagency.logic.entities.Publication
import com.example.sultanagency.logic.entities.RoomsType
import com.example.sultanagency.logic.entities.WindowsType
import java.time.LocalDate

@TargetApi(Build.VERSION_CODES.O)
object DataExample {
    var list: MutableList<Publication> = mutableListOf()

    init {
        val flat1 = Publication(
            pictures = mutableListOf(BitmapFactory.decodeResource(App.get().resources, R.drawable.flat)),
            openDate = LocalDate.of(2024,1,1),
            street = "ул. Калинина",
            houseNum = "54а",
            flatNum = "36",
            price = 1564,
            square = 40.5f,
            kitchenSquare = 4.2f,
            roomsNumber = 2,
            floorNumber = 4,
            ceiling = 3.2f,
            bathroom = BathRoomType.COMBINED,
            windowsType = WindowsType.TO_YARD,
            roomsType = RoomsType.COMBINED,
            balconyType = BalconyType.BALCONY,
            agentName = "Данил",
            agentPhone = "+7-987-333-22-22"
        )
        val flat2 = Publication(
            pictures = mutableListOf(BitmapFactory.decodeResource(App.get().resources, R.drawable.flat2)),
            openDate = LocalDate.of(2021,8,2),
            street = "ул. Губкина",
            houseNum = "6",
            flatNum = "69",
            price = 2354,
            square = 35.5f,
            kitchenSquare = 4.8f,
            roomsNumber = 3,
            floorNumber = 4,
            ceiling = 2.5f,
            bathroom = BathRoomType.SEPARATE,
            windowsType = WindowsType.TO_YARD,
            roomsType = RoomsType.COMBINED,
            balconyType = BalconyType.BALCONY,
            agentName = "Эльвира",
            agentPhone = "+7-987-222-22-22"
        )
        val flat3 = Publication(
            pictures = mutableListOf(BitmapFactory.decodeResource(App.get().resources, R.drawable.flat3)),
            openDate = LocalDate.of(2022,7,4),
            street = "ул. Костянова",
            houseNum = "16",
            flatNum = "58",
            price = 5555,
            square = 135.5f,
            kitchenSquare = 40.2f,
            roomsNumber = 3,
            floorNumber = 2,
            ceiling = 2.5f,
            bathroom = BathRoomType.SEPARATE,
            windowsType = WindowsType.TO_STREET,
            roomsType = RoomsType.SEPARATE,
            balconyType = BalconyType.LOGGIA,
            agentName = "Константин",
            agentPhone = "+7-987-777-58-85"
        )
        val flat4 = Publication(
            pictures = mutableListOf(BitmapFactory.decodeResource(App.get().resources, R.drawable.flat4)),
            openDate = LocalDate.of(2023,12,1),
            street = "ул. Ишимбайская",
            houseNum = "16",
            flatNum = "65",
            price = 5555,
            square = 135.5f,
            kitchenSquare = 3.2f,
            roomsNumber = 5,
            floorNumber = 12,
            ceiling = 2.85f,
            bathroom = BathRoomType.COMBINED,
            windowsType = WindowsType.TO_STREET,
            roomsType = RoomsType.COMBINED,
            balconyType = BalconyType.LOGGIA,
            agentName = "Руфина",
            agentPhone = "+7-905-333-21-12"
        )
        val flat5 = Publication(
            pictures = mutableListOf(BitmapFactory.decodeResource(App.get().resources, R.drawable.flat5)),
            openDate = LocalDate.of(2023,6,6),
            street = "ул. Лесопарковая",
            houseNum = "20",
            flatNum = "60",
            price = 3500,
            square = 75.5f,
            kitchenSquare = 4.2f,
            roomsNumber = 3,
            floorNumber = 7,
            ceiling = 2.9f,
            bathroom = BathRoomType.COMBINED,
            windowsType = WindowsType.TO_STREET,
            roomsType = RoomsType.COMBINED,
            balconyType = BalconyType.LOGGIA,
            agentName = "Альберт",
            agentPhone = "+7-937-123-34-54"
        )
        list.add(flat1)
        list.add(flat2)
        list.add(flat3)
        list.add(flat4)
        list.add(flat5)
    }
}