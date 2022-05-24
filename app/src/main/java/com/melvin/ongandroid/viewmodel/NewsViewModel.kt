package com.melvin.ongandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.ongandroid.businesslogic.repository.NewsRepository
import com.melvin.ongandroid.model.data.NewResponse
import kotlinx.coroutines.launch

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    suspend fun getNews() {
        _state.value = State.Loading()
        viewModelScope.launch {
            val news = newsRepository.getNews()
        }
    }

    sealed class State() {
        class Success(val news: NewResponse) : State()
        class Failure(val cause: Throwable) : State()
        class Loading() : State()
    }

    private val _state = MutableLiveData<State>()
    val state: LiveData<State>
        get() = _state

}