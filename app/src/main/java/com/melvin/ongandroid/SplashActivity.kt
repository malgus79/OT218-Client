package com.melvin.ongandroid

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import com.melvin.ongandroid.databinding.ActivitySplashActivityBinding
import com.melvin.ongandroid.model.ONGAndroidApp
import com.melvin.ongandroid.view.LoginActivity
import com.melvin.ongandroid.view.MainActivity
import kotlinx.coroutines.*
import java.lang.StrictMath.log

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashActivityBinding

    val activityScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* This is used to hide the status bar and make
         the splash screen as a full screen activity.*/
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        // Add animations
        val bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo)
        binding.somosMasSplash.startAnimation(bottomAnimation)

        val headAnimation = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba)
        binding.SplashScreenImage.startAnimation(headAnimation)

        activityScope.launch {
            delay(5000)
            Toast.makeText(applicationContext, "Timer has finished", Toast.LENGTH_SHORT).show()
            val token = ONGAndroidApp.prefs.getToken()
            Log.i("SplashScreen", token)

            if (token.isNotEmpty()) {
                startActivity(Intent(applicationContext, MainActivity::class.java))
            } else startActivity(Intent(applicationContext, LoginActivity::class.java))

            finish()
        }
    }
    override fun onPause() {
        activityScope.cancel()
        super.onPause()
    }
}

