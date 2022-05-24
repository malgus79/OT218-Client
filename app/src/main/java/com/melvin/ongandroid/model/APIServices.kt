package com.melvin.ongandroid.model

import com.melvin.ongandroid.model.data.HomeSlides
import com.melvin.ongandroid.model.data.News
import com.melvin.ongandroid.model.data.Testimonials
import retrofit2.http.GET

interface APIServices {

    @GET("api/slides")
    suspend fun getHomeSlides(): HomeSlides


    //This endpoint returns a list of Testimony
    @GET("api/testimonials")
    suspend fun getTestimonials(): Testimonials

    @GET("api/news")
    suspend fun getNews(): News

}