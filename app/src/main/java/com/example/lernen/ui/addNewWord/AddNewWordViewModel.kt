package com.example.lernen.ui.addNewWord

import android.util.Log
import androidx.databinding.Bindable
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lernen.repository.MainRepository
import com.example.lernen.room.WordEntity
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main

class AddNewWordViewModel
@ViewModelInject
constructor(
        private val mainRepository: MainRepository,
        @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel(){

    var newLesson = MutableLiveData<String>()
    var newWord = MutableLiveData<String>()
    var newTranslation = MutableLiveData<String>()

    fun addNewWord(){
        println("addNewWord")
        Log.d("AddNewWordViewModel", "addNewWord")
        Log.d("AddNewWordViewModel", "Lesson - ${newLesson.value}")
        Log.d("AddNewWordViewModel", "Word - ${newWord.value}")
        Log.d("AddNewWordViewModel", "Translation - ${newTranslation.value}")
        viewModelScope.launch {
            mainRepository.setWord(WordEntity(0, newLesson.value!!, newWord.value!!, newTranslation.value!!))
            Log.d("AddNewWordViewModel", "new word added")

        }

    }





}