package com.example.sultanagency.presentation.post

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.sultanagency.R
import com.example.sultanagency.data.room.PublicationDB
import com.example.sultanagency.data.room.AppDataBase
import com.example.sultanagency.logic.entities.BalconyType
import com.example.sultanagency.logic.entities.BathRoomType
import com.example.sultanagency.logic.entities.Publication
import com.example.sultanagency.logic.entities.RoomsType
import com.example.sultanagency.logic.entities.WindowsType
import com.example.sultanagency.presentation.main.IEditListener
import com.example.sultanagency.presentation.main.ISaveListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.relex.circleindicator.CircleIndicator3

class PostFragment(val post: Publication) : Fragment(), IPostFragment, ISaveListener, IEditListener {
    lateinit var presenter: PostPresenter
    lateinit var vpPicture: ViewPager2
    lateinit var ciPicture : CircleIndicator3
    lateinit var etPostStreet : TextView
    lateinit var etPostHouse : EditText
    lateinit var etPostFlat : EditText
    lateinit var etPostCeiling : EditText
    lateinit var etPostFloor : EditText
    lateinit var etPostAgentName : EditText
    lateinit var etPostAgentPhone : EditText
    lateinit var etPostPrice : EditText
    lateinit var etPostSquareAll : EditText
    lateinit var etPostSquareKithen : EditText
    lateinit var etPostRoomNum : EditText
    lateinit var cbPostBalcony :CheckBox
    lateinit var cbPostLoggia : CheckBox
    lateinit var cbPostRoomsTogether : CheckBox
    lateinit var cbPostRoomsSeparate : CheckBox
    lateinit var cbPostToiletTogether : CheckBox
    lateinit var cbPostToiletSeparate : CheckBox
    lateinit var cbPostWindowsToYard : CheckBox
    lateinit var cbPostWindowsToStreet : CheckBox
    lateinit var ibPostFavourite : ImageButton

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

