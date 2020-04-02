package com.campeche.congresopediatria.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.campeche.congresopediatria.R
import com.campeche.congresopediatria.model.Speaker


class SpeakerAdapter(val speakerListener: SpeakerListener): RecyclerView.Adapter<SpeakerAdapter.ViewHolder>() {
    var listspeakers = ArrayList<Speaker>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_speaker, parent, false))

    override fun getItemCount(): Int = listspeakers.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val speaker:Speaker = listspeakers[position]

        holder.tvItemSpeakerName.text = speaker.name
        holder.tvItemSpeakerJob.text = speaker.jobtitle

        Glide.with(holder.itemView.context)
            .load(speaker.image)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.ivItemSpeakerImage)

        holder.itemView.setOnClickListener {
            speakerListener.onSpeakerClick(speaker, position)
        }
    }

    fun updateData(data: List<Speaker>) {
        listspeakers.clear()
        listspeakers.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvItemSpeakerName = itemView.findViewById<TextView>(R.id.tvItemSpeakerName)
        val tvItemSpeakerJob = itemView.findViewById<TextView>(R.id.tvItemSpeakerJob)
        val ivItemSpeakerImage = itemView.findViewById<ImageView>(R.id.ivItemSpeakerImage)
    }
}