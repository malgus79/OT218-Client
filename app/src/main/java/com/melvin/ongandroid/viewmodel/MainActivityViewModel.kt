package com.melvin.ongandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.ongandroid.businesslogic.repository.HomeRepository
<<<<<<< HEAD
import com.melvin.ongandroid.model.data.HomeSlides
=======
>>>>>>> 1fea821a1435f5ab7446eed2c9455d553dc96039
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
<<<<<<< HEAD
class MainActivityViewModel @Inject constructor (private val homeRepository: HomeRepository) : ViewModel() {
=======
class MainActivityViewModel @Inject constructor(private val homeRepository: HomeRepository) :
    ViewModel() {
>>>>>>> 1fea821a1435f5ab7446eed2c9455d553dc96039

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
<<<<<<< HEAD
    suspend fun getTestimonials(){
=======
    //Definition of states
    suspend fun getTestimonials() {
>>>>>>> 1fea821a1435f5ab7446eed2c9455d553dc96039
        _state.value = State.Loading()
        viewModelScope.launch {
            val testimonials = homeRepository.getTestimonials()
        }
    }

<<<<<<< HEAD
=======
    //Definition of states
>>>>>>> f49350f (Hilt dependencies and spinner  added)
=======
    //Definition of states
>>>>>>> 1fea821a1435f5ab7446eed2c9455d553dc96039
    sealed class State() {
        class Success() : State()
        class Failure(val cause: Throwable) : State()
        class Loading() : State()
    }
}