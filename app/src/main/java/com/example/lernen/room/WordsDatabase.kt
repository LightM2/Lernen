package com.example.lernen.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [WordEntity::class], version = 1)
abstract class WordsDatabase: RoomDatabase() {
    abstract fun wordDao(): WordDao

    companion object{
        val DATABASE_NAME: String = "word_db"
    }
}