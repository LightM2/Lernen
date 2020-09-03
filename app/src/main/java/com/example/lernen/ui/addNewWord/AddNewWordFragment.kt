package com.example.lernen.ui.addNewWord

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.lernen.R
import com.example.lernen.databinding.AddNewWordFragmentBinding
import com.example.lernen.repository.MainRepository
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNewWordFragment
constructor(
) : Fragment(R.layout.add_new_word_fragment) {

    private lateinit var binding: AddNewWordFragmentBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("AddNewWordFragment", "Create fragment")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel: AddNewWordViewModel by viewModels()
        binding = DataBindingUtil.inflate(inflater, R.layout.add_new_word_fragment, container, false)
        binding.addNewWordViewModel = viewModel
        return binding.root
    }

}