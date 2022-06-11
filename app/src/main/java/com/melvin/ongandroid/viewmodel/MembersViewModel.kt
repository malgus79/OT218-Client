package com.melvin.ongandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.ongandroid.businesslogic.repository.HomeRepository
import com.melvin.ongandroid.model.data.MembersList
import com.melvin.ongandroid.model.network.ApiStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MembersViewModel @Inject constructor(
    private val repository: HomeRepository
): ViewModel()
{
    //Internal MutableLiveData
    private val _membersList = MutableLiveData<State<MembersList>>()


    //External LiveData
    val membersList: LiveData<State<MembersList>> = _membersList


    //Downloads data from api
    fun getMembers() {
        _membersList.postValue(State.Loading())
        viewModelScope.launch {
            try {
                val membersList = repository.getMembers()
                if (membersList.data.isNullOrEmpty()) {
                    _membersList.postValue((State.Failure(ResourceNotFoundException())))
                } else {
                    _membersList.postValue(State.Success(membersList))
                }
            } catch (e: Exception){
                _membersList.postValue(State.Failure(e))
            }

        }
    }
}