package com.example.zombicide.controllers

import com.example.zombicide.models.Survivor
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.zombicide.R
import com.example.zombicide.models.Skill
import com.example.zombicide.utils.MyJsonStream
import kotlinx.android.synthetic.main.activity_survivor.*
import kotlinx.android.synthetic.main.toolbar.*
import java.io.IOException

class SurvivorActivity : AppCompatActivity() {

    companion object {
        const val TAG = "HeroActivity"
    }

    //region {Initialization}
    private lateinit var mCurrentSurvivor: Survivor
    private lateinit var mCurrentHeroSkills : ArrayList<Skill>
    //endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survivor)

        // Get current hero from the previous selected item, using extras from intent
        mCurrentSurvivor = intent.getParcelableExtra("currentHero") as Survivor

        //region {General Settings}
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.title = mCurrentSurvivor.name.long_fr
        //endregion

        getDataFromJson()
    }

    private fun getDataFromJson() {
        try {
            val mSkillsList = MyJsonStream().getSkills(this)
            updateUI(mSkillsList)
        } catch (e : IOException) {
            println("Throwing IOException.")
            throw e
        }
    }

    private fun updateUI(mSkillsList : List<Skill>) {
        mCurrentHeroSkills = ArrayList() // Initialization

        // For each skill that is in our current hero skill set,
        // we will try to find the matching Skill in our whole
        // skills.json file, using indexOfFirst that will return
        // the index of the first element matching our predicate
        // (or -1 if the collection doest not contain such element)

        for (skill in mCurrentSurvivor.skills) {
            val index = mSkillsList.indexOfFirst { it.skill_id == skill.skill_id}
            if (index >= 0) {
                val mCurrentSkill = mSkillsList[index]
                mCurrentHeroSkills.add(mCurrentSkill)
            } else { // Index -1
                Log.d(TAG, "Skill can't be find. Verify your data.")
            }
        }

        // TODO Custom SkillAdapter
        val mArrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mCurrentHeroSkills)
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
