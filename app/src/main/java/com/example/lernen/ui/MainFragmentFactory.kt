package com.example.lernen.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.lernen.repository.MainRepository
import com.example.lernen.ui.addNewWord.AddNewWordFragment
import com.example.lernen.ui.allWordsList.AllWordsListFragment
import com.example.lernen.ui.learn.LearnFragment
import com.example.lernen.ui.learnNewWords.LearnNewWordsFragment
import com.example.lernen.ui.main.MainFragment
import javax.inject.Inject


class MainFragmentFactory
@Inject
constructor(
    private val mainRepository: MainRepository
): FragmentFactory(){

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className){
            MainFragment::class.java.name -> {
                val fragment = MainFragment()
                fragment
            }
            AddNewWordFragment::class.java.name -> {
                val fragment = AddNewWordFragment()
                fragment
            }
            AllWordsListFragment::class.java.name -> {
                val fragment = AllWordsListFragment()
                fragment
            }
            LearnFragment::class.java.name -> {
                val fragment = LearnFragment()
                fragment
            }
            LearnNewWordsFragment::class.java.name -> {
                val fragment = LearnNewWordsFragment()
                fragment
            }
            else -> super.instantiate(classLoader, className)
        }
    }
}