package com.melvin.ongandroid.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.melvin.ongandroid.databinding.FragmentActivitiesSlideBinding
import com.melvin.ongandroid.databinding.FragmentNewsBinding
import com.melvin.ongandroid.model.data.HomeSlides
import com.melvin.ongandroid.viewmodel.MainActivityViewModel

//import com.melvin.ongandroid.model.Datasource

class ActivitiesSlideFragment : Fragment() {

    // val myDataSet = Datasource().loadActivities() //TODO change this dataset to load api data
    private var _binding: FragmentActivitiesSlideBinding? = null
    private val binding get() = _binding!!

    private val mainActivityViewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentActivitiesSlideBinding.inflate(inflater)
        return binding.root
    }


}