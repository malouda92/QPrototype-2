package com.ramalomi.qprototype.di

import android.content.Context
import androidx.room.Room
import com.ramalomi.qprototype.database.AppDatabase
import com.ramalomi.qprototype.database.MIGRATION_1_2
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDataBase(
        @ApplicationContext context: Context) = Room.databaseBuilder(context, AppDatabase::class.java, "Qprototype_db")
            .addMigrations(MIGRATION_1_2).build()

    @Singleton
    @Provides
    fun provideDao(db: AppDatabase) = db.reponseDao()
}