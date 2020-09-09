package com.example.lernen.room

import androidx.room.*
import java.util.*

@Dao
interface WordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(word: WordEntity): Long

    @Query("SELECT * FROM words")
    suspend fun get(): List<WordEntity>

    @Query("SELECT * FROM words GROUP BY lesson")
    suspend fun getLastWordFromEachLesson(): List<WordEntity>

    @Query("DELETE FROM words")
    suspend fun deleteAllWords()

    @Query("SELECT *FROM words WHERE lesson = :someLesson")
    suspend fun getSomeLessonWords(someLesson: String): List<WordEntity>

    @Query("SELECT MAX(lesson) FROM words")
    suspend fun getMaxLesson(): String

    @Query("SELECT lesson FROM words")
    suspend fun getAllLesson(): List<String>

    @Update
    suspend fun updateWords(word: WordEntity)

    @Delete
    suspend fun deleteWords(word: WordEntity)

}