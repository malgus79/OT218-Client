package com.melvin.ongandroid.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.melvin.ongandroid.databinding.ActivityMainBinding
import com.melvin.ongandroid.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
<<<<<<< HEAD
<<<<<<< HEAD
    private val viewModel by viewModels<MainActivityViewModel>()
=======
    private lateinit var mainActivityViewModel: MainActivityViewModel
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
=======
    private val viewModel by viewModels<MainActivityViewModel>()
>>>>>>> 827da8a (Testimonials layout created)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Show Spinner Loading
<<<<<<< HEAD
<<<<<<< HEAD
        viewModel.isShowProgress()
=======
        mainActivityViewModel.isShowProgress()
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
=======
        viewModel.isShowProgress()
>>>>>>> 827da8a (Testimonials layout created)

        binding.button.setOnClickListener {
            startActivity(Intent(this, NavigationActivity::class.java))
        }

    }
}