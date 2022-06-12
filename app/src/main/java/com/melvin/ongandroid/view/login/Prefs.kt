package com.melvin.ongandroid.view.login

import android.content.Context
import android.content.SharedPreferences

class Prefs(val context: Context) {
    val SHARED_NAME = "MyPrefs"
    val SHARED_TOKEN = "UserToken"

    private val myPrefs: SharedPreferences = context.getSharedPreferences(SHARED_NAME,0)

    fun saveToken(token: String){
        myPrefs.edit().putString(SHARED_TOKEN, token).apply()
    }

    fun getToken(): String{
       return myPrefs.getString(SHARED_TOKEN,"")!!
    }
}