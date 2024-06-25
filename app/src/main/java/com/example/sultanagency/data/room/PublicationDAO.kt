package com.example.sultanagency.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PublicationDAO {

    @Insert
    suspend fun insertPost(post: PublicationDB)

    @Query("SELECT * FROM publications")
    fun getAllPosts(): Flow<List<PublicationDB>>

    @Delete
    suspend fun deletePost(post: PublicationDB)

    @Query("DELETE FROM publications WHERE id = :postId")
    suspend fun deletePostById(postId: String)

    @Query("SELECT * FROM publications WHERE id = :postId")
    suspend fun findPostById(postId: String): PublicationDB?
}