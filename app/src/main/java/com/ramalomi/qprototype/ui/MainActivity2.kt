package com.ramalomi.qprototype.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import com.ramalomi.qprototype.R
import com.ramalomi.qprototype.databinding.ActivityMain2Binding
import com.ramalomi.qprototype.viewModels.ReponseViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.lang.String.format

@AndroidEntryPoint
class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    val reponseViewModel: ReponseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val count = reponseViewModel.countReponse()

        val countBySatisfait = reponseViewModel.countReponseByQuery("Satisfait")
        binding.textViewTitle1?.text = resources.getString(R.string.rep_poss_1)
        binding.textViewCount1?.text = countBySatisfait.toString()
        binding.textViewTaux1?.text = format("%.5f", countBySatisfait.toDouble()/count)

        val countByNeutre = reponseViewModel.countReponseByQuery("Moyennement satisfait")
        binding.textViewTitle2?.text = resources.getString(R.string.rep_poss_2)
        binding.textViewCount2?.text = countByNeutre.toString()
        binding.textViewTaux2?.text = format("%.5f", countByNeutre.toDouble()/count)

        val countByInsatisfait = reponseViewModel.countReponseByQuery("Insatisfait")
        binding.textViewTitle3?.text = resources.getString(R.string.rep_poss_3)
        binding.textViewCount3?.text = countByInsatisfait.toString()
        binding.textViewTaux3?.text = format("%.5f", countByInsatisfait.toDouble()/count)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return true
    }
}