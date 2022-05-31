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
import com.melvin.ongandroid.model.APIServices
import com.melvin.ongandroid.model.data.news.New
import com.melvin.ongandroid.model.data.slides.Slide
import com.melvin.ongandroid.model.data.slides.SlidesList
import com.melvin.ongandroid.model.data.testimonials.Testimonial
<<<<<<< HEAD
<<<<<<< HEAD
import com.melvin.ongandroid.model.data.testimonials.TestimonialsList
=======
>>>>>>> 5e4589c (Testimony fragment added)
=======
import com.melvin.ongandroid.model.data.testimonials.TestimonialsList
>>>>>>> 08a6025 (slider compiling)
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepository: HomeRepository) : ViewModel() {
<<<<<<< HEAD
>>>>>>> 5e4589c (Testimony fragment added)
=======
>>>>>>> 5e4589c (Testimony fragment added)

    init {
        getSlides()
        getTestimonials()
        getNews()
    }
=======
class HomeViewModel @Inject constructor(private val homeRepository: HomeRepository) : ViewModel() {
>>>>>>> ee97f54 (post PR en local)

    init {
        getSlides()
        getTestimonials()
    }

    /* ---------------------------SLIDES REQUEST--------------------------- */
    //Internal MutableLiveData
    private val _slidesList = MutableLiveData<SlidesList>()

    //External LiveData
    val slidesList: LiveData<SlidesList> = _slidesList

<<<<<<< HEAD

<<<<<<< HEAD
=======


=======
    //External LiveData

    val slidesList: LiveData<SlidesList> = _slidesList


>>>>>>> 08a6025 (slider compiling)
>>>>>>> a53495d (slider compiling)
    fun getSlides() {
        var homeSlides: SlidesList
        viewModelScope.launch {
=======
    //External LiveData

    val slidesList: LiveData<SlidesList> = _slidesList


=======
>>>>>>> ee97f54 (post PR en local)
    fun getSlides() {
        var homeSlides: SlidesList
        viewModelScope.launch {

>>>>>>> 08a6025 (slider compiling)
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

    fun getTestimonials() {
=======

    private val _testimonialsList = MutableLiveData<TestimonialsList>()
    //External LiveData

    val testimonialsList: LiveData<TestimonialsList> = _testimonialsList

    fun getTestimonials(){
>>>>>>> 08a6025 (slider compiling)
=======
    fun getTestimonials() {
>>>>>>> ee97f54 (post PR en local)
        var homeTestimonials: TestimonialsList

=======

    private val _testimonialsList = MutableLiveData<TestimonialsList>()
    //External LiveData

    val testimonialsList: LiveData<TestimonialsList> = _testimonialsList

    fun getTestimonials(){
        var homeTestimonials: TestimonialsList
>>>>>>> 08a6025 (slider compiling)
        viewModelScope.launch {

            try {
                homeTestimonials = homeRepository.getTestimonials()
                _testimonialsList.value = homeTestimonials

            } catch (e: Exception) {
<<<<<<< HEAD
                homeTestimonials = TestimonialsList(false, null, "Error retrieving testimonials")
                _testimonialsList.value = homeTestimonials

=======
                homeTestimonials = TestimonialsList(false,null,"Error retrieving testimonials")
                _testimonialsList.value = homeTestimonials
>>>>>>> 08a6025 (slider compiling)
            }
        }
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    /* ---------------------------NEWS REQUEST--------------------------- */
=======
/*

    */
/* ---------------------------NEWS REQUEST--------------------------- *//*

>>>>>>> 08a6025 (slider compiling)
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

}
=======
=======
>>>>>>> a53495d (slider compiling)
<<<<<<< HEAD
=======
    /* ---------------------------NEWS REQUEST--------------------------- */
=======
/*

    */
/* ---------------------------NEWS REQUEST--------------------------- *//*

>>>>>>> 08a6025 (slider compiling)
    //Internal MutableLiveData
=======
    /* ---------------------------NEWS REQUEST--------------------------- */
=======
/* ---------------------------NEWS REQUEST--------------------------- *//*

>>>>>>> ee97f54 (post PR en local)
    //Internal MutableLiveData
>>>>>>> 5e4589c (Testimony fragment added)
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
<<<<<<< HEAD
<<<<<<< HEAD
*/
=======
>>>>>>> 5e4589c (Testimony fragment added)
=======
*/
>>>>>>> 08a6025 (slider compiling)

    sealed class State() {
        class Success() : State()
        class Failure(val cause: Throwable) : State()
        class Loading() : State()
    }
}
<<<<<<< HEAD
>>>>>>> 5e4589c (Testimony fragment added)
>>>>>>> dd3c420 (Testimony fragment added)
=======
>>>>>>> ee97f54 (post PR en local)
