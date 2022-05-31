package com.melvin.ongandroid.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.FragmentNewsBinding
import com.melvin.ongandroid.view.adapters.NewsViewPagerAdapter
import com.melvin.ongandroid.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init() {
        binding.rvNews.setHasFixedSize(true)
        binding.rvNews.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        setNews(viewModel, binding)
    }

    private fun setNews(viewModel : HomeViewModel, binding: FragmentNewsBinding){
        val newsList = viewModel.newsList.value
        //Initialize slides adapter
        if (newsList != null)
            binding.rvNews.adapter = NewsViewPagerAdapter(newsList.data)
        // TODO: Remove after add api call
        binding.rvNews.adapter = NewsViewPagerAdapter(emptyList())
    }

}