package com.campeche.congresopediatria.view.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager

import com.campeche.congresopediatria.R
import com.campeche.congresopediatria.view.adapter.PageAdapter
import com.google.android.material.tabs.TabLayout

/**
 * A simple [Fragment] subclass.
 */
class ScheduleFragment2 : Fragment() {

    private lateinit var pagerAdapter: PageAdapter
    private lateinit var viewPager: ViewPager


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pagerAdapter = PageAdapter(childFragmentManager)
        viewPager = view.findViewById(R.id.pager)
        viewPager.adapter = pagerAdapter

        val tabLayout = view.findViewById(R.id.tabLayout) as TabLayout
        tabLayout.setupWithViewPager(viewPager)

    }
}
