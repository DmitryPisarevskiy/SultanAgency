package com.example.sultanagency.presentation

import com.example.sultanagency.logic.entities.Publication

interface IAddPostListener {
    fun onPostIsAdded(post: Publication)
}