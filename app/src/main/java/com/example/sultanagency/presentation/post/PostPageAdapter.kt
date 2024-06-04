package com.example.sultanagency.presentation.post

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sultanagency.R

class PostPageAdapter(private val imageList: List<String>): RecyclerView.Adapter<PostPageAdapter.PageHolder>() {
    inner class PageHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val ivPicture = itemView.findViewById<ImageView>(R.id.iv_post_picture)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageHolder {
        return PageHolder(LayoutInflater.from(parent.context).inflate(R.layout.page_image,parent,false))
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: PageHolder, position: Int) {
        Glide
            .with(holder.itemView.context)
            .load(imageList[position])
            .into(holder.ivPicture)
    }
}