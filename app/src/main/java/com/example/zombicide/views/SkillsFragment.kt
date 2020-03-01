package com.example.zombicide.views

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zombicide.R
import com.example.zombicide.controllers.MainActivity
import com.example.zombicide.models.Skill
import com.example.zombicide.utils.MyJsonStream
import com.example.zombicide.utils.SkillAdapter
import kotlinx.android.synthetic.main.fragment_skills.*
import java.io.IOException

// This fragment is used to display all skills from DataBase.
class SkillsFragment : Fragment() {

    companion object {
        fun newInstance() : SkillsFragment = SkillsFragment()
        lateinit var mSkillsList: ArrayList<Skill>
    }

    private lateinit var adapter : SkillAdapter
    private lateinit var mContext : Context

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mContext = activity!!.applicationContext
        return inflater.inflate(R.layout.fragment_skills, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Search View
        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                adapter.filter(newText)
                return false
            }
        })

        getDataFromJson()
    }

    private fun configureRecyclerView(mSkillsList: List<Skill>) {
        recycler_view.layoutManager = LinearLayoutManager(mContext)
        adapter = SkillAdapter(mContext, mSkillsList)
        adapter.notifyDataSetChanged()
        recycler_view.adapter = adapter
    }

    private fun getDataFromJson() {
        try {
            mSkillsList = MyJsonStream().getSkills(mContext) as ArrayList<Skill>
            configureRecyclerView(mSkillsList)
        } catch (e : IOException) {
            Log.d(MainActivity.TAG, e.toString())
        }
    }

}