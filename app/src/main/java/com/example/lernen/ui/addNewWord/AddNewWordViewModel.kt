package com.example.lernen.ui.addNewWord

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class AddNewWordViewModel
@ViewModelInject
constructor(
        @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel(){

}