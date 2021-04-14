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

    @Query("SELECT * FROM reponse WHERE id = :id")
    fun findReponseById(id: Int): LiveData<Reponse>

    @Query("SELECT COUNT(id) FROM reponse ")
    fun countReponse(): Int

    @Query("SELECT COUNT(id) FROM reponse WHERE value_reponse = :query")
    fun countReponseByQuery(query: String): Int
}