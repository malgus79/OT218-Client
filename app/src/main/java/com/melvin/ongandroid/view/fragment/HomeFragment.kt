package com.melvin.ongandroid.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
<<<<<<< HEAD
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
=======
import androidx.fragment.app.viewModels
>>>>>>> 5e4589c (Testimony fragment added)
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.FragmentHomeBinding
import com.melvin.ongandroid.view.adapters.NewsViewPagerAdapter
import com.melvin.ongandroid.view.adapters.SlidesAdapter
<<<<<<< HEAD
import com.melvin.ongandroid.view.adapters.TestimonialsAdapter
=======
import com.melvin.ongandroid.view.adapters.TestimonyAdapter
>>>>>>> 5e4589c (Testimony fragment added)
import com.melvin.ongandroid.viewmodel.HomeViewModel
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
<<<<<<< HEAD:app/src/main/java/com/melvin/ongandroid/view/fragment/HomeFragment.kt
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
=======
        val binding = FragmentHomeBinding.inflate(inflater)
<<<<<<< HEAD
>>>>>>> dd3c420 (Testimony fragment added):app/src/main/java/com/melvin/ongandroid/view/HomeFragment.kt

        //Loads data and updates on changes
        viewModel.slidesList.observe(this, Observer {
            setSlides(viewModel, binding) //Load Slides
            setTestimonials(viewModel, binding) //Load testimonials
            setNews(viewModel, binding) //Load news
        })
<<<<<<< HEAD:app/src/main/java/com/melvin/ongandroid/view/fragment/HomeFragment.kt
        return binding.root
    }

=======
=======


        setSlides(viewModel, binding) //Load activities
        setNews(viewModel,binding) //Load news
        setTestimony(viewModel, binding) //Load testimony
>>>>>>> 5e4589c (Testimony fragment added)

        return binding.root
    }

<<<<<<< HEAD
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
=======


    override fun onDestroyView() {
>>>>>>> 5e4589c (Testimony fragment added)

    }

>>>>>>> dd3c420 (Testimony fragment added):app/src/main/java/com/melvin/ongandroid/view/HomeFragment.kt
    override fun onDestroyView() {
        super.onDestroyView()
        onDestroyNews()
    }


    private fun setSlides(viewModel: HomeViewModel, binding: FragmentHomeBinding) {
        val slidesList = viewModel.slidesList.value

<<<<<<< HEAD
        if (slidesList == null || !slidesList.success) {
            //TODO ERROR IMPLEMENTATION
        } else {
            if (!slidesList.slide.isNullOrEmpty()) {
                binding.rvSlides.adapter = SlidesAdapter(slidesList.slide)
            } else {
                //TODO ERROR IMPLEMENTATION
=======
    private fun setNews(viewModel: HomeViewModel, binding: FragmentHomeBinding){
/*        val newsList //Add news
        //Initialize news adapter
        binding.vpNews.adapter = NewsViewPagerAdapter()

        //Set starting page for news viewpager
        val currentPageIndex = 0
        binding.vpNews.currentItem = currentPageIndex

        //Registering for page change callback
        binding.vpNews.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
>>>>>>> 5e4589c (Testimony fragment added)
            }
        }
    }

<<<<<<< HEAD
    private fun setNews(viewModel: HomeViewModel, binding: FragmentHomeBinding) {
        val newsList = viewModel.newsList.value

        if (newsList == null || !newsList.success) {
            //TODO ERROR IMPLEMENTATION
        } else {
            if (!newsList.data.isNullOrEmpty()) {
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
    }

    private fun setTestimonials(viewModel: HomeViewModel, binding: FragmentHomeBinding) {
        val testimonialsList = viewModel.testimonialsList.value

        if (testimonialsList == null || !testimonialsList.success) {
            //TODO ERROR IMPLEMENTATION
        } else {
            if (!testimonialsList.testimonials.isNullOrEmpty()) {
                binding.rvTestimony.adapter =
                    TestimonialsAdapter(testimonialsList.testimonials, true)
            } else {
                //TODO ERROR IMPLEMENTATION

            }
        }
    }

    private fun onDestroyNews() {
=======
    private fun setTestimony(viewModel: HomeViewModel, binding: FragmentHomeBinding) {
        val testimonyList = viewModel.testimonialsList.value
        //Initialize testimony adapter
        if (testimonyList != null)
            binding.rvTestimony.adapter = TestimonyAdapter(testimonyList)

    }

    private fun onDestroyNews(){
>>>>>>> 5e4589c (Testimony fragment added)
        val viewpager = view?.findViewById<ViewPager2>(R.id.vp_news)
        //Unregistering the onPageChangedCallback
        viewpager?.unregisterOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {}
        )
    }

}