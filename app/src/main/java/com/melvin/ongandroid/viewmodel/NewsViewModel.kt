package com.melvin.ongandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.ongandroid.businesslogic.repository.HomeRepository
import com.melvin.ongandroid.model.data.news.NewsList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: HomeRepository,
) : ViewModel() {

    init {
        //getNews()
    }

    //Internal MutableLiveData
    private val _newsList = MutableLiveData<State<NewsList>>()

    //External LiveData
    val newsList: LiveData<State<NewsList>> = _newsList


    fun getNews() {
        _newsList.postValue(State.Loading())
        viewModelScope.launch {
            val newsList = repository.getNews()
            if (newsList.data.isNullOrEmpty()) {
                throw ResourceNotFoundException()
            } else {
                _newsList.postValue(State.Success(newsList))
            }
        }
    }
}