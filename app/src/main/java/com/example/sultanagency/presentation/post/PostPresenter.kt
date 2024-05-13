package com.example.sultanagency.presentation.post

import android.content.Context
import com.example.sultanagency.data.firebase.FireBaseRepo
import com.example.sultanagency.data.firebase.IRemoteRepo
import com.example.sultanagency.data.room.AppDataBase
import com.example.sultanagency.data.room.ILocalRepo
import com.example.sultanagency.data.room.RoomRepo
import com.example.sultanagency.logic.entities.Publication

class PostPresenter(val view: IPostFragment, val context: Context) {
        private val remoteRepo: IRemoteRepo = FireBaseRepo()
        private val localRepo: ILocalRepo = RoomRepo(AppDataBase.getDB(context).getPublicationDao())

    suspend fun addRemotePost(post: Publication) {
        remoteRepo.insertPost(post)
    }

    suspend fun deleteRemotePost(postId: String) {
        remoteRepo.deletePostById(postId)
    }

    suspend fun deleteLocalPost(postId: String) {
        localRepo.deletePostById(postId)
    }

}