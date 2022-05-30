package com.melvin.ongandroid.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
<<<<<<< HEAD
<<<<<<< HEAD
=======
import androidx.fragment.app.activityViewModels
>>>>>>> 5e4589c (Testimony fragment added)
=======
>>>>>>> fa6b629 (spinner)
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.melvin.ongandroid.databinding.FragmentTestimonyBinding
import com.melvin.ongandroid.model.data.testimonials.TestimonialsList
import com.melvin.ongandroid.viewmodel.TestimonyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TestimonyFragment : Fragment() {

    private lateinit var binding: FragmentTestimonyBinding
    private val viewmodel: TestimonyViewModel by viewModels<TestimonyViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
<<<<<<< HEAD
<<<<<<< HEAD
    ): View {
=======
    ): View? {
>>>>>>> 5e4589c (Testimony fragment added)
=======
    ): View {
>>>>>>> fa6b629 (spinner)
        // Inflate the layout for this fragment
        binding = FragmentTestimonyBinding.inflate(layoutInflater, container, false)
        return binding.root

        viewmodel.state.observe(viewLifecycleOwner, Observer {
<<<<<<< HEAD
<<<<<<< HEAD
            when (it) {
=======
            when (it){
>>>>>>> 5e4589c (Testimony fragment added)
=======
            when (it) {
>>>>>>> fa6b629 (spinner)
                is TestimonyViewModel.State.Success -> showTestimony(it.testimonialsList)
                is TestimonyViewModel.State.Failure -> showErrorDialog()
                is TestimonyViewModel.State.Loading -> showSpinnerLoading()
            }
        })
    }

    private fun showSpinnerLoading() {
<<<<<<< HEAD
<<<<<<< HEAD
        binding.progressBar1.isVisible = true
=======
     binding.progressBar1.isVisible = true
>>>>>>> 5e4589c (Testimony fragment added)
=======
        binding.progressBar1.isVisible = true
>>>>>>> fa6b629 (spinner)
    }

    private fun showTestimony(testimonialsList: TestimonialsList) {
        binding.rvTestimony.adapter

<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> 5e4589c (Testimony fragment added)
=======
>>>>>>> fa6b629 (spinner)
    }

    //llamar al metodo showErrorDialog dentro del recyclerview
    private fun showErrorDialog() {
        binding.progressBar1.isVisible = false
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Error")
            .setMessage("Ha ocurrido un error obteniendo la información")
            .setPositiveButton("Reintentar") { dialogInterface, i -> }
            .show()
    }
}
