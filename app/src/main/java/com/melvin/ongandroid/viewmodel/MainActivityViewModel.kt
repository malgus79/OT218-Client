package com.melvin.ongandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.ongandroid.businesslogic.repository.HomeRepository
import com.melvin.ongandroid.model.data.HomeSlides
import kotlinx.coroutines.launch

class MainActivityViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    suspend fun getHomeSlides() {
        _state.value = State.Loading()
        viewModelScope.launch {
            val homeSlides = homeRepository.getHomeSlides()
        }
    }

    suspend fun getTestimonials(){
        _state.value = State.Loading()
        viewModelScope.launch {
            val testimonials = homeRepository.getTestimonials()
        }
    }

    suspend fun getNews(){
        _state.value = State.Loading()
        viewModelScope.launch {
            val news = homeRepository.getNews()
        }
    }

    sealed class State() {
        class Success() : State()
        class Failure(val cause: Throwable) : State()
        class Loading() : State()
    }

    private val _state = MutableLiveData<State>()
    val state: LiveData<State>
        get() = _state

}