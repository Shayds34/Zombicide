package com.example.zombicide.views

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.zombicide.R
import com.example.zombicide.models.Skill
import kotlinx.android.synthetic.main.fragment_skill.*

// This fragment is used to display current selected skill.
class SkillFragment : Fragment() {

    companion object {
        private const val ARG_SKILL = "skillFragment"

        fun newInstance(skill : Skill) : SkillFragment {
           val args = Bundle()
            args.putSerializable(ARG_SKILL, skill)
            val fragment = SkillFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var mContext : Context
    private lateinit var mCurrentSkill : Skill

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mContext = activity!!.applicationContext
        mCurrentSkill = this.arguments!!.get(ARG_SKILL) as Skill
        return inflater.inflate(R.layout.fragment_skill, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateUI()
    }

    private fun updateUI() {
        tv_skill_id.text = mCurrentSkill.skill_id.toString()
        tv_skill_description.text = mCurrentSkill.description
    }


}
