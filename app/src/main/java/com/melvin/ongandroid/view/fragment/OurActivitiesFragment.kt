package com.melvin.ongandroid.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.melvin.ongandroid.databinding.FragmentOurActivitiesBinding
import com.melvin.ongandroid.view.adapters.ActivitiesAdapter
import com.melvin.ongandroid.viewmodel.ActivitiesViewModel
import com.melvin.ongandroid.viewmodel.HomeViewModel
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

        //Loads data and updates on changes
        viewModel.activitiesList.observe(this, Observer {
            setActivities(viewModel,binding)
        })
        return binding.root
    }

    private fun init() {
        binding.rcActivities.setHasFixedSize(true)


    }

    private fun setActivities(viewModel: ActivitiesViewModel, binding: FragmentOurActivitiesBinding) {
        val activitiesList = viewModel.activitiesList.value

        if (activitiesList == null || !activitiesList.success){
            //TODO ERROR IMPLEMENTATION
        } else{
            if (!activitiesList.data.isNullOrEmpty()){
                binding.rcActivities.adapter = ActivitiesAdapter(activitiesList.data)
            } else{
                //TODO ERROR IMPLEMENTATION
            }
        }



    }
}