package com.example.lernen.ui.learnNewWords

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.lernen.R
import com.example.lernen.databinding.LearnNewWordsFragmentBinding
import com.example.lernen.repository.MainRepository
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LearnNewWordsFragment constructor(
        private val mainRepository: MainRepository
) : Fragment(R.layout.learn_new_words_fragment) {
    private val TAG = "LearnNewWordsFragment"

    private lateinit var binding: LearnNewWordsFragmentBinding

    private val viewModel: LearnNewWordsViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val lesson = arguments?.getString("lesson")
        Log.d(TAG, "lesson - $lesson")
        binding = DataBindingUtil.inflate(inflater, R.layout.learn_new_words_fragment, container, false)
        binding.learnNewWordsViewModel = viewModel
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Log.d(TAG, "Create fragment")
    }



}