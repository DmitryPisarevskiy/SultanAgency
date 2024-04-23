package com.example.sultanagency.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PublicationDAO {

    @Insert
    fun insertPost(post: FavouriteDbEntity)

    @Query("SELECT * FROM publications")
    fun getAllPosts(): Flow<List<FavouriteDbEntity>>

    @Delete
    fun deletePost(post: FavouriteDbEntity)

    @Query("DELETE FROM publications WHERE id = :postId")
    fun deletePostById(postId: String)

    @Query("SELECT * FROM publications WHERE id = :postId")
    fun findPostById(postId: String): FavouriteDbEntity?
}