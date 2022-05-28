package com.melvin.ongandroid.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.FragmentHomeBinding
import com.melvin.ongandroid.view.adapters.SlidesAdapter
<<<<<<< HEAD:app/src/main/java/com/melvin/ongandroid/view/HomeFragment.kt
import com.melvin.ongandroid.view.adapters.TestimonialsAdapter
=======
>>>>>>> e4be640 (update and refactor proyect):app/src/main/java/com/melvin/ongandroid/view/fragment/HomeFragment.kt
import com.melvin.ongandroid.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater)

<<<<<<< HEAD:app/src/main/java/com/melvin/ongandroid/view/HomeFragment.kt
        //Loads data and updates on changes
        viewModel.slidesList.observe(this, Observer {
            setSlides(viewModel, binding) //Load Slides
            setTestimonials(viewModel, binding) //Load testimonials
        })
=======
        setSlides(viewModel, binding) //Load activities
        setNews(viewModel, binding) //Load news
>>>>>>> e4be640 (update and refactor proyect):app/src/main/java/com/melvin/ongandroid/view/fragment/HomeFragment.kt

        return binding.root
    }

<<<<<<< HEAD:app/src/main/java/com/melvin/ongandroid/view/HomeFragment.kt
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        onDestroyNews()

=======
    override fun onDestroyView() {
        super.onDestroyView()
        onDestroyNews()
>>>>>>> e4be640 (update and refactor proyect):app/src/main/java/com/melvin/ongandroid/view/fragment/HomeFragment.kt
    }


    private fun setSlides(viewModel: HomeViewModel, binding: FragmentHomeBinding) {
        val slidesList = viewModel.slidesList.value

        if (slidesList == null || !slidesList.success) {
            //TODO ERROR IMPLEMENTATION
        } else {
            if (!slidesList.slide.isNullOrEmpty()) {
                binding.rvSlides.adapter = SlidesAdapter(slidesList.slide)
            } else {
                //TODO ERROR IMPLEMENTATION
            }
        }
        //Initialize slides adapter
        if (slidesList != null)
            binding.rvSlides.adapter = SlidesAdapter(slidesList)
    }

    private fun setNews(viewModel: HomeViewModel, binding: FragmentHomeBinding) {
        /* val newsList //Add news
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
             }
         )*/
    }

<<<<<<< HEAD:app/src/main/java/com/melvin/ongandroid/view/HomeFragment.kt
    private fun setTestimonials(viewModel: HomeViewModel, binding: FragmentHomeBinding) {
        val testimonialsList = viewModel.testimonialsList.value

        if (testimonialsList == null || !testimonialsList.success) {
            //TODO ERROR IMPLEMENTATION
        } else {
            if (!testimonialsList.testimonials.isNullOrEmpty()) {
                binding.rvTestimony.adapter = TestimonialsAdapter(testimonialsList.testimonials,true)
            } else {
                //TODO ERROR IMPLEMENTATION

            }
        }
    }

=======
>>>>>>> e4be640 (update and refactor proyect):app/src/main/java/com/melvin/ongandroid/view/fragment/HomeFragment.kt
    private fun onDestroyNews() {
        val viewpager = view?.findViewById<ViewPager2>(R.id.vp_news)
        //Unregistering the onPageChangedCallback
        viewpager?.unregisterOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {}
        )
    }




}