package com.example.lernen.ui.learn

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lernen.R
import com.example.lernen.databinding.LearnFragmentBinding
import com.example.lernen.repository.MainRepository
import com.example.lernen.room.Lesson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.learn_fragment.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LearnFragment
constructor(
) : Fragment(R.layout.learn_fragment) {
    private val TAG = "LearnFragment"

    private lateinit var binding: LearnFragmentBinding

    private val viewModel: LearnViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.learn_fragment, container, false)
        binding.learnViewModel = viewModel
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val scopeIO = CoroutineScope(Job() + IO)
        val scopeMain = CoroutineScope(Job() + Dispatchers.Main)
        scopeIO.launch {
            val lessons: MutableList<Lesson>? = viewModel.getAllLessonsList()
            scopeMain.launch {
                if (lessons != null){
                    allLessonListRV.apply {
                        layoutManager = LinearLayoutManager(activity)
                        adapter = LearnRVAdapter(lessons)
                    }
                }
            }
        }


        Log.d(TAG, "Create fragment")
    }



}