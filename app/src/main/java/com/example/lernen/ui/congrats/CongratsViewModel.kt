package com.example.lernen.ui.congrats

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.hilt.Assisted
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.lernen.R

class CongratsViewModel constructor(
        @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel(){

    private val TAG = "CongratsViewModel"

    lateinit var lesson: String

    fun onClick(view: View, type: Int) {
        Log.d(TAG, "onClick mast work")
        val bundle = Bundle()
        bundle.putString("lesson", lesson)
        when (type){
            0 -> view.findNavController().navigate(R.id.action_congratsFragment_to_learnNewWordsFragment, bundle)
            1 -> view.findNavController().popBackStack()
        }

    }

}