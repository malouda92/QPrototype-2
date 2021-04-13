package com.ramalomi.qprototype.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ramalomi.qprototype.models.Reponse

@Dao
interface ReponseDao {

    @Query("SELECT * FROM reponse")
    fun findAll(): LiveData<List<Reponse>>

    @Insert
    suspend fun persist(reponse: Reponse)
}