package com.example.sultanagency.logic.usecases

import com.example.sultanagency.logic.entities.BalconyType
import com.example.sultanagency.logic.entities.BathRoomType
import com.example.sultanagency.logic.entities.Publication
import com.example.sultanagency.logic.entities.PublicationFB
import com.example.sultanagency.logic.entities.RoomsType
import com.example.sultanagency.logic.entities.WindowsType

class UkEntityConverter {
    companion object {
        fun getPostFB(post: Publication): PublicationFB {
            return PublicationFB(
                picturesRef=post.picturesRef,
//                openDate=post.openDate,
                street= post.street,
                houseNum= post.houseNum,
                flatNum= post.flatNum,
                price= post.price,
                square= post.square,
                kitchenSquare= post.kitchenSquare,
                roomsNumber= post.roomsNumber,
                floorNumber= post.floorNumber,
                ceiling= post.ceiling,
                bathroom= post.bathroom.toString(),
                windowsType= post.windowsType.toString(),
                roomsType= post.roomsType.toString(),
                balconyType= post.balconyType.toString(),
                sellerPhone= post.sellerPhone?:"",
                sellerName= post.sellerName?:"",
                agentPhone= post.agentPhone?:"",
                agentName= post.agentName?:"",
                isFavourite= post.isFavourite,
//                closeDate= ,
                isClosed = post.isClosed,
            )
        }

        fun getPostFromFB(post: PublicationFB): Publication {
            return Publication(
                picturesRef=post.picturesRef,
//                openDate=post.openDate,
                street= post.street,
                houseNum= post.houseNum,
                flatNum= post.flatNum,
                price= post.price,
                square= post.square,
                kitchenSquare= post.kitchenSquare,
                roomsNumber= post.roomsNumber,
                floorNumber= post.floorNumber,
                ceiling= post.ceiling,
                bathroom= BathRoomType.getBathRoomType(post.bathroom),
                windowsType= WindowsType.getWindowsType(post.windowsType),
                roomsType= RoomsType.getRoomsType(post.roomsType),
                balconyType= BalconyType.getBalconyType(post.balconyType),
                sellerPhone= post.sellerPhone?:"",
                sellerName= post.sellerName?:"",
                agentPhone= post.agentPhone?:"",
                agentName= post.agentName?:"",
                isFavourite= post.isFavourite,
//                closeDate= ,
                isClosed = post.isClosed,
            )
        }
    }
}