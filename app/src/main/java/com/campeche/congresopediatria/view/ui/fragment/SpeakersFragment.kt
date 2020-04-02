package com.campeche.congresopediatria.view.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager

import com.campeche.congresopediatria.R
import com.campeche.congresopediatria.model.Speaker
import com.campeche.congresopediatria.view.adapter.SpeakerAdapter
import com.campeche.congresopediatria.view.adapter.SpeakerListener
import com.campeche.congresopediatria.viewmodel.SpeakersViewModel
import kotlinx.android.synthetic.main.fragment_speakers.*

/**
 * A simple [Fragment] subclass.
 */
class SpeakersFragment : Fragment(), SpeakerListener {
    private lateinit var speakerAdapter: SpeakerAdapter
    private lateinit var viewModel: SpeakersViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_speakers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(SpeakersViewModel::class.java)
        viewModel.refresh()

        speakerAdapter = SpeakerAdapter(this)

        rvSpeakers.apply {
            layoutManager = GridLayoutManager(view.context, 2)
            adapter = speakerAdapter
        }
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.listSpeakers.observe(this, Observer<List<Speaker>> { schedule ->
            speakerAdapter.updateData(schedule)
        })

        viewModel.isLoading.observe(this, Observer<Boolean>{
            if(it!= null){
                rlBaseSpeakers.visibility = View.INVISIBLE
            }
        })
    }

    override fun onSpeakerClick(speaker: Speaker, position: Int) {
        val bundle = bundleOf("speaker" to speaker)
        findNavController().navigate(R.id.speakerDetailDialogFragment, bundle)
    }

}
