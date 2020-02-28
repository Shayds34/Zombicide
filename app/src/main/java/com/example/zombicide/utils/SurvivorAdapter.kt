package com.example.zombicide.utils

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zombicide.R
import com.example.zombicide.controllers.SurvivorActivity
import com.example.zombicide.models.Survivor
import kotlinx.android.synthetic.main.list_item_hero.view.*

class SurvivorAdapter(private val context: Context, private var items: List<Survivor>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        // const val TAG = "HeroAdapter"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_hero, parent, false)
        return HeroViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeroViewHolder -> {
                holder.bind(items[position])
                holder.setListeners()
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class HeroViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var mSurvivor : Survivor

        private val mHeroName = itemView.tv_name
        private val mHeroStory = itemView.tv_story
        private val mHeroFrom = itemView.tv_from

        fun bind(survivor: Survivor) {
            this.mSurvivor = survivor

            mHeroName.text = mSurvivor.name.short_fr
            mHeroStory.text = mSurvivor.story.fr
            mHeroFrom.text = mSurvivor.from
        }
        fun setListeners() {
            itemView.setOnClickListener {
                val intent = Intent(context, SurvivorActivity::class.java)
                intent.putExtra("currentHero", mSurvivor)
                context.startActivity(intent)
            }
        }
    }
}
