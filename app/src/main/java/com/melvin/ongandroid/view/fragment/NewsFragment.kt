package com.melvin.ongandroid.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.FragmentNewsBinding
import com.melvin.ongandroid.model.Novedades
import com.melvin.ongandroid.model.data.news.New
import com.melvin.ongandroid.view.adapters.NewsViewPagerAdapter
import com.melvin.ongandroid.viewmodel.HomeViewModel


class NewsFragment : Fragment(R.layout.fragment_news) {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

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
        val viewModel = HomeViewModel()

        binding.rvNews.setHasFixedSize(true)
        binding.rvNews.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)

        setNews(viewModel, binding)
    }


    private fun setNews(viewModel : HomeViewModel, binding: FragmentNewsBinding){
        val newsList = viewModel.newsList.value
        //Initialize slides adapter
        if (newsList != null)
            binding.rvNews.adapter = NewsViewPagerAdapter(newsList)
        // TODO: Remove after add api call
        binding.rvNews.adapter = NewsViewPagerAdapter(emptyList())
    }

}