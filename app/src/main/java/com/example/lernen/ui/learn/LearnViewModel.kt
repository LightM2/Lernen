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
import com.example.lernen.room.Lesson

class LearnViewModel
@ViewModelInject
constructor(
        private val mainRepository: MainRepository,
        @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel(){

    private val TAG = "LearnViewModel"


    suspend fun getAllLessonsList(): MutableList<Lesson>?{
        val lessonList = mainRepository.getAllLesson()
        val lessons: MutableList<Lesson>
        if (lessonList != null && lessonList.isNotEmpty()){
            lessons = lessonList as MutableList<Lesson>
            lessons.add(Lesson("Всі"))
        }else lessons = mutableListOf(Lesson("Слова відсутні"))

        Log.d(TAG, "getAllLessonsList dane")
        return lessons
    }

}