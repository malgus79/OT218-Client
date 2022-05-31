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
<<<<<<< HEAD
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {
=======
class HomeViewModel @Inject constructor(private val homeRepository: HomeRepository) : ViewModel() {
>>>>>>> ee97f54ad755c3795943cd7fc03e4f3485834fc8

    init {
        getSlides()
        getTestimonials()
        getNews()
    }

    /* ---------------------------SLIDES REQUEST--------------------------- */
    //Internal MutableLiveData
    private val _slidesList = MutableLiveData<SlidesList>()

    //External LiveData
    val slidesList: LiveData<SlidesList> = _slidesList

<<<<<<< HEAD

=======
>>>>>>> ee97f54ad755c3795943cd7fc03e4f3485834fc8
    fun getSlides() {
        var homeSlides: SlidesList
        viewModelScope.launch {
            try {
                homeSlides = homeRepository.getHomeSlides()
                _slidesList.value = homeSlides

            } catch (e: Exception) {
                homeSlides = SlidesList(emptyList(), "Error retrieving slides", false)
                _slidesList.value = homeSlides

            }
        }
    }

    /* ---------------------------TESTIMONIALS REQUEST--------------------------- */
    //Internal MutableLiveData
    private val _testimonialsList = MutableLiveData<TestimonialsList>()

    //External LiveData
    val testimonialsList: LiveData<TestimonialsList> = _testimonialsList

<<<<<<< HEAD

=======
>>>>>>> ee97f54ad755c3795943cd7fc03e4f3485834fc8
    fun getTestimonials() {
        var homeTestimonials: TestimonialsList

        viewModelScope.launch {

            try {
                homeTestimonials = homeRepository.getTestimonials()
                _testimonialsList.value = homeTestimonials

            } catch (e: Exception) {
                homeTestimonials = TestimonialsList(false, null, "Error retrieving testimonials")
                _testimonialsList.value = homeTestimonials

            }
        }
    }

<<<<<<< HEAD
    /* ---------------------------NEWS REQUEST--------------------------- */
    //Internal MutableLiveData
    private val _newsList = MutableLiveData<NewsList>()

    //External LiveData
    val newsList: LiveData<NewsList> = _newsList

    private fun getNews() {
        var newsList: NewsList
        viewModelScope.launch {

            try {
                newsList = homeRepository.getNews()
                _newsList.value = newsList

            } catch (e: Exception) {
                newsList = NewsList(emptyList(), "Error retrieving slides", false)
                _newsList.value = newsList

            }


        }
    }

=======
/* ---------------------------NEWS REQUEST--------------------------- *//*

    //Internal MutableLiveData
    private val _newsStatus = MutableLiveData<State>()
    private val _newsList = MutableLiveData<List<New>?>()
    //External LiveData
    val newsStatus: LiveData<State> = _newsStatus
    val newsList: LiveData<List<New>?> = _newsList

    suspend fun getNews(){
        _newsStatus.value = State.Loading()
        viewModelScope.launch {
            try {
                // val news = homeRepository.getNews().data
                _newsStatus.value = State.Success()
                // _newsList.value = news
            }
            catch (e: Exception){
                _newsStatus.value = State.Failure(e)
            }
        }
    }
*/

    sealed class State() {
        class Success() : State()
        class Failure(val cause: Throwable) : State()
        class Loading() : State()
    }
>>>>>>> ee97f54ad755c3795943cd7fc03e4f3485834fc8
}
