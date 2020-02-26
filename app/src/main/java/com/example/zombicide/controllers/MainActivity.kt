package com.example.zombicide.controllers

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zombicide.R
import com.example.zombicide.models.Hero
import com.example.zombicide.models.Skills
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private lateinit var adapter : HeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //region {General Settings}
        setSupportActionBar(toolbar)
        toolbar.setTitle(R.string.app_name)

        // Floating Action Button
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

            getDataFromJson()
        }
        //endregion
    }

    private fun configureRecyclerView(mHeroesList: List<Hero>) {
        Log.d(TAG, "configureRecyclerView")

        // Fetch our data.
        recycler_view.layoutManager = LinearLayoutManager(this)
        adapter = HeroAdapter(this, mHeroesList)
        adapter.notifyDataSetChanged()
        recycler_view.adapter = adapter
    }

    private fun getDataFromJson() {

        val mHeroesJson: String?
        val mSkillsJson: String?
        val mGson = Gson()

        try {
            val mHeroesInputStream = assets.open("heroes.json")
            mHeroesJson = mHeroesInputStream.bufferedReader().use{ it.readText()}
            val mHeroesList = (mGson.fromJson(mHeroesJson, Array<Hero>::class.java)).toList()

            val mSkillsInputStream = assets.open("skills.json")
            mSkillsJson = mSkillsInputStream.bufferedReader().use{ it.readText()}
            val mSkillsList = (mGson.fromJson(mSkillsJson, Array<Skills>::class.java)).toList()

            Log.d(TAG, "$mSkillsList")

            configureRecyclerView(mHeroesList)
        } catch (e : IOException) {
            Log.d(TAG, e.toString())
        }
    }

    companion object {
        const val TAG = "MainActivity"
    }

}
