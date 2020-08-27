package com.example.lernen.ui.allWordsList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lernen.R
import com.example.lernen.databinding.AllWordsListFragmentBinding
import com.example.lernen.repository.MainRepository
import com.example.lernen.ui.addNewWord.AddNewWordViewModel
import com.example.lernen.ui.learn.LearnViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.all_words_list_fragment.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AllWordsListFragment
constructor(
        private val mainRepository: MainRepository
) : Fragment(R.layout.all_words_list_fragment) {

    private lateinit var binding: AllWordsListFragmentBinding

    private val viewModel: AllWordsListViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.all_words_list_fragment, container, false)
        binding.allWordsListViewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val scopeIO = CoroutineScope(Job() + IO)
        val scopeMain = CoroutineScope(Job() + Main)
        scopeIO.launch {
            val data = viewModel.getDataFromDb()
            scopeMain.launch {
                if (data != null){
                    allWordsListRV.apply {
                        layoutManager = LinearLayoutManager(activity)
                        adapter = AllWordsListRVAdapter(data)
                    }
                }
            }
        }


        Log.d("AllWordsListFragment", "Create fragment")
    }




}