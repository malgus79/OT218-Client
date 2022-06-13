package com.melvin.ongandroid.model

import android.app.Application
import com.melvin.ongandroid.view.login.Prefs
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ONGAndroidApp : Application(){

    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }

    companion object{
        lateinit var prefs: Prefs
    }
}