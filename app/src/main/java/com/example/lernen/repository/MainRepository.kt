package com.example.lernen.repository

import android.util.Log
import com.example.lernen.room.Lesson
import com.example.lernen.room.WordDao
import com.example.lernen.room.WordEntity
import java.util.*

class MainRepository
constructor(
    private val wordDao: WordDao
) {
    suspend fun getWords(): List<WordEntity>? {
        var word: List<WordEntity>? = null

        try{
            word = wordDao.get()
            Log.d("getWords", "Success  $word")

        }catch (e: Exception){
            Log.d("getWords", "Exception $e")
        }

        return word
    }

    suspend fun setWord(word: WordEntity){

        try {
            wordDao.insert(word)
            Log.d("setWord", "Success")
        }catch (e: Exception){
            Log.d("setWord", "Exception $e")
        }

    }

    suspend fun getAllLesson(): List<Lesson>?{
        var allLesson: List<Lesson>? = null
        try {
            val list = wordDao.getAllLesson().toSet()
            allLesson = list.map { Lesson(it) }

            Log.d("getAllLesson", "Success")
        }catch (e: Exception){
            Log.d("getAllLesson", "Exception $e")
        }
        return allLesson
    }

    suspend fun getSomeLessonWords(someLesson: String): List<WordEntity>?{
        var listWords: List<WordEntity>? = null
        try {
            listWords = wordDao.getSomeLessonWords(someLesson)
            Log.d("getSomeLessonWords", "Success")
        }catch (e: Exception){
            Log.d("getSomeLessonWords", "Exception $e")
        }
        return listWords
    }
}