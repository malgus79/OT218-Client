package com.melvin.ongandroid.businesslogic.repository

import com.melvin.ongandroid.model.network.APIServices
import com.melvin.ongandroid.model.data.news.NewsList
import com.melvin.ongandroid.model.data.slides.SlidesList
import com.melvin.ongandroid.model.data.testimonials.TestimonialsList
import javax.inject.Inject
import javax.inject.Singleton


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

    //Calls APIService getNews function
    suspend fun getNews(): NewsList {
        return APIService.getNews()
    }
}