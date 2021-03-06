package com.example.lernen.ui.allWordsList

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lernen.R
import com.example.lernen.databinding.AllWordsListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.all_words_list_fragment.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.*

@AndroidEntryPoint
class AllWordsListFragment
constructor(
) : Fragment(R.layout.all_words_list_fragment), TextToSpeech.OnInitListener  {

    private var tts: TextToSpeech? = null

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

        tts = TextToSpeech(this.context, this)

        val scopeIO = CoroutineScope(Job() + IO)
        val scopeMain = CoroutineScope(Job() + Main)
        scopeIO.launch {
            val data = viewModel.getDataFromDb()
            scopeMain.launch {
                allWordsListRV.apply {
                    layoutManager = LinearLayoutManager(activity)
                    adapter = AllWordsListRVAdapter(data, tts!!)
                }
            }
        }


        Log.d("AllWordsListFragment", "Create fragment")
    }


    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS){
            val result = tts!!.setLanguage(Locale.GERMAN)

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("TTS", "The Language specified is not supported")
            }
        }else Log.e("TTS", " Initialization Failed")
    }





}