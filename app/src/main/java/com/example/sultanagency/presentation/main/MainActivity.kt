package com.example.sultanagency.presentation.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment
import com.example.sultanagency.R
import com.example.sultanagency.logic.entities.Publication
import com.example.sultanagency.presentation.fav.FavFragment
import com.example.sultanagency.presentation.ProfileFragment
import com.example.sultanagency.presentation.SearchFragment
import com.example.sultanagency.presentation.post.AddFragment
import com.example.sultanagency.presentation.post.PostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity(), IPostClickListener, IAddPostListener {
    private lateinit var toolbar: Toolbar
    private var toolsIsShown: Boolean = false

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        val ivFAB = findViewById<ImageButton>(R.id.fab)
        toolbar = findViewById(R.id.toolbar)
        var drawable = toolbar.overflowIcon
        drawable?.let {
            drawable = DrawableCompat.wrap(it)
            DrawableCompat.setTint(it.mutate(), resources.getColor(R.color.white))
            toolbar.overflowIcon = it
        }
        setSupportActionBar(toolbar)
        bottomNav.selectedItemId = R.id.main
        bottomNav.menu.getItem(2).isEnabled = false
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.search -> {
                    replaceFragment(SearchFragment())
                    setMenuColor(R.color.color_search)
                    hideSaveEdit()
                }
                R.id.add -> {
                    replaceFragment(AddFragment(this))
                    setMenuColor(R.color.color_add)
                    toolbar.menu.findItem(R.id.toolbar_save).isVisible = true
                }
                R.id.favourite -> {
                    replaceFragment(FavFragment(this, this))
                    setMenuColor(R.color.color_favourite)
                    hideSaveEdit()
                }
                R.id.profile -> {
                    replaceFragment(ProfileFragment())
                    setMenuColor(R.color.color_profile)
                    showSaveEdit()
                }
                else -> {}
            }
            true
        }
        replaceFragment(MainFragment(this,this))
        ivFAB.setOnClickListener {
            replaceFragment(MainFragment(this, this))
            bottomNav.selectedItemId = R.id.main
            hideSaveEdit()
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
        showSaveEdit()
    }

    fun setMenuColor(color: Int) {
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNav.itemIconTintList = ContextCompat.getColorStateList(this, color)
        bottomNav.itemTextColor = ContextCompat.getColorStateList(this, color)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.toolbar_save -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onPostIsAdded(post: Publication) {
        replaceFragment(PostFragment(post))
    }

    fun showSaveEdit() {
        toolbar.menu.findItem(R.id.toolbar_save).isVisible = true
        toolbar.menu.findItem(R.id.toolbar_edit).isVisible = true

    }

    fun hideSaveEdit() {
        toolbar.menu.findItem(R.id.toolbar_save).isVisible = false
        toolbar.menu.findItem(R.id.toolbar_edit).isVisible = false
    }

}