package com.example.zombicide.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.text.TextUtils.concat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.zombicide.R
import com.example.zombicide.controllers.SurvivorActivity
import com.example.zombicide.models.Survivor
import com.example.zombicide.views.SurvivorsFragment
import kotlinx.android.synthetic.main.list_item_survivor.view.*
import java.io.File
import java.util.*

class SurvivorAdapter(private val context: Context, private var items: List<Survivor>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TAG = "SurvivorAdapter"
    }

    private val mSurvivors : ArrayList<Survivor> = ArrayList()

    init {
        this.mSurvivors.addAll(SurvivorsFragment.mHeroesList)
    }


    fun filter (text : String) {
        val mText: String = text.toLowerCase(Locale.getDefault())
        SurvivorsFragment.mHeroesList.clear()

        if (mText.isEmpty()) {
            SurvivorsFragment.mHeroesList.addAll(mSurvivors)
        } else {
            for (mSurvivor in mSurvivors) {
                Log.d(TAG, "Current Survivor : ${mSurvivor.name}")
                if (mSurvivor.name.toString().toLowerCase(Locale.getDefault()).contains(mText)) {
                    SurvivorsFragment.mHeroesList.add(mSurvivor)
                }
            }
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_survivor, parent, false)
        return SurvivorViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SurvivorViewHolder -> {
                holder.bind(items[position])
                holder.setListeners()
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class SurvivorViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var mSurvivor : Survivor

        private val mHeroName = itemView.tv_name
        private val mHeroQuote = itemView.tv_quote
        private val mHeroFrom = itemView.tv_from
        private val mHeroPicture = itemView.survivor_image

        fun bind(survivor: Survivor) {
            this.mSurvivor = survivor
            val pathUri = "file:///android_asset/img/${survivor.name.short_fr.toLowerCase(Locale.getDefault())}.jpg"

            Glide
                .with(context)
                .asBitmap()
                .load(Uri.parse(pathUri))
                .fitCenter()
                .into(mHeroPicture)

            mHeroName.text = mSurvivor.name.short_fr
            mHeroQuote.text = concat("\"${mSurvivor.quote.fr}\"")
            mHeroFrom.text = mSurvivor.from

        }
        fun setListeners() {
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, SurvivorActivity::class.java)
                intent.putExtra("currentSurvivor", mSurvivor)
                itemView.context.startActivity(intent)
            }
        }
    }
}
