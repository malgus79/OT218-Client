package com.melvin.ongandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.ongandroid.businesslogic.repository.HomeRepository
import com.melvin.ongandroid.model.data.slides.SlidesList
import com.melvin.ongandroid.model.data.testimonials.TestimonialsList
import dagger.hilt.android.lifecycle.HiltViewModel
import com.melvin.ongandroid.model.data.news.NewsList
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.Exception

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {

    init {
        //getSlides()
        //getTestimonials()
        //getNews()
    }

    /* ---------------------------SLIDES REQUEST--------------------------- */
    //Internal MutableLiveData
    private val _slidesList = MutableLiveData<State<SlidesList>>()

    //External LiveData
    val slidesList: LiveData<State<SlidesList>> = _slidesList

    fun getSlides() {
        _slidesList.postValue(State.Loading())
        viewModelScope.launch {
            val slidesList = homeRepository.getHomeSlides()
            if (slidesList.slide.isNullOrEmpty()) {
                throw ResourceNotFoundException()
            } else {
                _slidesList.postValue(State.Success(slidesList))
            }
        }
    }

    /* ---------------------------TESTIMONIALS REQUEST--------------------------- */
    //Internal MutableLiveData
    private val _testimonialsList = MutableLiveData<State<TestimonialsList>>()

    //External LiveData
    val testimonialsList: LiveData<State<TestimonialsList>> = _testimonialsList

    fun getTestimonials() {
        _testimonialsList.postValue(State.Loading())
        viewModelScope.launch {
            val testimonialsList = homeRepository.getTestimonials()
            if (testimonialsList.testimonials.isNullOrEmpty()) {
                throw ResourceNotFoundException()
            } else {
                _testimonialsList.postValue(State.Success(testimonialsList))
            }
        }
    }

    /* ---------------------------NEWS REQUEST--------------------------- */
    //Internal MutableLiveData
    private val _newsList = MutableLiveData<State<NewsList>>()

    //External LiveData
    val newsList: LiveData<State<NewsList>> = _newsList

    fun getNews() {
        _newsList.postValue(State.Loading())
        viewModelScope.launch {
            val newsList = homeRepository.getNews()
            if (newsList.data.isNullOrEmpty()) {
                throw ResourceNotFoundException()
            } else {
                _newsList.postValue(State.Success(newsList))
            }
        }
    }

}
