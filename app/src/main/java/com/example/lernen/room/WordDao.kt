package com.example.lernen.room

import androidx.room.*

@Dao
interface WordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(word: WordEntity): Long

    @Query("SELECT * FROM words")
    suspend fun get(): List<WordEntity>

    @Query("DELETE FROM words")
    suspend fun deleteAllWords()

    @Query("SELECT *FROM words WHERE lesson == :someLesson")
    suspend fun getSomeLessonWords(someLesson: String): List<WordEntity>

    @Update
    suspend fun updateWords(word: WordEntity)

    @Delete
    suspend fun deleteWords(word: WordEntity)

}