package com.example.zombicide.controllers

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.zombicide.R
import com.example.zombicide.models.Hero
import kotlinx.android.synthetic.main.activity_hero.*
import kotlinx.android.synthetic.main.toolbar.*

class HeroActivity : AppCompatActivity() {

    companion object {
        const val TAG = "HeroActivity"

        lateinit var mCurrentHero: Hero
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero)

        mCurrentHero = intent.getParcelableExtra("currentHero")
        Log.d(TAG, "Current hero is ${mCurrentHero.name}")

        //region {General Settings}
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.title = mCurrentHero.name
        //endregion

        updateUI()
    }

    private fun updateUI() {
        val mArrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mCurrentHero.skills)
        listView.adapter = mArrayAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        android.R.id.home -> {
            finish()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}
