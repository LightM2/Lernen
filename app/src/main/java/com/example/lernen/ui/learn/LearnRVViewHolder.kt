package com.example.lernen.ui.learn

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.all_lesson_list_rv_elements.view.*

class LearnRVViewHolder(itemLayoutView: View): RecyclerView.ViewHolder(itemLayoutView) {

    private var lessonButton = itemLayoutView.someLessonButton

    fun bind(
            lesson: String
    ){
        lessonButton.text = lesson
    }
}