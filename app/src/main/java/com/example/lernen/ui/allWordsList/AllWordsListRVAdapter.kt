package com.example.lernen.ui.allWordsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lernen.R
import com.example.lernen.room.Lesson
import com.example.lernen.room.Word
import com.example.lernen.room.WordEntity

class AllWordsListRVAdapter(private val dataList: MutableList<Word>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 1) {
            val itemLayoutView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.all_words_list_rv_elements_header, parent, false)
            TextViewHolder(itemLayoutView)
        } else {
            val itemLayoutView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.all_words_list_rv_elements, parent, false)
            AllWordsListRVViewHolder(itemLayoutView)
        }

    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = dataList[position]
        when{
            holder is TextViewHolder && data is Lesson -> {
                holder.bind(
                        data.lesson
                )
            }
            holder is AllWordsListRVViewHolder && data is WordEntity -> {
                holder.bind(
                        data.word,
                        data.translation
                )
            }
        }



    }

    override fun getItemCount(): Int = dataList.size

    override fun getItemViewType(position: Int): Int {
        return dataList[position].getItemType()
    }
}

