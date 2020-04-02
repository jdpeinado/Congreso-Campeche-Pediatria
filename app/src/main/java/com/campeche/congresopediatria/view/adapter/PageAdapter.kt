package com.campeche.congresopediatria.view.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.campeche.congresopediatria.view.ui.fragment.ScheduleFragment

private const val ARG_OBJECT = "object"
class PageAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(i: Int): Fragment {
        val fragment = ScheduleFragment()
        fragment.arguments = Bundle()/*.apply {
            // Our object is just an integer :-P
            putInt(ARG_OBJECT, i + 1)
        }*/
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence {
        if (position==0)
            return "Lunes"
        else
            return "Martes"
    }

    override fun getCount(): Int  = 2

}