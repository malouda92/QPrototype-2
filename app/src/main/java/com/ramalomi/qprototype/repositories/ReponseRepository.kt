package com.ramalomi.qprototype.repositories

import com.ramalomi.qprototype.daos.ReponseDao
import com.ramalomi.qprototype.models.Reponse
import javax.inject.Inject

class ReponseRepository @Inject constructor(val reponseDao: ReponseDao) {

    suspend fun persist(reponse: Reponse) {
        reponseDao.persist(reponse)
    }
}