package com.melvin.ongandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.ongandroid.businesslogic.repository.HomeRepository
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
import com.melvin.ongandroid.model.data.HomeSlides
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
=======
>>>>>>> 03694ee (fix commit)
=======
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
=======
>>>>>>> 03694ee (fix commit)
=======

>>>>>>> 5e4589c (Testimony fragment added)
=======
=======
import com.melvin.ongandroid.model.data.HomeSlides
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
>>>>>>> c555745 (Hilt dependencies and spinner  added)
=======
=======
import com.melvin.ongandroid.model.data.HomeSlides
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
=======
>>>>>>> 03694ee (fix commit)
>>>>>>> cb766a0 (fix commit)
=======
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
=======
>>>>>>> 03694ee (fix commit)
=======

>>>>>>> 5e4589c (Testimony fragment added)
=======
>>>>>>> ee97f54 (post PR en local)
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> c555745 (Hilt dependencies and spinner  added)
=======
>>>>>>> cb766a0 (fix commit)
class MainActivityViewModel @Inject constructor(private val homeRepository: HomeRepository) :
    ViewModel() {
=======
class MainActivityViewModel @Inject constructor (private val homeRepository: HomeRepository) : ViewModel() {
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> cb766a0 (fix commit)
=======
class MainActivityViewModel @Inject constructor(private val homeRepository: HomeRepository) :
    ViewModel() {
>>>>>>> 03694ee (fix commit)
<<<<<<< HEAD
=======
class MainActivityViewModel @Inject constructor (private val homeRepository: HomeRepository) : ViewModel() {
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
=======
class MainActivityViewModel @Inject constructor(private val homeRepository: HomeRepository) :
    ViewModel() {
>>>>>>> 03694ee (fix commit)
=======
class MainActivityViewModel @Inject constructor(private val homeRepository: HomeRepository) :
    ViewModel() {
>>>>>>> 5e4589c (Testimony fragment added)
=======
>>>>>>> c555745 (Hilt dependencies and spinner  added)
=======
>>>>>>> cb766a0 (fix commit)
=======
class MainActivityViewModel @Inject constructor (private val homeRepository: HomeRepository) : ViewModel() {
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
=======
class MainActivityViewModel @Inject constructor(private val homeRepository: HomeRepository) :
    ViewModel() {
>>>>>>> 03694ee (fix commit)
=======
class MainActivityViewModel @Inject constructor(private val homeRepository: HomeRepository) :
    ViewModel() {
>>>>>>> 5e4589c (Testimony fragment added)
=======
class MainActivityViewModel @Inject constructor(private val homeRepository: HomeRepository) :
    ViewModel() {
>>>>>>> ee97f54 (post PR en local)

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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> c555745 (Hilt dependencies and spinner  added)
=======
>>>>>>> cb766a0 (fix commit)
    //Definition of states
    suspend fun getTestimonials() {
=======
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
=======
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
    suspend fun getTestimonials(){
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
=======
    suspend fun getTestimonials() {
>>>>>>> 03694ee (fix commit)
<<<<<<< HEAD
=======
    suspend fun getTestimonials() {
>>>>>>> 03694ee (fix commit)
=======
    //Call Testimonials
    suspend fun getTestimonials() {
>>>>>>> 5e4589c (Testimony fragment added)
=======
    suspend fun getTestimonials(){
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
>>>>>>> c555745 (Hilt dependencies and spinner  added)
=======
>>>>>>> cb766a0 (fix commit)
=======
    suspend fun getTestimonials() {
>>>>>>> 03694ee (fix commit)
=======
=======
>>>>>>> ee97f54 (post PR en local)
    //Call Testimonials
    suspend fun getTestimonials() {
        _state.value = State.Loading()
        viewModelScope.launch {
            val testimonials = homeRepository.getTestimonials()
        }
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> 737af41 (fix commit)
=======
>>>>>>> 9ba56be (Hilt dependencies and spinner  added)
=======
>>>>>>> 96261e4 (fix commit)
=======
>>>>>>> dd3c420 (Testimony fragment added)
<<<<<<< HEAD
=======
>>>>>>> c555745 (Hilt dependencies and spinner  added)
=======
>>>>>>> cb766a0 (fix commit)
    //Definition of states
=======
=======
    //Definition of states
>>>>>>> f49350f (Hilt dependencies and spinner  added)
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
<<<<<<< HEAD
<<<<<<< HEAD
=======
    //Definition of states
>>>>>>> 03694ee (fix commit)
=======
=======
    //Definition of states
>>>>>>> f49350f (Hilt dependencies and spinner  added)
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
=======
    //Definition of states
>>>>>>> 03694ee (fix commit)
=======
    //Definition of states
>>>>>>> 5e4589c (Testimony fragment added)
=======
>>>>>>> c555745 (Hilt dependencies and spinner  added)
=======
=======
    //Definition of states
>>>>>>> 03694ee (fix commit)
>>>>>>> cb766a0 (fix commit)
=======
=======
    //Definition of states
>>>>>>> f49350f (Hilt dependencies and spinner  added)
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
=======
    //Definition of states
>>>>>>> 03694ee (fix commit)
=======
    //Definition of states
>>>>>>> 5e4589c (Testimony fragment added)
=======
    //Definition of states
>>>>>>> ee97f54 (post PR en local)
    sealed class State() {
        class Success() : State()
        class Failure(val cause: Throwable) : State()
        class Loading() : State()
    }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
<<<<<<< HEAD
>>>>>>> f744c22 (Hilt dependencies and spinner  added)
=======
=======
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
<<<<<<< HEAD
>>>>>>> 9ba56be (Hilt dependencies and spinner  added)
=======
=======
>>>>>>> 5e4589c (Testimony fragment added)
>>>>>>> dd3c420 (Testimony fragment added)
=======

=======
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
>>>>>>> c555745 (Hilt dependencies and spinner  added)
=======
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
=======
>>>>>>> 5e4589c (Testimony fragment added)
=======
>>>>>>> ee97f54 (post PR en local)
}