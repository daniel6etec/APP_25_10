package com.example.app_25_10.di

import android.content.Context
import androidx.room.Room
import com.example.app_25_10.room.CronosDatabase
import com.example.app_25_10.room.CronosDatabseDao
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
    fun providesCronosDao(cronoDatabase: CronosDatabase) : CronosDatabseDao {
        return cronoDatabase.cronosDao()
    }

    @Singleton
    @Provides
    fun providesCronosDatabase(@ApplicationContext context: Context): CronosDatabase {
        return Room.databaseBuilder(
            context,
            CronosDatabase::class.java, "cronos_db"
        ).fallbackToDestructiveMigration()
            .build()
    }

}