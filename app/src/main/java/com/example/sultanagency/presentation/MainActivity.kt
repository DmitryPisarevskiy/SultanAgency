package com.example.sultanagency.presentation

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.sultanagency.R
import com.example.sultanagency.data.DataExample
import com.example.sultanagency.logic.entities.Publication
import com.example.sultanagency.logic.entities.PublicationFireBase
import com.example.sultanagency.logic.usecases.UkEntityConverter
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.Task
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.Firebase
import com.google.firebase.database.database
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.UploadTask
import java.io.ByteArrayOutputStream
import java.util.Date

class MainActivity : AppCompatActivity(), IPostClickListener {
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        val ivFAB = findViewById<ImageButton>(R.id.fab)

        val database = Firebase.database
        val storage = FirebaseStorage.getInstance()
        val sRef = storage.reference
        val dbRef = database.getReference("Publications")
        DataExample.list.forEach { post->
            val postRef = dbRef.child(post.id)
            val picturesRef = sRef.child(post.id)
            for (i in post.pictures.indices) {
                val bitmap = post.pictures[i]
                val picRef = picturesRef.child(i.toString())
                val baos = ByteArrayOutputStream()
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
                val up: UploadTask = picRef.putBytes(baos.toByteArray())
                up.continueWithTask {task->
                    if (task.isSuccessful) {
                        val downloadUri = task.result

                    }
                    picRef.downloadUrl
                }.addOnCompleteListener {task->
                    post.picturesRef.add(task.result.toString())
                    postRef.setValue(UkEntityConverter.getPublicationFireBase(post))
                }
            }
        }

        bottomNav.selectedItemId = R.id.main
        bottomNav.menu.getItem(2).isEnabled = false
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.search -> {
                    replaceFragment(SearchFragment())
                    setMenuColor(R.color.color_search)
                }
                R.id.add -> {
                    replaceFragment(AddFragment())
                    setMenuColor(R.color.color_add)
                }
                R.id.favourite -> {
                    replaceFragment(FavFragment(this, this))
                    setMenuColor(R.color.color_favourite)
                }
                R.id.profile -> {
                    replaceFragment(ProfileFragment())
                    setMenuColor(R.color.color_profile)
                }
                else -> {}
            }
            true
        }
        replaceFragment(MainFragment(this))
        ivFAB.setOnClickListener {
            replaceFragment(MainFragment(this))
            bottomNav.selectedItemId = R.id.main
        }
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_main, fragment)
            .commit()
    }

    override fun onPostClickListener(post: Publication) {
        replaceFragment(PostFragment(post))
    }

    fun setMenuColor(color: Int) {
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNav.itemIconTintList = ContextCompat.getColorStateList(this, color)
        bottomNav.itemTextColor = ContextCompat.getColorStateList(this, color)
    }
}