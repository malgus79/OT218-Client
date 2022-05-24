package com.melvin.ongandroid.businesslogic.repository

import com.melvin.ongandroid.model.APIServices
import com.melvin.ongandroid.model.data.HomeSlides
import com.melvin.ongandroid.model.data.News
import com.melvin.ongandroid.model.data.Testimonials

class HomeRepository(private val APIService: APIServices) {

    suspend fun getHomeSlides() : HomeSlides{
        return APIService.getHomeSlides()
    }

    //Calls APIservice getTestimonials suspend function
    suspend fun getTestimonials(): Testimonials{
        return APIService.getTestimonials()
    }

    suspend fun getNews() : News{
        return APIService.getNews()
    }
}