package com.ramalomi.qprototype

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.ramalomi.qprototype.daos.ReponseDao
import com.ramalomi.qprototype.database.AppDatabase
import com.ramalomi.qprototype.models.Reponse
import junit.framework.TestCase
import kotlinx.coroutines.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Exception
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import kotlin.jvm.Throws

@RunWith(AndroidJUnit4::class)
class RoomDatabaseTest: TestCase() {

    private lateinit var reponseDao: ReponseDao
    private lateinit var db: AppDatabase


    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).allowMainThreadQueries().build()
        reponseDao = db.reponseDao()
    }

    @After
    @Throws(Exception::class)
    fun closeDb() {
        db.close()
    }

    @Before
    fun writePassTest() = runBlocking {
        val reponse = Reponse(0, "Satisfait", "2021/04/14 11:14:00", "masiso")
        reponseDao.persist(reponse)
    }

    @Test
    @Throws(Exception::class)
    fun readPassTest() {
        val result = reponseDao.findReponseById(1)
        assertThat(result.blockingObserve()).isEqualTo("2021/04/14 11:14:00")
    }
}