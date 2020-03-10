package com.example.zombicide.controllers

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.zombicide.R
import com.example.zombicide.views.SkillsFragment
import com.example.zombicide.views.SurvivorsFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //region {General Settings}
        setSupportActionBar(toolbar)

        showFragment(SurvivorsFragment.newInstance())
        navigation_view.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_survivors -> {
                    toolbar.title = "Survivors"
                    val survivorsFragment = SurvivorsFragment.newInstance()
                    showFragment(survivorsFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_skills -> {
                    toolbar.title = "Skills"
                    val skillsFragment = SkillsFragment.newInstance()
                    showFragment(skillsFragment)
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
        //endregion
    }

    private fun showFragment(fragment: Fragment) {
        val mTransaction = supportFragmentManager.beginTransaction()
        mTransaction.replace(R.id.container, fragment)
        mTransaction.addToBackStack(null)
        mTransaction.commit()
    }

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_settings -> {
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}
