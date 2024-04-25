package com.example.sultanagency.presentation.main

import android.content.ContentUris
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
import com.example.sultanagency.presentation.IPostClickListener
import com.example.sultanagency.presentation.RVMainAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainFragment(val postClickListener: IPostClickListener, val liveCycleOwner: LifecycleOwner) : Fragment(), IMainFragment {
    private val presenter: MainFragmentPresenter = MainFragmentPresenter(this)
    lateinit var rvItem: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvItem = view.findViewById<RecyclerView>(R.id.rv_main)
        showPosts()
    }

    override fun showPosts() {
        presenter.getPostList().observe(liveCycleOwner) {
            if (isAdded) {
                rvItem.layoutManager = GridLayoutManager(requireContext(),2)
                rvItem.adapter = RVMainAdapter(it, postClickListener)
            }
        }
    }

}