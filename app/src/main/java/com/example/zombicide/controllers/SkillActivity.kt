package com.example.zombicide.controllers

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.zombicide.R
import com.example.zombicide.models.Skill
import com.example.zombicide.views.SkillFragment
import com.example.zombicide.views.SurvivorsFragment
import kotlinx.android.synthetic.main.activity_skill.*
import kotlinx.android.synthetic.main.toolbar.*

class SkillActivity : AppCompatActivity() {

    companion object {
        const val TAG = "SkillActivity"
    }

    //region {Initialization}
    private lateinit var mCurrentSkill: Skill
    //endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        // Get current hero from the previous selected item, using extras from intent
        mCurrentSkill = intent.getSerializableExtra("currentSkill") as Skill

        //region {General Settings}
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.title = mCurrentSkill.skill_name

        showFragment(SkillFragment.newInstance(mCurrentSkill))
        navigation_view.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_survivors -> {
                    toolbar.title = mCurrentSkill.skill_name
                    val skillFragment = SkillFragment.newInstance(mCurrentSkill)
                    showFragment(skillFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_skills -> {
                    toolbar.title = "Survivors"
                    val survivorsFragment = SurvivorsFragment.newInstance()
                    showFragment(survivorsFragment)
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        android.R.id.home -> {
            finish()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}
