package com.campeche.congresopediatria.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.campeche.congresopediatria.R
import com.campeche.congresopediatria.model.Conference

import kotlinx.android.synthetic.main.item_schedule.view.*
import java.text.SimpleDateFormat
import kotlin.collections.ArrayList

class ScheduleAdapter(val scheduleListener: ScheduleListener): RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {
    var listConference = ArrayList<Conference>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_schedule, parent, false))

    override fun getItemCount(): Int = listConference.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val conference = listConference[position] as Conference

        holder.tvConferenceName.text = conference.title
        holder.tvItemScheduleConferenceSpeaker.text = conference.speaker
        holder.txItemScheduleTag.text = conference.tag

        val simpleDateFormat = SimpleDateFormat("HH:mm")
        val simpleDateFormatAMPM = SimpleDateFormat("a")

        holder.txItemScheduleHour.text = simpleDateFormat.format(conference.datetime)
        holder.txItemScheduleAMPM.text = simpleDateFormatAMPM.format(conference.datetime).toUpperCase()

        holder.itemView.setOnClickListener {
            scheduleListener.onConferenceClick(conference, position)
        }
    }

    fun updateData(data: List<Conference>) {
        listConference.clear()
        listConference.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvConferenceName = itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceName)
        val tvItemScheduleConferenceSpeaker = itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceSpeaker)
        val txItemScheduleTag = itemView.findViewById<TextView>(R.id.txItemScheduleTag)
        val txItemScheduleHour = itemView.findViewById<TextView>(R.id.txItemScheduleHour)
        val txItemScheduleAMPM = itemView.findViewById<TextView>(R.id.txItemScheduleAMPM)
    }
}