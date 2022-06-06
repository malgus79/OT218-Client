package com.melvin.ongandroid.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
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
            when (it){
                is TestimonyViewModel.State.Success -> showTestimony(it.testimonialsList)
                is TestimonyViewModel.State.Failure -> showErrorDialog(callback = {viewmodel.getTestimonials()})
                is TestimonyViewModel.State.Loading -> showSpinnerLoading(true)
            }
        })
    }

    // show recyclerView of testimonials
    private fun showTestimony(testimonialsList: TestimonialsList) {

    }

    // show error message and try again
    private fun showErrorDialog(
        callback: (() -> Unit)? = null
    ) {
        binding.progressBar1.isVisible = false
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Error")
            .setMessage("Ha ocurrido un error obteniendo la información")
            .setPositiveButton("Reintentar") { _, _ -> callback?.invoke() }
            .show()
    }

    // show progress spinner
    private fun showSpinnerLoading(loading: Boolean) {
        binding.progressBar1.isVisible = loading

    }
}
