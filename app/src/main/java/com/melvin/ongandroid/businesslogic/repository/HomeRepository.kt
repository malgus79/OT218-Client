package com.melvin.ongandroid.businesslogic.repository

import com.melvin.ongandroid.model.data.activities.ActivitiesList
import com.melvin.ongandroid.model.data.news.NewsList
import com.melvin.ongandroid.model.data.slides.SlidesList
import com.melvin.ongandroid.model.data.testimonials.TestimonialsList
import com.melvin.ongandroid.model.network.APIServices
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepository @Inject constructor(private val APIService: APIServices) {

    //Calls APIServices getHomeSlides suspend function
    suspend fun getHomeSlides(): SlidesList {
        return APIService.getHomeSlides()
    }

    //Calls APIServices getTestimonials function
    suspend fun getTestimonials(): TestimonialsList {
        return APIService.getTestimonials()
    }

    //Calls APIServices getNews function
    suspend fun getNews(): NewsList {
        return APIService.getNews()
    }

    //Calls APIservices getActivites function
    
    suspend fun getActivities(): ActivitiesList{
        return APIService.getActivities()
}