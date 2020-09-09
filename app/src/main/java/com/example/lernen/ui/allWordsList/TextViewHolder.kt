package com.example.lernen.ui.allWordsList

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lernen.databinding.AllWordsListRvElementsBinding
import com.example.lernen.databinding.AllWordsListRvElementsHeaderBinding
import kotlinx.android.synthetic.main.all_words_list_rv_elements_header.view.*

class TextViewHolder(val binding: AllWordsListRvElementsHeaderBinding): RecyclerView.ViewHolder(binding.root)
/*(itemLayoutView: View): RecyclerView.ViewHolder(itemLayoutView) {

    private var lessonTV: TextView = itemLayoutView.someLessonTV

    fun bind(
            lesson: String
    ){
        lessonTV.text = lesson
    }
}*/