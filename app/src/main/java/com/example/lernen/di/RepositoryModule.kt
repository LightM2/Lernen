package com.example.lernen.di

import com.example.lernen.repository.MainRepository
import com.example.lernen.room.WordDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(wordDao: WordDao): MainRepository{
        return MainRepository(wordDao)
    }
}