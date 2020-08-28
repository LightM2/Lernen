package com.example.lernen.room

import androidx.room.*
import java.util.*

@Dao
interface WordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(word: WordEntity): Long

    @Query("SELECT * FROM words")
    suspend fun get(): List<WordEntity>

    @Query("DELETE FROM words")
    suspend fun deleteAllWords()

    @Query("SELECT *FROM words WHERE lesson = :someLesson")
    suspend fun getSomeLessonWords(someLesson: Int): List<WordEntity>

    @Query("SELECT MAX(lesson) FROM words")
    suspend fun getMaxLesson(): Int

    @Query("SELECT lesson FROM words")
    suspend fun getAllLesson(): List<Int>

    @Update
    suspend fun updateWords(word: WordEntity)

    @Delete
    suspend fun deleteWords(word: WordEntity)

}