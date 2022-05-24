package com.melvin.ongandroid.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.melvin.ongandroid.databinding.FragmentActivitiesSlideBinding
import com.melvin.ongandroid.model.Datasource

class ActivitiesSlideFragment : Fragment() {

val myDataSet = Datasource().loadActivities() //TODO change this dataset to load api data
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentActivitiesSlideBinding.inflate(inflater)
        binding.rvActivities.adapter = ActivitiesSlideAdapter(myDataSet)
        return binding.root
    }



}