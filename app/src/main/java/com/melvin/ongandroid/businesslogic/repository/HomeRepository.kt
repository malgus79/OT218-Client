package com.melvin.ongandroid.businesslogic.repository

import com.melvin.ongandroid.model.APIServices
import com.melvin.ongandroid.model.data.slides.SlidesList
import com.melvin.ongandroid.model.data.testimonials.TestimonialsList

class HomeRepository(private val APIService: APIServices) {

    suspend fun getHomeSlides() : SlidesList {
        return APIService.getHomeSlides()
    }

    //Calls APIservice getTestimonials function
    suspend fun getTestimonials(): TestimonialsList {
        return APIService.getTestimonials()
    }
}