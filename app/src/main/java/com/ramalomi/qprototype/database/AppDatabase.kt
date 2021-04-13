package com.ramalomi.qprototype.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ramalomi.qprototype.daos.ReponseDao
import com.ramalomi.qprototype.models.Reponse

@Database(entities = arrayOf(Reponse::class), version = 2, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun reponseDao(): ReponseDao
}