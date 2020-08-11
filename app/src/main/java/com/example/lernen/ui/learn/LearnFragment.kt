package com.example.lernen.ui.learn

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.lernen.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LearnFragment
constructor() : Fragment(R.layout.learn_fragment) {


    private val viewModel: LearnViewModel by viewModels()

    @LayoutRes
    fun getLayoutId(): Int = R.layout.learn_fragment


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        Log.d("LearnFragment", "Create fragment")
    }

    /*override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.setVariable(BR.viewModel, viewModel)
        return binding.root
    }*/


}