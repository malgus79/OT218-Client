package com.melvin.ongandroid.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.melvin.ongandroid.databinding.FragmentOurActivitiesBinding
import com.melvin.ongandroid.model.data.activities.ActivitiesList
import com.melvin.ongandroid.model.data.testimonials.TestimonialsList
import com.melvin.ongandroid.view.adapters.ActivitiesAdapter
import com.melvin.ongandroid.view.adapters.TestimonialsAdapter
import com.melvin.ongandroid.viewmodel.ActivitiesViewModel
import com.melvin.ongandroid.viewmodel.State
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OurActivitiesFragment : Fragment() {

    private val viewModel by viewModels<ActivitiesViewModel>()
    private lateinit var binding: FragmentOurActivitiesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOurActivitiesBinding.inflate(inflater, container, false)
        init()

        // Load and manage Nes data
        viewModel.getActivities()
        viewModel.activitiesList.observe(viewLifecycleOwner, Observer {
            when (it) {
                is State.Success -> setActivities(it.data)
                is State.Failure -> showErrorDialog(callback = { viewModel.getActivities() })
                is State.Loading -> showSpinnerLoading(true)
            }
        })
        return binding.root
    }

    private fun init() {
        binding.rcActivities.setHasFixedSize(true)
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

    private fun setActivities(activitiesList: ActivitiesList) {

            if (!activitiesList.data.isNullOrEmpty()){
                showSpinnerLoading(false)
                binding.rcActivities.adapter = ActivitiesAdapter(activitiesList.data)
            } else{
                //TODO ERROR IMPLEMENTATION
            }
        }

    // show progress spinner
    private fun showSpinnerLoading(loading: Boolean) {
        binding.progressBar3.isVisible = loading
    }
}


