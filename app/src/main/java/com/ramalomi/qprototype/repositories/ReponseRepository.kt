package com.ramalomi.qprototype.repositories

import androidx.lifecycle.LiveData
import com.ramalomi.qprototype.daos.ReponseDao
import com.ramalomi.qprototype.models.Reponse
import javax.inject.Inject

class ReponseRepository @Inject constructor(val reponseDao: ReponseDao) {

    suspend fun persist(reponse: Reponse) {
        reponseDao.persist(reponse)
    }

    fun countReponse(): Int {
        return reponseDao.countReponse()
    }

    fun countReponseByQuery(query: String): Int {
        return reponseDao.countReponseByQuery(query)
    }
}