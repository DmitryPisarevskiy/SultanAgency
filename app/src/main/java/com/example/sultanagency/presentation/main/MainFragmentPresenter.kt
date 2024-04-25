package com.example.sultanagency.presentation.main

import androidx.lifecycle.LiveData
import com.example.sultanagency.data.firebase.FireBaseRepo
import com.example.sultanagency.data.firebase.IRemoteRepo
import com.example.sultanagency.data.room.PublicationDAO
import com.example.sultanagency.data.room.RoomRepo
import com.example.sultanagency.logic.entities.Publication
import kotlinx.coroutines.flow.Flow

class MainFragmentPresenter(val view: IMainFragment) {
    private val remoteRepo: IRemoteRepo = FireBaseRepo()
    fun getPostList(): LiveData<List<Publication>> = remoteRepo.getAllPosts()
}