package com.example.lernen.ui.allWordsList

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class AllWordsListViewModel
@ViewModelInject
constructor(
        @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel(){

    fun onClick() {

        Log.d("AllWordsListViewModel", "Navigation mast work")
    }

}