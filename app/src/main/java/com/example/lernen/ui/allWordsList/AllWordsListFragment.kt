package com.example.lernen.ui.allWordsList

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.lernen.R
import com.example.lernen.ui.learn.LearnViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllWordsListFragment
constructor() : Fragment(R.layout.all_words_list_fragment) {


    private val viewModel: AllWordsListViewModel by viewModels()

    @LayoutRes
    fun getLayoutId(): Int = R.layout.all_words_list_fragment


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        Log.d("AllWordsListFragment", "Create fragment")
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