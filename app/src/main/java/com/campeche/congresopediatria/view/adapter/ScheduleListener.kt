package com.campeche.congresopediatria.view.adapter

import com.campeche.congresopediatria.model.Conference


interface ScheduleListener {
    fun onConferenceClick(conference: Conference, position: Int)
}