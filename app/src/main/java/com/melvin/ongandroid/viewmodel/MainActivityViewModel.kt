package com.melvin.ongandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.ongandroid.businesslogic.repository.HomeRepository
<<<<<<< HEAD
=======
import com.melvin.ongandroid.model.data.HomeSlides
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
<<<<<<< HEAD
class MainActivityViewModel @Inject constructor(private val homeRepository: HomeRepository) :
    ViewModel() {
=======
class MainActivityViewModel @Inject constructor (private val homeRepository: HomeRepository) : ViewModel() {
>>>>>>> bb72910 (Hilt dependencies and spinner  added)

    //Create states
    private val _state = MutableLiveData<State>()
    val state: LiveData<State>
        get() = _state

    //Create Spinner Loading
    private val _showProgress: MutableLiveData<State> = MutableLiveData()
    val showProgress: LiveData<State>
        get() = _state

    //Create progressBar
    fun isShowProgress(): LiveData<State> {
        return showProgress
    }

    //Call Slides
    suspend fun getHomeSlides() {
        _state.value = State.Loading()
        viewModelScope.launch {
            val homeSlides = homeRepository.getHomeSlides()
        }
    }

<<<<<<< HEAD
    //Definition of states
    suspend fun getTestimonials() {
=======
<<<<<<< HEAD
    suspend fun getTestimonials(){
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
        _state.value = State.Loading()
        viewModelScope.launch {
            val testimonials = homeRepository.getTestimonials()
        }
    }

<<<<<<< HEAD
    //Definition of states
=======
=======
    //Definition of states
>>>>>>> f49350f (Hilt dependencies and spinner  added)
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
    sealed class State() {
        class Success() : State()
        class Failure(val cause: Throwable) : State()
        class Loading() : State()
    }
<<<<<<< HEAD

=======
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
}