package com.example.lernen.ui.learn

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class LearnViewModel
@ViewModelInject
constructor(
        @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel(){

    fun onClick() {

        Log.d("LearnViewModel", "Navigation mast work")
    }

}