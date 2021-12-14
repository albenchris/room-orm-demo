package com.example.roomormdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WordViewModel(private val repository: WordRepository) : ViewModel() {

    /**
     * Using LiveData and chaching what allWords returns has several benefits:
     *  - We can put an observer on the data (instead of polling for changes)
     *      and only update the UI when the data actually changes
     *  - Repository is completely separated from the UI through ViewModel
     */
    val allWords: LiveData<List<Word>> = repository.allWords.asLiveData()

    /**
     * Launching a new coroutine to insert the data in the non-blocking way
     */
    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }
}