package com.example.zombicide.utils

import android.content.Context
import android.util.Log
import com.example.zombicide.models.CustomSkill
import com.example.zombicide.models.Survivor
import com.example.zombicide.models.Skill
import com.google.gson.Gson

class MyJsonStream {

    companion object{
        const val TAG = "MyJsonStream"
    }

    private lateinit var mHeroesJson: String
    private lateinit var mSkillsJson: String
    private val mGson = Gson()

    fun getHeroes(context: Context) : List<Survivor> {
        Log.d(TAG, "Getting heroes list.")
        val mInputStream = context.assets.open("heroes.json")
        mHeroesJson = mInputStream.bufferedReader().use{ it.readText()}

        return (mGson.fromJson(mHeroesJson, Array<Survivor>::class.java)).toList()
    }

    fun getSkills(context: Context) : List<Skill> {
        Log.d(TAG, "Getting skills list.")
        val mInputStream = context.assets.open("skills.json")
        mSkillsJson = mInputStream.bufferedReader().use{ it.readText()}

        return (mGson.fromJson(mSkillsJson, Array<Skill>::class.java)).toList()
    }

    fun createCustomSkillsList(context: Context) {
        Log.d(TAG, "Creating custom skills list.")

        val data = this.getSkills(context)
        val mCustomSkills = ArrayList<CustomSkill>()

        for (skill in data) {
            val mCustomSkill = CustomSkill(skill.skill_id, skill.skill_name)
            mCustomSkills.add(mCustomSkill)
        }

        val file = mCustomSkills.joinToString(separator = "\n")
        Log.d(TAG, file)
    }
}
