package com.example.zombicide.utils

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zombicide.R
import com.example.zombicide.controllers.SkillActivity
import com.example.zombicide.models.Skill
import com.example.zombicide.views.SkillsFragment
import kotlinx.android.synthetic.main.list_item_skill.view.*
import java.util.*
import kotlin.collections.ArrayList

class SkillAdapter (private val context: Context, private var items: List<Skill>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TAG = "SkillAdapter"
    }

    private val mSkills : ArrayList<Skill> = ArrayList()

    init {
        this.mSkills.addAll(SkillsFragment.mSkillsList)
    }

    fun filter (text : String) {
        val mText: String = text.toLowerCase(Locale.getDefault())
        SkillsFragment.mSkillsList.clear()

        if (mText.isEmpty()) {
            SkillsFragment.mSkillsList.addAll(mSkills)
        } else {
            for (mSkill in mSkills) {
                Log.d(TAG, "Current Survivor : ${mSkill.skill_name}")
                if (mSkill.skill_name.toLowerCase(Locale.getDefault()).contains(mText)) {
                    SkillsFragment.mSkillsList.add(mSkill)
                }
            }
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_skill, parent, false)
        return SkillViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SkillViewHolder -> {
                holder.bind(items[position])
                holder.setListeners()
            }
        }
    }

    inner class SkillViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var mSkill : Skill

        private val mSkillName = itemView.tv_name

        fun bind(skill: Skill) {
            this.mSkill = skill
            mSkillName.text = mSkill.skill_name
        }
        fun setListeners() {
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, SkillActivity::class.java)
                intent.putExtra("currentSkill", mSkill)
                itemView.context.startActivity(intent)
            }
        }
    }

}
