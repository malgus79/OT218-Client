package com.melvin.ongandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.ongandroid.businesslogic.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val homeRepository: HomeRepository) :
    ViewModel() {

//    //Create Spinner Loading
//    private val _showProgress: MutableLiveData<State> = MutableLiveData()
//    val showProgress: LiveData<State>
//        get() = _state
//
//    //Create progressBar
//    fun isShowProgress(): LiveData<State> {
//        return showProgress
//    }

}