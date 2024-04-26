package com.example.sultanagency.presentation.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.sultanagency.R
import com.example.sultanagency.logic.entities.Publication
import com.example.sultanagency.presentation.AddFragment
import com.example.sultanagency.presentation.FavFragment
import com.example.sultanagency.presentation.IPostClickListener
import com.example.sultanagency.presentation.post.PostFragment
import com.example.sultanagency.presentation.ProfileFragment
import com.example.sultanagency.presentation.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity(), IPostClickListener {

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        val ivFAB = findViewById<ImageButton>(R.id.fab)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.inflateMenu(R.menu.menu_toolbar)
        toolbar.setOnMenuItemClickListener { // Handle the menu item
            true
        }

        setSupportActionBar(toolbar)
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
        replaceFragment(MainFragment(this,this))
        ivFAB.setOnClickListener {
            replaceFragment(MainFragment(this, this))
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return when (id) {
            R.id.toolbar_save -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}