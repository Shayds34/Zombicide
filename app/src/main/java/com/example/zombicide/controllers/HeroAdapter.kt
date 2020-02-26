package com.example.zombicide.controllers

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.zombicide.R
import com.example.zombicide.models.Hero
import kotlinx.android.synthetic.main.list_item_hero.view.*

class HeroAdapter(private val context: Context, private var items: List<Hero>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TAG = "HeroAdapter"
    }

    //region {Initialization}

    //endregion

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_hero, parent, false)
        return HeroViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d(TAG, "OnBindViewHolder")
        when(holder) {
            is HeroViewHolder -> {
                holder.bind(items[position])
                holder.setListeners()
            }
        }
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount")
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
        fun setListeners(){
            itemView.setOnClickListener {
                Toast.makeText(context, "${mHero.name} has been clicked.", Toast.LENGTH_LONG).show()
                Log.d(TAG, "${mHero.name}'s skills are : ${mHero.skills}")
            }
        }
    }

    fun updateList(items: List<Hero>){
        this.items = items
        notifyDataSetChanged()
    }
}
