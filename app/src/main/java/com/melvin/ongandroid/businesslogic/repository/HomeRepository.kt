package com.melvin.ongandroid.businesslogic.repository

import com.melvin.ongandroid.model.APIServices
import com.melvin.ongandroid.model.data.HomeSlides
import com.melvin.ongandroid.model.data.Testimonials
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepository @Inject constructor(private val APIService: APIServices) {

    //Calls APIservice getHomeSlides suspend function
    suspend fun getHomeSlides(): HomeSlides {
        return APIService.getHomeSlides()
    }

    //Calls APIservice getTestimonials suspend function
    suspend fun getTestimonials(): Testimonials {
        return APIService.getTestimonials()
    }

}