package com.example.zombicide.utils

import android.content.Context
import com.example.zombicide.models.Hero
import com.example.zombicide.models.Skill
import com.example.zombicide.models.Skills
import com.google.gson.Gson

class MyJsonStream {
    companion object{
        const val TAG = "MyJsonStream"
    }

    private lateinit var mHeroesJson: String
    private lateinit var mSkillsJson: String
    private val mGson = Gson()

    fun getHeroes(context: Context) : List<Hero> {
        val mInputStream = context.assets.open("heroes.json")
        mHeroesJson = mInputStream.bufferedReader().use{ it.readText()}

        return (mGson.fromJson(mHeroesJson, Array<Hero>::class.java)).toList()
    }

    fun getSkills(context: Context) : List<Skill> {
        val mInputStream = context.assets.open("skills.json")
        mSkillsJson = mInputStream.bufferedReader().use{ it.readText()}

        return (mGson.fromJson(mSkillsJson, Array<Skill>::class.java)).toList()
    }
}