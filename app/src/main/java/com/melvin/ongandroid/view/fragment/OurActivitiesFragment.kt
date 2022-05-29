package com.melvin.ongandroid.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.FragmentNewsBinding
import com.melvin.ongandroid.databinding.FragmentOurActivitiesBinding
import com.melvin.ongandroid.view.adapters.ActivitiesAdapter
import com.melvin.ongandroid.view.adapters.NewsViewPagerAdapter
import com.melvin.ongandroid.viewmodel.HomeViewModel

class OurActivitiesFragment : Fragment() {

    private var _binding: FragmentOurActivitiesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOurActivitiesBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init() {
        val viewModel = HomeViewModel()

        binding.rcActivities.setHasFixedSize(true)
        binding.rcActivities.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)

        setActivities(viewModel, binding)
    }

    private fun setActivities(viewModel: HomeViewModel, binding: FragmentOurActivitiesBinding) {
//        val newsList = viewModel.newsList.value
//        //Initialize slides adapter
//        if (newsList != null)
//            binding.rcActivities.adapter = NewsViewPagerAdapter(newsList)
        // TODO: Remove after add api call
        binding.rcActivities.adapter = ActivitiesAdapter(emptyList())
    }
}