package com.campeche.congresopediatria.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.campeche.congresopediatria.model.Conference
import java.util.*

class ScheduleViewModel: ViewModel() {
    var listSchedule: MutableLiveData<List<Conference>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getSchedule()
    }

    fun getSchedule(){
        var conference = Conference()
        conference.title = "Endocrinologia Pediatrica"
        conference.description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nibh tellus molestie nunc non blandit massa enim nec dui. Sit amet luctus venenatis lectus magna fringilla urna porttitor rhoncus. Sed tempus urna et pharetra pharetra massa massa ultricies."
        conference.tag = "Endocrino"
        val cal = Calendar.getInstance()
        cal.timeInMillis = 1564830000 * 1000
        conference.datetime = cal.time
        conference.speaker = "Laura Santos"
        val aux = listOf<Conference>(conference)

        listSchedule.postValue(aux)
        processFinished()
    }

    fun processFinished() {
        isLoading.value =  true
    }
}