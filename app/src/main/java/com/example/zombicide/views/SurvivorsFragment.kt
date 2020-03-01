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
import com.example.zombicide.models.Survivor
import com.example.zombicide.utils.MyJsonStream
import com.example.zombicide.utils.SurvivorAdapter
import kotlinx.android.synthetic.main.fragment_survivors.*
import java.io.IOException

// This Fragment is used to display all survivors from DataBase.
class SurvivorsFragment : Fragment() {

    companion object {
        fun newInstance() : SurvivorsFragment = SurvivorsFragment()
        lateinit var mHeroesList: ArrayList<Survivor>
    }

    private lateinit var adapter : SurvivorAdapter
    private lateinit var mContext : Context

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mContext = activity!!.applicationContext
        return inflater.inflate(R.layout.fragment_survivors, container, false)
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

    private fun configureRecyclerView(mHeroesList: List<Survivor>) {
        Log.d(MainActivity.TAG, "configureRecyclerView")

        // Fetch our data.
        recycler_view.layoutManager = LinearLayoutManager(mContext)
        adapter = SurvivorAdapter(mContext, mHeroesList)
        adapter.notifyDataSetChanged()
        recycler_view.adapter = adapter
    }

    private fun getDataFromJson() {
        try {
            mHeroesList = MyJsonStream().getSurvivors(mContext) as ArrayList<Survivor>
            configureRecyclerView(mHeroesList)
        } catch (e : IOException) {
            Log.d(MainActivity.TAG, e.toString())
        }
    }


}


