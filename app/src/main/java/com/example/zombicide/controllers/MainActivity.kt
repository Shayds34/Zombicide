package com.example.zombicide.controllers

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.zombicide.R
import com.example.zombicide.models.Data
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.json.JSONArray
import java.io.IOException


class MainActivity : AppCompatActivity() {

    var mArray = ArrayList<Data>()

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

            getJson()
        }
        //endregion
    }

    private fun getJson() {
        var mJson : String? = null

        try {
            val mInputStream = assets.open("heroes.json")
            mJson = mInputStream.bufferedReader().use{ it.readText()}

            var mJsonArray = JSONArray(mJson)

            for (i in 0 until mJsonArray.length()){
                var mData = Data()
                var mJsonObject = mJsonArray.getJSONObject(i)

                mData.id = mJsonObject.getString("id")
                mData.name = mJsonObject.getString("name")
                mData.from = mJsonObject.getString("from")
                mData.story_fr = mJsonObject.getString("story_fr")
                mData.alt_armor_en = mJsonObject.getString("alt_armor_en")

                mArray.add(mData)
            }

            var mArrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mArray)
            listView.adapter = mArrayAdapter

        } catch (e : IOException) {
            Log.d(TAG, e.toString())
        }
    }

    companion object {
        const val TAG = "MainActivity"
    }

}
