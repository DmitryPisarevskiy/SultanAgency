package com.example.sultanagency.presentation.post

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.view.drawToBitmap
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.sultanagency.R
import com.example.sultanagency.logic.entities.BalconyType
import com.example.sultanagency.logic.entities.BathRoomType
import com.example.sultanagency.logic.entities.Publication
import com.example.sultanagency.logic.entities.RoomsType
import com.example.sultanagency.logic.entities.WindowsType
import com.example.sultanagency.data.room.AppDataBase
import com.example.sultanagency.data.firebase.PublicationDB
import com.example.sultanagency.presentation.IAddPostListener
import com.example.sultanagency.presentation.add.IAddFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddFragment(val addPostListener: IAddPostListener) : Fragment(), IAddFragment {
    lateinit var presenter: AddPresenter
    var post: Publication? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_post, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = AddPresenter(this, requireContext())
        val db = AppDataBase.getDB(requireContext())
        val ibPostSave = view.findViewById<ImageButton>(R.id.ib_post_save)

        view.findViewById<ImageButton>(R.id.ib_post_favourite).visibility = View.INVISIBLE

        ibPostSave.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val newPost = createPost()
                newPost?.let{
                    presenter.addRemotePost(newPost)
                    addPostListener.onPostIsAdded(newPost)
                }
            }
        }
    }

    private fun createPost(): Publication? {
        val ivPicture = requireView().findViewById<ImageView>(R.id.iv_post_picture)
        val etPostStreet = requireView().findViewById<TextView>(R.id.et_post_street)
        val etPostHouse = requireView().findViewById<EditText>(R.id.et_post_house)
        val etPostFlat = requireView().findViewById<EditText>(R.id.et_post_flat)
        val etPostCeiling = requireView().findViewById<EditText>(R.id.et_post_ceiling)
        val etPostFloor = requireView().findViewById<EditText>(R.id.et_post_floor)
        val etPostAgentName = requireView().findViewById<EditText>(R.id.et_post_name)
        val etPostAgentPhone = requireView().findViewById<EditText>(R.id.et_post_phone)
        val etPostPrice = requireView().findViewById<EditText>(R.id.et_post_price)
        val etPostSquareAll = requireView().findViewById<EditText>(R.id.et_post_square_all)
        val etPostSquareKithen = requireView().findViewById<EditText>(R.id.et_post_square_kitchen)
        val etPostRoomNum = requireView().findViewById<EditText>(R.id.et_post_room_num)
        val cbPostBalcony = requireView().findViewById<CheckBox>(R.id.cb_post_balcony)
        val cbPostLoggia= requireView().findViewById<CheckBox>(R.id.cb_post_loggia)
        val cbPostRoomsTogether= requireView().findViewById<CheckBox>(R.id.cb_post_rooms_together)
        val cbPostRoomsSeparate= requireView().findViewById<CheckBox>(R.id.cb_post_rooms_separate)
        val cbPostToiletTogether= requireView().findViewById<CheckBox>(R.id.cb_post_toilet_together)
        val cbPostToiletSeparate= requireView().findViewById<CheckBox>(R.id.cb_post_toilet_separate)
        val cbPostWindowsToYard= requireView().findViewById<CheckBox>(R.id.cb_post_windows_type_to_yard)
        val cbPostWindowsToStreet= requireView().findViewById<CheckBox>(R.id.cb_post_windows_type_to_street)
        val ibPostFavourite = requireView().findViewById<ImageButton>(R.id.ib_post_favourite)
        if ((etPostStreet.text.toString()!="") && (etPostHouse.text.toString()!="") && (etPostFlat.text.toString()!="") ) {
            return Publication(
                pictures = mutableListOf(ivPicture.drawToBitmap()),
                picturesRef = mutableListOf(),
                street = etPostStreet.text.toString(),
                houseNum = etPostHouse.text.toString(),
                flatNum = etPostFlat.text.toString(),
                price = etPostPrice.text.toString().toInt(),
                square = etPostSquareAll.text.toString().toFloat(),
                kitchenSquare = etPostSquareKithen.text.toString().toFloat(),
                roomsNumber = etPostRoomNum.text.toString().toInt(),
                floorNumber = etPostFloor.text.toString().toInt(),
                ceiling = etPostCeiling.text.toString().toFloat(),
                bathroom = if (cbPostToiletSeparate.isChecked) {
                    BathRoomType.SEPARATE
                } else {
                    BathRoomType.COMBINED
                },
                windowsType = if (cbPostWindowsToStreet.isChecked) {
                    WindowsType.TO_STREET
                } else {
                    WindowsType.TO_YARD
                },
                roomsType = if (cbPostRoomsSeparate.isChecked) {
                    RoomsType.SEPARATE
                } else {
                    RoomsType.COMBINED
                },
                balconyType = if (cbPostBalcony.isChecked) {
                    BalconyType.BALCONY
                } else {
                    if (cbPostLoggia.isChecked) {
                        BalconyType.LOGGIA
                    } else {
                        BalconyType.NO_BALCONY
                    }
                },
                agentName = etPostAgentName.text.toString(),
                agentPhone = etPostAgentPhone.text.toString()
            )
        } else {
            return null
        }
    }
}