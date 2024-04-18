package com.example.sultanagency.presentation

import android.annotation.SuppressLint
import android.app.ActionBar.LayoutParams
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.sultanagency.R
import com.example.sultanagency.presentation.main_fragments.MainFragment
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNav.selectedItemId = R.id.main
        bottomNav.menu.getItem(2).isEnabled = false
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.search -> {
                    replaceFragment(MainFragment())
                    bottomNav.itemIconTintList = ContextCompat.getColorStateList(this, R.color.color_search)
                    bottomNav.itemTextColor = ContextCompat.getColorStateList(this, R.color.color_search)
                }
                R.id.add -> {
                    replaceFragment(MainFragment())
                    bottomNav.itemIconTintList = ContextCompat.getColorStateList(this, R.color.color_add)
                    bottomNav.itemTextColor = ContextCompat.getColorStateList(this, R.color.color_add)
                }
                R.id.favourite -> {
                    replaceFragment(MainFragment())
                    bottomNav.itemIconTintList = ContextCompat.getColorStateList(this, R.color.color_favourite)
                    bottomNav.itemTextColor = ContextCompat.getColorStateList(this, R.color.color_favourite)
                }
                R.id.profile -> {
                    replaceFragment(MainFragment())
                    bottomNav.itemIconTintList = ContextCompat.getColorStateList(this, R.color.color_profile)
                    bottomNav.itemTextColor = ContextCompat.getColorStateList(this, R.color.color_profile)
                }
                else -> {}
            }
            true
        }
        replaceFragment(MainFragment())
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_main, fragment)
            .commit()
    }
}