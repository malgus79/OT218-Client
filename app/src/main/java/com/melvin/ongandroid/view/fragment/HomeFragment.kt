package com.melvin.ongandroid.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.dialog.MaterialDialogs
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.ktx.Firebase
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.FragmentHomeBinding
import com.melvin.ongandroid.model.data.news.NewsList
import com.melvin.ongandroid.model.data.slides.SlidesList
import com.melvin.ongandroid.model.network.ApiStatus
import com.melvin.ongandroid.model.data.testimonials.TestimonialsList
import com.melvin.ongandroid.view.adapters.NewsViewPagerAdapter
import com.melvin.ongandroid.view.adapters.SlidesAdapter
import com.melvin.ongandroid.view.adapters.TestimonialsAdapter
import com.melvin.ongandroid.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var analytics: FirebaseAnalytics

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        analytics = FirebaseAnalytics.getInstance(binding.root.context)

        viewModel.getSlides()
        viewModel.getTestimonials()
        viewModel.getNews()

        setupStatusLiveDataMerger(viewModel)

        viewModel.homeStatusLiveDataMerger.observe(viewLifecycleOwner, Observer {
            when (it) {
                ApiStatus.LOADING -> {
                    homeIsLoading(true, binding)
                }
                ApiStatus.DONE -> {
                    homeIsLoading(false, binding)
                }
                ApiStatus.ERROR -> {
                    binding.progressBar1.visibility = View.GONE
                    showErrorDialog(viewModel)
                }
            }
        })

        viewModel.slidesList.observe(viewLifecycleOwner, Observer {
            setSlides(viewModel, binding) //Load slides
        })

        viewModel.testimonialsList.observe(viewLifecycleOwner, Observer {
            setTestimonials(viewModel, binding) //Load testimonials
        })

        viewModel.newsList.observe(viewLifecycleOwner, Observer {
            setNews(viewModel, binding)
        })

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        onDestroyNews()
        undoStatusLiveDataMerger(viewModel)
    }

    private fun setSlides(viewModel: HomeViewModel, binding: FragmentHomeBinding) {
        //Success Analytics Event
        val bundle = Bundle()
        bundle.putString("message", "slider_retrieve_success")
        analytics.logEvent("Slider", bundle)

        val slidesList = viewModel.slidesList.value
        if (slidesList != null && slidesList.success && !slidesList.slide.isNullOrEmpty()) {
            binding.rvSlides.adapter = SlidesAdapter(slidesList.slide)
        }
    }

    private fun setNews(viewModel: HomeViewModel, binding: FragmentHomeBinding) {
        //Success Analytics Event
        val bundle = Bundle()
        bundle.putString("message", "last_news_retrieve_success")
        analytics.logEvent("News", bundle)

        val newsList = viewModel.newsList.value
        if (newsList != null && newsList.success && !newsList.data.isNullOrEmpty()) {
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
        }
    }

    private fun setTestimonials(viewModel: HomeViewModel, binding: FragmentHomeBinding) {
        //Success Analytics Event
        val bundle = Bundle()
        bundle.putString("message", "testimonios_retrieve_success")
        analytics.logEvent("Testimonials", bundle)

        val testimonialsList = viewModel.testimonialsList.value
        if (testimonialsList != null && testimonialsList.success && !testimonialsList.testimonials.isNullOrEmpty()) {
            binding.rvTestimony.adapter =
                TestimonialsAdapter(testimonialsList.testimonials, true)
        }
    }

    private fun onDestroyNews() {
        val viewpager = view?.findViewById<ViewPager2>(R.id.vp_news)
        //Unregistering the onPageChangedCallback
        viewpager?.unregisterOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {}
        )
    }

    private fun setupStatusLiveDataMerger(viewModel: HomeViewModel) {
        viewModel.homeStatusLiveDataMerger.addSource(viewModel.slidesStatus, Observer {
            viewModel.homeStatusLiveDataMerger.value = viewModel.combineHomeStatusData(
                viewModel.slidesStatus,
                viewModel.newsStatus,
                viewModel.testimonialsStatus
            )
        })

        viewModel.homeStatusLiveDataMerger.addSource(viewModel.newsStatus, Observer {
            viewModel.homeStatusLiveDataMerger.value = viewModel.combineHomeStatusData(
                viewModel.slidesStatus,
                viewModel.newsStatus,
                viewModel.testimonialsStatus
            )
        })

        viewModel.homeStatusLiveDataMerger.addSource(viewModel.testimonialsStatus, Observer {
            viewModel.homeStatusLiveDataMerger.value = viewModel.combineHomeStatusData(
                viewModel.slidesStatus,
                viewModel.newsStatus,
                viewModel.testimonialsStatus
            )
        })
    }

    private fun undoStatusLiveDataMerger(viewModel: HomeViewModel) {
        viewModel.homeStatusLiveDataMerger.removeSource(viewModel.slidesStatus)
        viewModel.homeStatusLiveDataMerger.removeSource(viewModel.newsStatus)
        viewModel.homeStatusLiveDataMerger.removeSource(viewModel.testimonialsStatus)
    }

    private fun homeIsLoading(loading: Boolean, binding: FragmentHomeBinding) {
        if (loading) {
            binding.progressBar1.visibility = View.VISIBLE
            binding.rvSlides.visibility = View.GONE
            binding.btnContact.visibility = View.GONE
            binding.tvNews.visibility = View.GONE
            binding.vpNews.visibility = View.GONE
            binding.btnWantToJoin.visibility = View.GONE
            binding.tvTestimonyTitle.visibility = View.GONE
            binding.rvTestimony.visibility = View.GONE
            binding.btnAddMyTestimonial.visibility = View.GONE
        } else {
            binding.progressBar1.visibility = View.GONE
            binding.rvSlides.visibility = View.VISIBLE
            binding.btnContact.visibility = View.VISIBLE
            binding.tvNews.visibility = View.VISIBLE
            binding.vpNews.visibility = View.VISIBLE
            binding.btnWantToJoin.visibility = View.VISIBLE
            binding.tvTestimonyTitle.visibility = View.VISIBLE
            binding.rvTestimony.visibility = View.VISIBLE
            binding.btnAddMyTestimonial.visibility = View.VISIBLE
        }
    }

    private fun showErrorDialog(viewModel: HomeViewModel) {
        val message = viewModel.messageCombineHomeStatusData(
            viewModel.slidesStatus,
            viewModel.newsStatus,
            viewModel.testimonialsStatus
        )
        val bundle = Bundle()
        when {
            message.contains("slides") -> {
                bundle.putString("message", "slider_retrieve_error")
                analytics.logEvent("Slider", bundle)
            }
            message.contains("novedades") -> {
                bundle.putString("message", "last_news_retrieve_error")
                analytics.logEvent("News", bundle)
            }
            message.contains("testimonios") -> {
                bundle.putString("message", "testimonies_retrieve_error")
                analytics.logEvent("Testimonials", bundle)
            }
        }
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Error")
            .setMessage(
                message
            )
            .setPositiveButton("Reintentar") { _, _ -> viewModel.retryFailedHomeSections() }
            .show()
    }

}