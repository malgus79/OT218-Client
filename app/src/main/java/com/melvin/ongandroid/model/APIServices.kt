package com.melvin.ongandroid.model

import com.melvin.ongandroid.model.data.HomeSlides
import com.melvin.ongandroid.model.data.Testimonials
import retrofit2.http.GET

interface APIServices {

    //This endpoint returns a list of Slides
    @GET("api/slides")
    suspend fun getHomeSlides(): HomeSlides


    //This endpoint returns a list of Testimony
    @GET("api/testimonials")
    suspend fun getTestimonials(): Testimonials


}