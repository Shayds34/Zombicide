package com.example.zombicide.utils

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zombicide.R
import com.example.zombicide.controllers.HeroActivity
import com.example.zombicide.models.Hero
import kotlinx.android.synthetic.main.list_item_hero.view.*

class HeroAdapter(private val context: Context, private var items: List<Hero>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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
        private lateinit var mHero : Hero

        private val mHeroName = itemView.tv_name
        private val mHeroStory = itemView.tv_story
        private val mHeroFrom = itemView.tv_from

        fun bind(hero: Hero) {
            this.mHero = hero

            mHeroName.text = mHero.name
            mHeroStory.text = mHero.story
            mHeroFrom.text = mHero.from
        }
        fun setListeners() {
            itemView.setOnClickListener {
                val intent = Intent(context, HeroActivity::class.java)
                intent.putExtra("currentHero", mHero)
                context.startActivity(intent)
            }
        }
    }
}
