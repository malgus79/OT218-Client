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
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class ActivitiesViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {


    //Internal MutableLiveData
    private val _activitiesList = MutableLiveData<State<ActivitiesList>>()

    //External LiveData
    val activitiesList: LiveData<State<ActivitiesList>> = _activitiesList


    fun getActivities() {
        _activitiesList.postValue(State.Loading())
        viewModelScope.launch {
            try {
                val activitiesList = repository.getActivities()
                if (activitiesList.data.isNullOrEmpty()) {
                    _activitiesList.postValue(State.Failure(ResourceNotFoundException()))
                } else {
                    _activitiesList.postValue(State.Success(activitiesList))
                }
            } catch (e: Exception){
                _activitiesList.postValue(State.Failure(e))
            }

        }
    }
}