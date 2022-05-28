package com.melvin.ongandroid.viewmodel

import android.transition.Slide
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.ongandroid.businesslogic.repository.HomeRepository
import com.melvin.ongandroid.model.data.ListSlide
import kotlinx.coroutines.launch
import java.lang.reflect.Array.get

class ActivitiesSlideViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    private val _slidesStatus = MutableLiveData<ActivitiesSlideViewModel.State>()
    private val _slidesList = MutableLiveData<List<ListSlide>?>()

    val slidesStatus: LiveData<ActivitiesSlideViewModel.State> = _slidesStatus
    val slidesList: LiveData<List<ListSlide>?> = _slidesList

    suspend fun getHomeSlides() {
        _slidesStatus.value = ActivitiesSlideViewModel.State.Loading()
        viewModelScope.launch {
            try {
                val homeSlides = homeRepository.getHomeSlides().listSlide
                _slidesStatus.value = ActivitiesSlideViewModel.State.Success()
                _slidesList.value = homeSlides
            } catch (e: Exception) {
                _slidesStatus.value = ActivitiesSlideViewModel.State.Failure(e)
            }
        }
    }

    sealed class State() {
        class Success() : State()
        class Failure(val cause: Throwable) : State()
        class Loading() : State()
    }
}