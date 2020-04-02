package com.campeche.congresopediatria.view.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.campeche.congresopediatria.R
import com.campeche.congresopediatria.model.Conference
import com.campeche.congresopediatria.model.Speaker
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setActionBar(findViewById(R.id.toolbarMain))
        configNav()
    }

    private fun configNav() {
        NavigationUI.setupWithNavController(bnvMenu, Navigation.findNavController(this, R.id.fragContent))
    }

    fun saveData(){
        println("Saving data to firestone")
        val jsonArr = JSONArray("[\n" +
                "            {\n" +
                "                'biography' : 'Laura Santos, endrocrinologa pediatra con sede en Campeche, Mexico, .......',\n" +
                "                'category' : 5,\n" +
                "                'image' : 'https://scontent-qro1-1.xx.fbcdn.net/v/t1.0-1/p720x720/71516213_1601296776662288_3298569281721073664_n.jpg?_nc_cat=111&_nc_sid=dbb9e7&_nc_ohc=q3Y0EEJ_I9QAX8rZbpx&_nc_ht=scontent-qro1-1.xx&_nc_tp=6&oh=e26c9d12411b24a834ce3a0c96d02d4b&oe=5EA86C68',\n" +
                "                'jobtitle' : 'Endocrinologa pediatra',\n" +
                "                'name' : 'Laura Santos',\n" +
                "                'instagram' : '@yo_mismita21',\n" +
                "                'workplace' : 'Hospital Especialidades Campeche'\n" +
                "            },\n" +
                "        ]")

        val jsonArr2 = JSONArray("[\n" +
                "            {\n" +
                "                \"datetime\" : 1564830000,\n" +
                "                \"description\" : \"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nibh tellus molestie nunc non blandit massa enim nec dui. Sit amet luctus venenatis lectus magna fringilla urna porttitor rhoncus. Sed tempus urna et pharetra pharetra massa massa ultricies.\",\n" +
                "                \"speaker\" : \"Laura Santos\",\n" +
                "                \"tag\" : \"Endocrino\",\n" +
                "                \"title\" : \"Endocrinologia Pediatrica\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"datetime\" : 1564862400,\n" +
                "                \"description\" : \"En esta charla Erika Oregel del equipo de Platzi nos invita a explorar nueva forma de adquirir gustos y pasiones, nos invita a procrastinar de forma consciente. \",\n" +
                "                \"speaker\" : \"Erika Oregel\",\n" +
                "                \"tag\" : \"Procastinación\",\n" +
                "                \"title\" : \"Procrastinar puede ser el alimento de tus futuras pasiones\"\n" +
                "            },\n" +
                "        ]")

        try {

            val firebaseFirestore = FirebaseFirestore.getInstance()
            for (i in 0 until jsonArr.length()) {
                val aux = jsonArr.get(i) as JSONObject
                var speaker = Speaker()
                speaker.name = aux.getString("name")
                speaker.jobtitle = aux.getString("jobtitle")
                speaker.workplace = aux.getString("workplace")
                speaker.biography = aux.getString("biography")
                speaker.instagram = aux.getString("twitter")
                speaker.image = aux.getString("image")
                speaker.category = aux.getInt("category")

                (firebaseFirestore.collection("speakers").document().set(speaker))
            }


            for(i in 0 until jsonArr2.length()) {
                val aux = jsonArr2.get(i) as JSONObject
                var conference = Conference()
                conference.title = aux.getString("title")
                conference.description = aux.getString("description")
                conference.tag = aux.getString("tag")
                val cal = Calendar.getInstance()
                cal.timeInMillis = aux.getLong("datetime") * 1000
                conference.datetime = cal.time
                conference.speaker = aux.getString("speaker")

                (firebaseFirestore.collection("conferences").document().set(conference))
            }
        }catch (e: Exception) {
            println("Error")
            e.printStackTrace()
        }
    }
}
