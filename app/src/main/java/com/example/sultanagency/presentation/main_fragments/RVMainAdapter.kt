package com.example.sultanagency.presentation.main_fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.example.sultanagency.R
import com.example.sultanagency.logic.entities.BalconyType
import com.example.sultanagency.logic.entities.BathRoomType
import com.example.sultanagency.logic.entities.Publication
import com.example.sultanagency.logic.entities.RoomsType
import com.example.sultanagency.logic.entities.WindowsType
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
        val tvSquareAll = itemView.findViewById<TextView>(R.id.tv_main_item_square_all)
        val tvSquareKitchen = itemView.findViewById<TextView>(R.id.tv_main_item_square_kitchen)
        val cbBalcony = itemView.findViewById<CheckBox>(R.id.cb_main_item_balcony)
        val cbLoggia = itemView.findViewById<CheckBox>(R.id.cb_main_item_loggia)
        val ivFlat = itemView.findViewById<ImageView>(R.id.iv_main_item_flat)
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
            tvPrice.text = context.getString(R.string.tv_main_item_price, formatInt(flat.cost))
            tvRoomNum.text = context.getString(R.string.tv_main_item_room_num, flat.roomsNumber)
            tvToileteType.text = context.getString(R.string.tv_main_item_toilet_type,
                if (flat.bathroom == BathRoomType.COMBINED) {"совм."} else {"разд."})
            tvFloorNum.text = context.getString(R.string.tv_main_item_floor_num, flat.floorNumber)
            tvWindowsType.text = context.getString(R.string.tv_main_item_windows_type,
                if (flat.windowsType== WindowsType.TO_STREET) {"на улицу"} else {"во двор"})
            tvCeiling.text = context.getString(R.string.tv_main_item_ceiling, formatFloat(flat.ceiling))
            tvRoomType.text = context.getString(R.string.tv_main_item_rooms_type,
                if (flat.roomsType==RoomsType.COMBINED) {"смежн."} else {"разд."})
            tvSquareAll.text = context.getString(R.string.tv_main_item_square_all, formatFloat(flat.square))
            tvSquareKitchen.text = context.getString(R.string.tv_main_item_square_kitchen, formatFloat(flat.kitchenSquare))
            if (flat.balconyType == BalconyType.BALCONY) {
                cbBalcony.isChecked = true
            } else {
                cbLoggia.isChecked=true
            }
            when (position) {
                0->ivFlat.setImageDrawable(AppCompatResources.getDrawable(context, R.drawable.flat))
                1->ivFlat.setImageDrawable(AppCompatResources.getDrawable(context, R.drawable.flat2))
                2->ivFlat.setImageDrawable(AppCompatResources.getDrawable(context, R.drawable.flat3))
                3->ivFlat.setImageDrawable(AppCompatResources.getDrawable(context, R.drawable.flat4))
                4->ivFlat.setImageDrawable(AppCompatResources.getDrawable(context, R.drawable.flat5))
            }
        }
    }
}