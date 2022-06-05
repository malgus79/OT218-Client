package com.melvin.ongandroid.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.FragmentHomeBinding
import com.melvin.ongandroid.model.data.news.NewsList
import com.melvin.ongandroid.model.data.slides.SlidesList
import com.melvin.ongandroid.model.data.testimonials.TestimonialsList
import com.melvin.ongandroid.view.adapters.NewsViewPagerAdapter
import com.melvin.ongandroid.view.adapters.SlidesAdapter
import com.melvin.ongandroid.view.adapters.TestimonialsAdapter
import com.melvin.ongandroid.viewmodel.HomeViewModel
import com.melvin.ongandroid.viewmodel.State
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<HomeViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        // Load and manage Slides data
        viewModel.getSlides()
        viewModel.slidesList.observe(viewLifecycleOwner, Observer {
            when (it) {
                is State.Success -> setSlides(it.data)
                is State.Failure -> showErrorDialog(callback = { viewModel.getSlides() })
                is State.Loading -> showSpinnerLoading(true)
            }
        })
        // Load and manage Testimonials data
        viewModel.getTestimonials()
        viewModel.testimonialsList.observe(viewLifecycleOwner, Observer {
            when (it) {
                is State.Success -> setTestimonials(it.data)
                is State.Failure -> showErrorDialog(callback = { viewModel.getTestimonials() })
                is State.Loading -> showSpinnerLoading(true)
            }
        })
        // Load and manage Nes data
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

    override fun onDestroyView() {
        super.onDestroyView()
        onDestroyNews()
    }

    private fun setSlides(slidesList: SlidesList) {
        if (!slidesList.slide.isNullOrEmpty()) {
            showSpinnerLoading(false)
            binding.rvSlides.adapter = SlidesAdapter(slidesList.slide)
        } else {
            //TODO ERROR IMPLEMENTATION
        }
    }

    private fun setNews(newsList: NewsList) {
        if (!newsList.data.isNullOrEmpty()) {
            showSpinnerLoading(false)
            //Initialize news adapter
            binding.vpNews.adapter = NewsViewPagerAdapter(newsList.data)
            //Set starting page for news viewpager
            val currentPageIndex = 0
            binding.vpNews.currentItem = currentPageIndex
            //Registering for page change callback
            binding.vpNews.registerOnPageChangeCallback(
                object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                    }
                }
            )
        } else {
            //TODO ERROR IMPLEMENTATION
        }
    }

    private fun setTestimonials(testimonialsList: TestimonialsList) {
        if (!testimonialsList.testimonials.isNullOrEmpty()) {
            showSpinnerLoading(false)
            binding.rvTestimony.adapter = TestimonialsAdapter(testimonialsList.testimonials, true)
        } else {
            //TODO ERROR IMPLEMENTATION
        }
    }

    private fun onDestroyNews() {
        val viewpager = view?.findViewById<ViewPager2>(R.id.vp_news)
        //Unregistering the onPageChangedCallback
        viewpager?.unregisterOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {}
        )
    }

}