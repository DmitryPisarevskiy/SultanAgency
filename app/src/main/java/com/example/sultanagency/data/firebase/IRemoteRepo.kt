package com.example.sultanagency.data.firebase

import androidx.lifecycle.LiveData
import com.example.sultanagency.logic.entities.Publication
import com.example.sultanagency.logic.entities.PublicationFB
import kotlinx.coroutines.flow.Flow

interface IRemoteRepo {
    suspend fun insertPost(post: Publication)

    fun getAllPosts(): LiveData<List<Publication>>

    suspend fun deletePostById(postId: String)

    suspend fun findPostById(postId: String): PublicationFB?
}