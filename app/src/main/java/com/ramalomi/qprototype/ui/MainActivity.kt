package com.ramalomi.qprototype.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.google.android.material.snackbar.Snackbar
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
    var textForResponse: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.buttonEnvoyer?.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val comment = binding.InputTextAvis?.text ?: ""
        val dateString = SimpleDateFormat("yyy/MM/dd HH:mm:ss", Locale.getDefault()).format(Calendar.getInstance().time)

        val checkedChipId = binding.chipGroup?.checkedChipId
        if(checkedChipId!! > 0) {
            textForResponse = if(checkedChipId == R.id.chipSatisfait) "Satisfait"
                                else if(checkedChipId == R.id.chipMoyenSatisfait) "Moyennement satisfait"
                                else if (checkedChipId == R.id.chipInsatisfait) "Insatisfait"
                                else ""

            reponseViewModel.addReponse(Reponse(0, textForResponse, dateString, comment.toString()))
            Snackbar.make(v, "Merci pour votre feedback", Snackbar.LENGTH_SHORT).show()
            initialize()
        }else {
            Snackbar.make(v, "Veuillez sélectionner une réponse.", Snackbar.LENGTH_SHORT).show()
        }

    }

    private fun initialize(){
        binding.chipGroup?.clearCheck()
        binding.InputTextAvis?.text?.clear()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.statMenu) {
            startActivity(Intent(this@MainActivity, MainActivity2::class.java))
        }
        return true
    }
}