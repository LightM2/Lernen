package com.example.lernen.ui.allWordsList

import android.util.Log
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.lernen.R
import com.example.lernen.repository.MainRepository
import com.example.lernen.room.Lesson
import com.example.lernen.room.Word
import com.example.lernen.room.WordEntity

class AllWordsListViewModel
@ViewModelInject
constructor(
        private val mainRepository: MainRepository,
        @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel(){
    private val TAG = "AllWordsListViewModel"

    suspend fun getDataFromDb(): MutableList<Word> {
        val dataList: MutableList<Word> = mutableListOf()
        val lessonsList = mainRepository.getAllLesson()
        val allWord = mainRepository.getWords()
        if (allWord != null && allWord.isNotEmpty() && lessonsList != null){
            dataList.addAll(lessonsList)
            allWord.forEach { wordEntity ->
                val lessonPosition  = dataList.indexOf(Lesson(wordEntity.lesson))
                dataList.add(lessonPosition + 1, wordEntity)
            }
        }else dataList.add(Lesson("Слова відсутні"))




        Log.d(TAG, "getList dane")
        return dataList
    }



}