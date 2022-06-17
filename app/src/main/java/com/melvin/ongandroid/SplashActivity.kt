package com.melvin.ongandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.melvin.ongandroid.model.ONGAndroidApp
import com.melvin.ongandroid.view.LoginActivity
import com.melvin.ongandroid.view.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(5000)
        val token = ONGAndroidApp.prefs.getToken()
        Log.i("SplashScreen", token)

        if (token.isNotEmpty()) {
            startActivity(Intent(this, MainActivity::class.java))
        } else startActivity(Intent(this, LoginActivity::class.java))

        super.onCreate(savedInstanceState)
    }
}