package com.example.lernen.ui.learn

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.lernen.R
import com.example.lernen.databinding.AllLessonListRvElementsBinding
import com.example.lernen.databinding.LearnFragmentBinding
import com.example.lernen.room.Lesson
import com.example.lernen.room.WordEntity
import java.util.*

class LearnRVAdapter(private val lessonList: List<Lesson>): RecyclerView.Adapter<LearnRVViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnRVViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: AllLessonListRvElementsBinding = DataBindingUtil
                .inflate(layoutInflater, R.layout.all_lesson_list_rv_elements, parent, false)

        return LearnRVViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LearnRVViewHolder, position: Int) {
        val lesson = lessonList[position]
        holder.binding.lesson = lesson
        holder.binding.someLessonButton.setOnClickListener { view ->
            Log.d("LearnBO", "lesson ${lesson.lesson}")
            if (lesson.lesson != "Слова відсутні"){
                Log.d("LearnBO", "navigate")
                val bundle = Bundle()
                bundle.putString("lesson", lesson.lesson)
                view.findNavController().navigate(R.id.action_learnFragment_to_learnNewWordsFragment, bundle)
            }

            Log.d("LearnBO", "Navigation mast work")
        }
    }

    override fun getItemCount(): Int = lessonList.size

}

