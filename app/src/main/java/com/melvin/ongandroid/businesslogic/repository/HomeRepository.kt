package com.melvin.ongandroid.businesslogic.repository

import com.melvin.ongandroid.model.APIServices
<<<<<<< HEAD
import com.melvin.ongandroid.model.data.slides.SlidesList
import com.melvin.ongandroid.model.data.testimonials.TestimonialsList
import javax.inject.Inject
import javax.inject.Singleton
=======
import com.melvin.ongandroid.model.data.HomeSlides
import com.melvin.ongandroid.model.data.News
import com.melvin.ongandroid.model.data.Testimonials
>>>>>>> f06885f (News added: fragment, adapter, view, and service)

@Singleton
class HomeRepository @Inject constructor(private val APIService: APIServices) {

 //Calls APIservice getHomeSlides suspend function
    suspend fun getHomeSlides() : SlidesList {
        return APIService.getHomeSlides()
    }

    //Calls APIservice getTestimonials function
    suspend fun getTestimonials(): TestimonialsList {
        return APIService.getTestimonials()
    }

<<<<<<< HEAD
=======
    suspend fun getNews() : News{
        return APIService.getNews()
    }
>>>>>>> f06885f (News added: fragment, adapter, view, and service)
}