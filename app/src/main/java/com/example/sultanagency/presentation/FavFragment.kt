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
import com.example.sultanagency.logic.entities.Publication
import com.example.sultanagency.presentation.fav.FavPresenter
import com.example.sultanagency.presentation.fav.IFavFragment

class FavFragment(val postClickListener: IPostClickListener, val liveCycleOwner: LifecycleOwner) : Fragment(), IPostClickListener, IFavFragment {
    lateinit var presenter: FavPresenter
    lateinit var rvFav: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fav, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvFav = view.findViewById(R.id.rv_fav)
        rvFav.layoutManager = GridLayoutManager(requireContext(),2)
        presenter = FavPresenter(this, requireContext())
        showPosts()
    }

    override fun onPostClickListener(post: Publication) {
        postClickListener.onPostClickListener(post)
    }

    override fun showPosts() {
        presenter.getLocalList().asLiveData().observe(liveCycleOwner) {localList ->
            val list: MutableList<Publication> = mutableListOf()
            presenter.getRemoteList().observe(liveCycleOwner) {remoteList ->
                if (isAdded) {
                    for (favouriteDbEntity in localList) {
                        for (item in remoteList) {
                            if (item.id == favouriteDbEntity.id) {
                                list.add(item)
                            }
                        }
                    }
                    rvFav.adapter = RVMainAdapter(list, postClickListener)
                }
            }
        }
    }
}