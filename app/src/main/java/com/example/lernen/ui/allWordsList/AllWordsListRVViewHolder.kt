package com.example.lernen.ui.allWordsList

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lernen.databinding.AllWordsListRvElementsBinding
import kotlinx.android.synthetic.main.all_words_list_rv_elements.view.*

class AllWordsListRVViewHolder(val binding: AllWordsListRvElementsBinding): RecyclerView.ViewHolder(binding.root)/*(itemLayoutView: View): RecyclerView.ViewHolder(itemLayoutView) {

    private var wordTV: TextView = itemLayoutView.allWordsListRvElementsWordTV
    private var translationTV: TextView = itemLayoutView.allWordsListRvElementsTranslationTV

    fun bind(
            word: String,
            translation: String
    ){
        wordTV.text = word
        translationTV.text = translation
    }
}*/