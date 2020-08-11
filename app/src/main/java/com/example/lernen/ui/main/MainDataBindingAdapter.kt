package com.example.lernen.ui.main

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import com.example.lernen.R
import com.google.android.material.button.MaterialButton

class MainDataBindingAdapter {
    companion object CurrencyBindingAdapter {

        @BindingAdapter("navigationListener")
        @JvmStatic
        fun bindCurrency(view: MaterialButton, clickListener: View.OnClickListener) {
            Log.d("MainDataBindingAdapter", "NavigationListener work")


            view.setOnClickListener {
                when(view.id) {
                    R.id.add_new_word_button -> view.findNavController().navigate(R.id.action_mainFragment_to_addNewWordFragment)
                    R.id.all_words_list_button -> view.findNavController().navigate(R.id.action_mainFragment_to_allWordsListFragment)
                    R.id.learn_button -> view.findNavController().navigate(R.id.action_mainFragment_to_learnFragment)
                    else -> Log.d("MainDataBindingAdapter", "This button doesn't exist in MainDataBindingAdapter")
                }

            }

        }
    }

}