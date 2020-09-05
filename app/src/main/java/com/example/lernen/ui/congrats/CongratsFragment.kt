package com.example.lernen.ui.congrats

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.lernen.R
import com.example.lernen.databinding.CongratsFragmentBinding

class CongratsFragment: Fragment(R.layout.congrats_fragment) {

    private val TAG = "CongratsFragment"
    private lateinit var binding: CongratsFragmentBinding
    private val viewModel: CongratsViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val lesson = arguments?.getString("lesson")
        if (lesson != null) {
            viewModel.lesson = lesson
        }
        binding = DataBindingUtil.inflate(inflater, R.layout.congrats_fragment, container, false)
        binding.congratsViewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Log.d(TAG, "Create fragment")
    }
}