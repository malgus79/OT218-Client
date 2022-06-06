package com.melvin.ongandroid.viewmodel

import androidx.lifecycle.*
import com.melvin.ongandroid.businesslogic.repository.HomeRepository
import com.melvin.ongandroid.model.data.slides.SlidesList
import com.melvin.ongandroid.model.data.testimonials.TestimonialsList
import dagger.hilt.android.lifecycle.HiltViewModel
import com.melvin.ongandroid.model.data.news.NewsList
import com.melvin.ongandroid.model.network.ApiStatus
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {


    val homeStatusLiveDataMerger = MediatorLiveData<ApiStatus>()

    fun combineHomeStatusData(
        slidesStatus: LiveData<ApiStatus>,
        newsStatus: LiveData<ApiStatus>,
        testimonialsStatus: LiveData<ApiStatus>
    ): ApiStatus {
        val slides = slidesStatus.value!!
        val news: ApiStatus = newsStatus.value!!
        val testimonials = testimonialsStatus.value!!

        if (slides.ordinal + news.ordinal + testimonials.ordinal == 0) {
            return ApiStatus.DONE
        } else if ((slides.ordinal + news.ordinal + testimonials.ordinal) <= 3 && (slides != ApiStatus.ERROR) && (news != ApiStatus.ERROR) && (testimonials != ApiStatus.ERROR)) {
            return ApiStatus.LOADING
        }

        return ApiStatus.ERROR
    }

    fun messageCombineHomeStatusData(
        slidesStatus: LiveData<ApiStatus>,
        newsStatus: LiveData<ApiStatus>,
        testimonialsStatus: LiveData<ApiStatus>
    ): Int {
        val slides = slidesStatus.value!!
        val news: ApiStatus = newsStatus.value!!
        val testimonials = testimonialsStatus.value!!

        if (slides.ordinal + news.ordinal + testimonials.ordinal == 0) {
            return 0 //"Exito"
        } else if ((slides.ordinal + news.ordinal + testimonials.ordinal) <= 3 && (slides != ApiStatus.ERROR) && (news != ApiStatus.ERROR) && (testimonials != ApiStatus.ERROR)) {
            return 1 // "Cargando"
        } else if ((slides == ApiStatus.ERROR) && (news == ApiStatus.ERROR) && (testimonials == ApiStatus.ERROR)) {
            return 2 // "Inicio - Error general"
        } else if (slides == ApiStatus.ERROR) {
            return 3 // "Error al cargar slides"
        } else if (news == ApiStatus.ERROR) {
            return 4 // "Error al cargar novedades"
        } else {
            return 5 // "Error al cargar testimonios"
        }


    }

    /* ---------------------------SLIDES REQUEST--------------------------- */
    //Internal MutableLiveData
    private val _slidesList = MutableLiveData<SlidesList>()
    private val _slidesStatus = MutableLiveData<ApiStatus>()

    //External LiveData
    val slidesList: LiveData<SlidesList> = _slidesList
    val slidesStatus: LiveData<ApiStatus> = _slidesStatus

    fun getSlides() {
        _slidesStatus.value = ApiStatus.LOADING
        viewModelScope.launch {
            try {


                val slidesList = homeRepository.getHomeSlides()
                if (slidesList.slide.isNullOrEmpty()) {
                    _slidesStatus.value = ApiStatus.ERROR

                } else {
                    _slidesList.value = slidesList
                    _slidesStatus.value = ApiStatus.DONE

                }
            }catch (e: Exception){
                _slidesStatus.value = ApiStatus.ERROR
            }
        }
    }

    /* ---------------------------TESTIMONIALS REQUEST--------------------------- */
    //Internal MutableLiveData
    private val _testimonialsList = MutableLiveData<TestimonialsList>()
    private val _testimonialsStatus = MutableLiveData<ApiStatus>()

    //External LiveData
    val testimonialsList: LiveData<TestimonialsList> = _testimonialsList
    val testimonialsStatus: LiveData<ApiStatus> = _testimonialsStatus


    fun getTestimonials() {
        _testimonialsStatus.value = ApiStatus.LOADING
        viewModelScope.launch {
            try {
                val testimonialsList = homeRepository.getTestimonials()
                if (testimonialsList.testimonials.isNullOrEmpty()) {
                    _testimonialsStatus.value = ApiStatus.ERROR
                } else {
                    _testimonialsList.value = testimonialsList
                    _testimonialsStatus.value = ApiStatus.DONE
                }
            } catch (e: Exception) {
                _testimonialsStatus.value = ApiStatus.ERROR
            }
        }
    }

    /* ---------------------------NEWS REQUEST--------------------------- */
    //Internal MutableLiveData
    private val _newsList = MutableLiveData<NewsList>()
    private val _newsStatus = MutableLiveData<ApiStatus>()

    //External LiveData
    val newsList: LiveData<NewsList> = _newsList
    val newsStatus: LiveData<ApiStatus> = _newsStatus

    fun getNews() {
        _newsStatus.value = ApiStatus.LOADING
        viewModelScope.launch {
            try {
                val newsList = homeRepository.getNews()
                if (newsList.data.isNullOrEmpty()) {
                    _newsStatus.value = ApiStatus.ERROR
                } else {
                    _newsList.value = newsList
                    _newsStatus.value = ApiStatus.DONE
                }
            } catch (e: Exception) {
                _newsStatus.value = ApiStatus.ERROR
            }
        }
    }

    fun updateHome() {
        getSlides()
        getNews()
        getTestimonials()
    }

    fun updateSlidesAndNews() {
        getSlides()
        getNews()
    }

    fun updateSlidesAndTestimonials() {
        getSlides()
        getTestimonials()
    }

    fun updateNewsAndTestimonials() {
        getNews()
        getTestimonials()
    }
}


