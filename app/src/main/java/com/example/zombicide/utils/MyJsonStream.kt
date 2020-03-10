package com.example.zombicide.utils

import android.content.Context
import android.util.Log
import com.example.zombicide.models.Skill
import com.example.zombicide.models.Survivor
import com.google.gson.Gson

class MyJsonStream {

    companion object{
        const val TAG = "MyJsonStream"
    }

    private lateinit var mSurvivorJson: String
    private lateinit var mSkillsJson: String
    private val mGson = Gson()

    fun getSurvivors(context: Context) : List<Survivor> {
        Log.d(TAG, "Getting survivors list.")

        val mInputStream = context.assets.open("survivors.json")
        mSurvivorJson = mInputStream.bufferedReader().use{ it.readText()}

        return (mGson.fromJson(mSurvivorJson, Array<Survivor>::class.java)).toList()
    }

    fun getSkills(context: Context) : List<Skill> {
        Log.d(TAG, "Getting skills list.")
        val mInputStream = context.assets.open("skills.json")
        mSkillsJson = mInputStream.bufferedReader().use{ it.readText()}

        return (mGson.fromJson(mSkillsJson, Array<Skill>::class.java)).toList()
    }
}
