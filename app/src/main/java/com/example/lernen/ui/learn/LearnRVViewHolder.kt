package com.example.lernen.ui.learn

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.lernen.R
import com.example.lernen.databinding.AllLessonListRvElementsBinding
import com.example.lernen.databinding.LearnFragmentBinding
import kotlinx.android.synthetic.main.all_lesson_list_rv_elements.view.*

class LearnRVViewHolder(val binding: AllLessonListRvElementsBinding): RecyclerView.ViewHolder(binding.root) /*{

    private var lessonButton = itemLayoutView.someLessonButton

    val binding = DataBindingUtil.bind<ViewDataBinding>(itemLayoutView)


    fun bind(
            lesson: String
    ){
        lessonButton.text = lesson
    }
}*/