package com.example.lernen.ui.learnNewWords

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.example.lernen.BR
import com.example.lernen.R
import com.example.lernen.repository.MainRepository
import com.example.lernen.room.WordEntity
import kotlinx.coroutines.launch
import kotlin.random.Random

class LearnNewWordsViewModel
@ViewModelInject
constructor(
        private val mainRepository: MainRepository,
        @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel(), Observable{

    private val TAG = "LearnNewWordsViewModel"

    var scoreLV = MutableLiveData("0")
    private var score = 0
    private var maxScore :Int = 0
    private var random = 0

    private val bundle = Bundle()

    var translation = MutableLiveData<String>()

    private lateinit var listLessonWords: MutableList<WordEntity>

    @Bindable
    var word = "Слово"
    private lateinit var correctAnswer :String



    fun onClick(view: View) {
        Log.d(TAG, "onClick mast work")

        val toastText = checkAnswer()
        if (toastText != null){
            val toast = Toast.makeText(view.context, toastText, Toast.LENGTH_LONG)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        }else view.findNavController().navigate(R.id.action_learnNewWordsFragment_to_congratsFragment, bundle)





    }

    fun getLessonWords(lesson: String){
        bundle.putString("lesson", lesson)
        viewModelScope.launch {
            listLessonWords = if (lesson.compareTo("Всі") == 0){
                mainRepository.getWords() as MutableList<WordEntity>
            }else mainRepository.getSomeLessonWords(lesson) as MutableList<WordEntity>
            maxScore = listLessonWords.size
            randomWords()
            notifyPropertyChanged(BR.word)
            Log.d(TAG, "listLessonWords - $listLessonWords")
        }
    }

    private fun randomWords(){
        random = (0 until listLessonWords.size).random()
        word = listLessonWords[random].translation
        correctAnswer = listLessonWords[random].word

    }

    private fun checkAnswer(): String?{
        return if (correctAnswer.compareTo(translation.value!!, ignoreCase = true) == 0){
            listLessonWords.removeAt(random)
            score++
            scoreLV.value = score.toString()
            translation.value = ""
            if (score < maxScore){
                randomWords()
                notifyChange()
                "Правильно"
            }else null

        } else "Помилка"
    }

    @Transient
    private var mCallbacks: PropertyChangeRegistry? = null

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
        synchronized(this) {
            if (mCallbacks == null) {
                mCallbacks = PropertyChangeRegistry()
            }
        }
        mCallbacks!!.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
        synchronized(this) {
            if (mCallbacks == null) {
                return
            }
        }
        mCallbacks!!.remove(callback)
    }

    /**
     * Notifies listeners that all properties of this instance have changed.
     */
    fun notifyChange() {
        synchronized(this) {
            if (mCallbacks == null) {
                return
            }
        }
        mCallbacks!!.notifyCallbacks(this, 0, null)
    }

    /**
     * Notifies listeners that a specific property has changed. The getter for the property
     * that changes should be marked with [Bindable] to generate a field in
     * `BR` to be used as `fieldId`.
     *
     * @param fieldId The generated BR id for the Bindable field.
     */
    fun notifyPropertyChanged(fieldId: Int) {
        synchronized(this) {
            if (mCallbacks == null) {
                return
            }
        }
        mCallbacks!!.notifyCallbacks(this, fieldId, null)
    }


}