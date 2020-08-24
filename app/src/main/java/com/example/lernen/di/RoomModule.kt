package com.example.lernen.di

import android.content.Context
import androidx.room.Room
import com.example.lernen.room.WordDao
import com.example.lernen.room.WordsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideWordsDb(@ApplicationContext context: Context): WordsDatabase {
        return Room.databaseBuilder(
            context,
            WordsDatabase::class.java,
            WordsDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }


    @Singleton
    @Provides
    fun provideWordsDAO(wordsDatabase: WordsDatabase): WordDao {
        return wordsDatabase.wordDao()
    }
}