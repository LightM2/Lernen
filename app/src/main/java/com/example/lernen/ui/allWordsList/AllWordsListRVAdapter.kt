package com.example.lernen.ui.allWordsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lernen.R
import com.example.lernen.room.WordEntity

class AllWordsListRVAdapter(private val dataList: List<WordEntity>): RecyclerView.Adapter<AllWordsListRVViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllWordsListRVViewHolder {
        val itemLayoutView = LayoutInflater.from(parent.context)
                .inflate(R.layout.all_words_list_rv_elements, parent, false)
        return AllWordsListRVViewHolder(itemLayoutView)
    }

    override fun onBindViewHolder(holder: AllWordsListRVViewHolder, position: Int) {
        val data = dataList[position]

        holder.bind(
                data.lesson,
                data.word,
                data.translation
        )
    }

    override fun getItemCount(): Int = dataList.size
}