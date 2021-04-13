package com.ramalomi.qprototype.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ramalomi.qprototype.models.Reponse
import com.ramalomi.qprototype.repositories.ReponseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReponseViewModel @Inject constructor(val reponseRepository: ReponseRepository): ViewModel() {

    fun addReponse(reponse: Reponse) = viewModelScope.launch {
        reponseRepository.persist(reponse)
    }
}