package com.example.zombicide.controllers

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zombicide.R
import com.example.zombicide.models.Survivor
import com.example.zombicide.utils.SurvivorAdapter
import com.example.zombicide.utils.MyJsonStream
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.toolbar.*
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private lateinit var adapter : SurvivorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //region {General Settings}
        setSupportActionBar(toolbar)
        toolbar.setTitle(R.string.app_name)

        // Floating Action Button
        fab.setOnClickListener {
            getDataFromJson()
        }
        //endregion
    }

    private fun configureRecyclerView(mHeroesList: List<Survivor>) {
        Log.d(TAG, "configureRecyclerView")

        // Fetch our data.
        recycler_view.layoutManager = LinearLayoutManager(this)
        adapter = SurvivorAdapter(this, mHeroesList)
        adapter.notifyDataSetChanged()
        recycler_view.adapter = adapter
    }

    private fun getDataFromJson() {
        try {
            val mSurvivorList = MyJsonStream().getSurvivors(this)
            configureRecyclerView(mSurvivorList)
        } catch (e : IOException) {
            Log.d(TAG, e.toString())
        }
    }

    companion object {
        const val TAG = "MainActivity"
    }
}
