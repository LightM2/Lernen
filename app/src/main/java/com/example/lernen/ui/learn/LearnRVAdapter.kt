package com.example.lernen.ui.learn

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.lernen.R
import com.example.lernen.databinding.AllLessonListRvElementsBinding
import com.example.lernen.databinding.LearnFragmentBinding
import com.example.lernen.room.WordEntity
import java.util.*

class LearnRVAdapter(private val lessonList: List<String>): RecyclerView.Adapter<LearnRVViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnRVViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: AllLessonListRvElementsBinding = DataBindingUtil.inflate(layoutInflater, R.layout.all_lesson_list_rv_elements, parent, false)

        return LearnRVViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LearnRVViewHolder, position: Int) {
        val lesson = lessonList[position]
        holder.binding.learnBO = LearnBO(lesson)
    }

    override fun getItemCount(): Int = lessonList.size

}

