package com.campeche.congresopediatria.view.adapter

import com.campeche.congresopediatria.model.Speaker


interface SpeakerListener {
    fun onSpeakerClick(speaker: Speaker, position: Int)
}