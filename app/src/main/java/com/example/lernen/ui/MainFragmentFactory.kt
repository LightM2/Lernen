package com.example.lernen.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.lernen.ui.addNewWord.AddNewWordFragment
import com.example.lernen.ui.allWordsList.AllWordsListFragment
import com.example.lernen.ui.learn.LearnFragment
import com.example.lernen.ui.main.MainFragment
import javax.inject.Inject


class MainFragmentFactory
@Inject
constructor(): FragmentFactory(){

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
            else -> super.instantiate(classLoader, className)
        }
    }
}