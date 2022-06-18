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
import com.melvin.ongandroid.databinding.ActivitySplashActivityBinding
import com.melvin.ongandroid.model.ONGAndroidApp
import com.melvin.ongandroid.view.LoginActivity
import com.melvin.ongandroid.view.MainActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Agregar animaciones

        val bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo)
        binding.somosMasSplash.startAnimation(bottomAnimation)

        val headAnimation = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba)
        binding.SplashScreenImage.startAnimation(headAnimation)

        // This is used to hide the status bar and make
        // the splash screen as a full screen activity.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        //val backgroundImage = findViewById<ImageView>(R.id.SplashScreenImage)
//        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.side_slide)
//        binding.SplashScreenImage.startAnimation(slideAnimation)


//        Thread.sleep(5000)


        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        Handler().postDelayed({
            val token = ONGAndroidApp.prefs.getToken()
            Log.i("SplashScreen", token)

            if (token.isNotEmpty()) {
                startActivity(Intent(this, MainActivity::class.java))
            } else startActivity(Intent(this, LoginActivity::class.java))

            finish()
        }, 3000) // 3000 is the delayed time in milliseconds.

    }
}