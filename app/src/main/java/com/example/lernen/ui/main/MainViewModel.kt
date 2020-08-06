package com.example.lernen.ui.main

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel


class MainViewModel
@ViewModelInject
constructor(
        @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel(){

}