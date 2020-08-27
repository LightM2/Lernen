package com.example.lernen.ui.allWordsList

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lernen.repository.MainRepository
import com.example.lernen.room.WordEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class AllWordsListViewModel
@ViewModelInject
constructor(
        private val mainRepository: MainRepository,
        @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel(){
    private val TAG = "AllWordsListViewModel"
    private var dataList : List<WordEntity>? = null

    fun onClick() {

        Log.d("AllWordsListViewModel", "Navigation mast work")
    }

    suspend fun getDataFromDb(): List<WordEntity>? {
        dataList = mainRepository.getWords()
        Log.d(TAG, "getList dane")
        return dataList
    }



}