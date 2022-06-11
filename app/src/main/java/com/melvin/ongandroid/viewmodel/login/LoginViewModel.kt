package com.melvin.ongandroid.viewmodel.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.melvin.ongandroid.businesslogic.repository.HomeRepository
import com.melvin.ongandroid.utils.validateFormatEmail
import com.melvin.ongandroid.utils.validateFormatPassword
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: HomeRepository): ViewModel(){


    //Internal MutableLiveData
    private val _emailLiveData = MutableLiveData("")
    private val _passwordLiveData = MutableLiveData("")

     var validEmail = false
     var validPassword = false


    // Internal MutableLiveData - Enable login button
    private val _loginButtonLiveData = MutableLiveData(false)

    // External MutableLiveData - Enable login button
    val loginButtonLiveData: LiveData<Boolean> = _loginButtonLiveData

    //setter for MutableLiveData
    fun setEmailData(data: String){
        _emailLiveData.postValue(data)
    }

    //setter for MutableLiveData
    fun setPasswordData(data: String){
        _passwordLiveData.postValue(data)
    }

    //Updates login button liveData
    fun setLoginButtonLiveData(){
        _loginButtonLiveData.postValue(validEmail && validPassword)
    }
}