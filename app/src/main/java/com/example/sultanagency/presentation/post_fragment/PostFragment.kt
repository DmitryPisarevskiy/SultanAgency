package com.example.sultanagency.presentation.post_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.sultanagency.R
import com.example.sultanagency.logic.entities.Publication

class PostFragment(val post: Publication) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val etPostStreet = view.findViewById<TextView>(R.id.et_post_street)
        val etPostHouse = view.findViewById<EditText>(R.id.et_post_house)
        val etPostFlat = view.findViewById<EditText>(R.id.et_post_flat)

        etPostStreet.text = post.street
        etPostHouse.setText(post.houseNum)
        etPostFlat.setText(post.flatNum)
    }
}