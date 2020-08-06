package com.example.lernen.ui.addNewWord

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.lernen.R
import com.example.lernen.ui.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNewWordFragment constructor() : Fragment(R.layout.add_new_word_fragment) {

    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("AddNewWordFragment", "Create fragment")
    }

}