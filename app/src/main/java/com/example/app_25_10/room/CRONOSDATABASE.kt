package com.example.app_25_10.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.app_25_10.model.Cronos

@Database(entities = [Cronos::class], version = 1, exportSchema = false)
abstract class CronosDatabase: RoomDatabase() {
    abstract fun cronosDao(): CronosDatabseDao
}