package com.example.lernen.ui.learn

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.lernen.repository.MainRepository

class LearnViewModel
@ViewModelInject
constructor(
        private val mainRepository: MainRepository,
        @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel(){

    private val TAG = "LearnViewModel"

    fun onClick() {

        Log.d("LearnViewModel", "Navigation mast work")
    }

    suspend fun getAllLessonsList(): List<Int>?{
        val lessonsList = mainRepository.getAllLesson()?.toList()
        Log.d(TAG, "getAllLessonsList dane")
        return lessonsList
    }

}