package com.ramalomi.qprototype.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ramalomi.qprototype.R
import com.ramalomi.qprototype.databinding.ActivityMainBinding
import com.ramalomi.qprototype.models.Reponse
import com.ramalomi.qprototype.viewModels.ReponseViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class MainActivity: AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    val reponseViewModel: ReponseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.apply {
            buttonSad?.setOnClickListener(this@MainActivity)
            buttonNeutral?.setOnClickListener(this@MainActivity)
            buttonSmile?.setOnClickListener(this@MainActivity)
        }
    }

    override fun onClick(v: View?) {
        val button = v as ImageButton
        var textForResponse = ""
        when(button.id){
            R.id.buttonSad -> {
                textForResponse = "Non satisfait"
            }
            R.id.buttonNeutral -> {
                textForResponse = "Moyennement satisfait"
            }
            R.id.buttonSmile -> {
                textForResponse = "Satisfait"
            }
        }

        val dateString = SimpleDateFormat("yyy/MM/dd HH:mm:ss", Locale.getDefault()).format(Calendar.getInstance().time)
        reponseViewModel.addReponse(Reponse(0, textForResponse, dateString))
        Toast.makeText(this@MainActivity, "Merci pour votre feed back", Toast.LENGTH_LONG).show()
    }


}