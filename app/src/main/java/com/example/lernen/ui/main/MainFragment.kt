package com.example.lernen.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.viewModels
import com.example.lernen.R
import com.example.lernen.databinding.MainFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment
constructor() : Fragment(R.layout.main_fragment) {

    private lateinit var binding: MainFragmentBinding

    private val viewModel: MainViewModel by viewModels()

    @LayoutRes
    fun getLayoutId(): Int = R.layout.main_fragment


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Log.d("MainFragment", "Create fragment")
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.setVariable(BR.viewModel, viewModel)
        return binding.root
    }


}