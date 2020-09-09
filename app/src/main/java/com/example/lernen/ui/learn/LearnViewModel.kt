package com.example.lernen.ui.learn

import android.util.Log
import android.view.View
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.lernen.R
import com.example.lernen.repository.MainRepository

class LearnViewModel
@ViewModelInject
constructor(
        private val mainRepository: MainRepository,
        @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel(){

    private val TAG = "LearnViewModel"

    fun onClick(view: View) {

        view.findNavController().navigate(R.id.action_learnFragment_to_learnNewWordsFragment)

        Log.d("LearnViewModel", "Navigation mast work")
    }

    suspend fun getAllLessonsList(): MutableList<String>?{
        val lessonList = mainRepository.getAllLesson()?.toList()
        val lessons: MutableList<String>
        if (lessonList != null && lessonList.isNotEmpty()){
            lessons = lessonList as MutableList<String>
            lessons.add("Всі")
        }else lessons = mutableListOf("Слова відсутні")

        Log.d(TAG, "getAllLessonsList dane")
        return lessons
    }

}