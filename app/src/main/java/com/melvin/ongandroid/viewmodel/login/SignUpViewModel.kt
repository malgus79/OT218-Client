package com.melvin.ongandroid.viewmodel.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.melvin.ongandroid.businesslogic.repository.HomeRepository
import com.melvin.ongandroid.utils.validateFormatEmail
import com.melvin.ongandroid.utils.validateFormatName
import com.melvin.ongandroid.utils.validateFormatPassword
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {

    //Internal MutableLiveData
    private val _nameLiveData = MutableLiveData("")
    private val _emailLiveData = MutableLiveData("")
    private val _passwordLiveData = MutableLiveData("")
    private val _repeatPasswordLiveData = MutableLiveData("")

    var validName = false
    var validEmail = false
    var validPassword = false
    var passMatch = false


    // Internal MutableLiveData - Enable login button
    private val _signupButtonLiveData = MutableLiveData(false)

    // External MutableLiveData - Enable login button
    val signupButtonLiveData: LiveData<Boolean> = _signupButtonLiveData

    //Updates login button liveData
     fun setSignupButtonLiveData() {
        _signupButtonLiveData.postValue(validName && validEmail && validPassword && passMatch)
    }

    fun validateName(name: String) {
        if (name.validateFormatName()) {
            _nameLiveData.value = name
            validName = true
        } else {
            validName = false
        }

    }

    fun validateEmail(email: String) {
        if (email.validateFormatEmail()) {
            _emailLiveData.value = email
            validEmail = true
        } else {
            validEmail = false
        }

    }

    fun validatePassword(pass: String) {
        _passwordLiveData.value = pass
        validPassword = pass.validateFormatPassword()
        passMatch = (_passwordLiveData.value == _repeatPasswordLiveData.value)

    }

    fun validateRepeatPass(pass: String){
        _repeatPasswordLiveData.value = pass
        passMatch = (_passwordLiveData.value == _repeatPasswordLiveData.value)
    }




}