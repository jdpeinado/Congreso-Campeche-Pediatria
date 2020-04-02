package com.campeche.congresopediatria.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.campeche.congresopediatria.model.Speaker

class SpeakersViewModel: ViewModel() {
    var listSpeakers: MutableLiveData<List<Speaker>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getSpeakers()
    }

    fun getSpeakers(){

        var speaker = Speaker()
        speaker.name = "Laura Santos"
        speaker.jobtitle = "Endocrinologa pediatra"
        speaker.workplace = "Hospital Especialidades Campeche"
        speaker.biography ="Laura Santos, endrocrinologa pediatra con sede en Campeche, Mexico, ......."
        speaker.instagram = "yo_mismita21"
        speaker.image = "https://scontent-qro1-1.xx.fbcdn.net/v/t1.0-1/p720x720/71516213_1601296776662288_3298569281721073664_n.jpg?_nc_cat=111&_nc_sid=dbb9e7&_nc_ohc=q3Y0EEJ_I9QAX8rZbpx&_nc_ht=scontent-qro1-1.xx&_nc_tp=6&oh=e26c9d12411b24a834ce3a0c96d02d4b&oe=5EA86C68"
        speaker.category = 5

        val aux = listOf<Speaker>(speaker)

        listSpeakers.postValue(aux)
        processFinished()


        /*firestoreService.getSpeakers(object: Callback<List<Speaker>> {
            override fun onSuccess(result: List<Speaker>?) {
                listSpeakers.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })*/
    }

    fun processFinished() {
        isLoading.value =  true
    }
}