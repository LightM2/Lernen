package com.example.lernen.ui.allWordsList

import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.lernen.R
import com.example.lernen.databinding.AllWordsListRvElementsBinding
import com.example.lernen.databinding.AllWordsListRvElementsHeaderBinding
import com.example.lernen.room.Lesson
import com.example.lernen.room.Word
import com.example.lernen.room.WordEntity
import java.util.*

class AllWordsListRVAdapter(private val dataList: MutableList<Word>, private var tts: TextToSpeech) : RecyclerView.Adapter<RecyclerView.ViewHolder>()
        {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return if (viewType == 1) {
            val binding: AllWordsListRvElementsHeaderBinding = DataBindingUtil
                    .inflate(layoutInflater, R.layout.all_words_list_rv_elements_header, parent, false)
            TextViewHolder(binding)
        } else {
            val binding: AllWordsListRvElementsBinding = DataBindingUtil
                    .inflate(layoutInflater, R.layout.all_words_list_rv_elements, parent, false)

            AllWordsListRVViewHolder(binding)
        }

    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = dataList[position]
        when{
            holder is TextViewHolder && data is Lesson -> {
                holder.binding.lesson = data

            }
            holder is AllWordsListRVViewHolder && data is WordEntity -> {
                holder.binding.wordEntity = data

                holder.binding.soundButton.setOnClickListener { view ->
                    //tts = TextToSpeech(view.context, this)
                    Log.d("AllWordsListRVAdapter", "OnClick - ${data.word}")
                    tts.speak(data.word, TextToSpeech.QUEUE_FLUSH, null, "")
                }

            }
        }


    }

    override fun getItemCount(): Int = dataList.size

    override fun getItemViewType(position: Int): Int {
        return dataList[position].getItemType()
    }

}

