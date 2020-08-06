package com.example.lernen.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import com.example.lernen.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment
constructor() : Fragment(R.layout.main_fragment) {

    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("MainFragment", "Create fragment")
    }

}