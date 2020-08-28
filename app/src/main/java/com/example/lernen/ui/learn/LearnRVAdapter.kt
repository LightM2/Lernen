package com.example.lernen.ui.learn

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lernen.R
import java.util.*

class LearnRVAdapter(private val lessonList: List<Int>): RecyclerView.Adapter<LearnRVViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnRVViewHolder {
        val itemLayoutView = LayoutInflater.from(parent.context)
                .inflate(R.layout.all_lesson_list_rv_elements, parent, false)
        return LearnRVViewHolder(itemLayoutView)
    }

    override fun onBindViewHolder(holder: LearnRVViewHolder, position: Int) {
        val lesson = lessonList[position].toString()
        holder.bind(lesson)
    }

    override fun getItemCount(): Int = lessonList.size

}