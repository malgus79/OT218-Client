package com.melvin.ongandroid.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
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
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentTestimonyBinding.inflate(layoutInflater, container, false)
        return binding.root

        viewmodel.state.observe(viewLifecycleOwner, Observer {
            when (it) {
                is TestimonyViewModel.State.Success -> showTestimony(it.testimonialsList)
                is TestimonyViewModel.State.Failure -> showErrorDialog()
                is TestimonyViewModel.State.Loading -> showSpinnerLoading()
            }
        })
    }

    private fun showSpinnerLoading() {
        binding.progressBar1.isVisible = true
    }

    private fun showTestimony(testimonialsList: TestimonialsList) {
        binding.rvTestimony.adapter

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
