package com.melvin.ongandroid.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.FragmentOurActivitiesBinding
import com.melvin.ongandroid.view.adapters.ActivitiesAdapter
import com.melvin.ongandroid.viewmodel.ActivitiesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OurActivitiesFragment : Fragment() {

    private val viewModel by viewModels<ActivitiesViewModel>()
    private lateinit var binding: FragmentOurActivitiesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentOurActivitiesBinding.inflate(inflater, container, false)
        init()

        //Loads data and updates on changes
        viewModel.activitiesList.observe(viewLifecycleOwner, Observer {
            setActivities(viewModel, binding)
        })
        return binding.root

    }

    //Start recyclerView
    private fun init() {
        binding.rcActivities.setHasFixedSize(true)

    }

    private fun setActivities(
        viewModel: ActivitiesViewModel,
        binding: FragmentOurActivitiesBinding,
    ) {
        val activitiesList = viewModel.activitiesList.value

        // Display an error message when an error occurs
        if (activitiesList == null || !activitiesList.success) {
            showErrorDialog()
        } else {
            // Display data when available
            if (!activitiesList.data.isNullOrEmpty()) {
                binding.rcActivities.adapter = ActivitiesAdapter(activitiesList.data)
            } else {
                //TODO ERROR IMPLEMENTATION
            }
        }

    }

    //show error message and try again
    private fun showErrorDialog(
        callback: (() -> Unit)? = null,
    ) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.error_dialog))
            .setMessage(getString(R.string.error_dialog_detail))
            .setPositiveButton(getString(R.string.try_again)) { _, _ -> callback?.invoke() }
            .show()
    }
}


