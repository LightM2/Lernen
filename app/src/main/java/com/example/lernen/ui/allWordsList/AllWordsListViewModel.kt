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
        val lastWords = mainRepository.getLastWordFromEachLesson()
        Log.d(TAG, "lastWords $lastWords")
        val allWord = mainRepository.getWords()
        Log.d(TAG, "allWord $allWord")
        val dataList: MutableList<Word> = mutableListOf()
        if (allWord != null && allWord.isNotEmpty()){
            dataList.add(Lesson(lastWords!![0].lesson))
            allWord.forEachIndexed { index, word ->
                dataList.add(word)
                if (lastWords.contains(word) && lastWords.last() != word){
                    dataList.add(Lesson(allWord[index+1].lesson))
                }
            }
        }else dataList.add(Lesson("Слова відсутні"))



        Log.d(TAG, "getList dane")
        return dataList
    }



}