package com.example.sultanagency.presentation.main

import com.example.sultanagency.logic.entities.Publication

interface IPostClickListener {
    fun onPostClickListener(post: Publication)
}