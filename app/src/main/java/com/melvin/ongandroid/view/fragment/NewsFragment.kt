package com.melvin.ongandroid.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.FragmentNewsBinding
import com.melvin.ongandroid.model.data.news.NewsList
import com.melvin.ongandroid.view.adapters.NewsViewPagerAdapter
import com.melvin.ongandroid.viewmodel.NewsViewModel
import com.melvin.ongandroid.viewmodel.State
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<NewsViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        init()

        // Load and manage News data
        viewModel.getNews()
        viewModel.newsList.observe(viewLifecycleOwner, Observer {
            when (it) {
                is State.Success -> setNews(it.data)
                is State.Failure -> showErrorDialog(callback = { viewModel.getNews() })
                is State.Loading -> showSpinnerLoading(true)
            }
        })
        return binding.root
    }

    //Start recyclerView
    private fun init() {
        binding.rvNews.setHasFixedSize(true)
    }

    // show error message and try again
    private fun showErrorDialog(
        callback: (() -> Unit)? = null,
    ) {
        binding.progressBar1.isVisible = false
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.error_dialog))
            .setMessage(getString(R.string.error_dialog_detail))
            .setPositiveButton(getString(R.string.try_again)) { _, _ -> callback?.invoke() }
            .show()
    }

    private fun setNews(newsList: NewsList) {
        if (!newsList.data.isNullOrEmpty()) {
            showSpinnerLoading(false)
            binding.rvNews.adapter = NewsViewPagerAdapter(newsList.data)
        } else {
            //TODO ERROR IMPLEMENTATION
        }
    }

    // show progress spinner
    private fun showSpinnerLoading(loading: Boolean) {
        binding.progressBar1.isVisible = loading
    }
}