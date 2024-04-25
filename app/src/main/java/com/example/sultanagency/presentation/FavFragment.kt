package com.example.sultanagency.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sultanagency.R
import com.example.sultanagency.data.firebase.DataExample
import com.example.sultanagency.logic.entities.Publication
import com.example.sultanagency.data.room.AppDataBase

class FavFragment(val postClickListener: IPostClickListener, val liveCycleOwner: LifecycleOwner) : Fragment(), IPostClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fav, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvFav = view.findViewById<RecyclerView>(R.id.rv_fav)
        rvFav.layoutManager = GridLayoutManager(requireContext(),2)
        val db = AppDataBase.getDB(requireContext())
        db.getPublicationDao().getAllPosts().asLiveData().observe(liveCycleOwner) {
            val list: MutableList<Publication> = mutableListOf()
            for (favouriteDbEntity in it) {
                for (item in DataExample.list) {
                    if (item.id == favouriteDbEntity.id) {
                        list.add(item)
                    }
                }
            }
            rvFav.adapter = RVMainAdapter(list, this)
        }
    }

    override fun onPostClickListener(post: Publication) {
        postClickListener.onPostClickListener(post)
    }
}