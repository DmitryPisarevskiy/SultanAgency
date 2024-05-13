package com.example.sultanagency.presentation.post

import android.content.Context
import com.example.sultanagency.data.firebase.FireBaseRepo
import com.example.sultanagency.data.firebase.IRemoteRepo
import com.example.sultanagency.data.firebase.PublicationDB
import com.example.sultanagency.data.room.AppDataBase
import com.example.sultanagency.data.room.ILocalRepo
import com.example.sultanagency.data.room.RoomRepo
import com.example.sultanagency.logic.entities.Publication
import com.example.sultanagency.presentation.add.IAddFragment

class AddPresenter(val view: IAddFragment, val context: Context) {
    private val remoteRepo: IRemoteRepo = FireBaseRepo()
    private val localRepo: ILocalRepo = RoomRepo(AppDataBase.getDB(context).getPublicationDao())

    suspend fun addRemotePost(post: Publication) {
        remoteRepo.insertPost(post)
    }

    suspend fun addFavPost(post: Publication) {
        val newPost = PublicationDB(
            street = post.street,
            houseNum = post.houseNum,
            flatNum = post.flatNum,
            id = post.id,
        )
        localRepo.insertPost(newPost)
    }

    suspend fun deleteFavPost(postId: String) {
        localRepo.deletePostById(postId)
    }
}