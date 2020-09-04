package com.example.lernen.ui.allWordsList

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.all_words_list_rv_elements_header.view.*

class TextViewHolder(itemLayoutView: View): RecyclerView.ViewHolder(itemLayoutView) {

    private var lessonTV: TextView = itemLayoutView.someLessonTV

    fun bind(
            lesson: String
    ){
        lessonTV.text = lesson
    }
}
/*view: View): RecyclerView.ViewHolder(view){
    companion object{
        fun from(parent: ViewGroup):TextViewHolder{
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.all_words_list_rv_elements_header, parent, false)
            return TextViewHolder(view)
        }
    }
}*/