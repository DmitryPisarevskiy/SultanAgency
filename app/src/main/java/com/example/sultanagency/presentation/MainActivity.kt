package com.example.sultanagency.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.sultanagency.R
import com.example.sultanagency.presentation.fragments.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(MainFragment())
    }

    fun replaceFragment(fragment: Fragment) {
        val fragmentManager  = supportFragmentManager
        fragmentManager
            .beginTransaction()
            .replace(R.id.fl_main, fragment)
            .commit()
    }
}