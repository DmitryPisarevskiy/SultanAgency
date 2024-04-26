package com.example.sultanagency.presentation.fav

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.sultanagency.data.firebase.FireBaseRepo
import com.example.sultanagency.data.firebase.IRemoteRepo
import com.example.sultanagency.data.firebase.PublicationDB
import com.example.sultanagency.data.room.AppDataBase
import com.example.sultanagency.data.room.ILocalRepo
import com.example.sultanagency.data.room.RoomRepo
import com.example.sultanagency.logic.entities.Publication
import kotlinx.coroutines.flow.Flow

class FavPresenter(val view: IFavFragment, val context: Context) {
    private val remoteRepo: IRemoteRepo = FireBaseRepo()
    private val localRepo: ILocalRepo = RoomRepo(AppDataBase.getDB(context).getPublicationDao())
    fun getRemoteList(): LiveData<List<Publication>> = remoteRepo.getAllPosts()
    fun getLocalList(): Flow<List<PublicationDB>> = localRepo.getAllPosts()
}