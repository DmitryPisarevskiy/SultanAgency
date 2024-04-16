package com.example.sultanagency.presentation.main_fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sultanagency.R
import com.example.sultanagency.logic.entities.Publication
import com.example.sultanagency.presentation.*

class RVMainAdapter(val list: List<Publication>): RecyclerView.Adapter<RVMainAdapter.MainItemHolder>() {
    class MainItemHolder(val itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvAdress = itemView.findViewById<TextView>(R.id.tv_main_item_adress)
        val tvPrice = itemView.findViewById<TextView>(R.id.tv_main_item_price)
        val tvRoomNum = itemView.findViewById<TextView>(R.id.tv_main_item_room_num)
        val tvToileteType = itemView.findViewById<TextView>(R.id.tv_main_item_toilet_type)
        val tvFloorNum = itemView.findViewById<TextView>(R.id.tv_main_item_floor_num)
        val tvWindowsType = itemView.findViewById<TextView>(R.id.tv_main_item_windows_type)
        val tvCeiling = itemView.findViewById<TextView>(R.id.tv_main_item_ceiling)
        val tvRoomType = itemView.findViewById<TextView>(R.id.tv_main_item_rooms_type)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainItemHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.rv_main_item,parent,false)
        return MainItemHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MainItemHolder, position: Int) {
        val flat = list[position]
        val context = holder.tvAdress.context
        with (holder) {
            tvAdress.text = context.getString(R.string.tv_main_item_adress, flat.street, flat.houseNum, flat.flatNum)
            tvPrice.text = context.getString(R.string.tv_main_item_price, formatter(flat.cost))
            tvRoomNum.text = context.getString(R.string.tv_main_item_room_num, flat.roomsNumber)
            tvToileteType.text = context.getString(R.string.tv_main_item_toilet_type)
//            tvFloorNum.text = context.getString(R.string.tv_main_item_floor_num)
//            tvWindowsType.text = context.getString(R.string.tv_main_item_windows_type)
//            tvCeiling.text = context.getString(R.string.tv_main_item_ceiling)
//            tvRoomType.text = context.getString(R.string.tv_main_item_rooms_type)
        }
    }
}