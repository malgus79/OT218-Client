package com.melvin.ongandroid.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.ActivityLoginBinding
import com.melvin.ongandroid.viewmodel.login.LoginViewModel
import com.melvin.ongandroid.model.ONGAndroidApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var navController: NavController
    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
//        setTheme(R.style.Theme_ONGAndroid)


        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragmentLogin =
            supportFragmentManager.findFragmentById(R.id.fragment_container_log_in) as NavHostFragment
        navController = navHostFragmentLogin.findNavController()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 200) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            viewModel.endUpGoogleLogIn(task)
        }
    }
}