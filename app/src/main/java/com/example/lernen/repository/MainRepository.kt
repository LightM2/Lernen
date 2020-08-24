package com.example.lernen.repository

import android.util.Log
import com.example.lernen.room.WordDao
import com.example.lernen.room.WordEntity

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
}