package com.example.lernen.repository

import android.util.Log
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

    suspend fun getMaxLesson(): Int?{
        var maxLesson: Int? = null
        try {
            maxLesson = wordDao.getMaxLesson()
            Log.d("getMaxLesson", "Success")
        }catch (e: Exception){
            Log.d("getMaxLesson", "Exception $e")
        }

        return maxLesson
    }

    suspend fun getAllLesson(): SortedSet<Int>?{
        var allLesson: SortedSet<Int>? = null
        try {
            allLesson = wordDao.getAllLesson().toSortedSet()
            Log.d("getAllLesson", "Success")
        }catch (e: Exception){
            Log.d("getAllLesson", "Exception $e")
        }
        return allLesson
    }

    suspend fun getSomeLessonWords(someLesson: Int): List<WordEntity>?{
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