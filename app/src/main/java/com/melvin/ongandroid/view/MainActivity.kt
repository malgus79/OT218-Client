package com.melvin.ongandroid.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.melvin.ongandroid.databinding.ActivityMainBinding
import com.melvin.ongandroid.databinding.ActivityNavigationBinding
import com.melvin.ongandroid.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

<<<<<<< HEAD
    private lateinit var binding: ActivityNavigationBinding
=======
    private lateinit var binding: ActivityMainBinding
//    private lateinit var mainActivityViewModel: MainActivityViewModel
>>>>>>> ee97f54ad755c3795943cd7fc03e4f3485834fc8
    private val viewModel by viewModels<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Show Spinner Loading
        viewModel.isShowProgress()
<<<<<<< HEAD



=======
>>>>>>> ee97f54ad755c3795943cd7fc03e4f3485834fc8
    }
}