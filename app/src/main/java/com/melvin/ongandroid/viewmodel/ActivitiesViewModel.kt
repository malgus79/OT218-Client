package com.melvin.ongandroid.viewmodel

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
        getActivities()
    }

    //Internal MutableLiveData
    private val _activitiesList = MutableLiveData<ActivitiesList>()

    //External LiveData
    val activitiesList: LiveData<ActivitiesList> = _activitiesList


    fun getActivities() {
        var activities: ActivitiesList
        viewModelScope.launch {
            try {
                activities = repository.getActivites()
                _activitiesList.value = activities

            } catch (e: Exception) {
                activities = ActivitiesList(false, emptyList(), "Error retrieving activities")
                _activitiesList.value = activities

            }
        }
    }
}