package com.example.sultanagency.data.room

import kotlinx.coroutines.flow.Flow

interface ILocalRepo {
    suspend fun insertPost(post: PublicationDB)

    fun getAllPosts(): Flow<List<PublicationDB>>

    suspend fun deletePost(post: PublicationDB)

    suspend fun deletePostById(postId: String)

    suspend fun findPostById(postId: String): PublicationDB?
}