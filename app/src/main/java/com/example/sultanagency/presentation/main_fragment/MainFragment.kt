package com.example.sultanagency.presentation.main_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sultanagency.R
import com.example.sultanagency.logic.entities.DataExample
import com.example.sultanagency.presentation.IPostClickListener

class MainFragment(val postClickListener: IPostClickListener) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvItem = view.findViewById<RecyclerView>(R.id.rv_main)
        rvItem.layoutManager = GridLayoutManager(requireContext(),2)
        rvItem.adapter = RVMainAdapter(DataExample.list, postClickListener)
    }
}