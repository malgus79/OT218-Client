package com.melvin.ongandroid.viewmodel

import android.app.PendingIntent.getActivities
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.ongandroid.businesslogic.repository.HomeRepository
import com.melvin.ongandroid.model.data.activities.ActivitiesList
import com.melvin.ongandroid.model.data.slides.SlidesList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActivitiesViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    init {
        //getActivities()
    }

    //Internal MutableLiveData
    private val _activitiesList = MutableLiveData<State<ActivitiesList>>()

    //External LiveData
    val activitiesList: LiveData<State<ActivitiesList>> = _activitiesList


    fun getActivities() {
        _activitiesList.postValue(State.Loading())
        viewModelScope.launch {
            val activitiesList = repository.getActivities()
            if (activitiesList.data.isNullOrEmpty()) {
                throw ResourceNotFoundException()
            } else {
                _activitiesList.postValue(State.Success(activitiesList))
            }
        }
    }
}