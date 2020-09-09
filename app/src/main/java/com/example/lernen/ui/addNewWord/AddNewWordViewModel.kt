package com.example.lernen.ui.addNewWord

import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.lernen.repository.MainRepository
import com.example.lernen.room.WordEntity
import kotlinx.coroutines.*

class AddNewWordViewModel
@ViewModelInject
constructor(
        private val mainRepository: MainRepository,
        @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel(), Observable {

    var newLesson = MutableLiveData<String>()

    var newWord = MutableLiveData<String>()

    var newTranslation = MutableLiveData<String>()

    fun addNewWord(view: View){
        println("addNewWord")
        Log.d("AddNewWordViewModel", "addNewWord")
        Log.d("AddNewWordViewModel", "Lesson - ${newLesson.value}")
        Log.d("AddNewWordViewModel", "Word - ${newWord.value}")
        Log.d("AddNewWordViewModel", "Translation - ${newTranslation.value}")
        viewModelScope.launch {
            if (newWord.value != null && newLesson.value != null && newTranslation.value != null){
                mainRepository.setWord(WordEntity(0, newLesson.value!!, newWord.value!!, newTranslation.value!!))
                Log.d("AddNewWordViewModel", "new word added")
                newLesson.value = ""
                newWord.value = ""
                newTranslation.value = ""
                notifyChange()
                val toast = Toast.makeText(view.context, "Слово додане", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            }else{
                val toast = Toast.makeText(view.context, "Не всі полля заповненні", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            }


        }

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