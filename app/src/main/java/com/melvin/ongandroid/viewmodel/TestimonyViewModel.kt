package com.melvin.ongandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.ongandroid.businesslogic.repository.HomeRepository
import com.melvin.ongandroid.model.data.testimonials.TestimonialsList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestimonyViewModel @Inject constructor(private val homeRepository: HomeRepository) :
    ViewModel() {

    //Create states testimony
    private val _state = MutableLiveData<State>()
    val state: LiveData<State>
        get() = _state

    //metodo show Testimony
    fun getTestimonials() {
        _state.value = State.Loading()
        viewModelScope.launch {
            val testimonyList = homeRepository.getTestimonials()
            if (testimonyList.testimonials.isNullOrEmpty()) {
                throw TestimonyListNotFoundedException()
            } else {
                _state.postValue(State.Success(testimonyList))
            }
        }
    }


    //Definition of states
    sealed class State() {
        class Success(val testimonialsList: TestimonialsList) : State()
        class Failure(val cause: Throwable) : State()
        class Loading() : State()
    }
    class TestimonyListNotFoundedException : Exception("The api returned an empty list")
}
