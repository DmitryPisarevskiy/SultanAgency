package com.example.sultanagency.logic.usecases

import com.example.sultanagency.logic.entities.Publication
import com.example.sultanagency.logic.entities.PublicationFireBase

class UkEntityConverter {
    companion object {
        fun getPublicationFireBase(post: Publication): PublicationFireBase {
            return PublicationFireBase(
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
    }
}