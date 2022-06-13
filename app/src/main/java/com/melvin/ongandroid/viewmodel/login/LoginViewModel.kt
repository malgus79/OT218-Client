package com.melvin.ongandroid.viewmodel.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.ongandroid.R
import com.melvin.ongandroid.businesslogic.repository.HomeRepository
import com.melvin.ongandroid.model.ONGAndroidApp
import com.melvin.ongandroid.model.data.LoginCredentials
import com.melvin.ongandroid.model.data.LoginResponse
import com.melvin.ongandroid.utils.validateFormatEmail
import com.melvin.ongandroid.utils.validateFormatPassword
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
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

    //Updates login button liveData
    private fun setLoginButtonLiveData(){
        _loginButtonLiveData.postValue(validEmail && validPassword)
    }

    //Attempts login with credentials received from fragment
    fun logIn (loginCredentials: LoginCredentials)  {
     val request = repository.logIn(loginCredentials)
        viewModelScope.launch(Dispatchers.IO) {
            val response = request.execute()
            if (response.isSuccessful){
                if (response.body()?.success == true){
                    ONGAndroidApp.prefs.saveToken(response.body()!!.data.token) //Saves token on shared preferences
                }else{
                    //TODO IMPL ERROR WITH CODE 200
                }
            }else{
                //TODO IMPL ERROR WITH CODE != 200
            }
        }
    }

    fun validateEmail(email: String){
        if (email.validateFormatEmail()){
            _emailLiveData.value = email
            validEmail = true
        } else{
            validEmail = false
        }
        setLoginButtonLiveData()
    }

    fun validatePassword(pass: String){
        if (pass.validateFormatPassword()) {
            _passwordLiveData.value = pass
            validPassword = true
        } else {
            validPassword = false
        }
        setLoginButtonLiveData()
    }
}