        presenter = PostPresenter(this, requireContext())
        vpPicture = view.findViewById(R.id.vp_post_picture)
        ciPicture = view.findViewById(R.id.ci_post_indicator)
        etPostStreet = view.findViewById(R.id.et_post_street)
        etPostHouse = view.findViewById(R.id.et_post_house)
        etPostFlat = view.findViewById(R.id.et_post_flat)
        etPostCeiling = view.findViewById(R.id.et_post_ceiling)
        etPostFloor = view.findViewById(R.id.et_post_floor)
        etPostAgentName = view.findViewById(R.id.et_post_name)
        etPostAgentPhone = view.findViewById(R.id.et_post_phone)
        etPostPrice = view.findViewById(R.id.et_post_price)
        etPostSquareAll = view.findViewById(R.id.et_post_square_all)
        etPostSquareKithen = view.findViewById(R.id.et_post_square_kitchen)
        etPostRoomNum = view.findViewById(R.id.et_post_room_num)
        cbPostBalcony = view.findViewById(R.id.cb_post_balcony)
        cbPostLoggia= view.findViewById(R.id.cb_post_loggia)
        cbPostRoomsTogether= view.findViewById(R.id.cb_post_rooms_together)
        cbPostRoomsSeparate= view.findViewById(R.id.cb_post_rooms_separate)
        cbPostToiletTogether= view.findViewById(R.id.cb_post_toilet_together)
        cbPostToiletSeparate= view.findViewById(R.id.cb_post_toilet_separate)
        cbPostWindowsToYard= view.findViewById(R.id.cb_post_windows_type_to_yard)
        cbPostWindowsToStreet= view.findViewById(R.id.cb_post_windows_type_to_street)
        ibPostFavourite = view.findViewById(R.id.ib_post_favourite)
        val db = AppDataBase.getDB(requireContext())
        etPostPrice.background.setColorFilter(resources.getColor(R.color.gray), PorterDuff.Mode.SRC_IN)
//        if (post.picturesRef.isNotEmpty()) {
//            Glide
//                .with(requireContext())
//                .load(post.picturesRef[0])
//                .into(ivPicture)
//        }
        vpPicture.adapter = PostPageAdapter(post.picturesRef)
        vpPicture.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        ciPicture.setViewPager(vpPicture)
        etPostStreet.text = post.street
        etPostHouse.setText(post.houseNum)
        etPostFlat.setText(post.flatNum)
        etPostCeiling.setText(post.ceiling.toString())
        etPostFloor.setText(post.floorNumber.toString())
        etPostAgentName.setText(post.agentName)
        etPostAgentPhone.setText(post.agentPhone)
        etPostPrice.setText(post.price.toString())
        etPostSquareAll.setText(post.square.toString())
        etPostSquareKithen.setText(post.kitchenSquare.toString())
        etPostRoomNum.setText(post.roomsNumber.toString())
        when (post.balconyType) {
            BalconyType.BALCONY -> cbPostBalcony.isChecked = true
            BalconyType.LOGGIA -> cbPostLoggia.isChecked = true
            BalconyType.NO_BALCONY -> {}
        }
        when (post.roomsType) {
            RoomsType.COMBINED -> cbPostRoomsTogether.isChecked = true
            RoomsType.SEPARATE -> cbPostRoomsSeparate.isChecked = true
        }
        when (post.bathroom) {
            BathRoomType.COMBINED -> cbPostToiletTogether.isChecked = true
            BathRoomType.SEPARATE -> cbPostToiletSeparate.isChecked = true
        }
        when (post.windowsType) {
            WindowsType.TO_STREET -> cbPostWindowsToYard.isChecked = true
            WindowsType.TO_YARD -> cbPostWindowsToStreet.isChecked = true
        }
        ibPostFavourite.visibility = View.VISIBLE
        CoroutineScope(Dispatchers.IO).launch {
            val fav = db.getPublicationDao().findPostById(post.id)
            if (fav!=null) {
                ibPostFavourite.background = getDrawable(requireContext(), R.drawable.heart_red)
                post.isFavourite = true
            } else {
                ibPostFavourite.background = getDrawable(requireContext(), R.drawable.heart_white)
                post.isFavourite = false
            }
        }
        ibPostFavourite.setOnClickListener {
            if (post.isFavourite)  {
                CoroutineScope(Dispatchers.IO).launch {
                    db.getPublicationDao().deletePostById(post.id)
                    ibPostFavourite.background = getDrawable(requireContext(), R.drawable.heart_white)
                    post.isFavourite = false
                }
            } else {
                CoroutineScope(Dispatchers.IO).launch {
                    ibPostFavourite.background = getDrawable(requireContext(), R.drawable.heart_red)
                    val newPost = PublicationDB(
                        street = post.street,
                        houseNum = post.houseNum,
                        flatNum = post.flatNum,
                        id = post.id,
                    )
                    db.getPublicationDao().insertPost(newPost)
                    post.isFavourite = true
                }
            }
        }
    }

    override fun onSaveClick() {
        CoroutineScope(Dispatchers.IO).launch {
            val pictures = mutableListOf<Bitmap>()
            for (ref in post.picturesRef) {
                val chefBitmap: Bitmap = Glide.with(requireContext())
                    .asBitmap()
                    .load(ref)
                    .submit()
                    .get()
                pictures.add(chefBitmap)
            }

            val newPost = Publication(
                pictures = pictures,
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
            presenter.deleteRemotePost(post.id)
            presenter.addRemotePost(newPost)
            updateAllEditText(false)
        }
    }

    override fun onEditClick() {
        updateAllEditText(true)
    }

    fun updateAllEditText(isEditable: Boolean) {
        updateEditText(isEditable, etPostPrice)
    }

    fun updateEditText(isEditable: Boolean, editText: EditText) {
        if (isEditable) {
            editText.background.clearColorFilter()
            editText.isEnabled = false
        } else {
            editText.background.setTint(Color.TRANSPARENT)
            editText.isEnabled = true
        }
    }
}