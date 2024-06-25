package com.example.sultanagency.data.room

import kotlinx.coroutines.flow.Flow

class RoomRepo(val dao: PublicationDAO): ILocalRepo {
    override suspend fun insertPost(post: PublicationDB) {
        dao.insertPost(post)
    }

    override fun getAllPosts(): Flow<List<PublicationDB>> {
        return dao.getAllPosts()
    }

    override suspend fun deletePost(post: PublicationDB) {
        dao.deletePost(post)
    }

    override suspend fun deletePostById(postId: String) {
        dao.deletePostById(postId)
    }

    override suspend fun findPostById(postId: String): PublicationDB? {
        return dao.findPostById(postId)
    }
}