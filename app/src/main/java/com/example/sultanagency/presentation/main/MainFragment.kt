package com.example.sultanagency.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sultanagency.R

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