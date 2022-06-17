package com.melvin.ongandroid.viewmodel.login

import android.app.Activity
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
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
class LoginViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {


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
    private fun setLoginButtonLiveData() {
        _loginButtonLiveData.postValue(validEmail && validPassword)
    }

    //Attempts login with credentials received from fragment
    fun logIn(loginCredentials: LoginCredentials) {
        val request = repository.logIn(loginCredentials)
        viewModelScope.launch(Dispatchers.IO) {
            val response = request.execute()
            if (response.isSuccessful) {
                if (response.body()?.success == true) {
                    ONGAndroidApp.prefs.saveToken(response.body()!!.data.token) //Saves token on shared preferences
                } else {
                    //TODO IMPL ERROR WITH CODE 200
                }
            } else {
                //TODO IMPL ERROR WITH CODE != 200
            }
        }
    }

    fun validateEmail(email: String) {
        if (email.validateFormatEmail()) {
            _emailLiveData.value = email
            validEmail = true
        } else {
            validEmail = false
        }
        setLoginButtonLiveData()
    }

    fun validatePassword(pass: String) {
        if (pass.validateFormatPassword()) {
            _passwordLiveData.value = pass
            validPassword = true
        } else {
            validPassword = false
        }
        setLoginButtonLiveData()
    }

    fun singInGoogle(activity: Activity) {
        // Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(activity.getString(R.string.services_client_id))
            .requestEmail()
            .build()

        val client = GoogleSignIn.getClient(activity, gso)
        val signInIntent = client.signInIntent
        activity.startActivityForResult(signInIntent, 200)
    }

    fun endUpGoogleLogIn(accountTask: Task<GoogleSignInAccount>) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val account = accountTask.getResult(ApiException::class.java)
                account.idToken.let { token ->
                    val auth = FirebaseAuth.getInstance()
                    val credentials = GoogleAuthProvider.getCredential(token, null)
                    auth.signInWithCredential(credentials)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                val user = auth.currentUser
                                Log.d(TAG, "${user?.displayName}")

                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "signInWithCredential:failure", task.exception)
                            }
                        }
                }
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w(ContentValues.TAG, "Google sign in failed", e)
            }
        }
    }
}