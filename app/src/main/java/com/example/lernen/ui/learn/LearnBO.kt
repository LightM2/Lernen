package com.example.lernen.ui.learn

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import com.example.lernen.R

class LearnBO(string: String){

    var buttonText = string

    fun onClick(view: View) {
        if (buttonText.compareTo("Слова відсутні") == 1){
            val bundle = Bundle()
            bundle.putString("lesson", buttonText)
            view.findNavController().navigate(R.id.action_learnFragment_to_learnNewWordsFragment, bundle)
        }

        Log.d("LearnBO", "Navigation mast work")
    }

}